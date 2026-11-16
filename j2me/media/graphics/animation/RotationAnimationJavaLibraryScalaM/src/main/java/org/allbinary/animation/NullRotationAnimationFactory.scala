/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.media.ScaleProperties

class NullRotationAnimationFactory private() extends AnimationInterfaceFactoryInterface with ProceduralAnimationInterfaceFactoryInterface {
    import _root_.org.allbinary.animation.NullRotationAnimationFactory.{*}

    val NULL_ROTATION_ANIMATION_ARRAY : Array[RotationAnimation] = new Array[RotationAnimation](0)

    private val NULL_ANIMATION : Animation = new NullRotationAnimation2()

    override def getInstance(instanceId : Int) : Animation = {
        return this.NULL_ANIMATION
    }

    override def getInstanceAnimation(animationInterface : Animation) : Animation = {
        return this.NULL_ANIMATION
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
    }

}

object NullRotationAnimationFactory {
    private var NULL_ROTATION_ANIMATION_FACTORY : NullRotationAnimationFactory = new NullRotationAnimationFactory()

    def getFactoryInstance() : NullRotationAnimationFactory = {
        return NullRotationAnimationFactory.NULL_ROTATION_ANIMATION_FACTORY
    }

}


