/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.user.modules.admin.configuration.AdminConfiguration
import _root_.org.allbinary.business.user.modules.admin.configuration.AdminConfigurationInterface
import _root_.org.allbinary.logic.communication.log.LogUtil

class AdminConfigurationRequestHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends ModifyTable {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var request : HttpServletRequest = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
            this.logUtil.putF(this.commonStrings.CONSTRUCTOR, this, this.commonStrings.CONSTRUCTOR)
        }
        this.request = pageContext.getRequest().asInstanceOf[HttpServletRequest]
    }

    override def insert() : String = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(this.commonStrings.START, this, "insert()")
            }
            var success : String = "Successfully inserted AdminConfiguration"
            var adminConfigurationInterface : AdminConfigurationInterface = (new AdminConfiguration(this.request)).asInstanceOf[AdminConfigurationInterface]
            adminConfigurationInterface.write()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "insert()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to created AdminConfiguration"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "insert()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def delete() : String = {
        try {
            var success : String = "Successfully deleted AdminConfiguration"
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "delete()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to delete"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "delete()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def update() : String = {
        try {
            var success : String = "Updated AdminConfiguration Successful"
            var adminConfigurationInterface : AdminConfigurationInterface = (new AdminConfiguration(this.request)).asInstanceOf[AdminConfigurationInterface]
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "update()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to update"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "update()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

}


