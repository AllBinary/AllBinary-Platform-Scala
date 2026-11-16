/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary

import _root_.android.app.Activity
import _root_.android.os.Build

class AndroidUtil {
    import _root_.org.allbinary.AndroidUtil.{NULL_ACTIVITY as _, *}
    def NULL_ACTIVITY : Activity = _root_.org.allbinary.AndroidUtil.NULL_ACTIVITY

}

object AndroidUtil {
    val NULL_ACTIVITY : Activity = new Activity()

    private val version : Int = Integer.parseInt(Build.VERSION.SDK)

    def isMemoryRestrictive() : Boolean = {
        if (AndroidUtil.version < 30) {
            return true
        }
        return false
    }

    def isAndroid() : Boolean = {
        return true
    }

}


