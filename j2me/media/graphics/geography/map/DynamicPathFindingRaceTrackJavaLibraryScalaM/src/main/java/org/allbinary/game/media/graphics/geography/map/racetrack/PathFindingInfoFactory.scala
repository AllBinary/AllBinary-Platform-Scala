/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.media.graphics.geography.map.racetrack

import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMapCellPositionFactory
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMapUtil
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellTypeFactory
import _root_.org.allbinary.media.graphics.geography.map.racetrack.BasePathFindingInfoFactory
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGeographicMapCellType
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackRoadsGeographicMapCellHistoryFactory
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingNodeCostInfoFactoryBase
import _root_.org.allbinary.media.graphics.geography.pathfinding.BasicGeographicMapGraph
import _root_.org.allbinary.media.graphics.geography.pathfinding.BasicGeographicMapPathFinder
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFinderGraphVisitorFactoryBase
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingInfo
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingNodeCostInfoFactory
import _root_.org.allbinary.util.BasicArrayListS

/**  *  * @author user  */
class PathFindingInfoFactory private(param_pathFinderGraphVisitorFactoryInterface : PathFinderGraphVisitorFactoryBase, param_max : Int) extends BasePathFindingInfoFactory {
    import _root_.org.allbinary.game.media.graphics.geography.map.racetrack.PathFindingInfoFactory.{*}

    private val MAX_DIRECTIONS : Int = 4

    private var pathFindingInfo : PathFindingInfo = null

    private var basicGeographicMapGraph : BasicGeographicMapGraph = null

    private var basicGeographicMapPathFinder : BasicGeographicMapPathFinder = null

    private var pathFinderGraphVisitorFactoryInterface : PathFinderGraphVisitorFactoryBase = null

    //Constructor
    {
        val pathFinderGraphVisitorFactoryInterface : PathFinderGraphVisitorFactoryBase = param_pathFinderGraphVisitorFactoryInterface
        val max : Int = param_max
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        PreLogUtil.put("Using Dynamic Path Finding", this, commonStrings.GET_INSTANCE)
        this.basicGeographicMapPathFinder = new BasicGeographicMapPathFinder(max)
        this.pathFindingInfo = new PathFindingInfo(new PathFindingNodeCostInfoFactory(max), new BasicArrayListS(1), new BasicArrayListS(1))
        this.basicGeographicMapGraph = new BasicGeographicMapGraph(this.pathFindingInfo.getPathFindingNodeCostInfoFactoryInterface().asInstanceOf[PathFindingNodeCostInfoFactory])
        this.pathFinderGraphVisitorFactoryInterface = pathFinderGraphVisitorFactoryInterface
    }

    override def getInstancePathFindingInfo(geographicMapInterface : BasicGeographicMap, mapArray : Array[Array[Int]]) : PathFindingInfo = {
        //TWB - find a way to cache this PathFindingInfo.
        val pathFindingInfo : PathFindingInfo = new PathFindingInfo(this.pathFindingInfo.getPathFindingNodeCostInfoFactoryInterface(), new BasicArrayListS(1), new BasicArrayListS(1))
        RaceTrackRoadsGeographicMapCellHistoryFactory.getInstance().init()
        this.init(geographicMapInterface, pathFindingInfo, mapArray)
        this.basicGeographicMapPathFinder.init(geographicMapInterface, this.basicGeographicMapGraph, this.pathFinderGraphVisitorFactoryInterface.getInstance(geographicMapInterface))
        pathFindingInfo.setPathFinder(this.basicGeographicMapPathFinder)
        return pathFindingInfo
    }

    // Set Appropriate Terrain and Map
    override def init(geographicMapInterface : BasicGeographicMap, pathFindingInfo : PathFindingInfo, mapArray : Array[Array[Int]]) : Unit = {
        super.init(geographicMapInterface, pathFindingInfo, mapArray)
        //this.logUtil.putF(CommonLabels + allBinaryTiledLayer.getHeight() + commonStrings.SPACE + CommonLabels + width, this, this.commonStrings.INIT);
        this.buildPathFindingNodes(geographicMapInterface, pathFindingInfo, mapArray)
    }

    private def buildPathFindingNodesForCellPosition(geographicMapInterface : BasicGeographicMap, pathFindingInfo : PathFindingInfo, mapArray : Array[Array[Int]], cellPosition : GeographicMapCellPosition) : Unit = {
        val geographicMapCellPositionFactory : BasicGeographicMapCellPositionFactory = geographicMapInterface.getGeographicMapCellPositionFactory()
        val cellTypeId : Int = mapArray(cellPosition.getRow())(cellPosition.getColumn())
        val geographicMapCellType : GeographicMapCellType = GeographicMapCellTypeFactory.getInstance().get(geographicMapInterface.getCellTypeFromMapCellTypeInt(cellTypeId))
        val raceTrackGeographicMapCellType : RaceTrackGeographicMapCellType = geographicMapCellType.asInstanceOf[RaceTrackGeographicMapCellType]
        val allBinaryTiledLayer : AllBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer()
        val pathFindingNodeCostInfoFactoryInterface : PathFindingNodeCostInfoFactoryBase = pathFindingInfo.getPathFindingNodeCostInfoFactoryInterface()
        //{
        val basicGeographicMapUtil : BasicGeographicMapUtil = BasicGeographicMapUtil.getInstance()
        var row : Int = 0
        var column : Int = 0
        var goingToGeographicMapCellPosition : GeographicMapCellPosition = null
        var costFromStart : Int = 0
        var costToEnd : Int = 0

        {
            var index : Int = 0
            while (index < this.MAX_DIRECTIONS) {
                row = basicGeographicMapUtil.getBorderingRow(index, cellPosition)
                column = basicGeographicMapUtil.getBorderingColumn(index, cellPosition)
                // If beyond border
                if ((((row < allBinaryTiledLayer.getRows()) && (column < allBinaryTiledLayer.getColumns())) && (row >= 0)) && (column >= 0)) {
                    goingToGeographicMapCellPosition = geographicMapCellPositionFactory.getAt(column, row)
                    //[goingToGeographicMapCellPosition.getColumn()]);
                    costFromStart = raceTrackGeographicMapCellType.getTravelCost()
                    // nextBorderingRaceGameGeographicMapCellType);
                    costToEnd = costFromStart
                    // extraCost);
                    pathFindingNodeCostInfoFactoryInterface.create(geographicMapInterface, goingToGeographicMapCellPosition, cellPosition, costFromStart, costToEnd)
                }
                index += 1
            }
        }
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
    private var instance : PathFindingInfoFactory = null

    /**      * @return the instance      */
    def getInstance() : PathFindingInfoFactory = {
        return PathFindingInfoFactory.instance
    }

    def initMax(max : Int) : Unit = {
        PathFindingInfoFactory.instance = new PathFindingInfoFactory(new SimplePathFinderGraphVisitorFactory(1, 1, Integer.MAX_VALUE), max)
    }

}


