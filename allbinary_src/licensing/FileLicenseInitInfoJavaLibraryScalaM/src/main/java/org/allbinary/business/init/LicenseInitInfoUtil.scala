/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.init

import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.globals.PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.AbDataInputStream
import _root_.org.allbinary.logic.io.AbDataOutputStream
import _root_.org.allbinary.logic.io.AbFileInputStream
import _root_.org.allbinary.logic.io.DataOutputStreamFactory
import _root_.org.allbinary.logic.io.FileStreamFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.security.crypt.DatabaseEncoder
import _root_.org.allbinary.logic.system.security.crypt.WeakCrypt
import _root_.org.allbinary.string.CommonLabels

class LicenseInitInfoUtil {
    import _root_.org.allbinary.business.init.LicenseInitInfoUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val stringUtil : StringUtil = StringUtil.getInstance()

    val INITFILENAME : String = "licenseinitdata.dat"

    val ABOUT : String = "about"

    val PRIVACY_POLICY : String = "privacy_policy"

    private var filePath : String = this.stringUtil.EMPTY_STRING

    def setFilePath(filePath : String) : Unit = this.synchronized {
        this.filePath = filePath
    }

    def write(initData : LicenseInitInfo) : Unit = this.synchronized {
        if (this.filePath eq this.stringUtil.EMPTY_STRING) {
            this.filePath = URLGLOBALS.getMainPath() + PATH_GLOBALS.getInstance().INIT_PATH
        }
        try {
            val tsUtil : TsUtil = TsUtil.getInstance()
            val dataOutputStream : AbDataOutputStream = DataOutputStreamFactory.getInstance().getInstance(this.filePath, this.INITFILENAME)
            val licenseIdCrypted : Array[Byte] = tsUtil.getByteArray(new WeakCrypt(1).encrypt(initData.getLicenseId()))
            dataOutputStream.writeUTF(DatabaseEncoder.encode(licenseIdCrypted))
            val numberOfLicenseServers : Int = initData.getNumberOfServers()
            dataOutputStream.writeInt(numberOfLicenseServers)
            var licenseServerCrypted : Array[Byte] = null

            {
                var index : Int = 0
                while (index < numberOfLicenseServers) {
                    licenseServerCrypted = tsUtil.getByteArray(new WeakCrypt(3).encrypt(initData.getServer(index)))
                    dataOutputStream.writeUTF(DatabaseEncoder.encode(licenseServerCrypted))
                    index += 1
                }
            }
        } catch {
            case e : Exception => {
                // {
                this.logUtil.put("Command Failed: " + this.INITFILENAME, this, "write", e)
                // }
                FileStreamFactory.getInstance().delete(this.filePath, this.INITFILENAME)
                throw e
            }
        }
    }

    def read() : LicenseInitInfo = this.synchronized {
        return this.readAgain(0)
    }

    /*     public static synchronized boolean exists() throws Exception     {         AbPath abPath = new AbPath(URLGLOBALS.getMainPath() + PATH_GLOBALS.INIT_PATH,                 INITFILENAME);                  return FileUtil.isFile(abPath);     }     */
    def readAgain(initializeCounter : Int) : LicenseInitInfo = this.synchronized {
        val METHOD_NAME : String = "readAgain"
        if (this.filePath eq this.stringUtil.EMPTY_STRING) {
            this.filePath = URLGLOBALS.getMainPath() + PATH_GLOBALS.getInstance().INIT_PATH
        }
        try {
            // FILEABPATH.toString(),
            this.logUtil.putF("LicenseInitInfo File: " + this.INITFILENAME, this, METHOD_NAME)
            //this.logUtil.putF("LicenseInitInfo isFile: " + new File(this.INITFILENAME).isFile(), this, METHOD_NAME);
            val fileStreamFactory : FileStreamFactory = FileStreamFactory.getInstance()
            val iFile : AbFileInputStream = fileStreamFactory.getFileInputStreamInstance(this.filePath, this.INITFILENAME)
            if (iFile != null) {
                val iData : AbDataInputStream = new AbDataInputStream(iFile)
                val initInfo : LicenseInitInfo = new LicenseInitInfo()
                var decodedByteArray : Array[Byte] = DatabaseEncoder.decode(iData.readUTF())
                val licenseIdDecoded : String = new String(decodedByteArray)
                initInfo.setLicenseId(new WeakCrypt(1).decrypt(licenseIdDecoded))
                var numberOfLicenseServers : Int = iData.readInt()
                val NEXT_FILE : String = new StringMaker().append(CommonLabels.getInstance().NEXT).append(" License Server From File: ").toString()
                var licenseServerDecoded : String = null

                {
                    var index : Int = 0
                    while (index < numberOfLicenseServers) {
                        decodedByteArray = DatabaseEncoder.decode(iData.readUTF())
                        licenseServerDecoded = new String(decodedByteArray)
                        initInfo.setServer(new WeakCrypt(3).decrypt(licenseServerDecoded), index)
                        // {
                        this.logUtil.putF(NEXT_FILE + initInfo.getServer(index), this, METHOD_NAME)
                        index += 1
                    }
                }
                return initInfo
            } else {
                throw new Exception("Could Not Load License InitInfo: " + this.INITFILENAME)
            }
        } catch {
            case e : Exception => {
                try {
                    // {
                    this.logUtil.put("Command Failed: " + this.INITFILENAME, this, METHOD_NAME, e)
                } catch {
                    case e2 : Exception => {
                        // {
                        this.logUtil.put("LicenseInitInfo Read Retry: " + this.INITFILENAME, this, "readAgain()", e2)
                    }
                }
                throw new Exception("LicenseInitInfo Read Error: " + this.INITFILENAME)
            }
        }
        throw new IllegalStateException()
    }

    /**      * @return the filePath      */
    def getFilePath() : String = {
        return this.filePath
    }

}

object LicenseInitInfoUtil {
    private val instance : LicenseInitInfoUtil = new LicenseInitInfoUtil()

    def getInstance() : LicenseInitInfoUtil = {
        return LicenseInitInfoUtil.instance
    }

}


