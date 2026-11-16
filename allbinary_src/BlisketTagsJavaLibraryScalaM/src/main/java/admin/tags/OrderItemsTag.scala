/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.java.lang.reflect.Method
import _root_.javax.servlet.jsp.JspTagException
import _root_.admin.taghelpers.OrderItemsHelperFactory
import _root_.admin.taghelpers.OrderItemsRequestHelperFactory
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.LicensingException

class OrderItemsTag() extends TableTag {

    val logUtil_OrderItemsTag : LogUtil = LogUtil.getInstance()

    private var status : String = null

    //Constructor
    {
        this.setTagHelperFactory(new OrderItemsHelperFactory())
        this.setTagRequestHelperFactory(new OrderItemsRequestHelperFactory())
    }

    def setStatus(value : String) : Unit = {
        this.status = value
    }

    private def setOrderStatus() : String = {
        try {
            var anyType : Object = new OrderItemsRequestHelperFactory().getInstance(this.getPropertiesHashMap(), this.pageContext)
            if (this.status == null) {
                var helperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
                var method : Method = helperClass.getMethod("setOrderStatus", null)
                var result : String = method.invoke(anyType, null).asInstanceOf[String]
                return result
            } else {
                var helperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
                var methodParams : Array[Class[?]] = Array[Class[?]](this.status.getClass())
                var method : Method = helperClass.getMethod("setOrderStatus", methodParams*)
                var methodArgs : Array[Object] = Array[Object](this.status)
                var result : String = method.invoke(anyType, methodArgs*).asInstanceOf[String]
                return result
            }
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to set Order status to: " + this.status
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_OrderItemsTag.put(this.commonStrings.EXCEPTION, this, "setOrderStatus()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def doStartTag() : Int = {
        try {
            if (this.isEnabled()) {
                if (this.getCommand() != null) {
                    this.getPropertiesHashMap().put(OrderHistoryData.STATUS, this.status)
                    if (this.getCommand().compareTo(OrderHistoryData.SETSTATUS) == 0) {
                        this.pageContext.getOut().print(this.setOrderStatus())
                    } else {
                        return super.doStartTag()
                    }
                }
            }
            return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
        } catch {
            case e : LicensingException => {
                AbResponseHandler.sendJspTagLicensingRedirect(this.pageContext, e)
                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
            }
            case e : Exception => {
                AbResponseHandler.sendJspTagRedirect(this.pageContext, e)
                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
            }
        }
        throw new IllegalStateException()
    }

}


