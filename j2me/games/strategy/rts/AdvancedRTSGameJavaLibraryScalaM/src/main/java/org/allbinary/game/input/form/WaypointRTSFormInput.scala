/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.form

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.game.input.RTSPlayerGameInput
import _root_.org.allbinary.game.layer.AdvancedRTSGameLayer
import _root_.org.allbinary.game.layer.AdvancedRTSPlayerLayerInterface
import _root_.org.allbinary.game.layer.RTSGameStrings
import _root_.org.allbinary.game.layer.RTSLayer
import _root_.org.allbinary.game.layer.RTSLayerEvent
import _root_.org.allbinary.game.layer.RTSLayerUtil
import _root_.org.allbinary.game.layer.RTSPlayerLayerInterface
import _root_.org.allbinary.game.layer.capital.Capital
import _root_.org.allbinary.game.layer.waypoint.WaypointCellPositionHistory
import _root_.org.allbinary.game.layer.waypoint.WaypointLayer
import _root_.org.allbinary.game.layer.waypoint.event.WaypointEventHandlerFactory
import _root_.org.allbinary.graphics.form.item.ABCustomItem
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.game.identification.Group
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.game.layer.GeographicMapCellPositionAreaBase
import _root_.org.allbinary.game.layer.NullPathFindingLayer
import _root_.org.allbinary.game.layer.NullRTSLayer
import _root_.org.allbinary.game.layer.PathFindingLayerInterface
import _root_.org.allbinary.game.layer.hud.event.GameNotificationEvent
import _root_.org.allbinary.game.layer.hud.event.GameNotificationEventHandler
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.layer.Layer
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.media.audio.ErrorSound
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCompositeInterface
import _root_.org.allbinary.media.graphics.geography.map.drop.DropCellPositionHistory
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGeographicMapCellTypeFactory

/**  *  * @author user  */
class WaypointRTSFormInput(param_groupInterface : Array[Group], param_isPrimaryWaypointCreator : Boolean) extends RTSFormInput(param_groupInterface) {

    private val WAYPOINT_EVENT : RTSLayerEvent = new RTSLayerEvent(NullRTSLayer.NULL_RTS_LAYER)

    var dragToSpotGameNotificationEvent : GameNotificationEvent = null

    var spotTakenGameNotificationEvent : GameNotificationEvent = null

    var buildingCollisionGameNotificationEvent : GameNotificationEvent = null

    var roadCollisionGameNotificationEvent : GameNotificationEvent = null

    var newWaypointGameNotificationEvent : GameNotificationEvent = null

    var noMoneyGameNotificationEvent : GameNotificationEvent = null

    private var isPrimaryWaypointCreator : Boolean = false

    private var stickyAssociatedRtsLayer : PathFindingLayerInterface = NullPathFindingLayer.NULL_PATH_FINDING_LAYER

