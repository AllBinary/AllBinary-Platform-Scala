/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.unit

import _root_.org.allbinary.J2MEUtil
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.layer.SteeringVisitor
import _root_.org.allbinary.game.layer.AdvancedRTSGameLayer
import _root_.org.allbinary.game.layer.MultipassWaypointPathRunnable
import _root_.org.allbinary.game.layer.RTSLayer
import _root_.org.allbinary.game.layer.WaypointPathRunnable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.game.layer.PathFindingLayerInterface
import _root_.org.allbinary.game.layer.WaypointPathRunnableBase
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.game.layer.waypoint.WaypointBase
import _root_.org.allbinary.game.tracking.TrackingEventHandler
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.math.LayerDistanceUtil
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.SimpleGeographicMapCellPositionFactory
import _root_.org.allbinary.thread.PathFindingThreadPool
import _root_.org.allbinary.thread.ThreadPool
import _root_.org.allbinary.time.TimeDelayHelper

class UnitWaypointBehavior2(param_ownerAdvancedRTSGameLayer : UnitLayer, param_fakeWaypoint : AdvancedRTSGameLayer) extends UnitWaypointBehavior(param_ownerAdvancedRTSGameLayer, param_fakeWaypoint) {
    import _root_.org.allbinary.game.layer.unit.UnitWaypointBehavior2.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val unitWaypointStrings : UnitWaypointStrings = UnitWaypointStrings.getInstance()

    private val basicColorFactory : BasicColorFactory = BasicColorFactory.getInstance()

    private val layerDistanceUtil : LayerDistanceUtil = LayerDistanceUtil.getInstance()

    private val pathFindingThreadPool : ThreadPool = PathFindingThreadPool.getInstance()

    private var progressTimeDelayHelper : TimeDelayHelper = null

    private var wanderPathsList : BasicArrayList = null

    private var waypointPathRunnable : WaypointPathRunnableBase = null

    private var sensorRange : Int = 0

    private var closeRange : Int = 0

    private var nextUnvisitedPathGeographicMapCellPosition : GeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION

    private var afterNextUnvisitedPathGeographicMapCellPosition : GeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION

    private var waitingOnTargetPath : Boolean = false

    private var waitingOnWaypointPath : Boolean = false

    private var targetWithoutCachedPathLayerInterface : CollidableDestroyableDamageableLayer = CollidableDestroyableDamageableLayer.getNullInstance()

    private val buildingSteeringVisitor : BuildingSteeringVisitor = new BuildingSteeringVisitor()

    //protected
    //Constructor
    {
        val ownerAdvancedRTSGameLayer : UnitLayer = param_ownerAdvancedRTSGameLayer
        val fakeWaypoint : AdvancedRTSGameLayer = param_fakeWaypoint
        this.progressTimeDelayHelper = new TimeDelayHelper(5000)
        this.wanderPathsList = new BasicArrayListD()
        val features : Features = Features.getInstance()
        this.waypointPathRunnable = (if (J2MEUtil.isHTML()) new MultipassWaypointPathRunnable() else new WaypointPathRunnable())
    }

    override def initRange(weaponRange : Int) : Unit = {
        super.initRange(weaponRange)
        this.closeRange = weaponRange
        //this.getOwnerAdvancedRTSGameLayer().geographicMapInterface.getAllBinaryTiledLayer().getCellHeight() * 3 / 2;
        this.sensorRange = weaponRange * 4
        this.associatedAdvancedRTSGameLayer.waypoint2LogHelperP.initRange(this.associatedAdvancedRTSGameLayer, this.closeRange, this.sensorRange)
    }

    override def getNextUnvisitedPathGeographicMapCellPosition() : GeographicMapCellPosition = {
        return this.nextUnvisitedPathGeographicMapCellPosition
    }

