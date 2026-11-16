/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.unit

import _root_.org.allbinary.game.input.form.PrimaryWaypointHelper
import _root_.org.allbinary.game.layer.AdvancedRTSGameLayer
import _root_.org.allbinary.game.layer.RTSLayerEvent
import _root_.org.allbinary.game.layer.SensorAction
import _root_.org.allbinary.game.layer.SensorActionFactory
import _root_.org.allbinary.game.layer.WaypointBehaviorBase
import _root_.org.allbinary.game.layer.building.BuildingLayer
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.game.layer.waypoint.event.WaypointEventListenerInterface
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellHistory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.SimpleGeographicMapCellPositionFactory
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.util.BasicArrayListUtil

class UnitWaypointBehavior(param_associatedAdvancedRTSGameLayer : UnitLayer, param_fakeWaypoint : CollidableDestroyableDamageableLayer) extends WaypointBehaviorBase with WaypointEventListenerInterface {

    val commonSeps : CommonSeps = CommonSeps.getInstance()

    private val unitWaypointStrings : UnitWaypointStrings = UnitWaypointStrings.getInstance()

    private var longWeaponRange : Int = 0

    private var sensorAction : SensorAction = SensorActionFactory.getInstance().ATTACK

    private var completeTimeDelayHelper : TimeDelayHelper = null

    var currentGeographicMapCellHistoryP : GeographicMapCellHistory = null

    private var lastPathGeographicMapCellPosition : GeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION

    private var currentPathGeographicMapCellPosition : GeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION

    private var FAKE_WAYPOINT_LAYER : CollidableDestroyableDamageableLayer = null

    var targetList : BasicArrayList = null

    private var possibleTargetList : BasicArrayList = null

    var associatedAdvancedRTSGameLayer : UnitLayer = null

    private var moving : Boolean = false

    private var movingFromStopped : Boolean = false

    var waypointPathsListP : BasicArrayList = BasicArrayListUtil.getInstance().getImmutableInstance()

    private var currentTargetDistance : Int = Integer.MAX_VALUE

    var currentTargetLayerInterfaceP : CollidableDestroyableDamageableLayer = CollidableDestroyableDamageableLayer.getNullInstance()

    private var trackingWaypoint : Boolean = false

    private val repeatedToLong : TimeDelayHelper = new TimeDelayHelper(22000)

    //Constructor
    {
        val associatedAdvancedRTSGameLayer : UnitLayer = param_associatedAdvancedRTSGameLayer
        val fakeWaypoint : CollidableDestroyableDamageableLayer = param_fakeWaypoint
        this.associatedAdvancedRTSGameLayer = associatedAdvancedRTSGameLayer
        this.completeTimeDelayHelper = new TimeDelayHelper(30000)
        this.targetList = new BasicArrayListD()
        this.possibleTargetList = new BasicArrayListD()
        this.setWaypointPathsList(BasicArrayListUtil.getInstance().getImmutableInstance())
        this.currentGeographicMapCellHistoryP = new GeographicMapCellHistory()
        this.FAKE_WAYPOINT_LAYER = fakeWaypoint
    }

