/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.compound

import _root_.javax.microedition.khronos.opengles.GL
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.animation.RotationAnimation
import _root_.org.allbinary.direction.Direction
import _root_.org.allbinary.logic.math.PrimitiveIntUtil
import _root_.org.allbinary.math.Angle
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.util.CircularIndexUtil

/**  *  * @author Berthelot, Travis  * @version 1.0  */
class AutoCompoundRotationAnimation(param_animationInterfaceArray : Array[RotationAnimation], param_animationBehavior : AnimationBehavior) extends RotationAnimation(AngleInfo.getInstance(AngleFactory.getInstance().QUARTER_TOTAL_ANGLE), CircularIndexUtil.createInstance(4), param_animationBehavior) with CompoundAnimationInterface {

    private var animationInterfaceArray : Array[RotationAnimation] = null

    //Constructor
    {
        val animationInterfaceArray : Array[RotationAnimation] = param_animationInterfaceArray
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.animationInterfaceArray = animationInterfaceArray
        this.circularIndexUtil = CircularIndexUtil.createInstance(this.animationInterfaceArray.length)
    }

    override def setFrame(index : Int) : Unit = {
        this.animationInterfaceArray(this.circularIndexUtil.getIndex()).setFrame(index)
    }

    override def getFrame() : Int = {
        return this.animationInterfaceArray(this.circularIndexUtil.getIndex()).getFrame()
    }

    override def getAnimationSize() : Int = {
        return this.animationInterfaceArray(this.circularIndexUtil.getIndex()).getAnimationSize()
    }

    override def getSize() : Int = {
        return this.animationInterfaceArray(this.circularIndexUtil.getIndex()).getSize()
    }

    override def previousFrame() : Unit = {
        this.circularIndexUtil.previous()
        this.animationInterfaceArray(this.circularIndexUtil.getIndex()).previousFrame()
    }

    override def nextFrame() : Unit = {
        this.circularIndexUtil.next()
        this.animationInterfaceArray(this.circularIndexUtil.getIndex()).nextFrame()
    }

    override def previousRotation() : Unit = {
        this.animationInterfaceArray(this.circularIndexUtil.getIndex()).previousRotation()
    }

    override def nextRotation() : Unit = {
        this.animationInterfaceArray(this.circularIndexUtil.getIndex()).nextRotation()
    }

    override def setSequence(sequence : Array[Int]) : Unit = {
    }

    override def getSequence() : Array[Int] = {
        return PrimitiveIntUtil.getArrayInstance()
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.animationInterfaceArray(this.circularIndexUtil.getIndex()).paintXY(graphics, x, y)
    }

    override def paintThreedXYZ(graphics : Graphics, x : Int, y : Int, z : Int) : Unit = {
        this.animationInterfaceArray(this.circularIndexUtil.getIndex()).paintThreedXYZ(graphics, x, y, z)
    }

    override def getCurrentAnimation() : IndexedAnimation = {
        return this.animationInterfaceArray(this.circularIndexUtil.getIndex())
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
        val frame : Int = this.getFrame()
        this.circularIndexUtil.setIndex(index)
        this.setFrame(frame)
    }

    override def setFrameByDirection(direction : Direction) : Unit = {
        this.animationInterfaceArray(this.circularIndexUtil.getIndex()).setFrameByDirection(direction)
    }

    override def setFrameToAngle(angle : Angle) : Unit = {
        this.animationInterfaceArray(this.circularIndexUtil.getIndex()).setFrameToAngle(angle)
    }

    override def adjustFrameToAngle(newAngle : Angle) : Unit = {
        this.adjustFrame(newAngle.getValue())
    }

    override def adjustFrame(angle : Short) : Unit = {
        this.animationInterfaceArray(this.circularIndexUtil.getIndex()).adjustFrame(angle)
    }

    override def getAngleInfoP() : AngleInfo = {
        return this.animationInterfaceArray(this.circularIndexUtil.getIndex()).getAngleInfoP()
    }

    /**      * @return the animationInterfaceArray      */
    def getAnimationInterfaceArray() : Array[RotationAnimation] = {
        return this.animationInterfaceArray
    }

    /**      * @param animationInterfaceArray the animationInterfaceArray to set      */
    def setAnimationInterfaceArray(animationInterfaceArray : Array[RotationAnimation]) : Unit = {
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


