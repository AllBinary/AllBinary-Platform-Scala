/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.init.db

import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

class DbConnectionInfo() extends DatabaseConnectionInfoInterface {

    private var jdbcDriver : String = null

    private var name : String = null

    private var userName : String = null

    private var password : String = null

    private var schema : String = null

    private var server : String = null

    private var port : String = null

    private var url : String = null

    private var host : String = null

    private val SCHEMA_SEP : String = "://"

    private val USER_NAME_KEY : String = "?user="

    private val PASSWORD_KEY : String = "&password="

    private def updateUrl() : Unit = {
        this.updateHost()
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.getHost())
        stringBuffer.append(this.getName())
        stringBuffer.append(this.getUserNameKey())
        stringBuffer.append(this.getUserName())
        stringBuffer.append(this.getPasswordKey())
        stringBuffer.append(this.getPassword())
        this.url = stringBuffer.toString()
    }

    def getUrl() : String = {
        return this.url
    }

    def getJdbcDriver() : String = {
        return this.jdbcDriver
    }

    def getName() : String = {
        return this.name
    }

    def getUserName() : String = {
        return this.userName
    }

    def getPassword() : String = {
        return this.password
    }

    private def updateHost() : Unit = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.getSchema())
        stringBuffer.append(this.SCHEMA_SEP)
        stringBuffer.append(this.getServer())
        if ((this.getPort() != null) && (this.getPort().length() > 1)) {
            stringBuffer.append(CommonSeps.getInstance().COLON)
            stringBuffer.append(this.getPort())
        }
        stringBuffer.append(AbPathData.getInstance().SEPARATOR)
        this.host = stringBuffer.toString()
    }

    def getHost() : String = {
        return this.host
    }

    def getSchema() : String = {
        return this.schema
    }

    def getServer() : String = {
        return this.server
    }

    def getPort() : String = {
        return this.port
    }

    def setJdbcDriver(value : String) : Unit = {
        this.jdbcDriver = value
    }

    def setName(value : String) : Unit = {
        this.name = value
        this.updateUrl()
    }

    def setUserName(value : String) : Unit = {
        this.userName = value
        this.updateUrl()
    }

    def setPassword(value : String) : Unit = {
        this.password = value
        this.updateUrl()
    }

    def setSchema(value : String) : Unit = {
        this.schema = value
        this.updateUrl()
    }

    def setServer(value : String) : Unit = {
        this.server = value
        this.updateUrl()
    }

    def setPort(value : String) : Unit = {
        this.port = value
        this.updateUrl()
    }

    final def getUserNameKey() : String = {
        return this.USER_NAME_KEY
    }

    final def getPasswordKey() : String = {
        return this.PASSWORD_KEY
    }

}


