/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.commands

import _root_.javax.microedition.lcdui.Command
import _root_.org.allbinary.graphics.displayable.CanvasStrings
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings

class GameCommandsFactory() {
    import _root_.org.allbinary.game.commands.GameCommandsFactory.{*}

    val TOGGLE_FULLSCREEN : Command = new Command("Toggle FullScreen", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val TOGGLE_KEYBOARD : Command = new Command("Keyboard", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val SET_MENU_DISPLAYABLE : Command = new Command("Set Menu Displayable", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val APPLICATION_UPDATE : Command = new Command(CommonStrings.getInstance().UPDATE, StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val DISPLAY_ABOUT : Command = new Command(CanvasStrings.getInstance().ABOUT, StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 2)

    val OPEN_WEB_URL : Command = new Command("Open Web URL", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 2)

    //general commands
    val CLOSE_OPTIONS : Command = new Command("Back", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val DISPLAY_OPTIONS : Command = new Command(CanvasStrings.getInstance().OPTIONS, StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 2)

    val START_TRACE : Command = new Command("Start Trace", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val STOP_TRACE : Command = new Command("Stop Trace", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val DEFAULT_OPTIONS : Command = new Command("Default", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val SHOW_GAME_CANVAS : Command = new Command("Back to Game", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val CLOSE_AND_SHOW_GAME_CANVAS : Command = new Command("Back", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val QUIT_COMMAND : Command = new Command("Quit", StringUtil.getInstance().EMPTY_STRING, Command.STOP, 1)

    val RESTART_COMMAND : Command = new Command("Restart", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 0)

    val DISPLAY_SAVE_FORM : Command = new Command("Save To", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 3)

    val SAVE : Command = new Command("Save", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 3)

    val DISPLAY_LOAD_FORM : Command = new Command("Load", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 3)

    val LOAD_FILE : Command = new Command("Load File", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 3)

    val DELETE_FILE : Command = new Command("Delete File", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val EXIT_COMMAND : Command = new Command("Exit", StringUtil.getInstance().EMPTY_STRING, Command.EXIT, 2)

    val EXIT_WITHOUT_PROGRESS_COMMAND : Command = new Command("Exit Without Progress", StringUtil.getInstance().EMPTY_STRING, Command.EXIT, 2)

    val START_COMMAND : Command = new Command(CommonStrings.getInstance().START, StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val CONTINUE_COMMAND : Command = new Command("Continue", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val SELECT_COMMAND : Command = new Command("Select", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val FEATURE_UPDATE : Command = new Command("Feature Update", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val BUY_COMMAND : Command = new Command("BUY", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

}

object GameCommandsFactory {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : GameCommandsFactory = {
        if (GameCommandsFactory.instance eq NullUtil.getInstance().NULL_OBJECT) {
            GameCommandsFactory.instance = new GameCommandsFactory()
        }
        return GameCommandsFactory.instance.asInstanceOf[GameCommandsFactory]
    }

}


