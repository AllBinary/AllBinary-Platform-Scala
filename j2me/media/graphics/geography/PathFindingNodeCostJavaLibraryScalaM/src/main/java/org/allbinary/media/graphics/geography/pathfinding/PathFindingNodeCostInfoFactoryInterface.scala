/* * AllBinary Open License Version 1 * Copyright (c) 2006 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.pathfinding

import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition

trait PathFindingNodeCostInfoFactoryInterface extends PathFindingNodeCostInfoFactoryBaseInterface {

    def getInstance(comingFromGeographicMapCellPosition : GeographicMapCellPosition, geographicMapCellPosition : GeographicMapCellPosition, costFromStart : Long, costToEnd : Long) : PathFindingNodeCostInfo

    def getInstance(comingFromGeographicMapCellPosition : GeographicMapCellPosition, geographicMapCellPosition : GeographicMapCellPosition) : PathFindingNodeCostInfo

    def getTotalCost(comingFromGeographicMapCellPosition : GeographicMapCellPosition, geographicMapCellPosition : GeographicMapCellPosition) : Long

}


