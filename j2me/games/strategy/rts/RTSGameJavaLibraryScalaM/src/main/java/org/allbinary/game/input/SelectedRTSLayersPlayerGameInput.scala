/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.game.layer.RTSGameStrings
import _root_.org.allbinary.game.layer.RTSLayer
import _root_.org.allbinary.game.layer.RTSLayerInfoPaintable
import _root_.org.allbinary.game.layer.RTSPlayerLayerInterface
import _root_.org.allbinary.game.layer.capital.Capital
import _root_.org.allbinary.media.audio.DowngradeSound
import _root_.org.allbinary.media.audio.UpgradeSound
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.util.BasicArrayListUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.InputFeatureFactory
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.hud.event.GameNotificationEvent
import _root_.org.allbinary.game.layer.hud.event.GameNotificationEventHandler
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.util.visitor.Visitor
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.media.audio.ErrorSound
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCompositeInterface

/**  *   * @author user  */
class SelectedRTSLayersPlayerGameInput(param_towerInfoPaintable : RTSLayerInfoPaintable, param_rtsPlayerLayerInterface : RTSPlayerLayerInterface, param_list : BasicArrayList, param_playerInputId : Int, param_selectRTSLayerVisitorFactoryInterface : SelectRTSLayerVisitorFactoryInterface) extends PlayerGameInput(param_list, new BasicArrayListD(), param_playerInputId) {

    val inputProcessorArray : Array[GameInputProcessor] = new Array[GameInputProcessor](InputFactory.getInstance().MAX)

    private var list : BasicArrayList = null

    val isSingleKeyProcessing : Boolean = Features.getInstance().isFeature(InputFeatureFactory.getInstance().SINGLE_KEY_REPEAT_PRESS) || Features.getInstance().isFeature(InputFeatureFactory.getInstance().SINGLE_KEY_PRESS)

    private var selectedRTSLayersList : BasicArrayList = new BasicArrayListD()

    private var preSelectedRTSLayersList : BasicArrayList = new BasicArrayListD()

    private var paintSelectedRTSLayersList : BasicArrayList = BasicArrayListUtil.getInstance().getImmutableInstance()

    private var rtsPlayerLayerInterface : RTSPlayerLayerInterface = null

    private var selectRTSLayerVisitorInterface : Visitor = null

    private var upgradeGameNotificationEvent : GameNotificationEvent = null

    private var noMoneyGameNotificationEvent : GameNotificationEvent = null

    private var downgradeGameNotificationEvent : GameNotificationEvent = null

