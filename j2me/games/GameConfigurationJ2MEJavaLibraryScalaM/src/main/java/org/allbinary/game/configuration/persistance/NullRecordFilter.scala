/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.persistance

import _root_.javax.microedition.rms.RecordFilter

/**  *  * @author User  */
class NullRecordFilter extends RecordFilter {
    import _root_.org.allbinary.game.configuration.persistance.NullRecordFilter.{*}

    override def matches(candidate : Array[Byte]) : Boolean = {
        return true
    }

}

object NullRecordFilter {
    var NULL_RECORD_FILTER : NullRecordFilter = new NullRecordFilter()

}


