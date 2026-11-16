/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.midlet

import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvas
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import _root_.org.allbinary.graphics.displayable.command.MyCommandsFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.ABHashtable

class CreateGameRunnable(param_demoGameMidlet : DemoGameMidlet, param_hashtable : ABHashtable[Object, Object]) extends Runnable {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var demoGameMidlet : DemoGameMidlet = null

    private var hashtable : ABHashtable[Object, Object] = null

    private var startGameMidletEvent : DemoGameMidletEvent = null

    //Constructor
    {
        val demoGameMidlet : DemoGameMidlet = param_demoGameMidlet
        val hashtable : ABHashtable[Object, Object] = param_hashtable
        this.demoGameMidlet = demoGameMidlet
        this.hashtable = hashtable
        this.startGameMidletEvent = new DemoGameMidletEvent(this, DemoGameMidletStateFactory.getInstance().START_GAME)
    }

    override def run() : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START_RUNNABLE, this, this.commonStrings.RUN)
            val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
            this.demoGameMidlet.commandAction(MyCommandsFactory.getInstance().SET_DISPLAYABLE, progressCanvas)
            //progressCanvas.waitUntilDisplayed();
            this.demoGameMidlet.stopGameCanvasRunnableInterface()
            // mediaInit();
            this.demoGameMidlet.setGameCanvasRunnableInterface(this.demoGameMidlet.createGameCanvasRunnableInterface())
            this.demoGameMidlet.getGameCanvasRunnableInterface().setLoadStateHashtable(this.hashtable)
            // this.getGameCanvasRunnableInterface());
            this.demoGameMidlet.startGameCanvasRunnableInterface()
            DemoGameMidletEventHandler.getInstance().fireEvent(this.startGameMidletEvent)
            this.logUtil.putF(this.commonStrings.END_RUNNABLE, this, this.commonStrings.RUN)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.RUN, e)
            }
        }
    }

}


