/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.javax.microedition.lcdui.Canvas
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.input.form.RTSFormInput
import _root_.org.allbinary.game.layer.RTSLayer
import _root_.org.allbinary.game.layer.RTSLayerInfoPaintable
import _root_.org.allbinary.game.layer.RTSPlayerLayerInterface
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.InputFeatureFactory
import _root_.org.allbinary.game.displayable.canvas.AllBinaryGameCanvas
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.game.input.form.NullRTSFormInputFactory
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.game.layer.NullRTSLayer
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEvent
import _root_.org.allbinary.input.motion.gesture.observer.MotionGestureEvent
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.media.audio.SecondaryPlayerQueueFactory
import _root_.org.allbinary.media.audio.SelectSound
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCompositeInterface
import _root_.org.allbinary.media.graphics.geography.map.SimpleGeographicMapCellPositionFactory
import _root_.org.allbinary.string.CommonLabels

/**  *   * @author user  */
class RTSPlayerGameInput(param_gameCanvas : AllBinaryGameCanvas, param_inputList : BasicArrayList, param_playerInputId : Int, param_towerInfoPaintable : RTSLayerInfoPaintable, param_rtsPlayerLayerInterface : RTSPlayerLayerInterface, param_layerPositionFinderInterface : LayerPositionFinderInterface, param_selectRTSLayerVisitorFactoryInterface : SelectRTSLayerVisitorFactoryInterface) extends PlayerGameInput(param_inputList, new BasicArrayListD(), param_playerInputId) {

    val inputProcessorArray : Array[GameInputProcessor] = new Array[GameInputProcessor](InputFactory.getInstance().MAX)

    val removeInputProcessorArray : Array[GameInputProcessor] = new Array[GameInputProcessor](InputFactory.getInstance().MAX)

    private var inputList : BasicArrayList = null

    private val isSingleKeyProcessing : Boolean = Features.getInstance().isFeature(InputFeatureFactory.getInstance().SINGLE_KEY_REPEAT_PRESS) || Features.getInstance().isFeature(InputFeatureFactory.getInstance().SINGLE_KEY_PRESS)

    private var gameCanvas : AllBinaryGameCanvas = null

    private val motionGestureInputList : BasicArrayList = new BasicArrayListD()

    private var scrollPlayerGameInput : ScrollMapPlayerGameInput = null

    private var selectedRTSLayerPlayerGameInput : SelectedRTSLayersPlayerGameInput = null

    private var towerInfoPaintable : RTSLayerInfoPaintable = null

    private var rtsPlayerLayerInterface : RTSPlayerLayerInterface = null

    private var layerPositionFinderInterface : LayerPositionFinderInterface = null

    private var selectedRtsFormInput : RTSFormInput = NullRTSFormInputFactory.getInstance()

    //private LayerInterfaceFactoryInterface lastLayerInterfaceFactoryInterface;
    //Constructor
    {
        val gameCanvas : AllBinaryGameCanvas = param_gameCanvas
        val inputList : BasicArrayList = param_inputList
        val playerInputId : Int = param_playerInputId
        val towerInfoPaintable : RTSLayerInfoPaintable = param_towerInfoPaintable
        val rtsPlayerLayerInterface : RTSPlayerLayerInterface = param_rtsPlayerLayerInterface
        val layerPositionFinderInterface : LayerPositionFinderInterface = param_layerPositionFinderInterface
        val selectRTSLayerVisitorFactoryInterface : SelectRTSLayerVisitorFactoryInterface = param_selectRTSLayerVisitorFactoryInterface
        this.initInputProcessors()
        this.gameCanvas = gameCanvas
        this.inputList = inputList
        this.towerInfoPaintable = towerInfoPaintable
        this.rtsPlayerLayerInterface = rtsPlayerLayerInterface
        this.selectedRTSLayerPlayerGameInput = new SelectedRTSLayersPlayerGameInput(this.getRTSLayerInfoPaintable(), this.getRtsPlayerLayerInterface(), this.inputList, playerInputId, selectRTSLayerVisitorFactoryInterface)
        if (this.rtsPlayerLayerInterface ne NullRTSLayer.NULL_RTS_LAYER) {
            this.setSelectedRtsFormInput(this.rtsPlayerLayerInterface.getRTSFormInput())
        }
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = this.gameCanvas.getLayerManager().asInstanceOf[GeographicMapCompositeInterface]
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        this.scrollPlayerGameInput = new ScrollMapPlayerGameInput(geographicMapInterface, this.inputList, playerInputId)
        // this.currentPlayerGameInput = this.scrollPlayerGameInput;
        this.layerPositionFinderInterface = layerPositionFinderInterface
    }

