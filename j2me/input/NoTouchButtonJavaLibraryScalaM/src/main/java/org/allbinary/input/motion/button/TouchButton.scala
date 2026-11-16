/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationInterface
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

class TouchButton(param_touchButtonInput : TouchButtonInput, param_animationInterface : AnimationInterface, param_rawRectangle : Rectangle, param_cellPosition : CellPosition, param_xBorder : Int, param_yBorder : Int) extends Paintable {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var touchButtonInput : TouchButtonInput = null

    private var animationInterface : Animation = null

    var rawRectangle : Rectangle = null

    var xBorder : Int = 0

    var yBorder : Int = 0

    var rectangle : Rectangle = RectangleFactory.SINGLETON

    var cellPosition : CellPosition = null

    var animationX : Int = 0

    var animationY : Int = 0

    //Constructor
    {
        val touchButtonInput : TouchButtonInput = param_touchButtonInput
        val animationInterface : AnimationInterface = param_animationInterface
        val rawRectangle : Rectangle = param_rawRectangle
        val cellPosition : CellPosition = param_cellPosition
        val xBorder : Int = param_xBorder
        val yBorder : Int = param_yBorder
        this.touchButtonInput = touchButtonInput
        this.animationInterface = animationInterface.asInstanceOf[Animation]
        this.rawRectangle = rawRectangle
        this.cellPosition = cellPosition
        this.xBorder = xBorder
        this.yBorder = yBorder
        this.updateRectangle()
        this.logUtil.putF(new StringMaker().append("Created: ").append(this.toString()).toString(), this, this.commonStrings.CONSTRUCTOR)
    }

    override def paint(graphics : Graphics) : Unit = {
        this.animationInterface.paintXY(graphics, animationX, this.animationY)
    }

    //This would probably be better as a builder
    def updateRectangle() : Unit = {
        try {
            val x : Int = this.rawRectangle.getWidth() * this.cellPosition.getColumn()
            val y : Int = this.rawRectangle.getHeight() * this.cellPosition.getRow()
            val pointFactory : PointFactory = PointFactory.getInstance()
            this.rectangle = new Rectangle(pointFactory.createXY(x + this.xBorder, y + this.yBorder), this.rawRectangle.getWidth(), this.rawRectangle.getHeight())
            val point : GPoint = this.rectangle.getPoint()
            this.animationX = point.getX()
            this.animationY = point.getY()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "updateRectangle", e)
            }
        }
    }

    /*     public void setCellPosition(CellPosition cellPosition)     {         this.cellPosition = cellPosition;         this.updateRectangle();     }     */
    def getCellPositionP() : CellPosition = {
        return this.cellPosition
    }

    def getRectangleP() : Rectangle = {
        return this.rectangle
    }

    def getTouchButtonInput() : TouchButtonInput = {
        return this.touchButtonInput
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        val stringUtil : StringUtil = StringUtil.getInstance()
        stringBuffer.append("TouchButton: ")
        stringBuffer.append(stringUtil.toString(this.rectangle))
        stringBuffer.append(" CellPosition: ")
        stringBuffer.append(stringUtil.toString(this.cellPosition))
        stringBuffer.append(" xBorder: ")
        stringBuffer.appendint(this.xBorder)
        stringBuffer.append(" yBorder: ")
        stringBuffer.appendint(this.yBorder)
        return stringBuffer.toString()
    }

}


