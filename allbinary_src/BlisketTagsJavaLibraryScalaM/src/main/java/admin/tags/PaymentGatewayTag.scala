/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.java.lang.reflect.Method
import _root_.javax.servlet.jsp.JspTagException
import _root_.admin.taghelpers.PaymentGatewayHelperFactory
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.LicensingException

class PaymentGatewayTag() extends TableTag {

    val logUtil_PaymentGatewayTag : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        this.setTagHelperFactory(new PaymentGatewayHelperFactory())
        this.setTagRequestHelperFactory(new PaymentGatewayHelperFactory())
    }

    def process() : String = {
        try {
            var anyType : Object = new PaymentGatewayHelperFactory().getInstance(this.getPropertiesHashMap(), this.pageContext)
            var helperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod(commonStrings.PROCESS, null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : LicensingException => {
                this.logUtil_PaymentGatewayTag.put("LicensingException", this, this.commonStrings.PROCESS, e)
                throw e
            }
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_PaymentGatewayTag.put(this.commonStrings.EXCEPTION, this, this.commonStrings.PROCESS, e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    override def doStartTag() : Int = {
        try {
            if (this.isEnabled()) {
                if (((this.getCommand().compareTo(_root_.org.allbinary.globals.GLOBALS2.AUTHORIZEORDEREVALBODYONERROR) == 0) || (this.getCommand().compareTo(_root_.org.allbinary.globals.GLOBALS2.AUTHORIZEORDERANDEVALBODY) == 0)) || (this.getCommand().compareTo(_root_.org.allbinary.globals.GLOBALS2.AUTHORIZEFORMEVALBODYONERROR) == 0)) {
                    var output : String = this.process()
                    //if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().JSPTAGEXTRAOUTPUT))

                    {
                        this.pageContext.getOut().print(output + "<br />")
                    }
                    if (this.getCommand().compareTo(_root_.org.allbinary.globals.GLOBALS2.AUTHORIZEORDEREVALBODYONERROR) == 0) {
                        return this.SKIP_BODY
                    } else {
                        return this.EVAL_BODY_INCLUDE
                    }
                } else {
                    return super.doStartTag()
                }
            }
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


