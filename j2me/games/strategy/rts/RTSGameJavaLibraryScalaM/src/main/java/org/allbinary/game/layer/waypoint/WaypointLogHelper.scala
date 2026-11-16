/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.waypoint

import _root_.org.allbinary.game.layer.PathFindingLayerInterface
import _root_.org.allbinary.game.layer.WaypointBehaviorBase
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author User  */
class WaypointLogHelper {
    import _root_.org.allbinary.game.layer.waypoint.WaypointLogHelper.{*}

    def onWaypointEvent(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, advancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def addWaypointFromBuilding(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, advancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def addWaypointFromBuildingList(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, advancedRTSGameLayer : PathFindingLayerInterface, list : BasicArrayList) : Unit = {
    }

    def insertWaypoint(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, index : Int, rtsLayer : CollidableDestroyableDamageableLayer, waypointName : String) : Unit = {
    }

    def insertWaypointList(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, index : Int, rtsLayer : CollidableDestroyableDamageableLayer, waypointName : String, list : BasicArrayList) : Unit = {
    }

    def setRandomGeographicMapCellHistoryList(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, pathsList : BasicArrayList) : Unit = {
    }

    def moveAwayFromBuilding(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def needToMove(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, unitWaypointBehavior : WaypointBehaviorBase) : Unit = {
    }

    def setRandomGeographicMapCellHistory(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def setCurrentPathGeographicMapCellPosition(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, existingCurrentPathGeographicMapCellPosition : GeographicMapCellPosition, currentPathGeographicMapCellPosition : GeographicMapCellPosition) : Unit = {
    }

    def setNextUnvisitedPathGeographicMapCellPosition(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, existingNextUnvisitedPathGeographicMapCellPosition : GeographicMapCellPosition, nextUnvisitedPathGeographicMapCellPosition : GeographicMapCellPosition) : Unit = {
    }

}

object WaypointLogHelper {
    private val instance : WaypointLogHelper = new WaypointLogHelper()

    /**      * @return the instance      */
    def getInstance() : WaypointLogHelper = {
        return WaypointLogHelper.instance
    }

}


