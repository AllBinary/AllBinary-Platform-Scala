/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.math.PrimitiveIntUtil
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.util.CircularIndexUtil

class VectorBaseRotationAnimation(param_angleInfo : AngleInfo, param_currentPoints : Array[Array[Array[Int]]], param_basicColor : BasicColor, param_animationBehavior : AnimationBehavior) extends RotationAnimation(param_angleInfo, CircularIndexUtil.createInstance(360 / param_angleInfo.getAngleIncrementInfo().getAngleIncrement()), param_animationBehavior) with VectorAnimationInterface {

    private var currentPoints : Array[Array[Array[Int]]] = NullUtil.getInstance().NULL_INT_ARRAY_ARRAY_ARRAY

    //Constructor
    {
        val angleInfo : AngleInfo = param_angleInfo
        val currentPoints : Array[Array[Array[Int]]] = param_currentPoints
        val basicColor : BasicColor = param_basicColor
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.setPoints(currentPoints)
        this.setBasicColorP(basicColor)
    }

    //    }
    override def getAnimationSize() : Int = {
        return this.getSize()
    }

    override def getFrame() : Int = {
        return this.circularIndexUtil.getIndex()
    }

    override def setFrame(index : Int) : Unit = {
        this.circularIndexUtil.setIndex(index)
    }

    override def nextFrame() : Unit = {
        this.circularIndexUtil.next()
    }

    override def previousFrame() : Unit = {
        this.circularIndexUtil.previous()
    }

    override def getSize() : Int = {
        return this.currentPoints.length
    }

    override def setSequence(sequence : Array[Int]) : Unit = {
    }

    override def getSequence() : Array[Int] = {
        return PrimitiveIntUtil.getArrayInstance()
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.basicSetColorUtil.setBasicColorP(graphics, this.basicColor)
        try {
            /*              * if (this.currentFrame >= this.currentPoints.length) {              * this.currentFrame = 0; }              */
            var nextPointX : Int = 0
            var nextPointY : Int = 0
            var nextPoint : Array[Int] = null
            var point : Array[Int] = null
            val currentPointsFrame : Array[Array[Int]] = this.currentPoints(this.circularIndexUtil.getIndex())
            val size : Int = currentPointsFrame.length
            //3;
            var index : Int = size - 2

            {
                while ({ index -= 1; index } >= 0) {
                    nextPoint = currentPointsFrame(index)
                    point = currentPointsFrame(index + 1)
                    nextPointX = nextPoint(0)
                    nextPointY = nextPoint(1)
                    if (nextPointX != 1000) {
                        // + this.currentPoints[this.currentFrame][index][1] + y, // this, // canvasStrings.PAINT);
                        graphics.drawLine(point(0) + x, point(1) + y, nextPointX + x, nextPointY + y)
                    } else {
                        index -= 1
                    }
                }
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "paintVectors", e)
            }
        }
    }

    override def getPoints(frame : Int) : Array[Array[Int]] = {
        return this.currentPoints(frame)
    }

    def setPoints(currentPoints : Array[Array[Array[Int]]]) : Unit = {
        this.currentPoints = currentPoints
        this.circularIndexUtil = CircularIndexUtil.createInstance(this.currentPoints.length)
    }

    //Needed for polyglot do not remove
    override def getBasicColorP() : BasicColor = {
        return super.getBasicColorP()
    }

    //Needed for polyglot do not remove
    override def setBasicColorP(basicColor : BasicColor) : Unit = {
        super.setBasicColorP(basicColor)
    }

}


