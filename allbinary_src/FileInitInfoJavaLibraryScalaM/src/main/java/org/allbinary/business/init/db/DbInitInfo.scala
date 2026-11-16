/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.business.init.db

import _root_.org.allbinary.globals.FREEBLISKET_PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.http.HttpData
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes
import _root_.org.allbinary.logic.io.AbDataInputStream
import _root_.org.allbinary.logic.io.AbDataOutputStream
import _root_.org.allbinary.logic.io.AbFileInputStream
import _root_.org.allbinary.logic.io.DataOutputStreamFactory
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.directory.Directory
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.security.crypt.DatabaseEncoder
import _root_.org.allbinary.logic.system.security.crypt.WeakCrypt
import _root_.org.allbinary.string.CommonStrings

class DbInitInfo(param_initFileName : String, param_read : Boolean) extends DbConnectionInfo() {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val directory : Directory = Directory.getInstance()

    private val httpData : HttpData = HttpData.getInstance()

    private val GET_URL : String = "getUrl"

    //private final String PACKAGE = "/allbinary/ecommerce/init/db/";
    private val PACKAGE : String = FREEBLISKET_PATH_GLOBALS.getInstance().DBINITPATH

    private var initFileName : String = null

    private var hasRead : Boolean = false

    //read argument is off for installation only
    //Constructor
    {
        val initFileName : String = param_initFileName
        val read : Boolean = param_read
        this.initFileName = initFileName
        if (read) {
            this.updateIfNeeded()
        } else {
            this.setHasRead(true)
        }
    }

