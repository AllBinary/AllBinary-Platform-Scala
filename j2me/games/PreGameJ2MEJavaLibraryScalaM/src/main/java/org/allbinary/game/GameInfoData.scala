/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game


class GameInfoData private() {
    import _root_.org.allbinary.game.GameInfoData.{*}

    val GAME_TYPE : String = "GAME_TYPE"

    val GAME_MODE : String = "GAME_MODE"

    val PLAYER_TYPE : String = "PLAYER_TYPE"

    val HIGHEST_LEVEL : String = "HIGHEST_LEVEL"

    val CURRENT_LEVEL : String = "CURRENT_LEVEL"

    val SOFTWARE_INFORMATION : String = "SOFTWARE_INFORMATION"

}

object GameInfoData {
    private val instance : GameInfoData = new GameInfoData()

    def getInstance() : GameInfoData = {
        return GameInfoData.instance
    }

}


