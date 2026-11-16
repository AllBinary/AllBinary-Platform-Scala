/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.waypoint

import _root_.org.allbinary.game.layer.PathFindingLayerInterface
import _root_.org.allbinary.game.layer.WaypointBehaviorBase
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author User  */
class Waypoint2LogHelper {
    import _root_.org.allbinary.game.layer.waypoint.Waypoint2LogHelper.{*}

    def initRange(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, closeRange : Int, sensorRange : Int) : Unit = {
    }

    def processPossibleTarget(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, unitWaypointBehavior2 : WaypointBehaviorBase, layerInterface : PathFindingLayerInterface, anotherTargetDistance : Int, isShorterThanCurrentTargetDistance : Boolean, isCurrentTargetDestroyed : Boolean) : Unit = {
    }

    def processSetTarget(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, unitWaypointBehavior2 : WaypointBehaviorBase, layerInterface : PathFindingLayerInterface, anotherTargetDistance : Int) : Unit = {
    }

    def processPossibleTargetCloser(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, unitWaypointBehavior2 : WaypointBehaviorBase, layerInterface : PathFindingLayerInterface, anotherTargetDistance : Int) : Unit = {
    }

    def setTarget(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, unitWaypointBehavior2 : WaypointBehaviorBase, layerInterface : PathFindingLayerInterface, anotherTargetDistance : Int) : Unit = {
    }

    def setTargetPath(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def setTargetPathIgnoreNewPath(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, unitWaypointBehavior2 : WaypointBehaviorBase) : Unit = {
    }

    def processWaypoint(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, unitWaypointBehavior2 : WaypointBehaviorBase, targetLayer : PathFindingLayerInterface, size : Int) : Unit = {
    }

    def processWaypointTracked(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, unitWaypointBehavior2 : WaypointBehaviorBase) : Unit = {
    }

    def processWaypointTrackedVisit(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, geographicMapCellPosition : GeographicMapCellPosition) : Unit = {
    }

    def processWaypointTrackedWithoutProgress(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, reason : String) : Unit = {
    }

    def wander(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def targetDestroyed(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def processTargeting(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, dx : Int, dy : Int) : Unit = {
    }

    def processTargetingNonWayPoint(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, dx : Int, dy : Int) : Unit = {
    }

    def removeWaypoint(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, unitWaypointBehavior2 : WaypointBehaviorBase, waypointLayer : PathFindingLayerInterface, reason : String) : Unit = {
    }

    def removeWaypointList(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, unitWaypointBehavior2 : WaypointBehaviorBase, list : BasicArrayList) : Unit = {
    }

    def removeWaypointClear(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def clearTarget(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def addWaypointFromUser(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, advancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def targetMovedSoRetarget(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

}

object Waypoint2LogHelper {
    private val instance : Waypoint2LogHelper = new Waypoint2LogHelper()

    /**      * @return the instance      */
    def getInstance() : Waypoint2LogHelper = {
        return Waypoint2LogHelper.instance
    }

}


