/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.java.lang.reflect.Method
import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.JspTagException
import _root_.admin.taghelpers.StoreFrontHelperFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.tags.CustomTagSupport

class StoreFrontTag() extends CustomTagSupport {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var command : String = null

    private var storeName : String = null

    private var propertiesHashMap : HashMap[Object, Object] = null

    def setCommand(command : String) : Unit = {
        this.command = command
    }

    def setStoreName(value : String) : Unit = {
        this.storeName = value
    }

    private def getCurrentLocation() : String = {
        try {
            var anyType : Object = new StoreFrontHelperFactory().getInstance(this.propertiesHashMap, this.pageContext)
            var method : Method = anyType.getClass().getMethod("getCurrentLocation", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to retrieve current location"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "getCurrentLocation()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    private def getCurrentHomeLocation() : String = {
        try {
            var anyType : Object = new StoreFrontHelperFactory().getInstance(this.propertiesHashMap, this.pageContext)
            var method : Method = anyType.getClass().getMethod("getCurrentHomeLocation", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to retrieve current home location"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "getCurrentHomeLocation()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def doStartTag() : Int = {
        try {
            if (this.command != null) {
                this.propertiesHashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
                this.propertiesHashMap.put(StoreFrontData.getInstance().NAME, this.storeName)
                if (this.command.compareTo(_root_.org.allbinary.globals.GLOBALS2.GETCURRENTLOCATION) == 0) {
                    pageContext.getOut().print(this.getCurrentLocation())
                } else if (this.command.compareTo(_root_.org.allbinary.globals.GLOBALS2.GETCURRENTHOMELOCATION) == 0) {
                    pageContext.getOut().print(this.getCurrentHomeLocation())
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


