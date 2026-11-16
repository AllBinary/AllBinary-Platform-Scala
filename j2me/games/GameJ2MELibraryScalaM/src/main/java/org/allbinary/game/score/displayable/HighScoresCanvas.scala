/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score.displayable

import _root_.javax.microedition.lcdui.Command
import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.GameInfo
import _root_.org.allbinary.game.commands.GameCommandsFactory
import _root_.org.allbinary.game.displayable.canvas.GameCommandCanvas
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.paint.ColorFillBasePaintable
import _root_.org.allbinary.game.paint.ColorFillPaintableFactory
import _root_.org.allbinary.game.score.HighScoreCommandsFactory
import _root_.org.allbinary.game.score.HighScores
import _root_.org.allbinary.game.score.HighScoresCanvasInputProcessor
import _root_.org.allbinary.game.score.HighScoresCanvasInputProcessorFactoryInterface
import _root_.org.allbinary.game.score.HighScoresFactoryInterface
import _root_.org.allbinary.game.score.HighScoresHelperBase
import _root_.org.allbinary.game.score.HighScoresPaintable
import _root_.org.allbinary.game.score.HighScoresResultsListener
import _root_.org.allbinary.game.score.NoHighScoresFactory
import _root_.org.allbinary.game.score.NullHighScoresSingletonFactory
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.paint.NullPaintable
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.graphics.paint.SimpleTextPaintable
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.thread.SecondaryThreadPool

class HighScoresCanvas(param_commandListener : CommandListener, param_allBinaryGameLayerManager : AllBinaryGameLayerManager, param_gameInfo : GameInfo, param_paintable : HighScoresPaintable, param_highScoresFactoryInterface : HighScoresFactoryInterface, param_highScoresCanvasInputProcessorFactoryInterface : HighScoresCanvasInputProcessorFactoryInterface) extends GameCommandCanvas(param_commandListener, HighScoresCanvas.NAME, param_allBinaryGameLayerManager.getBackgroundBasicColor(), param_allBinaryGameLayerManager.getForegroundBasicColor()) with HighScoresResultsListener {
    import _root_.org.allbinary.game.score.displayable.HighScoresCanvas.{NAME as _, *}
    def NAME : String = _root_.org.allbinary.game.score.displayable.HighScoresCanvas.NAME

    private var paintable : Paintable = NullPaintable.getInstance()

    private val highScoreCommandsFactory : HighScoreCommandsFactory = HighScoreCommandsFactory.getInstance()

    private val waitPaintable : SimpleTextPaintable = new SimpleTextPaintable(this.commonStrings.PLEASE_WAIT_FOR_SERVER, BasicColorFactory.getInstance().WHITE)

    private var highScoresPaintable : HighScoresPaintable = null

    private var highScoresFactoryInterface : HighScoresFactoryInterface = null

    var colorFillPaintable : ColorFillBasePaintable = null

    private val highScoresHelper : HighScoresHelperBase = new HighScoresHelperBase()

    private var gameInfo : GameInfo = null

    private var highScoresCanvasInputProcessor : HighScoresCanvasInputProcessor = null

    private var currentCommand : Command = this.highScoreCommandsFactory.HIGH_SCORE_COMMANDS(0)

    var hasPainted : Boolean = false

    //Constructor
    {
        val commandListener : CommandListener = param_commandListener
        val allBinaryGameLayerManager : AllBinaryGameLayerManager = param_allBinaryGameLayerManager
        val gameInfo : GameInfo = param_gameInfo
        val paintable : HighScoresPaintable = param_paintable
        val highScoresFactoryInterface : HighScoresFactoryInterface = param_highScoresFactoryInterface
        val highScoresCanvasInputProcessorFactoryInterface : HighScoresCanvasInputProcessorFactoryInterface = param_highScoresCanvasInputProcessorFactoryInterface
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        this.highScoresPaintable = paintable
        this.highScoresFactoryInterface = highScoresFactoryInterface
        this.highScoresCanvasInputProcessor = highScoresCanvasInputProcessorFactoryInterface.getInstance(this)
        this.gameInfo = gameInfo
        // .getInstance().START_INPUT_MAPPING));
        this.waitPaintable.setBasicColorP(allBinaryGameLayerManager.getForegroundBasicColor())
        this.getHighScoresPaintable().setBasicColorP(allBinaryGameLayerManager.getForegroundBasicColor())
        this.colorFillPaintable = ColorFillPaintableFactory.getInstance().getInstance(allBinaryGameLayerManager.getBackgroundBasicColor(), false)
        //NO_HIGH_SCORES is empty. Generated languages such as Go can not tell empty arrays apart by reference.
        if (this.highScoresHelper.getHighScoresArray().length == NoHighScoresFactory.getInstance().NO_HIGH_SCORES.length) {
            this.setPaintable(this.waitPaintable)
        } else {
            this.logUtil.putF("Show HighScores that are already loaded", this, this.commonStrings.CONSTRUCTOR)
            this.updateCommand(this.currentCommand)
            this.setPaintable(this.getHighScoresPaintable())
        }
        SecondaryThreadPool.getInstance().runTask(new HighScoreRunnable(this))
    }

