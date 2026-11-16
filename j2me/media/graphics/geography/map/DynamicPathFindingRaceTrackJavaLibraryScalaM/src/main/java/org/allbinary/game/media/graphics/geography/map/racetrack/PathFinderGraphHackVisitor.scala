/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.media.graphics.geography.map.racetrack

import _root_.org.jgrapht.GraphPath
import _root_.org.jgrapht.graph.DefaultWeightedEdge
import _root_.org.jgrapht.graph.SimpleWeightedGraph
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.graphics.CellPosition
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMapCellPositionFactory
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMapUtil
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGeographicMap
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingNode

/**  *  * @author user  */
class PathFinderGraphHackVisitor[V, E](param_geographicMapInterface : BasicGeographicMap, param_edgeMinimum : Int, param_minPathWeight : Int, param_maxPathWeight : Int) extends BasePathFinderGraphVisitor[V, E](param_geographicMapInterface, param_edgeMinimum, param_minPathWeight, param_maxPathWeight) {

    val logUtil : LogUtil = LogUtil.getInstance()

    //RaceTrackGeographicMap raceTrackGeographicMap
    //Constructor
    {
        val geographicMapInterface : BasicGeographicMap = param_geographicMapInterface
        val edgeMinimum : Int = param_edgeMinimum
        val minPathWeight : Int = param_minPathWeight
        val maxPathWeight : Int = param_maxPathWeight
    }

    override def visit(graph : SimpleWeightedGraph, startPathFindingNodeList : BasicArrayList, endPathFindingNodeList : BasicArrayList) : Unit = {
        this.fixStart(graph, startPathFindingNodeList)
        this.fixEnd(graph, endPathFindingNodeList)
        this.fixOverPassEdges(graph)
    }

    private def fixStart(graph : SimpleWeightedGraph[CellPosition, DefaultWeightedEdge], startPathFindingNodeList : BasicArrayList) : Unit = {
        var geographicMapCellPositionFactory : BasicGeographicMapCellPositionFactory = this.geographicMapInterface.getGeographicMapCellPositionFactory()
        var tiledLayer : AllBinaryTiledLayer = this.geographicMapInterface.getAllBinaryTiledLayer()

        {
            var index : Int = startPathFindingNodeList.size() - 1
            while (index >= 0) {
                var startPathFindingNode : PathFindingNode = startPathFindingNodeList.get(index).asInstanceOf[PathFindingNode]
                var geographicMapCellPosition : GeographicMapCellPosition = startPathFindingNode.geographicMapCellPosition
                var column : Int = geographicMapCellPosition.getColumn()
                var row : Int = geographicMapCellPosition.getRow()
                //If going beyond the tile layer then it is not a closed loop
                var nextRow : Int = row + 1
                if (tiledLayer.isOnTileLayer(column, nextRow)) {
                    var geographicMapCellPositionNeighbor : GeographicMapCellPosition = geographicMapCellPositionFactory.getAt(column, nextRow)
                    //this.logUtil.putF("geographicMapCellPositionNeighbor: " + geographicMapCellPositionNeighbor.toString() , this, "fixStart");
                    graph.removeEdge(geographicMapCellPosition, geographicMapCellPositionNeighbor)
                }
                index -= 1
            }
        }
    }

    private def fixEnd(graph : SimpleWeightedGraph[CellPosition, DefaultWeightedEdge], endPathFindingNodeList : BasicArrayList) : Unit = {
        var geographicMapCellPositionFactory : BasicGeographicMapCellPositionFactory = this.geographicMapInterface.getGeographicMapCellPositionFactory()
        var tiledLayer : AllBinaryTiledLayer = this.geographicMapInterface.getAllBinaryTiledLayer()

        {
            var index : Int = endPathFindingNodeList.size() - 1
            while (index >= 0) {
                var endPathFindingNode : PathFindingNode = endPathFindingNodeList.get(index).asInstanceOf[PathFindingNode]
                var geographicMapCellPosition : GeographicMapCellPosition = endPathFindingNode.geographicMapCellPosition
                graph.addVertex(geographicMapCellPosition)
                var column : Int = geographicMapCellPosition.getColumn()
                var row : Int = geographicMapCellPosition.getRow()
                //If going beyond the tile layer then it is not a closed loop
                var nextRow : Int = row + 1
                if (tiledLayer.isOnTileLayer(column, nextRow)) {
                    var geographicMapCellPositionNeighbor : GeographicMapCellPosition = geographicMapCellPositionFactory.getAt(column, nextRow)
                    graph.addEdge(geographicMapCellPosition, geographicMapCellPositionNeighbor)
                }
                index -= 1
            }
        }
    }

