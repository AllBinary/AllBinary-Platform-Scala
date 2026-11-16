/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.init.db


class InventoryDbInitInfo private (super_1 : String, super_2 : Boolean, constructor_ : Unit) extends DbInitInfo(super_1, super_2) {
    import _root_.org.allbinary.business.init.db.InventoryDbInitInfo.{*}

    def this(read : Boolean) = {
        this(_root_.org.allbinary.business.init.db.InventoryDbInitInfo.INITFILE, read, ())
    }

    def this() = {
        this(_root_.org.allbinary.business.init.db.InventoryDbInitInfo.INITFILE, true, ())
    }

}

object InventoryDbInitInfo {
    private val INITFILE : String = "inventorydbinitdata.dat"

}


