/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.waypoint

import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.PathFindingLayerInterface
import _root_.org.allbinary.game.layer.RTSLayerEvent
import _root_.org.allbinary.game.layer.building.event.BuildingEventListenerInterface
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.game.layer.unit.UnitWaypointBehavior
import _root_.org.allbinary.game.media.graphics.geography.map.racetrack.PathFindingInfoFactory
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.media.audio.Sound
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellTypeFactory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCompositeInterface
import _root_.org.allbinary.media.graphics.geography.map.racetrack.CustomMapGenerator
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGeographicMap
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingInfo
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathGenerator
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListUtil

/**  *  * @author user  */
class NoCacheWaypoint(param_ownerLayer : PathFindingLayerInterface, param_sound : Sound) extends WaypointBase(param_sound) with BuildingEventListenerInterface {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    var ownerLayer : PathFindingLayerInterface = null

    //Constructor
    {
        val ownerLayer : PathFindingLayerInterface = param_ownerLayer
        val sound : Sound = param_sound
        this.ownerLayer = ownerLayer
    }

    override def setAllBinaryGameLayerManager(allBinaryGameLayerManager : AllBinaryGameLayerManager) : Unit = {
        super.setAllBinaryGameLayerManager(allBinaryGameLayerManager)
    }

    def releaseCachedPaths() : Unit = {
    }

    override def getPathsListFromCacheOnly(geographicMapCellPosition : GeographicMapCellPosition) : BasicArrayList = {
        return BasicArrayListUtil.getInstance().getImmutableInstance()
    }

    override def getPathsListRunnable(geographicMapCellPosition : GeographicMapCellPosition) : BasicArrayList = {
        return this.createPaths(geographicMapCellPosition)
    }

    def getEndGeographicMapCellPosition(startGeographicMapCellPosition : GeographicMapCellPosition) : GeographicMapCellPosition = {
        val endList : BasicArrayList = this.ownerLayer.getEndGeographicMapCellPositionList()
        //this.logUtil.putF(new StringMaker().append(this.ownerLayer.getName()).append(" c: ").append(this.ownerLayer.getCurrentGeographicMapCellPosition()).append(CommonSeps.getInstance().SPACE).append(this.ownerLayer.getTopLeftGeographicMapCellPosition()).append(" endList: ").append(endList).toString(), this, "visit");
        var endGeographicMapCellPosition : GeographicMapCellPosition = BasicArrayListUtil.getInstance().getRandom(endList).asInstanceOf[GeographicMapCellPosition]
        if (startGeographicMapCellPosition eq endGeographicMapCellPosition) {

            {
                var index : Int = endList.size() - 1
                scala.util.boundary { (break_N77085 : scala.util.boundary.Label[Unit]) ?=>
                    while (index >= 0) {
                        endGeographicMapCellPosition = endList.get(index).asInstanceOf[GeographicMapCellPosition]
                        if (startGeographicMapCellPosition ne endGeographicMapCellPosition) {
                            scala.util.boundary.break()(using break_N77085)
                        }
                        index -= 1
                    }
                }
            }
        }
        return endGeographicMapCellPosition
    }

    private def createPaths(startGeographicMapCellPosition : GeographicMapCellPosition) : BasicArrayList = {
        //this.logUtil.putF("", this, "createPaths");
        val endGeographicMapCellPosition : GeographicMapCellPosition = this.getEndGeographicMapCellPosition(startGeographicMapCellPosition)
        if (endGeographicMapCellPosition == null) {
            //return new BasicArrayListD();
            return BasicArrayListUtil.getInstance().getImmutableInstance()
        }
        //Most likely not a building
        if (startGeographicMapCellPosition eq endGeographicMapCellPosition) {
            //this.logUtil.putF("", this, "createPaths");
            if (this.ownerLayer.shouldHandleStartSameAsEnd()) {
                //return new BasicArrayListD();
                return BasicArrayListUtil.getInstance().getImmutableInstance()
            } else {
                throw new Exception("Start should not be End: " + endGeographicMapCellPosition)
            }
        }
        //this.logUtil.putF("", this, "createPaths");
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
    }

    override def reset() : Unit = {
        this.getConnectedWaypointList().clear()
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
                scala.util.boundary { (break_N78898 : scala.util.boundary.Label[Unit]) ?=>
                    while (this.getConnectedWaypointList().size() > 0) {
                        val rtsLayer : CollidableDestroyableDamageableLayer = this.getConnectedWaypointList().get(0).asInstanceOf[CollidableDestroyableDamageableLayer]
                        if (rtsLayer.isDestroyed()) {
                            this.getConnectedWaypointList().remove(rtsLayer)
                        } else {
                            //{
                            unitLayer.handleCost(this.ownerLayer)
                            //this.logUtil.putF("Sending: " + unitLayer.getName(), this, "visit");
                            unitWaypointBehavior.insertWaypoint(0, rtsLayer)
                            scala.util.boundary.break()(using break_N78898)
                        }
                    }
                }
            }
        }
    }

}


