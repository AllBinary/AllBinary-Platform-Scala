/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *  * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *  * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *  * Created By: Travis Berthelot  *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.waypoint

import _root_.org.allbinary.game.layer.PathFindingLayerInterface
import _root_.org.allbinary.game.layer.WaypointBehaviorBase
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.math.PositionStrings
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author User  */
class Waypoint2SelectedLogHelper extends Waypoint2LogHelper {
    import _root_.org.allbinary.game.layer.waypoint.Waypoint2SelectedLogHelper.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //private final CommonStrings commonStrings = CommonStrings.getInstance();
    private val commonSeps : CommonSeps = CommonSeps.getInstance()

    private val positionStrings : PositionStrings = PositionStrings.getInstance()

    private val stringUtil : StringUtil = StringUtil.getInstance()

    private val ENEMY_POSSIBLE_TARGET : String = " Enemy Possible Target: "

    private val CLOSE_RANGE : String = "closeRange: "

    private val SENSOR_RANGE : String = " sensorRange: "

    private val ONLY_TARGETS : String = " Only Targets: "

    private val SHORTER_THAN_CURRENT_TARGET_DISTANCE : String = " isShorterThanCurrentTargetDistance: "

    private val CURRENT_TARGET_DESTROYED : String = " isCurrentTargetDestroyed: "

    private val CURRENT_TARGET_NOT_AVAILABLE : String = " isCurrentTargetNotAvailable: "

    private val PROCESS_POSSIBLE_TARGET : String = "selected: processPossibleTarget1"

