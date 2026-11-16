/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.compound

import _root_.javax.microedition.khronos.opengles.GL
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.logic.math.PrimitiveIntUtil
import _root_.org.allbinary.util.CircularIndexUtil

/**  *  * @author Berthelot, Travis  * @version 1.0  */
class CompoundIndexedAnimation(param_animationInterfaceArray : Array[Animation], param_animationBehavior : AnimationBehavior) extends IndexedAnimation(param_animationBehavior) with CompoundAnimationInterface {

    private var circularIndexUtil : CircularIndexUtil = null

    private var animationInterfaceArray : Array[Animation] = null

    //Constructor
    {
        val animationInterfaceArray : Array[Animation] = param_animationInterfaceArray
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.animationInterfaceArray = animationInterfaceArray
        this.circularIndexUtil = CircularIndexUtil.createInstance(this.animationInterfaceArray.length)
    }

    override def setFrame(index : Int) : Unit = {
        val indexedAnimation : IndexedAnimation = this.animationInterfaceArray(this.circularIndexUtil.getIndex()).asInstanceOf[IndexedAnimation]
        indexedAnimation.setFrame(index)
    }

    override def getFrame() : Int = {
        val indexedAnimation : IndexedAnimation = this.animationInterfaceArray(this.circularIndexUtil.getIndex()).asInstanceOf[IndexedAnimation]
        return indexedAnimation.getFrame()
    }

    override def getSize() : Int = {
        val indexedAnimation : IndexedAnimation = this.animationInterfaceArray(this.circularIndexUtil.getIndex()).asInstanceOf[IndexedAnimation]
        return indexedAnimation.getSize()
    }

    override def previousFrame() : Unit = {
        val indexedAnimation : IndexedAnimation = this.animationInterfaceArray(this.circularIndexUtil.getIndex()).asInstanceOf[IndexedAnimation]
        indexedAnimation.previousFrame()
    }

    override def setSequence(sequence : Array[Int]) : Unit = {
    }

    override def getSequence() : Array[Int] = {
        return PrimitiveIntUtil.getArrayInstance()
    }

    override def nextFrame() : Unit = {
        this.animationInterfaceArray(this.circularIndexUtil.getIndex()).nextFrame()
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.animationInterfaceArray(this.circularIndexUtil.getIndex()).paintXY(graphics, x, y)
    }

    override def paintThreedXYZ(graphics : Graphics, x : Int, y : Int, z : Int) : Unit = {
        this.animationInterfaceArray(this.circularIndexUtil.getIndex()).paintThreedXYZ(graphics, x, y, z)
    }

    override def getCurrentAnimation() : IndexedAnimation = {
        return this.animationInterfaceArray(this.circularIndexUtil.getIndex()).asInstanceOf[IndexedAnimation]
    }

    override def nextAnimation() : Unit = {
        var frame : Int = this.getFrame()
        this.circularIndexUtil.next()
        this.setFrame(frame)
    }

    override def previousAnimation() : Unit = {
        var frame : Int = this.getFrame()
        this.circularIndexUtil.previous()
        this.setFrame(frame)
    }

    override def setAnimation(index : Int) : Unit = {
        var frame : Int = this.getFrame()
        this.circularIndexUtil.setIndex(index)
        this.setFrame(frame)
    }

    /**      * @return the animationInterfaceArray      */
    def getAnimationInterfaceArray() : Array[Animation] = {
        return this.animationInterfaceArray
    }

    /**      * @param animationInterfaceArray the animationInterfaceArray to set      */
    def setAnimationInterfaceArray(animationInterfaceArray : Array[Animation]) : Unit = {
        this.animationInterfaceArray = animationInterfaceArray
    }

    override def set(gl : GL) : Unit = {

        {
            var index : Int = this.animationInterfaceArray.length
            while ({ index -= 1; index } >= 0) {
                this.animationInterfaceArray(index).set(gl)
            }
        }
    }

}


