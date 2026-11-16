/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration

import _root_.javax.microedition.lcdui.Choice
import _root_.javax.microedition.lcdui.Command
import _root_.javax.microedition.lcdui.CommandListener
import _root_.org.allbinary.game.commands.GameCommandsFactory
import _root_.org.allbinary.game.configuration.feature.GameFeatureFormUtil
import _root_.org.allbinary.game.configuration.feature.InGameFeatureChoiceGroups
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.displayable.screen.CommandForm
import _root_.org.allbinary.logic.string.StringUtil

class InGameOptionsForm(param_commandListener : CommandListener, param_title : String, param_backgrounBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends CommandForm(param_commandListener, param_title, param_backgrounBasicColor, param_foregroundBasicColor) {
    import _root_.org.allbinary.game.configuration.InGameOptionsForm.{DISPLAY as _, SAVE as _, DEFAULT as _, *}
    def DISPLAY : Command = _root_.org.allbinary.game.configuration.InGameOptionsForm.DISPLAY
    def SAVE : Command = _root_.org.allbinary.game.configuration.InGameOptionsForm.SAVE
    def DEFAULT : Command = _root_.org.allbinary.game.configuration.InGameOptionsForm.DEFAULT

    //Constructor
    {
        val commandListener : CommandListener = param_commandListener
        val title : String = param_title
        val backgrounBasicColor : BasicColor = param_backgrounBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        val gameFeatureFormUtil : GameFeatureFormUtil = GameFeatureFormUtil.getInstance()
        gameFeatureFormUtil.addChoiceGroup(this, InGameFeatureChoiceGroups.getExclusiveInstance().get(), Choice.EXCLUSIVE)
        gameFeatureFormUtil.addChoiceGroup(this, InGameFeatureChoiceGroups.getMultipleInstance().get(), Choice.MULTIPLE)
        this.initCommands(commandListener)
    }

    override def initCommands(cmdListener : CommandListener) : Unit = {
        this.removeAllCommands()
        this.addCommand(GameCommandsFactory.getInstance().CLOSE_AND_SHOW_GAME_CANVAS)
        this.addCommand(InGameOptionsForm.DEFAULT)
        this.setCommandListener(cmdListener)
    }

}

object InGameOptionsForm {
    val DISPLAY : Command = new Command("Options In Game", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val SAVE : Command = new Command("Save", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val DEFAULT : Command = new Command("Default", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

}


