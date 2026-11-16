/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.media.graphics.geography.map.racetrack

import _root_.org.jgrapht.GraphPath
import _root_.org.jgrapht.graph.SimpleWeightedGraph
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFinderGraphVisitorBase
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingNode
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author user  */
class BasePathFinderGraphVisitor[V, E](param_geographicMapInterface : BasicGeographicMap, param_edgeMinimum : Int, param_minPathWeight : Int, param_maxPathWeight : Int) extends PathFinderGraphVisitorBase {

    var geographicMapInterface : BasicGeographicMap = null

    var edgeMinimum : Int = 0

    //10
    var minPathWeight : Int = 0

    //8
    var maxPathWeight : Int = 0

    //100000
    //Constructor
    {
        val geographicMapInterface : BasicGeographicMap = param_geographicMapInterface
        val edgeMinimum : Int = param_edgeMinimum
        val minPathWeight : Int = param_minPathWeight
        val maxPathWeight : Int = param_maxPathWeight
        this.geographicMapInterface = geographicMapInterface
        this.edgeMinimum = edgeMinimum
        this.minPathWeight = minPathWeight
        this.maxPathWeight = maxPathWeight
    }

    def visit(graph : SimpleWeightedGraph, startPathFindingNodeList : BasicArrayList, endPathFindingNodeList : BasicArrayList) : Unit = {
    }

    override def fixPath(startPathFindingNodeList : BasicArrayList, endPathFindingNodeList : BasicArrayList, pathList : BasicArrayList) : Unit = {

        {
            var index : Int = startPathFindingNodeList.size() - 1
            while (index >= 0) {
                var startPathFindingNode : PathFindingNode = startPathFindingNodeList.get(index).asInstanceOf[PathFindingNode]
                pathList.remove(startPathFindingNode.geographicMapCellPosition)
                pathList.addAt(0, startPathFindingNode.geographicMapCellPosition)
                index -= 1
            }
        }
    }

    def isValid(graphPath : GraphPath) : Boolean = {
        if (((graphPath.getEdgeList().size() > this.edgeMinimum) && (graphPath.getWeight() < this.maxPathWeight)) && (graphPath.getWeight() > this.minPathWeight)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def getInvalidReason(graphPath : GraphPath) : String = {
        val stringBuffer : StringMaker = new StringMaker()
        if (graphPath.getEdgeList().size() < this.edgeMinimum) {
            stringBuffer.append("Ignoring Small: " + graphPath.getEdgeList().size())
        }
        if (graphPath.getWeight() <= this.minPathWeight) {
            stringBuffer.append(" Low Weighted Path: " + graphPath.getWeight())
        }
        if (graphPath.getWeight() >= this.maxPathWeight) {
            stringBuffer.append(" To High Weighted Path: " + graphPath.getWeight())
        }
        return stringBuffer.toString()
    }

}


