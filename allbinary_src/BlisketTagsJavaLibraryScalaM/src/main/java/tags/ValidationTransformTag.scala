/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package tags

import _root_.java.lang.reflect.Method
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.JspTagException
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.taghelpers.ValidatedViewHelperFactory

class ValidationTransformTag() extends TransformTag(new ValidatedViewHelperFactory()) {

    val logUtil_ValidationTransformTag : LogUtil = LogUtil.getInstance()

    private var xslFile : String = null

    private var logic : Boolean = false

    //Constructor
    {
        this.logic = true
    }

    def setXsl(value : String) : Unit = {
        this.xslFile = value
        this.setTemplateFile(this.xslFile)
    }

    def setLogic(logic : Boolean) : Unit = {
        this.logic = logic
    }

    private def isValid() : Boolean = {
        try {
            var helperClass : Class[?] = this.getHelper().getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod(commonStrings.IS_VALID, null)
            var result : _root_.java.lang.Boolean = method.invoke(this.getHelper(), null).asInstanceOf[_root_.java.lang.Boolean]
            return result.booleanValue()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_ValidationTransformTag.put(this.commonStrings.EXCEPTION, this, this.commonStrings.IS_VALID, e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    private def validationInfo() : String = {
        try {
            var addressHelperClass : Class[?] = this.getHelper().getClass().asInstanceOf[Class[?]]
            var method : Method = addressHelperClass.getMethod("validationInfo", null)
            var result : String = method.invoke(this.getHelper(), null).asInstanceOf[String]
            return result
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_ValidationTransformTag.put(this.commonStrings.EXCEPTION, this, "validationInfo()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    override def doStartTag() : Int = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                var stringBuffer : StringMaker = new StringMaker()
                var request : HttpServletRequest = this.pageContext.getRequest().asInstanceOf[HttpServletRequest]
                stringBuffer.append("ValidationViewTag Start For: ")
                stringBuffer.append(this.getName())
                stringBuffer.append("\nView FIle: ")
                stringBuffer.append(this.getObjectFile())
                stringBuffer.append("\nRequest URI: ")
                stringBuffer.append(request.getRequestURI())
                this.logUtil_ValidationTransformTag.putF(stringBuffer.toString(), this, tagStrings.DO_START_TAG)
            }
            this.setHelper()
            if (this.isValid()) {
                super.doStartTag()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("View File: ")
                    stringBuffer.append(this.getObjectFile())
                    stringBuffer.append("\nLogic includes body if true=")
                    stringBuffer.appendboolean(this.logic)
                    this.logUtil_ValidationTransformTag.putF(stringBuffer.toString(), this, tagStrings.DO_START_TAG)
                }
                if (this.logic) {
                    return _root_.javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE
                } else {
                    return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
                }
            } else {
                //super.doStartTag();
                pageContext.getOut().print(this.validationInfo())
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("View File: ")
                    stringBuffer.append(this.getObjectFile())
                    stringBuffer.append("\nisValid()=false")
                    stringBuffer.append("\nLogic skips body if true=")
                    stringBuffer.appendboolean(this.logic)
                    this.logUtil_ValidationTransformTag.putF(stringBuffer.toString(), this, tagStrings.DO_START_TAG)
                }
                if (this.logic) {
                    return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
                } else {
                    return _root_.javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE
                }
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

    override def doEndTag() : Int = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
            this.logUtil_ValidationTransformTag.putF("Tag Ended", this, "doEndTag")
        }
        this.logic = true
        return super.doEndTag()
    }

}


