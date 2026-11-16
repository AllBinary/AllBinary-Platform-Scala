/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.installer.Portion
import _root_.org.allbinary.business.user.NewUserFactory
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.business.user.UserInterface
import _root_.org.allbinary.business.user.username.UserName
import _root_.org.allbinary.data.tables.user.UserEntityFactory
import _root_.org.allbinary.globals.FREEBLISKET_PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.http.request.RequestParams
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlTableUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringValidationUtil

class UserHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends Table {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var hashMap : HashMap[Object, Object] = null

    private var pageContext : PageContext = null

    private var request : HttpServletRequest = null

    private var path : String = null

    private var portion : Portion = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        this.hashMap = hashMap
        this.pageContext = pageContext
        this.request = pageContext.getRequest().asInstanceOf[HttpServletRequest]
        this.path = URLGLOBALS.getMainPath() + FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH
        this.portion = new Portion(hashMap)
    }

    override def delete() : String = {
        try {
            var requestHashMap : HashMap[Object, Object] = new RequestParams(this.request).toHashMap().asInstanceOf[HashMap[Object, Object]]
            var userName : UserName = new UserName(requestHashMap)
            UserEntityFactory.getInstance().deleteWhere(UserData.USERNAME, userName.get())
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Successfully Removed the user with ")
            stringBuffer.append(UserData.USERNAME)
            stringBuffer.append("=")
            stringBuffer.append(userName.get())
            stringBuffer.append(" from to the user table")
            var success : String = stringBuffer.toString()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "delete()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = ("Failed to remove user with " + UserData.USERNAME) + " from User table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "delete()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def insert() : String = {
        try {
            var userInterface : UserInterface = NewUserFactory.getInstance(this.request, hashMap)
            //Property Enable can be included in Tag for user inserts
            var enable : String = this.hashMap.get(EntryData.getInstance().ENABLE).asInstanceOf[String]
            if (!StringValidationUtil.getInstance().isEmpty(enable)) {
                userInterface.setEnable(enable)
            }
            var values : BasicArrayList = userInterface.toVector()
            UserEntityFactory.getInstance().insert(values)
            var success : String = "New User Successfully added to the Users Table"
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "add()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to add User"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "add()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def update() : String = {
        try {
            var user : UserInterface = NewUserFactory.getInstance(this.request, hashMap)
            var values : HashMap[Object, Object] = user.toHashMap().asInstanceOf[HashMap[Object, Object]]
            UserEntityFactory.getInstance().update(user.getUserName(), values)
            var success : String = "New User Successfully added to the Users Table"
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "update()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to add User"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "update()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def drop() : String = {
        try {
            var success : String = UserEntityFactory.getInstance().dropTable()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
                this.logUtil.putF(success, this, this.commonStrings.DROP)
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to drop user table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.DROP, e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def create() : String = {
        try {
            var success : String = UserEntityFactory.getInstance().createTable()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
                this.logUtil.putF(success, this, "create()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to create user table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "create()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def restore() : String = {
        try {
            val success : String = "Restore Successful"
            val result : String = AbSqlTableUtil.getInstance().restoreTable(UserEntityFactory.getInstance(), this.portion)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "restore()")
            }
            return result
        } catch {
            case e : Exception => {
                var error : String = "Failed to restore backup"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "restore()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def backup() : String = {
        try {
            val success : String = "Restore Successful"
            val result : String = AbSqlTableUtil.getInstance().backupTable(UserEntityFactory.getInstance())
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
                this.logUtil.putF(success, this, "backup()")
            }
            return result
        } catch {
            case e : Exception => {
                var error : String = "Failed to make backup"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "backup()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

}


