/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *  * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *  * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *  * Created By: Travis Berthelot  *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.thread.ARunnable

/**  * Repaints the canvas and updates the display info on its own thread for RepaintBehavior.onChangeRepaint and  * AlwaysRepaintBehavior.repaint.  */
class RepaintRunnable(param_canvas : Canvas) extends ARunnable {

    private var canvas : Canvas = null

    //Constructor
    {
        val canvas : Canvas = param_canvas
        this.canvas = canvas
    }

    override def run() : Unit = {
        try {
            //System.out.println("TWB:RepaintBehavior:repaint");
            this.canvas.repaint()
            DisplayInfoSingleton.getInstance().process()
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                val logUtil : LogUtil = LogUtil.getInstance()
                logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
            }
        }
    }

}


