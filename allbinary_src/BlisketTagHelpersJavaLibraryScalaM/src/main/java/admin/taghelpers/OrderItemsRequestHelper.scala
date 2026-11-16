/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderData
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData
import _root_.org.allbinary.business.user.commerce.shipping.ShippingMethodData
import _root_.org.allbinary.data.tables.user.commerce.inventory.order.OrderItemsEntityFactory
import _root_.org.allbinary.logic.communication.log.LogUtil

class OrderItemsRequestHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends TagHelper {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var request : HttpServletRequest = null

    private var id : String = null

    private var groupId : String = null

    private var status : String = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        this.request = pageContext.getRequest().asInstanceOf[HttpServletRequest]
        this.getFormData()
    }

    private def getFormData() : Unit = {
        this.id = this.request.getParameter(OrderData.ID)
        this.groupId = this.request.getParameter(ShippingMethodData.GROUP)
        this.status = this.request.getParameter(OrderHistoryData.STATUS)
    }

    def setOrderStatus(param_newStatus : String) : String = {
        var newStatus : String = param_newStatus
        try {
            if (newStatus == null) {
                newStatus = this.status
            }
            var success : String = "Status successfully set to: " + newStatus
            OrderItemsEntityFactory.getInstance().setStatus(this.id, this.groupId, newStatus)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "setOrderStatus(newStatus)")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to view order table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "setOrderStatus(newStatus)", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def setOrderStatus() : String = {
        try {
            var success : String = "Status successfully set to: " + this.status
            OrderItemsEntityFactory.getInstance().setStatus(this.id, this.groupId, this.status)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "setOrderStatus(newStatus)")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to view order table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "setOrderStatus(newStatus)", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

}


