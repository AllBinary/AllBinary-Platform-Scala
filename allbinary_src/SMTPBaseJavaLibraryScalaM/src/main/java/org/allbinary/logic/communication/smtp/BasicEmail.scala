/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp

import _root_.java.util.HashMap
import _root_.javax.mail.internet.MimeMessage
import _root_.org.allbinary.logic.communication.smtp.info.BasicEmailInfo
import _root_.org.allbinary.logic.communication.smtp.info.EmailInfo
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class BasicEmail(param_emailInfo : EmailInfo, param_to : String) extends EmailInterface {

    private var email : AbEmail = null

    //Constructor
    {
        val emailInfo : EmailInfo = param_emailInfo
        val to : String = param_to
        var basicEmailInfo : BasicEmailInfo = emailInfo.getBasicEmailInfo()
        this.email = new AbEmail(basicEmailInfo.getEmailServerConfigurationInterface().getSmtpServer(), basicEmailInfo.getEmailServerConfigurationInterface().getAccountName(), to, basicEmailInfo.getSubject(), basicEmailInfo.getTextBody(), emailInfo.getHtmlAttachment(), emailInfo.getContentBase())
    }

    def getEmail() : Email = {
        return this.email.getEmail().asInstanceOf[Email]
    }

    def getMimeMessage() : MimeMessage = {
        return this.email.getMimeMessage()
    }

    def getDebugInfo() : String = {
        return this.email.getDebugInfo()
    }

    def log() : String = {
        return this.email.log()
    }

    def toHashMap() : HashMap[Object, Object] = {
        return this.email.toHashMap()
    }

    def toXmlNode(document : Document) : Node = {
        return this.email.toXmlNode(document)
    }

    def toXmlDoc() : Document = {
        return this.email.toXmlDoc()
    }

}


