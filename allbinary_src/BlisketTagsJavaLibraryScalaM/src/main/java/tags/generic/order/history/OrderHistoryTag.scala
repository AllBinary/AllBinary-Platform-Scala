/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package tags.generic.order.history

import _root_.java.lang.reflect.Method
import _root_.javax.servlet.jsp.JspTagException
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.taghelpers.OrderHistoryHelperFactory
import _root_.tags.StoreValidationTransformTag

class OrderHistoryTag() extends StoreValidationTransformTag {

    val logUtil_OrderHistoryTag : LogUtil = LogUtil.getInstance()

    //private String id;
    private var status : String = null

    /*    public void setId(String id)    {       this.id=id;    }  */
    def setStatus(value : String) : Unit = {
        this.status = value
    }

    /*    public void setShipped(String value)    {       this.shipped=value;    }         public void setPartiallyShipped(String value)    {       this.partiallyShipped=value;    }         public void setPreprocessing(String value)    {       this.preprocessing=value;    }         public void setProcessing(String value)    {       this.processing=value;    }         public void setCancelled(String value)    {       this.cancelled=value;    }     */
    private def setOrderStatus() : String = {
        try {
            var anyType : Object = new OrderHistoryHelperFactory().getInstance(this.getPropertiesHashMap(), pageContext)
            var helperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod("setOrderStatus", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to view order table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_OrderHistoryTag.put(this.commonStrings.EXCEPTION, this, "setOrderStatus()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def doStartTag() : Int = {
        try {
            this.setName("Basic Order History View")
            this.setObjectFile("views.generic.order.history.ValidationView")
            if (this.getCommand() != null) {
                if (this.getCommand().compareTo(OrderHistoryData.SETSTATUS) == 0) {
                    this.getPropertiesHashMap().put(OrderHistoryData.STATUS, this.status)
                    pageContext.getOut().print(this.setOrderStatus())
                } else if (this.getCommand().compareTo(_root_.org.allbinary.globals.GLOBALS2.VIEW) == 0) {
                } else {
                    throw new Exception("No Such View Command: " + this.getCommand())
                }
                return super.doStartTag()
            }
            throw new Exception("Command Null")
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


