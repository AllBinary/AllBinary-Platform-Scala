/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io

import _root_.java.io.FileNotFoundException
import _root_.java.io.FileOutputStream
import _root_.java.io.IOException
import _root_.java.io.OutputStream
import _root_.java.nio.channels.FileChannel
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.AbFileNativeUtil

/**  *   * @author user  */
class AbFileOutputStream(param_fileOutputStream : FileOutputStream) extends OutputStream {
    import _root_.org.allbinary.logic.io.AbFileOutputStream.{*}

    private var fileOutputStream : FileOutputStream = null

    //    }
    //Constructor
    {
        val fileOutputStream : FileOutputStream = param_fileOutputStream
        //super(fileOutputStream.toString());
        this.fileOutputStream = fileOutputStream
    }

    override def close() : Unit = {
        this.fileOutputStream.close()
    }

    def getChannel() : FileChannel = {
        return this.fileOutputStream.getChannel()
    }

    /*     public FileDescriptor getFD()      {         return this.fileOutputStream.getFD();     }     */
    override def write(buffer : Array[Byte]) : Unit = {
        this.fileOutputStream.write(buffer)
    }

    override def write(buffer : Array[Byte], offset : Int, count : Int) : Unit = {
        this.fileOutputStream.write(buffer, offset, count)
    }

    override def write(b : Int) : Unit = {
        this.fileOutputStream.write(b)
    }

}

object AbFileOutputStream {
    def createFromAbFile(file : AbFile) : AbFileOutputStream = {
        return new AbFileOutputStream(new FileOutputStream(AbFileNativeUtil.get(file)))
    }

    def createFromAbFileAppend(file : AbFile, append : Boolean) : AbFileOutputStream = {
        return new AbFileOutputStream(new FileOutputStream(file.getPath()))
    }

    def createFromFilePath(name : String) : AbFileOutputStream = {
        return new AbFileOutputStream(new FileOutputStream(name))
    }

    def createFromFilePathAppend(name : String, append : Boolean) : AbFileOutputStream = {
        return new AbFileOutputStream(new FileOutputStream(name))
    }

}


