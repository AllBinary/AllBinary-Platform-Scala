/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package tags

import _root_.java.lang.reflect.Method
import _root_.javax.servlet.jsp.JspTagException
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.LicensingException

class XmlValidationTransformTag() extends TransformTag {

    val logUtil_XmlValidationTransformTag : LogUtil = LogUtil.getInstance()

    private def isValid() : Boolean = {
        try {
            var helperClass : Class[?] = this.getHelper().getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod(commonStrings.IS_VALID, null)
            var result : _root_.java.lang.Boolean = method.invoke(this.getHelper(), null).asInstanceOf[_root_.java.lang.Boolean]
            return result.booleanValue()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_XmlValidationTransformTag.put(this.commonStrings.EXCEPTION, this, this.commonStrings.IS_VALID, e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    override def doStartTag() : Int = {
        try {
            this.setHelper()
            if (this.isValid()) {
                super.doStartTag()
                return this.EVAL_BODY_INCLUDE
            } else {
                super.doStartTag()
                return this.SKIP_BODY
            }
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


