/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *  * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *  * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *  * Created By: Travis Berthelot  *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io

import _root_.java.io.IOException
import _root_.java.io.Reader

/**  * A Reader that is always at the end. Reader.read (CharBuffer) reads with read (char[], int, int) so it is -1 as well.  *  * @author User  */
class NullReader extends Reader {
    import _root_.org.allbinary.logic.io.NullReader.{NULL_READER as _, *}
    def NULL_READER : NullReader = _root_.org.allbinary.logic.io.NullReader.NULL_READER

    override def read() : Int = {
        return -1
    }

    override def read(cbuf : Array[Char], off : Int, len : Int) : Int = {
        return -1
    }

    override def ready() : Boolean = {
        return false
    }

    override def skip(n : Long) : Long = {
        return 0L
    }

    override def close() : Unit = {
    }

}

object NullReader {
    val NULL_READER : NullReader = new NullReader()

}


