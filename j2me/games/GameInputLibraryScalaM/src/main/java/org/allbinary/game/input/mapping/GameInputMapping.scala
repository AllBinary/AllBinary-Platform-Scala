/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.mapping

import _root_.org.allbinary.game.input.GameKey
import _root_.org.allbinary.logic.string.StringUtil

class GameInputMapping(param_name : String, param_gameKey : GameKey) {

    private var name : String = StringUtil.getInstance().EMPTY_STRING

    private var gameKey : GameKey = GameKey.NULL_GAME_KEY

    //Constructor
    {
        val name : String = param_name
        val gameKey : GameKey = param_gameKey
        this.setName(name)
        this.setGameKey(gameKey)
    }

    private def setGameKey(gameKey : GameKey) : Unit = {
        this.gameKey = gameKey
    }

    def getGameKey() : GameKey = {
        return this.gameKey
    }

    private def setName(name : String) : Unit = {
        this.name = name
    }

    def getName() : String = {
        return this.name
    }

}


