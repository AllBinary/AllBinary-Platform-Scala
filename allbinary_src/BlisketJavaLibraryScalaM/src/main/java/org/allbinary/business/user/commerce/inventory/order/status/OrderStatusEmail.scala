/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.order.status

import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.UserInterface
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistory
import _root_.org.allbinary.data.tables.user.UserEntityFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData
import _root_.org.allbinary.logic.communication.smtp.event.handler.UserEmailEventHandler
import _root_.org.allbinary.logic.communication.smtp.event.handler.factory.AdminUserEmailEventHandlerSingletons
import _root_.org.allbinary.logic.communication.smtp.event.handler.factory.StoreAdminUserEmailEventHandlerSingletons
import _root_.org.allbinary.logic.communication.smtp.event.handler.factory.UserEmailEventHandlerSingletons
import _root_.org.allbinary.logic.communication.smtp.info.AdminEmailInfo
import _root_.org.allbinary.logic.communication.smtp.info.BasicEmailInfo
import _root_.org.allbinary.logic.communication.smtp.info.EmailInfo
import _root_.org.allbinary.logic.communication.smtp.info.StoreEmailInfo
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.string.CommonStrings

class OrderStatusEmail(param_abeClientInformation : AbeClientInformationInterface, param_orderHistory : OrderHistory) {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var abeClientInformation : AbeClientInformationInterface = null

    private var orderHistory : OrderHistory = null

    private var storeFrontInterface : StoreFrontInterface = null

    private var user : UserInterface = null

    /* import org.allbinary.business.user.commerce.inventory.order.OrderHistoryData;       OrderHistoryData.PREPROCESSING       OrderHistoryData.PROCESSING        OrderHistoryData.PARTIALLYSHIPPED       OrderHistoryData.CANCELLED       OrderHistoryData.SHIPPED  **/
    //Constructor
    {
        val abeClientInformation : AbeClientInformationInterface = param_abeClientInformation
        val orderHistory : OrderHistory = param_orderHistory
        this.abeClientInformation = abeClientInformation
        this.orderHistory = orderHistory
        var storeName : String = orderHistory.getStoreName()
        this.storeFrontInterface = StoreFrontFactory.getInstance(storeName)
        this.user = UserEntityFactory.getInstance().getUser(orderHistory.getUserName())
    }

    def process() : Unit = {
        this.notifyStoreAdmin()
        this.notifyUser()
    }

    private def notifyStoreAdmin() : Unit = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
                this.logUtil.putF("Order Email", this, "emailStoreAdmin")
            }
            var adminEmailSubject : String = ("Order " + this.orderHistory.getStatus()) + " Attempt"
            var adminEmailTextBody : String = (("Order attempt: " + this.orderHistory.getId()) + " Preprocessing by: ") + this.user.getUserName()
            var adminBasicEmailInfo : BasicEmailInfo = (new AdminEmailInfo(adminEmailSubject, adminEmailTextBody)).asInstanceOf[BasicEmailInfo]
            var storeAdminBasicEmailInfo : BasicEmailInfo = (new StoreEmailInfo(this.storeFrontInterface, adminEmailSubject, adminEmailTextBody)).asInstanceOf[BasicEmailInfo]
            var storeAdminEmailInfo : EmailInfo = new EmailInfo(storeAdminBasicEmailInfo)
            var adminEmailInfo : EmailInfo = new EmailInfo(adminBasicEmailInfo)
            var userEmailEventNameData : UserEmailEventNameData = UserEmailEventNameData.getInstance(this.orderHistory.getStatus())
            //Send response to Admin(s)
            var adminUserEmailEventHandler : UserEmailEventHandler = AdminUserEmailEventHandlerSingletons.getInstance().getInstance(this.abeClientInformation, userEmailEventNameData)
            var storeAdminUserEmailEventHandler : UserEmailEventHandler = StoreAdminUserEmailEventHandlerSingletons.getInstance().getInstance(userEmailEventNameData, this.abeClientInformation, this.storeFrontInterface)
            storeAdminUserEmailEventHandler.receiveEmailInfo(userEmailEventNameData, storeAdminEmailInfo)
            adminUserEmailEventHandler.receiveEmailInfo(userEmailEventNameData, adminEmailInfo)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGINGERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "emailAdmin", e)
                }
            }
        }
    }

    ///String subject, String textBody
    private def notifyUser() : Unit = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
                this.logUtil.putF("Email User", this, "notifyUser()")
            }
            var subject : String = ("Order " + this.orderHistory.getStatus()) + " Attempt"
            var textBody : String = (("Order attempt: " + this.orderHistory.getId()) + " Preprocessing by: ") + this.user.getUserName()
            var basicEmailInfo : BasicEmailInfo = (new StoreEmailInfo(this.storeFrontInterface, subject, textBody)).asInstanceOf[BasicEmailInfo]
            var emailInfo : EmailInfo = new EmailInfo(basicEmailInfo)
            var userEmailEventNameData : UserEmailEventNameData = UserEmailEventNameData.getInstance(this.orderHistory.getStatus())
            var userEmailEventHandler : UserEmailEventHandler = UserEmailEventHandlerSingletons.getInstance().getInstance(this.abeClientInformation, userEmailEventNameData, this.user)
            userEmailEventHandler.receiveEmailInfo(userEmailEventNameData, emailInfo)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGINGERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "notifyUser", e)
                }
                throw e
            }
        }
    }

}


