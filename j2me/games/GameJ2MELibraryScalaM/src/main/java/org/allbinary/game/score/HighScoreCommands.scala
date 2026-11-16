/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.javax.microedition.lcdui.Command
import _root_.org.allbinary.logic.string.StringUtil

class HighScoreCommands {
    import _root_.org.allbinary.game.score.HighScoreCommands.{*}

    val DISPLAY : Command = new Command("Scores", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val PERSONAL : Command = new Command("Personal", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val WORLD : Command = new Command("World", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

}

object HighScoreCommands {
    private val instance : HighScoreCommands = new HighScoreCommands()

    /**      * @return the instance      */
    def getInstance() : HighScoreCommands = {
        return HighScoreCommands.instance
    }

}