    def setAllBinaryGameLayerManager(allBinaryGameLayerManager : AllBinaryGameLayerManager) : Unit = {
        this.selectedRTSLayerPlayerGameInput.setAllBinaryGameLayerManager(allBinaryGameLayerManager)
        if (this.selectedRtsFormInput ne NullRTSFormInputFactory.getInstance()) {
            this.selectedRtsFormInput.setAllBinaryGameLayerManager(allBinaryGameLayerManager)
        }
    }

    def onDisplayChangeEvent(displayChangeEvent : DisplayChangeEvent) : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, "onDisplayChangeEvent")
            this.getRTSLayerInfoPaintable().update()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "onDisplayChangeEvent", e)
            }
        }
    }

    def left() : Unit = {
        this.rtsPlayerLayerInterface.getCurrentScrollSelectionForm().processInputKey(Canvas.LEFT)
    }

    def right() : Unit = {
        this.rtsPlayerLayerInterface.getCurrentScrollSelectionForm().processInputKey(Canvas.RIGHT)
    }

    def initInputProcessors() : Unit = {
        this.inputProcessorArray(Canvas.LEFT) = new RTSPlayerLeftGameInputProcessor(this)
        this.inputProcessorArray(Canvas.KEY_NUM0) = this.inputProcessorArray(Canvas.LEFT)
        this.inputProcessorArray(Canvas.RIGHT) = new RTSPlayerRightGameInputProcessor(this)
        this.inputProcessorArray(Canvas.KEY_POUND) = this.inputProcessorArray(Canvas.RIGHT)
        this.removeInputProcessorArray(Canvas.KEY_NUM1) = new RTSPlayerFireGameInputProcessor(this)
        this.removeInputProcessorArray(Canvas.KEY_NUM3) = this.removeInputProcessorArray(Canvas.KEY_NUM1)
        this.removeInputProcessorArray(Canvas.KEY_NUM3) = this.removeInputProcessorArray(Canvas.KEY_NUM1)
        this.removeInputProcessorArray(Canvas.LEFT) = this.removeInputProcessorArray(Canvas.KEY_NUM1)
        this.removeInputProcessorArray(Canvas.RIGHT) = this.removeInputProcessorArray(Canvas.KEY_NUM1)
        this.removeInputProcessorArray(Canvas.KEY_NUM0) = this.removeInputProcessorArray(Canvas.KEY_NUM1)
        this.removeInputProcessorArray(Canvas.KEY_POUND) = this.removeInputProcessorArray(Canvas.KEY_NUM1)
        GameInputProcessorUtil.init(this.inputProcessorArray)
        GameInputProcessorUtil.init(this.removeInputProcessorArray)
    }

    def processInput(layerManager : AllBinaryLayerManager) : Unit = {
        try {
            this.processMotionInput(layerManager)
            var size : Int = this.inputList.size()
            var key : Int = 0

            {
                var index : Int = 0
                while (index < size) {
                    var gameKeyEvent : GameKeyEvent = this.inputList.get(index).asInstanceOf[GameKeyEvent]
                    key = gameKeyEvent.getKey()
                    this.getScrollPlayerGameInput().processInputKey(key)
                    this.getSelectedBuildingPlayerGameInput().processInputKey(key)
                    // this.currentPlayerGameInput.processInput(key);
                    this.inputProcessorArray(key).processEvent(layerManager, gameKeyEvent)
                    this.removeInputProcessorArray(key).processEvent(layerManager, gameKeyEvent)
                    index += 1
                }
            }
            if (this.isIsSingleKeyProcessing()) {
                this.clear()
            } else {
                this.update()
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.gameInputStrings.PROCESS_INPUT, e)
            }
        }
    }

    def processMotionInput(layerManager : AllBinaryLayerManager) : Unit = {
    }

    def select(motionGestureEvent : MotionGestureEvent) : Unit = {
        val point : GPoint = motionGestureEvent.getCurrentPoint()
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = this.gameCanvas.getLayerManager().asInstanceOf[GeographicMapCompositeInterface]
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        val allBinaryTiledLayer : AllBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer()
        val x : Int = point.getX() + allBinaryTiledLayer.getXP()
        val y : Int = point.getY() + allBinaryTiledLayer.getYP()
        //commonLabels).append(allBinaryTiledLayer.getHeight(), this, "select");
        var geographicMapCellPosition : GeographicMapCellPosition = geographicMapInterface.getCellPositionAtXYNoThrow(x, y)
        if (geographicMapCellPosition ne SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            SecondaryPlayerQueueFactory.getInstance().add(SelectSound.getInstance())
            var layer : AllBinaryLayer = this.layerPositionFinderInterface.getLayerInterface(geographicMapCellPosition)
            if (layer eq AllBinaryLayer.NULL_ALLBINARY_LAYER) {
                layer = CollidableDestroyableDamageableLayer.getNullInstance()
            } else {
                geographicMapCellPosition = geographicMapInterface.getCellPositionAtXY(layer.getXP(), layer.getYP())
            }
            val foundRTSLayer : CollidableDestroyableDamageableLayer = layer.asInstanceOf[CollidableDestroyableDamageableLayer]
            // otherwise set to null
            this.setSelectedRTSLayer(foundRTSLayer, geographicMapCellPosition)
        } else {
            val commonLabels : CommonLabels = CommonLabels.getInstance()
            this.logUtil.putF(new StringMaker().append("Off Of Map -").append(commonLabels.WIDTH_LABEL).appendint(allBinaryTiledLayer.getWidth()).append(commonLabels.HEIGHT_LABEL).appendint(allBinaryTiledLayer.getHeight()).toString(), this, "select")
        }
    }

    def setSelectedRTSLayer(rtsLayer : CollidableDestroyableDamageableLayer, geographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        //this.setSelectedRtsLayer(rtsLayer);
        this.getSelectedBuildingPlayerGameInput().setSelectedRTSLayer(rtsLayer)
    }

    def paint(graphics : Graphics) : Unit = {
        val geographicMapCellPosition : GeographicMapCellPosition = this.getSelectedRtsFormInput().getSelectedGeographicCellPosition()
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = this.gameCanvas.getLayerManager().asInstanceOf[GeographicMapCompositeInterface]
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        val allBinaryTiledLayer : AllBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer()
        graphics.setColor(BasicColorFactory.getInstance().GREEN.intValue())
        var list : BasicArrayList = this.getSelectedBuildingPlayerGameInput().getPaintSelectedRTSLayersList()
        var width : Int = 0
        var height : Int = 0
        if (list.size() > 0) {

            {
                var index : Int = list.size() - 1
                while (index >= 0) {
                    var rtsLayer : RTSLayer = list.get(index).asInstanceOf[RTSLayer]
                    width = rtsLayer.getWidth()
                    height = rtsLayer.getHeight()
                    graphics.drawRect(rtsLayer.getXP() - allBinaryTiledLayer.getXP(), rtsLayer.getYP() - allBinaryTiledLayer.getYP(), width, height)
                    index -= 1
                }
            }
        } else if (geographicMapCellPosition ne SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            var point : GPoint = geographicMapCellPosition.getPoint()
            width = allBinaryTiledLayer.getCellWidth()
            height = allBinaryTiledLayer.getCellHeight()
            graphics.drawRect(point.getX() - allBinaryTiledLayer.getXP(), point.getY() - allBinaryTiledLayer.getYP(), width, height)
        }
    }

    def updatePaintable() : Unit = {
    }

    def getSelectedBuildingPlayerGameInput() : SelectedRTSLayersPlayerGameInput = {
        return this.selectedRTSLayerPlayerGameInput
    }

    /**      * @return the selectedRtsFormInput      */
    def getSelectedRtsFormInput() : RTSFormInput = {
        return this.selectedRtsFormInput
    }

    /**      * @param selectedRtsFormInput the selectedRtsFormInput to set      */
    def setSelectedRtsFormInput(selectedRtsFormInput : RTSFormInput) : Unit = {
        this.logUtil.putF(new StringMaker().append("RTSFormInput: ").append(StringUtil.getInstance().toString(selectedRtsFormInput)).toString(), this, "setSelectedRtsFormInput")
        this.selectedRtsFormInput = selectedRtsFormInput
    }

    /**      * @return the rtsPlayerLayerInterface      */
    def getRtsPlayerLayerInterface() : RTSPlayerLayerInterface = {
        return this.rtsPlayerLayerInterface
    }

    /**      * @return the towerInfoPaintable      */
    def getRTSLayerInfoPaintable() : RTSLayerInfoPaintable = {
        return this.towerInfoPaintable
    }

    /**      * @return the motionGestureInputList      */
    def getMotionGestureInputList() : BasicArrayList = {
        return this.motionGestureInputList
    }

    /**      * @return the gameCanvas      */
    def getGameCanvas() : AllBinaryGameCanvas = {
        return this.gameCanvas
    }

    /**      * @return the isSingleKeyProcessing      */
    def isIsSingleKeyProcessing() : Boolean = {
        return this.isSingleKeyProcessing
    }

    def getScrollPlayerGameInput() : ScrollMapPlayerGameInput = {
        return this.scrollPlayerGameInput
    }

}


