/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.paint

import _root_.javax.microedition.lcdui.Graphics

class StringLocationPaintable(param_value : String) extends LocationPaintable {

    private var value : String = null

    //Constructor
    {
        val value : String = param_value
        this.value = value
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        graphics.drawString(this.value, x, y, 0)
    }

}


