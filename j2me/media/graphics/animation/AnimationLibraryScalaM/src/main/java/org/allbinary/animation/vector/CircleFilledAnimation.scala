/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.vector

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.ColorCompositeInterface

class CircleFilledAnimation(param_width : Int, param_height : Int, param_basicColor : BasicColor) extends Animation() with ColorCompositeInterface {

    private var width : Int = 0

    private var height : Int = 0

    //Constructor
    {
        val width : Int = param_width
        val height : Int = param_height
        val basicColor : BasicColor = param_basicColor
        this.width = width
        this.height = height
        this.setBasicColorP(basicColor)
    }

    override def nextFrame() : Unit = {
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.basicSetColorUtil.setBasicColorP3(graphics, this.getBasicColorP(), this.getColor())
        //graphics.fillArc(x, y, width, height, 0, TOTAL_ANGLE);
        graphics.fillRect(x, y, this.width, this.height)
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


