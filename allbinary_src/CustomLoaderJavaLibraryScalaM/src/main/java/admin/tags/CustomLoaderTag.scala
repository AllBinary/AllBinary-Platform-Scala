/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.java.lang.reflect.Method
import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.JspTagException
import _root_.admin.taghelpers.CustomLoaderHelperFactory
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.tags.CustomTagSupport

class CustomLoaderTag() extends CustomTagSupport {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var command : String = null

    private var webappPath : String = null

    private var propertiesHashMap : HashMap[Object, Object] = null

    def setCommand(command : String) : Unit = {
        this.command = command
    }

    def setWebappPath(value : String) : Unit = {
        this.webappPath = value
    }

    private def setCustomLoaderWebappPath() : Unit = {
        try {
            var anyType : Object = new CustomLoaderHelperFactory().getInstance(this.propertiesHashMap, pageContext)
            var helperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var methodParams : Array[Class[?]] = Array[Class[?]](this.webappPath.getClass())
            var methodArgs : Array[Object] = Array[Object](this.webappPath)
            var setMethod : Method = helperClass.getMethod("setWebappPath", methodParams*)
            setMethod.invoke(anyType, methodArgs*)
        } catch {
            case e : LicensingException => {
                throw e
            }
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
                this.propertiesHashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
                if (this.command.compareTo(_root_.org.allbinary.globals.GLOBALS2.SET) == 0) {
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


