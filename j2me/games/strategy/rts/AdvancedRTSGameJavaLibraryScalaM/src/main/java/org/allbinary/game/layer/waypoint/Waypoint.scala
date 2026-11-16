/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.waypoint

import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.game.layer.PathFindingLayerInterface
import _root_.org.allbinary.game.layer.RTSLayerEvent
import _root_.org.allbinary.game.layer.building.event.BuildingEventListenerInterface
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.game.layer.unit.UnitWaypointBehavior
import _root_.org.allbinary.game.media.graphics.geography.map.racetrack.PathFindingInfoFactory
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.media.audio.Sound
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellTypeFactory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCompositeInterface
import _root_.org.allbinary.media.graphics.geography.map.racetrack.CustomMapGenerator
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGeographicMap
import _root_.org.allbinary.media.graphics.geography.pathfinding.BasicGeographicMapExtractedPathsCacheFactory
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingInfo
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathGenerator
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListUtil

/**  *  * @author user  */
class Waypoint(param_ownerLayer : PathFindingLayerInterface, param_sound : Sound) extends WaypointBase(param_sound) with BuildingEventListenerInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val basicArrayListUtil : BasicArrayListUtil = BasicArrayListUtil.getInstance()

    var ownerLayer : PathFindingLayerInterface = null

    private var endList : BasicArrayList = this.basicArrayListUtil.getImmutableInstance()

    private var paths : Array[Array[BasicArrayList]] = this.basicArrayListUtil.NULL_ARRAY_OF_ARRAY

    //, BasicArrayList endList
    //Constructor
    {
        val ownerLayer : PathFindingLayerInterface = param_ownerLayer
        val sound : Sound = param_sound
        this.ownerLayer = ownerLayer
    }

    override def setAllBinaryGameLayerManager(allBinaryGameLayerManager : AllBinaryGameLayerManager) : Unit = {
        super.setAllBinaryGameLayerManager(allBinaryGameLayerManager)
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = allBinaryGameLayerManager.asInstanceOf[GeographicMapCompositeInterface]
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        val tiledLayer : AllBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer()
        if (this.paths ne this.basicArrayListUtil.NULL_ARRAY_OF_ARRAY) {
            throw new RuntimeException()
        }
        this.endList = this.ownerLayer.getEndGeographicMapCellPositionList()
        this.paths = Array.ofDim[BasicArrayList](tiledLayer.getColumns(), tiledLayer.getRows())
        this.clearPaths()
    }

    def releaseCachedPaths() : Unit = {

        {
            var columnIndex : Int = this.paths.length
            while ({ columnIndex -= 1; columnIndex } >= 0) {

                {
                    var rowIndex : Int = this.paths.length
                    while ({ rowIndex -= 1; rowIndex } >= 0) {
                        val pathsList : BasicArrayList = this.paths(columnIndex)(rowIndex)
                        if (pathsList ne this.basicArrayListUtil.getImmutableInstance()) {
                            BasicGeographicMapExtractedPathsCacheFactory.getInstance().release(pathsList)
                        }
                    }
                }
            }
        }
    }

    override def getPathsListFromCacheOnly(geographicMapCellPosition : GeographicMapCellPosition) : BasicArrayList = {
        return this.paths(geographicMapCellPosition.getColumn())(geographicMapCellPosition.getRow())
    }

    override def getPathsListRunnable(geographicMapCellPosition : GeographicMapCellPosition) : BasicArrayList = {
        var pathsList : BasicArrayList = this.paths(geographicMapCellPosition.getColumn())(geographicMapCellPosition.getRow())
        if (pathsList eq this.basicArrayListUtil.getImmutableInstance()) {
            pathsList = this.createPaths(geographicMapCellPosition)
            this.paths(geographicMapCellPosition.getColumn())(geographicMapCellPosition.getRow()) = pathsList
        }
        return pathsList
    }

    /*     private BasicArrayList createPaths(GeographicMapCellPosition geographicMapCellPosition)     throws Exception     {     BasicArrayList pathsList = new BasicArrayListD();      BasicArrayList pathList = new BasicArrayListD();      GeographicMapCellPosition endGeographicMapCellPosition =     (GeographicMapCellPosition)     this.geographicMapCellPositionArea.getOccupyingGeographicMapCellPositionList().get(0);      pathList.add(geographicMapCellPosition);     pathList.add(endGeographicMapCellPosition);      pathsList.add(pathList);      return pathsList;     }      */
    def getEndGeographicMapCellPosition(startGeographicMapCellPosition : GeographicMapCellPosition) : GeographicMapCellPosition = {
        var endGeographicMapCellPosition : GeographicMapCellPosition = this.basicArrayListUtil.getRandom(this.endList).asInstanceOf[GeographicMapCellPosition]
        if (startGeographicMapCellPosition eq endGeographicMapCellPosition) {

            {
                var index : Int = this.endList.size() - 1
                scala.util.boundary { (break_N78642 : scala.util.boundary.Label[Unit]) ?=>
                    while (index >= 0) {
                        endGeographicMapCellPosition = this.endList.get(index).asInstanceOf[GeographicMapCellPosition]
                        if (startGeographicMapCellPosition ne endGeographicMapCellPosition) {
                            scala.util.boundary.break()(using break_N78642)
                        }
                        index -= 1
                    }
                }
            }
        }
        return endGeographicMapCellPosition
    }

    private def createPaths(startGeographicMapCellPosition : GeographicMapCellPosition) : BasicArrayList = {
        if (this.endList.size() == 0) {
            //return new BasicArrayListD();
            return this.basicArrayListUtil.getImmutableInstance()
        }
        val endGeographicMapCellPosition : GeographicMapCellPosition = this.getEndGeographicMapCellPosition(startGeographicMapCellPosition)
        if (endGeographicMapCellPosition == null) {
            //return new BasicArrayListD();
            return this.basicArrayListUtil.getImmutableInstance()
        }
        //Most likely not a building
        if (startGeographicMapCellPosition eq endGeographicMapCellPosition) {
            if (this.ownerLayer.shouldHandleStartSameAsEnd()) {
                //return new BasicArrayListD();
                return this.basicArrayListUtil.getImmutableInstance()
            } else {
                throw new Exception("Start should not be End: " + this.endList.size())
            }
        }
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = this.allBinaryGameLayerManagerP.asInstanceOf[GeographicMapCompositeInterface]
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        val raceTrackGeographicMap : RaceTrackGeographicMap = geographicMapInterface.asInstanceOf[RaceTrackGeographicMap]
        val raceTrackGeographicMapCellTypeFactory : GeographicMapCellTypeFactory = raceTrackGeographicMap.getGeographicMapCellTypeFactory()
        //Copy mapArray into graphArray - Note: mapArray may not contain start and end nodes
        val customMapGenerator : CustomMapGenerator = raceTrackGeographicMap.getCustomMapGenerator().asInstanceOf[CustomMapGenerator]
        customMapGenerator.copyMapIntoCustomMap()
        val customMapArray : Array[Array[Int]] = customMapGenerator.getCustomMapArray()
        //  customMapArray[endGeographicMapCellPosition.getRow()][endGeographicMapCellPosition.getColumn()];
        customMapArray(startGeographicMapCellPosition.getRow())(startGeographicMapCellPosition.getColumn()) = raceTrackGeographicMapCellTypeFactory.getStartType()
        customMapArray(endGeographicMapCellPosition.getRow())(endGeographicMapCellPosition.getColumn()) = raceTrackGeographicMapCellTypeFactory.getEndType()
        val pathFindingInfo : PathFindingInfo = PathFindingInfoFactory.getInstance().getInstancePathFindingInfo(raceTrackGeographicMap, customMapArray)
        //this.logUtil.putF("geographicMapInterface.getGeographicMapCellTypeFactory().toString(): " + geographicMapInterface.getGeographicMapCellTypeFactory().toString(), this, "createPaths");
        val list : BasicArrayList = PathGenerator.getInstance().getInstanceNoCache(geographicMapInterface, pathFindingInfo, 2)
        //Temporary debugging for clearing caching
        if (list.size() < 1) {
            throw new Exception("Path may have been cleared by clearing caching")
        }
        return list
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    //Clear path cache
    override def onBuildingEvent(event : RTSLayerEvent) : Unit = {
        //Remove offending paths from cache
        this.clearPaths()
    }

    private def clearPaths() : Unit = {

        {
            var columnIndex : Int = this.paths.length
            while ({ columnIndex -= 1; columnIndex } >= 0) {

                {
                    var rowIndex : Int = this.paths.length
                    while ({ rowIndex -= 1; rowIndex } >= 0) {
                        this.paths(columnIndex)(rowIndex) = this.basicArrayListUtil.getImmutableInstance()
                    }
                }
            }
        }
    }

    override def reset() : Unit = {
        this.getConnectedWaypointList().clear()
        this.releaseCachedPaths()
    }

    override def visit(unitLayer : PathFindingLayerInterface) : Unit = {
        //Only visit waypoint if in same group
        if (unitLayer.getGroupInterface()(0) != this.ownerLayer.getGroupInterface()(0)) {
            return
        }
        val size : Int = this.getConnectedWaypointList().size()
        if (size > 0) {
            val unitWaypointBehavior : UnitWaypointBehavior = unitLayer.getWaypointBehavior().asInstanceOf[UnitWaypointBehavior]

            {
                scala.util.boundary { (break_N80783 : scala.util.boundary.Label[Unit]) ?=>
                    while (this.getConnectedWaypointList().size() > 0) {
                        val rtsLayer : CollidableDestroyableDamageableLayer = this.getConnectedWaypointList().get(0).asInstanceOf[CollidableDestroyableDamageableLayer]
                        if (rtsLayer.isDestroyed()) {
                            this.getConnectedWaypointList().remove(rtsLayer)
                        } else {
                            //{
                            unitLayer.handleCost(this.ownerLayer)
                            //this.logUtil.putF("Sending: " + unitLayer.getName(), this, "visit");
                            unitWaypointBehavior.insertWaypoint(0, rtsLayer)
                            scala.util.boundary.break()(using break_N80783)
                        }
                    }
                }
            }
        }
    }

}


