/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media

import _root_.android.content.Context
import _root_.android.os.Vibrator
import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.game.configuration.GameConfigurationCentral

class AllBinaryVibration() extends AllBinaryVibrationME {
    import _root_.org.allbinary.media.AllBinaryVibration.{*}

    private val vibrator : Vibrator = ResourceUtil.getInstance().getContext().getSystemService(Context.VIBRATOR_SERVICE).asInstanceOf[Vibrator]

    override def vibrate(duration : Int, `type` : Int, volume : Int) : Unit = {
        this.vibrator.vibrate(duration.toLong)
    }

}

object AllBinaryVibration {
    private var VIBRATION : AllBinaryVibrationME = AllBinaryNoVibration.NO_VIBRATION

    def getInstance() : AllBinaryVibrationME = {
        return AllBinaryVibration.VIBRATION
    }

    def init() : Unit = {
        if (GameConfigurationCentral.getInstance().VIBRATION.getValue().intValue() == 0) {
            AllBinaryVibration.VIBRATION = AllBinaryNoVibration.NO_VIBRATION
        } else {
            AllBinaryVibration.VIBRATION = new AllBinaryVibration()
        }
    }

}


