/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game

import _root_.org.allbinary.game.state.GameState
import _root_.org.allbinary.game.state.GameStateFactory

class IntermissionFactory {
    import _root_.org.allbinary.game.IntermissionFactory.{*}

    val START_LEVEL_INTERMISSION_GAME_STATE : GameState = GameStateFactory.getInstance().createGameState("START_LEVEL_INTERMISSION_GAME_STATE")

    val WAIT_LEVEL_INTERMISSION_GAME_STATE : GameState = GameStateFactory.getInstance().createGameState("WAIT_LEVEL_INTERMISSION_GAME_STATE")

    val SHOW_RESULTS_LEVEL_INTERMISSION_GAME_STATE : GameState = GameStateFactory.getInstance().createGameState("SHOW_RESULTS_LEVEL_INTERMISSION_GAME_STATE")

    val SHOW_HIGH_SCORE_LEVEL_INTERMISSION_GAME_STATE : GameState = GameStateFactory.getInstance().createGameState("SHOW_HIGH_SCORE_LEVEL_INTERMISSION_GAME_STATE")

}

object IntermissionFactory {
    private val instance : IntermissionFactory = new IntermissionFactory()

    def getInstance() : IntermissionFactory = {
        return IntermissionFactory.instance
    }

}


