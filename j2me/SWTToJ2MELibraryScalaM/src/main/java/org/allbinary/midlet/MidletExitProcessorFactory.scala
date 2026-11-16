/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.midlet

import _root_.javax.microedition.midlet.MIDlet
import _root_.org.allbinary.AppletUtil
import _root_.org.allbinary.J2MEUtil
import _root_.org.allbinary.canvas.Processor

class MidletExitProcessorFactory {
    import _root_.org.allbinary.midlet.MidletExitProcessorFactory.{*}

    def getExitInstance(midlet : MIDlet) : Processor = {
        if (AppletUtil.isAppletLoader(midlet) || J2MEUtil.isJ2ME()) {
            return Processor.getInstance()
        } else {
            return new MidletExitProcessor(midlet)
        }
        throw new IllegalStateException()
    }

}

object MidletExitProcessorFactory {
    private val instance : MidletExitProcessorFactory = new MidletExitProcessorFactory()

    /**      * @return the instance      */
    def getInstance() : MidletExitProcessorFactory = {
        return MidletExitProcessorFactory.instance
    }

}


