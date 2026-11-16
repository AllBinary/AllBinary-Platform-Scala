/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.paint

import _root_.javax.microedition.lcdui.Graphics

/**  *  * @author user  */
class PaintableComposite(param_paintableArray : Array[PaintableInterface]) extends Paintable {

    private var paintableArray : Array[PaintableInterface] = null

    //Constructor
    {
        val paintableArray : Array[PaintableInterface] = param_paintableArray
        this.paintableArray = paintableArray
    }

    override def paint(graphics : Graphics) : Unit = {

        {
            var index : Int = this.paintableArray.length - 1
            while (index >= 0) {
                this.paintableArray(index).paint(graphics)
                index -= 1
            }
        }
    }

    override def paintThreed(graphics : Graphics) : Unit = {

        {
            var index : Int = this.paintableArray.length - 1
            while (index >= 0) {
                this.paintableArray(index).paintThreed(graphics)
                index -= 1
            }
        }
    }

}