    def initRange(weaponRange : Int) : Unit = {
        this.longWeaponRange = weaponRange / 2
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def onWaypointEvent(event : RTSLayerEvent) : Unit = {
        val advancedRTSGameLayer : AdvancedRTSGameLayer = event.getRtsLayer().asInstanceOf[AdvancedRTSGameLayer]
        this.associatedAdvancedRTSGameLayer.waypointLogHelperP.onWaypointEvent(this.associatedAdvancedRTSGameLayer, advancedRTSGameLayer)
        // advancedRTSGameLayer.getParentLayer() == null for buildings
        if (this.associatedAdvancedRTSGameLayer.isSelected()) {
            this.addWaypointFromUser(advancedRTSGameLayer)
        } else if (advancedRTSGameLayer.shouldAddWaypointFromBuilding()) {
            this.addWaypointFromBuilding(advancedRTSGameLayer)
        }
    }

    def addWaypointFromUser(advancedRTSGameLayer : AdvancedRTSGameLayer) : Unit = {
    }

    private def addWaypointFromBuilding(advancedRTSGameLayer : AdvancedRTSGameLayer) : Unit = {
        if ((advancedRTSGameLayer eq PrimaryWaypointHelper.getInstance().getWaypointLayer()) || (advancedRTSGameLayer.getParentLayer() eq this.associatedAdvancedRTSGameLayer.getParentLayer())) {
            if (!this.targetList.contains(advancedRTSGameLayer)) {
                this.associatedAdvancedRTSGameLayer.waypointLogHelperP.addWaypointFromBuilding(this.associatedAdvancedRTSGameLayer, advancedRTSGameLayer)
                if (advancedRTSGameLayer.isDestroyed()) {
                    throw new Exception("Trying to add a dead: " + advancedRTSGameLayer)
                }
                this.targetList.add(advancedRTSGameLayer)
                this.associatedAdvancedRTSGameLayer.waypointLogHelperP.addWaypointFromBuildingList(this.associatedAdvancedRTSGameLayer, advancedRTSGameLayer, this.targetList)
            }
        }
    }

    override def isWaypointListEmptyOrOnlyTargets() : Boolean = {
        return false
    }

    def insertWaypoint(index : Int, rtsLayer : CollidableDestroyableDamageableLayer) : Boolean = {
        if (this.canInsertWaypoint(index, rtsLayer)) {
            this.associatedAdvancedRTSGameLayer.waypointLogHelperP.insertWaypoint(this.associatedAdvancedRTSGameLayer, index, rtsLayer, this.getName())
            if (rtsLayer.isDestroyed()) {
                throw new Exception("Trying to add a dead: " + rtsLayer)
            }
            this.targetList.addAt(index, rtsLayer)
            this.associatedAdvancedRTSGameLayer.waypointLogHelperP.insertWaypointList(this.associatedAdvancedRTSGameLayer, index, rtsLayer, this.getName(), this.targetList)
            return true
        }
        return false
    }

    def move() : Unit = {
        if (this.isMoving()) {
            this.setMovingFromStopped(false)
        } else {
            this.setMovingFromStopped(true)
        }
        this.setMoving(false)
    }

    def setRandomGeographicMapCellHistory(pathsList : BasicArrayList) : Unit = {
        val size : Int = pathsList.size()
        this.associatedAdvancedRTSGameLayer.waypointLogHelperP.setRandomGeographicMapCellHistoryList(this.associatedAdvancedRTSGameLayer, pathsList)
        if (size > 0) {
            val geographicMapCellPositionBasicArrayList : BasicArrayList = BasicArrayListUtil.getInstance().getRandom(pathsList).asInstanceOf[BasicArrayList]
            this.setGeographicMapCellHistoryPath(geographicMapCellPositionBasicArrayList)
        }
    }

    def setGeographicMapCellHistoryPath(geographicMapCellPositionBasicArrayList : BasicArrayList) : Unit = {
        this.lastPathGeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
        if (this.associatedAdvancedRTSGameLayer.showMoreCaptionStates) {
            this.associatedAdvancedRTSGameLayer.getCaptionAnimationHelper().update(this.unitWaypointStrings.PATHING, BasicColorFactory.getInstance().GREEN)
        }
        this.currentGeographicMapCellHistoryP.init()
        this.associatedAdvancedRTSGameLayer.init(this.currentGeographicMapCellHistoryP, geographicMapCellPositionBasicArrayList)
        this.setTrackingWaypoint(true)
        this.getCompleteTimeDelayHelper().setStartTimeTNT()
    }

    def canInsertWaypoint(index : Int, rtsLayer : CollidableDestroyableDamageableLayer) : Boolean = {
        if (this.targetList.size() > 4) {
        } else if (this.targetList.contains(rtsLayer)) {
        } else {
            return true
        }
        return false
    }

    def addBuildingChase(allbinaryLayer : AllBinaryLayer, cellPosition : GeographicMapCellPosition) : Unit = {
    }

    def moveAwayFromBuilding(buildingLayer : BuildingLayer) : Unit = {
        val geographicMapCellPosition : GeographicMapCellPosition = this.associatedAdvancedRTSGameLayer.getCurrentGeographicMapCellPosition()
        val list : BasicArrayList = buildingLayer.geographicMapCellPositionAreaBase.getOccupyingGeographicMapCellPositionList()
        if (list.contains(geographicMapCellPosition)) {
            if (this.insertWaypoint(0, this.FAKE_WAYPOINT_LAYER)) {
                this.associatedAdvancedRTSGameLayer.waypointLogHelperP.moveAwayFromBuilding(this.associatedAdvancedRTSGameLayer)
                this.setCurrentTargetLayerInterface(this.FAKE_WAYPOINT_LAYER.asInstanceOf[CollidableDestroyableDamageableLayer])
                val pathsList : BasicArrayList = buildingLayer.getMoveOutOfBuildAreaPath(geographicMapCellPosition)
                // {
                this.associatedAdvancedRTSGameLayer.setClosestGeographicMapCellHistory(pathsList)
            }
        }
    }

    override def needToMove() : Boolean = {
        this.associatedAdvancedRTSGameLayer.waypointLogHelperP.needToMove(this.associatedAdvancedRTSGameLayer, this)
        if ((this.isTrackingWaypoint() || (this.sensorAction eq SensorActionFactory.getInstance().EVADE)) || ((this.currentTargetLayerInterfaceP ne CollidableDestroyableDamageableLayer.getNullInstance()) && (this.getCurrentTargetDistance() >= (this.longWeaponRange + this.currentTargetLayerInterfaceP.getHalfHeight())))) {
            this.repeatedToLong.setStartTimeTNT()
            return true
        }
        if (this.repeatedToLong.isTimeTNT()) {
            val message : String = "Repeating too long: " + this.getMovementLogicAsString()
            ForcedLogUtil.log(message, this.associatedAdvancedRTSGameLayer)
        }
        return false
    }

    override def getMovementLogicAsString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("isTrackingWaypoint: ")
        stringBuffer.appendboolean(this.isTrackingWaypoint())
        stringBuffer.append(" sensorAction: ")
        stringBuffer.append(this.sensorAction.name)
        stringBuffer.append(" getCurrentTargetLayerInterface: ")
        stringBuffer.append(StringUtil.getInstance().toString(this.currentTargetLayerInterfaceP))
        if (this.currentTargetLayerInterfaceP ne CollidableDestroyableDamageableLayer.getNullInstance()) {
            stringBuffer.append(" Target Range: ")
            stringBuffer.appendint(this.getCurrentTargetDistance())
            stringBuffer.append(" >= ")
            stringBuffer.appendint(this.longWeaponRange + this.currentTargetLayerInterfaceP.getHalfHeight())
        }
        return stringBuffer.toString()
    }

