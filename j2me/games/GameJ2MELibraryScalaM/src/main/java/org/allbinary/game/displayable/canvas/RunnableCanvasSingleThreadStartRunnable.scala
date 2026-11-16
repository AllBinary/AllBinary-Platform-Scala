/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.org.allbinary.canvas.RunnableCanvas
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class RunnableCanvasSingleThreadStartRunnable(param_demoCanvas : RunnableCanvas) extends GameRunnable {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var runnableCanvas : RunnableCanvas = null

    //Constructor
    {
        val demoCanvas : RunnableCanvas = param_demoCanvas
        this.runnableCanvas = demoCanvas
    }

    override def run() : Unit = {
        try {
            this.runnableCanvas.run()
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
            }
        }
    }

    override def processLoopSleep() : Unit = {
        this.runnableCanvas.processLoopSleep()
    }

}


