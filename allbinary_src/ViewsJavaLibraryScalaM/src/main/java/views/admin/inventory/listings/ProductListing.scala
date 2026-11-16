/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.inventory.listings

import _root_.java.util.HashMap
import _root_.java.util.HashSet
import _root_.java.util.Set
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
import _root_.org.allbinary.data.tables.context.module.storefronts.StoreFrontsEntity
import _root_.org.allbinary.data.tables.staticpages.StaticPagesEntity
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.InventoryEntity
import _root_.org.allbinary.globals.GLOBALS2
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.search.SearchParams
import _root_.org.allbinary.logic.control.search.SearchRequest
import _root_.org.allbinary.logic.io.AbDataOutputStream
import _root_.org.allbinary.logic.io.DataOutputStreamFactory
import _root_.org.allbinary.logic.io.InputOutputTypeData
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.directory.Directory
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.SpecialCharacterUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.regex.replace.Replace
import _root_.org.allbinary.logic.string.tokens.UniqueTokens
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory
import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.util.BasicArrayList
import _root_.views.generic.inventory.InventoryColumnUtil
import _root_.views.generic.inventory.InventorySearchUtil

class ProductListing(param_searchRequest : SearchRequest) extends ProductListingInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val directory : Directory = Directory.getInstance()

    val basicItemData : BasicItemData = BasicItemData.getInstance()

    private var storeFronts : StoreFrontsEntity = null

    private var staticPages : StaticPagesEntity = null

    private var inventory : InventoryEntity = null

    private var searchRequest : SearchRequest = null

    private val INVENTORY : String = ".InventoryView"

    //Constructor
    {
        val searchRequest : SearchRequest = param_searchRequest
        this.searchRequest = searchRequest
        this.storeFronts = new StoreFrontsEntity()
        this.staticPages = new StaticPagesEntity()
        this.inventory = new InventoryEntity()
    }

    final private def getHashSet(storeFront : StoreFrontInterface) : HashSet[Object] = {
        var inventoryColumnUtil : InventoryColumnUtil = InventoryColumnUtil.getInstance()
        var keywords : BasicArrayList = inventoryColumnUtil.getColumnWhereLike(this.inventory, storeFront.getCategoryPath(), basicItemData.KEYWORDS)
        var subStoreVector : BasicArrayList = storeFront.getSubStores()
        var size : Int = subStoreVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var subStore : String = subStoreVector.get(index).asInstanceOf[String]
                //AbSqlData.ANYSINGLECHARACTERMATCH
                var substoreKeywords : BasicArrayList = inventoryColumnUtil.getColumnWhereLike(this.inventory, AbPathData.getInstance().SEPARATOR + subStore, basicItemData.CATEGORY)
                keywords.addAllList(substoreKeywords)
                index += 1
            }
        }
        //}
        var uniqueTokens : UniqueTokens = new UniqueTokens()
        var keywordHashSet : HashSet[Object] = uniqueTokens.getWhithoutDashesAndSkipNumberOnlyTokens(keywords).asInstanceOf[HashSet[Object]]
        return keywordHashSet
    }

    private def savePage(file : String, data : String) : Unit = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().STATICPAGEGENERATIONLOGGING)) {
            //Creates a new File
            this.logUtil.putF("Creating File: " + file, this, "generateAll()")
        }
        var newFile : AbFile = AbFile.createAbFile(file)
        if (newFile.exists()) {
            newFile.delete()
        }
        newFile.createNewFile()
        if (newFile.exists()) {
            var idOutData : AbDataOutputStream = DataOutputStreamFactory.getInstance().getInstanceForAbFile(newFile)
            idOutData.writeBytes(data)
            idOutData.flush()
            StreamUtil.getInstance().close(idOutData)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().STATICPAGEGENERATIONLOGGING)) {
                this.logUtil.putF("Wrote Total Bytes: " + newFile.length(), this, "generateAll()")
            }
        } else {
            throw new Exception("Could Not Create: " + file)
        }
    }

    private def create(keywordData : String, keywordFilenameHashMap : HashMap[Object, Object], vector : BasicArrayList, staticPath : AbPath) : Unit = {
        var stringBuffer : StringMaker = new StringMaker()
        var hashMap : HashMap[Object, Object] = SpecialCharacterUtil.getHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(CommonSeps.getInstance().SPACE, StringUtil.getInstance().EMPTY_STRING)
        var pageName : String = new Replace(hashMap).all(keywordData)
        //add keywords to search params
        var searchParams : SearchParams = this.searchRequest.getParams()
        searchParams.add(basicItemData.KEYWORDS, keywordData)
        searchParams.setStartPage(CommonPhoneStrings.getInstance().ZERO)
        this.searchRequest.setParams(searchParams)
        this.searchRequest.setFileBaseName(pageName)
        //  InventoryViewFactory.getInstance(this.searchRequest);
        val abeClientInformation : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()
        val inventorySearchUtil : InventorySearchUtil = InventorySearchUtil.getInstance()
        //creates a listing from the created search data ^
        var productListingPages : Array[String] = inventorySearchUtil.search(abeClientInformation, searchRequest, vector)

        {
            var index : Int = 0
            scala.util.boundary { (break_N81941 : scala.util.boundary.Label[Unit]) ?=>
                while (index < productListingPages.length) {
                    if (productListingPages(index) == null) {
                        scala.util.boundary.break()(using break_N81941)
                    }
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().STATICPAGEGENERATIONLOGGING)) {
                        this.logUtil.putF("Saving Listing: " + index, this, "generateAll()")
                    }
                    var indexStr : String = StringUtil.getInstance().EMPTY_STRING
                    if (index > 0) {
                        indexStr = new Integer(index).toString()
                    }
                    keywordFilenameHashMap.put(keywordData, pageName + indexStr)
                    stringBuffer.delete(0, stringBuffer.length())
                    stringBuffer.append(staticPath.toString())
                    stringBuffer.append(pageName)
                    stringBuffer.append(indexStr)
                    stringBuffer.append(AbPathData.getInstance().EXTENSION_SEP)
                    stringBuffer.append(InputOutputTypeData.getInstance().DEFAULT)
                    var file : String = stringBuffer.toString()
                    //Create Directories
                    if (!this.directory.create(staticPath)) {
                        throw new Exception("Could Not Create Directory: " + staticPath)
                    }
                    this.savePage(file, productListingPages(index))
                    index += 1
                }
            }
        }
    }

    private def addStaticPageInfoToDatabase(storeFront : StoreFrontInterface, keywordFilenameHashMap : HashMap[Object, Object]) : Unit = {
        //add to Static info to staticpages db
        var keywordHashSet : Set[Object] = keywordFilenameHashMap.keySet().asInstanceOf[Set[Object]]
        val keywordArray : Array[Object] = keywordHashSet.toArray()
        val size : Int = keywordArray.length

        {
            var index : Int = 0
            while (index < size) {
                var insertVector : BasicArrayList = new BasicArrayListD()
                var keywordData : String = keywordArray(index).asInstanceOf[String]
                var fileName : String = keywordFilenameHashMap.get(keywordData).asInstanceOf[String]
                insertVector.add(storeFront.getName())
                insertVector.add(keywordData)
                insertVector.add(fileName)
                this.staticPages.insert(insertVector)
                index += 1
            }
        }
    }

    def generateAll() : String = {
        try {
            val storeFront : StoreFrontInterface = this.searchRequest.getStoreFront()
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(URLGLOBALS.getWebappPath())
            stringBuffer.append(storeFront.getName())
            stringBuffer.append(AbPathData.getInstance().SEPARATOR)
            stringBuffer.append(storeFront.getStaticPath())
            //+ storeFront.getTestHtmlPath() + storeFront.getStaticPath()
            val staticPath : AbPath = new AbPath(stringBuffer.toString(), StringUtil.getInstance().EMPTY_STRING)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().STATICPAGEGENERATIONLOGGING)) {
                this.logUtil.putF("Store Static Pages Path: " + staticPath, this, "generateAll()")
            }
            //compile a list of possible keywords
            val keywordHashSet : HashSet[Object] = this.getHashSet(storeFront).asInstanceOf[HashSet[Object]]
            val keywordArray : Array[Object] = keywordHashSet.toArray()
            val size : Int = keywordArray.length
            //their associated Static page filenames
            var keywordFilenameHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            if (size == 0) {
                stringBuffer.delete(0, stringBuffer.length())
                stringBuffer.append("Products For ")
                stringBuffer.append(storeFront.getName())
                stringBuffer.append(" Store Not Found")
                return stringBuffer.toString()
            }
            val inventorySearchUtil : InventorySearchUtil = InventorySearchUtil.getInstance()
            val vector : BasicArrayList = inventorySearchUtil.getBasicItemIdColumn(this.searchRequest)

            {
                var index : Int = 0
                while (index < size) {
                    var keywordData : String = keywordArray(index).asInstanceOf[String]
                    if (keywordData.length() > 1) {
                        this.create(keywordData, keywordFilenameHashMap, vector, staticPath)
                    }
                    index += 1
                }
            }
            this.addStaticPageInfoToDatabase(storeFront, keywordFilenameHashMap)
            stringBuffer.delete(0, stringBuffer.length())
            stringBuffer.append("Static Files Generated Successfully For ")
            stringBuffer.append(storeFront.getName())
            stringBuffer.append(" it used packages ")
            stringBuffer.append(storeFront.getPackageLocation())
            stringBuffer.append(this.INVENTORY)
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def generateAll(param_storeName : String) : String = {
        var storeName : String = param_storeName
        try {
            var stringBuffer : StringMaker = new StringMaker()
            if (storeName != null) {
                if (storeName.compareTo(GLOBALS2.GENERATEALLSTORES) != 0) {
                    this.searchRequest.setStoreFront(this.storeFronts.getStoreFrontInterface(storeName))
                    // result = temp + "<br>";
                    stringBuffer.append(this.generateAll())
                    stringBuffer.append("<br />")
                } else {
                    var storeFrontVector : BasicArrayList = this.storeFronts.getStoreFrontNames()
                    val size : Int = storeFrontVector.size()

                    {
                        var index : Int = 0
                        while (index < size) {
                            storeName = storeFrontVector.get(index).asInstanceOf[String]
                            this.searchRequest.setStoreFront(this.storeFronts.getStoreFrontInterface(storeName))
                            // result += temp + "<br>";
                            stringBuffer.append(this.generateAll())
                            stringBuffer.append("<br />")
                            index += 1
                        }
                    }
                }
            } else {
                return "Generation Failed No Store Specified<br/>"
            }
            stringBuffer.append("All Static Pages Generated<br/>")
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


