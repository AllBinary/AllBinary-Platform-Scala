/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.special

import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.animation.IndexedAnimationBehavior

class SpecialAnimation(param_animationBehavior : AnimationBehavior) extends IndexedAnimation(param_animationBehavior) with SpecialAnimationInterface {
    import _root_.org.allbinary.animation.special.SpecialAnimation.{*}

    //Constructor
    {
        val animationBehavior : AnimationBehavior = param_animationBehavior
    }

    override def nextFrame() : Unit = {
        val indexedAnimationBehavior : IndexedAnimationBehavior = (this.animationBehaviorP.asInstanceOf[IndexedAnimationBehavior])
        indexedAnimationBehavior.loopIndex += 1
    }

    override def setLastFrame() : Unit = {
    }

    override def isComplete() : Boolean = {
        return false
    }

    def open() : Unit = {
    }

    def close() : Unit = {
    }

    def process() : Unit = {
    }

}

object SpecialAnimation {
    private val NULL_SPECIAL_ANIMATION : SpecialAnimation = new SpecialAnimation(new IndexedAnimationBehavior(1, 250))

    def getInstance() : SpecialAnimation = {
        return SpecialAnimation.NULL_SPECIAL_ANIMATION
    }

}


