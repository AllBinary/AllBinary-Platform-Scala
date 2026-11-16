/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.installer.Portion
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.business.user.address.StreetAddress
import _root_.org.allbinary.data.tables.user.address.billing.BillingAddressesEntityFactory
import _root_.org.allbinary.data.tables.user.address.shipping.ShippingAddressesEntity
import _root_.org.allbinary.data.tables.user.address.shipping.ShippingAddressesEntityFactory
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSessionData
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlTableUtil
import _root_.org.allbinary.logic.string.StringUtil

class ShippingAddressHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends BasicTable {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val stringUtil : StringUtil = StringUtil.getInstance()

    private var weblisketSession : WeblisketSession = null

    private var request : HttpServletRequest = null

    private var userName : String = null

    private var streetAddress : StreetAddress = null

    private var portion : Portion = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        this.request = pageContext.getRequest().asInstanceOf[HttpServletRequest]
        this.weblisketSession = new WeblisketSession(hashMap, pageContext)
        this.portion = new Portion(hashMap)
        this.getAddressForm()
    }

    private def getAddressForm() : Unit = {
        this.userName = this.request.getParameter(UserData.USERNAME)
        if (this.userName == null) {
            this.userName = this.request.getParameter(WeblisketSessionData.REMOVABLEUSERNAME)
        }
        this.streetAddress = new StreetAddress(this.request)
    }

    override def drop() : String = {
        try {
            var success : String = new ShippingAddressesEntity(this.stringUtil.EMPTY_STRING).drop()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, this.commonStrings.DROP)
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to drop Admin table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.DROP, e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def create() : String = {
        try {
            var success : String = new ShippingAddressesEntity(this.stringUtil.EMPTY_STRING).createTable()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "create()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to create user table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
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
            val result : String = AbSqlTableUtil.getInstance().restoreTable(new ShippingAddressesEntity(StringUtil.getInstance().EMPTY_STRING), portion)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "restore()")
            }
            return result
        } catch {
            case e : Exception => {
                var error : String = "Failed to restore backup"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "restore()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def backup() : String = {
        try {
            val success : String = "Backup Successful"
            val result : String = AbSqlTableUtil.getInstance().backupTable(new ShippingAddressesEntity(StringUtil.getInstance().EMPTY_STRING))
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "backup()")
            }
            return result
        } catch {
            case e : Exception => {
                var error : String = "Failed to make backup"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "backup()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def insert() : String = {
        try {
            var success : String = "Successfully Added Shipping Address"
            ShippingAddressesEntityFactory.getInstance().getInstance(this.weblisketSession.getUserName()).add(this.streetAddress)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "insert")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to add Shipping streetAddress"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "insert", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def update() : String = {
        try {
            var success : String = "Successfully Updated Shipping Address"
            ShippingAddressesEntityFactory.getInstance().getInstance(this.weblisketSession.getUserName()).update(this.streetAddress)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF("Successfull update of a Users Shipping Address table", this, "update()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed update of a Users Shipping Address Table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "update", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    private def setToBillingAddress() : String = {
        try {
            var streetAddress : StreetAddress = BillingAddressesEntityFactory.getInstance().getInstance(this.weblisketSession.getUserName()).getDefault()
            if (streetAddress != null) {
                ShippingAddressesEntityFactory.getInstance().getInstance(this.weblisketSession.getUserName()).add(streetAddress)
            } else {
                return "No Billing Address"
            }
            return StringUtil.getInstance().EMPTY_STRING
        } catch {
            case e : Exception => {
                var error : String = "Failed Setting Shipping address to Billing Address"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "setToBillingAddress()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def delete() : String = {
        try {
            var success : String = "Successfully Removed Shipping Address"
            ShippingAddressesEntityFactory.getInstance().getInstance(this.weblisketSession.getUserName()).remove(new Integer(this.streetAddress.getId()))
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "remove()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to remove Shipping Address"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "remove()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def set() : String = {
        try {
            var success : String = "Successfully Set Shipping Address"
            ShippingAddressesEntityFactory.getInstance().getInstance(this.weblisketSession.getUserName()).setDefault(this.streetAddress.getId())
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "set()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to set Shipping Address"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "set()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

}


