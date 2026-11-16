/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary * * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. * * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. * * Created By: Travis Berthelot * */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.canvas.transition.progress

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.paint.Paintable

class ProgressPaintable(param_progressCanvas : ProgressCanvas) extends Paintable {

    private var progressCanvas : ProgressCanvas = null

    //Constructor
    {
        val progressCanvas : ProgressCanvas = param_progressCanvas
        this.progressCanvas = progressCanvas
    }

    override def paint(graphics : Graphics) : Unit = {
        this.progressCanvas.paint2(graphics)
    }

}


