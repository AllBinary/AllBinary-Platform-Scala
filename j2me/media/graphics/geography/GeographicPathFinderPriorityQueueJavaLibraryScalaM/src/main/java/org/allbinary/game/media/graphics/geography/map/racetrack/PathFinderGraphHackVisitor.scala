/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.media.graphics.geography.map.racetrack

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap

//1.4.2
class PathFinderGraphHackVisitor(param_geographicMapInterface : BasicGeographicMap, param_edgeMinimum : Int, param_minPathWeight : Int, param_maxPathWeight : Int) extends BasePathFinderGraphVisitor[Object, Object](param_geographicMapInterface, param_edgeMinimum, param_minPathWeight, param_maxPathWeight) {

    //RaceTrackGeographicMap raceTrackGeographicMap
    //Constructor
    {
        val geographicMapInterface : BasicGeographicMap = param_geographicMapInterface
        val edgeMinimum : Int = param_edgeMinimum
        val minPathWeight : Int = param_minPathWeight
        val maxPathWeight : Int = param_maxPathWeight
    }

    override def visit(graph : Object, startPathFindingNodeList : BasicArrayList, endPathFindingNodeList : BasicArrayList) : Unit = {
        this.fixStart(graph, startPathFindingNodeList)
        this.fixEnd(graph, endPathFindingNodeList)
        this.fixOverPassEdges(graph)
    }

    private def fixStart(graph : Object, startPathFindingNodeList : BasicArrayList) : Unit = {
    }

    private def fixEnd(graph : Object, endPathFindingNodeList : BasicArrayList) : Unit = {
    }

    private def fixOverPassEdges(graph : Object) : Unit = {
    }

    override def fixPath(startPathFindingNodeList : BasicArrayList, endPathFindingNodeList : BasicArrayList, pathList : BasicArrayList) : Unit = {
    }

    //Fix Over pass Hack
    private def removeOverPassEdges(pathList : BasicArrayList) : Unit = {
    }

    override def isValid(graphPath : Object) : Boolean = {
        return false
    }

}


