/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.compound

import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.media.ScaleProperties

class CompoundAnimationInterfaceFactory(param_basicAnimationInterfaceFactoryInterfaceArray : Array[AnimationInterfaceFactoryInterface], param_animationBehaviorFactory : AnimationBehaviorFactory) extends AnimationInterfaceFactoryInterface {

    var basicAnimationInterfaceFactoryInterfaceArrayP : Array[AnimationInterfaceFactoryInterface] = null

    var animationBehaviorFactory : AnimationBehaviorFactory = null

    //Constructor
    {
        val basicAnimationInterfaceFactoryInterfaceArray : Array[AnimationInterfaceFactoryInterface] = param_basicAnimationInterfaceFactoryInterfaceArray
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
        this.basicAnimationInterfaceFactoryInterfaceArrayP = basicAnimationInterfaceFactoryInterfaceArray
        this.animationBehaviorFactory = animationBehaviorFactory
    }

    override def getInstance(instanceId : Int) : Animation = {
        val size : Int = this.basicAnimationInterfaceFactoryInterfaceArrayP.length
        val animationInterfaceArray : Array[Animation] = this.createArray(size)

        {
            var index : Int = 0
            while (index < size) {
                animationInterfaceArray(index) = this.basicAnimationInterfaceFactoryInterfaceArrayP(index).getInstance(instanceId)
                index += 1
            }
        }
        return this.createAnimation(animationInterfaceArray)
    }

    def createArray(size : Int) : Array[Animation] = {
        return NullAnimationFactory.getFactoryInstance().EMPTY_ARRAY
    }

    def createAnimation(animationInterfaceArray : Array[Animation]) : Animation = {
        return NullAnimationFactory.getFactoryInstance().getInstance(0)
    }

    def getBasicAnimationInterfaceFactoryInterfaceArray() : Array[AnimationInterfaceFactoryInterface] = {
        return this.basicAnimationInterfaceFactoryInterfaceArrayP
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
        val size : Int = this.basicAnimationInterfaceFactoryInterfaceArrayP.length

        {
            var index : Int = 0
            while (index < size) {
                this.basicAnimationInterfaceFactoryInterfaceArrayP(index).setInitialScale(scaleProperties)
                index += 1
            }
        }
    }

}


