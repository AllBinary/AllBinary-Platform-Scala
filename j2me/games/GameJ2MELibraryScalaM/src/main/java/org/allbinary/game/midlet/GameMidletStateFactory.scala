/* Generated Code Do Not Modify */
package org.allbinary.game.midlet

import _root_.org.allbinary.game.state.GameState
import _root_.org.allbinary.game.state.GameStateFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonLabels

class GameMidletStateFactory private() {
    import _root_.org.allbinary.game.midlet.GameMidletStateFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var currentGameState : GameState = GameStateFactory.getInstance().NO_GAME_STATE

    def getCurrentGameState() : GameState = {
        return this.currentGameState
    }

    def setCurrentGameState(currentGameState : GameState) : Unit = {
        this.logUtil.putF(new StringMaker().append(CommonLabels.getInstance().CURRENT).append(" GameState: ").append(StringUtil.getInstance().toString(currentGameState)).toString(), this, "setCurrentGameState")
        this.currentGameState = currentGameState
    }

}

object GameMidletStateFactory {
    private val INSTANCE : GameMidletStateFactory = new GameMidletStateFactory()

    def getInstance() : GameMidletStateFactory = {
        return GameMidletStateFactory.INSTANCE
    }

}


