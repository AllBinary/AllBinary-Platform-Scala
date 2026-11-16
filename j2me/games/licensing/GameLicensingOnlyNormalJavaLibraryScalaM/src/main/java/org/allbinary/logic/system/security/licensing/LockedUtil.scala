/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing


class LockedUtil extends LockedUtilInterface {
    import _root_.org.allbinary.logic.system.security.licensing.LockedUtil.{*}

    def isLocked() : Boolean = {
        //Paid
        return false
    }

    def isLockedFeature(lockableFeatrue : LockableFeature) : Boolean = {
        //Paid
        return false
    }

}

object LockedUtil {
    private val instance : LockedUtil = new LockedUtil()

    def getInstance() : LockedUtil = {
        return LockedUtil.instance
    }

}


