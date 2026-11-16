/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.pathfinding


class PathFindingNodeCostInfoData private() {
    import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingNodeCostInfoData.{*}

    var MAX_TOTAL_COST : Int = Integer.MAX_VALUE

    //SmallLongFactory.SPECIAL;
    var MAX_NODE_COST : Int = Integer.MAX_VALUE / 10000

}

object PathFindingNodeCostInfoData {
    private val instance : PathFindingNodeCostInfoData = new PathFindingNodeCostInfoData()

    /**      * @return the instance      */
    def getInstance() : PathFindingNodeCostInfoData = {
        return PathFindingNodeCostInfoData.instance
    }

}


