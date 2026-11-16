/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.org.allbinary.game.GameInfo
import _root_.org.allbinary.logic.communication.log.LogUtil

class NoHighScoresFactory private() extends HighScoresBase {
    import _root_.org.allbinary.game.score.NoHighScoresFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val NO_HIGH_SCORES : Array[HighScores] = new Array[HighScores](0)

    override def fetchHighScores(gameInfo : GameInfo, highScoresResultsListener : HighScoresResultsListener) : Unit = {
        this.logUtil.putF("Getting No HighScores", this, "fetchHighScores")
        highScoresResultsListener.setHighScoresArray(this.NO_HIGH_SCORES)
    }

    override def createHighScoresHelper() : HighScoresHelperBaseInterface = {
        return new HighScoresHelperBase()
    }

}

object NoHighScoresFactory {
    private val instance : NoHighScoresFactory = new NoHighScoresFactory()

    def getInstance() : NoHighScoresFactory = {
        return NoHighScoresFactory.instance
    }

}


