/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.util.ABHashtable

class GameInfo(param_gameType : GameType, param_gameMode : GameMode, param_playerType : PlayerType, param_highestLevel : Int, param_currentLevel : Int) {
    import _root_.org.allbinary.game.GameInfo.{NONE as _, LEVEL_NAME as _, *}
    def NONE : GameInfo = _root_.org.allbinary.game.GameInfo.NONE
    def LEVEL_NAME : String = _root_.org.allbinary.game.GameInfo.LEVEL_NAME

    val logUtil : LogUtil = LogUtil.getInstance()

    private val gameInfoData : GameInfoData = GameInfoData.getInstance()

    private var gameType : GameType = null

    private var gameMode : GameMode = null

    private var playerType : PlayerType = null

    private var highestLevel : Int = 0

    private var currentLevel : Int = 0

    private val NEW_LEVEL : String = "New Level: "

    private val SET_CURRENT_LEVEL : String = "setCurrentLevel"

    private val NEXT_GAME_LEVEL : String = "nextGameLevel"

    //Constructor
    {
        val gameType : GameType = param_gameType
        val gameMode : GameMode = param_gameMode
        val playerType : PlayerType = param_playerType
        val highestLevel : Int = param_highestLevel
        val currentLevel : Int = param_currentLevel
        this.gameType = gameType
        this.gameMode = gameMode
        this.setHighestLevel(highestLevel)
        this.currentLevel = currentLevel
        this.playerType = playerType
    }

    def getGameType() : GameType = {
        return this.gameType
    }

    def getGameMode() : GameMode = {
        return this.gameMode
    }

    def getPlayerType() : PlayerType = {
        return this.playerType
    }

    def getHighestLevel() : Int = {
        return this.highestLevel
    }

    def setHighestLevel(highestLevel : Int) : Unit = {
        this.highestLevel = highestLevel
    }

    def getCurrentLevel() : Int = {
        return this.currentLevel
    }

    def setCurrentLevel(currentLevel : Int) : Unit = {
        this.currentLevel = currentLevel
        this.logUtil.putF(new StringMaker().append(this.NEW_LEVEL).appendint(this.getCurrentLevel()).toString(), this, this.SET_CURRENT_LEVEL)
    }

    def nextGameLevel() : Unit = {
        if (this.getCurrentLevel() < this.getHighestLevel()) {
            this.currentLevel += 1
        }
        this.logUtil.putF(new StringMaker().append(CommonLabels.getInstance().NEXT).append(CommonSeps.getInstance().SPACE).append(this.NEW_LEVEL).appendint(this.getCurrentLevel()).toString(), this, this.NEXT_GAME_LEVEL)
    }

    def previousGameLevel() : Unit = {
        if (this.getCurrentLevel() > 1) {
            this.currentLevel -= 1
        }
    }

    def isLastLevel() : Boolean = {
        if (this.getCurrentLevel() >= this.getHighestLevel()) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def toHashtable() : ABHashtable[Object, Object] = {
        val hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()
        hashtable.put(this.gameInfoData.GAME_TYPE, this.getGameType().toString())
        hashtable.put(this.gameInfoData.GAME_MODE, this.gameMode.toString())
        hashtable.put(this.gameInfoData.PLAYER_TYPE, this.playerType.toString())
        hashtable.put(this.gameInfoData.HIGHEST_LEVEL, Integer.toString(this.getHighestLevel()))
        hashtable.put(this.gameInfoData.CURRENT_LEVEL, Integer.toString(this.currentLevel))
        return hashtable
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        stringBuffer.append(this.gameInfoData.GAME_TYPE)
        stringBuffer.append(commonSeps.EQUALS)
        stringBuffer.append(this.getGameType().toString())
        stringBuffer.append(commonSeps.COMMA_SEP)
        stringBuffer.append(this.gameInfoData.GAME_MODE)
        stringBuffer.append(commonSeps.EQUALS)
        stringBuffer.append(this.gameMode.toString())
        stringBuffer.append(commonSeps.COMMA_SEP)
        stringBuffer.append(this.gameInfoData.PLAYER_TYPE)
        stringBuffer.append(commonSeps.EQUALS)
        stringBuffer.append(StringUtil.getInstance().toString(this.playerType))
        stringBuffer.append(commonSeps.COMMA_SEP)
        stringBuffer.append(this.gameInfoData.HIGHEST_LEVEL)
        stringBuffer.append(commonSeps.EQUALS)
        stringBuffer.appendint(this.getHighestLevel())
        stringBuffer.append(commonSeps.COMMA_SEP)
        stringBuffer.append(this.gameInfoData.CURRENT_LEVEL)
        stringBuffer.append(commonSeps.EQUALS)
        stringBuffer.appendint(this.currentLevel)
        return stringBuffer.toString()
    }

}

object GameInfo {
    val NONE : GameInfo = new GameInfo(GameTypeFactory.getInstance().NONE, GameMode.NONE, PlayerTypesFactory.getInstance().PLAYER_TYPE_ONE, -1, -1)

    val LEVEL_NAME : String = "LEVEL"

}


