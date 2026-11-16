/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.event.handler

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.smtp.event.EmailEvent
import _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventListenerInterface
import _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData
import _root_.org.allbinary.logic.communication.smtp.info.EmailInfo

class UserEmailEventHandler() {

    private var emailVector : BasicArrayList = null

    private var emailInfo : EmailInfo = null

    private var userEmailEventNameData : UserEmailEventNameData = null

    //Constructor
    {
        this.emailVector = new BasicArrayListD()
    }

    def receiveEmailInfo(userEmailEventNameData : UserEmailEventNameData, emailInfo : EmailInfo) : Unit = this.synchronized {
        this.userEmailEventNameData = userEmailEventNameData
        this.emailInfo = emailInfo
        this.fireEmailEvent()
    }

    def addListener(vector : BasicArrayList) : Unit = this.synchronized {
        val size : Int = vector.size()

        {
            var index : Int = 0
            while (index < size) {
                var userEmailEventListenerInterface : UserEmailEventListenerInterface = vector.get(index).asInstanceOf[UserEmailEventListenerInterface]
                this.addListener(userEmailEventListenerInterface)
                index += 1
            }
        }
    }

    def addListener(emailEventListenerInterface : UserEmailEventListenerInterface) : Unit = this.synchronized {
        this.emailVector.add(emailEventListenerInterface)
    }

    def removeListener(emailEventListenerInterface : UserEmailEventListenerInterface) : Unit = this.synchronized {
        this.emailVector.remove(emailEventListenerInterface)
    }

    def fireEmailEvent() : Unit = this.synchronized {
        var emailEvent : EmailEvent = new EmailEvent(this, this.userEmailEventNameData, this.emailInfo, 0)
        val size : Int = this.emailVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var emailEventListenerInterface : UserEmailEventListenerInterface = this.emailVector.get(index).asInstanceOf[UserEmailEventListenerInterface]
                emailEventListenerInterface.onEmailSendRequest(emailEvent)
                index += 1
            }
        }
    }

}


