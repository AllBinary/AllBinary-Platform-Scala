/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author User  */
class HighScoresHelperBase extends HighScoresHelperBaseInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    var highScoresArrayP : Array[HighScores] = LastFetchHighScoresFactory.getInstance().highScoresArray

    override def setHighScoresArray(highScoresArrayP : Array[HighScores]) : Unit = {
        if (highScoresArrayP != null) {
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            this.logUtil.putF(new StringMaker().append(commonStrings.START).appendint(highScoresArrayP.length).toString(), this, "setHighScoresArray")
        } else {
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            this.logUtil.putF(commonStrings.START, this, "setHighScoresArray")
        }
        this.highScoresArrayP = highScoresArrayP
    }

    def getNextHighScores() : HighScores = {
        return NullHighScoresSingletonFactory.getInstance()
    }

    def isAnyHighScores() : Boolean = {
        throw new RuntimeException()
    }

    override def setSelectedHighScores(selectedHighScores : HighScores) : Unit = {
    }

    override def getSelectedHighScores() : HighScores = {
        return NullHighScoresSingletonFactory.getInstance()
    }

    override def getHighScoresArray() : Array[HighScores] = {
        return this.highScoresArrayP
    }

    def selectHighScores() : Unit = {
    }

}


