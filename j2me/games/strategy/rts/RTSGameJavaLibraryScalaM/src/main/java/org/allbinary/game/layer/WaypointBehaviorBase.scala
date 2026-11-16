/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.game.layer.waypoint.WaypointBase
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.game.tick.TickableInterface
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellHistory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.util.BasicArrayListS

class WaypointBehaviorBase() extends TickableInterface {

    private var ownedWaypointList : BasicArrayList = null

    var waypointOverridesAttacking : Boolean = true

    private var waypoint : WaypointBase = WaypointBase.NULL_WAYPOINT_BASE

    //If colliding with a game object then don't try to turn since in steering mode
    private val steeringVisitorList : BasicArrayList = new BasicArrayListD()

    //Constructor
    {
        //TWB - Currently 0ne but should change if that increases
        this.ownedWaypointList = new BasicArrayListS(1)
    }

    override def getName() : String = {
        return this.getClass().getName()
    }

    def isRunning() : Boolean = {
        return false
    }

    override def processTick(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
    }

    /**      * @return the ownedWaypointList      */
    def getOwnedWaypointList() : BasicArrayList = {
        return this.ownedWaypointList
    }

    /**      * @return the waypoint      */
    def getWaypoint() : WaypointBase = {
        return this.waypoint
    }

    /**      * @param waypoint the waypoint to set      */
    def setWaypoint(waypoint : WaypointBase) : Unit = {
        this.waypoint = waypoint
    }

    def getSteeringVisitorList() : BasicArrayList = {
        return this.steeringVisitorList
    }

    def getMovementLogicAsString() : String = {
        throw new RuntimeException()
    }

    def isWaypointListEmptyOrOnlyTargets() : Boolean = {
        throw new RuntimeException()
    }

    def isInSensorRange(layerInterface : CollidableDestroyableDamageableLayer, targetDistance : Int) : Boolean = {
        throw new RuntimeException()
    }

    def getCurrentTargetLayerInterface() : CollidableDestroyableDamageableLayer = {
        throw new RuntimeException()
    }

    def getCurrentTargetingStateString() : String = {
        throw new RuntimeException()
    }

    def isTrackingWaypoint() : Boolean = {
        throw new RuntimeException()
    }

    def getCurrentPathGeographicMapCellPosition() : GeographicMapCellPosition = {
        throw new RuntimeException()
    }

    def getCurrentGeographicMapCellHistory() : GeographicMapCellHistory = {
        throw new RuntimeException()
    }

    def isWaypointOverridesAttacking() : Boolean = {
        return this.waypointOverridesAttacking
    }

    def getNextUnvisitedPathGeographicMapCellPosition() : GeographicMapCellPosition = {
        throw new RuntimeException()
    }

    def needToMove() : Boolean = {
        throw new RuntimeException()
    }

    def setWaypointPathsList(waypointPathsList : BasicArrayList) : Unit = {
        throw new RuntimeException()
    }

    def getWaypointPathsList() : BasicArrayList = {
        throw new RuntimeException()
    }

    def setTarget(layerInterface : PathFindingLayerInterface) : Unit = {
        throw new RuntimeException()
    }

    def setTargetWithDistance(layerInterface : PathFindingLayerInterface, anotherTargetDistance : Int) : Unit = {
        throw new RuntimeException()
    }

    def clearTarget() : Unit = {
        throw new RuntimeException()
    }

    def updatePathOnTargetMove(reason : String) : Unit = {
    }

}


