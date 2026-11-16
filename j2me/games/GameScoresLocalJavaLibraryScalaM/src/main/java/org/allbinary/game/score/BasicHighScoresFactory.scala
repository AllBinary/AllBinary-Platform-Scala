/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.org.allbinary.game.GameInfo
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.SoftwareInformation
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface

class BasicHighScoresFactory(param_abeClientInformation : AbeClientInformationInterface, param_softwareInformation : SoftwareInformation) extends HighScoresBase {
    import _root_.org.allbinary.game.score.BasicHighScoresFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var abeClientInformation : AbeClientInformationInterface = null

    private val highScoresArray : Array[HighScores] = new Array[HighScores](1)

    private val TOP : String = "Top"

    private val SCORES : String = "Scores"

    private val PERSONAL_HIGH_SCORES : String = "Personal Top Scores"

    private val FETCH : String = "fetchHighScores"

    //Constructor
    {
        val abeClientInformation : AbeClientInformationInterface = param_abeClientInformation
        val softwareInformation : SoftwareInformation = param_softwareInformation
        this.abeClientInformation = abeClientInformation
    }

    override def fetchHighScores(gameInfo : GameInfo, highScoresResultsListener : HighScoresResultsListener) : Unit = {
        this.logUtil.putF("Getting Local HighScores", this, this.FETCH)
        this.fetchHighScoresPreload(gameInfo, highScoresResultsListener, true)
    }

    override def fetchHighScoresPreload(gameInfo : GameInfo, highScoresResultsListener : HighScoresResultsListener, preload : Boolean) : Unit = {
        //System.gc();
        try {
            this.highScoresArray(0) = RecordStoreHighScores.getInstance(this.abeClientInformation, gameInfo, this.TOP, this.PERSONAL_HIGH_SCORES, this.SCORES, new ScoreComparator(true))
            highScoresResultsListener.setHighScoresArray(this.highScoresArray)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.FETCH, e)
            }
        }
    }

    override def createHighScoresHelper() : HighScoresHelperBaseInterface = {
        return new HighScoresHelper2()
    }

}

object BasicHighScoresFactory {
    def loaded(index2 : Int) : Boolean = {
        if (index2 >= 0) {
            return true
        }
        return false
    }

}


