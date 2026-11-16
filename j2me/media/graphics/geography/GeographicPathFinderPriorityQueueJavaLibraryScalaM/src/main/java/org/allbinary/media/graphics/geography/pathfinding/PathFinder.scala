/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.pathfinding

import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.math.MathUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMapCellPositionFactory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGeographicMapCellType
import _root_.org.allbinary.util.ABHashSet
import _root_.org.allbinary.util.ABPriorityQueue
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.util.BasicArrayListUtil

class PathFinder extends GeographicPathFinderBase {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val basicArrayListUtil : BasicArrayListUtil = BasicArrayListUtil.getInstance()

    private val mathUtil : MathUtil = MathUtil.getInstance()

    private val openPriorityQueue : ABPriorityQueue[PathFindingNodeCost] = new ABPriorityQueue[PathFindingNodeCost]()

    private val closedSet : ABHashSet[PathFindingNodeCost] = new ABHashSet[PathFindingNodeCost]()

    //BasicGeographicMap
    private var geographicMapInterface : Object = NullUtil.getInstance().NULL_OBJECT

    private var costArray : Array[Array[PathFindingNodeCost]] = PathFindingNodeCost.NULL_PATH_FINDING_NODE_COST_ARRAY_ARRAY

    def init(geographicMapInterface : BasicGeographicMap) : Unit = {
        this.geographicMapInterface = geographicMapInterface
        val tiledLayer : AllBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer()
        this.costArray = Array.ofDim[PathFindingNodeCost](tiledLayer.getColumns(), tiledLayer.getRows())
        val basicGeographicMapCellPositionFactory : BasicGeographicMapCellPositionFactory = geographicMapInterface.getGeographicMapCellPositionFactory()
        var node : PathFindingNodeCost = null
        val sizeX : Int = this.costArray.length
        val sizeY : Int = this.costArray(0).length

        {
            var column : Int = 0
            while (column < sizeX) {

                {
                    var row : Int = 0
                    while (row < sizeY) {
                        val geographicMapCellType : GeographicMapCellType = geographicMapInterface.getCellTypeAt(basicGeographicMapCellPositionFactory.getAt(column, row))
                        val raceTrackGeographicMapCellType : RaceTrackGeographicMapCellType = geographicMapCellType.asInstanceOf[RaceTrackGeographicMapCellType]
                        node = new PathFindingNodeCost(NullUtil.getInstance().NULL_OBJECT, basicGeographicMapCellPositionFactory.getAt(column, row), new PathFindingNodeCostInfo(raceTrackGeographicMapCellType.getTravelCost().toLong, (-1).toLong))
                        this.costArray(column)(row) = node
                        row += 1
                    }
                }
                column += 1
            }
        }
    }

