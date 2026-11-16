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
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.media.audio.SecondaryPlayerQueueFactory
import _root_.org.allbinary.media.audio.SelectSound
import _root_.org.allbinary.media.graphics.geography.map.racetrack.MultiLevelRaceTrackGeographicMapInterfaceFactoryInterface
import _root_.org.allbinary.thread.ABRunnable
import _root_.org.allbinary.thread.ThreadObjectUtil
import _root_.org.allbinary.time.TimeDelayHelper

class MapSelectionGameInputProcessor(param_gameCanvas : AllBinaryGameCanvas, param_raceTrackGeographicMapInterfaceFactoryInterface : MultiLevelRaceTrackGeographicMapInterfaceFactoryInterface, param_mapSelectorPaintable : PreGameSelectorPaintable, param_lockedIndex : Int) extends Processor with GameInputProcessorInterface with PlayerGameInputCompositeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var gameCanvas : AllBinaryGameCanvas = null

    private var raceTrackGeographicMapInterfaceFactoryInterface : MultiLevelRaceTrackGeographicMapInterfaceFactoryInterface = null

    private var preGameSelectorPaintable : PreGameSelectorPaintable = null

    private val inputTimeHelper : TimeDelayHelper = new TimeDelayHelper(650)

    private var playerGameInput : PlayerGameInput = null

    private var lockedIndex : Int = 0

    private val abRunnable : ABRunnable = new MapSelectionRunnable(this)

    //Constructor
    {
        val gameCanvas : AllBinaryGameCanvas = param_gameCanvas
        val raceTrackGeographicMapInterfaceFactoryInterface : MultiLevelRaceTrackGeographicMapInterfaceFactoryInterface = param_raceTrackGeographicMapInterfaceFactoryInterface
        val mapSelectorPaintable : PreGameSelectorPaintable = param_mapSelectorPaintable
        val lockedIndex : Int = param_lockedIndex
        this.gameCanvas = gameCanvas
        this.raceTrackGeographicMapInterfaceFactoryInterface = raceTrackGeographicMapInterfaceFactoryInterface
        this.preGameSelectorPaintable = mapSelectorPaintable
        this.playerGameInput = new GameInputProcessorComposite("Map Selection", this)
        this.lockedIndex = lockedIndex
    }

    class MapSelectionRunnable(param_inputProcessor : MapSelectionGameInputProcessor) extends ABRunnable {

        private[MapSelectionRunnable] var inputProcessor : MapSelectionGameInputProcessor = null

        //Constructor
        {
            val inputProcessor : MapSelectionGameInputProcessor = param_inputProcessor
            this.inputProcessor = inputProcessor
        }

        override def run() : Unit = {
            try {
                this.setRunning(true)
                SecondaryPlayerQueueFactory.getInstance().add(SelectSound.getInstance())
                // this.gameCanvas.setGameState(Intermission.WAIT_LEVEL_INTERMISSION_GAME_STATE);
                val track : Int = this.inputProcessor.preGameSelectorPaintable.getPreGameSelectionForm().getSelectedIndex() + 1
                val wave : Int = this.inputProcessor.raceTrackGeographicMapInterfaceFactoryInterface.getFirstWaveWithTrack(track)
                this.inputProcessor.gameCanvas.getLayerManager().getGameInfo().setCurrentLevel(wave)
                this.inputProcessor.gameCanvas.buildGameInit(false)
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
        // this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.PROCESS);
        this.getPlayerGameInput().update()
    }

    override def onInput(list : BasicArrayList) : Unit = {
        var size : Int = list.size()

        {
            var index : Int = 0
            scala.util.boundary { (break_N80413 : scala.util.boundary.Label[Unit]) ?=>
                while (index < size) {
                    var anyType : Object = list.get(index)
                    var key : Int = GameKeyEventUtil.getKey(anyType)
                    if ((((key == Canvas.LEFT) || (key == Canvas.RIGHT)) || (key == Canvas.UP)) || (key == Canvas.DOWN)) {
                        if (this.inputTimeHelper.isTimeTNT()) {
                            SecondaryPlayerQueueFactory.getInstance().add(SelectSound.getInstance())
                            this.preGameSelectorPaintable.getPreGameSelectionForm().processInputKey(key)
                            scala.util.boundary.break()(using break_N80413)
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
                            scala.util.boundary.break()(using break_N80413)
                        } else {
                            LockedFeatureNotificationUtil.getInstance().fire()
                        }
                    }
                    list.clear()
                    index += 1
                }
            }
        }
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


