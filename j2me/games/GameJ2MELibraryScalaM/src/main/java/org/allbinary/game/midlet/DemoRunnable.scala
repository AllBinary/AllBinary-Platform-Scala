/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.midlet

import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import _root_.org.allbinary.graphics.displayable.command.MyCommandsFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings

class DemoRunnable(param_demoGameMidlet : DemoGameMidlet) extends Runnable {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var demoGameMidlet : DemoGameMidlet = null

    private var startDemoGameMidletEvent : DemoGameMidletEvent = null

    //Constructor
    {
        val demoGameMidlet : DemoGameMidlet = param_demoGameMidlet
        this.demoGameMidlet = demoGameMidlet
        this.startDemoGameMidletEvent = new DemoGameMidletEvent(this.demoGameMidlet, DemoGameMidletStateFactory.getInstance().START_DEMO)
    }

    override def run() : Unit = {
        try {
            this.logUtil.putF(new StringMaker().append(CommonLabels.getInstance().START_LABEL).append("GameCanvasRunnableInterface").toString(), this, this.commonStrings.RUN)
            this.demoGameMidlet.commandAction(MyCommandsFactory.getInstance().SET_DISPLAYABLE, ProgressCanvasFactory.getInstance())
            // mediaInit();
            this.demoGameMidlet.setGameCanvasRunnableInterface(this.demoGameMidlet.createDemoGameCanvasRunnableInterface())
            //this.logUtil.putF("GameCanvasRunnableInterface - 1", this, this.commonStrings.RUN);
            this.demoGameMidlet.demoSetup()
            // this.getGameCanvasRunnableInterface());
            DemoGameMidletEventHandler.getInstance().fireEvent(this.startDemoGameMidletEvent)
            this.demoGameMidlet.startGameCanvasRunnableInterface()
            //this.logUtil.putF("GameCanvasRunnableInterface - 3", this, this.commonStrings.RUN);
            this.demoGameMidlet.postDemoSetup()
            this.logUtil.putF(this.commonStrings.END_RUNNABLE, this, this.commonStrings.RUN)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.RUN, e)
            }
        }
    }

}


