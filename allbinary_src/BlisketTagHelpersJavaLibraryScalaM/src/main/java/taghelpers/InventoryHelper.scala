/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.http.HttpServletResponse
import _root_.javax.servlet.jsp.PageContext
import _root_.admin.taghelpers.TagHelper
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.address.StreetAddress
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
import _root_.org.allbinary.logic.communication.http.AcceptableResponseGenerator
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.search.SearchParams
import _root_.org.allbinary.logic.control.search.SearchRequest
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoData
import _root_.views.admin.inventory.listings.InventoryViewFactory
import _root_.views.admin.inventory.listings.InventoryViewSearchInterface

class InventoryHelper(param_propertiesHashMap : HashMap[Object, Object], param_pageContext : PageContext) extends TagHelper {

    val logUtil : LogUtil = LogUtil.getInstance()

    val basicItemData : BasicItemData = BasicItemData.getInstance()

    private var weblisketSession : WeblisketSession = null

    private var response : HttpServletResponse = null

    private var request : HttpServletRequest = null

    private var streetAddress : StreetAddress = null

    private var id : String = null

    //private SearchParams searchParams;
    private var searchRequest : SearchRequest = null

    //Constructor
    {
        val propertiesHashMap : HashMap[Object, Object] = param_propertiesHashMap
        val pageContext : PageContext = param_pageContext
        this.response = pageContext.getResponse().asInstanceOf[HttpServletResponse]
        this.request = pageContext.getRequest().asInstanceOf[HttpServletRequest]
        var storeName : String = propertiesHashMap.get(StoreFrontData.getInstance().NAME).asInstanceOf[String]
        var xslFile : String = propertiesHashMap.get(TransformInfoData.getInstance().TEMPLATEFILENAME).asInstanceOf[String]
        if (storeName != null) {
            var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(storeName)
            var contentType : String = AcceptableResponseGenerator.getInstance().get(this.request)
            var searchParams : SearchParams = new SearchParams(this.request)
            this.searchRequest = new SearchRequest(storeFrontInterface, searchParams, xslFile, contentType, propertiesHashMap, pageContext)
        }
        this.getFormData()
    }

    private def getFormData() : Unit = {
        this.id = this.request.getParameter(basicItemData.ID)
    }

    def viewSummary() : String = {
        try {
            var inventoryViewSearchInterface : InventoryViewSearchInterface = InventoryViewFactory.getInstance(this.searchRequest)
            var result : String = inventoryViewSearchInterface.getProduct(this.id)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF("Successfull Inventory View Summary", this, "viewSummary()")
            }
            return result
        } catch {
            case e : Exception => {
                var error : String = "Failed to View Summary"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "viewSummary()", e)
                }
                return (((error + "<br>") + "Exception: ") + e) + "<br>"
            }
        }
        throw new IllegalStateException()
    }

    def search() : String = {
        try {
            val stringUtil : StringUtil = StringUtil.getInstance()
            var keywords : String = this.searchRequest.getParams().get().get(basicItemData.KEYWORDS).asInstanceOf[String]
            if ((keywords == null) || (keywords.compareTo(stringUtil.EMPTY_STRING) == 0)) {
                return "Please enter a keyword in the search field above the Search button."
            }
            var inventoryViewSearchInterface : InventoryViewSearchInterface = InventoryViewFactory.getInstance(this.searchRequest)
            //if(inventoryDomNodeInterface==null) 
            var result : String = inventoryViewSearchInterface.searchSingleDynamicPage()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF("Successful Inventory Dynamic Search", this, "searchSingleDynamicPage()")
            }
            return result
        } catch {
            case e : Exception => {
                var error : String = "Failed to search Inventory by keyword"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "searchSingleDynamicPage()", e)
                }
                return (((error + "<br>") + "Exception: ") + e) + "<br>"
            }
        }
        throw new IllegalStateException()
    }

}


