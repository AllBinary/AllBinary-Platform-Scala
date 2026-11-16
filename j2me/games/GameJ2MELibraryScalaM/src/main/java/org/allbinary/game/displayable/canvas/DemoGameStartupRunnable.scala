/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.thread.ABRunnable

class DemoGameStartupRunnable(param_demoCanvas : DemoCanvas) extends ABRunnable {
    import _root_.org.allbinary.game.displayable.canvas.DemoGameStartupRunnable.{TYPE as _, *}
    def TYPE : Int = _root_.org.allbinary.game.displayable.canvas.DemoGameStartupRunnable.TYPE

    val logUtil : LogUtil = LogUtil.getInstance()

    private var demoCanvas : DemoCanvas = null

    //Constructor
    {
        val demoCanvas : DemoCanvas = param_demoCanvas
        this.demoCanvas = demoCanvas
    }

    override def run() : Unit = {
        try {
            this.setRunning(true)
            //            this.logUtil.putF(commonStrings.START, this, commonStrings.RUN);
            this.demoCanvas.stopGameDemo()
            this.demoCanvas.create()
            this.demoCanvas.start()
            this.setRunning(false)
        } catch {
            case e : Exception => {
                this.setRunning(false)
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
            }
        }
    }

    override def getType() : Int = {
        return DemoGameStartupRunnable.TYPE
    }

}

object DemoGameStartupRunnable {
    val TYPE : Int = 4

}


