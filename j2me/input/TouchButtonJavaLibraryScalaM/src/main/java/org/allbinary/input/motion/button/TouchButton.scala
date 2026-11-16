/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory
import _root_.org.allbinary.graphics.CellPosition
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.RectangleFactory
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings

class TouchButton(param_touchButtonInput : TouchButtonInput, param_animationInterface : Animation, param_hintAnimationInterface : Animation, param_rawRectangle : Rectangle, param_cellPosition : CellPosition, param_xBorder : Int, param_yBorder : Int) extends Paintable {
    import _root_.org.allbinary.input.motion.button.TouchButton.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var touchButtonInput : TouchButtonInput = null

    private var animationInterface : Animation = null

    private var hintAnimationInterface : Animation = null

    var rawRectangle : Rectangle = null

    var xBorder : Int = 0

    var yBorder : Int = 0

    var rectangleP : Rectangle = RectangleFactory.SINGLETON

    var cellPositionP : CellPosition = null

    var animationX : Int = 0

    var animationY : Int = 0

    var hintAnimationY : Int = 0

    //Constructor
    {
        val touchButtonInput : TouchButtonInput = param_touchButtonInput
        val animationInterface : Animation = param_animationInterface
        val hintAnimationInterface : Animation = param_hintAnimationInterface
        val rawRectangle : Rectangle = param_rawRectangle
        val cellPosition : CellPosition = param_cellPosition
        val xBorder : Int = param_xBorder
        val yBorder : Int = param_yBorder
        this.touchButtonInput = touchButtonInput
        this.animationInterface = animationInterface
        this.hintAnimationInterface = hintAnimationInterface
        this.rawRectangle = rawRectangle
        this.cellPositionP = cellPosition
        this.xBorder = xBorder
        this.yBorder = yBorder
        this.updateRectangle()
        this.logUtil.putF(new StringMaker().append("Created: ").append(this.toString()).toString(), this, this.commonStrings.CONSTRUCTOR)
    }

    def paintHint(graphics : Graphics) : Unit = {
        this.hintAnimationInterface.paintXY(graphics, this.animationX, this.hintAnimationY)
    }

    override def paint(graphics : Graphics) : Unit = {
        this.animationInterface.paintXY(graphics, this.animationX, this.animationY)
    }

    //This would probably be better as a builder
    def updateRectangle() : Unit = {
        try {
            val pointFactory : PointFactory = PointFactory.getInstance()
            val x : Int = this.rawRectangle.getWidth() * this.cellPositionP.getColumn()
            val y : Int = this.rawRectangle.getHeight() * this.cellPositionP.getRow()
            this.rectangleP = new Rectangle(pointFactory.createXY(x + this.xBorder, y + this.yBorder), this.rawRectangle.getWidth(), this.rawRectangle.getHeight())
            val point : GPoint = this.rectangleP.getPoint()
            this.animationX = point.getX()
            this.animationY = point.getY()
            this.hintAnimationY = this.animationY - 32
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "updateRectangle", e)
            }
        }
    }

    /*     public void setCellPosition(CellPosition cellPosition)     {         this.cellPosition = cellPosition;         this.updateRectangle();     }     */
    def getCellPosition() : CellPosition = {
        return this.cellPositionP
    }

    def getRectangle() : Rectangle = {
        return this.rectangleP
    }

    def getTouchButtonInput() : TouchButtonInput = {
        return this.touchButtonInput
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        val stringUtil : StringUtil = StringUtil.getInstance()
        stringBuffer.append("TouchButton: ")
        stringBuffer.append(stringUtil.toString(this.getRectangle()))
        stringBuffer.append(" CellPosition: ")
        stringBuffer.append(stringUtil.toString(this.cellPositionP))
        stringBuffer.append(" xBorder: ")
        stringBuffer.appendint(this.xBorder)
        stringBuffer.append(" yBorder: ")
        stringBuffer.appendint(this.yBorder)
        return stringBuffer.toString()
    }

}

object TouchButton {
    def createButton(touchButtonInput : TouchButtonInput, touchButtonResource : TouchButtonResource, rawRectangle : Rectangle, cellPosition : CellPosition, xBorder : Int, yBorder : Int) : TouchButton = {
        return new TouchButton(touchButtonInput, FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance().get(touchButtonResource.RESOURCE).getInstance(0), FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance().get(touchButtonResource.HINT).getInstance(0), rawRectangle, cellPosition, xBorder, yBorder)
    }

}


