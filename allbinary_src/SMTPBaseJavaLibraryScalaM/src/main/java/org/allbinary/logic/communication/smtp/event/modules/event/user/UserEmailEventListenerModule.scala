/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.event.modules.event.user

import _root_.org.allbinary.business.user.UserInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.smtp.BasicEmail
import _root_.org.allbinary.logic.communication.smtp.EmailInterface
import _root_.org.allbinary.logic.communication.smtp.event.EmailEvent
import _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventListenerInterface
import _root_.org.allbinary.logic.communication.smtp.queue.EmailQueueFactory

class UserEmailEventListenerModule(param_userInterface : UserInterface) extends UserEmailEventListenerInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var userInterface : UserInterface = null

    //Constructor
    {
        val userInterface : UserInterface = param_userInterface
        this.userInterface = userInterface
    }

    //Recieves the same email event that was sent when a error occurs
    def onEmailSendFailure(emailEvent : EmailEvent) : Unit = {
        //Change the destination address errored
        var to : String = this.userInterface.getSecondaryEmail()
        //Future Imp - Change smtp server if server failed to send
        var email : BasicEmail = new BasicEmail(emailEvent.getEmailInfo(), to)
        EmailQueueFactory.getInstance().offer(email.getEmail().asInstanceOf[EmailInterface])
    }

    def onEmailSendRequest(emailEvent : EmailEvent) : Unit = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            this.logUtil.putF("Add Email To Que For Sending: " + emailEvent.toString(), this, "onEmailSendRequest")
        }
        var to : String = this.userInterface.getMainEmail()
        var email : BasicEmail = new BasicEmail(emailEvent.getEmailInfo(), to)
        EmailQueueFactory.getInstance().offer(email.getEmail().asInstanceOf[EmailInterface])
    }

}