    //Constructor
    {
        val towerInfoPaintable : RTSLayerInfoPaintable = param_towerInfoPaintable
        val rtsPlayerLayerInterface : RTSPlayerLayerInterface = param_rtsPlayerLayerInterface
        val list : BasicArrayList = param_list
        val playerInputId : Int = param_playerInputId
        val selectRTSLayerVisitorFactoryInterface : SelectRTSLayerVisitorFactoryInterface = param_selectRTSLayerVisitorFactoryInterface
        this.initInputProcessors()
        this.rtsPlayerLayerInterface = rtsPlayerLayerInterface
        this.list = list
        this.selectRTSLayerVisitorInterface = selectRTSLayerVisitorFactoryInterface.create(this)
        val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()
        val basicColorFactory : BasicColorFactory = BasicColorFactory.getInstance()
        this.upgradeGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().UPGRADE, smallIntegerSingletonFactory.getAt(2), basicColorFactory.PINK, BooleanFactory.getInstance().FALSE)
        this.noMoneyGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().NO_MONEY, smallIntegerSingletonFactory.getAt(2), basicColorFactory.PINK, BooleanFactory.getInstance().FALSE)
        this.downgradeGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().DOWNGRADE, smallIntegerSingletonFactory.getAt(2), basicColorFactory.PINK, BooleanFactory.getInstance().FALSE)
    }

    def setAllBinaryGameLayerManager(allBinaryGameLayerManager : AllBinaryGameLayerManager) : Unit = {
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = allBinaryGameLayerManager.asInstanceOf[GeographicMapCompositeInterface]
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        this.upgradeGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
        this.noMoneyGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
        this.downgradeGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
    }

    def isSelected(rtsLayer : RTSLayer) : Boolean = {
        if (this.selectedRTSLayersList.contains(rtsLayer)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def upgrade() : Unit = {
        var anyChanged : Boolean = false

        {
            var index : Int = this.selectedRTSLayersList.size() - 1
            while (index >= 0) {
                var rtsLayer : RTSLayer = this.selectedRTSLayersList.get(index).asInstanceOf[RTSLayer]
                if (rtsLayer.isUpgradeable()) {
                    var capital : Capital = this.rtsPlayerLayerInterface.getCapital()
                    var upgradeCost : Int = rtsLayer.getUpgradeCost()
                    if (upgradeCost <= capital.getTotalMoney()) {
                        anyChanged = true
                        this.rtsPlayerLayerInterface.add(UpgradeSound.getInstance())
                        rtsLayer.upgrade()
                        capital.removeMoney(upgradeCost)
                        // this.towerInfoPaintable.updateRTSLayerInfo(this.selectedLayer);
                        if (!this.rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
                            GameNotificationEventHandler.getInstance().fireEvent(this.upgradeGameNotificationEvent)
                        }
                    } else {
                        this.rtsPlayerLayerInterface.add(ErrorSound.getInstance())
                        if (!this.rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
                            //Not enough money
                            GameNotificationEventHandler.getInstance().fireEvent(this.noMoneyGameNotificationEvent)
                        }
                    }
                }
                index -= 1
            }
        }
        //Since a set of layers could be selected just update when all are changed
        if (anyChanged) {
            val rtsPlayerGameInput : RTSPlayerGameInput = (this.rtsPlayerLayerInterface.getPlayerGameInput().asInstanceOf[RTSPlayerGameInput])
            rtsPlayerGameInput.updatePaintable()
        }
    }

    def downgrade() : Unit = {
        var anyChanged : Boolean = false

        {
            var index : Int = this.selectedRTSLayersList.size()
            while ({ index -= 1; index } >= 0) {
                var rtsLayer : RTSLayer = this.selectedRTSLayersList.get(index).asInstanceOf[RTSLayer]
                if (rtsLayer.isDowngradeable()) {
                    anyChanged = true
                    this.rtsPlayerLayerInterface.add(DowngradeSound.getInstance())
                    var downgradeCost : Int = rtsLayer.getDowngradeCost()
                    rtsLayer.downgrade()
                    var capital : Capital = this.rtsPlayerLayerInterface.getCapital()
                    capital.addMoney(downgradeCost)
                    // this.towerInfoPaintable.updateRTSLayerInfo(this.selectedLayer);
                    if (!this.rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
                        GameNotificationEventHandler.getInstance().fireEvent(this.downgradeGameNotificationEvent)
                    }
                }
            }
        }
        //Since a set of layers could be selected just update when all are changed
        if (anyChanged) {
            val rtsPlayerGameInput : RTSPlayerGameInput = (this.rtsPlayerLayerInterface.getPlayerGameInput().asInstanceOf[RTSPlayerGameInput])
            rtsPlayerGameInput.updatePaintable()
        }
    }

    def initInputProcessors() : Unit = {
        this.inputProcessorArray(Canvas.KEY_NUM1) = new SelectedRTSLayersPlayerUpgradeGameInputProcessor(this)
        this.inputProcessorArray(Canvas.KEY_NUM3) = new SelectedRTSLayersPlayerDowngradeGameInputProcessor(this)
        GameInputProcessorUtil.init(this.inputProcessorArray)
    }

    def processInputKey(key : Int) : Unit = {
        if (this.selectedRTSLayersList != null) {
            this.inputProcessorArray(key).processEvent(AllBinaryGameLayerManager.getNullInstance(), GameKeyEvent.NONE)
        }
    }

    def processInput(layerManager : AllBinaryLayerManager) : Unit = {
        try {
            var size : Int = this.list.size()
            var key : Int = 0

            {
                var index : Int = 0
                while (index < size) {
                    var gameKeyEvent : GameKeyEvent = this.list.get(index).asInstanceOf[GameKeyEvent]
                    key = gameKeyEvent.getKey()
                    this.processInputKey(key)
                    index += 1
                }
            }
            if (this.isSingleKeyProcessing) {
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

    /**      * @return the selectedRTSLayer      */
    def getSelectedBasicArrayList() : BasicArrayList = {
        return this.selectedRTSLayersList
    }

    /**      * @param selectedRTSLayer      *            the selectedRTSLayer to set      */
    def addSelectedRTSLayer(selectedLayer : RTSLayer) : Unit = {
        this.paintSelectedRTSLayersList = BasicArrayListUtil.getInstance().getImmutableInstance()
        if (selectedLayer eq CollidableDestroyableDamageableLayer.getNullInstance()) {
            this.deselectAll()
            this.selectedRTSLayersList.clear()
        } else {
            if (!this.selectedRTSLayersList.contains(selectedLayer)) {
                this.selectedRTSLayersList.add(selectedLayer)
            }
        }
        this.paintSelectedRTSLayersList = this.selectedRTSLayersList
    }

    def setSelectedRTSLayer(selectedLayer : CollidableDestroyableDamageableLayer) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Selected Layer: ")
        if (selectedLayer != null) {
            stringBuffer.append(selectedLayer.getName())
        }
        this.logUtil.putF(stringBuffer.toString(), this, "setSelectedRTSLayer")
        this.paintSelectedRTSLayersList = BasicArrayListUtil.getInstance().getImmutableInstance()
        this.selectRTSLayerVisitorInterface.visit(selectedLayer)
        this.deselectAll()
        //Could be better if list if never deselected until a new command occurs instead        
        if (this.selectedRTSLayersList.size() > 0) {
            this.getPreSelectedRTSLayersList().clear()
            val tempList : BasicArrayList = this.getPreSelectedRTSLayersList()
            this.preSelectedRTSLayersList = this.selectedRTSLayersList
            this.selectedRTSLayersList = tempList
            this.logUtil.putF(new StringMaker().append("Preselected: ").append(this.preSelectedRTSLayersList.toString()).toString(), this, "setSelectedRTSLayer")
        }
        //this.selectedRTSLayersList.clear();
        if (selectedLayer ne CollidableDestroyableDamageableLayer.getNullInstance()) {
            this.selectedRTSLayersList.add(selectedLayer)
        }
        this.paintSelectedRTSLayersList = this.selectedRTSLayersList
    }

    def getLastSelectedRtsLayer() : CollidableDestroyableDamageableLayer = {
        if (this.isAnyRTSLayerSelected()) {
            return this.selectedRTSLayersList.get(this.selectedRTSLayersList.size() - 1).asInstanceOf[CollidableDestroyableDamageableLayer]
        } else {
            return CollidableDestroyableDamageableLayer.getNullInstance()
        }
        throw new IllegalStateException()
    }

    def selectAllPreselected() : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Select all Preselected: ")
        stringBuffer.append(this.preSelectedRTSLayersList.toString())
        this.logUtil.putF(stringBuffer.toString(), this, "selectAllPreselected")

        {
            var index : Int = this.preSelectedRTSLayersList.size() - 1
            while (index >= 0) {
                var rtsLayer : RTSLayer = this.preSelectedRTSLayersList.get(index).asInstanceOf[RTSLayer]
                rtsLayer.select()
                index -= 1
            }
        }
    }

    def deselectAllPreselected() : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Deselect all Preselected: ")
        stringBuffer.append(this.preSelectedRTSLayersList.toString())
        this.logUtil.putF(stringBuffer.toString(), this, "deselectAllPreselected")

        {
            var index : Int = this.preSelectedRTSLayersList.size() - 1
            while (index >= 0) {
                var rtsLayer : RTSLayer = this.preSelectedRTSLayersList.get(index).asInstanceOf[RTSLayer]
                rtsLayer.deselect()
                index -= 1
            }
        }
        this.preSelectedRTSLayersList.clear()
    }

    def deselectAll() : Unit = {

        {
            var index : Int = this.selectedRTSLayersList.size() - 1
            while (index >= 0) {
                var rtsLayer : RTSLayer = this.selectedRTSLayersList.get(index).asInstanceOf[RTSLayer]
                rtsLayer.deselect()
                index -= 1
            }
        }
    }

    def isAnyRTSLayerSelected() : Boolean = {
        if (this.selectedRTSLayersList.size() == 0) {
            return false
        }
        return true
    }

    def getPaintSelectedRTSLayersList() : BasicArrayList = {
        return this.paintSelectedRTSLayersList
    }

    def getPreSelectedRTSLayersList() : BasicArrayList = {
        return this.preSelectedRTSLayersList
    }

}


