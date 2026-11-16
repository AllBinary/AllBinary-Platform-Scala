/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.init

import _root_.org.allbinary.globals.PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.AbDataInputStream
import _root_.org.allbinary.logic.io.AbDataOutputStream
import _root_.org.allbinary.logic.io.AbFileLocalInputStream
import _root_.org.allbinary.logic.io.DataOutputStreamFactory
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.security.crypt.DatabaseEncoder
import _root_.org.allbinary.logic.system.security.crypt.WeakCrypt

class InstallerInfo() {
    import _root_.org.allbinary.business.init.InstallerInfo.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def write() : Unit = this.synchronized {
        var FILEABPATH : AbPath = new AbPath(URLGLOBALS.getMainPath() + InstallerInfo.PACKAGE, InstallerInfo.INITFILENAME)
        try {
            var newFile : AbFile = AbFile.createAbFileFromAbPath(FILEABPATH)
            newFile.createNewFile()
            var dataOutputStream : AbDataOutputStream = DataOutputStreamFactory.getInstance().getInstanceForAbFile(newFile)
            var cryptedUserName : Array[Byte] = new WeakCrypt(1).encrypt(this.getUserName()).getBytes()
            var cryptedPassword : Array[Byte] = new WeakCrypt(2).encrypt(this.getPassword()).getBytes()
            dataOutputStream.writeUTF(DatabaseEncoder.encode(cryptedUserName))
            dataOutputStream.writeUTF(DatabaseEncoder.encode(cryptedPassword))
            InstallerInfo.hasRead = false
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PRELOADERERROR)) {
                    this.logUtil.putF("Failed", this, "write")
                }
                throw e
            }
        }
    }

    private def read() : Unit = this.synchronized {
        var FILEABPATH : AbPath = new AbPath(URLGLOBALS.getMainPath() + InstallerInfo.PACKAGE, InstallerInfo.INITFILENAME)
        try {
            var file : AbFile = AbFile.createAbFileFromAbPath(FILEABPATH)
            if (file.isFile()) {
                var iFile : AbFileLocalInputStream = new AbFileLocalInputStream(file)
                var iData : AbDataInputStream = new AbDataInputStream(iFile)
                var decryptedUserName : String = new String(DatabaseEncoder.decode(iData.readUTF()))
                var decryptedPassword : String = new String(DatabaseEncoder.decode(iData.readUTF()))
                this.setUserName(new WeakCrypt(1).decrypt(decryptedUserName))
                this.setPassword(new WeakCrypt(2).decrypt(decryptedPassword))
            } else {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PRELOADER)) {
                    this.logUtil.putF("Not a File - Failed Loading: " + FILEABPATH.toString(), this, "read")
                }
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PRELOADERERROR)) {
                    this.logUtil.putF("Failed", this, "read")
                }
            }
        }
    }

    def setUserName(userName : String) : Unit = {
        InstallerInfo.userName = userName
    }

    def setPassword(password : String) : Unit = {
        InstallerInfo.password = password
    }

    private def updateIfNeeded() : Unit = this.synchronized {
        if (!InstallerInfo.hasRead) {
            InstallerInfo.hasRead = true
            this.read()
            if ((InstallerInfo.userName == null) || (InstallerInfo.password == null)) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PRELOADER)) {
                    this.logUtil.putF("Failed", this, "updateIfNeeded")
                }
            }
        }
    }

    def getUserName() : String = {
        this.updateIfNeeded()
        return InstallerInfo.userName
    }

    def getPassword() : String = {
        this.updateIfNeeded()
        return InstallerInfo.password
    }

    def isValid(userName : String, password : String) : Boolean = {
        this.updateIfNeeded()
        if ((((_root_.org.allbinary.business.init.InstallerInfo.userName != null) && (_root_.org.allbinary.business.init.InstallerInfo.userName.compareTo(userName) == 0)) && (_root_.org.allbinary.business.init.InstallerInfo.password != null)) && (_root_.org.allbinary.business.init.InstallerInfo.password.compareTo(password) == 0)) {
            return true
        }
        return false
    }

}

object InstallerInfo {
    private val instance : InstallerInfo = new InstallerInfo()

    private val INITFILENAME : String = "installerdata.dat"

    //private static final String PACKAGE = "/allbinary//init/";
    private val PACKAGE : String = PATH_GLOBALS.getInstance().INIT_PATH

    private var userName : String = StringUtil.getInstance().EMPTY_STRING

    private var password : String = StringUtil.getInstance().EMPTY_STRING

    private var hasRead : Boolean = false

    def setHasRead(value : Boolean) : Unit = this.synchronized {
        InstallerInfo.hasRead = value
    }

}


