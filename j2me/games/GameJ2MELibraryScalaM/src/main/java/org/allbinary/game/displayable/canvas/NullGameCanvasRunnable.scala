/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Item
import _root_.org.allbinary.game.state.GameState
import _root_.org.allbinary.game.state.GameStateFactory
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.util.ABHashtable

/**  *  * @author User  */
class NullGameCanvasRunnable extends GameCanvasRunnableInterface {
    import _root_.org.allbinary.game.displayable.canvas.NullGameCanvasRunnable.{NULL_GAME_CANVAS_RUNNABLE as _, *}
    def NULL_GAME_CANVAS_RUNNABLE : NullGameCanvasRunnable = _root_.org.allbinary.game.displayable.canvas.NullGameCanvasRunnable.NULL_GAME_CANVAS_RUNNABLE

    val gameStateFactory : GameStateFactory = GameStateFactory.getInstance()

    override def getTitle() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    override def isInitialized() : Boolean = {
        return false
    }

    override def isPaused() : Boolean = {
        return false
    }

    override def unPause() : Unit = {
    }

    override def pause() : Unit = {
    }

    override def isHighScoreSubmitted() : Boolean = {
        return false
    }

    override def setHighScoreSubmitted(highScoreSubmitted : Boolean) : Unit = {
    }

    override def processGameOver() : Unit = {
    }

    override def isGameOver() : Boolean = {
        return false
    }

    override def initCommands(cmdListener : CommandListener) : Unit = {
    }

    override def getCurrentStateHashtable() : ABHashtable[Object, Object] = {
        return StdUtil.getInstance().NULL_TABLE
    }

    override def getLoadStateHashtable() : ABHashtable[Object, Object] = {
        return StdUtil.getInstance().NULL_TABLE
    }

    override def setLoadStateHashtable(hashtable : ABHashtable[Object, Object]) : Unit = {
    }

    override def getType() : Int = {
        return -1
    }

    override def setGameState(gameState : GameState) : Unit = {
    }

    override def getGameState() : GameState = {
        return this.gameStateFactory.NO_GAME_STATE
    }

    override def itemStateChanged(item : Item) : Unit = {
    }

    override def paint(graphics : Graphics) : Unit = {
    }

    override def paintThreed(graphics : Graphics) : Unit = {
    }

    override def isRunning() : Boolean = {
        return false
    }

    override def setRunning(isRunning : Boolean) : Unit = {
    }

    override def setThread(thread : Thread) : Unit = {
    }

    override def run() : Unit = {
    }

}

object NullGameCanvasRunnable {
    val NULL_GAME_CANVAS_RUNNABLE : NullGameCanvasRunnable = new NullGameCanvasRunnable()

}


