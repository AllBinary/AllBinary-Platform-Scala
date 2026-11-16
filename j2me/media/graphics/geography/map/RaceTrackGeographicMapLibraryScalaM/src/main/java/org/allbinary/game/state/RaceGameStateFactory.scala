/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.state

import _root_.org.allbinary.logic.NullUtil

/**  *  * @author User  */
class RaceGameStateFactory {
    import _root_.org.allbinary.game.state.RaceGameStateFactory.{*}

    val START_GAME_STATE : GameState = GameStateFactory.getInstance().createGameState("START_GAME_STATE")

    val YELLOW_LIGHT_GAME_STATE : GameState = GameStateFactory.getInstance().createGameState("YELLOW_LIGHT_GAME_STATE")

    val RED_LIGHT_GAME_STATE : GameState = GameStateFactory.getInstance().createGameState("RED_LIGHT_GAME_STATE")

}

object RaceGameStateFactory {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : RaceGameStateFactory = {
        if (RaceGameStateFactory.instance eq NullUtil.getInstance().NULL_OBJECT) {
            RaceGameStateFactory.instance = new RaceGameStateFactory()
        }
        return RaceGameStateFactory.instance.asInstanceOf[RaceGameStateFactory]
    }

}


