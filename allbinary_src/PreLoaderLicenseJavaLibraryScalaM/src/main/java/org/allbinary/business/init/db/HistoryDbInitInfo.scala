/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.init.db


class HistoryDbInitInfo private (super_1 : String, super_2 : Boolean, constructor_ : Unit) extends DbInitInfo(super_1, super_2) {
    import _root_.org.allbinary.business.init.db.HistoryDbInitInfo.{*}

    def this(read : Boolean) = {
        this(_root_.org.allbinary.business.init.db.HistoryDbInitInfo.INITFILE, read, ())
    }

    def this() = {
        this(_root_.org.allbinary.business.init.db.HistoryDbInitInfo.INITFILE, true, ())
    }

}

object HistoryDbInitInfo {
    private val INITFILE : String = "historydbinitdata.dat"

}


