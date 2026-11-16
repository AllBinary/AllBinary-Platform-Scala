/* * AllBinary Open License Version 1 * Copyright (c) 2006 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.pathfinding

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels

class PathFindingNodeCostInfo(param_costFromStart : Long, param_costToGoal : Long) extends Comparable[PathFindingNodeCostInfo] {

    private val pathFindingNodeCostInfoData : PathFindingNodeCostInfoData = PathFindingNodeCostInfoData.getInstance()

    var costFromStartP : Long = 0L

    var costToEndP : Long = 0L

    //Add coming from costing
    var totalCostP : Long = 0L

    //Constructor
    {
        val costFromStart : Long = param_costFromStart
        val costToGoal : Long = param_costToGoal
        this.costFromStartP = costFromStart
        this.costToEndP = costToGoal
        //this.setTotalCost(totalCost);
        this.setCalculatedTotalCost()
    }

    def setCostToEnd(costToEnd : Long) : Unit = {
        this.costToEndP = costToEnd
    }

    def setTotalCost(totalCost : Long) : Unit = {
        this.totalCostP = totalCost
    }

    def setCalculatedTotalCost() : Unit = {
        this.totalCostP = this.costFromStartP + this.costToEndP
        if (this.totalCostP > this.pathFindingNodeCostInfoData.MAX_NODE_COST) {
            throw new Exception("Max Cost Exceeded")
        }
    }

    //older library check this method
    def setCostFromStart(cost : Long) : Unit = {
        //this.costFromStart += cost;
        this.costFromStartP = cost
    }

    def addCostFromStart(cost : Long) : Unit = {
        this.costFromStartP += cost
    }

    override def compareTo(pathFindingNodeCostInfo : PathFindingNodeCostInfo) : Int = {
        //java.lang.Long.compare is not available to the JS build
        if (this.totalCostP < pathFindingNodeCostInfo.totalCostP) {
            return -1
        } else if (this.totalCostP > pathFindingNodeCostInfo.totalCostP) {
            return 1
        }
        return 0
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.getClass().getName())
        stringBuffer.append(CommonLabels.getInstance().COLON_SEP)
        stringBuffer.append("CostFromStart: ")
        stringBuffer.appendlong(this.costFromStartP)
        stringBuffer.append(" CostToEnd: ")
        stringBuffer.appendlong(this.costToEndP)
        stringBuffer.append(" TotalCost: ")
        stringBuffer.appendlong(this.totalCostP)
        return stringBuffer.toString()
    }

}


