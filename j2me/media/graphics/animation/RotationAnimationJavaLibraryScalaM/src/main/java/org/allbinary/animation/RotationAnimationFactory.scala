/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.game.configuration.GameConfigurationCentral
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.media.ScaleProperties

class RotationAnimationFactory(param_totalAngle : Short, param_angleIncrement : Short) extends AnimationInterfaceFactoryInterface with ProceduralAnimationInterfaceFactoryInterface {
    import _root_.org.allbinary.animation.RotationAnimationFactory.{*}

    private var totalAngle : Short = 0

    private var angleIncrement : Short = 0

    //Constructor
    {
        val totalAngle : Short = param_totalAngle
        val angleIncrement : Short = param_angleIncrement
        this.totalAngle = totalAngle
        this.angleIncrement = angleIncrement
    }

    override def getInstance(instanceId : Int) : Animation = {
        return NullRotationAnimation.createTotalAngle(AngleInfo.getInstance(this.angleIncrement), this.totalAngle, AnimationBehavior.getInstance())
    }

    override def getInstanceAnimation(animationInterface : Animation) : Animation = {
        return NullRotationAnimation.createTotalAngle(AngleInfo.getInstance(this.angleIncrement), this.totalAngle, AnimationBehavior.getInstance())
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
    }

}

object RotationAnimationFactory {
    def createFactory() : RotationAnimationFactory = {
        val totalAngle : Short = AngleFactory.getInstance().TOTAL_ANGLE
        return new RotationAnimationFactory(totalAngle, (totalAngle / GameConfigurationCentral.getInstance().getGameControlFidelity()).toShort)
    }

}


