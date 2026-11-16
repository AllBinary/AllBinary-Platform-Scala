/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.business.installer

import _root_.org.allbinary.business.init.InitInfoEntity
import _root_.org.allbinary.business.init.db.DatabaseConnectionInfoInterface
import _root_.org.allbinary.business.init.db.DbConnectionInfo
import _root_.org.allbinary.business.init.db.HistoryDbInitInfo
import _root_.org.allbinary.business.init.db.InventoryDbInitInfo
import _root_.org.allbinary.business.init.db.LogDbInitInfo
import _root_.org.allbinary.business.init.db.StaticPagesDbInitInfo
import _root_.org.allbinary.business.init.db.UserDbInitInfo
import _root_.org.allbinary.data.tables.context.module.storefronts.StoreFrontsEntityFactory
import _root_.org.allbinary.data.tables.log.LogTableEntityFactory
import _root_.org.allbinary.data.tables.staticpages.StaticPagesEntityFactory
import _root_.org.allbinary.data.tables.transform.info.TransformInfoEntityBuilder
import _root_.org.allbinary.data.tables.user.UserEntityFactory
import _root_.org.allbinary.data.tables.user.address.billing.BillingAddressesEntityFactory
import _root_.org.allbinary.data.tables.user.address.shipping.ShippingAddressesEntityFactory
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.InventoryEntityFactory
import _root_.org.allbinary.data.tables.user.commerce.inventory.order.OrderHistoryEntityFactory
import _root_.org.allbinary.data.tables.user.commerce.inventory.order.OrderItemsEntityFactory
import _root_.org.allbinary.data.tables.user.commerce.money.payment.PaymentEntityFactory
import _root_.org.allbinary.data.tables.user.commerce.money.payment.gateway.PaymentGatewayEntityFactory
import _root_.org.allbinary.data.tables.user.commerce.money.payment.transaction.TransactionEntityFactory
import _root_.org.allbinary.data.tables.user.commerce.money.payment.transaction.TransactionResultEntityFactory
import _root_.org.allbinary.data.tables.user.quoterequest.QuoteRequestEntityFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbDatabaseManagement
import _root_.org.allbinary.logic.io.AbDataOutputStream
import _root_.org.allbinary.logic.io.DataOutputStreamFactory
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.FileFactory
import _root_.org.allbinary.logic.string.StringMaker

//Warning you must have sql root access
class InitDbCrypted(param_databaseConnectionInfoInterface : DatabaseConnectionInfoInterface) extends AbDatabaseManagement(param_databaseConnectionInfoInterface.asInstanceOf[DbConnectionInfo]) {

    //extends InitSql
    val logUtil_InitDbCrypted : LogUtil = LogUtil.getInstance()

    private var userDbInitInfo : UserDbInitInfo = null

    private var inventoryDbInitInfo : InventoryDbInitInfo = null

    private var historyDbInitInfo : HistoryDbInitInfo = null

    private var staticpagesDbInitInfo : StaticPagesDbInitInfo = null

    private var logDbInitInfo : LogDbInitInfo = null

    private val SQL_FILE : String = "initWeblisket.sql"

    //String db, String userName, String password
    //Constructor
    {
        val databaseConnectionInfoInterface : DatabaseConnectionInfoInterface = param_databaseConnectionInfoInterface
    }

