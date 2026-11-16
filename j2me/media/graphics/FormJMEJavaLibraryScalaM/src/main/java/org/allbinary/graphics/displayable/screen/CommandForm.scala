/*  * AllBinary Open License Version 1  * Copyright (c) 2002 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.displayable.screen

import _root_.javax.microedition.lcdui.Command
import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.Form
import _root_.javax.microedition.lcdui.NullCommandListener
import _root_.org.allbinary.canvas.Processor
import _root_.org.allbinary.game.displayable.canvas.MenuListener
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.displayable.command.MyCommandInterface
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.ABStack

class CommandForm(param_commandListener : CommandListener, param_formTitle : String, param_backgrounBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends Form(param_formTitle) with MyCommandInterface with MenuListener {
    import _root_.org.allbinary.graphics.displayable.screen.CommandForm.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val repaintProcessor : Processor = ScreenRepaintProcessorFactory.getInstance().create(this)

    private var commandStack : ABStack[Object] = null

    //Constructor
    {
        val commandListener : CommandListener = param_commandListener
        val formTitle : String = param_formTitle
        val backgrounBasicColor : BasicColor = param_backgrounBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        this.commandStack = StdUtil.getInstance().createStack()
        try {
            this.repaintProcessor.process()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.CONSTRUCTOR, e)
            }
        }
    }

    def initCommands(cmdListener : CommandListener) : Unit = {
    }

    override def open() : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, "open")
    }

    override def close() : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CLOSE)
    }

    def update() : Unit = {
        this.repaintProcessor.process()
    }

    override def getSourceId() : Int = {
        return 0
    }

    override def addCommand(command : Command) : Unit = {
        this.commandStack.push(command)
        super.addCommand(command)
    }

    override def removeAllCommands() : Unit = {
        val size : Int = this.commandStack.size()

        {
            var index : Int = 0
            while (index < size) {
                super.removeCommand(this.commandStack.pop().asInstanceOf[Command])
                index += 1
            }
        }
    }

}

object CommandForm {
    private var NULL_COMMAND_FORM : Object = NullUtil.getInstance().NULL_OBJECT

    def getNullCommandForm() : CommandForm = {
        if (CommandForm.NULL_COMMAND_FORM eq NullUtil.getInstance().NULL_OBJECT) {
            CommandForm.NULL_COMMAND_FORM = new CommandForm(NullCommandListener.NULL_COMMAND_LISTENER, StringUtil.getInstance().EMPTY_STRING, BasicColorFactory.getInstance().BLACK, BasicColorFactory.getInstance().WHITE)
        }
        return CommandForm.NULL_COMMAND_FORM.asInstanceOf[CommandForm]
    }

}


