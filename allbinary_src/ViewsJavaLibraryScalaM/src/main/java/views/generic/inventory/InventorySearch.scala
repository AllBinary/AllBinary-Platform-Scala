/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.inventory

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
import _root_.org.allbinary.data.tables.staticpages.StaticPagesEntity
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.search.SearchParams
import _root_.org.allbinary.logic.control.search.SearchRequest
import _root_.org.allbinary.logic.io.InputOutputTypeData
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.string.regex.replace.Replace
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.views.admin.inventory.listings.InventoryViewSearchInterface

/*  *This class updates the static page db table and generates/updates the html  *associated with each keyword filename pair listed in the static page db table  *when a client request a search this class returns a static page  */
class InventorySearch(param_searchRequest : SearchRequest) extends InventoryViewSearchInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    val basicItemData : BasicItemData = BasicItemData.getInstance()

    private var searchRequest : SearchRequest = null

    //Constructor
    {
        val searchRequest : SearchRequest = param_searchRequest
        this.searchRequest = searchRequest
    }

    /*This function searches the static pages db for a match*/
    def searchSingleStaticPage() : String = {
        try {
            var storeFront : StoreFrontInterface = this.searchRequest.getStoreFront()
            var searchParams : SearchParams = this.searchRequest.getParams()
            var columnValueHashMap : HashMap[Object, Object] = searchParams.get().asInstanceOf[HashMap[Object, Object]]
            var file : String = new StaticPagesEntity().getFile(storeFront.getName(), new Replace("-", CommonSeps.getInstance().SPACE).all(columnValueHashMap.get(basicItemData.KEYWORDS).asInstanceOf[String]))
            if (StringValidationUtil.getInstance().isEmpty(file)) {
                return null
            } else {
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append(storeFront.getCurrentHostName())
                stringBuffer.append(storeFront.getCurrentHostNamePath())
                stringBuffer.append(storeFront.getStaticPath())
                stringBuffer.append(file)
                stringBuffer.append(this.searchRequest.getParams().getEndPage())
                stringBuffer.append(AbPathData.getInstance().EXTENSION_SEP)
                stringBuffer.append(InputOutputTypeData.getInstance().DEFAULT)
                var filePath : String = new Replace(CommonSeps.getInstance().SPACE, "%20").all(stringBuffer.toString())
                return filePath
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PRODUCTSEARCHLOGGING)) {
                    this.logUtil.put(this.commonStrings.FAILURE, this, "searchSingleStaticPage", e)
                }
                throw new Exception("Failed retrieve Single Product Page Static")
            }
        }
        throw new IllegalStateException()
    }

    def searchSingleDynamicPage() : String = {
        try {
            var str : Array[String] = this.search()
            return str(this.searchRequest.getParams().getStartPageInt().intValue())
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PRODUCTSEARCHLOGGINGERROR)) {
                    this.logUtil.put(this.commonStrings.FAILURE, this, "searchSingleDynamicPage", e)
                }
                throw new Exception("Failed retrieve Single Product Page Dynamically")
            }
        }
        throw new IllegalStateException()
    }

    //Node contentTypeNode = document.createElement(this.searchRequest.getContentType());
    def search() : Array[String] = {
        val abeClientInformation : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()
        val inventorySearchUtil : InventorySearchUtil = InventorySearchUtil.getInstance()
        val vector : BasicArrayList = inventorySearchUtil.getBasicItemIdColumn(this.searchRequest)
        return inventorySearchUtil.search(abeClientInformation, searchRequest, vector)
    }

    def getProduct(product : String) : String = {
        val abeClientInformation : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()
        return InventorySearchProductUtil.getInstance().getProduct(abeClientInformation, this.searchRequest, product)
    }

}


