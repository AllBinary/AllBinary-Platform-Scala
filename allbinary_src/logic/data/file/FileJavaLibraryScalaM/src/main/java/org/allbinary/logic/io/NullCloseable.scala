/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io

import _root_.java.io.Closeable
import _root_.java.io.IOException

/**  *  * @author User  */
class NullCloseable extends Closeable {
    import _root_.org.allbinary.logic.io.NullCloseable.{NULL_CLOSEABLE as _, *}
    def NULL_CLOSEABLE : NullCloseable = _root_.org.allbinary.logic.io.NullCloseable.NULL_CLOSEABLE

    override def close() : Unit = {
    }

}

object NullCloseable {
    val NULL_CLOSEABLE : NullCloseable = new NullCloseable()

}