    private def fixOverPassEdges(graph : SimpleWeightedGraph[CellPosition, DefaultWeightedEdge]) : Unit = {
        var geographicMapCellPositionFactory : BasicGeographicMapCellPositionFactory = this.geographicMapInterface.getGeographicMapCellPositionFactory()
        var raceTrackGeographicMap : RaceTrackGeographicMap = this.geographicMapInterface.asInstanceOf[RaceTrackGeographicMap]
        //Add Over Passes
        var CellPositionArray : Array[CellPosition] = raceTrackGeographicMap.getRaceTrackData().getOverPassGeographicMapCellPositionArray()

        {
            var index : Int = CellPositionArray.length - 1
            while (index >= 0) {
                var overPassGeographicMapCellPosition : CellPosition = CellPositionArray(index)
                this.logUtil.putF((("Fixing Over Pass: " + overPassGeographicMapCellPosition.getColumn()) + ", ") + overPassGeographicMapCellPosition.getRow(), this, "fixOverPassEdges")
                var underPassGeographicMapCellPosition : GeographicMapCellPosition = geographicMapCellPositionFactory.getAt(overPassGeographicMapCellPosition.getColumn(), overPassGeographicMapCellPosition.getRow())
                var rightUnderPassGeographicMapCellPosition : GeographicMapCellPosition = geographicMapCellPositionFactory.getAt(overPassGeographicMapCellPosition.getColumn() + 1, overPassGeographicMapCellPosition.getRow())
                var leftUnderPassGeographicMapCellPosition : GeographicMapCellPosition = geographicMapCellPositionFactory.getAt(overPassGeographicMapCellPosition.getColumn() - 1, overPassGeographicMapCellPosition.getRow())
                //Remove under pass cross connections
                graph.removeEdge(underPassGeographicMapCellPosition, rightUnderPassGeographicMapCellPosition)
                graph.removeEdge(underPassGeographicMapCellPosition, leftUnderPassGeographicMapCellPosition)
                graph.addVertex(overPassGeographicMapCellPosition)
                graph.addEdge(overPassGeographicMapCellPosition, rightUnderPassGeographicMapCellPosition)
                graph.addEdge(overPassGeographicMapCellPosition, leftUnderPassGeographicMapCellPosition)
                index -= 1
            }
        }
    }

    override def fixPath(startPathFindingNodeList : BasicArrayList, endPathFindingNodeList : BasicArrayList, pathList : BasicArrayList) : Unit = {
        //this.logUtil.putF("Path: " + pathList, this, "fixPath");

        {
            var index : Int = startPathFindingNodeList.size() - 1
            while (index >= 0) {
                var endPathFindingNode : PathFindingNode = endPathFindingNodeList.get(index).asInstanceOf[PathFindingNode]
                var startPathFindingNode : PathFindingNode = startPathFindingNodeList.get(index).asInstanceOf[PathFindingNode]
                //Fix Start/End Hack
                if (BasicGeographicMapUtil.getInstance().isSameCellPosition(startPathFindingNode.geographicMapCellPosition, endPathFindingNode.geographicMapCellPosition)) {
                    if (pathList.remove(endPathFindingNode.geographicMapCellPosition)) {
                        pathList.remove(startPathFindingNode.geographicMapCellPosition)
                        pathList.addAt(0, startPathFindingNode.geographicMapCellPosition)
                    }
                }
                index -= 1
            }
        }
        this.removeOverPassEdges(pathList)
    }

    //Fix Over pass Hack
    private def removeOverPassEdges(pathList : BasicArrayList) : Unit = {
        var geographicMapCellPositionFactory : BasicGeographicMapCellPositionFactory = this.geographicMapInterface.getGeographicMapCellPositionFactory()
        var raceTrackGeographicMap : RaceTrackGeographicMap = this.geographicMapInterface.asInstanceOf[RaceTrackGeographicMap]
        var CellPositionArray : Array[CellPosition] = raceTrackGeographicMap.getRaceTrackData().getOverPassGeographicMapCellPositionArray()

        {
            var index : Int = CellPositionArray.length - 1
            while (index >= 0) {
                var overPassGeographicMapCellPosition : CellPosition = CellPositionArray(index)
                var underPassGeographicMapCellPosition : GeographicMapCellPosition = geographicMapCellPositionFactory.getAt(overPassGeographicMapCellPosition.getColumn(), overPassGeographicMapCellPosition.getRow())
                var indexOf : Int = pathList.indexOf(overPassGeographicMapCellPosition)
                if (indexOf != -1) {
                    pathList.set(indexOf, underPassGeographicMapCellPosition)
                }
                index -= 1
            }
        }
    }

    override def isValid(graphPath : GraphPath) : Boolean = {
        if (((graphPath.getEdgeList().size() > edgeMinimum) && (graphPath.getWeight() < maxPathWeight)) && (graphPath.getWeight() > minPathWeight)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

}


