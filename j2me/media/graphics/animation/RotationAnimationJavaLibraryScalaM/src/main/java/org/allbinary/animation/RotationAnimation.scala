/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.direction.Direction
import _root_.org.allbinary.direction.DirectionUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.math.Angle
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.math.FrameUtil
import _root_.org.allbinary.util.CircularIndexUtil

class RotationAnimation(param_angleInfo : AngleInfo, param_circularIndexUtil : CircularIndexUtil, param_animationBehavior : AnimationBehavior) extends IndexedAnimation(param_animationBehavior) with RotationAnimationInterface {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    val frameUtil : FrameUtil = FrameUtil.getInstance()

    val directionUtil : DirectionUtil = DirectionUtil.getInstance()

    var angleInfo : AngleInfo = null

    var circularIndexUtil : CircularIndexUtil = null

    //Constructor
    {
        val angleInfo : AngleInfo = param_angleInfo
        val circularIndexUtil : CircularIndexUtil = param_circularIndexUtil
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.angleInfo = angleInfo
        this.circularIndexUtil = circularIndexUtil
    }

    def nextRotationX() : Unit = {
    }

    def previousRotationX() : Unit = {
    }

    override def nextRotation() : Unit = {
        //super.nextFrame();
        this.angleInfo.adjustAngle(this.circularIndexUtil.next())
    }

    override def previousRotation() : Unit = {
        //super.previousFrame();
        this.angleInfo.adjustAngle(this.circularIndexUtil.previous())
    }

    def nextRotationZ() : Unit = {
    }

    def previousRotationZ() : Unit = {
    }

    override def setFrame(index : Int) : Unit = {
        //int currentFrame = this.circularIndexUtil.getIndex();
        this.circularIndexUtil.setIndex(index)
        val newFrame : Int = this.circularIndexUtil.getIndex()
        //this.logUtil.putF("newFrame: " + newFrame, this, "setRotation");
        this.angleInfo.adjustAngle(newFrame)
    }

    override def setFrameByDirection(direction : Direction) : Unit = {
        /*         DirectionFactory directionFactory = DirectionFactory.getInstance();                  if(directionFactory.UP == direction)         {             this.circularIndexUtil.setIndex(0);         }         else             if(directionFactory.DOWN == direction)             {                 this.circularIndexUtil.setIndex(2);             }             else                 if(directionFactory.LEFT == direction)                 {                     this.circularIndexUtil.setIndex(3);                 }                 else                     if(directionFactory.RIGHT == direction)                     {                         this.circularIndexUtil.setIndex(1);                     }          this.angleInfo.adjustAngle(this.circularIndexUtil.getIndex());         */
        val angle : Angle = this.directionUtil.getFrameAngle(direction)
        this.adjustFrameToAngle(angle)
    }

    override def setFrameToAngle(angle : Angle) : Unit = {
        this.adjustFrameToAngle(angle)
    }

    override def adjustFrameToAngle(angle : Angle) : Unit = {
        this.adjustFrame(angle.getValue())
    }

    override def adjustFrame(angle : Short) : Unit = {
        this.setFrame(this.frameUtil.getFrameForAngle(angle, this.angleInfo.getAngleIncrementInfo().getAngleIncrement().toInt))
    }

    override def getFrame() : Int = {
        return this.circularIndexUtil.getIndex()
    }

    override def getSize() : Int = {
        return this.circularIndexUtil.getSize()
    }

    override def getAngleInfoP() : AngleInfo = {
        return this.angleInfo
    }

    override def toString() : String = {
        return new StringMaker().append(super.toString()).append("circularIndexUtil: ").append(this.circularIndexUtil.toString()).append("angleInfo: ").append(this.angleInfo.toString()).toString()
    }

}


