/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.persistance

import _root_.javax.microedition.rms.RecordComparator

/**  *  * @author User  */
class NullRecordComparator extends RecordComparator {
    import _root_.org.allbinary.game.configuration.persistance.NullRecordComparator.{NULL_RECORD_COMPARATOR as _, *}
    def NULL_RECORD_COMPARATOR : NullRecordComparator = _root_.org.allbinary.game.configuration.persistance.NullRecordComparator.NULL_RECORD_COMPARATOR

    override def compare(rec1 : Array[Byte], rec2 : Array[Byte]) : Int = {
        return 0
    }

}

object NullRecordComparator {
    val NULL_RECORD_COMPARATOR : NullRecordComparator = new NullRecordComparator()

}


