/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.org.allbinary.graphics.displayable.GameTickDisplayInfoSingleton
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.time.GameTickTimeDelayHelper
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory

class GameFrameRunnable(param_allBinaryGameCanvas : AllBinaryGameCanvas) extends GameRunnable {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val gameTickDisplayInfoSingleton : GameTickDisplayInfoSingleton = GameTickDisplayInfoSingleton.getInstance()

    private var allBinaryGameCanvas : AllBinaryGameCanvas = null

    private val gameTickTimeDelayHelper : GameTickTimeDelayHelper = GameTickTimeDelayHelperFactory.getInstance()

    //Constructor
    {
        val allBinaryGameCanvas : AllBinaryGameCanvas = param_allBinaryGameCanvas
        this.allBinaryGameCanvas = allBinaryGameCanvas
    }

    override def run() : Unit = {
        try {
            val allBinaryGameCanvas : AllBinaryGameCanvas = this.allBinaryGameCanvas
            allBinaryGameCanvas.getLoopTimeHelperP().setStartTime(this.gameTickTimeDelayHelper.setStartTime())
            this.gameTickDisplayInfoSingleton.update()
            allBinaryGameCanvas.processGame()
            if (!allBinaryGameCanvas.isRunning() || allBinaryGameCanvas.isPaused()) {
                allBinaryGameCanvas.notifyDonePainting()
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
            }
        }
    }

}


