/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.java.lang.reflect.Method
import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.JspTagException
import _root_.admin.taghelpers.PaymentHelperFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.user.commerce.money.payment.PaymentData
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.LicensingException

class PaymentTag() extends TableTag {

    val logUtil_PaymentTag : LogUtil = LogUtil.getInstance()

    private var storeName : String = null

    private var propertiesHashMap : HashMap[Object, Object] = null

    //Constructor
    {
        this.setTagHelperFactory(new PaymentHelperFactory())
        this.setTagRequestHelperFactory(new PaymentHelperFactory())
    }

    def setStoreName(value : String) : Unit = {
        this.storeName = value
    }

    private def select() : String = {
        try {
            var anyType : Object = new PaymentHelperFactory().getInstance(this.getPropertiesHashMap(), pageContext)
            var addressHelperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = addressHelperClass.getMethod("select", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to select Payment"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_PaymentTag.put(this.commonStrings.EXCEPTION, this, "selectPayment()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def doStartTag() : Int = {
        try {
            if (this.isEnabled()) {
                this.propertiesHashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
                this.propertiesHashMap.put(StoreFrontData.getInstance().NAME, this.storeName)
                if (this.getCommand() != null) {
                    if (this.getCommand().compareTo(PaymentData.SELECT) == 0) {
                        var output : String = this.select()
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGEXTRAOUTPUT)) {
                            this.pageContext.getOut().print(output + "<br />")
                        }
                        return this.EVAL_BODY_INCLUDE
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


