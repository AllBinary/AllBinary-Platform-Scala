/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.compound

import _root_.javax.microedition.khronos.opengles.GL
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.logic.math.PrimitiveIntUtil

/**  *  * @author Berthelot, Travis  * @version 1.0  */
class SimultaneousCompoundIndexAnimation(param_animationInterfaceArray : Array[IndexedAnimation], param_animationBehavior : AnimationBehavior) extends IndexedAnimation(param_animationBehavior) {

    private var animationInterfaceArray : Array[IndexedAnimation] = null

    //Constructor
    {
        val animationInterfaceArray : Array[IndexedAnimation] = param_animationInterfaceArray
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.animationInterfaceArray = animationInterfaceArray
    }

    override def setFrame(frameIndex : Int) : Unit = {

        {
            var index : Int = this.animationInterfaceArray.length
            while ({ index -= 1; index } >= 0) {
                this.animationInterfaceArray(index).setFrame(frameIndex)
            }
        }
    }

    override def getFrame() : Int = {
        return this.animationInterfaceArray(0).getFrame()
    }

    override def getAnimationSize() : Int = {
        return this.animationInterfaceArray(0).getAnimationSize()
    }

    override def getSize() : Int = {
        return this.animationInterfaceArray(0).getSize()
    }

    override def previousFrame() : Unit = {

        {
            var index : Int = this.animationInterfaceArray.length
            while ({ index -= 1; index } >= 0) {
                this.animationInterfaceArray(index).previousFrame()
            }
        }
    }

    override def nextFrame() : Unit = {

        {
            var index : Int = this.animationInterfaceArray.length
            while ({ index -= 1; index } >= 0) {
                this.animationInterfaceArray(index).nextFrame()
            }
        }
    }

    override def setSequence(sequence : Array[Int]) : Unit = {
    }

    override def getSequence() : Array[Int] = {
        return PrimitiveIntUtil.getArrayInstance()
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {

        {
            var index : Int = this.animationInterfaceArray.length
            while ({ index -= 1; index } >= 0) {
                this.animationInterfaceArray(index).paintXY(graphics, x, y)
            }
        }
    }

    override def paintThreedXYZ(graphics : Graphics, x : Int, y : Int, z : Int) : Unit = {

        {
            var index : Int = this.animationInterfaceArray.length
            while ({ index -= 1; index } >= 0) {
                this.animationInterfaceArray(index).paintThreedXYZ(graphics, x, y, z)
            }
        }
    }

    override def set(gl : GL) : Unit = {

        {
            var index : Int = this.animationInterfaceArray.length
            while ({ index -= 1; index } >= 0) {
                this.animationInterfaceArray(index).set(gl)
            }
        }
    }

    /**      * @return the animationInterfaceArray      */
    def getAnimationInterfaceArray() : Array[IndexedAnimation] = {
        return this.animationInterfaceArray
    }

    /**      * @param animationInterfaceArray the animationInterfaceArray to set      */
    def setAnimationInterfaceArray(animationInterfaceArray : Array[IndexedAnimation]) : Unit = {
        this.animationInterfaceArray = animationInterfaceArray
    }

}


