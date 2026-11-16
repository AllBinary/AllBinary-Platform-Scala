/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.canvas

import _root_.org.allbinary.graphics.displayable.MyCanvas

class RunnableCanvasRefreshHelper(param_runnableCanvas : MyCanvas) extends Processor {

    private var runnableCanvas : MyCanvas = null

    //Constructor
    {
        val runnableCanvas : MyCanvas = param_runnableCanvas
        this.runnableCanvas = runnableCanvas
    }

    override def process() : Unit = {
        //System.out.println("TWB:RunnableCanvasRefreshHelper:process:repaint");
        this.runnableCanvas.repaint()
    }

}


