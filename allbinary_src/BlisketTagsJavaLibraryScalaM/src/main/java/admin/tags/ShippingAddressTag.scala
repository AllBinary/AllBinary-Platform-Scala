/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.java.lang.reflect.Method
import _root_.javax.servlet.jsp.JspTagException
import _root_.admin.taghelpers.ShippingAddressHelperFactory
import _root_.org.allbinary.business.user.address.ShippingAddressData
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.LicensingException

class ShippingAddressTag() extends TableTag {

    val logUtil_ShippingAddressTag : LogUtil = LogUtil.getInstance()

    private var value : String = null

    //Constructor
    {
        this.setTagHelperFactory(new ShippingAddressHelperFactory())
        this.setTagRequestHelperFactory(new ShippingAddressHelperFactory())
    }

    def setValue(value : String) : Unit = {
        this.value = value
    }

    private def set() : String = {
        try {
            var anyType : Object = new ShippingAddressHelperFactory().getInstance(this.getPropertiesHashMap(), this.pageContext)
            var addressHelperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = addressHelperClass.getMethod("set", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to set Shipping Address"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_ShippingAddressTag.put(this.commonStrings.EXCEPTION, this, "set()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    private def setToBillingAddress() : String = {
        try {
            var anyType : Object = new ShippingAddressHelperFactory().getInstance(this.getPropertiesHashMap(), this.pageContext)
            var addressHelperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = addressHelperClass.getMethod("setToBillingAddress", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed Setting Shipping address to Billing Address"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_ShippingAddressTag.put(this.commonStrings.EXCEPTION, this, "setShippingAddressToBillingAddress()", e)
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
                    if (this.getCommand().compareTo(ShippingAddressData.SELECT) == 0) {
                        this.set()
                        return this.EVAL_BODY_INCLUDE
                    } else if (this.getCommand().compareTo(ShippingAddressData.SETTOBILLINGADDRESS) == 0) {
                        this.setToBillingAddress()
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


