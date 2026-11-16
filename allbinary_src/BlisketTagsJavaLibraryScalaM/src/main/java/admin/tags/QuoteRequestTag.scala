/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.java.lang.reflect.Method
import _root_.javax.servlet.jsp.JspTagException
import _root_.admin.taghelpers.QuoteHelperFactory
import _root_.admin.taghelpers.QuoteRequestHelperFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.LicensingException

class QuoteRequestTag() extends TableTag {

    val logUtil_QuoteRequestTag : LogUtil = LogUtil.getInstance()

    private var storeName : String = null

    //Constructor
    {
        this.setTagHelperFactory(new QuoteHelperFactory())
        this.setTagRequestHelperFactory(new QuoteRequestHelperFactory())
    }

    def setStoreName(storeName : String) : Unit = {
        this.storeName = storeName
    }

    private def email() : String = {
        try {
            var anyType : Object = new QuoteHelperFactory().getInstance(this.getPropertiesHashMap(), pageContext)
            var helperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod("email", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to send QuoteRequest emails"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_QuoteRequestTag.put(this.commonStrings.EXCEPTION, this, "sendEmail()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def doStartTag() : Int = {
        try {
            if (this.getCommand() != null) {
                this.getPropertiesHashMap().put(StoreFrontData.getInstance().NAME, this.storeName)
                if (this.getCommand().compareTo("EMAIL") == 0) {
                    this.email()
                    return this.EVAL_BODY_INCLUDE
                } else {
                    return super.doStartTag()
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


