/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.inventory

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.commerce.inventory.InventoryData
import _root_.org.allbinary.business.user.commerce.inventory.basket.BasketData
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemView
import _root_.org.allbinary.business.user.commerce.inventory.item.ItemInterface
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.InventoryEntity
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.InventoryEntityFactory
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.search.SearchData
import _root_.org.allbinary.logic.control.search.SearchParams
import _root_.org.allbinary.logic.control.search.SearchRequest
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.string.regex.replace.Replace
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.visual.transform.StoreTransformer
import _root_.org.allbinary.logic.visual.transform.data.TransformDocumentInterface
import _root_.org.allbinary.logic.visual.transform.data.TransformStoreDocumentFactory
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpSearch
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

/**  *  * @author user  */
class InventorySearchUtil {
    import _root_.views.generic.inventory.InventorySearchUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val commonPhoneStrings : CommonPhoneStrings = CommonPhoneStrings.getInstance()

    val basicItemData : BasicItemData = BasicItemData.getInstance()

    //private final String STORING_CURRENT_PAGE = "Storing Doc: CurrentPage: ";
    def getBasicItemIdColumn(searchRequest : SearchRequest) : BasicArrayList = {
        var inventoryEntityInterface : InventoryEntity = InventoryEntityFactory.getInstance().getInventoryEntityInstance()
        var storeFrontInterface : StoreFrontInterface = searchRequest.getStoreFront()
        var inventorySearchUtil : InventoryColumnUtil = InventoryColumnUtil.getInstance()
        var column : BasicArrayList = inventorySearchUtil.getColumnWhereLike(inventoryEntityInterface, storeFrontInterface.getCategoryPath(), basicItemData.ID)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PRODUCTSEARCHLOGGING)) {
            this.logUtil.putF("Number Of Items Found: " + column.size(), this, "search")
        }
        var subStoreVector : BasicArrayList = storeFrontInterface.getSubStores()
        var size : Int = subStoreVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var subStore : String = subStoreVector.get(index).asInstanceOf[String]
                var substoreIdColumn : BasicArrayList = inventorySearchUtil.getColumnWhereLike(inventoryEntityInterface, subStore, basicItemData.ID)
                column.addAllList(substoreIdColumn)
                index += 1
            }
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PRODUCTSEARCHLOGGING)) {
            this.logUtil.putF("Number Of Items Found Including SubStores: " + column.size(), this, "search")
        }
        return column
    }

    private def getNoResults(viewDocumentInterface : TransformDocumentInterface, inventoryNode : Node) : String = {
        inventoryNode.appendChild(ModDomHelper.createNameValueNodes(viewDocumentInterface.getDoc(), SearchData.TOTAL_NUMBER_PAGES, this.commonPhoneStrings.ZERO))
        inventoryNode.appendChild(ModDomHelper.createNameValueNodes(viewDocumentInterface.getDoc(), SearchData.TOTAL_NUMBER_ITEMS, this.commonPhoneStrings.ZERO))
        var success : String = XmlDocumentHelper.toString(viewDocumentInterface.getDoc())
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PRODUCTSEARCHLOGGING)) {
            this.logUtil.putF("No Results Xml: " + success, this, "search")
        }
        return success
    }

    def search(abeClientInformation : AbeClientInformationInterface, searchRequest : SearchRequest, column : BasicArrayList) : Array[String] = {
        try {
            var inventoryEntityInterface : InventoryEntity = InventoryEntityFactory.getInstance().getInventoryEntityInstance()
            var searchParams : SearchParams = searchRequest.getParams()
            var startPage : Int = searchParams.getStartPageInt().intValue()
            var endPage : Int = searchParams.getEndPageInt().intValue()
            var pageLength : Int = searchParams.getLengthInt().intValue()
            var savedPagesInRange : Int = 0
            //this.searchRequest.getKeywords()
            var columnValueHashMap : HashMap[Object, Object] = searchParams.get().asInstanceOf[HashMap[Object, Object]]
            var keyword : String = new Replace("-", CommonSeps.getInstance().SPACE).all(columnValueHashMap.get(basicItemData.KEYWORDS).asInstanceOf[String])
            if (StringValidationUtil.getInstance().isEmpty(keyword)) {
                return null
            }
            var stringBuffer : StringMaker = new StringMaker()
            /*             if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(                 org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().PRODUCTSEARCHLOGGING))             {              stringBuffer.append(KEYWORD);                 stringBuffer.append(keyword);                 stringBuffer.append(START_PAGE);                 stringBuffer.append(startPage);                 stringBuffer.append(END_PAGE);                 stringBuffer.append(endPage);                 stringBuffer.append(PAGE_LENGTH);                 stringBuffer.append(pageLength);                  this.logUtil.putF(stringBuffer.toString(), this, "search");             }             */
            if (startPage >= 0) {
                if (pageLength == 0) {
                    pageLength = SearchData.DEFAULT_PAGE_LENGTH
                }
                val MAXPAGES : Int = 100
                val productListingPages : Array[String] = new Array[String](MAXPAGES)
                val documents : Array[Document] = new Array[Document](MAXPAGES)
                val inventoryNodes : Array[Node] = new Array[Node](MAXPAGES)
                keyword = keyword.toUpperCase()
                var lastPage : Int = -1
                var numberOfResultsOnCurrentPage : Int = 0
                var numberOfResults : Int = 0
                //then start new document
                var viewDocumentInterface : TransformDocumentInterface = TransformStoreDocumentFactory.getInstance(searchRequest)
                var inventoryNode : Node = viewDocumentInterface.getDoc().createElement(InventoryData.INVENTORY)
                viewDocumentInterface.getBaseNode().appendChild(inventoryNode)
                inventoryNode.appendChild(ModDomHelper.createNameValueNodes(viewDocumentInterface.getDoc(), SearchData.PAGE, new Integer(startPage).toString()))
                if (searchRequest.getFileBaseName() != null) {
                    inventoryNode.appendChild(searchRequest.getFileBaseNameNode(viewDocumentInterface.getDoc()))
                }
                /*                 if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(                     org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().PRODUCTSEARCHLOGGING))                 {                     this.logUtil.putF("Initial Document Created", this, "search");                 }                 */
                var currentPage : Int = -1
                val size : Int = column.size()

                {
                    var index : Int = 0
                    scala.util.boundary { (break_N80087 : scala.util.boundary.Label[Unit]) ?=>
                        while (index < size) {
                            var product : String = new String(column.get(index).asInstanceOf[String])
                            var itemInterface : ItemInterface = inventoryEntityInterface.getItem(product)
                            var keywords : String = itemInterface.getKeywords()
                            keywords = keywords.toUpperCase()
                            /*                     if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(                         org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().PRODUCTSEARCHLOGGING))                     {                         stringBuffer.delete(0, stringBuffer.length());                          stringBuffer.append(KEYWORD_ANALYSIS);                         stringBuffer.append(keyword);                         stringBuffer.append(WITH);                         stringBuffer.append(keywords);                          this.logUtil.putF(stringBuffer.toString(), this, "search");                     }                     */
                            if (keywords.indexOf(keyword) != -1) {
                                //only create document item if item is on a requested page
                                if (((currentPage + 1) >= startPage) && ((currentPage + 1) <= endPage)) {
                                    var itemNode : Node = new BasicItemView(itemInterface, new BasicArrayListD()).toXmlNode(viewDocumentInterface.getDoc())
                                    itemNode.appendChild(ModDomHelper.createNameValueNodes(viewDocumentInterface.getDoc(), BasketData.ITEMTOTALINBASKET, this.commonPhoneStrings.ONE))
                                    inventoryNode.appendChild(itemNode.cloneNode(true))
                                }
                                currentPage = ((numberOfResults + 1) / pageLength) - 1
                                numberOfResultsOnCurrentPage += 1
                                /*                         if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(                             org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().PRODUCTSEARCHLOGGING))                         {                             stringBuffer.delete(0, stringBuffer.length());                              stringBuffer.append("current: ");                             stringBuffer.append(currentPage);                             stringBuffer.append(" num: ");                             stringBuffer.append(numberOfResults);                             stringBuffer.append(" last: ");                             stringBuffer.append(lastPage);                              this.logUtil.putF(stringBuffer.toString(), this, "search");                         }                         */
                                if (lastPage < currentPage) {
                                    if ((currentPage >= startPage) && (currentPage <= endPage)) {
                                        /*                                 if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(                                     org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().PRODUCTSEARCHLOGGING))                                 {                                     stringBuffer.delete(0, stringBuffer.length());                                      stringBuffer.append(STORING_CURRENT_PAGE);                                     stringBuffer.append(currentPage);                                     stringBuffer.append(START_PAGE);                                     stringBuffer.append(startPage);                                     stringBuffer.append(END_PAGE);                                     stringBuffer.append(endPage);                                     //stringBuffer.append(XML_COLON);                                     //stringBuffer.append(XmlDocumentHelper.toString(viewDocumentInterface.getDoc()));                                      this.logUtil.putF(stringBuffer.toString(), this, "search");                                 }                                 */
                                        inventoryNode.appendChild(ModDomHelper.createNameValueNodes(viewDocumentInterface.getDoc(), SearchData.TOTAL_NUMBER_ITEMS_ON_THIS_PAGE, new Integer(numberOfResultsOnCurrentPage).toString()))
                                        //save current page result
                                        documents(currentPage) = viewDocumentInterface.getDoc()
                                        inventoryNodes(currentPage) = inventoryNode
                                        savedPagesInRange += 1
                                        //then start new document
                                        viewDocumentInterface = TransformStoreDocumentFactory.getInstance(searchRequest)
                                        inventoryNode = viewDocumentInterface.getDoc().createElement(InventoryData.INVENTORY)
                                        viewDocumentInterface.getBaseNode().appendChild(inventoryNode)
                                        inventoryNode.appendChild(ModDomHelper.createNameValueNodes(viewDocumentInterface.getDoc(), SearchData.PAGE, new Integer(currentPage + 1).toString()))
                                        if (searchRequest.getFileBaseName() != null) {
                                            inventoryNode.appendChild(searchRequest.getFileBaseNameNode(viewDocumentInterface.getDoc()))
                                        }
                                    }
                                    lastPage = currentPage
                                    numberOfResultsOnCurrentPage = 0
                                }
                                numberOfResults += 1
                                if (lastPage >= (MAXPAGES - 1)) {
                                    scala.util.boundary.break()(using break_N80087)
                                }
                            }
                            index += 1
                        }
                    }
                }
                //Store last page if it exists
                if ((numberOfResultsOnCurrentPage > 0) && (((currentPage + 1) >= startPage) && ((currentPage + 1) <= endPage))) {
                    //save current page result
                    inventoryNode.appendChild(ModDomHelper.createNameValueNodes(viewDocumentInterface.getDoc(), SearchData.TOTAL_NUMBER_ITEMS_ON_THIS_PAGE, new Integer(numberOfResultsOnCurrentPage - 1).toString()))
                    documents(lastPage + 1) = viewDocumentInterface.getDoc()
                    inventoryNodes(lastPage + 1) = inventoryNode
                    savedPagesInRange += 1
                }
                if (numberOfResultsOnCurrentPage > 0) {
                    lastPage += 1
                }
                //and add totals
                if (endPage > (MAXPAGES - 1)) {
                    endPage = MAXPAGES - 1
                }

                {
                    var index : Int = startPage
                    while (index <= endPage) {
                        if (index <= lastPage) {
                            var tempDocument : Document = documents(index)
                            /*                         if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(                             org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().PRODUCTSEARCHLOGGING))                         {                             stringBuffer.delete(0, stringBuffer.length());                              stringBuffer.append("Translating Doc: ");                             stringBuffer.append(index);                             stringBuffer.append(XML_COLON);                             stringBuffer.append(XmlDocumentHelper.toString(tempDocument));                              this.logUtil.putF(stringBuffer.toString(), this, "search");                         }                         */
                            inventoryNodes(index).appendChild(ModDomHelper.createNameValueNodes(tempDocument, SearchData.TOTAL_NUMBER_PAGES, new Integer(lastPage + 1).toString()))
                            inventoryNodes(index).appendChild(ModDomHelper.createNameValueNodes(tempDocument, SearchData.TOTAL_NUMBER_ITEMS, new Integer(numberOfResults).toString()))
                            //add Page Numbers

                            {
                                var pageIndex : Int = 0
                                while (pageIndex <= lastPage) {
                                    stringBuffer.delete(0, stringBuffer.length())
                                    //Add file name
                                    stringBuffer.append(searchRequest.getFileBaseName())
                                    if (stringBuffer.length() > 0) {
                                        if (pageIndex != 0) {
                                            stringBuffer.append(Integer.toString(pageIndex))
                                        }
                                        inventoryNodes(index).appendChild(ModDomHelper.createNameValueNodes(tempDocument, SearchData.PAGE_INFO, Integer.toString(pageIndex), stringBuffer.toString()))
                                    } else {
                                        inventoryNodes(index).appendChild(ModDomHelper.createNameValueNodes(tempDocument, SearchData.PAGE_INFO, Integer.toString(pageIndex), SearchData.SEARCH))
                                    }
                                    pageIndex += 1
                                }
                            }
                            var success : String = XmlDocumentHelper.toString(tempDocument)
                            /*                         if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(                             org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().PRODUCTSEARCHLOGGING))                         {                             stringBuffer.delete(0, stringBuffer.length());                              stringBuffer.append("Inventory Page: ");                             stringBuffer.append(index);                             stringBuffer.append(XML_COLON);                             stringBuffer.append(success);                              this.logUtil.putF(stringBuffer.toString(), this, "search");                         }                         */
                            productListingPages(index) = new StoreTransformer(abeClientInformation, (new TransformInfoHttpSearch(searchRequest)).asInstanceOf[TransformInfoInterface]).translate(success)
                        }
                        index += 1
                    }
                }
                //This should not occur during static page generation
                if (savedPagesInRange == 0) {
                    var result : String = this.getNoResults(viewDocumentInterface, inventoryNode)
                    productListingPages(0) = new StoreTransformer(abeClientInformation, new TransformInfoHttpSearch(searchRequest)).translate(result)
                }
                return productListingPages
            } else {
                return null
            }
        } catch {
            case breakException: scala.util.boundary.Break[?] => throw breakException
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PRODUCTSEARCHLOGGINGERROR)) {
                    this.logUtil.put(this.commonStrings.FAILURE, this, "search", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}

object InventorySearchUtil {
    private val instance : InventorySearchUtil = new InventorySearchUtil()

    /**      * @return the instance      */
    def getInstance() : InventorySearchUtil = {
        return InventorySearchUtil.instance
    }

}


