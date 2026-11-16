/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.paint

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton

class ColorFillPaintable(param_basicColor : BasicColor) extends ColorFillBasePaintable(param_basicColor) {

    val displayInfoSingleton : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()

    //Constructor
    {
        val basicColor : BasicColor = param_basicColor
    }

    override def paint(graphics : Graphics) : Unit = {
        graphics.setColor(this.colorP)
        //graphics.fillRect(0, 0, graphics.getClipWidth(), graphics.getClipHeight());
        graphics.fillRect(0, 0, this.displayInfoSingleton.getLastWidth(), this.displayInfoSingleton.getLastHeight())
    }

}


