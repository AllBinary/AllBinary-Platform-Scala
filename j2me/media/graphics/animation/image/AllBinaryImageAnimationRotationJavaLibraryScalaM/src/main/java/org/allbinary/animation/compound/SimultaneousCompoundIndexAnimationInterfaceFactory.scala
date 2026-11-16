/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.compound

import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.media.ScaleProperties

class SimultaneousCompoundIndexAnimationInterfaceFactory(param_basicAnimationInterfaceFactoryInterfaceArray : Array[AnimationInterfaceFactoryInterface], param_animationBehaviorFactory : AnimationBehaviorFactory) extends AnimationInterfaceFactoryInterface {

    private var basicAnimationInterfaceFactoryInterfaceArray : Array[AnimationInterfaceFactoryInterface] = null

    private var animationBehaviorFactory : AnimationBehaviorFactory = null

    //Constructor
    {
        val basicAnimationInterfaceFactoryInterfaceArray : Array[AnimationInterfaceFactoryInterface] = param_basicAnimationInterfaceFactoryInterfaceArray
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
        this.basicAnimationInterfaceFactoryInterfaceArray = basicAnimationInterfaceFactoryInterfaceArray
        this.animationBehaviorFactory = animationBehaviorFactory
    }

    override def getInstance(instanceId : Int) : Animation = {
        val size : Int = this.basicAnimationInterfaceFactoryInterfaceArray.length
        val animationInterfaceArray : Array[IndexedAnimation] = new Array[IndexedAnimation](size)

        {
            var index : Int = 0
            while (index < size) {
                animationInterfaceArray(index) = this.basicAnimationInterfaceFactoryInterfaceArray(index).getInstance(instanceId).asInstanceOf[IndexedAnimation]
                index += 1
            }
        }
        return this.getOrCreate(animationInterfaceArray)
    }

    def getOrCreate(animationInterfaceArray : Array[IndexedAnimation]) : Animation = {
        return new SimultaneousCompoundIndexAnimation(animationInterfaceArray, this.animationBehaviorFactory.getOrCreateInstance())
    }

    def getBasicAnimationInterfaceFactoryInterfaceArray() : Array[AnimationInterfaceFactoryInterface] = {
        return this.basicAnimationInterfaceFactoryInterfaceArray
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
    }

}


