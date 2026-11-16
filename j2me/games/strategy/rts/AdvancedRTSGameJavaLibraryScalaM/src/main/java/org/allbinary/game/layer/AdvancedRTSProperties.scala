/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.animation.transition.shake.NoShakeAnimationListener
import _root_.org.allbinary.animation.transition.shake.ShakeAnimationListener
import _root_.org.allbinary.animation.transition.shake.ShakeAnimationListenerFactory
import _root_.org.allbinary.game.configuration.GameConfigurationCentral
import _root_.org.allbinary.game.tick.TickableInterface
import _root_.org.allbinary.media.AllBinaryNoVibration
import _root_.org.allbinary.media.AllBinaryVibration
import _root_.org.allbinary.media.AllBinaryVibrationME

/**  *  * @author User  */
class AdvancedRTSProperties(param_shakeListener : ShakeAnimationListener, param_vibration : AllBinaryVibrationME, param_duration : Int, param_waypointBehaviorBase : TickableInterface) {
    import _root_.org.allbinary.game.layer.AdvancedRTSProperties.{*}

    var shakeListener : ShakeAnimationListener = null

    var vibration : AllBinaryVibrationME = null

    var duration : Int = 0

    var waypointBehaviorBase : TickableInterface = null

    //Constructor
    {
        val shakeListener : ShakeAnimationListener = param_shakeListener
        val vibration : AllBinaryVibrationME = param_vibration
        val duration : Int = param_duration
        val waypointBehaviorBase : TickableInterface = param_waypointBehaviorBase
        this.shakeListener = shakeListener
        this.vibration = vibration
        this.duration = duration
        this.waypointBehaviorBase = waypointBehaviorBase
    }

}

object AdvancedRTSProperties {
    def createPropertiesSimulated() : AdvancedRTSProperties = {
        return new AdvancedRTSProperties(NoShakeAnimationListener.NO_SHAKE_ANIMATION_LISTENER, AllBinaryNoVibration.NO_VIBRATION, 0, new WaypointBehaviorBase())
    }

    def createProperties() : AdvancedRTSProperties = {
        return new AdvancedRTSProperties(ShakeAnimationListenerFactory.getInstance(), AllBinaryVibration.getInstance(), GameConfigurationCentral.getInstance().VIBRATION.getValue().intValue() * 100, new WaypointBehaviorBase())
    }

}


