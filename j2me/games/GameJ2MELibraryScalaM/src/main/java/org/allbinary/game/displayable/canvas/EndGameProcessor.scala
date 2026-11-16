/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.org.allbinary.canvas.Processor
import _root_.org.allbinary.game.score.HighScores
import _root_.org.allbinary.game.score.HighScoresHelperBase
import _root_.org.allbinary.game.score.NullHighScoresSingletonFactory
import _root_.org.allbinary.game.state.GameStateFactory
import _root_.org.allbinary.graphics.paint.NullPaintable

class EndGameProcessor(param_gameCanvas : AllBinaryGameCanvas) extends Processor {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    val gameStateFactory : GameStateFactory = GameStateFactory.getInstance()

    private var gameCanvas : AllBinaryGameCanvas = null

    private val WAIT : Long = 5000

    //Constructor
    {
        val gameCanvas : AllBinaryGameCanvas = param_gameCanvas
        this.gameCanvas = gameCanvas
    }

    override def process() : Unit = {
        // Only Show End of game for people
        if (this.gameCanvas.isHighScoreSubmitted()) {
            // this.logUtil.putF("Score Submitted: Time In State: " + this.getGameStateTimeHelper().getElapsed(), this, "showEndOfGame");
            if (this.gameCanvas.getGameStateTimeHelper().isElapsedTNT(this.WAIT)) {
                if (this.gameCanvas.getGameState() eq this.gameStateFactory.SHOW_END_RESULT_GAME_STATE) {
                    val highScoresBase : HighScoresHelperBase = this.gameCanvas.highScoresHelper.asInstanceOf[HighScoresHelperBase]
                    val highScores : HighScores = highScoresBase.getSelectedHighScores()
                    if (highScores ne NullHighScoresSingletonFactory.getInstance()) {
                        highScoresBase.selectHighScores()
                        this.gameCanvas.getRealHighScoresPaintable().setHighScores(highScores)
                        this.gameCanvas.setGameState(this.gameStateFactory.SHOW_HIGH_SCORE_GAME_STATE)
                        this.gameCanvas.setHighScoresPaintable(this.gameCanvas.getRealHighScoresPaintable())
                    }
                } else if (this.gameCanvas.getGameState() eq this.gameStateFactory.SHOW_HIGH_SCORE_GAME_STATE) {
                    this.gameCanvas.setGameState(this.gameStateFactory.SHOW_END_RESULT_GAME_STATE)
                    this.gameCanvas.setHighScoresPaintable(NullPaintable.getInstance())
                }
            }
        }
    }

}


