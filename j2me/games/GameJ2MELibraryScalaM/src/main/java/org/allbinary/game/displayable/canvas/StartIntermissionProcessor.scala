/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.org.allbinary.canvas.Processor
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class StartIntermissionProcessor(param_gameCanvas : AllBinaryGameCanvas) extends Processor {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var gameCanvas : AllBinaryGameCanvas = null

    private val WAIT : Long = 5000

    //Constructor
    {
        val gameCanvas : AllBinaryGameCanvas = param_gameCanvas
        this.gameCanvas = gameCanvas
    }

    override def process() : Unit = {
        if (this.gameCanvas.getStartIntermissionInterface().getTimeDelayHelper().isElapsedTNT(this.WAIT)) {
            this.logUtil.putF("Intermission End", this, this.commonStrings.PROCESS)
            this.gameCanvas.getStartIntermissionInterface().setEnabled(false)
        }
    }

}