    def addUsers() : _root_.java.lang.Boolean = {
        try {
            this.logUtil_InitDbCrypted.putF(this.commonStrings.START, this, this.METHOD_ADD_USERS)
            this.userDbInitInfo = new UserDbInitInfo()
            this.inventoryDbInitInfo = new InventoryDbInitInfo()
            this.historyDbInitInfo = new HistoryDbInitInfo()
            this.staticpagesDbInitInfo = new StaticPagesDbInitInfo()
            this.logDbInitInfo = new LogDbInitInfo()
            var CUSTOMERDB : String = this.userDbInitInfo.getName()
            var CUSTOMERDBUSER : String = this.userDbInitInfo.getUserName()
            var CUSTOMERDBPASSWORD : String = this.userDbInitInfo.getPassword()
            if (!this.addDbUser(CUSTOMERDB, CUSTOMERDBUSER, CUSTOMERDBPASSWORD)) {
                this.logUtil_InitDbCrypted.putF(this.UNABLE_TO_CREATE_USER + CUSTOMERDBUSER, this, this.METHOD_ADD_USERS)
                return _root_.java.lang.Boolean.FALSE
            }
            var INVENTORYDB : String = this.inventoryDbInitInfo.getName()
            var INVENTORYDBUSER : String = this.inventoryDbInitInfo.getUserName()
            var INVENTORYDBPASSWORD : String = this.inventoryDbInitInfo.getPassword()
            if (!this.addDbUser(INVENTORYDB, INVENTORYDBUSER, INVENTORYDBPASSWORD)) {
                this.logUtil_InitDbCrypted.putF(this.UNABLE_TO_CREATE_USER + INVENTORYDBUSER, this, this.METHOD_ADD_USERS)
                return _root_.java.lang.Boolean.FALSE
            }
            var HISTORYDB : String = this.historyDbInitInfo.getName()
            var HISTORYDBUSER : String = this.historyDbInitInfo.getUserName()
            var HISTORYDBPASSWORD : String = this.historyDbInitInfo.getPassword()
            if (!this.addDbUser(HISTORYDB, HISTORYDBUSER, HISTORYDBPASSWORD)) {
                this.logUtil_InitDbCrypted.putF(this.UNABLE_TO_CREATE_USER + HISTORYDBUSER, this, this.METHOD_ADD_USERS)
                return _root_.java.lang.Boolean.FALSE
            }
            var STATICPAGESDB : String = this.staticpagesDbInitInfo.getName()
            var STATICPAGESDBUSER : String = this.staticpagesDbInitInfo.getUserName()
            var STATICPAGESDBPASSWORD : String = this.staticpagesDbInitInfo.getPassword()
            if (!this.addDbUser(STATICPAGESDB, STATICPAGESDBUSER, STATICPAGESDBPASSWORD)) {
                this.logUtil_InitDbCrypted.putF(this.UNABLE_TO_CREATE_USER + STATICPAGESDBUSER, this, this.METHOD_ADD_USERS)
                return _root_.java.lang.Boolean.FALSE
            }
            var LOGDB : String = this.logDbInitInfo.getName()
            var LOGDBUSER : String = this.logDbInitInfo.getUserName()
            var LOGDBPASSWORD : String = this.logDbInitInfo.getPassword()
            if (!this.addDbUser(LOGDB, LOGDBUSER, LOGDBPASSWORD)) {
                this.logUtil_InitDbCrypted.putF(this.UNABLE_TO_CREATE_USER + LOGDBUSER, this, this.METHOD_ADD_USERS)
                return _root_.java.lang.Boolean.FALSE
            }
            this.logUtil_InitDbCrypted.putF(this.commonStrings.END, this, this.METHOD_ADD_USERS)
            return _root_.java.lang.Boolean.TRUE
        } catch {
            case e : Exception => {
                this.logUtil_InitDbCrypted.put(this.commonStrings.EXCEPTION, this, this.METHOD_ADD_USERS, e)
                //return Boolean.FALSE;
                return _root_.java.lang.Boolean.TRUE
            }
        }
        throw new IllegalStateException()
    }

    def addDatabases() : _root_.java.lang.Boolean = {
        try {
            this.logUtil_InitDbCrypted.putF(this.commonStrings.START, this, this.METHOD_ADD_DATABASES)
            this.userDbInitInfo = new UserDbInitInfo()
            this.inventoryDbInitInfo = new InventoryDbInitInfo()
            this.historyDbInitInfo = new HistoryDbInitInfo()
            this.staticpagesDbInitInfo = new StaticPagesDbInitInfo()
            this.logDbInitInfo = new LogDbInitInfo()
            var CUSTOMERDB : String = this.userDbInitInfo.getName()
            if (!this.addDb(CUSTOMERDB)) {
                this.logUtil_InitDbCrypted.putF(this.UNABLE_TO_CREATE_DATABASE + CUSTOMERDB, this, this.METHOD_ADD_DATABASES)
                return _root_.java.lang.Boolean.FALSE
            }
            var INVENTORYDB : String = this.inventoryDbInitInfo.getName()
            if (!this.addDb(INVENTORYDB)) {
                this.logUtil_InitDbCrypted.putF(this.UNABLE_TO_CREATE_DATABASE + INVENTORYDB, this, this.METHOD_ADD_DATABASES)
                return _root_.java.lang.Boolean.FALSE
            }
            var HISTORYDB : String = this.historyDbInitInfo.getName()
            if (!this.addDb(HISTORYDB)) {
                this.logUtil_InitDbCrypted.putF(this.UNABLE_TO_CREATE_DATABASE + HISTORYDB, this, this.METHOD_ADD_DATABASES)
                return _root_.java.lang.Boolean.FALSE
            }
            var STATICPAGESDB : String = this.staticpagesDbInitInfo.getName()
            if (!this.addDb(STATICPAGESDB)) {
                this.logUtil_InitDbCrypted.putF(this.UNABLE_TO_CREATE_DATABASE + STATICPAGESDB, this, this.METHOD_ADD_DATABASES)
                return _root_.java.lang.Boolean.FALSE
            }
            var LOGDB : String = this.logDbInitInfo.getName()
            if (!this.addDb(LOGDB)) {
                this.logUtil_InitDbCrypted.putF(this.UNABLE_TO_CREATE_DATABASE + LOGDB, this, this.METHOD_ADD_DATABASES)
                return _root_.java.lang.Boolean.FALSE
            }
            var file : AbFile = FileFactory.getInstance().getInstance(this.SQL_FILE)
            file.createNewFile()
            var idOutData : AbDataOutputStream = DataOutputStreamFactory.getInstance().getInstanceForAbFile(file)
            idOutData.writeBytes(this.sqlCommandLog.toString())
            return _root_.java.lang.Boolean.TRUE
        } catch {
            case e : Exception => {
                this.logUtil_InitDbCrypted.put(this.commonStrings.EXCEPTION, this, this.METHOD_ADD_DATABASES, e)
                //return Boolean.FALSE;
                return _root_.java.lang.Boolean.TRUE
            }
        }
        throw new IllegalStateException()
    }

