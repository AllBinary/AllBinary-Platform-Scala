/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.configuration.server

import _root_.java.util.HashMap
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings

class EmailServerConfiguration() extends EmailServerConfigurationInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var accountName : String = null

    private var password : String = null

    private var smtpServer : String = null

    //Constructor
    {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            this.logUtil.putF(commonStrings.START, this, commonStrings.CONSTRUCTOR)
        }
        this.setSmtpServer(StringUtil.getInstance().EMPTY_STRING)
    }

    def this(account : String, password : String, server : String) = {
        this()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            this.logUtil.putF(commonStrings.START, this, "EmailServerConfiguration(HashMap)")
        }
        this.setAccountName(account)
        this.setPassword(password)
        this.setSmtpServer(server)
        this.log()
    }

    def this(hashMap : HashMap[Object, Object]) = {
        this()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            this.logUtil.putF(commonStrings.START, this, "EmailServerConfiguration(HashMap)")
        }
        this.setAccountName(hashMap.get(EmailServerConfigurationData.ACCOUNT).asInstanceOf[String])
        this.setPassword(hashMap.get(EmailServerConfigurationData.PASSWORD).asInstanceOf[String])
        this.setSmtpServer(hashMap.get(EmailServerConfigurationData.SERVER).asInstanceOf[String])
        this.log()
    }

    def setSmtpServer(value : String) : Unit = {
        this.smtpServer = value
    }

    def getSmtpServer() : String = {
        return this.smtpServer
    }

    def getAccountName() : String = {
        return this.accountName
    }

    def setAccountName(accountName : String) : Unit = {
        this.accountName = accountName
    }

    def getPassword() : String = {
        return this.password
    }

    def setPassword(password : String) : Unit = {
        this.password = password
    }

    def log() : Unit = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            this.logUtil.putF(this.toString(), this, "EmailServerConfiguration")
        }
    }

    override def toString() : String = {
        return ((((("Email Server Configuration:\n" + "Smtp Server: \n") + this.getSmtpServer()) + "\nAccount Name: ") + this.getAccountName()) + "\nPassword: ") + this.getPassword()
    }

}


