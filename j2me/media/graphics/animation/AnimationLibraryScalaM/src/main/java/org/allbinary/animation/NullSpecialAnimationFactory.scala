/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.animation.special.SpecialAnimation
import _root_.org.allbinary.media.ScaleProperties

class NullSpecialAnimationFactory private() extends AnimationInterfaceFactoryInterface with ProceduralAnimationInterfaceFactoryInterface {
    import _root_.org.allbinary.animation.NullSpecialAnimationFactory.{*}

    override def getInstance(instanceId : Int) : Animation = {
        return SpecialAnimation.getInstance()
    }

    override def getInstanceAnimation(animationInterface : Animation) : Animation = {
        return SpecialAnimation.getInstance()
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
    }

}

object NullSpecialAnimationFactory {
    private var NULL_SPECIAL_ANIMATION_FACTORY : NullSpecialAnimationFactory = new NullSpecialAnimationFactory()

    def getFactoryInstance() : NullSpecialAnimationFactory = {
        return NullSpecialAnimationFactory.NULL_SPECIAL_ANIMATION_FACTORY
    }

}


