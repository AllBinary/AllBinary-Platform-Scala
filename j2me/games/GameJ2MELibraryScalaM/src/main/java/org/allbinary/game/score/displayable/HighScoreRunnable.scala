/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score.displayable

import _root_.org.allbinary.J2MEUtil
import _root_.org.allbinary.logic.ABSystemWrapper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.thread.ARunnable

class HighScoreRunnable(param_highScoresCanvas : HighScoresCanvas) extends ARunnable {

    var highScoresCanvas : HighScoresCanvas = null

    //Constructor
    {
        val highScoresCanvas : HighScoresCanvas = param_highScoresCanvas
        this.highScoresCanvas = highScoresCanvas
    }

    override def run() : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        val logUtil : LogUtil = LogUtil.getInstance()
        val highScoresCanvas : HighScoresCanvas = this.highScoresCanvas
        try {
            val isHTML : Boolean = J2MEUtil.isHTML()
            if (!isHTML) {

                {
                    while (!highScoresCanvas.hasPainted) {
                    }
                }
                highScoresCanvas.hasPainted = false
            }
            val stringMaker : StringMaker = new StringMaker()
            val systemWrapper : ABSystemWrapper = ABSystemWrapper.getInstance()
            val currentTimeMillis : Long = systemWrapper.currentTimeMillis()
            logUtil.putF(stringMaker.append("HighScoresCanvas - Request repaint to be sure: ").appendlong(currentTimeMillis).toString(), this, commonStrings.RUN)
            highScoresCanvas.repaintBehavior.onChangeRepaint(highScoresCanvas)
            if (!isHTML) {

                {
                    while (!highScoresCanvas.hasPainted) {
                    }
                }
            }
            stringMaker.delete(0, stringMaker.length())
            logUtil.putF(stringMaker.append("HighScoresCanvas - Now that the canvas has completed repaint go ahead and fetch the scores: ").appendlong(currentTimeMillis).toString(), this, commonStrings.RUN)
            highScoresCanvas.executeUpdate()
        } catch {
            case e : Exception => {
                logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
            }
        }
    }

}


