/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.javax.microedition.lcdui.Command

class HighScoreCommandsFactory private() extends HighScoreCommandsBaseFactory(Array[Command](HighScoreCommands.getInstance().PERSONAL, HighScoreCommands.getInstance().WORLD)) {
    import _root_.org.allbinary.game.score.HighScoreCommandsFactory.{*}

}

object HighScoreCommandsFactory {
    private val instance : HighScoreCommandsFactory = new HighScoreCommandsFactory()

    /**      * @return the instance      */
    def getInstance() : HighScoreCommandsFactory = {
        return HighScoreCommandsFactory.instance
    }

}


