/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.event

import _root_.java.util.EventObject
import _root_.org.allbinary.logic.communication.smtp.info.EmailInfo
import _root_.org.allbinary.logic.string.StringMaker

class EmailEvent(param_emailEventHandler : Object, param_userEmailEventNameData : UserEmailEventNameData, param_emailInfo : EmailInfo, param_attempts : Int) extends EventObject(param_emailEventHandler) {

    private var emailInfo : EmailInfo = null

    private var userEmailEventNameData : UserEmailEventNameData = null

    private var attempts : Int = 0

    //Constructor
    {
        val emailEventHandler : Object = param_emailEventHandler
        val userEmailEventNameData : UserEmailEventNameData = param_userEmailEventNameData
        val emailInfo : EmailInfo = param_emailInfo
        val attempts : Int = param_attempts
        this.userEmailEventNameData = userEmailEventNameData
        this.emailInfo = emailInfo
    }

    def getEmailInfo() : EmailInfo = {
        return this.emailInfo
    }

    def getAttempts() : Int = {
        return this.attempts
    }

    def setAttempts(attempts : Int) : Unit = {
        this.attempts = attempts
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("EmailEvent Log: \n")
        stringBuffer.append("Event Name: ")
        stringBuffer.append(this.userEmailEventNameData.toString())
        stringBuffer.append(this.getEmailInfo().toString())
        stringBuffer.append("\nNumber of Attempts: ")
        stringBuffer.appendint(this.getAttempts())
        return stringBuffer.toString()
    }

}