    override def initCommands(cmdListener : CommandListener) : Unit = {
        this.removeAllCommands()
        this.addCommand(GameCommandsFactory.getInstance().CLOSE_AND_SHOW_GAME_CANVAS)
        // this.addCommand(HighScoresCanvas.WORLD);
        this.setCommandListener(cmdListener)
    }

    override def open() : Unit = {
        super.open()
        this.highScoresCanvasInputProcessor.open()
    }

    override def close() : Unit = {
        super.close()
        this.highScoresCanvasInputProcessor.close()
    }

    override def paint(graphics : Graphics) : Unit = {
        this.colorFillPaintable.paint(graphics)
        this.paintable.paint(graphics)
        if (this.waitPaintable ne this.paintable) {
            this.highScoresCanvasInputProcessor.paint(graphics)
        }
        super.paint(graphics)
        this.hasPainted = true
    }

    def executeUpdate() : Unit = {
        try {
            this.highScoresFactoryInterface.fetchHighScores(this.getGameInfo(), this)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.UPDATE, e)
            }
        }
    }

    private def getHighScoresPaintable() : HighScoresPaintable = {
        return this.highScoresPaintable
    }

    override def setHighScoresArray(highScoresArray : Array[HighScores]) : Unit = {
        try {
            if (highScoresArray != null) {
                this.logUtil.putF(new StringMaker().append(this.commonStrings.START).appendint(highScoresArray.length).toString(), this, "setHighScoresArray")
            } else {
                this.logUtil.putF(this.commonStrings.START, this, "setHighScoresArray")
            }
            this.highScoresHelper.setHighScoresArray(highScoresArray)
            this.updateCommand(this.currentCommand)
            this.setPaintable(this.getHighScoresPaintable())
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.UPDATE, e)
            }
        }
    }

    def updateCommand(command : Command) : Unit = {
        this.logUtil.putF(new StringMaker().append(this.commonStrings.START).append(this.stringUtil.toString(command)).toString(), this, this.commonStrings.UPDATE)
        val gameCommandsFactory : GameCommandsFactory = GameCommandsFactory.getInstance()
        if (this.highScoreCommandsFactory.isHighScoreCommand(command)) {
            val index : Int = this.highScoreCommandsFactory.getIndex(command)
            //this.logUtil.putF(this.commonStrings.START).append(index, this, this.commonStrings.UPDATE);
            var nextIndex : Int = index + 1
            val highScoresArray : Array[HighScores] = this.highScoresHelper.getHighScoresArray()
            if (nextIndex >= highScoresArray.length) {
                nextIndex = 0
            }
            if (highScoresArray.length > 0) {
                this.getHighScoresPaintable().setHighScores(highScoresArray(index))
            } else {
                this.getHighScoresPaintable().setHighScores(NullHighScoresSingletonFactory.getInstance())
            }
            if (index != nextIndex) {
                this.removeAllCommands()
                this.addCommand(gameCommandsFactory.CLOSE_AND_SHOW_GAME_CANVAS)
                this.addCommand(this.highScoreCommandsFactory.HIGH_SCORE_COMMANDS(nextIndex))
            }
        }
        this.currentCommand = command
        this.close()
        super.initMenu()
        this.open()
        this.repaintBehavior.onChangeRepaint(this)
    }

    def getGameInfo() : GameInfo = {
        return this.gameInfo
    }

    private def setPaintable(paintable : Paintable) : Unit = {
        this.paintable = paintable
        this.repaintBehavior.onChangeRepaint(this)
    }

}

object HighScoresCanvas {
    val NAME : String = "HighScoresCanvas"

}


