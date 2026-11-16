/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.javax.servlet.jsp.JspTagException
import _root_.org.allbinary.globals.AppUrlGlobals
import _root_.org.allbinary.globals.GLOBALS2
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.tags.CustomTagSupport

class CustomLoaderTag() extends CustomTagSupport {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var command : String = null

    private var webappPath : String = null

    def setCommand(command : String) : Unit = {
        this.command = command
    }

    def setWebappPath(value : String) : Unit = {
        this.webappPath = value
    }

    private def setCustomLoaderWebappPath() : Unit = {
        try {
            var urlGlobals : AppUrlGlobals = new AppUrlGlobals()
            urlGlobals.setWebappPath(this.webappPath)
            URLGLOBALS.init(urlGlobals)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "setCustomLoaderWebappPath()", e)
                }
            }
        }
    }

    //         String webappPath = (String) method.invoke(object,null);
    override def doStartTag() : Int = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                this.logUtil.putF(this.commonStrings.START, this, tagStrings.DO_START_TAG)
            }
            if (this.command != null) {
                if (this.command.compareTo(GLOBALS2.SET) == 0) {
                    this.setCustomLoaderWebappPath()
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


