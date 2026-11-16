/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.java.lang.reflect.Method
import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.JspTagException
import _root_.admin.taghelpers.BasicTextEmailHelperFactory
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.tags.CustomTagSupport

class BasicTextEmailTag() extends CustomTagSupport {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var subject : String = null

    private var body : String = null

    def setSubject(value : String) : Unit = {
        this.subject = value
    }

    def setBody(value : String) : Unit = {
        this.body = value
    }

    def send() : String = {
        try {
            var propertiesHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            propertiesHashMap.put("Subject", this.subject)
            propertiesHashMap.put("Body", this.body)
            var anyType : Object = new BasicTextEmailHelperFactory().getInstance(propertiesHashMap, this.pageContext)
            var method : Method = anyType.getClass().getMethod("send", null)
            method.invoke(anyType, null)
            return "Email Sent"
        } catch {
            case e : Exception => {
                var error : String = "Failed to Send Email."
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "send()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def doStartTag() : Int = {
        try {
            this.pageContext.getOut().print(this.send())
            return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
        } catch {
            case e : Exception => {
                AbResponseHandler.sendJspTagRedirect(this.pageContext, e)
                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
            }
        }
        throw new IllegalStateException()
    }

}