    def isMovingFromStopped() : Boolean = {
        return this.movingFromStopped
    }

    /**      * @param movingFromStopped the movingFromStopped to set      */
    def setMovingFromStopped(movingFromStopped : Boolean) : Unit = {
        this.movingFromStopped = movingFromStopped
    }

    override def setWaypointPathsList(waypointPathsList : BasicArrayList) : Unit = {
        this.waypointPathsListP = waypointPathsList
    }

    override def getWaypointPathsList() : BasicArrayList = {
        return this.waypointPathsListP
    }

    /**      * @return the moving      */
    def isMoving() : Boolean = {
        return this.moving
    }

    /**      * @param moving the moving to set      */
    def setMoving(moving : Boolean) : Unit = {
        this.moving = moving
    }

    /**      * @return the trackingWaypoint      */
    override def isTrackingWaypoint() : Boolean = {
        return this.trackingWaypoint
    }

    def getPossibleTargetList() : BasicArrayList = {
        return this.possibleTargetList
    }

    def setLastPathGeographicMapCellPosition(lastPathGeographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        this.lastPathGeographicMapCellPosition = lastPathGeographicMapCellPosition
    }

    def getLastPathGeographicMapCellPosition() : GeographicMapCellPosition = {
        return this.lastPathGeographicMapCellPosition
    }

    def setCurrentPathGeographicMapCellPosition(currentPathGeographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        this.currentPathGeographicMapCellPosition = currentPathGeographicMapCellPosition
    }

    override def getCurrentPathGeographicMapCellPosition() : GeographicMapCellPosition = {
        return this.currentPathGeographicMapCellPosition
    }

    def setSensorAction(sensorAction : SensorAction) : Unit = {
        this.sensorAction = sensorAction
    }

    def getSensorAction() : SensorAction = {
        return this.sensorAction
    }

    //    }
    def setCurrentTargetLayerInterface(currentTargetLayerInterface : CollidableDestroyableDamageableLayer) : Unit = {
        this.currentTargetLayerInterfaceP = currentTargetLayerInterface
    }

    override def getCurrentTargetLayerInterface() : CollidableDestroyableDamageableLayer = {
        return this.currentTargetLayerInterfaceP
    }

    def setCurrentTargetDistance(currentTargetDistance : Int) : Unit = {
        this.currentTargetDistance = currentTargetDistance
    }

    def getCurrentTargetDistance() : Int = {
        return this.currentTargetDistance
    }

    def getCompleteTimeDelayHelper() : TimeDelayHelper = {
        return this.completeTimeDelayHelper
    }

    override def getCurrentGeographicMapCellHistory() : GeographicMapCellHistory = {
        return this.currentGeographicMapCellHistoryP
    }

    def setTrackingWaypoint(trackingWaypoint : Boolean) : Unit = {
        this.trackingWaypoint = trackingWaypoint
    }

}


