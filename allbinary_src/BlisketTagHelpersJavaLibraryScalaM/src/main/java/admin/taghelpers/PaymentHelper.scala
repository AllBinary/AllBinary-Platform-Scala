/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.installer.Portion
import _root_.org.allbinary.business.user.commerce.money.payment.PaymentFactory
import _root_.org.allbinary.business.user.commerce.money.payment.PaymentInterface
import _root_.org.allbinary.data.tables.user.commerce.money.payment.PaymentEntity
import _root_.org.allbinary.data.tables.user.commerce.money.payment.PaymentEntityFactory
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlTableUtil
import _root_.org.allbinary.logic.system.security.licensing.LicensingException

class PaymentHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends Table {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var weblisketSession : WeblisketSession = null

    private var request : HttpServletRequest = null

    private var value : String = null

    private var portion : Portion = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        this.request = pageContext.getRequest().asInstanceOf[HttpServletRequest]
        this.weblisketSession = new WeblisketSession(hashMap, pageContext)
        this.portion = new Portion(hashMap)
        this.getFormData()
    }

    private def getFormData() : Unit = {
        this.value = this.request.getParameter("VALUE")
    }

    override def insert() : String = {
        try {
            var success : String = "Successfully Added Payment"
            var paymentEntity : PaymentEntity = PaymentEntityFactory.getInstance().getPaymentEntityInstance()
            var paymentInterface : PaymentInterface = PaymentFactory.getInstance(this.request)
            paymentEntity.add(this.weblisketSession.getUserName(), paymentInterface)
            paymentEntity.setDefault(this.weblisketSession.getUserName(), new Integer(paymentEntity.getLastId(this.weblisketSession.getUserName())))
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "addPayment()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to add Payment"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "addPayment()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def select() : String = {
        try {
            var success : String = "Successfully Selected Payment"
            var paymentEntity : PaymentEntity = PaymentEntityFactory.getInstance().getPaymentEntityInstance()
            paymentEntity.setDefault(this.weblisketSession.getUserName(), new Integer(this.value))
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "selectPayment()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to select Payment"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "selectPayment()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def delete() : String = {
        try {
            var success : String = "Successfully Removed Payment"
            var paymentEntity : PaymentEntity = PaymentEntityFactory.getInstance().getPaymentEntityInstance()
            paymentEntity.remove(this.weblisketSession.getUserName(), new Integer(this.value))
            var paymentInterface : PaymentInterface = paymentEntity.getDefault(this.weblisketSession.getUserName())
            if (paymentInterface == null) {
                paymentEntity.setDefault(this.weblisketSession.getUserName(), new Integer(paymentEntity.getLastId(this.weblisketSession.getUserName())))
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "removePayment()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to remove Payment"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "removePayment()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def drop() : String = {
        try {
            var paymentEntity : PaymentEntity = PaymentEntityFactory.getInstance().getPaymentEntityInstance()
            var success : String = paymentEntity.dropTable()
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
            var paymentEntity : PaymentEntity = PaymentEntityFactory.getInstance().getPaymentEntityInstance()
            var success : String = paymentEntity.createTable()
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
            val result : String = AbSqlTableUtil.getInstance().restoreTable(PaymentEntityFactory.getInstance().getPaymentEntityInstance(), portion)
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
            val result : String = AbSqlTableUtil.getInstance().backupTable(PaymentEntityFactory.getInstance().getPaymentEntityInstance())
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

    override def update() : String = {
        return commonStrings.NOT_IMPLEMENTED
    }

}


