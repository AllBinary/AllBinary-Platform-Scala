/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.pathfinding

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListUtil

class PathFindingInfo(param_pathFindingNodeCostInfoFactoryInterface : PathFindingNodeCostInfoFactoryBase, param_startPathFindingNodeList : BasicArrayList, param_endPathFindingNodeList : BasicArrayList) extends PathFindingInfoInterface {
    import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingInfo.{NULL_PATH_FINDING_INFO as _, *}
    def NULL_PATH_FINDING_INFO : PathFindingInfo = _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingInfo.NULL_PATH_FINDING_INFO

    private var pathFinder : GeographicPathFinderBase = GeographicPathFinderBase.NULL_GEOGRAPHIC_PATH_FINDER_BASE

    private var startPathFindingNodeList : BasicArrayList = null

    private var endPathFindingNodeList : BasicArrayList = null

    private var pathFindingNodeCostInfoFactoryInterface : PathFindingNodeCostInfoFactoryBase = null

    //Constructor
    {
        val pathFindingNodeCostInfoFactoryInterface : PathFindingNodeCostInfoFactoryBase = param_pathFindingNodeCostInfoFactoryInterface
        val startPathFindingNodeList : BasicArrayList = param_startPathFindingNodeList
        val endPathFindingNodeList : BasicArrayList = param_endPathFindingNodeList
        this.pathFindingNodeCostInfoFactoryInterface = pathFindingNodeCostInfoFactoryInterface
        this.startPathFindingNodeList = startPathFindingNodeList
        this.endPathFindingNodeList = endPathFindingNodeList
    }

    override def getStartPathFindingNodeList() : BasicArrayList = {
        return this.startPathFindingNodeList
    }

    override def getEndPathFindingNodeList() : BasicArrayList = {
        return this.endPathFindingNodeList
    }

    override def getPathFinder() : GeographicPathFinderBase = {
        return this.pathFinder
    }

    def addStartPathFindingNode(startPathFindingNode : PathFindingNode) : Unit = {
        this.startPathFindingNodeList.add(startPathFindingNode)
    }

    def addEndPathFindingNode(endPathFindingNode : PathFindingNode) : Unit = {
        this.endPathFindingNodeList.add(endPathFindingNode)
    }

    def setPathFinder(pathFinder : GeographicPathFinderBase) : Unit = {
        this.pathFinder = pathFinder
    }

    def getPathFindingNodeCostInfoFactoryInterface() : PathFindingNodeCostInfoFactoryBase = {
        return this.pathFindingNodeCostInfoFactoryInterface
    }

}

object PathFindingInfo {
    val NULL_PATH_FINDING_INFO : PathFindingInfo = new PathFindingInfo(PathFindingNodeCostInfoFactoryBase.NULL_PATH_FINDING_NODE_COST_INFO_FACTORY_BASE, BasicArrayListUtil.getInstance().getImmutableInstance(), BasicArrayListUtil.getInstance().getImmutableInstance())

}


