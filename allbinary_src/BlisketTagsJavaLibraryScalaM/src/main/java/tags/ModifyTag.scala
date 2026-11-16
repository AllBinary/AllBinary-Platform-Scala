/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package tags

import _root_.java.lang.reflect.Method
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.JspTagException
import _root_.admin.taghelpers.TagHelperFactoryInterface
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.org.allbinary.string.CommonStrings

class ModifyTag(param_tagHelperFactoryInterface : TagHelperFactoryInterface) extends HelperTag(param_tagHelperFactoryInterface) {

    val logUtil_ModifyTag : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val tagHelperFactoryInterface : TagHelperFactoryInterface = param_tagHelperFactoryInterface
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
            this.logUtil_ModifyTag.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        }
    }

    def insert() : String = {
        try {
            var helperClass : Class[?] = this.getHelper().getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod("insert", null)
            var result : String = method.invoke(this.getHelper(), null).asInstanceOf[String]
            return result
        } catch {
            case e : Exception => {
                var error : String = "Failed to insert"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_ModifyTag.put(this.commonStrings.EXCEPTION, this, "insert()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def delete() : String = {
        try {
            var helperClass : Class[?] = this.getHelper().getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod(commonStrings.delete, null)
            var result : String = method.invoke(this.getHelper(), null).asInstanceOf[String]
            return result
        } catch {
            case e : Exception => {
                var error : String = "Failed to delete"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_ModifyTag.put(this.commonStrings.EXCEPTION, this, "delete()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def update() : String = {
        try {
            var helperClass : Class[?] = this.getHelper().getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod("update", null)
            var result : String = method.invoke(this.getHelper(), null).asInstanceOf[String]
            return result
        } catch {
            case e : Exception => {
                var error : String = "Failed to update"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_ModifyTag.put(this.commonStrings.EXCEPTION, this, "update()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def doStartTag() : Int = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                var request : HttpServletRequest = this.pageContext.getRequest().asInstanceOf[HttpServletRequest]
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("Command: ")
                stringBuffer.append(this.getCommand())
                stringBuffer.append(" Request URI: ")
                stringBuffer.append(request.getRequestURI())
                this.logUtil_ModifyTag.putF(stringBuffer.toString(), this, tagStrings.DO_START_TAG)
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
            }
            if (this.getCommand() != null) {
                this.setHelper()
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                if (this.getCommand().compareTo(commonStrings.INSERT) == 0) {
                    var output : String = this.insert()
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGEXTRAOUTPUT)) {
                        this.pageContext.getOut().print(output + "<br />")
                    }
                } else if (this.getCommand().compareTo(commonStrings.DELETE) == 0) {
                    var output : String = this.delete()
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGEXTRAOUTPUT)) {
                        this.pageContext.getOut().print(output + "<br />")
                    }
                } else if (this.getCommand().compareTo(commonStrings.UPDATE) == 0) {
                    var output : String = this.update()
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGEXTRAOUTPUT)) {
                        this.pageContext.getOut().print(output + "<br />")
                    }
                }
            }
            return this.EVAL_BODY_INCLUDE
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


