/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.math.PrimitiveIntUtil
import _root_.org.allbinary.util.CircularIndexUtil

class VectorAnimation(param_currentPoints : Array[Array[Array[Int]]], param_basicColor : BasicColor, param_animationBehavior : AnimationBehavior) extends IndexedAnimation(param_animationBehavior) with VectorAnimationInterface {
    import _root_.org.allbinary.animation.VectorAnimation.{*}

    private var currentPoints : Array[Array[Array[Int]]] = NullUtil.getInstance().NULL_INT_ARRAY_ARRAY_ARRAY

    private var circularIndexUtil : CircularIndexUtil = CircularIndexUtil.createInstance(0)

    //Constructor
    {
        val currentPoints : Array[Array[Array[Int]]] = param_currentPoints
        val basicColor : BasicColor = param_basicColor
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.setPoints(currentPoints)
        this.setBasicColorP(basicColor)
    }

    override def setBasicColorP(basicColor : BasicColor) : Unit = {
        var changed : Boolean = false
        if ((this.getBasicColorP() == null) || (this.getBasicColorP().intValue() != basicColor.intValue())) {
            changed = true
        }
        super.setBasicColorP(basicColor)
        if (changed) {
            //            this.setColorProcessor = SetColorProcessor.getInstance();
            this.updateModifiers()
        }
    }

    override def changeBasicColor(basicColor : BasicColor) : Unit = {
        var changed : Boolean = false
        //if(this.getBasicColorP() == null || this.getBasicColorP().intValue() != basicColor.intValue()) {
        if ((this.getChangeBasicColor() == null) || (this.getChangeBasicColor().intValue() != basicColor.intValue())) {
            changed = true
        }
        super.changeBasicColor(basicColor)
        if (changed) {
            //            this.changeColorProcessor = ChangeColorProcessor.getInstance();
            this.updateModifiers()
        }
    }

    override def setAlpha(alpha : Int) : Unit = {
        var changed : Boolean = false
        if (this.alphaP != alpha) {
            changed = true
        }
        super.setAlpha(alpha)
        if (changed) {
            //            this.alphaProcessor = AlphaProcessor.getInstance();
            this.updateModifiers()
        }
    }

    override def setScale(scaleX : Float, scaleY : Float) : Unit = {
    }

    override def setMaxScale(maxScaleX : Float, maxScaleY : Float) : Unit = {
    }

    private def updateModifiers() : Unit = {
    }

    override def getAnimationSize() : Int = {
        return this.getSize()
    }

    override def getSize() : Int = {
        return this.currentPoints.length
    }

    override def setSequence(sequence : Array[Int]) : Unit = {
    }

    override def getSequence() : Array[Int] = {
        return PrimitiveIntUtil.getArrayInstance()
    }

    override def nextFrame() : Unit = {
        this.circularIndexUtil.next()
    }

    override def previousFrame() : Unit = {
        this.circularIndexUtil.previous()
    }

    def paintVectors(graphics : Graphics, x : Int, y : Int) : Unit = {
        try {
            /*              * if (this.currentFrame >= this.currentPoints.length) {              * this.currentFrame = 0; }              */
            var nextPointX : Int = 0
            var nextPointY : Int = 0
            var nextPoint : Array[Int] = null
            var point : Array[Int] = null
            val currentPointsFrame : Array[Array[Int]] = this.currentPoints(this.circularIndexUtil.getIndex())
            val size : Int = currentPointsFrame.length
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

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.basicSetColorUtil.setBasicColorP(graphics, this.basicColor)
        this.paintVectors(graphics, x, y)
    }

    override def getFrame() : Int = {
        return this.circularIndexUtil.getIndex()
    }

    override def setFrame(index : Int) : Unit = {
        this.circularIndexUtil.setIndex(index)
    }

    override def getPoints(frame : Int) : Array[Array[Int]] = {
        return this.currentPoints(frame)
    }

    def setPoints(currentPoints : Array[Array[Array[Int]]]) : Unit = {
        this.currentPoints = currentPoints
        this.circularIndexUtil = CircularIndexUtil.createInstance(currentPoints.length)
    }

    //Needed for polyglot do not remove
    override def getBasicColorP() : BasicColor = {
        return super.getBasicColorP()
    }

}

object VectorAnimation {
    def createVectorAnimation(currentPoints2 : Array[Array[Int]], basicColor : BasicColor, animationBehavior : AnimationBehavior) : VectorAnimation = {
        val currentPoints : Array[Array[Array[Int]]] = Array.ofDim[Int](1, currentPoints2.length, 2)
        var size : Int = currentPoints2.length

        {
            var index : Int = 0
            while (index < size) {
                currentPoints(0)(index)(0) = currentPoints2(index)(0)
                currentPoints(0)(index)(1) = currentPoints2(index)(1)
                index += 1
            }
        }
        return new VectorAnimation(currentPoints, basicColor, animationBehavior)
    }

}


