/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.org.allbinary.game.GameInfo
import _root_.org.allbinary.graphics.displayable.MyCanvas
import _root_.org.allbinary.logic.string.StringUtil

class EndGameInfo {

    //private final String NORMAL_GAME_OVER = "Game Over";
    val NORMAL_GAME_OVER_WIN : String = "You Won"

    private val TEASER_DEMO_GAME_END_LAST_LEVEL : String = "End of Demo."

    private val TEASER_DEMO_GAME_END : String = "Demo Game Over."

    //game then it has not obtained info from the server yet.
    private var gameOverStr : String = StringUtil.getInstance().EMPTY_STRING

    private var winStr : String = this.gameOverStr

    final def update(gameInfo : GameInfo, myCanvas : MyCanvas) : Unit = {
        if (gameInfo.isLastLevel()) {
            this.setWinStr(this.TEASER_DEMO_GAME_END_LAST_LEVEL)
            this.setGameOverStr(this.TEASER_DEMO_GAME_END_LAST_LEVEL)
        } else {
            this.setWinStr(this.NORMAL_GAME_OVER_WIN)
            this.setGameOverStr(this.TEASER_DEMO_GAME_END)
        }
    }

    /**      * @return the gameOverStr      */
    def getGameOverStr() : String = {
        return this.gameOverStr
    }

    /**      * @param gameOverStr the gameOverStr to set      */
    def setGameOverStr(gameOverStr : String) : Unit = {
        this.gameOverStr = gameOverStr
    }

    /**      * @return the winStr      */
    def getWinStr() : String = {
        return this.winStr
    }

    /**      * @param winStr the winStr to set      */
    def setWinStr(winStr : String) : Unit = {
        this.winStr = winStr
    }

}


