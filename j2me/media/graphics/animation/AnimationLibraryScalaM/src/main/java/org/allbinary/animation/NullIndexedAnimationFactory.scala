/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.media.ScaleProperties

class NullIndexedAnimationFactory private() extends AnimationInterfaceFactoryInterface with ProceduralAnimationInterfaceFactoryInterface {
    import _root_.org.allbinary.animation.NullIndexedAnimationFactory.{NULL_INDEXED_ANIMATION_ARRAY as _, *}
    def NULL_INDEXED_ANIMATION_ARRAY : Array[IndexedAnimation] = _root_.org.allbinary.animation.NullIndexedAnimationFactory.NULL_INDEXED_ANIMATION_ARRAY

    private val NULL_ANIMATION : Animation = new NullIndexedAnimationInner()

    override def getInstance(instanceId : Int) : Animation = {
        return this.NULL_ANIMATION
    }

    override def getInstanceAnimation(animationInterface : Animation) : Animation = {
        return this.NULL_ANIMATION
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
    }

}

object NullIndexedAnimationFactory {
    val NULL_INDEXED_ANIMATION_ARRAY : Array[IndexedAnimation] = new Array[IndexedAnimation](0)

    private var NULL_INDEXED_ANIMATION_FACTORY : NullIndexedAnimationFactory = new NullIndexedAnimationFactory()

    def getFactoryInstance() : NullIndexedAnimationFactory = {
        return NullIndexedAnimationFactory.NULL_INDEXED_ANIMATION_FACTORY
    }

}


