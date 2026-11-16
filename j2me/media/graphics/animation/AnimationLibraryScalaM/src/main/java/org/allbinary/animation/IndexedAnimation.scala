/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.math.PrimitiveIntUtil
import _root_.org.allbinary.string.CommonStrings

/**  *   * @author user  */
class IndexedAnimation(param_animationBehavior : AnimationBehavior) extends Animation with IndexedAnimationInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    var animationBehaviorP : AnimationBehavior = null

    //Constructor
    {
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.animationBehaviorP = animationBehavior
    }

    /**      * @return the animationBehavior      */
    def getAnimationBehavior() : AnimationBehavior = {
        return this.animationBehaviorP
    }

    override def reset() : Unit = {
        this.animationBehaviorP.reset()
        this.setFrame(0)
    }

    override def setFrame(index : Int) : Unit = {
    }

    override def getFrame() : Int = {
        return 0
    }

    def getAnimationSize() : Int = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    override def getSize() : Int = {
        return 0
    }

    override def previousFrame() : Unit = {
    }

    def isLastFrame() : Boolean = {
        if (this.getFrame() == (this.getSize() - 1)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    override def setSequence(sequence : Array[Int]) : Unit = {
    }

    override def getSequence() : Array[Int] = {
        return PrimitiveIntUtil.getArrayInstance()
    }

    def setState(indexedAnimation : IndexedAnimation) : Unit = {
        this.setFrame(indexedAnimation.getFrame())
        this.setDx(indexedAnimation.getDx())
        this.setDy(indexedAnimation.getDy())
    }

    //TWB - This is really only for ImageBaseRotationAnimation
    def getWidth() : Int = {
        return 0
    }

    def getHeight() : Int = {
        return 0
    }

}


