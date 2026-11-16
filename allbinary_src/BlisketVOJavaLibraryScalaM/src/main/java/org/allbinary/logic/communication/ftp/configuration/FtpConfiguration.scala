/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.ftp.configuration

import _root_.java.util.HashMap

class FtpConfiguration() extends FtpConfigurationInterface {

    private var ftpServer : String = null

    private var ftpPath : String = null

    private var ftpUserName : String = null

    private var ftpPassword : String = null

    def this(hashMap : HashMap[Object, Object]) = {
        this()
        this.ftpServer = hashMap.get(FtpConfigurationData.SERVER).asInstanceOf[String]
        this.ftpPath = hashMap.get(FtpConfigurationData.PATH).asInstanceOf[String]
        this.ftpUserName = hashMap.get(FtpConfigurationData.USERNAME).asInstanceOf[String]
        this.ftpPassword = hashMap.get(FtpConfigurationData.PASSWORD).asInstanceOf[String]
    }

    def getServer() : String = {
        return this.ftpServer
    }

    def getPath() : String = {
        return this.ftpPath
    }

    def getUserName() : String = {
        return this.ftpUserName
    }

    def getPassword() : String = {
        return this.ftpPassword
    }

    def setServer(value : String) : Unit = {
        this.ftpServer = value
    }

    def setPath(value : String) : Unit = {
        this.ftpPath = value
    }

    def setUserName(value : String) : Unit = {
        this.ftpUserName = value
    }

    def setPassword(value : String) : Unit = {
        this.ftpPassword = value
    }

}


