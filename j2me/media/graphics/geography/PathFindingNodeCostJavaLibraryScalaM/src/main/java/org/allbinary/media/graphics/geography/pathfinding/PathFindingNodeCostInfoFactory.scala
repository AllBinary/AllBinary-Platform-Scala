/* * AllBinary Open License Version 1 * Copyright (c) 2006 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.pathfinding

import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition

class PathFindingNodeCostInfoFactory(param_max : Int) extends PathFindingNodeCostInfoFactoryBase {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var pathFindingNodeCostInfoAdjacencyList : Array[Array[PathFindingNodeCostInfo]] = null

    //Constructor
    {
        val max : Int = param_max
        this.pathFindingNodeCostInfoAdjacencyList = Array.ofDim[PathFindingNodeCostInfo](max, max)
    }

    override def create(geographicMapInterface : BasicGeographicMap, goingToGeographicMapCellPosition : GeographicMapCellPosition, geographicMapCellPosition : GeographicMapCellPosition, costFromStart : Long, costToEnd : Long) : Unit = {
        this.getInstance(goingToGeographicMapCellPosition, geographicMapCellPosition, costFromStart, costToEnd)
    }

    def getInstance(goingToGeographicMapCellPosition : GeographicMapCellPosition, geographicMapCellPosition : GeographicMapCellPosition, costFromStart : Long, costToEnd : Long) : PathFindingNodeCostInfo = {
        var pathFindingNodeCostInfo : PathFindingNodeCostInfo = this.getInstance(goingToGeographicMapCellPosition, geographicMapCellPosition)
        if (pathFindingNodeCostInfo == null) {
            //PathFindingNodeCostInfo pathFindingNodeCostInfo =
            pathFindingNodeCostInfo = new PathFindingNodeCostInfo(costFromStart, costToEnd)
            pathFindingNodeCostInfo.setCalculatedTotalCost()
            this.pathFindingNodeCostInfoAdjacencyList(geographicMapCellPosition.getId())(goingToGeographicMapCellPosition.getId()) = pathFindingNodeCostInfo
        } else {
            pathFindingNodeCostInfo.setCostFromStart(costFromStart)
            pathFindingNodeCostInfo.setCostToEnd(costToEnd)
            pathFindingNodeCostInfo.setCalculatedTotalCost()
        }
        return pathFindingNodeCostInfo
    }

    def getInstance(goingToFromGeographicMapCellPosition : GeographicMapCellPosition, geographicMapCellPosition : GeographicMapCellPosition) : PathFindingNodeCostInfo = {
        //return pathFindingNodeCostInfo;
        return this.pathFindingNodeCostInfoAdjacencyList(geographicMapCellPosition.getId())(goingToFromGeographicMapCellPosition.getId())
    }

    override def getTotalCost(geographicMapInterface : BasicGeographicMap, comingFromGeographicMapCellPosition : GeographicMapCellPosition, geographicMapCellPosition : GeographicMapCellPosition) : Long = {
        return this.getInstance(comingFromGeographicMapCellPosition, geographicMapCellPosition).totalCostP
    }

}