    override def searchTotalPath(startPathFindingNodeList : BasicArrayList, endPathFindingNodeList : BasicArrayList, totalPaths : Int) : BasicArrayList = {
        try {
            return this.search(startPathFindingNodeList.get(0).asInstanceOf[PathFindingNode], endPathFindingNodeList.get(0).asInstanceOf[PathFindingNode])
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, "search", e)
                return this.basicArrayListUtil.getImmutableInstance()
            }
        }
        throw new IllegalStateException()
    }

    override def searchTotalPathN(startPathFindingNodeList : BasicArrayList, endPathFindingNodeList : BasicArrayList, totalPaths : Int, multipassState : MultipassState) : BasicArrayList = {
        if (multipassState.step == 0) {
            multipassState.step += 1
        } else if (multipassState.step == 1) {
            //this.logUtil.putF(new StringMaker().append("step 1: ").append(multipassState.iteration).toString(), this, "search");
            this.searchStart(startPathFindingNodeList.get(0).asInstanceOf[PathFindingNode], endPathFindingNodeList.get(0).asInstanceOf[PathFindingNode], multipassState)
        } else if (multipassState.step == 2) {
            //this.logUtil.putF("step 2", this, "search");
            return this.searchN(startPathFindingNodeList.get(0).asInstanceOf[PathFindingNode], endPathFindingNodeList.get(0).asInstanceOf[PathFindingNode], multipassState)
        }
        return this.basicArrayListUtil.getImmutableInstance()
    }

    def search(startPathFindingNode : PathFindingNode, endPathFindingNode : PathFindingNode) : BasicArrayList = {
        val list : BasicArrayList = this.findPath(startPathFindingNode.geographicMapCellPosition, endPathFindingNode.geographicMapCellPosition)
        //        }
        val pathList : BasicArrayList = new BasicArrayListD()
        pathList.add(list)
        //this.logUtil.putF(new StringMaker().append("finish A* ").append(list.size()).append(CommonSeps.getInstance().SPACE).append(pathList.size()).append(CommonSeps.getInstance().SPACE).append(list.toString()).toString(), this, "search");
        return pathList
    }

    def searchStart(startPathFindingNode : PathFindingNode, endPathFindingNode : PathFindingNode, multipassState : MultipassState) : Unit = {
        this.findPathStart(startPathFindingNode.geographicMapCellPosition, endPathFindingNode.geographicMapCellPosition, multipassState)
    }

    def searchN(startPathFindingNode : PathFindingNode, endPathFindingNode : PathFindingNode, multipassState : MultipassState) : BasicArrayList = {
        val list : BasicArrayList = this.findPathEnd(startPathFindingNode.geographicMapCellPosition, endPathFindingNode.geographicMapCellPosition, multipassState)
        if (list == null) {
            return this.basicArrayListUtil.getImmutableInstance()
        }
        val pathList : BasicArrayList = new BasicArrayListD()
        pathList.add(list)
        //this.logUtil.putF(new StringMaker().append("finish A* ").append(list.size()).append(CommonSeps.getInstance().SPACE).append(pathList.size()).append(CommonSeps.getInstance().SPACE).append(list.toString()).toString(), this, "search");
        multipassState.iteration = 0
        multipassState.step = 0
        return pathList
    }

    def findPath(start : GeographicMapCellPosition, target : GeographicMapCellPosition) : BasicArrayList = {
        this.openPriorityQueue.clear()
        this.closedSet.clear()
        var discoveryCalculation : Long = 0L
        var node : PathFindingNodeCost = null
        val targetColumn : Int = target.getColumn()
        val targetRow : Int = target.getRow()
        val sizeX : Int = this.costArray.length
        val sizeY : Int = this.costArray(0).length

        {
            var column : Int = 0
            while (column < sizeX) {

                {
                    var row : Int = 0
                    while (row < sizeY) {
                        discoveryCalculation = this.mathUtil.abs(column - targetColumn).toLong + this.mathUtil.abs(row - targetRow)
                        node = this.costArray(column)(row)
                        node.pathFindingNodeCostInfoP.totalCostP = 0
                        node.pathFindingNodeCostInfoP.costToEndP = discoveryCalculation
                        row += 1
                    }
                }
                column += 1
            }
        }
        val startNode : PathFindingNodeCost = this.costArray(start.getColumn())(start.getRow())
        this.openPriorityQueue.add(startNode)
        val geographicMapInterface : BasicGeographicMap = this.geographicMapInterface.asInstanceOf[BasicGeographicMap]
        val basicGeographicMapCellPositionFactory : BasicGeographicMapCellPositionFactory = geographicMapInterface.getGeographicMapCellPositionFactory()
        val allBinaryTiledLayer : AllBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer()
        val targetNode : PathFindingNodeCost = this.costArray(target.getColumn())(target.getRow())
        var current : PathFindingNodeCost = null

        {
            while ({
                current = this.openPriorityQueue.poll()
                this.closedSet.add(current)
                if (current.equals(targetNode)) {
                    return this.extractPath(start, current)
                }
                var neighbor : PathFindingNodeCost = null
                var neighborInfo : PathFindingNodeCostInfo = null
                var calculatedCost : Long = 0L

                {
                    var column : Int = current.geographicMapCellPosition.getColumn() - 1
                    while (column < (current.geographicMapCellPosition.getColumn() + 2)) {

                        {
                            var row : Int = current.geographicMapCellPosition.getRow() - 1
                            while (row < (current.geographicMapCellPosition.getRow() + 2)) {
                                scala.util.boundary { (continue_N74562 : scala.util.boundary.Label[Unit]) ?=>
                                    if (((((column > 0) && (row > 0)) && (column < allBinaryTiledLayer.getColumns())) && (row < allBinaryTiledLayer.getRows())) && geographicMapInterface.isOnMap(basicGeographicMapCellPositionFactory.getAt(column, row))) {
                                        neighbor = this.costArray(column)(row)
                                        if (this.closedSet.contains(neighbor)) {
                                            scala.util.boundary.break()(using continue_N74562)
                                        }
                                        neighborInfo = neighbor.pathFindingNodeCostInfoP
                                        calculatedCost = (neighborInfo.costToEndP + neighborInfo.costFromStartP) + current.pathFindingNodeCostInfoP.totalCostP
                                        if ((calculatedCost < neighborInfo.totalCostP) || !this.openPriorityQueue.contains(neighbor)) {
                                            neighborInfo.totalCostP = calculatedCost
                                            neighbor.parent = current
                                            if (!this.openPriorityQueue.contains(neighbor)) {
                                                if (geographicMapInterface.isOfFourDirections(current.geographicMapCellPosition, neighbor.geographicMapCellPosition)) {
                                                    this.openPriorityQueue.add(neighbor)
                                                }
                                            }
                                        }
                                    }
                                }
                                row += 1
                            }
                        }
                        column += 1
                    }
                }
                !this.openPriorityQueue.isEmpty()
            }) ()
        }
        //return new BasicArrayListD()add(start);
        throw new RuntimeException()
    }

    def findPathStart(start : GeographicMapCellPosition, target : GeographicMapCellPosition, multipassState : MultipassState) : Unit = {
        this.openPriorityQueue.clear()
        this.closedSet.clear()
        var discoveryCalculation : Long = 0L
        var node : PathFindingNodeCost = null
        val targetColumn : Int = target.getColumn()
        val targetRow : Int = target.getRow()
        val sizeX : Int = this.costArray.length
        val sizeY : Int = this.costArray(0).length
        //multipassState.iteration

        {
            var column : Int = 0
            while (column < sizeX) {

                {
                    var row : Int = 0
                    while (row < sizeY) {
                        discoveryCalculation = this.mathUtil.abs(column - targetColumn).toLong + this.mathUtil.abs(row - targetRow)
                        node = this.costArray(column)(row)
                        node.pathFindingNodeCostInfoP.totalCostP = 0
                        node.pathFindingNodeCostInfoP.costToEndP = discoveryCalculation
                        row += 1
                    }
                }
                column += 1
            }
        }
        val startNode : PathFindingNodeCost = this.costArray(start.getColumn())(start.getRow())
        this.openPriorityQueue.add(startNode)
        //multipassState.iteration = 0;
        multipassState.step += 1
    }

    def findPathEnd(start : GeographicMapCellPosition, target : GeographicMapCellPosition, multipassState : MultipassState) : BasicArrayList = {
        val geographicMapInterface : BasicGeographicMap = this.geographicMapInterface.asInstanceOf[BasicGeographicMap]
        val basicGeographicMapCellPositionFactory : BasicGeographicMapCellPositionFactory = geographicMapInterface.getGeographicMapCellPositionFactory()
        val allBinaryTiledLayer : AllBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer()
        val targetNode : PathFindingNodeCost = this.costArray(target.getColumn())(target.getRow())
        var current : PathFindingNodeCost = null
        var total : Int = 0

        {
            while ({
                current = this.openPriorityQueue.poll()
                this.closedSet.add(current)
                if (current.equals(targetNode)) {
                    return this.extractPath(start, current)
                }
                var neighbor : PathFindingNodeCost = null
                var neighborInfo : PathFindingNodeCostInfo = null
                var calculatedCost : Long = 0L

                {
                    var column : Int = current.geographicMapCellPosition.getColumn() - 1
                    while (column < (current.geographicMapCellPosition.getColumn() + 2)) {

                        {
                            var row : Int = current.geographicMapCellPosition.getRow() - 1
                            while (row < (current.geographicMapCellPosition.getRow() + 2)) {
                                scala.util.boundary { (continue_N77108 : scala.util.boundary.Label[Unit]) ?=>
                                    if (((((column > 0) && (row > 0)) && (column < allBinaryTiledLayer.getColumns())) && (row < allBinaryTiledLayer.getRows())) && geographicMapInterface.isOnMap(basicGeographicMapCellPositionFactory.getAt(column, row))) {
                                        neighbor = this.costArray(column)(row)
                                        if (this.closedSet.contains(neighbor)) {
                                            scala.util.boundary.break()(using continue_N77108)
                                        }
                                        neighborInfo = neighbor.pathFindingNodeCostInfoP
                                        calculatedCost = (neighborInfo.costToEndP + neighborInfo.costFromStartP) + current.pathFindingNodeCostInfoP.totalCostP
                                        if ((calculatedCost < neighborInfo.totalCostP) || !this.openPriorityQueue.contains(neighbor)) {
                                            neighborInfo.totalCostP = calculatedCost
                                            neighbor.parent = current
                                            if (!this.openPriorityQueue.contains(neighbor)) {
                                                if (geographicMapInterface.isOfFourDirections(current.geographicMapCellPosition, neighbor.geographicMapCellPosition)) {
                                                    this.openPriorityQueue.add(neighbor)
                                                }
                                            }
                                        }
                                    }
                                }
                                row += 1
                            }
                        }
                        column += 1
                    }
                }
                total += 1
                if (total > 10) {
                    return this.basicArrayListUtil.getImmutableInstance()
                }
                !this.openPriorityQueue.isEmpty()
            }) ()
        }
        //return new BasicArrayListD()add(start);
        throw new RuntimeException()
    }

    private def extractPath(start : GeographicMapCellPosition, param_current : PathFindingNodeCost) : BasicArrayList = {
        var current : PathFindingNodeCost = param_current
        val path : BasicArrayList = new BasicArrayListD()

        {
            while (current.parent ne NullUtil.getInstance().NULL_OBJECT) {
                path.add(current.geographicMapCellPosition)
                current = current.parent.asInstanceOf[PathFindingNodeCost]
            }
        }
        path.add(start)
        this.basicArrayListUtil.reverse(path)
        return path
    }

}


