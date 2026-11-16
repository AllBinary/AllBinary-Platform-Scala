/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score.displayable

import _root_.javax.microedition.lcdui.Command
import _root_.javax.microedition.lcdui.CommandListener
import _root_.org.allbinary.game.GameInfo
import _root_.org.allbinary.game.score.HighScore
import _root_.org.allbinary.game.score.HighScoreNamePersistanceSingleton
import _root_.org.allbinary.game.score.HighScores
import _root_.org.allbinary.game.score.HighScoresFactoryInterface
import _root_.org.allbinary.game.score.HighScoresHelperBaseInterface
import _root_.org.allbinary.game.score.HighScoresResultsListener
import _root_.org.allbinary.graphics.displayable.MyCanvas
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.string.CommonStrings

class HighScoreUtil(param_highScoresFactoryInterface : HighScoresFactoryInterface, param_highScoresHelper : HighScoresHelperBaseInterface, param_abeClientInformation : AbeClientInformationInterface, param_gameInfo : GameInfo, param_cmdListener : CommandListener, param_name : String, param_highScore : HighScore) extends HighScoresResultsListener {
    import _root_.org.allbinary.game.score.displayable.HighScoreUtil.{SUBMIT_TEXTBOX_COMMAND as _, *}
    def SUBMIT_TEXTBOX_COMMAND : Command = _root_.org.allbinary.game.score.displayable.HighScoreUtil.SUBMIT_TEXTBOX_COMMAND

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var highScoresFactoryInterface : HighScoresFactoryInterface = null

    private var highScoresArray : Array[HighScores] = null

    private var highScore : HighScore = null

    private var abeClientInformation : AbeClientInformationInterface = null

    private var gameInfo : GameInfo = null

    private var highScoresHelper : HighScoresHelperBaseInterface = null

    private var firstTime : Boolean = true

    //Constructor
    {
        val highScoresFactoryInterface : HighScoresFactoryInterface = param_highScoresFactoryInterface
        val highScoresHelper : HighScoresHelperBaseInterface = param_highScoresHelper
        val abeClientInformation : AbeClientInformationInterface = param_abeClientInformation
        val gameInfo : GameInfo = param_gameInfo
        val cmdListener : CommandListener = param_cmdListener
        val name : String = param_name
        val highScore : HighScore = param_highScore
        this.highScoresFactoryInterface = highScoresFactoryInterface
        this.highScoresHelper = highScoresHelper
        this.highScoresArray = this.highScoresHelper.getHighScoresArray()
        this.highScore = highScore
        this.abeClientInformation = abeClientInformation
        this.gameInfo = gameInfo
    }

    override def setHighScoresArray(highScoresArray : Array[HighScores]) : Unit = {
        this.highScoresArray = highScoresArray
        this.firstTime = false
        this.saveHighScore()
    }

    def update(name : String) : Unit = {
        HighScoreNamePersistanceSingleton.getInstance().save(this.abeClientInformation, this.gameInfo, name)
        this.highScore.setName(name)
    }

    def saveHighScore() : Unit = {
        this.logUtil.putF(new StringMaker().append(this.commonStrings.START).append(StringUtil.getInstance().toString(this.highScore)).toString(), this, "saveHighScore")
        val size : Int = this.highScoresArray.length
        if (this.firstTime && (size == 0)) {
            this.logUtil.putF("Games canvas did not give us any HighScores", this, "saveHighScore")
            this.highScoresFactoryInterface.fetchHighScores(this.gameInfo, this)
            return
        }
        var highScores : HighScores = null
        var highScoresAsString : String = null

        {
            var index : Int = 0
            while (index < size) {
                highScores = this.highScoresArray(index)
                highScores.addHighScore(this.highScore)
                highScoresAsString = highScores.toString()
                this.logUtil.putF(new StringMaker().append("Added/Adding Score: ").append(highScoresAsString).toString(), this, "saveHighScore")
                index += 1
            }
        }
        this.highScoresHelper.setHighScoresArray(this.highScoresArray)
    }

    def submit(myCanvas : MyCanvas) : Unit = {
        val commandListener : CommandListener = myCanvas.getCustomCommandListener()
        commandListener.commandAction(HighScoreUtil.SUBMIT_TEXTBOX_COMMAND, myCanvas)
    }

}

object HighScoreUtil {
    val SUBMIT_TEXTBOX_COMMAND : Command = new Command("Submit", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

}


