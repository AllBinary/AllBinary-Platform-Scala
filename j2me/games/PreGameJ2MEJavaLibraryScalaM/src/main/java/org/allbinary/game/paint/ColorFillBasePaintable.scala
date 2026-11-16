/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.paint

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.color.ColorCompositeInterface
import _root_.org.allbinary.graphics.paint.Paintable

class ColorFillBasePaintable(param_basicColor : BasicColor) extends Paintable with ColorCompositeInterface {

    var basicColor : BasicColor = BasicColorFactory.getInstance().WHITE

    var colorP : Int = 0

    //Constructor
    {
        val basicColor : BasicColor = param_basicColor
        this.setBasicColorP(basicColor)
    }

    override def setBasicColorP(basicColor : BasicColor) : Unit = {
        this.basicColor = basicColor
        this.setColor(this.getBasicColorP().intValue())
    }

    /**      * @return the basicColor      */
    override def getBasicColorP() : BasicColor = {
        return this.basicColor
    }

    /**      * @return the color      */
    def getColor() : Int = {
        return this.colorP
    }

    /**      * @param color      *            the color to set      */
    def setColor(color : Int) : Unit = {
        this.colorP = color
    }

    override def paint(graphics : Graphics) : Unit = {
    }

}


