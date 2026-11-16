/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.admin.taghelpers.TagHelper
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.address.StreetAddress
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderData
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryFactory
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryInterface
import _root_.org.allbinary.business.user.commerce.shipping.ShippingMethodData
import _root_.org.allbinary.data.tables.user.commerce.inventory.order.OrderHistoryEntityFactory
import _root_.org.allbinary.data.tables.user.commerce.inventory.order.OrderHistoryEntityInterface
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.communication.log.LogUtil

class OrderHistoryHelper(param_propertiesHashMap : HashMap[Object, Object], param_pageContext : PageContext) extends TagHelper {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var weblisketSession : WeblisketSession = null

    private var storeFrontInterface : StoreFrontInterface = null

    private var propertiesHashMap : HashMap[Object, Object] = null

    private var pageContext : PageContext = null

    private var request : HttpServletRequest = null

    private var streetAddress : StreetAddress = null

    private var id : String = null

    private var groupId : String = null

    private var status : String = null

    private var newStatus : String = null

    //Constructor
    {
        val propertiesHashMap : HashMap[Object, Object] = param_propertiesHashMap
        val pageContext : PageContext = param_pageContext
        this.propertiesHashMap = propertiesHashMap
        this.pageContext = pageContext
        this.request = pageContext.getRequest().asInstanceOf[HttpServletRequest]
        var storeName : String = propertiesHashMap.get(StoreFrontData.getInstance().NAME).asInstanceOf[String]
        this.newStatus = propertiesHashMap.get(OrderHistoryData.STATUS).asInstanceOf[String]
        if (storeName != null) {
            this.storeFrontInterface = StoreFrontFactory.getInstance(storeName)
        }
        this.getFormData()
    }

    private def getFormData() : Unit = {
        this.id = this.request.getParameter(OrderData.ID)
        this.groupId = this.request.getParameter(ShippingMethodData.GROUP)
        if (this.newStatus == null) {
            this.newStatus = this.request.getParameter(OrderHistoryData.STATUS)
        }
    }

    def setOrderStatus() : String = {
        try {
            var success : String = "Status successfully set to: " + this.status
            var orderReviewInterface : OrderHistoryInterface = OrderHistoryFactory.getInstance(this.id)
            var status : String = orderReviewInterface.getStatus()
            if (status.compareTo(OrderHistoryData.CANCELLED) == 0) {
                return ("Order " + this.id) + " Already Cancelled<br/>"
            } else if (status.compareTo(OrderHistoryData.SHIPPED) == 0) {
                return ("Order " + this.id) + " Already Shipped. You can't cancel a shipped order.<br/>"
            } else if (status.compareTo(OrderHistoryData.PREPROCESSING) == 0) {
                return ("Order " + this.id) + " has been cancelled.<br/>"
            } else if (status.compareTo(OrderHistoryData.PARTIALLYSHIPPED) == 0) {
                return ("Order " + this.id) + " Partially Shipped. You can cancel unshipped items, but not the whole order.<br/>"
            } else if (status.compareTo(OrderHistoryData.PROCESSING) == 0) {
                var orderHistoryEntityInterface : OrderHistoryEntityInterface = OrderHistoryEntityFactory.getInstance()
                orderHistoryEntityInterface.setStatus(this.id, this.newStatus)
                return ("Order " + this.id) + " has been cancelled.<br/>"
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "setOrderStatus()")
            }
            return "Error Setting Order Status"
        } catch {
            case e : Exception => {
                var error : String = "Failed to set order status"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "setOrderStatus()", e)
                }
                return (((error + "<br/>") + "Exception: ") + e) + "<br/>"
            }
        }
        throw new IllegalStateException()
    }

}


