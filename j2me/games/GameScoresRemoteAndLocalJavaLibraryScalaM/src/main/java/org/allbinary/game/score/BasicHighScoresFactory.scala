/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.org.allbinary.thread.ARunnable
import _root_.org.allbinary.game.BasicHighScoresGameInfoFactory
import _root_.org.allbinary.game.GameInfo
import _root_.org.allbinary.game.GameType
import _root_.org.allbinary.game.GameTypeFactory
import _root_.org.allbinary.game.score.remote.RemoteHighScores
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.logic.system.SoftwareInformation
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.thread.SecondaryThreadPool

class BasicHighScoresFactory(param_abeClientInformation : AbeClientInformationInterface, param_softwareInformation : SoftwareInformation) extends HighScoresBase {
    import _root_.org.allbinary.game.score.BasicHighScoresFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var abeClientInformation : AbeClientInformationInterface = null

    private var softwareInformation : SoftwareInformation = null

    private val highScoresArray : Array[HighScores] = new Array[HighScores](2)

    private val TOP : String = "Top"

    private val SCORES : String = "Scores"

    private val PERSONAL_HIGH_SCORES : String = "Personal Top Scores"

    private val WORLD_TOP_SCORES : String = "World Top Scores"

    private val FETCH : String = "fetchHighScores"

    //Constructor
    {
        val abeClientInformation : AbeClientInformationInterface = param_abeClientInformation
        val softwareInformation : SoftwareInformation = param_softwareInformation
        this.abeClientInformation = abeClientInformation
        this.softwareInformation = softwareInformation
    }

    override def fetchHighScores(gameInfo : GameInfo, highScoresResultsListener : HighScoresResultsListener) : Unit = {
        this.logUtil.putF("Getting Remote/Local HighScores", this, this.FETCH)
        this.fetchHighScoresPreload(gameInfo, highScoresResultsListener, true)
    }

    override def fetchHighScoresPreload(gameInfo : GameInfo, highScoresResultsListener : HighScoresResultsListener, preload : Boolean) : Unit = {
        //System.gc();
        SecondaryThreadPool.getInstance().runTask(new ARunnable {
                override def run() : Unit = {
                    val logUtil : LogUtil = LogUtil.getInstance()
                    try {
                        logUtil.putF(BasicHighScoresFactory.this.commonStrings.START, this, FETCH)
                        highScoresArray(0) = RecordStoreHighScores.getInstance(abeClientInformation, gameInfo, TOP, PERSONAL_HIGH_SCORES, SCORES, new ScoreComparator(true))
                        val gameType : GameType = gameInfo.getGameType()
                        val gameTypeFactory : GameTypeFactory = GameTypeFactory.getInstance()
                        var gameInfo2 : GameInfo = gameInfo
                        if ((gameType eq gameTypeFactory.SINGLE_PLAYER) || (gameType eq gameTypeFactory.BOT)) {
                            gameInfo2 = BasicHighScoresGameInfoFactory.getInstance().SINGLE_PLAYER_SERVER
                        } else if (gameType eq gameTypeFactory.MULTI_PLAYER) {
                            gameInfo2 = BasicHighScoresGameInfoFactory.getInstance().MULTI_PLAYER_SERVER
                        }
                        highScoresArray(1) = RemoteHighScores.getInstancePreload(abeClientInformation, softwareInformation, gameInfo2, WORLD_TOP_SCORES, SCORES, BooleanFactory.getInstance().FALSE, preload)
                        logUtil.putF(BasicHighScoresFactory.this.commonStrings.END, this, FETCH)
                        LastFetchHighScoresFactory.getInstance().highScoresArray = highScoresArray
                        highScoresResultsListener.setHighScoresArray(highScoresArray)
                    } catch {
                        case e : Exception => {
                            logUtil.put(commonStrings.EXCEPTION, this, FETCH, e)
                        }
                    }
                }

            })
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


