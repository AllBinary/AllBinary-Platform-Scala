/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.info

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.smtp.configuration.server.EmailServerConfigurationInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

class BasicEmailInfo(param_subject : String, param_textBody : String) {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var subject : String = null

    private var textBody : String = null

    var emailServerConfigurationInterface : EmailServerConfigurationInterface = null

    //Constructor
    {
        val subject : String = param_subject
        val textBody : String = param_textBody
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            this.logUtil.putF(commonStrings.START, this, commonStrings.CONSTRUCTOR)
        }
        this.subject = subject
        this.textBody = textBody
    }

    def getSubject() : String = {
        return this.subject
    }

    def getTextBody() : String = {
        return this.textBody
    }

    def getEmailServerConfigurationInterface() : EmailServerConfigurationInterface = {
        return this.emailServerConfigurationInterface
    }

    def setEmailServerConfigurationInterface(emailServerConfigurationInterface : EmailServerConfigurationInterface) : Unit = {
        this.emailServerConfigurationInterface = emailServerConfigurationInterface
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.getEmailServerConfigurationInterface().toString())
        stringBuffer.append(CommonSeps.getInstance().NEW_LINE)
        stringBuffer.append("Subject: \n")
        stringBuffer.append(this.getSubject())
        stringBuffer.append("\nText Body: \n")
        stringBuffer.append(this.getTextBody())
        return stringBuffer.toString()
    }

    def init() : Unit = {
        throw new RuntimeException()
    }

}


