/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.java.lang.reflect.Method
import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.JspTagException
import _root_.javax.servlet.jsp.tagext.TagSupport
import _root_.admin.taghelpers.OrderHelperFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.tags.CustomTagSupport

class OrderTag() extends CustomTagSupport {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var command : String = null

    private var storeName : String = null

    private var propertiesHashMap : HashMap[Object, Object] = null

    def setCommand(command : String) : Unit = {
        this.command = command
    }

    def setStoreName(value : String) : Unit = {
        this.storeName = value
    }

    private def process() : String = {
        try {
            var anyType : Object = new OrderHelperFactory().getInstance(this.propertiesHashMap, this.pageContext)
            var helperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod(commonStrings.PROCESS, null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to Process Order: "
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.PROCESS, e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    private def setPaymentGateway() : _root_.java.lang.Boolean = {
        try {
            var anyType : Object = new OrderHelperFactory().getInstance(this.propertiesHashMap, this.pageContext)
            var addressHelperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = addressHelperClass.getMethod("setPaymentGateway", null)
            var result : _root_.java.lang.Boolean = method.invoke(anyType, null).asInstanceOf[_root_.java.lang.Boolean]
            return result
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to setPaymentGateway for Order"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "setPaymentGateway()", e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    /*    private String getOrderIdFromSession() throws LicensingException    {       try       {          Object object = OrderHelperFactory.getInstance(this.storeName,          pageContext.getSession();          Class addressHelperClass = object.getClass();          Method method = addressHelperClass.getMethod("getOrderIdFromSession",null);                    String result = (String) method.invoke(object,null);          return result;       }       catch(LicensingException e)       {          throw e;       }       catch(Exception e)       {          String error = "Failed to get Order id from session";                    if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLTAGSERROR))          {             this.logUtil.put(this.commonStrings.EXCEPTION,this,"getOrderIdFromSession()",e);          }          return "Unknown";       }    }       */
    override def doStartTag() : Int = {
        try {
            if (this.command != null) {
                this.propertiesHashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
                this.propertiesHashMap.put(StoreFrontData.getInstance().NAME, this.storeName)
                if (this.command.compareTo(_root_.org.allbinary.globals.GLOBALS2.PROCESS) == 0) {
                    this.process()
                } else if (this.command.compareTo(PaymentGatewayData.NAME.toString()) == 0) {
                    if (this.setPaymentGateway() == _root_.java.lang.Boolean.TRUE) {
                        return TagSupport.EVAL_BODY_INCLUDE
                    }
                }
            }
            return TagSupport.SKIP_BODY
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


