/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.compound

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.logic.math.PrimitiveIntUtil

/**  *  * @author Berthelot, Travis  * @version 1.0  */
class SimultaneousCompoundIndexedAnimation(param_animationInterfaceArray : Array[Animation], param_animationBehavior : AnimationBehavior) extends IndexedAnimation(param_animationBehavior) {

    //implements IndexedAnimationInterface
    private var animationInterfaceArray : Array[Animation] = null

    //Constructor
    {
        val animationInterfaceArray : Array[Animation] = param_animationInterfaceArray
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.animationInterfaceArray = animationInterfaceArray
    }

    override def setFrame(frameIndex : Int) : Unit = {
        var indexedAnimation : IndexedAnimation = null

        {
            var index : Int = this.animationInterfaceArray.length
            while ({ index -= 1; index } >= 0) {
                indexedAnimation = this.animationInterfaceArray(index).asInstanceOf[IndexedAnimation]
                indexedAnimation.setFrame(frameIndex)
            }
        }
    }

    override def getFrame() : Int = {
        val indexedAnimation : IndexedAnimation = this.animationInterfaceArray(0).asInstanceOf[IndexedAnimation]
        return indexedAnimation.getFrame()
    }

    override def getSize() : Int = {
        val indexedAnimation : IndexedAnimation = this.animationInterfaceArray(0).asInstanceOf[IndexedAnimation]
        return indexedAnimation.getSize()
    }

    override def previousFrame() : Unit = {
        var indexedAnimation : IndexedAnimation = null

        {
            var index : Int = this.animationInterfaceArray.length
            while ({ index -= 1; index } >= 0) {
                indexedAnimation = this.animationInterfaceArray(index).asInstanceOf[IndexedAnimation]
                indexedAnimation.previousFrame()
            }
        }
    }

    override def setSequence(sequence : Array[Int]) : Unit = {
    }

    override def getSequence() : Array[Int] = {
        return PrimitiveIntUtil.getArrayInstance()
    }

    override def nextFrame() : Unit = {

        {
            var index : Int = this.animationInterfaceArray.length
            while ({ index -= 1; index } >= 0) {
                this.animationInterfaceArray(index).nextFrame()
            }
        }
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        var size : Int = this.animationInterfaceArray.length

        {
            var index : Int = 0
            while (index < size) {
                this.animationInterfaceArray(index).paintXY(graphics, x, y)
                index += 1
            }
        }
    }

    override def paintThreedXYZ(graphics : Graphics, x : Int, y : Int, z : Int) : Unit = {
        var size : Int = this.animationInterfaceArray.length

        {
            var index : Int = 0
            while (index < size) {
                this.animationInterfaceArray(index).paintThreedXYZ(graphics, x, y, z)
                index += 1
            }
        }
    }

    /**      * @return the animationInterfaceArray      */
    def getAnimationInterfaceArray() : Array[Animation] = {
        return this.animationInterfaceArray
    }

    /**      * @param animationInterfaceArray the animationInterfaceArray to set      */
    def setAnimationInterfaceArray(animationInterfaceArray : Array[Animation]) : Unit = {
        this.animationInterfaceArray = animationInterfaceArray
    }

}


