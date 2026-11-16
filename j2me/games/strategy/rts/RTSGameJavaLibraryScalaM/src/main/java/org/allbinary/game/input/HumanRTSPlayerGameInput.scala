/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.input.form.RTSFormInput
import _root_.org.allbinary.game.layer.MultiSelectPaintable
import _root_.org.allbinary.game.layer.RTSGameStrings
import _root_.org.allbinary.game.layer.RTSLayer
import _root_.org.allbinary.game.layer.RTSLayerInfoPaintable
import _root_.org.allbinary.game.layer.RTSPlayerLayerInterface
import _root_.org.allbinary.game.state.GameStateFactory
import _root_.org.allbinary.input.motion.button.EndLevelNoBuildingSelectedTouchButtonsBuilder
import _root_.org.allbinary.input.motion.button.EndLevelTouchButtonsBuilder
import _root_.org.allbinary.input.motion.button.NoBuildingSelectedTouchButtonsBuilder
import _root_.org.allbinary.input.motion.button.RTSTouchButtonsBuilder
import _root_.org.allbinary.media.audio.SelectBuildingSound
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.game.displayable.canvas.AllBinaryGameCanvas
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.hud.event.GameNotificationEvent
import _root_.org.allbinary.game.layer.hud.event.GameNotificationEventHandler
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.form.ScrollSelectionForm
import _root_.org.allbinary.graphics.form.item.ABCustomItem
import _root_.org.allbinary.graphics.paint.NullInitUpdatePaintable
import _root_.org.allbinary.input.motion.button.TouchButtonsBuilderFactory
import _root_.org.allbinary.input.motion.gesture.MotionGestureInput
import _root_.org.allbinary.input.motion.gesture.TouchMotionGestureFactory
import _root_.org.allbinary.input.motion.gesture.observer.BaseMotionGestureEventListener
import _root_.org.allbinary.input.motion.gesture.observer.BasicMotionGesturesHandler
import _root_.org.allbinary.input.motion.gesture.observer.MotionGestureEvent
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.math.RectangleCollisionUtil
import _root_.org.allbinary.media.audio.ErrorSound
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCompositeInterface
import _root_.org.allbinary.view.ViewPositionBase

/**  *   * @author user  */
class HumanRTSPlayerGameInput(param_gameCanvas : AllBinaryGameCanvas, param_inputList : BasicArrayList, param_playerInputId : Int, param_towerInfoPaintable : RTSLayerInfoPaintable, param_rtsPlayerLayerInterface : RTSPlayerLayerInterface, param_layerPositionFinderInterface : LayerPositionFinderInterface, param_selectRTSLayerVisitorFactoryInterface : SelectRTSLayerVisitorFactoryInterface, param_touchButtonsBuilderFactory : TouchButtonsBuilderFactory) extends RTSPlayerGameInput(param_gameCanvas, param_inputList, param_playerInputId, param_towerInfoPaintable, param_rtsPlayerLayerInterface, param_layerPositionFinderInterface, param_selectRTSLayerVisitorFactoryInterface) with BaseMotionGestureEventListener {

    private var isDragging : Boolean = false

    val gameStateFactory : GameStateFactory = GameStateFactory.getInstance()

    //private final GameInputStrings gameInputStrings = GameInputStrings.getInstance();
    private val rectangleCollisionUtil : RectangleCollisionUtil = RectangleCollisionUtil.getInstance()

    private val touchMotionGestureFactory : TouchMotionGestureFactory = TouchMotionGestureFactory.getInstance()

    private val PRESSED : MotionGestureInput = this.touchMotionGestureFactory.PRESSED

    private val RELEASED : MotionGestureInput = this.touchMotionGestureFactory.RELEASED

    private var touchButtonsBuilderFactory : TouchButtonsBuilderFactory = null

    private var notYoursGameNotificationEvent : GameNotificationEvent = null

    private var selectedRtsLayer : CollidableDestroyableDamageableLayer = CollidableDestroyableDamageableLayer.getNullInstance()

    private var startPoint : GPoint = PointFactory.getInstance().ZERO_ZERO

    private var endPoint : GPoint = PointFactory.getInstance().ZERO_ZERO

    val POSSIBLE : String = "Possible: "

    val AT : String = "At: "

    val METHOD : String = "makeSelection"

