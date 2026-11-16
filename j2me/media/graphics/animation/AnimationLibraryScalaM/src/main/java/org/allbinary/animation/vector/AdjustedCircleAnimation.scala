/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.vector

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.AndroidUtil
import _root_.org.allbinary.graphics.color.BasicColor

/**  *  * @author user  */
class AdjustedCircleAnimation(param_width : Int, param_height : Int, param_basicColor : BasicColor) extends CircleAnimation(param_width, param_height, param_basicColor) {
    import _root_.org.allbinary.animation.vector.AdjustedCircleAnimation.{*}

    private var xAdjustment : Int = 0

    private var yAdjustment : Int = 0

    //Constructor
    {
        val width : Int = param_width
        val height : Int = param_height
        val basicColor : BasicColor = param_basicColor
    }

    private def initXY(xAdjustment : Int, yAdjustment : Int) : Unit = {
        this.xAdjustment = xAdjustment
        this.yAdjustment = yAdjustment
    }

    private def init(innerWidth : Int) : Unit = {
        if (AndroidUtil.isAndroid()) {
            var widthPortion : Int = (((innerWidth / 3) * 10) / 7)
            this.xAdjustment = -((this.width >> 1) - widthPortion)
            this.yAdjustment = this.xAdjustment
        } else {
            this.xAdjustment = -((this.width >> 1) - innerWidth)
            this.yAdjustment = this.xAdjustment
        }
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.basicSetColorUtil.setBasicColorP3(graphics, this.getBasicColorP(), this.getColor())
        graphics.drawArc(x + this.xAdjustment, y + this.yAdjustment, this.width, this.height, 0, this.TOTAL_ANGLE)
    }

}

object AdjustedCircleAnimation {
    def createAnimation(width : Int, height : Int, xAdjustment : Int, yAdjustment : Int, basicColor : BasicColor) : AdjustedCircleAnimation = {
        val adjustedCircleAnimation : AdjustedCircleAnimation = new AdjustedCircleAnimation(width, height, basicColor)
        adjustedCircleAnimation.initXY(xAdjustment, yAdjustment)
        return adjustedCircleAnimation
    }

    def createW(width : Int, height : Int, innerWidth : Int, basicColor : BasicColor) : AdjustedCircleAnimation = {
        val adjustedCircleAnimation : AdjustedCircleAnimation = new AdjustedCircleAnimation(width, height, basicColor)
        adjustedCircleAnimation.init(innerWidth)
        return adjustedCircleAnimation
    }

}


