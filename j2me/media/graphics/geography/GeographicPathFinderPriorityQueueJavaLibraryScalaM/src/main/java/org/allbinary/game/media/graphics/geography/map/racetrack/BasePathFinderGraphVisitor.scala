/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.media.graphics.geography.map.racetrack

import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFinderGraphVisitorBase
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingNode
import _root_.org.allbinary.util.BasicArrayList

//1.4.2
class BasePathFinderGraphVisitor(param_geographicMapInterface : BasicGeographicMap, param_edgeMinimum : Int, param_minPathWeight : Int, param_maxPathWeight : Int) extends PathFinderGraphVisitorBase {

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

    override def visit(graph : Object, startPathFindingNodeList : BasicArrayList, endPathFindingNodeList : BasicArrayList) : Unit = {
    }

    override def fixPath(startPathFindingNodeList : BasicArrayList, endPathFindingNodeList : BasicArrayList, pathList : BasicArrayList) : Unit = {
        var startPathFindingNode : PathFindingNode = null

        {
            var index : Int = startPathFindingNodeList.size() - 1
            while (index >= 0) {
                startPathFindingNode = startPathFindingNodeList.get(index).asInstanceOf[PathFindingNode]
                pathList.remove(startPathFindingNode.geographicMapCellPosition)
                pathList.addAt(0, startPathFindingNode.geographicMapCellPosition)
                index -= 1
            }
        }
    }

    override def isValid(graphPath : Object) : Boolean = {
        return false
    }

    override def getInvalidReason(graphPath : Object) : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

}


