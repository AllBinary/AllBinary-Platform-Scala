/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.media.graphics.geography.map.racetrack

import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMapCellPositionFactory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.racetrack.BasePathFindingInfoFactory
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackRoadsGeographicMapCellHistoryFactory
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFinder
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingInfo
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingNodeCostInfoFactory
import _root_.org.allbinary.util.BasicArrayListS

//1.4.2
class PathFindingInfoFactory private() extends BasePathFindingInfoFactory {
    import _root_.org.allbinary.game.media.graphics.geography.map.racetrack.PathFindingInfoFactory.{*}

    //private final int MAX_DIRECTIONS = 4;
    private var pathFindingInfo : PathFindingInfo = null

    private var pathFinder : PathFinder = null

    //Constructor
    {
        //PreLogUtil.put("Using Dynamic Path Finding", this, this.commonStrings.GET_INSTANCE);
        this.pathFindingInfo = new PathFindingInfo(new PathFindingNodeCostInfoFactory(PathFindingInfoFactory.MAX), new BasicArrayListS(1), new BasicArrayListS(1))
        this.pathFinder = new PathFinder()
    }

    override def getInstancePathFindingInfo(geographicMapInterface : BasicGeographicMap, mapArray : Array[Array[Int]]) : PathFindingInfo = {
        //TWB - find a way to cache this PathFindingInfo.
        val pathFindingInfo : PathFindingInfo = new PathFindingInfo(this.pathFindingInfo.getPathFindingNodeCostInfoFactoryInterface(), new BasicArrayListS(1), new BasicArrayListS(1))
        RaceTrackRoadsGeographicMapCellHistoryFactory.getInstance().init()
        this.init(geographicMapInterface, pathFindingInfo, mapArray)
        this.pathFinder.init(geographicMapInterface)
        pathFindingInfo.setPathFinder(this.pathFinder)
        return pathFindingInfo
    }

    // Set Appropriate Terrain and Map
    override def init(geographicMapInterface : BasicGeographicMap, pathFindingInfo : PathFindingInfo, mapArray : Array[Array[Int]]) : Unit = {
        super.init(geographicMapInterface, pathFindingInfo, mapArray)
        //this.logUtil.putF(SpacialStrings + allBinaryTiledLayer.getHeight() + commonStrings.SPACE + SpacialStrings + width, this, this.commonStrings.INIT);
        this.buildPathFindingNodes(geographicMapInterface, pathFindingInfo, mapArray)
    }

    private def buildPathFindingNodesForCellPosition(geographicMapInterface : BasicGeographicMap, pathFindingInfo : PathFindingInfo, mapArray : Array[Array[Int]], cellPosition : GeographicMapCellPosition) : Unit = {
    }

    private def buildPathFindingNodes(geographicMapInterface : BasicGeographicMap, pathFindingInfo : PathFindingInfo, mapArray : Array[Array[Int]]) : Unit = {
        //this.logUtil.putF(CommonSeps.getInstance().START, this, "buildPathFindingNode");
        val geographicMapCellPositionFactory : BasicGeographicMapCellPositionFactory = geographicMapInterface.getGeographicMapCellPositionFactory()
        val allBinaryTiledLayer : AllBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer()
        val totalColumns : Int = allBinaryTiledLayer.getColumns()
        val totalRows : Int = allBinaryTiledLayer.getRows()

        {
            var column : Int = 0
            while (column < totalColumns) {

                {
                    var row : Int = 0
                    while (row < totalRows) {
                        this.buildPathFindingNodesForCellPosition(geographicMapInterface, pathFindingInfo, mapArray, geographicMapCellPositionFactory.getAt(column, row))
                        row += 1
                    }
                }
                column += 1
            }
        }
    }

}

object PathFindingInfoFactory {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : PathFindingInfoFactory = new PathFindingInfoFactory()

    /**      * @return the instance      */
    def getInstance() : PathFindingInfoFactory = {
        return PathFindingInfoFactory.instance
    }

    private var MAX : Int = 32768

    def initMax(max : Int) : Unit = {
        PathFindingInfoFactory.MAX = max
    }

}


