/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration

import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.TextField
import _root_.org.allbinary.MIDPUtil
import _root_.org.allbinary.game.commands.GameCommandsFactory
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.displayable.screen.CommandForm
import _root_.org.allbinary.logic.ABSystemWrapper

class SaveGameForm private(param_commandListener : CommandListener, param_title : String, param_backgrounBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends CommandForm(param_commandListener, param_title, param_backgrounBasicColor, param_foregroundBasicColor) {
    import _root_.org.allbinary.game.configuration.SaveGameForm.{*}

    private val meUtil : MIDPUtil = MIDPUtil.getInstance()

    //Constructor
    {
        val commandListener : CommandListener = param_commandListener
        val title : String = param_title
        val backgrounBasicColor : BasicColor = param_backgrounBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        var timeString : String = _root_.java.lang.Long.toString(ABSystemWrapper.getInstance().currentTimeMillis())
        this.meUtil.appendItem(this, new TextField("Name: ", timeString, 30, TextField.ANY))
        this.initCommands(commandListener)
    }

    override def initCommands(cmdListener : CommandListener) : Unit = {
        val gameCommandsFactory : GameCommandsFactory = GameCommandsFactory.getInstance()
        this.removeAllCommands()
        this.addCommand(gameCommandsFactory.SAVE)
        this.addCommand(gameCommandsFactory.CLOSE_AND_SHOW_GAME_CANVAS)
        this.setCommandListener(cmdListener)
    }

}

object SaveGameForm {
    private var FORM : CommandForm = CommandForm.getNullCommandForm()

    def createForm(commandListener : CommandListener, title : String, backgrounBasicColor : BasicColor, foregroundBasicColor : BasicColor) : CommandForm = {
        SaveGameForm.FORM = new SaveGameForm(commandListener, title, backgrounBasicColor, foregroundBasicColor)
        return SaveGameForm.FORM
    }

    def getInstance() : CommandForm = {
        return SaveGameForm.FORM
    }

}


