/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *  * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *  * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *  * Created By: Travis Berthelot  *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io

import _root_.java.io.IOException
import _root_.java.io.OutputStream

/**  * An OutputStream that ignores everything written to it.  *  * @author User  */
class NullOutputStream extends OutputStream {
    import _root_.org.allbinary.logic.io.NullOutputStream.{NULL_OUTPUT_STREAM as _, *}
    def NULL_OUTPUT_STREAM : NullOutputStream = _root_.org.allbinary.logic.io.NullOutputStream.NULL_OUTPUT_STREAM

    override def write(b : Int) : Unit = {
    }

    override def write(b : Array[Byte], off : Int, len : Int) : Unit = {
    }

    override def close() : Unit = {
    }

}

object NullOutputStream {
    val NULL_OUTPUT_STREAM : NullOutputStream = new NullOutputStream()

}


