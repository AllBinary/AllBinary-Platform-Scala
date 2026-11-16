/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.screen

import _root_.javax.microedition.lcdui.Command
import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.TextField
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.game.commands.GameCommandsFactory
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.form.item.CustomTextBox
import _root_.org.allbinary.graphics.paint.NullPaintable
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.graphics.paint.SimpleTextPaintable
import _root_.org.allbinary.input.event.VirtualKeyboardEventHandler

class LicenseRegistrationTextBox(param_cmdListener : CommandListener, param_backgrounBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends CustomTextBox(param_cmdListener, "Enter Registration Code:", StringUtil.getInstance().EMPTY_STRING, 60, TextField.ANY, Font.getDefaultFont(), param_backgrounBasicColor, param_foregroundBasicColor) {
    import _root_.org.allbinary.game.displayable.screen.LicenseRegistrationTextBox.{DISPLAY_COMMAND as _, SUBMIT_COMMAND as _, *}
    def DISPLAY_COMMAND : Command = _root_.org.allbinary.game.displayable.screen.LicenseRegistrationTextBox.DISPLAY_COMMAND
    def SUBMIT_COMMAND : Command = _root_.org.allbinary.game.displayable.screen.LicenseRegistrationTextBox.SUBMIT_COMMAND

    //implements MyCommandInterface
    val logUtil_LicenseRegistrationTextBox : LogUtil = LogUtil.getInstance()

    private val pleaseWaitPaintable : Paintable = new SimpleTextPaintable(commonStrings.PLEASE_WAIT, BasicColorFactory.getInstance().WHITE)

    private var paintable : Paintable = NullPaintable.getInstance()

    //Constructor
    {
        val cmdListener : CommandListener = param_cmdListener
        val backgrounBasicColor : BasicColor = param_backgrounBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
    }

    override def initCommands(cmdListener : CommandListener) : Unit = {
        this.removeAllCommands()
        this.addCommand(GameCommandsFactory.getInstance().CLOSE_AND_SHOW_GAME_CANVAS)
        this.addCommand(GameCommandsFactory.getInstance().TOGGLE_KEYBOARD)
        this.addCommand(SUBMIT_COMMAND)
        this.setCommandListener(cmdListener)
    }

    override def open() : Unit = {
        try {
            var virtualKeyboardEventHandler : VirtualKeyboardEventHandler = VirtualKeyboardEventHandler.getInstance()
            virtualKeyboardEventHandler.fireEvent(virtualKeyboardEventHandler.SHOW_EVENT)
        } catch {
            case e : Exception => {
                this.logUtil_LicenseRegistrationTextBox.put(commonStrings.EXCEPTION, this, "open", e)
            }
        }
        super.open()
        this.paintable = NullPaintable.getInstance()
        this.repaint()
    }

    override def close() : Unit = {
        try {
            var virtualKeyboardEventHandler : VirtualKeyboardEventHandler = VirtualKeyboardEventHandler.getInstance()
            virtualKeyboardEventHandler.fireEvent(virtualKeyboardEventHandler.HIDE_EVENT)
        } catch {
            case e : Exception => {
                this.logUtil_LicenseRegistrationTextBox.put(commonStrings.EXCEPTION, this, "open", e)
            }
        }
        this.paintable = this.pleaseWaitPaintable
        this.repaint()
        super.close()
    }

    override def paint(graphics : Graphics) : Unit = {
        super.paint(graphics)
        this.paintable.paint(graphics)
    }

    override def submit() : Unit = {
        var commandListener : CommandListener = this.getCustomCommandListener()
        commandListener.commandAction(SUBMIT_COMMAND, this)
    }

}

object LicenseRegistrationTextBox {
    val DISPLAY_COMMAND : Command = new Command("Register", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 3)

    val SUBMIT_COMMAND : Command = new Command("Submit", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 3)

}


