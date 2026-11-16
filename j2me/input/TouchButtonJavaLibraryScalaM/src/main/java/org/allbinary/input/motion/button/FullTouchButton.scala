/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory
import _root_.org.allbinary.graphics.CellPosition
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.Rectangle

class FullTouchButton(param_touchButtonInput : TouchButtonInput, param_animationInterface : Animation, param_hintAnimationInterface : Animation, param_rawRectangle : Rectangle, param_cellPosition : CellPosition, param_xBorder : Int, param_yBorder : Int) extends TouchButton(param_touchButtonInput, param_animationInterface, param_hintAnimationInterface, param_rawRectangle, param_cellPosition, param_xBorder, param_yBorder) {
    import _root_.org.allbinary.input.motion.button.FullTouchButton.{*}

    //Constructor
    {
        val touchButtonInput : TouchButtonInput = param_touchButtonInput
        val animationInterface : Animation = param_animationInterface
        val hintAnimationInterface : Animation = param_hintAnimationInterface
        val rawRectangle : Rectangle = param_rawRectangle
        val cellPosition : CellPosition = param_cellPosition
        val xBorder : Int = param_xBorder
        val yBorder : Int = param_yBorder
    }

    override def updateRectangle() : Unit = {
        try {
            val pointFactory : PointFactory = PointFactory.getInstance()
            val x : Int = this.rawRectangle.getWidth() * this.cellPositionP.getColumn()
            val y : Int = this.rawRectangle.getHeight() * this.cellPositionP.getRow()
            this.rectangleP = new Rectangle(pointFactory.createXY(x, y), this.rawRectangle.getWidth() + (2 * this.xBorder), this.rawRectangle.getHeight() + (2 * this.yBorder))
            val point : GPoint = this.rectangleP.getPoint()
            this.animationX = point.getX() + this.xBorder
            this.animationY = point.getY() + this.yBorder
            this.hintAnimationY = (this.animationY - this.rectangleP.getHeight()) >> 1
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "updateRectangle", e)
            }
        }
    }

}

object FullTouchButton {
    def createButton(touchButtonInput : TouchButtonInput, touchButtonResource : TouchButtonResource, rawRectangle : Rectangle, cellPosition : CellPosition, xBorder : Int, yBorder : Int) : FullTouchButton = {
        return new FullTouchButton(touchButtonInput, FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance().get(touchButtonResource.RESOURCE).getInstance(0), FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance().get(touchButtonResource.HINT).getInstance(0), rawRectangle, cellPosition, xBorder, yBorder)
    }

}


