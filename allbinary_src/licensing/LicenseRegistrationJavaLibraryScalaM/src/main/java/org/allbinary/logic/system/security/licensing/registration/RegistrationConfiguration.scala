/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing.registration

import _root_.java.io.DataInputStream
import _root_.java.io.InputStream
import _root_.java.io.OutputStream
import _root_.org.allbinary.logic.io.AbDataOutputStream
import _root_.org.allbinary.logic.io.FileStreamFactory
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.io.file.FileFactory
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil

class RegistrationConfiguration private() {
    import _root_.org.allbinary.logic.system.security.licensing.registration.RegistrationConfiguration.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var registrationCode : String = "No Registration Code"

    val NAME : String = "registrationid"

    private val FILE : String = "Registration.dat"

    //Constructor
    {
        try {
            if (FileFactory.getInstance().isFile(this.FILE)) {
                this.read()
            } else {
                this.write()
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.CONSTRUCTOR, e)
            }
        }
    }

    private def read() : Unit = {
        var fileInputStreamFactory : FileStreamFactory = FileStreamFactory.getInstance()
        var fileInputStream : InputStream = fileInputStreamFactory.getFileInputStreamInstance(StringUtil.getInstance().EMPTY_STRING, this.FILE)
        var dataInputStream : DataInputStream = new DataInputStream(fileInputStream)
        this.setRegistrationCode(dataInputStream.readUTF())
        PreLogUtil.put(new StringMaker().append("Read Configuration: ").append(this.toString()).toString(), this, "read")
    }

    def write() : Unit = {
        var dataOutputStream : AbDataOutputStream = null
        try {
            this.logUtil.putF(new StringMaker().append("Write Configuration: ").append(this.toString()).toString(), this, "write")
            //PreLogUtil.put("Write Configuration: ").append(this.toString(), this, "write");
            var fileInputStreamFactory : FileStreamFactory = FileStreamFactory.getInstance()
            var fileOutputStream : OutputStream = fileInputStreamFactory.getFileOutputStreamInstance(StringUtil.getInstance().EMPTY_STRING, this.FILE)
            dataOutputStream = new AbDataOutputStream(fileOutputStream)
            dataOutputStream.writeUTF(this.getRegistrationCode())
            dataOutputStream.flush()
        } finally {
            StreamUtil.getInstance().close(dataOutputStream)
        }
    }

    override def toString() : String = {
        return new StringMaker().append("Registration Code: ").append(this.getRegistrationCode()).toString()
    }

    def setRegistrationCode(registrationCode : String) : Unit = {
        this.registrationCode = registrationCode
    }

    def getRegistrationCode() : String = {
        return this.registrationCode
    }

}

object RegistrationConfiguration {
    private val SINGLETON : RegistrationConfiguration = new RegistrationConfiguration()

    def getInstance() : RegistrationConfiguration = {
        return RegistrationConfiguration.SINGLETON
    }

}


