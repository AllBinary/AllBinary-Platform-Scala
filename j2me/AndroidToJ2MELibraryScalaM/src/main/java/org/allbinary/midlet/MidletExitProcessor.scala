/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.midlet

import _root_.javax.microedition.midlet.MIDlet
import _root_.org.allbinary.canvas.Processor

class MidletExitProcessor(param_midlet : MIDlet) extends Processor {

    private var midlet : MIDlet = null

    //Constructor
    {
        val midlet : MIDlet = param_midlet
        this.midlet = midlet
    }

    override def process() : Unit = {
        this.midlet.exit()
    }

}


