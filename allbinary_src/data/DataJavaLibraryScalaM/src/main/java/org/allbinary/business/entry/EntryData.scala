/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.entry


class EntryData private() {
    import _root_.org.allbinary.business.entry.EntryData.{*}

    val ID : String = "ENTRY_ID"

    val ENCRYPTION : String = "ENTRY_ENCRYPTION"

    val TIMECREATED : String = "ENTRY_TIMECREATED"

    val LASTMODIFIED : String = "ENTRY_LASTMODIFIED"

    val DEFAULT : String = "ENTRY_DEFAULT"

    val SPECIAL : String = "ENTRY_SPECIAL"

    val ENABLE : String = "ENTRY_ENABLE"

    val YES : String = "Yes"

    val NO : String = "No"

}

object EntryData {
    private val instance : EntryData = new EntryData()

    def getInstance() : EntryData = {
        return EntryData.instance
    }

}


