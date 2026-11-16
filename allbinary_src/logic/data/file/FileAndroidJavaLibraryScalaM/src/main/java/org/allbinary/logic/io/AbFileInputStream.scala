/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io

import _root_.java.io.FileInputStream
import _root_.java.io.FileNotFoundException
import _root_.java.io.IOException
import _root_.java.io.InputStream
import _root_.java.nio.channels.FileChannel

/**  *  * @author user  */
class AbFileInputStream(param_fileInputStream : FileInputStream) extends InputStream {

    /*     public AbFileInputStream(String name) throws FileNotFoundException {         super(name);     }      public AbFileInputStream(AbFile file) throws FileNotFoundException {         super(AbFileNativeUtil.get(file));     }          protected AbFileInputStream(File file) throws FileNotFoundException {         super(file);     }     */
    private var fileInputStream : FileInputStream = null

    //Constructor
    {
        val fileInputStream : FileInputStream = param_fileInputStream
        //super(fileInputStream.toString());
        this.fileInputStream = fileInputStream
    }

    override def mark(readlimit : Int) : Unit = {
        this.fileInputStream.mark(readlimit)
    }

    override def markSupported() : Boolean = {
        return this.fileInputStream.markSupported()
    }

    override def reset() : Unit = this.synchronized {
        this.fileInputStream.reset()
    }

    override def available() : Int = {
        return this.fileInputStream.available()
    }

    override def close() : Unit = {
        this.fileInputStream.close()
    }

    def getChannel() : FileChannel = {
        return this.fileInputStream.getChannel()
    }

    //}
    override def read() : Int = {
        return this.fileInputStream.read()
    }

    override def read(b : Array[Byte]) : Int = {
        return this.fileInputStream.read(b)
    }

    override def read(buffer : Array[Byte], offset : Int, count : Int) : Int = {
        return this.fileInputStream.read(buffer, offset, count)
    }

    override def skip(n : Long) : Long = {
        return this.fileInputStream.skip(n)
    }

}


