/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary * * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. * * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. * * Created By: Travis Berthelot * */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.org.allbinary.game.score.displayable.HighScoreTextBox
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvas
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class SaveHighScoreRunnable(param_isLast : Boolean, param_textBox : HighScoreTextBox) extends Runnable {

    private val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()

    //Fields instead of the captured locals so the class does not need the enclosing method, such as in C#
    private var isLast : Boolean = false

    private var textBox : HighScoreTextBox = null

    //Constructor
    {
        val isLast : Boolean = param_isLast
        val textBox : HighScoreTextBox = param_textBox
        this.isLast = isLast
        this.textBox = textBox
    }

    override def run() : Unit = {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            //                        progressCanvas.addPortion(6, "Saving High Score");
            if (this.isLast) {
                this.textBox.submit()
            } else {
                this.textBox.saveHighScore()
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                logUtil.put(commonStrings.EXCEPTION, this, "run", e)
                this.progressCanvas.end()
            }
        }
    }

}


