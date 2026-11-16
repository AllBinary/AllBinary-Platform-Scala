/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.displayable.command

import _root_.javax.microedition.lcdui.Command
import _root_.org.allbinary.logic.string.StringUtil

class MyCommandsFactory() {
    import _root_.org.allbinary.graphics.displayable.command.MyCommandsFactory.{*}

    val NO_COMMAND : Command = new Command(StringUtil.getInstance().EMPTY_STRING, StringUtil.getInstance().EMPTY_STRING, -1, -1)

    val GAUGE_CHANGE : Command = new Command("GAUGE_CHANGE", StringUtil.getInstance().EMPTY_STRING, Command.ITEM, 1)

    // general commands
    val SET_DISPLAYABLE : Command = new Command("Display", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 2)

    val PAUSE_COMMAND : Command = new Command("Pause", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 0)

    val RESUME_COMMAND : Command = new Command("Resume", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 0)

}

object MyCommandsFactory {
    private val instance : MyCommandsFactory = new MyCommandsFactory()

    def getInstance() : MyCommandsFactory = {
        return MyCommandsFactory.instance
    }

}


