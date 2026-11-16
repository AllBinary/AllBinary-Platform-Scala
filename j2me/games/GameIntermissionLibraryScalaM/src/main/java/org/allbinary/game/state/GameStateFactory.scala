/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.state

import _root_.org.allbinary.logic.NullUtil

class GameStateFactory private() {
    import _root_.org.allbinary.game.state.GameStateFactory.{*}

    private var index : Int = 0

    val NO_GAME_STATE : GameState = this.createGameState("NO_GAME_STATE")

    val PLAYING_GAME_STATE : GameState = this.createGameState("PLAYING_GAME_STATE")

    val SHOW_END_RESULT_GAME_STATE : GameState = this.createGameState("SHOW_END_RESULT_GAME_STATE")

    val SHOW_HIGH_SCORE_GAME_STATE : GameState = this.createGameState("SHOW_HIGH_SCORE_GAME_STATE")

    def createGameState(name : String) : GameState = {
        return new GameState(name, { val value_N67006 = this.index; this.index += 1; value_N67006 })
    }

}

object GameStateFactory {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : GameStateFactory = {
        if (GameStateFactory.instance eq NullUtil.getInstance().NULL_OBJECT) {
            GameStateFactory.instance = new GameStateFactory()
        }
        return GameStateFactory.instance.asInstanceOf[GameStateFactory]
    }

}


