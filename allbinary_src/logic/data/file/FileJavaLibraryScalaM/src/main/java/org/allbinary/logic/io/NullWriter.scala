/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *  * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *  * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *  * Created By: Travis Berthelot  *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io

import _root_.java.io.IOException
import _root_.java.io.Writer

/**  * A Writer that ignores everything written to it. Writer.append writes so it is ignored as well.  *  * @author User  */
class NullWriter extends Writer {
    import _root_.org.allbinary.logic.io.NullWriter.{NULL_WRITER as _, *}
    def NULL_WRITER : NullWriter = _root_.org.allbinary.logic.io.NullWriter.NULL_WRITER

    override def write(c : Int) : Unit = {
    }

    override def write(cbuf : Array[Char], off : Int, len : Int) : Unit = {
    }

    override def write(str : String) : Unit = {
    }

    override def write(str : String, off : Int, len : Int) : Unit = {
    }

    override def flush() : Unit = {
    }

    override def close() : Unit = {
    }

}

object NullWriter {
    val NULL_WRITER : NullWriter = new NullWriter()

}


