/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.direction.Direction
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.math.Angle
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.math.AngleInfo

class VectorRotationAnimation(param_currentPoints : Array[Array[Array[Int]]], param_basicColor : BasicColor, param_animationBehavior : AnimationBehavior) extends VectorBaseRotationAnimation(AngleInfo.getInstance((AngleFactory.getInstance().TOTAL_ANGLE / param_currentPoints.length).toShort), param_currentPoints, param_basicColor, param_animationBehavior) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    //Constructor
    {
        val currentPoints : Array[Array[Array[Int]]] = param_currentPoints
        val basicColor : BasicColor = param_basicColor
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.angleInfo.adjustAngle(this.getFrame())
    }

    override def setFrameByDirection(direction : Direction) : Unit = {
        var angle : Angle = this.directionUtil.getFrameAngle(direction)
        this.adjustFrameToAngle(angle)
    }

    override def setFrameToAngle(angle : Angle) : Unit = {
        this.adjustFrameToAngle(angle)
    }

    override def setFrame(index : Int) : Unit = {
        super.setFrame(index)
        this.angleInfo.adjustAngle(this.getFrame())
    }

    override def adjustFrame(newAngle : Short) : Unit = {
        this.setFrame(this.frameUtil.getFrameForAngle(newAngle, this.angleInfo.getAngleIncrementInfo().getAngleIncrement().toInt))
    }

    override def adjustFrameToAngle(newAngle : Angle) : Unit = {
        this.adjustFrame(newAngle.getValue())
    }

}


