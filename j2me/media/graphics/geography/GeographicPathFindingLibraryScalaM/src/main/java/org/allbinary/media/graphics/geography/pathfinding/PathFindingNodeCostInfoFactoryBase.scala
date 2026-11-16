/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.pathfinding

import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition

/**  *  * @author User  */
class PathFindingNodeCostInfoFactoryBase extends PathFindingNodeCostInfoFactoryBaseInterface {
    import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingNodeCostInfoFactoryBase.{NULL_PATH_FINDING_NODE_COST_INFO_FACTORY_BASE as _, *}
    def NULL_PATH_FINDING_NODE_COST_INFO_FACTORY_BASE : PathFindingNodeCostInfoFactoryBase = _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingNodeCostInfoFactoryBase.NULL_PATH_FINDING_NODE_COST_INFO_FACTORY_BASE

    override def create(geographicMapInterface : BasicGeographicMap, comingFromGeographicMapCellPosition : GeographicMapCellPosition, geographicMapCellPosition : GeographicMapCellPosition, costFromStart : Long, costToEnd : Long) : Unit = {
        throw new RuntimeException()
    }

    override def getTotalCost(geographicMapInterface : BasicGeographicMap, comingFromGeographicMapCellPosition : GeographicMapCellPosition, geographicMapCellPosition : GeographicMapCellPosition) : Long = {
        throw new RuntimeException()
    }

}

object PathFindingNodeCostInfoFactoryBase {
    val NULL_PATH_FINDING_NODE_COST_INFO_FACTORY_BASE : PathFindingNodeCostInfoFactoryBase = new PathFindingNodeCostInfoFactoryBase()

}


