/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.form

import _root_.org.allbinary.game.input.RTSPlayerGameInput
import _root_.org.allbinary.game.layer.DemoLockedWithCostLayerInterfaceFactoryInterface
import _root_.org.allbinary.game.layer.GeographicMapCellPositionAreaBase
import _root_.org.allbinary.game.layer.RTSGameStrings
import _root_.org.allbinary.game.layer.RTSLayer
import _root_.org.allbinary.game.layer.RTSPlayerLayerInterface
import _root_.org.allbinary.game.layer.capital.Capital
import _root_.org.allbinary.game.layer.item.LayerInterfaceFactoryImageItem
import _root_.org.allbinary.graphics.form.item.ABCustomItem
import _root_.org.allbinary.media.audio.BuildingSound
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.logic.system.security.licensing.LockedFeatureNotificationUtil
import _root_.org.allbinary.logic.system.security.licensing.LockedUtil
import _root_.org.allbinary.game.identification.Group
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.hud.event.GameNotificationEvent
import _root_.org.allbinary.game.layer.hud.event.GameNotificationEventHandler
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.media.audio.ErrorSound
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCompositeInterface
import _root_.org.allbinary.media.graphics.geography.map.SimpleGeographicMapCellPositionFactory
import _root_.org.allbinary.media.graphics.geography.map.drop.DropCellPositionHistory
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGeographicMapCellTypeFactory

/**  *  * @author user  */
class BuildingRTSFormInput(param_groupInterface : Array[Group], param_isUnitProducer : Boolean) extends RTSFormInput(param_groupInterface) {

    private var isUnitProducer : Boolean = false

    private var buildOnPathGameNotificationEvent : GameNotificationEvent = null

    private var spotTakenGameNotificationEvent : GameNotificationEvent = null

    private var selectBuildSpotGameNotificationEvent : GameNotificationEvent = null

    private var roadCollisionGameNotificationEvent : GameNotificationEvent = null

    private var noMoneyGameNotificationEvent : GameNotificationEvent = null

    private var buildingCollisionGameNotificationEvent : GameNotificationEvent = null

    private var structureToCloseCollisionGameNotificationEvent : GameNotificationEvent = null

    private var buildingGameNotificationEvent : GameNotificationEvent = null

    private var mapEdgeGameNotificationEvent : GameNotificationEvent = null

    private val dropCellPositionHistory : DropCellPositionHistory = DropCellPositionHistory.getInstance()

