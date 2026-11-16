/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.installer.Portion
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayInterface
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayInterfaceFactory
import _root_.org.allbinary.business.user.commerce.money.payment.types.BasicPaymentTypeUtil
import _root_.org.allbinary.data.tables.user.commerce.money.payment.gateway.PaymentGatewayEntityFactory
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlTableUtil
import _root_.org.allbinary.logic.string.StringMaker

class PaymentGatewayHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends BasicTable {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var weblisketSession : WeblisketSession = null

    private var httpServletRequest : HttpServletRequest = null

    private var portion : Portion = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        try {
            this.weblisketSession = new WeblisketSession(hashMap, pageContext)
            this.httpServletRequest = pageContext.getRequest().asInstanceOf[HttpServletRequest]
            this.portion = new Portion(hashMap)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PAYMENTERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.CONSTRUCTOR, e)
                }
                throw e
            }
        }
    }

    def insert() : String = {
        try {
            var paymentGatewayInterface : PaymentGatewayInterface = new PaymentGatewayInterfaceFactory().getInstance(this.httpServletRequest)
            paymentGatewayInterface.setStoreName(this.weblisketSession.getStoreName())
            PaymentGatewayEntityFactory.getInstance().add(paymentGatewayInterface)
            var success : String = "Successfully Added New Payment Gateway"
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "insert()")
            }
            return success + "<br/>"
        } catch {
            case e : Exception => {
                var error : String = "Failed to add"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "add()", e)
                }
                return (((error + "<br>") + "Exception: ") + e) + "<br>"
            }
        }
        throw new IllegalStateException()
    }

    def update() : String = {
        try {
            var paymentGatewayInterface : PaymentGatewayInterface = new PaymentGatewayInterfaceFactory().getInstance(this.httpServletRequest)
            paymentGatewayInterface.setStoreName(this.weblisketSession.getStoreName())
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("Gateway Name: ")
                stringBuffer.append(paymentGatewayInterface.getName())
                stringBuffer.append(" HashMap=")
                stringBuffer.append(paymentGatewayInterface.toHashMap(true).toString())
                this.logUtil.putF(stringBuffer.toString(), this, "update()")
            }
            PaymentGatewayEntityFactory.getInstance().update(paymentGatewayInterface)
            var success : String = "Successfully Updated Payment Gateway information"
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "update()")
            }
            return success + "<br/>"
        } catch {
            case e : Exception => {
                var error : String = "Failed to update payment gateway information"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "update()", e)
                }
                return (((error + "<br/>") + "Exception: ") + e) + "<br/>"
            }
        }
        throw new IllegalStateException()
    }

    def delete() : String = {
        try {
            var paymentGatewayInterface : PaymentGatewayInterface = new PaymentGatewayInterfaceFactory().getInstance(this.httpServletRequest)
            paymentGatewayInterface.setStoreName(this.weblisketSession.getStoreName())
            var storeName : String = paymentGatewayInterface.getStoreName()
            var gatewayName : String = paymentGatewayInterface.getName()
            PaymentGatewayEntityFactory.getInstance().remove(storeName, BasicPaymentTypeUtil.getInstance().get(gatewayName))
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Successfully Removed payment gateway where store name=")
            stringBuffer.append(storeName)
            stringBuffer.append(" and gateway name=")
            stringBuffer.append(gatewayName)
            var success : String = stringBuffer.toString()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "delete()")
            }
            return success + "<br/>"
        } catch {
            case e : Exception => {
                var error : String = "Failed to remove payment gateway from table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "remove()", e)
                }
                return (((error + "<br/>") + "Exception: ") + e) + "<br>"
            }
        }
        throw new IllegalStateException()
    }

    override def drop() : String = {
        try {
            var success : String = PaymentGatewayEntityFactory.getInstance().dropTable()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, this.commonStrings.DROP)
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to drop payment transaction result table"
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
            var success : String = PaymentGatewayEntityFactory.getInstance().createTable()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "create()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to create payment transaction result table"
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
            val result : String = AbSqlTableUtil.getInstance().restoreTable(PaymentGatewayEntityFactory.getInstance(), this.portion)
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
            val success : String = "Restore Successful"
            val result : String = AbSqlTableUtil.getInstance().backupTable(PaymentGatewayEntityFactory.getInstance())
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

}