    override def initRange(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, closeRange : Int, sensorRange : Int) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        stringBuffer.append(this.CLOSE_RANGE)
        stringBuffer.appendint(closeRange)
        stringBuffer.append(this.SENSOR_RANGE)
        stringBuffer.appendint(sensorRange)
        this.logUtil.putF(stringBuffer.toString(), this, "selected: initRange")
    }

    override def processPossibleTarget(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, waypointBehaviorBase : WaypointBehaviorBase, layerInterface : PathFindingLayerInterface, anotherTargetDistance : Int, isShorterThanCurrentTargetDistance : Boolean, isCurrentTargetDestroyed : Boolean) : Unit = {
        if (waypointBehaviorBase.isWaypointListEmptyOrOnlyTargets() && waypointBehaviorBase.isInSensorRange(layerInterface.asInstanceOf[CollidableDestroyableDamageableLayer], anotherTargetDistance)) {
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
            stringBuffer.append(this.ONLY_TARGETS)
            stringBuffer.appendboolean(waypointBehaviorBase.isWaypointListEmptyOrOnlyTargets())
            stringBuffer.append(this.SHORTER_THAN_CURRENT_TARGET_DISTANCE)
            stringBuffer.appendboolean(isShorterThanCurrentTargetDistance)
            stringBuffer.append(this.CURRENT_TARGET_DESTROYED)
            stringBuffer.appendboolean(isCurrentTargetDestroyed)
            stringBuffer.append(this.CURRENT_TARGET_NOT_AVAILABLE)
            stringBuffer.appendboolean((waypointBehaviorBase.getCurrentTargetLayerInterface() == null))
            this.logUtil.putF(stringBuffer.toString(), this, this.PROCESS_POSSIBLE_TARGET)
        }
    }

    override def processSetTarget(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, waypointBehaviorBase : WaypointBehaviorBase, layerInterface : PathFindingLayerInterface, anotherTargetDistance : Int) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(waypointBehaviorBase.getCurrentTargetingStateString())
        stringBuffer.append(this.ENEMY_POSSIBLE_TARGET)
        stringBuffer.append(layerInterface.getName())
        stringBuffer.append(" anotherTargetDistance: ")
        stringBuffer.appendint(anotherTargetDistance)
        this.logUtil.putF(stringBuffer.toString(), this, "selected: processPossibleTarget2")
    }

    override def processPossibleTargetCloser(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, waypointBehaviorBase : WaypointBehaviorBase, layerInterface : PathFindingLayerInterface, anotherTargetDistance : Int) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(waypointBehaviorBase.getCurrentTargetingStateString())
        stringBuffer.append(this.ENEMY_POSSIBLE_TARGET)
        stringBuffer.append(layerInterface.getName())
        stringBuffer.append(" anotherTargetDistance: ")
        stringBuffer.appendint(anotherTargetDistance)
        this.logUtil.putF(stringBuffer.toString(), this, "selected: processPossibleTarget3")
    }

    override def setTarget(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, waypointBehaviorBase : WaypointBehaviorBase, layerInterface : PathFindingLayerInterface, anotherTargetDistance : Int) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(waypointBehaviorBase.getName())
        stringBuffer.append(" targeting: ")
        stringBuffer.append(layerInterface.getName())
        stringBuffer.append(" at: ")
        stringBuffer.appendint(anotherTargetDistance)
        stringBuffer.append(" instead of: ")
        stringBuffer.append(waypointBehaviorBase.getCurrentTargetingStateString())
        this.logUtil.putF(stringBuffer.toString(), this, "selected: setTarget")
    }

    override def setTargetPath(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF("Target Destroyed", this, "selected: setTargetPath")
    }

    override def setTargetPathIgnoreNewPath(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, waypointBehaviorBase : WaypointBehaviorBase) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        stringBuffer.append(" Set Path To Target: ")
        stringBuffer.append(waypointBehaviorBase.getCurrentTargetLayerInterface().getName())
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(this.stringUtil.toString(waypointBehaviorBase.getCurrentTargetLayerInterface()))
        this.logUtil.putF(stringBuffer.toString(), this, "selected: setTargetPath")
    }

    override def processWaypoint(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, waypointBehaviorBase : WaypointBehaviorBase, targetLayer : PathFindingLayerInterface, size : Int) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        stringBuffer.append(" Size: ")
        stringBuffer.appendint(size)
        stringBuffer.append(" Waypoint: ")
        stringBuffer.append(targetLayer.getName())
        stringBuffer.append(" Target: ")
        stringBuffer.append(this.stringUtil.toString(waypointBehaviorBase.getCurrentTargetLayerInterface()))
        stringBuffer.append(" isTrackingWaypoint: ")
        stringBuffer.appendboolean(waypointBehaviorBase.isTrackingWaypoint())
        stringBuffer.append(" WaypointOverridesAttacking: ")
        stringBuffer.appendboolean(waypointBehaviorBase.isWaypointOverridesAttacking())
        this.logUtil.putF(stringBuffer.toString(), this, "selected: processWaypoint")
    }

    override def processWaypointTracked(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, waypointBehaviorBase : WaypointBehaviorBase) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        stringBuffer.append(" currentPathGeographicMapCellPosition: ")
        stringBuffer.append(this.stringUtil.toString(waypointBehaviorBase.getCurrentPathGeographicMapCellPosition()))
        stringBuffer.append(" nextUnvisitedPathGeographicMapCellPosition: ")
        stringBuffer.append(this.stringUtil.toString(waypointBehaviorBase.getNextUnvisitedPathGeographicMapCellPosition()))
        stringBuffer.append(" Tracked: ")
        stringBuffer.append(this.stringUtil.toString(waypointBehaviorBase.getCurrentGeographicMapCellHistory().getTracked()))
        this.logUtil.putF(stringBuffer.toString(), this, "selected: processWaypoint")
    }

    override def processWaypointTrackedVisit(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, geographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        stringBuffer.append(" Visited: ")
        stringBuffer.append(this.stringUtil.toString(geographicMapCellPosition))
        this.logUtil.putF(stringBuffer.toString(), this, "selected: processWaypoint")
    }

    override def processWaypointTrackedWithoutProgress(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, reason : String) : Unit = {
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(reason).toString(), this, "turnTo")
    }

    override def wander(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(associatedAdvancedRTSGameLayer.getName(), this, "wander")
    }

    override def targetDestroyed(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(" Target Destroyed").toString(), this, "selected: processTargeting")
    }

    override def processTargeting(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, dx : Int, dy : Int) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(this.positionStrings.DX_LABEL)
        stringBuffer.appendint(dx)
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(this.positionStrings.DY_LABEL)
        stringBuffer.appendint(dy)
        this.logUtil.putF(stringBuffer.toString(), this, "selected: processTargeting")
    }

    override def processTargetingNonWayPoint(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, dx : Int, dy : Int) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        stringBuffer.append(" Targeting Non Waypoint ")
        stringBuffer.append(this.positionStrings.DX_LABEL)
        stringBuffer.appendint(dx)
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(this.positionStrings.DY_LABEL)
        stringBuffer.appendint(dy)
        this.logUtil.putF(stringBuffer.toString(), this, "selected: processTargeting")
    }

    override def removeWaypoint(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, unitWaypointBehavior2 : WaypointBehaviorBase, waypointLayer : PathFindingLayerInterface, reason : String) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(unitWaypointBehavior2.getName())
        stringBuffer.append(" remove: ")
        stringBuffer.append(waypointLayer.getName())
        stringBuffer.append(" because: ")
        stringBuffer.append(reason)
        this.logUtil.putF(stringBuffer.toString(), this, "selected: removeWaypoint")
    }

    override def removeWaypointList(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, unitWaypointBehavior2 : WaypointBehaviorBase, list : BasicArrayList) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(unitWaypointBehavior2.getName())
        stringBuffer.append(" Waypoints: ")
        stringBuffer.append(this.stringUtil.toString(list))
        this.logUtil.putF(stringBuffer.toString(), this, "selected: removeWaypoint")
    }

    override def removeWaypointClear(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(" Clearing removed waypoint").toString(), this, "selected: removeWaypoint")
    }

    override def clearTarget(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(" Cleared Target").toString(), this, "selected: clearTarget")
    }

    override def addWaypointFromUser(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, advancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        //            stringBuffer.append(associatedAdvancedRTSGameLayer.isSelected());
        stringBuffer.append(" Adding Waypoint to Selected: ")
        stringBuffer.append(advancedRTSGameLayer.getName())
        if (advancedRTSGameLayer.getParentLayer() != null) {
            stringBuffer.append(" With Parent: ")
            stringBuffer.append(advancedRTSGameLayer.getParentLayer().getName())
        }
        this.logUtil.putF(stringBuffer.toString(), this, "selected: onWaypointEvent")
    }

    override def targetMovedSoRetarget(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(" - target moved so retargeting").toString(), this, "turnTo")
    }

}

object Waypoint2SelectedLogHelper {
    private val instanceC : Waypoint2SelectedLogHelper = new Waypoint2SelectedLogHelper()

    /**      * @return the instance      */
    def getInstance() : Waypoint2LogHelper = {
        return Waypoint2SelectedLogHelper.instanceC
    }

}