    val ADDING : String = "Adding: "

    val SPACE : String = CommonSeps.getInstance().SPACE

    private val multiSelectPaintable : MultiSelectPaintable = new MultiSelectPaintable()

    //Constructor
    {
        val gameCanvas : AllBinaryGameCanvas = param_gameCanvas
        val inputList : BasicArrayList = param_inputList
        val playerInputId : Int = param_playerInputId
        val towerInfoPaintable : RTSLayerInfoPaintable = param_towerInfoPaintable
        val rtsPlayerLayerInterface : RTSPlayerLayerInterface = param_rtsPlayerLayerInterface
        val layerPositionFinderInterface : LayerPositionFinderInterface = param_layerPositionFinderInterface
        val selectRTSLayerVisitorFactoryInterface : SelectRTSLayerVisitorFactoryInterface = param_selectRTSLayerVisitorFactoryInterface
        val touchButtonsBuilderFactory : TouchButtonsBuilderFactory = param_touchButtonsBuilderFactory
        this.touchButtonsBuilderFactory = touchButtonsBuilderFactory
        val basicColorFactory : BasicColorFactory = BasicColorFactory.getInstance()
        this.notYoursGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().NOT_YOURS, SmallIntegerSingletonFactory.getInstance().getAt(2), basicColorFactory.PINK, BooleanFactory.getInstance().FALSE)
        BasicMotionGesturesHandler.getInstance().addListenerInterface(this)
    }

    override def setAllBinaryGameLayerManager(allBinaryGameLayerManager : AllBinaryGameLayerManager) : Unit = {
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = allBinaryGameLayerManager.asInstanceOf[GeographicMapCompositeInterface]
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        this.notYoursGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
    }

    private def processDraggingMotionInput(layerManager : AllBinaryLayerManager) : Boolean = {
        val motionGestureEvent : MotionGestureEvent = this.getMotionGestureInputList().get(this.getMotionGestureInputList().size() - 1).asInstanceOf[MotionGestureEvent]
        val motionGestureInput : MotionGestureInput = motionGestureEvent.getMotionGesture()
        val rtsFormInput : RTSFormInput = this.getSelectedRtsFormInput()
        if (motionGestureInput eq this.PRESSED) {
            val point : GPoint = motionGestureEvent.getCurrentPoint()
            if (this.getRtsPlayerLayerInterface().getCurrentScrollSelectionForm().isInForm(point)) {
                this.isDragging = rtsFormInput.processSticky(this.getSelectedRtsLayer(), this.getRtsPlayerLayerInterface(), layerManager, point)
            }
        } else if (motionGestureInput eq this.RELEASED) {
            val point : GPoint = motionGestureEvent.getCurrentPoint()
            if (this.getRtsPlayerLayerInterface().getCurrentScrollSelectionForm().isInForm(point)) {
                rtsFormInput.processAtPoint(this.getSelectedRtsLayer(), this.getRtsPlayerLayerInterface(), layerManager, point)
            } else if (rtsFormInput.isStickyItemSelected()) {
                val previousRtsFormInput : RTSFormInput = rtsFormInput
                this.select(motionGestureEvent)
                this.getSelectedBuildingPlayerGameInput().selectAllPreselected()
                previousRtsFormInput.processAtPoint(this.getSelectedRtsLayer(), this.getRtsPlayerLayerInterface(), layerManager, point)
                this.getSelectedBuildingPlayerGameInput().deselectAllPreselected()
            } else {
                this.select(motionGestureEvent)
            }
            rtsFormInput.setStickyItemSelected(false)
            rtsFormInput.setSelectedStickyItem(ABCustomItem.getNullInstance())
            rtsFormInput.setSelectedStickyItemIndex(-1)
            return true
        }
        return false
    }

    private def makeSelection() : Unit = {
        val rtsLayerList : BasicArrayList = this.getRtsPlayerLayerInterface().getPlayerOwnedRTSLayers().rtsLayerList
        var rectX1 : Int = this.startPoint.getX()
        var rectY1 : Int = this.startPoint.getY()
        var rectX2 : Int = this.endPoint.getX()
        var rectY2 : Int = this.endPoint.getY()
        if (rectX1 > rectX2) {
            rectX2 = rectX1
            rectX1 = this.endPoint.getX()
        }
        if (rectY1 > rectY2) {
            rectY2 = rectY1
            rectY1 = this.endPoint.getY()
        }
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.AT)
        stringBuffer.appendint(rectX1)
        stringBuffer.append(this.SPACE)
        stringBuffer.appendint(rectY1)
        stringBuffer.append(this.SPACE)
        stringBuffer.appendint(rectX2)
        stringBuffer.append(this.SPACE)
        stringBuffer.appendint(rectY2)
        this.logUtil.putF(stringBuffer.toString(), this, this.METHOD)
        var rtsLayer : RTSLayer = null

        {
            var index : Int = rtsLayerList.size() - 1
            while (index >= 0) {
                rtsLayer = rtsLayerList.get(index).asInstanceOf[RTSLayer]
                stringBuffer.delete(0, stringBuffer.length())
                val viewPosition : ViewPositionBase = rtsLayer.getViewPosition()
                stringBuffer.append(this.POSSIBLE)
                stringBuffer.append(rtsLayer.getName())
                stringBuffer.append(this.SPACE)
                stringBuffer.append(this.AT)
                stringBuffer.appendint((viewPosition.getX() + rtsLayer.getHalfWidth()))
                stringBuffer.append(this.SPACE)
                stringBuffer.appendint((viewPosition.getY() + rtsLayer.getHalfHeight()))
                this.logUtil.putF(stringBuffer.toString(), this, this.METHOD)
                if (this.rectangleCollisionUtil.isInside(rectX1, rectY1, rectX2, rectY2, viewPosition.getX() + rtsLayer.getHalfWidth(), viewPosition.getY() + rtsLayer.getHalfHeight())) {
                    this.logUtil.putF(new StringMaker().append(this.ADDING).append(rtsLayer.getName()).toString(), this, this.METHOD)
                    rtsLayer.select()
                    this.getSelectedBuildingPlayerGameInput().addSelectedRTSLayer(rtsLayer)
                }
                index -= 1
            }
        }
        //for now update on the last selected item
        val gameLayer : CollidableDestroyableDamageableLayer = this.getSelectedBuildingPlayerGameInput().getLastSelectedRtsLayer()
        if (gameLayer ne CollidableDestroyableDamageableLayer.getNullInstance()) {
            val lastRTSLayer : RTSLayer = gameLayer.asInstanceOf[RTSLayer]
            if (lastRTSLayer.getScrollSelectionForm() ne ScrollSelectionForm.getNullScrollSelectionForm()) {
                this.updateForm(lastRTSLayer.getScrollSelectionForm(), lastRTSLayer.getRTSFormInput())
                this.setSelectedRtsLayer(lastRTSLayer)
            }
        }
        this.updatePaintable()
    }

    private def processSelectionBoxMotionInput(layerManager : AllBinaryLayerManager) : Unit = {

        {
            var index : Int = this.getMotionGestureInputList().size() - 1
            while (index >= 0) {
                val motionGestureEvent : MotionGestureEvent = this.getMotionGestureInputList().get(index).asInstanceOf[MotionGestureEvent]
                val motionGestureInput : MotionGestureInput = motionGestureEvent.getMotionGesture()
                val point : GPoint = motionGestureEvent.getCurrentPoint()
                if (motionGestureInput eq this.touchMotionGestureFactory.PRESSED) {
                    //Start selection box
                    this.startPoint = point
                    this.endPoint = point
                } else if (motionGestureInput eq this.touchMotionGestureFactory.RELEASED) {
                    this.endPoint = point
                    //Make selection
                    this.makeSelection()
                    this.startPoint = PointFactory.getInstance().ZERO_ZERO
                    this.endPoint = PointFactory.getInstance().ZERO_ZERO
                } else {
                    //Adjust selection box
                    this.endPoint = point
                }
                index -= 1
            }
        }
    }

    override def processMotionInput(layerManager : AllBinaryLayerManager) : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, gameInputStrings.PROCESS_MOTION_INPUT);
        if (this.getMotionGestureInputList().size() > 0) {
            var endDrag : Boolean = this.processDraggingMotionInput(layerManager)
            //If Not dragging item then go ahead and create selection box
            if (!this.isDragging) {
                this.processSelectionBoxMotionInput(layerManager)
            }
            if (endDrag) {
                this.isDragging = false
            }
        }
        this.getMotionGestureInputList().clear()
    }

    /**      * @param selectedRtsFormInput the selectedRtsFormInput to set      */
    override def setSelectedRtsFormInput(selectedRtsFormInput : RTSFormInput) : Unit = {
        val logUtil : LogUtil = LogUtil.getInstance()
        this.logUtil.putF(new StringMaker().append(CommonLabels.getInstance().START).append(StringUtil.getInstance().toString(selectedRtsFormInput)).toString(), this, "setSelectedRtsFormInput")
        super.setSelectedRtsFormInput(selectedRtsFormInput)
        this.setSelectedRtsLayer(CollidableDestroyableDamageableLayer.getNullInstance())
    }

    private def updateFormForLayer(rtsLayer : RTSLayer) : Unit = {
        val scrollSelectionForm : ScrollSelectionForm = rtsLayer.getScrollSelectionForm()
        // Waypoints are the only games objects still without menus currently
        if ((scrollSelectionForm ne ScrollSelectionForm.getNullScrollSelectionForm()) && (this.getRtsPlayerLayerInterface().getGroupInterface()(0) eq rtsLayer.getGroupInterface()(0))) {
            this.updateForm(scrollSelectionForm, rtsLayer.getRTSFormInput())
            this.getSelectedBuildingPlayerGameInput().setSelectedRTSLayer(CollidableDestroyableDamageableLayer.getNullInstance())
            this.setSelectedRtsLayer(rtsLayer)
        } else {
            this.getRtsPlayerLayerInterface().setCurrentScrollSelectionForm(this.getRtsPlayerLayerInterface().getBuildingScrollSelectionForm())
            // geographicMapCellPosition);
            this.setSelectedRtsFormInput(this.getRtsPlayerLayerInterface().getRTSFormInput())
            this.getSelectedBuildingPlayerGameInput().setSelectedRTSLayer(CollidableDestroyableDamageableLayer.getNullInstance())
        }
    }

    private def updateForm(scrollSelectionForm : ScrollSelectionForm, rtfFormInput : RTSFormInput) : Unit = {
        // Waypoints are the only games objects still without menus
        this.getRtsPlayerLayerInterface().setCurrentScrollSelectionForm(scrollSelectionForm)
        // rtsLayer.getRTSFormInput().setSelectedGeographicCellPosition(geographicMapCellPosition);
        this.setSelectedRtsFormInput(rtfFormInput)
    }

    override def setSelectedRTSLayer(rtSLayer : CollidableDestroyableDamageableLayer, geographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        if ((rtSLayer ne CollidableDestroyableDamageableLayer.getNullInstance()) && (this.getRtsPlayerLayerInterface().getGroupInterface()(0) ne rtSLayer.getGroupInterface()(0))) {
            this.getRtsPlayerLayerInterface().add(ErrorSound.getInstance())
            GameNotificationEventHandler.getInstance().fireEvent(this.notYoursGameNotificationEvent)
            return
        }
        //deselect all?
        val gameCanvas : AllBinaryGameCanvas = this.getGameCanvas()
        if (rtSLayer ne CollidableDestroyableDamageableLayer.getNullInstance()) {
            this.getRtsPlayerLayerInterface().add(SelectBuildingSound.getInstance())
            val rtsLayer : RTSLayer = rtSLayer.asInstanceOf[RTSLayer]
            rtsLayer.select()
            this.updateFormForLayer(rtsLayer)
            if (gameCanvas.getGameState() eq this.gameStateFactory.PLAYING_GAME_STATE) {
                if (rtsLayer.isSelfUpgradeable()) {
                    gameCanvas.updateCurrentTouchInputFactory(new RTSTouchButtonsBuilder())
                } else {
                    gameCanvas.updateCurrentTouchInputFactory(new NoBuildingSelectedTouchButtonsBuilder())
                }
            } else {
                val endLevelTouchButtonsBuilder : EndLevelTouchButtonsBuilder = new EndLevelTouchButtonsBuilder()
                if (this.touchButtonsBuilderFactory != null) {
                    endLevelTouchButtonsBuilder.add(this.touchButtonsBuilderFactory.getInstance())
                }
                gameCanvas.updateCurrentTouchInputFactory(endLevelTouchButtonsBuilder)
            }
        } else {
            this.logUtil.putF("Set Player Default Form", this, "setSelectedRTSLayer")
            this.getRtsPlayerLayerInterface().setCurrentScrollSelectionForm(this.getRtsPlayerLayerInterface().getBuildingScrollSelectionForm())
            //   geographicMapCellPosition);
            this.setSelectedRtsFormInput(this.getRtsPlayerLayerInterface().getRTSFormInput())
            this.getSelectedBuildingPlayerGameInput().setSelectedRTSLayer(CollidableDestroyableDamageableLayer.getNullInstance())
            if (gameCanvas.getGameState() eq this.gameStateFactory.PLAYING_GAME_STATE) {
                gameCanvas.updateCurrentTouchInputFactory(new NoBuildingSelectedTouchButtonsBuilder())
            } else {
                val endLevelNoBuildingSelectedTouchButtonsBuilder : EndLevelNoBuildingSelectedTouchButtonsBuilder = new EndLevelNoBuildingSelectedTouchButtonsBuilder()
                if (this.touchButtonsBuilderFactory != null) {
                    endLevelNoBuildingSelectedTouchButtonsBuilder.add(this.touchButtonsBuilderFactory.getInstance())
                }
                gameCanvas.updateCurrentTouchInputFactory(endLevelNoBuildingSelectedTouchButtonsBuilder)
            }
        }
        this.getSelectedRtsFormInput().setSelectedGeographicCellPosition(geographicMapCellPosition)
        this.getSelectedBuildingPlayerGameInput().setSelectedRTSLayer(rtSLayer)
        this.updatePaintable()
    }

    override def updatePaintable() : Unit = {
        val list : BasicArrayList = this.getSelectedBuildingPlayerGameInput().getSelectedBasicArrayList()
        if (list.size() > 1) {
            val geographicMapCompositeInterface : GeographicMapCompositeInterface = this.getGameCanvas().asInstanceOf[GeographicMapCompositeInterface]
            val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
            this.multiSelectPaintable.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
            this.multiSelectPaintable.update(list)
            this.getRTSLayerInfoPaintable().updateRTSLayerInfoSelection(this.multiSelectPaintable)
        } else if (list.size() == 1) {
            var rtsLayer : RTSLayer = list.get(0).asInstanceOf[RTSLayer]
            this.getRTSLayerInfoPaintable().updateRTSLayerInfoSelection(rtsLayer.createHudPaintable())
        } else {
            this.getRTSLayerInfoPaintable().updateRTSLayerInfoInit(NullInitUpdatePaintable.getInstance())
        }
    }

    override def paint(graphics : Graphics) : Unit = {
        super.paint(graphics)
        if ((this.startPoint ne PointFactory.getInstance().ZERO_ZERO) && (this.endPoint ne PointFactory.getInstance().ZERO_ZERO)) {
            graphics.setColor(BasicColorFactory.getInstance().RED.intValue())
            var rectX1 : Int = this.startPoint.getX()
            var rectY1 : Int = this.startPoint.getY()
            var rectX2 : Int = this.endPoint.getX()
            var rectY2 : Int = this.endPoint.getY()
            if (rectX1 > rectX2) {
                rectX2 = rectX1
                rectX1 = this.endPoint.getX()
            }
            if (rectY1 > rectY2) {
                rectY2 = rectY1
                rectY1 = this.endPoint.getY()
            }
            graphics.drawRect(rectX1, rectY1, rectX2 - rectX1, rectY2 - rectY1)
        }
    }

    override def onMotionGestureEvent(motionGestureEvent : MotionGestureEvent) : Unit = {
        //this.logUtil.putF("motionGestureEvent: ").append(motionGestureEvent, this, "onMotionGestureEvent");
        this.getMotionGestureInputList().add(motionGestureEvent)
    }

    override def onScrolledMotionGestureEvent(motionGestureEvent : MotionGestureEvent) : Unit = {
    }

    /**      * @return the selectedRtsLayer      */
    private def getSelectedRtsLayer() : CollidableDestroyableDamageableLayer = {
        return this.selectedRtsLayer
    }

    /**      * @param selectedRtsLayer the selectedRtsLayer to set      */
    private def setSelectedRtsLayer(selectedRtsLayer : CollidableDestroyableDamageableLayer) : Unit = {
        this.selectedRtsLayer = selectedRtsLayer
    }

}


