/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.email

import _root_.org.allbinary.business.user.UserInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData
import _root_.org.allbinary.logic.communication.smtp.event.handler.UserEmailEventHandler
import _root_.org.allbinary.logic.communication.smtp.event.handler.factory.AdminUserEmailEventHandlerSingletons
import _root_.org.allbinary.logic.communication.smtp.event.handler.factory.UserEmailEventHandlerSingletons
import _root_.org.allbinary.logic.communication.smtp.info.AdminEmailInfo
import _root_.org.allbinary.logic.communication.smtp.info.BasicEmailInfo
import _root_.org.allbinary.logic.communication.smtp.info.EmailInfo
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.string.CommonStrings

class NewPasswordEmail(param_abeClientInformation : AbeClientInformationInterface, param_userInterface : UserInterface, param_newPassword : String) {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var abeClientInformation : AbeClientInformationInterface = null

    private var userInterface : UserInterface = null

    private var newPassword : String = null

    //Constructor
    {
        val abeClientInformation : AbeClientInformationInterface = param_abeClientInformation
        val userInterface : UserInterface = param_userInterface
        val newPassword : String = param_newPassword
        this.abeClientInformation = abeClientInformation
        this.userInterface = userInterface
        this.newPassword = newPassword
    }

    def process() : Unit = {
        this.notifyStoreAdmin()
        this.notifyUser()
    }

    private def notifyStoreAdmin() : Unit = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
                this.logUtil.putF("notifyStoreAdmin", this, "notifyStoreAdmin")
            }
            var emailSubject : String = "New Password For User: " + this.userInterface.getUserName()
            var emailBody : String = "New Password: " + this.newPassword
            var basicEmailInfo : BasicEmailInfo = (new AdminEmailInfo(emailSubject, emailBody)).asInstanceOf[BasicEmailInfo]
            //EmailInfo storeAdminEmailInfo = new EmailInfo(storeAdminBasicEmailInfo);
            var emailInfo : EmailInfo = new EmailInfo(basicEmailInfo)
            //Send response to Admin(s)
            var adminUserEmailEventHandler : UserEmailEventHandler = AdminUserEmailEventHandlerSingletons.getInstance().getInstance(this.abeClientInformation, UserEmailEventNameData.NEWPASSWORD)
            //storeAdminUserEmailEventHandler.receiveEmailInfo(emailInfo);
            adminUserEmailEventHandler.receiveEmailInfo(UserEmailEventNameData.NEWPASSWORD, emailInfo)
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
            var subject : String = "New Password"
            var body : String = "New Password: " + this.newPassword
            /*          BasicEmailInfo basicEmailInfo = (BasicEmailInfo)             new StoreEmailInfo(this.storeFrontInterface, subject, body);          */
            var basicEmailInfo : BasicEmailInfo = (new AdminEmailInfo(subject, body)).asInstanceOf[BasicEmailInfo]
            var emailInfo : EmailInfo = new EmailInfo(basicEmailInfo)
            var userEmailEventHandler : UserEmailEventHandler = UserEmailEventHandlerSingletons.getInstance().getInstance(this.abeClientInformation, UserEmailEventNameData.NEWPASSWORD, this.userInterface)
            userEmailEventHandler.receiveEmailInfo(UserEmailEventNameData.NEWPASSWORD, emailInfo)
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


