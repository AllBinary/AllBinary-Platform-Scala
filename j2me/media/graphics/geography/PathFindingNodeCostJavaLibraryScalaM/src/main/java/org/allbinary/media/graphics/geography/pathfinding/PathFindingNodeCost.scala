/* * AllBinary Open License Version 1 * Copyright (c) 2006 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.pathfinding

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.string.CommonLabels

class PathFindingNodeCost(param_parent : Object, param_geographicMapCellPosition : GeographicMapCellPosition, param_pathFindingNodeCostInfo : PathFindingNodeCostInfo) extends PathFindingNode(param_parent, param_geographicMapCellPosition) with Comparable[PathFindingNodeCost] {
    import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingNodeCost.{NULL_PATH_FINDING_NODE_COST_ARRAY_ARRAY as _, *}
    def NULL_PATH_FINDING_NODE_COST_ARRAY_ARRAY : Array[Array[PathFindingNodeCost]] = _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingNodeCost.NULL_PATH_FINDING_NODE_COST_ARRAY_ARRAY

    private val commonSeps : CommonSeps = CommonSeps.getInstance()

    var pathFindingNodeCostInfoP : PathFindingNodeCostInfo = null

    //Constructor
    {
        val parent : Object = param_parent
        val geographicMapCellPosition : GeographicMapCellPosition = param_geographicMapCellPosition
        val pathFindingNodeCostInfo : PathFindingNodeCostInfo = param_pathFindingNodeCostInfo
        this.pathFindingNodeCostInfoP = pathFindingNodeCostInfo
        /*       if(this.getParent() == null)       {          this.logUtil.putF("No Parent", this, this.commonStrings.CONSTRUCTOR);       }          */
        if (this.geographicMapCellPosition == null) {
            throw new Exception("No GeographicMapCellPosition")
        }
        if (this.getPathFindingNodeCostInfo() == null) {
            throw new Exception("No PathFindingNodeCostInfo")
        }
    }

    def getPathFindingNodeCostInfo() : PathFindingNodeCostInfo = {
        return this.pathFindingNodeCostInfoP
    }

    def setPathFindingNodeCostInfo(pathFindingNodeCostInfo : PathFindingNodeCostInfo) : Unit = {
        this.pathFindingNodeCostInfoP = pathFindingNodeCostInfo
    }

    override def compareTo(pathFindingNodeCost : PathFindingNodeCost) : Int = {
        return this.pathFindingNodeCostInfoP.compareTo(pathFindingNodeCost.pathFindingNodeCostInfoP)
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.getClass().getName())
        stringBuffer.append(CommonLabels.getInstance().COLON_SEP)
        stringBuffer.append(this.getPathFindingNodeCostInfo().toString())
        stringBuffer.append(" Path: ")
        stringBuffer.append(this.geographicMapCellPosition.toString())
        var pathFindingNode : PathFindingNode = this.parent.asInstanceOf[PathFindingNode]

        {
            while (pathFindingNode != null) {
                stringBuffer.append(pathFindingNode.geographicMapCellPosition.toString())
                stringBuffer.append(this.commonSeps.SPACE)
                pathFindingNode = pathFindingNode.parent.asInstanceOf[PathFindingNode]
            }
        }
        return stringBuffer.toString()
    }

}

object PathFindingNodeCost {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    val NULL_PATH_FINDING_NODE_COST_ARRAY_ARRAY : Array[Array[PathFindingNodeCost]] = Array.ofDim[PathFindingNodeCost](0, 0)

}


