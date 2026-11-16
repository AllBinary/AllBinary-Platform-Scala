/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.logic.system.security.licensing.LockedFeatureNotificationUtil
import _root_.org.allbinary.logic.system.security.licensing.LockedUtil
import _root_.org.allbinary.canvas.Processor
import _root_.org.allbinary.game.displayable.canvas.AllBinaryGameCanvas
import _root_.org.allbinary.game.displayable.canvas.PreGameSelectorPaintable
import _root_.org.allbinary.game.input.event.GameKeyEventHandler
import _root_.org.allbinary.game.input.event.GameKeyEventUtil
import _root_.org.allbinary.game.state.GameState
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.media.audio.SecondaryPlayerQueueFactory
import _root_.org.allbinary.media.audio.SelectSound
import _root_.org.allbinary.thread.ABRunnable
import _root_.org.allbinary.thread.ThreadObjectUtil
import _root_.org.allbinary.time.TimeDelayHelper

class PreGameSelectionGameInputProcessor(param_gameCanvas : AllBinaryGameCanvas, param_preGameSelectorPaintable : PreGameSelectorPaintable, param_nextGameState : GameState, param_lockedIndex : Int) extends Processor with GameInputProcessorInterface with PlayerGameInputCompositeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var gameCanvas : AllBinaryGameCanvas = null

    private var preGameSelectorPaintable : PreGameSelectorPaintable = null

    private val inputTimeHelper : TimeDelayHelper = new TimeDelayHelper(650)

    private var nextGameState : GameState = null

    private var playerGameInput : PlayerGameInput = null

    private var lockedIndex : Int = 0

    private val abRunnable : ABRunnable = new PreGameSelectionRunnable(this)

    //Constructor
    {
        val gameCanvas : AllBinaryGameCanvas = param_gameCanvas
        val preGameSelectorPaintable : PreGameSelectorPaintable = param_preGameSelectorPaintable
        val nextGameState : GameState = param_nextGameState
        val lockedIndex : Int = param_lockedIndex
        this.gameCanvas = gameCanvas
        this.preGameSelectorPaintable = preGameSelectorPaintable
        this.nextGameState = nextGameState
        this.playerGameInput = new GameInputProcessorComposite("Pre Game Selection", this)
        this.lockedIndex = lockedIndex
    }

    class PreGameSelectionRunnable(param_inputProcessor : PreGameSelectionGameInputProcessor) extends ABRunnable {

        private[PreGameSelectionRunnable] var inputProcessor : PreGameSelectionGameInputProcessor = null

        //Constructor
        {
            val inputProcessor : PreGameSelectionGameInputProcessor = param_inputProcessor
            this.inputProcessor = inputProcessor
        }

        override def run() : Unit = {
            try {
                this.setRunning(true)
                SecondaryPlayerQueueFactory.getInstance().add(SelectSound.getInstance())
                this.inputProcessor.gameCanvas.setGameState(this.inputProcessor.nextGameState)
                GameKeyEventHandler.getInstance().removeListener(this.inputProcessor.getPlayerGameInput())
                this.setRunning(false)
            } catch {
                case e : Exception => {
                    this.setRunning(false)
                    val logUtil : LogUtil = LogUtil.getInstance()
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
                }
            }
        }

    }

    override def process() : Unit = {
        this.getPlayerGameInput().update()
    }

    override def onInput(list : BasicArrayList) : Unit = {
        var size : Int = list.size()

        {
            var index : Int = 0
            scala.util.boundary { (break_N79639 : scala.util.boundary.Label[Unit]) ?=>
                while (index < size) {
                    var anyType : Object = list.get(index)
                    var key : Int = GameKeyEventUtil.getKey(anyType)
                    if ((((key == Canvas.LEFT) || (key == Canvas.RIGHT)) || (key == Canvas.UP)) || (key == Canvas.DOWN)) {
                        if (this.inputTimeHelper.isTimeTNT()) {
                            SecondaryPlayerQueueFactory.getInstance().add(SelectSound.getInstance())
                            this.getPreGameSelectorPaintable().getPreGameSelectionForm().processInputKey(key)
                            scala.util.boundary.break()(using break_N79639)
                        }
                    } else if (key == Canvas.KEY_NUM0) {
                        var selectedIndex : Int = this.preGameSelectorPaintable.getPreGameSelectionForm().getSelectedIndex()
                        if ((selectedIndex < this.lockedIndex) || !LockedUtil.getInstance().isLocked()) {
                            //PreLogUtil.put("selectedIndex: " + selectedIndex + " LockedUtil.getInstance().isLockedFeature(): " + LockedUtil.getInstance().isLockedFeature(), this, "onInput");
                            if (!abRunnable.isRunning()) {
                                abRunnable.setRunning(true)
                                //Better to mix this in with the UI thread that is already running.
                                ThreadObjectUtil.getInstance().processThread(abRunnable)
                            }
                            scala.util.boundary.break()(using break_N79639)
                        } else {
                            LockedFeatureNotificationUtil.getInstance().fire()
                        }
                    }
                    index += 1
                }
            }
        }
        list.clear()
    }

    /**      * @return the preGameSelectorPaintable      */
    def getPreGameSelectorPaintable() : PreGameSelectorPaintable = {
        return this.preGameSelectorPaintable
    }

    override def processInput(layerManager : AllBinaryLayerManager) : Unit = {
    }

    override def initInputProcessors() : Unit = {
    }

    override def getName() : String = {
        return this.toString()
    }

    override def getPlayerGameInput() : PlayerGameInput = {
        return this.playerGameInput
    }

}


