/* * AllBinary Open License Version 1 * Copyright (c) 2009 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.input.motion

import _root_.org.allbinary.android.AndroidInfoFactory
import _root_.org.allbinary.android.input.motion.api1.GameInputMotionInfoAPI1
import _root_.org.allbinary.android.input.motion.api5.GameInputMotionInfoAPI5

class GameInputMotionInfoFactory {
    import _root_.org.allbinary.android.input.motion.GameInputMotionInfoFactory.{*}

}

object GameInputMotionInfoFactory {
    def getInstance() : GameInputMotionInfo = {
        var SDK_VERSION : Int = AndroidInfoFactory.getInstance().getVersion()
        //VERSION_CODES.DONUT
        if (SDK_VERSION <= 4) {
            return GameInputMotionInfoAPI1.getInstance()
        } else {
            return GameInputMotionInfoAPI5.getInstance()
        }
        throw new IllegalStateException()
    }

}


