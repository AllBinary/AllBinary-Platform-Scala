/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.configuration.server


trait EmailServerConfigurationInterface {

    def setSmtpServer(value : String) : Unit

    def getSmtpServer() : String

    def getAccountName() : String

    def setAccountName(accountName : String) : Unit

    def getPassword() : String

    def setPassword(password : String) : Unit

    def log() : Unit

    override def toString() : String

}


