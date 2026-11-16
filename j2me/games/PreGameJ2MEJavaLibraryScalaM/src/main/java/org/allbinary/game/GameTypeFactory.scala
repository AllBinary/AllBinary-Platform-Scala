/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game

import _root_.org.allbinary.logic.string.StringUtil

class GameTypeFactory {
    import _root_.org.allbinary.game.GameTypeFactory.{*}

    var NULL_GAME_TYPE_ARRAY : Array[GameType] = new Array[GameType](0)

    var NONE : GameType = new GameType(StringUtil.getInstance().NULL_STRING)

    var SINGLE_PLAYER : GameType = new GameType("Single Player")

    var MULTI_PLAYER : GameType = new GameType("Multi Player")

    var BOT : GameType = new GameType("Artificial Player")

}

object GameTypeFactory {
    private val instance : GameTypeFactory = new GameTypeFactory()

    def getInstance() : GameTypeFactory = {
        return GameTypeFactory.instance
    }

}