    //Constructor
    {
        val groupInterface : Array[Group] = param_groupInterface
        val isUnitProducer : Boolean = param_isUnitProducer
        this.isUnitProducer = isUnitProducer
        val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()
        val basicColorFactory : BasicColorFactory = BasicColorFactory.getInstance()
        this.buildOnPathGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().BUILD_ON_PATH, smallIntegerSingletonFactory.getAt(2), basicColorFactory.PINK, BooleanFactory.getInstance().FALSE)
        this.spotTakenGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().SPOT_TAKEN, smallIntegerSingletonFactory.getAt(2), basicColorFactory.PINK, BooleanFactory.getInstance().FALSE)
        this.selectBuildSpotGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().SELECT_BUILD_SPOT, smallIntegerSingletonFactory.getAt(2), basicColorFactory.PINK, BooleanFactory.getInstance().FALSE)
        this.roadCollisionGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().ROAD_COLLISION, smallIntegerSingletonFactory.getAt(2), basicColorFactory.PINK, BooleanFactory.getInstance().FALSE)
        this.noMoneyGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().NO_MONEY, smallIntegerSingletonFactory.getAt(2), basicColorFactory.PINK, BooleanFactory.getInstance().FALSE)
        this.buildingCollisionGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().BUILDING_COLLISION, smallIntegerSingletonFactory.getAt(2), basicColorFactory.PINK, BooleanFactory.getInstance().FALSE)
        this.structureToCloseCollisionGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().STRUCTURE_TO_CLOSE, smallIntegerSingletonFactory.getAt(2), basicColorFactory.PINK, BooleanFactory.getInstance().FALSE)
        this.buildingGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().BUILDING, smallIntegerSingletonFactory.getAt(2), basicColorFactory.PINK, BooleanFactory.getInstance().FALSE)
        this.mapEdgeGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().MAP_EDGE, smallIntegerSingletonFactory.getAt(2), basicColorFactory.PINK, BooleanFactory.getInstance().FALSE)
    }

    override def setAllBinaryGameLayerManager(allBinaryGameLayerManager : AllBinaryGameLayerManager) : Unit = {
        super.setAllBinaryGameLayerManager(allBinaryGameLayerManager)
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = allBinaryGameLayerManager.asInstanceOf[GeographicMapCompositeInterface]
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        this.buildOnPathGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
        this.spotTakenGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
        this.selectBuildSpotGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
        this.roadCollisionGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
        this.noMoneyGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
        this.buildingCollisionGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
        this.structureToCloseCollisionGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
        this.buildingGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
        this.mapEdgeGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
    }

    override def processGameSpecific(associatedRtsLayer : CollidableDestroyableDamageableLayer, rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerManager : AllBinaryLayerManager, item : ABCustomItem, itemIndex : Int) : Unit = {
        super.process(layerManager)
        this.buildFromMotionInput(rtsPlayerLayerInterface, layerManager, item, itemIndex)
    }

    def isPositionBlocked() : Boolean = {
        return this.dropCellPositionHistory.isCellPositionWithDrop(this.getSelectedGeographicCellPosition())
    }

    private def isDemoLocked(item : ABCustomItem) : Boolean = {
        val factoryItem : LayerInterfaceFactoryImageItem = item.asInstanceOf[LayerInterfaceFactoryImageItem]
        val layerInterfaceFactoryInterface : DemoLockedWithCostLayerInterfaceFactoryInterface = factoryItem.getLayerInterfaceFactoryInterface().asInstanceOf[DemoLockedWithCostLayerInterfaceFactoryInterface]
        if (LockedUtil.getInstance().isLocked() && layerInterfaceFactoryInterface.isDemoLocked()) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def buildFromMotionInput(rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerManager : AllBinaryLayerManager, item : ABCustomItem, itemIndex : Int) : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        this.logUtil.putF(commonStrings.START, this, "buildFromMotionInput")
        if (layerManager == null) {
            throw new RuntimeException()
        }
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = layerManager.asInstanceOf[GeographicMapCompositeInterface]
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        if (this.isDemoLocked(item)) {
            rtsPlayerLayerInterface.add(ErrorSound.getInstance())
            LockedFeatureNotificationUtil.getInstance().fireWithColor(geographicMapInterface.getForegroundBasicColor())
            return
        }
        // If no tower is selected try to build if tower is selected
        val geographicMapCellPosition : GeographicMapCellPosition = this.getSelectedGeographicCellPosition()
        if (geographicMapCellPosition ne SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            // null)
            if (!this.isPositionBlocked()) {
                val geographicMapCellType : GeographicMapCellType = geographicMapInterface.getCellTypeAt(geographicMapCellPosition)
                val raceTrackGeographicMapCellTypeFactory : RaceTrackGeographicMapCellTypeFactory = geographicMapInterface.getGeographicMapCellTypeFactory().asInstanceOf[RaceTrackGeographicMapCellTypeFactory]
                if (!raceTrackGeographicMapCellTypeFactory.isPath(geographicMapCellType)) {
                    if (this.newUnconstructedRTSLayerInterfaceArray(itemIndex) eq CollidableDestroyableDamageableLayer.getNullInstance()) {
                        this.newUnconstructedRTSLayerInterfaceArray(itemIndex) = this.getInstance(layerManager, item, geographicMapCellPosition)
                    } else {
                        val rtsLayer : RTSLayer = this.newUnconstructedRTSLayerInterfaceArray(itemIndex).asInstanceOf[RTSLayer]
                        //update area and position
                        val cellPoint : GPoint = geographicMapCellPosition.getPoint()
                        rtsLayer.setPosition(cellPoint.getX(), cellPoint.getY(), cellPoint.getZ())
                        rtsLayer.geographicMapCellPositionAreaBase.update(geographicMapInterface)
                    }
                    val rtsLayer : RTSLayer = this.newUnconstructedRTSLayerInterfaceArray(itemIndex).asInstanceOf[RTSLayer]
                    this.attemptBuild(rtsPlayerLayerInterface, layerManager, rtsLayer, itemIndex)
                } else {
                    rtsPlayerLayerInterface.add(ErrorSound.getInstance())
                    if (!rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
                        GameNotificationEventHandler.getInstance().fireEvent(this.buildOnPathGameNotificationEvent)
                    }
                }
            } else {
                rtsPlayerLayerInterface.add(ErrorSound.getInstance())
                if (!rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
                    GameNotificationEventHandler.getInstance().fireEvent(this.spotTakenGameNotificationEvent)
                }
            }
        } else {
            rtsPlayerLayerInterface.add(ErrorSound.getInstance())
            if (!rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
                GameNotificationEventHandler.getInstance().fireEvent(this.selectBuildSpotGameNotificationEvent)
            }
        }
    }

    def attemptBuild(rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerManager : AllBinaryLayerManager, layerInterface : RTSLayer, itemIndex : Int) : Boolean = {
        this.logUtil.putF(new StringMaker().append("Layer: ").append(StringUtil.getInstance().toString(layerInterface)).toString(), this, "attemptBuild")
        val geographicMapCellPositionArea : GeographicMapCellPositionAreaBase = layerInterface.geographicMapCellPositionAreaBase
        val occupyList : BasicArrayList = geographicMapCellPositionArea.getOccupyingGeographicMapCellPositionList()
        //this.logUtil.putF("List: ").append(list, this, "attemptBuild");
        if (!this.isBuildAttemptValid(rtsPlayerLayerInterface, layerInterface)) {
            return false
        }
        var geographicMapCellType : GeographicMapCellType = null

        {
            var index : Int = occupyList.size() - 1
            while (index >= 0) {
                val geographicMapCompositeInterface : GeographicMapCompositeInterface = layerManager.asInstanceOf[GeographicMapCompositeInterface]
                val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
                geographicMapCellType = geographicMapInterface.getCellTypeAt(occupyList.get(index).asInstanceOf[GeographicMapCellPosition])
                val raceTrackGeographicMapCellTypeFactory : RaceTrackGeographicMapCellTypeFactory = geographicMapInterface.getGeographicMapCellTypeFactory().asInstanceOf[RaceTrackGeographicMapCellTypeFactory]
                if (raceTrackGeographicMapCellTypeFactory.isPath(geographicMapCellType)) {
                    rtsPlayerLayerInterface.add(ErrorSound.getInstance())
                    if (!rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
                        GameNotificationEventHandler.getInstance().fireEvent(this.roadCollisionGameNotificationEvent)
                    }
                    return false
                }
                index -= 1
            }
        }
        val cost : Int = layerInterface.getCost()
        val capital : Capital = rtsPlayerLayerInterface.getCapital()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Trying to Build: ")
        stringBuffer.append(layerInterface.getName())
        stringBuffer.append(" for: $")
        stringBuffer.appendint(cost)
        stringBuffer.append(" with ")
        stringBuffer.appendint(capital.getTotalMoney())
        this.logUtil.putF(stringBuffer.toString(), this, "attemptBuild")
        if (cost <= capital.getTotalMoney()) {
            layerInterface.construct(rtsPlayerLayerInterface)
            this.newUnconstructedRTSLayerInterfaceArray(itemIndex) = CollidableDestroyableDamageableLayer.getNullInstance()
            capital.removeMoney(cost)
            this.add(rtsPlayerLayerInterface, layerManager, layerInterface)
            return true
        } else {
            rtsPlayerLayerInterface.add(ErrorSound.getInstance())
            if (!rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
                GameNotificationEventHandler.getInstance().fireEvent(this.noMoneyGameNotificationEvent)
            }
            return false
        }
        throw new IllegalStateException()
    }

    def isBuildAttemptValid(rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerInterface : RTSLayer) : Boolean = {
        val geographicMapCellPositionArea : GeographicMapCellPositionAreaBase = layerInterface.geographicMapCellPositionAreaBase
        val occupyList : BasicArrayList = geographicMapCellPositionArea.getOccupyingGeographicMapCellPositionList()
        if (this.dropCellPositionHistory.anyCellPositionWithDrop(occupyList)) {
            rtsPlayerLayerInterface.add(ErrorSound.getInstance())
            if (!rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
                GameNotificationEventHandler.getInstance().fireEvent(this.buildingCollisionGameNotificationEvent)
            }
            return false
        }
        if (this.isUnitProducer && this.dropCellPositionHistory.anyCellPositionWithDrop(geographicMapCellPositionArea.getSurroundingGeographicMapCellPositionList())) {
            rtsPlayerLayerInterface.add(ErrorSound.getInstance())
            if (!rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
                GameNotificationEventHandler.getInstance().fireEvent(this.structureToCloseCollisionGameNotificationEvent)
            }
            return false
        } else {
            if (this.isSurroundingCellsOffMap(layerInterface)) {
                rtsPlayerLayerInterface.add(ErrorSound.getInstance())
                if (!rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
                    GameNotificationEventHandler.getInstance().fireEvent(this.mapEdgeGameNotificationEvent)
                }
                return false
            }
        }
        return true
    }

    def add(rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerManager : AllBinaryLayerManager, layerInterface : RTSLayer) : Unit = {
        val geographicMapCellPositionArea : GeographicMapCellPositionAreaBase = layerInterface.geographicMapCellPositionAreaBase
        val occupyList : BasicArrayList = geographicMapCellPositionArea.getOccupyingGeographicMapCellPositionList()
        this.dropCellPositionHistory.addAll(occupyList, layerInterface)
        val rtsPlayerGameInput : RTSPlayerGameInput = rtsPlayerLayerInterface.getPlayerGameInput().asInstanceOf[RTSPlayerGameInput]
        rtsPlayerGameInput.setSelectedRTSLayer(layerInterface, this.getSelectedGeographicCellPosition())
        layerManager.append(layerInterface)
        rtsPlayerLayerInterface.add(BuildingSound.getInstance())
        if (!rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
            GameNotificationEventHandler.getInstance().fireEvent(this.buildingGameNotificationEvent)
        }
    }

    private def isSurroundingCellsOffMap(layerInterface : RTSLayer) : Boolean = {
        var geographicMapCellPositionArea : GeographicMapCellPositionAreaBase = layerInterface.geographicMapCellPositionAreaBase
        var occupyList : BasicArrayList = geographicMapCellPositionArea.getOccupyingGeographicMapCellPositionList()
        var surroundList : BasicArrayList = geographicMapCellPositionArea.getSurroundingGeographicMapCellPositionList()
        //4 16 20
        var occupySize : Int = occupyList.size()
        var surroundSize : Int = surroundList.size()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("occupySize: ")
        stringBuffer.appendint(occupySize)
        stringBuffer.append(" surroundSize: ")
        stringBuffer.appendint(surroundSize)
        stringBuffer.append(" surroundList: ")
        stringBuffer.append(StringUtil.getInstance().toString(surroundList))
        this.logUtil.putF(stringBuffer.toString(), this, "isSurroundingCellsOffMap")
        var isSurroundOffMap : Boolean = false
        if ((occupySize == 1) && (surroundSize != 8)) {
            isSurroundOffMap = true
        } else if ((occupySize == 4) && (surroundSize != 12)) {
            isSurroundOffMap = true
        }
        if ((occupySize == 0) || isSurroundOffMap) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

}


