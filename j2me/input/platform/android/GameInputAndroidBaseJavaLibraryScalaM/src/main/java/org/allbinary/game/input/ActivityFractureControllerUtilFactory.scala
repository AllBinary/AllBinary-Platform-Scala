/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.android.AndroidInfoFactory

class ActivityFractureControllerUtilFactory {
    import _root_.org.allbinary.game.input.ActivityFractureControllerUtilFactory.{*}

}

object ActivityFractureControllerUtilFactory {
    def getInstance() : AndroidKeyFactory = {
        val SDK_VERSION : Int = AndroidInfoFactory.getInstance().getVersion()
        //VERSION_CODES.DONUT
        if (SDK_VERSION <= 8) {
            return AndroidAPI1KeyFactory.getInstance()
        } else if (SDK_VERSION <= 11) {
            return AndroidAPI9KeyFactory.getInstance()
        } else {
            return AndroidAPI12KeyFactory.getAPI12Instance()
        }
        throw new IllegalStateException()
    }

}