    def addTables() : _root_.java.lang.Boolean = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            this.logUtil_InitDbCrypted.putF(this.commonStrings.START, this, this.METHOD_ADD_TABLES)
            stringBuffer.append(UserEntityFactory.getInstance().createTable())
            stringBuffer.append(StoreFrontsEntityFactory.getInstance().getStoreFrontsEntityInstance().createTable())
            stringBuffer.append(BillingAddressesEntityFactory.getInstance().getInstance(this.stringUtil.EMPTY_STRING).createTable())
            stringBuffer.append(ShippingAddressesEntityFactory.getInstance().getInstance(this.stringUtil.EMPTY_STRING).createTable())
            stringBuffer.append(PaymentEntityFactory.getInstance().getPaymentEntityInstance().createTable())
            stringBuffer.append(QuoteRequestEntityFactory.getInstance().getQuoteRequestEntityInstance().createTable())
            stringBuffer.append(OrderHistoryEntityFactory.getInstance().createTable())
            stringBuffer.append(OrderItemsEntityFactory.getInstance().createTable())
            stringBuffer.append(TransactionEntityFactory.getInstance().getTransactionEntityInstance().createTable())
            stringBuffer.append(TransactionResultEntityFactory.getInstance().getTransactionResultEntityInstance().createTable())
            stringBuffer.append(PaymentGatewayEntityFactory.getInstance().createTable())
            //stringBuffer.append(CategoryEntityFactory.getInstance().createTable());
            stringBuffer.append(InventoryEntityFactory.getInstance().getInventoryEntityInstance().createTable())
            /*              stringBuffer.append(CustomItemsEntityFactory.getInstance().createTable()));              stringBuffer.append(DownloadItemsEntityFactory.getInstance().createTable()));              stringBuffer.append(BasicGroupItemsEntityFactory.getInstance().createTable()));              stringBuffer.append(BasicOptionItemsEntityFactory.getInstance().createTable()));              stringBuffer.append(XmlOptionItemsEntityFactory.getInstance().createTable()));              stringBuffer.append(PermissionItemsEntityFactory.getInstance().createTable()));              stringBuffer.append(SpecialItemsEntityFactory.getInstance().createTable()));              */
            stringBuffer.append(new InitInfoEntity().createTable())
            stringBuffer.append(LogTableEntityFactory.getInstance().getLogTableEntityInstance().createTable())
            stringBuffer.append(StaticPagesEntityFactory.getInstance().getStaticPagesEntityInstance().createTable())
            stringBuffer.append(TransformInfoEntityBuilder.getInstance().createTable())
            //ViewTemplateEntityFactory.getInstance().createTable());
            this.logUtil_InitDbCrypted.putF(ADD_TABLES_RESULTS_LABEL + stringBuffer.toString(), this, this.METHOD_ADD_TABLES)
            return _root_.java.lang.Boolean.TRUE
        } catch {
            case e : Exception => {
                this.logUtil_InitDbCrypted.put(this.commonStrings.EXCEPTION, this, this.METHOD_ADD_TABLES, e)
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

}


