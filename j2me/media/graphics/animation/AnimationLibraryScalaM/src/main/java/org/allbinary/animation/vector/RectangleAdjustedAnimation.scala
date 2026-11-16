/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.vector

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.ColorCompositeInterface

class RectangleAdjustedAnimation(param_width : Int, param_height : Int, param_offsetX : Int, param_offsetY : Int, param_basicColor : BasicColor) extends Animation with ColorCompositeInterface {

    private var width : Int = 0

    private var height : Int = 0

    private var offsetX : Int = 0

    private var offsetY : Int = 0

    //Constructor
    {
        val width : Int = param_width
        val height : Int = param_height
        val offsetX : Int = param_offsetX
        val offsetY : Int = param_offsetY
        val basicColor : BasicColor = param_basicColor
        this.width = width
        this.height = height
        this.offsetX = offsetX
        this.offsetY = offsetY
        this.setBasicColorP(basicColor)
    }

    override def nextFrame() : Unit = {
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.basicSetColorUtil.setBasicColorP3(graphics, this.getBasicColorP(), this.getColor())
        graphics.drawRect(x + this.offsetX, y + this.offsetY, this.width, this.height)
    }

    /**      * @param width the width to set      */
    def setWidth(width : Int) : Unit = {
        this.width = width
    }

    /**      * @param height the height to set      */
    def setHeight(height : Int) : Unit = {
        this.height = height
    }

    /**      * @param offsetX the offsetX to set      */
    def setOffsetX(offsetX : Int) : Unit = {
        this.offsetX = offsetX
    }

    /**      * @param offsetY the offsetY to set      */
    def setOffsetY(offsetY : Int) : Unit = {
        this.offsetY = offsetY
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


