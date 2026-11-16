/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp

import _root_.java.util.HashMap
import _root_.javax.mail.internet.MimeMessage
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class AbEmail(param_server : String, param_from : String, param_to : String, param_subject : String, param_textBody : String, param_htmlAttachment : String, param_contentBase : String) extends EmailInterface {

    private var email : Email = null

    //Constructor
    {
        val server : String = param_server
        val from : String = param_from
        val to : String = param_to
        val subject : String = param_subject
        val textBody : String = param_textBody
        val htmlAttachment : String = param_htmlAttachment
        val contentBase : String = param_contentBase
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGINGERROR)) {
            this.email = new Email(from, to, subject, server, textBody, htmlAttachment, contentBase, true)
        } else {
            this.email = new Email(from, to, subject, server, textBody, htmlAttachment, contentBase)
        }
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

    def getEmail() : Email = {
        return this.email.asInstanceOf[Email]
    }

    def toXmlDoc() : Document = {
        return this.email.toXmlDoc()
    }

}


