/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.time.GameTickTimeDelayHelper
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory

class DemoGameRunnable(param_demoCanvas : DemoCanvas) extends GameRunnable {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var demoCanvas : DemoCanvas = null

    private val gameTickTimeDelayHelper : GameTickTimeDelayHelper = GameTickTimeDelayHelperFactory.getInstance()

    //Constructor
    {
        val demoCanvas : DemoCanvas = param_demoCanvas
        this.demoCanvas = demoCanvas
    }

    override def run() : Unit = {
        try {
            //final AllBinaryGameCanvas allBinaryGameCanvas = this.allBinaryGameCanvas;
            this.demoCanvas.getLoopTimeHelperP().setStartTime(this.gameTickTimeDelayHelper.setStartTime())
            this.demoCanvas.processGame()
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
            }
        }
    }

    override def processLoopSleep() : Unit = {
        this.demoCanvas.processLoopSleep()
    }

}


