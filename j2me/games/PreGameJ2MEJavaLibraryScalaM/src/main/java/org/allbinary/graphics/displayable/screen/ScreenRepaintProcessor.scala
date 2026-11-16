/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.displayable.screen

import _root_.javax.microedition.lcdui.Displayable
import _root_.org.allbinary.canvas.Processor

class ScreenRepaintProcessor(param_displayable : Displayable) extends Processor {

    private var displayable : Displayable = null

    //Constructor
    {
        val displayable : Displayable = param_displayable
        this.displayable = displayable
    }

    override def process() : Unit = {
        ScreenRepaintUtil.repaint(this.displayable)
    }

}


