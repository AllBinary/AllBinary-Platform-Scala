/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.java.lang.reflect.Method
import _root_.javax.servlet.jsp.JspTagException
import _root_.javax.servlet.jsp.tagext.TagSupport
import _root_.admin.taghelpers.StoreFrontsHelperFactory
import _root_.admin.taghelpers.StoreFrontsRequestHelperFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.LicensingException

class StoreFrontsTag() extends TableTag {

    val logUtil_StoreFrontsTag : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        this.setTagHelperFactory(new StoreFrontsHelperFactory())
        this.setTagRequestHelperFactory(new StoreFrontsRequestHelperFactory())
    }

    private def generateSelect() : String = {
        try {
            var anyType : Object = this.getTagHelperFactoryInterface().getInstance(this.getPropertiesHashMap(), pageContext)
            var method : Method = anyType.getClass().getMethod("generateSelect", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to generate storefronts select"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_StoreFrontsTag.put(this.commonStrings.EXCEPTION, this, "generateSelect()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    private def install() : String = {
        try {
            var anyType : Object = this.getTagRequestHelperFactoryInterface().getInstance(this.getPropertiesHashMap(), pageContext)
            var method : Method = anyType.getClass().getMethod("install", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to generate storefronts select"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_StoreFrontsTag.put(this.commonStrings.EXCEPTION, this, "generateSelect()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    private def sendStoreCreatedEmails() : String = {
        try {
            var anyType : Object = this.getTagRequestHelperFactoryInterface().getInstance(this.getPropertiesHashMap(), pageContext)
            var method : Method = anyType.getClass().getMethod("sendStoreCreatedEmails", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to send email"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_StoreFrontsTag.put(this.commonStrings.EXCEPTION, this, "sendStoreCreatedEmails()", e)
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
                    var storeFrontData : StoreFrontData = StoreFrontData.getInstance()
                    if (this.getCommand().compareTo(storeFrontData.SELECT) == 0) {
                        this.pageContext.getOut().print(this.generateSelect())
                    } else if (this.getCommand().compareTo(storeFrontData.INSTALL) == 0) {
                        this.getPropertiesHashMap().put("current", this.getCurrent())
                        this.getPropertiesHashMap().put("total", this.getTotal())
                        //If install is complete process body
                        if (this.getCurrent().intValue() == this.getTotal().intValue()) {
                            return TagSupport.EVAL_BODY_INCLUDE
                        }
                        this.install()
                    } else if (this.getCommand().compareTo(storeFrontData.INSTALL_COMPLETE) == 0) {
                        this.sendStoreCreatedEmails()
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


