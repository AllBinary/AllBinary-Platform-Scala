/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.math.LayerDistanceUtil
import _root_.org.allbinary.thread.PriorityRunnable
import _root_.org.allbinary.thread.RunnableInterface

/**  *  * @author User  */
class WaypointPathRunnableBase extends RunnableInterface with PriorityRunnable {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val layerDistanceUtil : LayerDistanceUtil = LayerDistanceUtil.getInstance()

    var pathFindingLayer : PathFindingLayerInterface = NullPathFindingLayer.NULL_PATH_FINDING_LAYER

    var targetPathFindingLayer : PathFindingLayerInterface = NullPathFindingLayer.NULL_PATH_FINDING_LAYER

    var priorityP : Int = Integer.MAX_VALUE

    var runningP : Boolean = false

    override def isRunning() : Boolean = {
        return this.runningP
    }

    override def setRunning(isRunning : Boolean) : Unit = {
        this.runningP = isRunning
    }

    override def setThread(thread : Thread) : Unit = {
    }

    /**      * @param waypointLayer the waypointLayer to set      */
    def setTargetLayer(waypointLayer : PathFindingLayerInterface) : Unit = {
        this.targetPathFindingLayer = waypointLayer
        this.setPriority()
    }

    def setPriority() : Unit = {
        val pathFindingLayer : AllBinaryLayer = this.pathFindingLayer.asInstanceOf[AllBinaryLayer]
        val targetLayer : AllBinaryLayer = this.targetPathFindingLayer.asInstanceOf[AllBinaryLayer]
        if (targetLayer != null) {
            val distance : Int = this.layerDistanceUtil.getDistance(targetLayer, pathFindingLayer)
            val distanceCategory : Int = distance / 70
            this.priorityP = distanceCategory
        }
    }

    def getTargetLayer() : PathFindingLayerInterface = {
        return this.targetPathFindingLayer
    }

    /**      * @param unitLayer the unitLayer to set      */
    def setUnitLayer(unitLayer : PathFindingLayerInterface) : Unit = {
        this.pathFindingLayer = unitLayer
    }

    override def getPriority() : Int = {
        return this.priorityP
    }

    override def isDone() : Boolean = {
        return true
    }

    override def run() : Unit = {
    }

    override def reset() : Unit = {
    }

}