    override def isRunning() : Boolean = {
        if (this.waypointPathRunnable.isRunning()) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    //making it more performant and less polling like
    override def processTick(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        if (this.waypointPathRunnable.isRunning()) {
            //thread is done
            if (this.waypointPathsListP ne UnitWaypointBehavior2.runningWaypointPathList) {
                this.waypointPathRunnable.setRunning(false)
                if (this.waitingOnTargetPath) {
                    this.setTargetPath()
                } else if (this.waitingOnWaypointPath) {
                    //TWBAdvancedRTSGameLayer
                    this.setWaypointPath(this.waypointPathRunnable.getTargetLayer().asInstanceOf[AdvancedRTSGameLayer])
                } else {
                    throw new Exception("Should not happen")
                }
            } else {
                return
            }
        }
        this.processTargetList()
        if (!this.waypointPathRunnable.isRunning()) {
            this.processWaypoint()
        } else {
            return
        }
        if (!this.waypointPathRunnable.isRunning()) {
            this.processTargeting()
        } else {
            return
        }
        if (!this.waypointPathRunnable.isRunning()) {
            this.teleportIfNoProgress()
        } else {
            return
        }
    }

    private def onEnemyMovement(layerInterface : AdvancedRTSGameLayer) : Unit = {
        /*         if(this.getOwnerAdvancedRTSGameLayer().isSelected())         {             this.logUtil.putF(                     "Enemy Possible Target: " + layerInterface.getName(), this, "selected: onEnemyMovement");                             }         */
        val anotherTargetDistance : Int = this.layerDistanceUtil.getDistance(this.associatedAdvancedRTSGameLayer, layerInterface)
        // Update Distance Of Current Target
        if (layerInterface eq this.currentTargetLayerInterfaceP) {
            this.setCurrentTargetDistance(anotherTargetDistance)
        } else {
            this.processPossibleTarget(layerInterface, anotherTargetDistance)
        }
    }

    private def processPossibleTarget(layerInterface : AdvancedRTSGameLayer, anotherTargetDistance : Int) : Unit = {
        var isShorterThanCurrentTargetDistance : Boolean = this.getCurrentTargetDistance() > anotherTargetDistance
        var isCurrentTargetDestroyed : Boolean = (this.currentTargetLayerInterfaceP ne CollidableDestroyableDamageableLayer.getNullInstance()) && this.currentTargetLayerInterfaceP.isDestroyed()
        this.associatedAdvancedRTSGameLayer.waypoint2LogHelperP.processPossibleTarget(this.associatedAdvancedRTSGameLayer, this, layerInterface, anotherTargetDistance, isShorterThanCurrentTargetDistance, isCurrentTargetDestroyed)
        if ((this.isWaypointListEmptyOrOnlyTargets() && this.isInSensorRange(layerInterface, anotherTargetDistance)) && (isShorterThanCurrentTargetDistance || isCurrentTargetDestroyed)) {
            this.associatedAdvancedRTSGameLayer.waypoint2LogHelperP.processSetTarget(this.associatedAdvancedRTSGameLayer, this, layerInterface, anotherTargetDistance)
            this.setTarget(layerInterface, anotherTargetDistance)
        } else if (this.isCloseRange(layerInterface, anotherTargetDistance) && (isShorterThanCurrentTargetDistance || isCurrentTargetDestroyed)) {
            this.associatedAdvancedRTSGameLayer.waypoint2LogHelperP.processPossibleTargetCloser(this.associatedAdvancedRTSGameLayer, this, layerInterface, anotherTargetDistance)
            this.setTarget(layerInterface, anotherTargetDistance)
        }
    }

    private def teleportIfNoProgress() : Unit = {
        if (this.isTrackingWaypoint() || this.associatedAdvancedRTSGameLayer.getParentLayer().isDestroyed()) {
            //If not progressing move to next position
            if (this.progressTimeDelayHelper.isTimeTNT() && (this.nextUnvisitedPathGeographicMapCellPosition ne SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION)) {
                this.associatedAdvancedRTSGameLayer.teleportTo(this.nextUnvisitedPathGeographicMapCellPosition)
            }
            //If path taking a long time then
            if (this.getCompleteTimeDelayHelper().isTimeTNT()) {
                val geographicMapCellPosition : GeographicMapCellPosition = this.currentGeographicMapCellHistoryP.getTracked().get(this.currentGeographicMapCellHistoryP.getSize() - 1).asInstanceOf[GeographicMapCellPosition]
                this.associatedAdvancedRTSGameLayer.teleportTo(geographicMapCellPosition)
            }
        }
    }

    private def setTarget(layerInterface : AdvancedRTSGameLayer, anotherTargetDistance : Int) : Unit = {
        this.associatedAdvancedRTSGameLayer.waypoint2LogHelperP.setTarget(this.associatedAdvancedRTSGameLayer, this, layerInterface, anotherTargetDistance)
        this.associatedAdvancedRTSGameLayer.getCaptionAnimationHelper().update(this.unitWaypointStrings.TARGET, BasicColorFactory.getInstance().GREEN)
        //Drop load when going after target
        this.associatedAdvancedRTSGameLayer.setLoad(0)
        //Set target for pathfinding or chasing
        this.setCurrentTargetDistance(anotherTargetDistance)
        this.setCurrentTargetLayerInterface(layerInterface)
        this.setTrackingWaypoint(false)
        //Hmm one target at a time
        this.targetList.clear()
        if (!this.isCloseRange(layerInterface, anotherTargetDistance) && this.canInsertWaypoint(0, this.currentTargetLayerInterfaceP)) {
            val geographicMapCellPosition : GeographicMapCellPosition = this.associatedAdvancedRTSGameLayer.getCurrentGeographicMapCellPosition()
            val pathFindingLayerInterface : PathFindingLayerInterface = (this.currentTargetLayerInterfaceP.asInstanceOf[PathFindingLayerInterface])
            val waypoint : WaypointBase = pathFindingLayerInterface.getWaypointBehavior().getWaypoint()
            val list : BasicArrayList = waypoint.getPathsListFromCacheOnly(geographicMapCellPosition)
            //"waypointPathsList: " + list, this);
            this.setWaypointPathsList(list)
            if (this.waypointPathsListP == null) {
                this.targetWithoutCachedPathLayerInterface = this.currentTargetLayerInterfaceP
            } else if (this.waypointPathsListP.size() != 0) {
                this.setTargetPath()
            }
        }
    }

    private def setTargetPath() : Unit = {
        if (this.currentTargetLayerInterfaceP ne CollidableDestroyableDamageableLayer.getNullInstance()) {
            if (this.currentTargetLayerInterfaceP.isDestroyed()) {
                this.associatedAdvancedRTSGameLayer.waypoint2LogHelperP.setTargetPath(this.associatedAdvancedRTSGameLayer)
                this.associatedAdvancedRTSGameLayer.getCaptionAnimationHelper().update(this.unitWaypointStrings.KILL, this.basicColorFactory.ORANGE)
                this.clearTarget()
                return
            }
            // Ignore new path if target changed - this shouldn't happen but?
            if (this.currentTargetLayerInterfaceP eq this.waypointPathRunnable.getTargetLayer()) {
                this.associatedAdvancedRTSGameLayer.waypoint2LogHelperP.setTargetPathIgnoreNewPath(this.associatedAdvancedRTSGameLayer, this)
                this.insertWaypoint(0, this.currentTargetLayerInterfaceP)
                this.setRandomGeographicMapCellHistory(this.waypointPathsListP)
            }
        }
    }

    override def setGeographicMapCellHistoryPath(geographicMapCellPositionBasicArrayList : BasicArrayList) : Unit = {
        this.setCurrentPathGeographicMapCellPosition(SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION)
        this.nextUnvisitedPathGeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
        super.setGeographicMapCellHistoryPath(geographicMapCellPositionBasicArrayList)
    }

    private def processWaypoint() : Unit = {
        val size : Int = this.targetList.size()
        if (size > 0) {
            val targetLayer : AdvancedRTSGameLayer = this.targetList.get(0).asInstanceOf[AdvancedRTSGameLayer]
            this.associatedAdvancedRTSGameLayer.waypoint2LogHelperP.processWaypoint(this.associatedAdvancedRTSGameLayer, this, targetLayer, size)
            // If waypoint was destroyed
            if (targetLayer.isDestroyed()) {
                this.associatedAdvancedRTSGameLayer.getCaptionAnimationHelper().update(this.unitWaypointStrings.WAYPOINT_DESTROYED_SHORT, this.basicColorFactory.YELLOW)
                this.removeWaypoint(targetLayer, this.unitWaypointStrings.WAYPOINT_DESTROYED)
            } else {
                val geographicMapCellPosition : GeographicMapCellPosition = this.associatedAdvancedRTSGameLayer.getCurrentGeographicMapCellPosition()
                if (this.isTrackingWaypoint()) {
                    this.associatedAdvancedRTSGameLayer.waypoint2LogHelperP.processWaypointTracked(this.associatedAdvancedRTSGameLayer, this)
                    if (this.visitIfAtMidPoint(geographicMapCellPosition)) {
                        this.associatedAdvancedRTSGameLayer.waypoint2LogHelperP.processWaypointTrackedVisit(this.associatedAdvancedRTSGameLayer, geographicMapCellPosition)
                    }
                    if (this.currentGeographicMapCellHistoryP.isAllVisited2() && (this.currentTargetLayerInterfaceP ne CollidableDestroyableDamageableLayer.getNullInstance())) {
                        val oldWaypointLayer : AdvancedRTSGameLayer = this.currentTargetLayerInterfaceP.asInstanceOf[AdvancedRTSGameLayer]
                        // Get next waypoint if any
                        oldWaypointLayer.getWaypointBehavior().getWaypoint().visit(this.associatedAdvancedRTSGameLayer)
                        this.associatedAdvancedRTSGameLayer.getCaptionAnimationHelper().update(this.unitWaypointStrings.ALL_VISITED_SHORT, this.basicColorFactory.GREEN)
                        this.removeWaypoint(this.currentTargetLayerInterfaceP.asInstanceOf[AdvancedRTSGameLayer], this.unitWaypointStrings.ALL_VISITED)
                    }
                } else if ((this.currentTargetLayerInterfaceP == null) || this.waypointOverridesAttacking) {
                    val list : BasicArrayList = targetLayer.getWaypointBehavior().getWaypoint().getPathsListFromCacheOnly(geographicMapCellPosition)
                    //"waypointPathsList2: " + list, this);
                    this.setWaypointPathsList(list)
                    if (this.waypointPathsListP == null) {
                        this.waitingOnWaypointPath = true
                        this.associatedAdvancedRTSGameLayer.getCaptionAnimationHelper().update(this.unitWaypointStrings.THINKING, this.basicColorFactory.GREEN)
                        this.runWaypointPathTask(targetLayer)
                        return
                    }
                    //geographicMapCellPosition);
                    this.setWaypointPath(targetLayer)
                }
            }
        }
    }

    private def wander() : Unit = {
        if (this.currentGeographicMapCellHistoryP.isAllVisited2()) {
            this.associatedAdvancedRTSGameLayer.waypoint2LogHelperP.wander(this.associatedAdvancedRTSGameLayer)
            this.associatedAdvancedRTSGameLayer.getCaptionAnimationHelper().update(this.unitWaypointStrings.WANDERING, this.basicColorFactory.RED)
            this.wanderPathsList.clear()
            this.wanderPathsList.add(this.associatedAdvancedRTSGameLayer.getSurroundingGeographicMapCellPositionList())
            this.setRandomGeographicMapCellHistory(this.wanderPathsList)
        }
        this.visitIfAtMidPoint(this.getCurrentPathGeographicMapCellPosition())
        this.updateCurrentPathGeographicMapCellPosition()
        this.associatedAdvancedRTSGameLayer.trackTo(this.unitWaypointStrings.NEXT_PATH_NODE)
    }

    private def visitIfAtMidPoint(geographicMapCellPosition : GeographicMapCellPosition) : Boolean = {
        val unitLayer : UnitLayer = this.associatedAdvancedRTSGameLayer
        if ((geographicMapCellPosition ne SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) && (this.nextUnvisitedPathGeographicMapCellPosition eq geographicMapCellPosition)) {
            val point : GPoint = geographicMapCellPosition.getMidPoint()
            val afterNextPoint : GPoint = this.afterNextUnvisitedPathGeographicMapCellPosition.getMidPoint()
            var beyondMidPoint : Boolean = true
            if (geographicMapCellPosition.getColumn() == this.afterNextUnvisitedPathGeographicMapCellPosition.getColumn()) {
            } else if (point.getX() < afterNextPoint.getX()) {
                if ((unitLayer.getXP() + unitLayer.getHalfWidth()) < point.getX()) {
                    beyondMidPoint = false
                }
            } else {
                if ((unitLayer.getXP() + unitLayer.getHalfWidth()) > point.getX()) {
                    beyondMidPoint = false
                }
            }
            if (geographicMapCellPosition.getRow() == this.afterNextUnvisitedPathGeographicMapCellPosition.getRow()) {
            } else if (point.getY() < afterNextPoint.getY()) {
                if ((unitLayer.getYP() + unitLayer.getHalfHeight()) < point.getY()) {
                    beyondMidPoint = false
                }
            } else {
                if ((unitLayer.getYP() + unitLayer.getHalfHeight()) > point.getY()) {
                    beyondMidPoint = false
                }
            }
            if (beyondMidPoint) {
                return this.currentGeographicMapCellHistoryP.visit(geographicMapCellPosition)
            }
        }
        return false
    }

    /*      * private void processMidWaypoints() throws Exception {      * this.geographicMapCellPositionArea.update();      *       * BasicArrayList occupyingList =this.geographicMapCellPositionArea.      * getOccupyingGeographicMapCellPositionList();      *       * GeographicMapCellPosition geographicMapCellPosition =      * (GeographicMapCellPosition) occupyingList.get(0);      *       * if (DropCellPositionHistory.getInstance().isCellPositionWithDrop(      * geographicMapCellPosition)) { //Add Waypoint to empty position      * BasicArrayList surroundingGeographicMapCellPositionList =      * CellPositionUtil.getAllSurrounding( this.geographicMapInterface,      * this      * .geographicMapCellPositionArea.getOccupyingGeographicMapCellPositionList      * (), midWaypointlist);      *       * if(surroundingGeographicMapCellPositionList.size() > 0) {      * GeographicMapCellPosition emptyGeographicMapCellPosition =      * (GeographicMapCellPosition)      * surroundingGeographicMapCellPositionList.get(0);      *       * this.logUtil.putF( "Inserting Waypoint: " +      * emptyGeographicMapCellPosition, this, "processMidWaypoint");      *       * GPoint point = emptyGeographicMapCellPosition.getPoint();      *       * this.OUT_OF_BUILDING_WAYPOINT.setPosition( point.getX().intValue(),      * point.getY().intValue());      *       * this.getPathIdList().add(0, this.OUT_OF_BUILDING_WAYPOINT); } else {      * //This is very bad. Stuck in a building how?      * LogUtil.put(LogFactory.getInstance      * ("Should Not Happen unless buildings get bigger", this,      * "processMidWaypoint")); } } else if (this.isMoving) { int angle =      * this.getRotationAnimationInterface().getAngleInfoP().getAngle();      *       * //goingTowardsGeographicMapCellPosition      * //DropCellPositionHistory.getInstance().isCellPositionWithDrop(      * //goingTowardsGeographicMapCellPosition) //Add Waypoint to get around      * building //this.getWaypointList().add(); } }      */
    private def processTargetList() : Unit = {
        this.targetWithoutCachedPathLayerInterface = CollidableDestroyableDamageableLayer.getNullInstance()

        {
            var index : Int = this.getPossibleTargetList().size() - 1
            while (index >= 0) {
                val layerInterface : AdvancedRTSGameLayer = this.getPossibleTargetList().get(index).asInstanceOf[AdvancedRTSGameLayer]
                //Remove Destroyed targets
                if (layerInterface.isDestroyed()) {
                    this.getPossibleTargetList().remove(layerInterface)
                } else {
                    this.onEnemyMovement(layerInterface)
                }
                index -= 1
            }
        }
        if (this.targetWithoutCachedPathLayerInterface ne CollidableDestroyableDamageableLayer.getNullInstance()) {
            this.waitingOnTargetPath = true
            this.associatedAdvancedRTSGameLayer.getCaptionAnimationHelper().update(this.unitWaypointStrings.THINKING_ABOUT_TARGET, this.basicColorFactory.GREEN)
            //TWBAdvancedRTSGameLayer
            this.runWaypointPathTask(this.currentTargetLayerInterfaceP.asInstanceOf[AdvancedRTSGameLayer])
        }
        this.getPossibleTargetList().clear()
    }

    private def processTargeting() : Unit = {
        if ((this.currentTargetLayerInterfaceP ne CollidableDestroyableDamageableLayer.getNullInstance()) && (this.isInSensorRange(this.currentTargetLayerInterfaceP, this.getCurrentTargetDistance()) || this.isTrackingWaypoint())) {
            /*             if(this.getOwnerAdvancedRTSGameLayer().isSelected())             {                 this.logUtil.putF(this.commonStrings.START, this, "selected: processTargeting");             }             */
            if (this.currentTargetLayerInterfaceP.isDestroyed()) {
                this.associatedAdvancedRTSGameLayer.waypoint2LogHelperP.targetDestroyed(this.associatedAdvancedRTSGameLayer)
                this.associatedAdvancedRTSGameLayer.getCaptionAnimationHelper().update(this.unitWaypointStrings.KILL, this.basicColorFactory.ORANGE)
                this.clearTarget()
                return
            }
            //int dy = getOwnerAdvancedRTSGameLayer().getY() - this.currentTargetLayerInterface.getYP();
            var dx : Int = 0
            var dy : Int = 0
            if (this.isTrackingWaypoint()) {
                this.updateCurrentPathGeographicMapCellPosition()
                val point : GPoint = this.nextUnvisitedPathGeographicMapCellPosition.getMidPoint()
                dx = (this.associatedAdvancedRTSGameLayer.getXP() + this.associatedAdvancedRTSGameLayer.getHalfWidth()) - point.getX()
                dy = (this.associatedAdvancedRTSGameLayer.getYP() + this.associatedAdvancedRTSGameLayer.getHalfHeight()) - point.getY()
                this.associatedAdvancedRTSGameLayer.waypoint2LogHelperP.processTargeting(this.associatedAdvancedRTSGameLayer, dx, dy)
            } else {
                this.associatedAdvancedRTSGameLayer.waypoint2LogHelperP.processTargetingNonWayPoint(this.associatedAdvancedRTSGameLayer, dx, dy)
                dx = (this.associatedAdvancedRTSGameLayer.getXP() + this.associatedAdvancedRTSGameLayer.getHalfWidth()) - (this.currentTargetLayerInterfaceP.getXP() + this.currentTargetLayerInterfaceP.getHalfWidth())
                dy = (this.associatedAdvancedRTSGameLayer.getYP() + this.associatedAdvancedRTSGameLayer.getHalfHeight()) - (this.currentTargetLayerInterfaceP.getYP() + this.currentTargetLayerInterfaceP.getHalfHeight())
            }
            this.associatedAdvancedRTSGameLayer.trackToDXY(dx, dy)
        } else {
            // If owner is dead then track and move
            if (this.associatedAdvancedRTSGameLayer.getParentLayer().isDestroyed()) {
                this.wander()
            } else {
                if (this.associatedAdvancedRTSGameLayer.showMoreCaptionStates) {
                    this.associatedAdvancedRTSGameLayer.getCaptionAnimationHelper().update(this.unitWaypointStrings.STOP, this.basicColorFactory.YELLOW)
                }
                this.associatedAdvancedRTSGameLayer.allStop()
            }
        }
    }

    private def updateCurrentPathGeographicMapCellPosition() : Unit = {
        this.setLastPathGeographicMapCellPosition(this.getCurrentPathGeographicMapCellPosition())
        this.setCurrentPathGeographicMapCellPosition(this.nextUnvisitedPathGeographicMapCellPosition)
        this.nextUnvisitedPathGeographicMapCellPosition = this.currentGeographicMapCellHistoryP.getFirstUnvisited()
        this.afterNextUnvisitedPathGeographicMapCellPosition = this.currentGeographicMapCellHistoryP.getAfterIfNotLast(this.nextUnvisitedPathGeographicMapCellPosition)
        if (this.getCurrentPathGeographicMapCellPosition() ne this.nextUnvisitedPathGeographicMapCellPosition) {
            this.progressTimeDelayHelper.setStartTimeTNT()
        }
    }

    private def setWaypointPath(waypointLayer : AdvancedRTSGameLayer) : Unit = {
        if (this.waypointPathsListP.size() != 0) {
            this.setCurrentTargetLayerInterface(waypointLayer)
            val MAX : Int = Integer.MAX_VALUE
            this.setCurrentTargetDistance(MAX)
            this.setRandomGeographicMapCellHistory(this.waypointPathsListP)
        } else {
            // Get next waypoint
            waypointLayer.getWaypointBehavior().getWaypoint().visit(this.associatedAdvancedRTSGameLayer)
            this.associatedAdvancedRTSGameLayer.getCaptionAnimationHelper().update(this.unitWaypointStrings.ALREADY_THERE_SHORT, this.basicColorFactory.YELLOW)
            this.removeWaypoint(waypointLayer, this.unitWaypointStrings.ALREADY_THERE)
        }
    }

    private def runWaypointPathTask(waypointLayer : AdvancedRTSGameLayer) : Unit = {
        this.setWaypointPathsList(UnitWaypointBehavior2.runningWaypointPathList)
        if (this.waypointPathRunnable.isRunning()) {
            throw new Exception("Should never be running here")
        }
        this.waypointPathRunnable.setRunning(true)
        this.waypointPathRunnable.setUnitLayer(this.associatedAdvancedRTSGameLayer)
        this.waypointPathRunnable.setTargetLayer(waypointLayer)
        this.pathFindingThreadPool.runTask(this.waypointPathRunnable)
    }

    private def removeWaypoint(waypointLayer : RTSLayer, reason : String) : Unit = {
        this.associatedAdvancedRTSGameLayer.waypoint2LogHelperP.removeWaypoint(this.associatedAdvancedRTSGameLayer, this, waypointLayer, reason)
        this.targetList.remove(waypointLayer)
        this.associatedAdvancedRTSGameLayer.waypoint2LogHelperP.removeWaypointList(this.associatedAdvancedRTSGameLayer, this, this.targetList)
        if (this.currentTargetLayerInterfaceP eq waypointLayer) {
            this.associatedAdvancedRTSGameLayer.waypoint2LogHelperP.removeWaypointClear(this.associatedAdvancedRTSGameLayer)
            this.clearTarget()
        }
    }

    override def clearTarget() : Unit = {
        this.associatedAdvancedRTSGameLayer.waypoint2LogHelperP.clearTarget(this.associatedAdvancedRTSGameLayer)
        //this.waypointPathsList = BasicArrayListUtil.getImmutableInstance();
        this.setCurrentTargetLayerInterface(CollidableDestroyableDamageableLayer.getNullInstance())
        this.setTrackingWaypoint(false)
        val MAX : Int = Integer.MAX_VALUE
        this.setCurrentTargetDistance(MAX)
        TrackingEventHandler.getInstance().fireEvent(this.associatedAdvancedRTSGameLayer.getTrackingEvent())
    }

    //Only public for logging
    override def isWaypointListEmptyOrOnlyTargets() : Boolean = {
        val list : BasicArrayList = this.targetList
        if (list.size() == 0) {
            //this.logUtil.putF("No Waypoints", this, "isWaypointListEmptyOrOnlyTargets");
            return true
        }

        {
            var index : Int = list.size() - 1
            while (index >= 0) {
                val layerInterface : AdvancedRTSGameLayer = list.get(index).asInstanceOf[AdvancedRTSGameLayer]
                if (layerInterface.isWaypointListEmptyOrOnlyTargets()) {
                    return false
                }
                index -= 1
            }
        }
        //this.logUtil.putF("All Waypoints Targets/Units", this, "isWaypointListEmptyOrOnlyTargets");
        return true
    }

    private def isCloseRange(layerInterface : AdvancedRTSGameLayer, targetDistance : Int) : Boolean = {
        return targetDistance < (this.closeRange + layerInterface.getHalfHeight())
    }

    override def isInSensorRange(layerInterface : CollidableDestroyableDamageableLayer, targetDistance : Int) : Boolean = {
        return targetDistance < (this.sensorRange + layerInterface.getHalfHeight())
    }

    override def getCurrentTargetingStateString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        if (this.currentTargetLayerInterfaceP ne CollidableDestroyableDamageableLayer.getNullInstance()) {
            stringBuffer.append(UnitWaypointBehavior2.TARGET_LAYER)
            stringBuffer.append(this.commonSeps.SPACE)
            stringBuffer.append(this.currentTargetLayerInterfaceP.getName())
            stringBuffer.append(" with ")
            stringBuffer.append(UnitWaypointBehavior2.TARGET_DISTANCE)
            stringBuffer.append(this.commonSeps.SPACE)
            stringBuffer.appendint(this.getCurrentTargetDistance())
        }
        return stringBuffer.toString()
    }

