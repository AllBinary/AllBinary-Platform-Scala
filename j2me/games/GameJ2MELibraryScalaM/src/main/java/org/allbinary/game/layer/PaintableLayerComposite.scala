/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.graphics.paint.PaintableInterface
import _root_.org.allbinary.layer.Layer

class PaintableLayerComposite(param_paintableArray : Array[Layer]) extends Paintable {

    private var paintableArray : Array[Layer] = null

    //Constructor
    {
        val paintableArray : Array[Layer] = param_paintableArray
        this.paintableArray = paintableArray
    }

    override def paint(graphics : Graphics) : Unit = {

        {
            var index : Int = this.paintableArray.length
            while ({ index -= 1; index } >= 0) {
                this.paintableArray(index).paint(graphics)
            }
        }
    }

    override def paintThreed(graphics : Graphics) : Unit = {
        var paintableInterface : PaintableInterface = null

        {
            var index : Int = this.paintableArray.length
            while ({ index -= 1; index } >= 0) {
                paintableInterface = this.paintableArray(index).asInstanceOf[PaintableInterface]
                paintableInterface.paintThreed(graphics)
            }
        }
    }

}