    override def getUrl() : String = {
        var url : String = super.getUrl()
        //this.getPasswordKey() + this.getPassword();
        if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADER)) {
            PreLogUtil.put(this.httpData.URL_LABEL + url, this, GET_URL)
        }
        return url
    }

    def write() : Unit = {
        val PATH : AbPath = new AbPath(URLGLOBALS.getWebappPath() + this.PACKAGE, StringUtil.getInstance().EMPTY_STRING)
        this.directory.create(PATH)
        val FILEABPATH : AbPath = new AbPath(URLGLOBALS.getWebappPath() + this.PACKAGE, this.initFileName)
        try {
            val newFile : AbFile = AbFile.createAbFileFromAbPath(FILEABPATH)
            newFile.createNewFile()
            //PreLogUtil.put("Host: " + this.getHost(), this, "write");
            val dataOutputStream : AbDataOutputStream = DataOutputStreamFactory.getInstance().getInstanceForAbFile(newFile)
            try {
                val cryptedJdbcDriver : Array[Byte] = new WeakCrypt(1).encrypt(this.getJdbcDriver()).getBytes()
                val cryptedName : Array[Byte] = new WeakCrypt(2).encrypt(this.getName()).getBytes()
                val cryptedUserName : Array[Byte] = new WeakCrypt(3).encrypt(this.getUserName()).getBytes()
                val cryptedPassword : Array[Byte] = new WeakCrypt(4).encrypt(this.getPassword()).getBytes()
                val cryptedSchema : Array[Byte] = new WeakCrypt(5).encrypt(this.getSchema()).getBytes()
                val cryptedServer : Array[Byte] = new WeakCrypt(6).encrypt(this.getServer()).getBytes()
                val cryptedPort : Array[Byte] = new WeakCrypt(7).encrypt(this.getPort()).getBytes()
                dataOutputStream.writeUTF(DatabaseEncoder.encode(cryptedJdbcDriver))
                dataOutputStream.writeUTF(DatabaseEncoder.encode(cryptedName))
                dataOutputStream.writeUTF(DatabaseEncoder.encode(cryptedUserName))
                dataOutputStream.writeUTF(DatabaseEncoder.encode(cryptedPassword))
                dataOutputStream.writeUTF(DatabaseEncoder.encode(cryptedSchema))
                dataOutputStream.writeUTF(DatabaseEncoder.encode(cryptedServer))
                dataOutputStream.writeUTF(DatabaseEncoder.encode(cryptedPort))
                this.hasRead = false
            } finally {
                StreamUtil.getInstance().close(dataOutputStream)
            }
        } catch {
            case e : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADERERROR)) {
                    PreLogUtil.putOE("Failed Write: " + FILEABPATH.toString(), this, "write", e)
                }
            }
        }
    }

    private def load() : Unit = {
        val FILEABPATH : AbPath = new AbPath(URLGLOBALS.getWebappPath() + this.PACKAGE, this.initFileName)
        try {
            val file : AbFile = AbFile.createAbFileFromAbPath(FILEABPATH)
            if (file.isFile()) {
                val iFile : AbFileInputStream = AbFileInputStream.createFromAbFile(file)
                val iData : AbDataInputStream = new AbDataInputStream(iFile)
                try {
                    val decryptedJdbcDriver : String = new String(DatabaseEncoder.decode(iData.readUTF()))
                    val decryptedName : String = new String(DatabaseEncoder.decode(iData.readUTF()))
                    val decryptedUserName : String = new String(DatabaseEncoder.decode(iData.readUTF()))
                    val decryptedPassword : String = new String(DatabaseEncoder.decode(iData.readUTF()))
                    val decryptedSchema : String = new String(DatabaseEncoder.decode(iData.readUTF()))
                    val decryptedServer : String = new String(DatabaseEncoder.decode(iData.readUTF()))
                    val decryptedPort : String = new String(DatabaseEncoder.decode(iData.readUTF()))
                    this.setJdbcDriver(new WeakCrypt(1).decrypt(decryptedJdbcDriver))
                    this.setName(new WeakCrypt(2).decrypt(decryptedName))
                    this.setUserName(new WeakCrypt(3).decrypt(decryptedUserName))
                    this.setPassword(new WeakCrypt(4).decrypt(decryptedPassword))
                    this.setSchema(new WeakCrypt(5).decrypt(decryptedSchema))
                    this.setServer(new WeakCrypt(6).decrypt(decryptedServer))
                    this.setPort(new WeakCrypt(7).decrypt(decryptedPort))
                    val stringUtil : StringUtil = StringUtil.getInstance()
                } finally {
                    StreamUtil.getInstance().close(iData)
                }
            } else {
                this.hasRead = false
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADER)) {
                    PreLogUtil.put("Not a File - Failed Loading: " + FILEABPATH.toString(), this, this.commonStrings.LOAD)
                }
            }
        } catch {
            case e : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADERERROR)) {
                    PreLogUtil.putOE("Failed Loading: " + FILEABPATH.toString(), this, this.commonStrings.LOAD, e)
                }
            }
        }
    }

    def setHasRead(value : Boolean) : Unit = {
        this.hasRead = value
    }

    private def updateIfNeeded() : Unit = {
        try {
            if (!this.hasRead) {
                this.hasRead = true
                this.load()
            }
        } catch {
            case e : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADERERROR)) {
                    PreLogUtil.putOE(this.commonStrings.EXCEPTION, this, "updateIfNeeded", e)
                }
            }
        }
    }

    override def getName() : String = {
        this.updateIfNeeded()
        if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADER)) {
            PreLogUtil.put("Name: " + super.getName(), this, "getName")
        }
        return super.getName()
    }

    override def getUserName() : String = {
        this.updateIfNeeded()
        if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADER)) {
            PreLogUtil.put("Name: " + super.getUserName(), this, "getUserName")
        }
        return super.getUserName()
    }

    override def getPassword() : String = {
        this.updateIfNeeded()
        return super.getPassword()
    }

    override def getSchema() : String = {
        this.updateIfNeeded()
        return super.getSchema()
    }

    override def getServer() : String = {
        this.updateIfNeeded()
        return super.getServer()
    }

    override def getPort() : String = {
        this.updateIfNeeded()
        return super.getPort()
    }

}