    override def addWaypointFromUser(advancedRTSGameLayer : AdvancedRTSGameLayer) : Unit = {
        if (advancedRTSGameLayer.isDestroyed()) {
            throw new Exception("Trying to add a dead: " + advancedRTSGameLayer)
        }
        this.associatedAdvancedRTSGameLayer.waypoint2LogHelperP.addWaypointFromUser(this.associatedAdvancedRTSGameLayer, advancedRTSGameLayer)
        // clear waypoints and use player created waypoint
        this.targetList.clear()
        this.targetList.add(advancedRTSGameLayer)
        // must be reassigned to building to follow buildings order/waypoint
        this.clearTarget()
    }

    class BuildingSteeringVisitor extends SteeringVisitor {

        private[BuildingSteeringVisitor] val positionList : BasicArrayList = new BasicArrayListD()

        override def visit(anyType : Object) : Object = {
            val logUtil : LogUtil = LogUtil.getInstance()
            try {
                if (this.getList().size() > 0) {
                    //logUtil.putF("steering", this, "visit");
                    val allbinaryLayer : AllBinaryLayer = this.getList().get(0).asInstanceOf[AllBinaryLayer]
                    val cellPosition : GeographicMapCellPosition = this.getPositionList().get(0).asInstanceOf[GeographicMapCellPosition]
                    val clear : Boolean = UnitWaypointBehavior2.this.buildingChase(allbinaryLayer, cellPosition)
                    if (clear) {
                        this.getList().clear()
                        this.positionList.clear()
                        return NullUtil.getInstance().NULL_OBJECT
                    }
                    return BooleanFactory.getInstance().FALSE
                }
                return NullUtil.getInstance().NULL_OBJECT
            } catch {
                case e : Exception => {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    logUtil.put(commonStrings.EXCEPTION, this, "visit", e)
                    return NullUtil.getInstance().NULL_OBJECT
                }
            }
            throw new IllegalStateException()
        }

        def getPositionList() : BasicArrayList = {
            return this.positionList
        }

    }

    override def addBuildingChase(allbinaryLayer : AllBinaryLayer, cellPosition : GeographicMapCellPosition) : Unit = {
        //chase mode
        if (!this.buildingSteeringVisitor.getList().contains(allbinaryLayer)) {
            this.buildingSteeringVisitor.getList().add(allbinaryLayer)
            this.buildingSteeringVisitor.getPositionList().add(cellPosition)
        }
        if (!this.getSteeringVisitorList().contains(this.buildingSteeringVisitor)) {
            this.getSteeringVisitorList().add(this.buildingSteeringVisitor)
        }
    }

    //Follow building wall
    private def buildingChase(allbinaryLayer : AllBinaryLayer, cellPosition : GeographicMapCellPosition) : Boolean = {
        return this.associatedAdvancedRTSGameLayer.buildingChase(allbinaryLayer, cellPosition)
    }

}

object UnitWaypointBehavior2 {
    private val runningWaypointPathList : BasicArrayList = new BasicArrayListD()

    private val TARGET_DISTANCE : String = "Target Distance"

    private val TARGET_LAYER : String = "Target Layer"

}


