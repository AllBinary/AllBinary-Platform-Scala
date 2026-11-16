/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.Command
import _root_.javax.microedition.lcdui.CommandListener
import _root_.org.allbinary.graphics.displayable.MyCanvas
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class CommandRunnable(param_commandFormInputProcessor : CommandFormInputProcessor, param_command : Command) extends Runnable {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var commandFormInputProcessor : CommandFormInputProcessor = null

    private var command : Command = null

    //Constructor
    {
        val commandFormInputProcessor : CommandFormInputProcessor = param_commandFormInputProcessor
        val command : Command = param_command
        this.commandFormInputProcessor = commandFormInputProcessor
        this.command = command
    }

    override def run() : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START_RUNNABLE, this, this.commonStrings.RUN)
            val canvas : MyCanvas = this.commandFormInputProcessor.getCanvas()
            val commandListener : CommandListener = canvas.getCustomCommandListener()
            commandListener.commandAction(this.command, canvas)
            this.logUtil.putF(this.commonStrings.END_RUNNABLE, this, this.commonStrings.RUN)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.RUN, e)
            }
        }
    }

}


