/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.displayable.screen

import _root_.javax.microedition.lcdui.Displayable
import _root_.org.allbinary.J2MEUtil
import _root_.org.allbinary.canvas.Processor

class ScreenRepaintProcessorFactory private() {
    import _root_.org.allbinary.graphics.displayable.screen.ScreenRepaintProcessorFactory.{*}

    def create(displayable : Displayable) : Processor = {
        if (!J2MEUtil.isJ2ME()) {
            return new ScreenRepaintProcessor(displayable)
        } else {
            return Processor.getInstance()
        }
        throw new IllegalStateException()
    }

}

object ScreenRepaintProcessorFactory {
    private val instance : ScreenRepaintProcessorFactory = new ScreenRepaintProcessorFactory()

    /**      * @return the instance      */
    def getInstance() : ScreenRepaintProcessorFactory = {
        return ScreenRepaintProcessorFactory.instance
    }

}


