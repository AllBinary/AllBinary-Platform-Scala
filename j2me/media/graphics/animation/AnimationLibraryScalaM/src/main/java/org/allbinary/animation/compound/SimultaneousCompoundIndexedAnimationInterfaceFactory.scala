/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.compound

import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil

class SimultaneousCompoundIndexedAnimationInterfaceFactory(param_basicAnimationInterfaceFactoryInterfaceArray : Array[AnimationInterfaceFactoryInterface], param_animationBehaviorFactory : AnimationBehaviorFactory) extends CompoundAnimationInterfaceFactory(param_basicAnimationInterfaceFactoryInterfaceArray, param_animationBehaviorFactory) {

    //Constructor
    {
        val basicAnimationInterfaceFactoryInterfaceArray : Array[AnimationInterfaceFactoryInterface] = param_basicAnimationInterfaceFactoryInterfaceArray
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
    }

    override def createArray(size : Int) : Array[Animation] = {
        return new Array[Animation](size)
    }

    override def createAnimation(animationArray : Array[Animation]) : Animation = {
        return new SimultaneousCompoundIndexedAnimation(animationArray, this.animationBehaviorFactory.getOrCreateInstance())
    }

}


