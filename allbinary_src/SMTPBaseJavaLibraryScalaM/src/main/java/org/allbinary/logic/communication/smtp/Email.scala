/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp

import _root_.java.io.ByteArrayOutputStream
import _root_.java.io.PrintStream
import _root_.java.util.HashMap
import _root_.java.util.Properties
import _root_.javax.mail.Address
import _root_.javax.mail.Authenticator
import _root_.javax.mail.Message
import _root_.javax.mail.MessagingException
import _root_.javax.mail.Session
import _root_.javax.mail.internet.InternetAddress
import _root_.javax.mail.internet.InternetHeaders
import _root_.javax.mail.internet.MimeBodyPart
import _root_.javax.mail.internet.MimeMessage
import _root_.javax.mail.internet.MimeMultipart
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class Email private () extends EmailInterface {
    import _root_.org.allbinary.logic.communication.smtp.Email.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var msg : MimeMessage = null

    private var properties : Properties = null

    private var bs : ByteArrayOutputStream = null

    private var isDebug : Boolean = false

    def this(from : String, to : String, subject : String, server : String, textBody : String, htmlAttachment : String, contentBase : String, isDebug : Boolean) = {
        this()
        this.isDebug = isDebug
        this.init(from, to, subject, server, textBody, htmlAttachment, contentBase)
    }

    def this(from : String, to : String, subject : String, server : String, textBody : String, htmlAttachment : String, contentBase : String) = {
        this()
        this.isDebug = false
        this.init(from, to, subject, server, textBody, htmlAttachment, contentBase)
    }

    def init(from : String, to : String, subject : String, server : String, textBody : String, htmlAttachment : String, contentBase : String) : Unit = {
        try {
            var stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
            var mimeBodyParts : Array[MimeBodyPart] = new Array[MimeBodyPart]((if (!stringValidationUtil.isEmpty(htmlAttachment)) 2 else 1))
            mimeBodyParts(0) = new MimeBodyPart()
            mimeBodyParts(0).setText(textBody)
            if (!stringValidationUtil.isEmpty(htmlAttachment)) {
                var internetHeaders : InternetHeaders = new InternetHeaders()
                internetHeaders.addHeader("Content-Type", "text/html")
                if (!stringValidationUtil.isEmpty(contentBase)) {
                    internetHeaders.addHeader("Content-Base", contentBase)
                }
                mimeBodyParts(1) = new MimeBodyPart(internetHeaders, htmlAttachment.getBytes())
            }
            this.init(server, (null).asInstanceOf[Authenticator], Array[InternetAddress](new InternetAddress(from)), Array[InternetAddress](new InternetAddress(to)), (null).asInstanceOf[Array[InternetAddress]], (null).asInstanceOf[Array[InternetAddress]], subject, mimeBodyParts)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGINGERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(commonStrings.EXCEPTION, this, "emailConstructor", e)
                }
                throw e
            }
        }
    }

    def init(server : String, authenticator : Authenticator, addresses_from : Array[InternetAddress], addresses_to : Array[InternetAddress], addresses_cc : Array[InternetAddress], addresses_bcc : Array[InternetAddress], subject : String, mimeBodyParts : Array[MimeBodyPart]) : Unit = {
        this.properties = new Properties()
        this.properties.put(Email.SMTP_HOST, server)
        try {
            var hostName : String = StringUtil.getInstance().EMPTY_STRING
            //InetAddress.getLocalHost().getHostName();
            if (StringValidationUtil.getInstance().isEmpty(hostName)) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGINGERROR)) {
                    this.logUtil.putF("Unable to get HostName so using fake", this, "init()")
                }
                this.properties.put(Email.SMTP_LOCAL_HOST, "FakeHostName")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGINGERROR)) {
                    this.logUtil.put("Continuing on Exception: Unable to get HostName", this, "init()", e)
                }
                this.properties.put(Email.SMTP_LOCAL_HOST, "FakeHostName")
            }
        }
        if (this.isDebug) {
            this.properties.put(Email.DEBUG, "true")
        }
        var session : Session = Session.getInstance(this.properties, authenticator)
        if (this.isDebug) {
            session.setDebug(true)
            this.bs = new ByteArrayOutputStream()
            var printStream : PrintStream = new PrintStream(this.bs)
            session.setDebugOut(printStream)
        }
        this.msg = new MimeMessage(session)
        this.msg.addFrom(addresses_from.asInstanceOf[Array[Address]])
        this.msg.setRecipients(Message.RecipientType.TO, addresses_to.asInstanceOf[Array[Address]])
        this.msg.setRecipients(Message.RecipientType.CC, addresses_cc.asInstanceOf[Array[Address]])
        this.msg.setRecipients(Message.RecipientType.BCC, addresses_bcc.asInstanceOf[Array[Address]])
        this.msg.setSubject(subject)
        var mimeMultipart : MimeMultipart = new MimeMultipart()

        {
            var i : Int = 0
            while (i < mimeBodyParts.length) {
                mimeMultipart.addBodyPart(mimeBodyParts(i))
                i += 1
            }
        }
        this.msg.setContent(mimeMultipart)
    }

    def getMimeMessage() : MimeMessage = {
        return this.msg
    }

    def getDebugInfo() : String = {
        if (this.isDebug) {
            //"Size: " + bs.size()
            return "More Logging Before This To Standard Out: " + new String(this.bs.toString())
        } else {
            return "Debugging Is Off"
        }
        throw new IllegalStateException()
    }

    def log() : String = {
        return "\nHashMap: " + this.toHashMap().toString()
    }

    def toHashMap() : HashMap[Object, Object] = {
        try {
            var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            hashMap.put(EmailData.SERVER, this.properties.get(Email.SMTP_HOST).asInstanceOf[String])
            var addresses : Array[Address] = this.msg.getFrom()
            if (addresses != null) {

                {
                    var index : Int = 0
                    while (index < addresses.length) {
                        hashMap.put(EmailData.FROM, addresses(index).toString())
                        index += 1
                    }
                }
            }
            addresses = this.msg.getRecipients(Message.RecipientType.TO)
            if (addresses != null) {

                {
                    var index : Int = 0
                    while (index < addresses.length) {
                        hashMap.put(EmailData.TO, addresses(index).toString())
                        index += 1
                    }
                }
            }
            addresses = this.msg.getRecipients(Message.RecipientType.CC)
            if (addresses != null) {

                {
                    var index : Int = 0
                    while (index < addresses.length) {
                        hashMap.put(EmailData.CC, addresses(index).toString())
                        index += 1
                    }
                }
            }
            addresses = this.msg.getRecipients(Message.RecipientType.BCC)
            if (addresses != null) {

                {
                    var index : Int = 0
                    while (index < addresses.length) {
                        hashMap.put(EmailData.BCC, addresses(index).toString())
                        index += 1
                    }
                }
            }
            hashMap.put(EmailData.SUBJECT, this.msg.getSubject())
            var mimeMultipart : MimeMultipart = msg.getContent().asInstanceOf[MimeMultipart]
            if (mimeMultipart != null) {

                {
                    var index : Int = 0
                    while (index < mimeMultipart.getCount()) {
                        var content : String = mimeMultipart.getBodyPart(index).getContent().asInstanceOf[String]
                        hashMap.put(EmailData.CONTENT, content)
                        index += 1
                    }
                }
            }
            return hashMap
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGINGERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "toHashMap()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def toXmlNode(document : Document) : Node = {
        val node : Node = ModDomHelper.createNameValueNodes(document, EmailData.NAME, this.toHashMap())
        return node
    }

    def toXmlDoc() : Document = {
        throw new Exception(CommonStrings.getInstance().NOT_IMPLEMENTED)
    }

}

object Email {
    private val DEBUG : String = "mail.debug"

    private val SMTP_HOST : String = "mail.smtp.host"

    private val SMTP_PORT : String = "mail.smtp.port"

    private val SMTP_USER : String = "mail.smtp.user"

    private val SMTP_RETURN_ADDRESS : String = "mail.from"

    //Used for HELO
    private val SMTP_LOCAL_HOST : String = "mail.smtp.localhost"

}


