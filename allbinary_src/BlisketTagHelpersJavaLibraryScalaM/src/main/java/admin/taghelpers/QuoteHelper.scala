/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFront
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.installer.Portion
import _root_.org.allbinary.business.user.UserInterface
import _root_.org.allbinary.business.user.quoterequest.QuoteRequest
import _root_.org.allbinary.data.tables.user.UserEntityFactory
import _root_.org.allbinary.data.tables.user.quoterequest.QuoteRequestEntity
import _root_.org.allbinary.data.tables.user.quoterequest.QuoteRequestEntityFactory
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData
import _root_.org.allbinary.logic.communication.smtp.event.handler.UserEmailEventHandler
import _root_.org.allbinary.logic.communication.smtp.event.handler.factory.AdminUserEmailEventHandlerSingletons
import _root_.org.allbinary.logic.communication.smtp.event.handler.factory.StoreAdminUserEmailEventHandlerSingletons
import _root_.org.allbinary.logic.communication.smtp.event.handler.factory.UserEmailEventHandlerSingletons
import _root_.org.allbinary.logic.communication.smtp.info.BasicEmailInfo
import _root_.org.allbinary.logic.communication.smtp.info.EmailInfo
import _root_.org.allbinary.logic.communication.smtp.info.StoreEmailInfo
import _root_.org.allbinary.logic.communication.sql.AbSqlTableUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory

class QuoteHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends BasicTable {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val abeClientInformation : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()

    private var weblisketSession : WeblisketSession = null

    private var storeFrontInterface : StoreFrontInterface = null

    private var portion : Portion = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        var storeName : String = hashMap.get(StoreFrontData.getInstance().NAME).asInstanceOf[String]
        if (storeName != null) {
            this.storeFrontInterface = StoreFrontFactory.getInstance(storeName)
        } else {
            this.storeFrontInterface = new StoreFront()
        }
        this.weblisketSession = new WeblisketSession(hashMap, pageContext)
        this.portion = new Portion(hashMap)
    }

    private def emailUser(quoteRequest : QuoteRequest) : Unit = {
        var user : UserInterface = UserEntityFactory.getInstance().getUser(quoteRequest.getUserName())
        var userEmailSubject : String = "Quote Request Receipt"
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("This is just a verification email. ")
        stringBuffer.append("We usually respond to quote request within 24 hours.")
        stringBuffer.append("\n\nThank You For Your Business.")
        var userEmailTextBody : String = stringBuffer.toString()
        var basicEmailInfo : BasicEmailInfo = (new StoreEmailInfo(this.storeFrontInterface, userEmailSubject, userEmailTextBody)).asInstanceOf[BasicEmailInfo]
        var emailInfo : EmailInfo = new EmailInfo(basicEmailInfo)
        //Send response to customer
        var userEmailEventHandler : UserEmailEventHandler = UserEmailEventHandlerSingletons.getInstance().getInstance(this.abeClientInformation, UserEmailEventNameData.QUOTEREQUEST, user)
        userEmailEventHandler.receiveEmailInfo(UserEmailEventNameData.QUOTEREQUEST, emailInfo)
    }

    private def emailAdmins(quoteRequest : QuoteRequest) : Unit = {
        var adminEmailSubject : String = "Quote Request"
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("\nUserName: ")
        stringBuffer.append(quoteRequest.getUserName())
        stringBuffer.append("\nProject Info: \n")
        stringBuffer.append(quoteRequest.getProjectInfo())
        stringBuffer.append("\nUser Comments: \n")
        stringBuffer.append(quoteRequest.getUserComments())
        stringBuffer.append("\nBudget: \n")
        stringBuffer.append(quoteRequest.getBudget())
        stringBuffer.append("\nTime Frame: \n")
        stringBuffer.append(quoteRequest.getTimeFrame())
        stringBuffer.append("\nComments: \n")
        stringBuffer.append(quoteRequest.getComments())
        var adminEmailTextBody : String = stringBuffer.toString()
        var basicEmailInfo : BasicEmailInfo = (new StoreEmailInfo(this.storeFrontInterface, adminEmailSubject, adminEmailTextBody)).asInstanceOf[BasicEmailInfo]
        var emailInfo : EmailInfo = new EmailInfo(basicEmailInfo)
        //send request to store admins if subscribed to handler name for review and response
        var storeAdminUserEmailEventHandler : UserEmailEventHandler = AdminUserEmailEventHandlerSingletons.getInstance().getInstance(this.abeClientInformation, UserEmailEventNameData.QUOTEREQUEST)
        var adminUserEmailEventHandler : UserEmailEventHandler = StoreAdminUserEmailEventHandlerSingletons.getInstance().getInstance(UserEmailEventNameData.QUOTEREQUEST, this.abeClientInformation, this.storeFrontInterface)
        storeAdminUserEmailEventHandler.receiveEmailInfo(UserEmailEventNameData.QUOTEREQUEST, emailInfo)
        adminUserEmailEventHandler.receiveEmailInfo(UserEmailEventNameData.QUOTEREQUEST, emailInfo)
    }

    def email() : String = {
        try {
            val quoteRequestEntity : QuoteRequestEntity = QuoteRequestEntityFactory.getInstance().getQuoteRequestEntityInstance()
            val userName : String = this.weblisketSession.getUserName()
            val vector : BasicArrayList = quoteRequestEntity.getIds(userName)
            var id : Int = 0
            //get last quote request
            val size : Int = vector.size()

            {
                var index : Int = 0
                while (index < size) {
                    var nextId : Int = (vector.get(index).asInstanceOf[Integer]).intValue()
                    if (id < nextId) {
                        id = nextId
                    }
                    index += 1
                }
            }
            var quoteRequest : QuoteRequest = quoteRequestEntity.get(userName, id)
            if (quoteRequest != null) {
                this.emailUser(quoteRequest)
                this.emailAdmins(quoteRequest)
                return "Thank You For Your Business.<p/>"
            } else {
                throw new Exception("No Quote Request")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGINGERROR)) {
                    this.logUtil.put(this.commonStrings.FAILURE, this, "email", e)
                }
                return "Thank You For Your Business.<p>"
            }
        }
        throw new IllegalStateException()
    }

    override def drop() : String = {
        try {
            var success : String = QuoteRequestEntityFactory.getInstance().getQuoteRequestEntityInstance().dropTable()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, this.commonStrings.DROP)
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to drop QuoteRequest table"
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
            var success : String = QuoteRequestEntityFactory.getInstance().getQuoteRequestEntityInstance().createTable()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "create()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to create new QuoteRequest table"
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
            val result : String = AbSqlTableUtil.getInstance().restoreTable(QuoteRequestEntityFactory.getInstance().getQuoteRequestEntityInstance(), portion)
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
            val result : String = AbSqlTableUtil.getInstance().backupTable(QuoteRequestEntityFactory.getInstance().getQuoteRequestEntityInstance())
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