    //Constructor
    {
        val groupInterface : Array[Group] = param_groupInterface
        val isPrimaryWaypointCreator : Boolean = param_isPrimaryWaypointCreator
        this.isPrimaryWaypointCreator = isPrimaryWaypointCreator
        val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()
        val basicColorFactory : BasicColorFactory = BasicColorFactory.getInstance()
        this.dragToSpotGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().DRAG_TO_SPOT, smallIntegerSingletonFactory.getAt(2), basicColorFactory.WHITE, BooleanFactory.getInstance().FALSE)
        this.spotTakenGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().SPOT_TAKEN, smallIntegerSingletonFactory.getAt(2), basicColorFactory.WHITE, BooleanFactory.getInstance().FALSE)
        this.buildingCollisionGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().BUILDING_COLLISION, smallIntegerSingletonFactory.getAt(2), basicColorFactory.WHITE, BooleanFactory.getInstance().FALSE)
        this.roadCollisionGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().ROAD_COLLISION, smallIntegerSingletonFactory.getAt(2), basicColorFactory.WHITE, BooleanFactory.getInstance().FALSE)
        this.newWaypointGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().NEW_WAYPOINT, smallIntegerSingletonFactory.getAt(2), basicColorFactory.WHITE, BooleanFactory.getInstance().FALSE)
        this.noMoneyGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().NO_MONEY, smallIntegerSingletonFactory.getAt(2), basicColorFactory.WHITE, BooleanFactory.getInstance().FALSE)
    }

    override def setAllBinaryGameLayerManager(allBinaryGameLayerManager : AllBinaryGameLayerManager) : Unit = {
        super.setAllBinaryGameLayerManager(allBinaryGameLayerManager)
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = allBinaryGameLayerManager.asInstanceOf[GeographicMapCompositeInterface]
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        this.dragToSpotGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
        this.spotTakenGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
        this.buildingCollisionGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
        this.roadCollisionGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
        this.newWaypointGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
        this.noMoneyGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
    }

    override def processAtPoint(associatedRtsLayer : CollidableDestroyableDamageableLayer, rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerManager : AllBinaryLayerManager, point : GPoint) : Unit = {
        super.process(layerManager)
        if (this.isStickyItemSelected() || (associatedRtsLayer eq CollidableDestroyableDamageableLayer.getNullInstance())) {
            if (this.isStickyItemSelected() && (associatedRtsLayer eq CollidableDestroyableDamageableLayer.getNullInstance())) {
                val geographicMapCompositeInterface : GeographicMapCompositeInterface = layerManager.asInstanceOf[GeographicMapCompositeInterface]
                val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
                val allBinaryTiledLayer : AllBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer()
                var x : Int = point.getX() + allBinaryTiledLayer.getXP()
                var y : Int = point.getY() + allBinaryTiledLayer.getYP()
                val geographicMapCellPosition : GeographicMapCellPosition = geographicMapInterface.getCellPositionAtXY(x, y)
                this.processCellPosition(rtsPlayerLayerInterface, layerManager, geographicMapCellPosition)
            } else {
                if (!rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
                    GameNotificationEventHandler.getInstance().fireEvent(this.dragToSpotGameNotificationEvent)
                }
            }
        } else {
            if (!rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
                GameNotificationEventHandler.getInstance().fireEvent(this.spotTakenGameNotificationEvent)
            }
        }
    }

    private def processCellPosition(rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerManager : AllBinaryLayerManager, geographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        var itemIndex : Int = this.getSelectedStickyItemIndex()
        if (this.newUnconstructedRTSLayerInterfaceArray(itemIndex) eq CollidableDestroyableDamageableLayer.getNullInstance()) {
            this.newUnconstructedRTSLayerInterfaceArray(itemIndex) = this.getInstance(layerManager, this.getSelectedStickyItem(), geographicMapCellPosition)
        } else {
            //GPoint cellPoint = geographicMapCellPosition.getMidPoint();
            val cellPoint : GPoint = geographicMapCellPosition.getPoint()
            val rtsLayer : RTSLayer = this.newUnconstructedRTSLayerInterfaceArray(itemIndex).asInstanceOf[RTSLayer]
            rtsLayer.setPosition(cellPoint.getX(), cellPoint.getY(), rtsLayer.getZP())
            val geographicMapCompositeInterface : GeographicMapCompositeInterface = rtsLayer.allBinaryGameLayerManagerP.asInstanceOf[GeographicMapCompositeInterface]
            val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
            rtsLayer.geographicMapCellPositionAreaBase.update(geographicMapInterface)
        }
        this.attemptBuild(rtsPlayerLayerInterface, layerManager, this.newUnconstructedRTSLayerInterfaceArray(itemIndex).asInstanceOf[RTSLayer], itemIndex)
    }

    override def processStickyGameSpecific(associatedRtsLayer : CollidableDestroyableDamageableLayer, rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerManager : AllBinaryLayerManager, item : ABCustomItem, index : Int) : Unit = {
        this.logUtil.putF("Set Sticking Item: " + item, this, "processSticky")
        this.setSelectedStickyItem(item)
        this.setSelectedStickyItemIndex(index)
        this.setStickyItemSelected(true)
        this.stickyAssociatedRtsLayer = associatedRtsLayer.asInstanceOf[RTSLayer]
        this.getHashtable().put(Layer.ID, associatedRtsLayer)
    }

    def attemptBuild(rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerManager : AllBinaryLayerManager, layerInterface : RTSLayer, itemIndex : Int) : Boolean = {
        this.logUtil.putF("Layer: " + layerInterface, this, "attemptBuild")
        if (layerInterface == null) {
            this.logUtil.put("Layer was null", this, "attemptBuild", new Exception())
            return false
        }
        var geographicMapCellPositionArea : GeographicMapCellPositionAreaBase = layerInterface.geographicMapCellPositionAreaBase
        var list : BasicArrayList = geographicMapCellPositionArea.getOccupyingGeographicMapCellPositionList()
        //this.logUtil.putF("List: " + list, this, "attemptBuild");
        if (DropCellPositionHistory.getInstance().anyCellPositionWithDrop(list) || WaypointCellPositionHistory.getInstance().anyCellPositionWithDrop(list)) {
            rtsPlayerLayerInterface.add(ErrorSound.getInstance())
            if (!rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
                GameNotificationEventHandler.getInstance().fireEvent(this.buildingCollisionGameNotificationEvent)
            }
            return false
        }
        /*         else         {         if (this.isSurroundingCellsOffMap(layerInterface))         {         rtsPlayerLayerInterface.add(ErrorSound.getInstance());          rtsPlayerLayerInterface.getGameNotificationHud().add(         RTSGameStrings.MAP_EDGE, smallIntegerSingletonFactory.getInstance(2),         this.geographicMapInterface.getForegroundBasicColor(), Boolean.FALSE);         return;         }         }          */
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = layerManager.asInstanceOf[GeographicMapCompositeInterface]
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        val raceTrackGeographicMapCellTypeFactory : RaceTrackGeographicMapCellTypeFactory = geographicMapInterface.getGeographicMapCellTypeFactory().asInstanceOf[RaceTrackGeographicMapCellTypeFactory]
        var geographicMapCellType : GeographicMapCellType = null

        {
            var index : Int = list.size()
            while ({ index -= 1; index } >= 0) {
                geographicMapCellType = geographicMapInterface.getCellTypeAt(list.get(index).asInstanceOf[GeographicMapCellPosition])
                if (raceTrackGeographicMapCellTypeFactory.isPath(geographicMapCellType)) {
                    rtsPlayerLayerInterface.add(ErrorSound.getInstance())
                    if (!rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
                        GameNotificationEventHandler.getInstance().fireEvent(this.roadCollisionGameNotificationEvent)
                    }
                    return false
                }
            }
        }
        var cost : Int = layerInterface.getCost()
        var capital : Capital = rtsPlayerLayerInterface.getCapital()
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
            WaypointCellPositionHistory.getInstance().addList(list, layerInterface)
            val geographicMapCellPosition : GeographicMapCellPosition = geographicMapInterface.getCellPositionAtXY(layerInterface.getXP(), layerInterface.getYP())
            val waypointLayer : WaypointLayer = layerInterface.asInstanceOf[WaypointLayer]
            this.addWayPoint(waypointLayer)
            val rtsPlayerGameInput : RTSPlayerGameInput = rtsPlayerLayerInterface.getPlayerGameInput().asInstanceOf[RTSPlayerGameInput]
            rtsPlayerGameInput.setSelectedRTSLayer(layerInterface, geographicMapCellPosition)
            val advancedRTSPlayerLayerInterface : AdvancedRTSPlayerLayerInterface = rtsPlayerLayerInterface.asInstanceOf[AdvancedRTSPlayerLayerInterface]
            advancedRTSPlayerLayerInterface.getAdvancedPlayerOwnedRTSLayers().addWaypoint(layerInterface)
            //if(this.stickyAssociatedRtsLayer.getType() != UnitLayer.getStaticType())
            layerManager.append(layerInterface)
            val waypointAvancedRTSGameLayer : AdvancedRTSGameLayer = waypointLayer.asInstanceOf[AdvancedRTSGameLayer]
            rtsPlayerLayerInterface.add(waypointAvancedRTSGameLayer.getWaypointBehavior().getWaypoint().getSound())
            if (!rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
                GameNotificationEventHandler.getInstance().fireEvent(this.newWaypointGameNotificationEvent)
            }
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

    /*     private boolean isSurroundingCellsOffMap(RTSLayer layerInterface)     {         GeographicMapCellPositionArea geographicMapCellPositionArea =             layerInterface.geographicMapCellPositionArea;          BasicArrayList occupyList =             geographicMapCellPositionArea.getOccupyingGeographicMapCellPositionList();          BasicArrayList surroundList =             geographicMapCellPositionArea.getSurroundingGeographicMapCellPositionList();          //surround should be 4*sqrt(occupy) + 4 or 4*side + 4         //Table         //sides cells surround         //1 1 8         //2 4 12         //3 9 16         //4 16 20          int occupySize = occupyList.size();         int surroundSize = surroundList.size();          this.logUtil.putF(             "occupySize: " + occupySize +             " surroundSize: " + surroundSize +             " surroundList: " + surroundList, this, "isSurroundingCellsOffMap");          boolean isSurroundOffMap = false;         if (occupySize == 1 && surroundSize != 8)         {             isSurroundOffMap = true;         }         else if (occupySize == 4 && surroundSize != 12)         {             isSurroundOffMap = true;         }          if (occupySize == 0 || isSurroundOffMap)         {             return true;         }         else         {             return false;         }     }     */
    private def addWayPoint(layerInterface : WaypointLayer) : Unit = {
        val stickyAssociatedAdvandedRtsLayer : AdvancedRTSGameLayer = this.stickyAssociatedRtsLayer.asInstanceOf[AdvancedRTSGameLayer]
        //Currently only one waypoint owned per layer
        val list : BasicArrayList = stickyAssociatedAdvandedRtsLayer.getWaypointBehavior().getOwnedWaypointList()
        RTSLayerUtil.getInstance().destroyAndClear(list)
        //Add new waypoint to owner
        list.add(layerInterface)
        if (this.isPrimaryWaypointCreator) {
            PrimaryWaypointHelper.getInstance().setWaypointLayer(layerInterface)
        }
        this.WAYPOINT_EVENT.setRtsLayer(layerInterface)
        WaypointEventHandlerFactory.getInstance(layerInterface.getGroupInterface()(0)).fireEvent(this.WAYPOINT_EVENT)
    }

}


