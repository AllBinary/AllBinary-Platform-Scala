/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.compound

import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.RotationAnimation
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil

class SimultaneousCompoundRotationAnimationInterfaceFactory(param_basicAnimationInterfaceFactoryInterfaceArray : Array[AnimationInterfaceFactoryInterface], param_animationBehaviorFactory : AnimationBehaviorFactory) extends CompoundAnimationInterfaceFactory(param_basicAnimationInterfaceFactoryInterfaceArray, param_animationBehaviorFactory) {

    //Constructor
    {
        val basicAnimationInterfaceFactoryInterfaceArray : Array[AnimationInterfaceFactoryInterface] = param_basicAnimationInterfaceFactoryInterfaceArray
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
        if (animationBehaviorFactory eq AnimationBehaviorFactory.getInstance()) {
            ForcedLogUtil.log("Using default AnimationBehaviorFactory with IndexedAnimationFactory", this)
        }
    }

    override def createArray(size : Int) : Array[Animation] = {
        return new Array[RotationAnimation](size).asInstanceOf[Array[Animation]]
    }

    override def createAnimation(animationInterfaceArray : Array[Animation]) : Animation = {
        return new SimultaneousCompoundRotationAnimation(animationInterfaceArray.asInstanceOf[Array[RotationAnimation]], this.animationBehaviorFactory.getOrCreateInstance())
    }

}


