/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.midlet

import _root_.javax.microedition.lcdui.NullCanvas
import _root_.org.allbinary.canvas.Processor
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class ExitRunnable(param_midlet : AllBinaryMidlet, param_processor : Processor, param_isProgress : Boolean) extends Runnable {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var midlet : AllBinaryMidlet = null

    private var processor : Processor = null

    private var isProgress : Boolean = false

    //Constructor
    {
        val midlet : AllBinaryMidlet = param_midlet
        val processor : Processor = param_processor
        val isProgress : Boolean = param_isProgress
        this.midlet = midlet
        this.isProgress = isProgress
        this.processor = processor
    }

    override def run() : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START_RUNNABLE, this, this.commonStrings.RUN)
            this.midlet.destroyAppInRunnable(false, this.isProgress)
            // Why set to null
            this.midlet.setDisplay(NullCanvas.NULL_CANVAS)
            // when resuming from onSaveInstanceState
            this.midlet.notifyDestroyed()
            this.logUtil.putF(this.commonStrings.END_RUNNABLE, this, this.commonStrings.RUN)
            this.processor.process()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.RUN, e)
                try {
                    this.processor.process()
                } catch {
                    case e2 : Exception => {
                        this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.RUN, e)
                    }
                }
            }
        }
    }

}


