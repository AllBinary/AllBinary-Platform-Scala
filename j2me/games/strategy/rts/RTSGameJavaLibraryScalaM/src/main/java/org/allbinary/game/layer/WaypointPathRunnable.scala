/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition

/**  *  * @author user  */
class WaypointPathRunnable() extends WaypointPathRunnableBase {

    val logUtil : LogUtil = LogUtil.getInstance()

    override def run() : Unit = {
        try {
            //this.logUtil.putF("", this, "run");
            this.pathFindingLayer.getWaypointRunnableLogHelper().start(this.pathFindingLayer)
            val waypointBehavior : WaypointBehaviorBase = this.pathFindingLayer.getWaypointBehavior()
            val geographicMapCellPosition : GeographicMapCellPosition = this.pathFindingLayer.getCurrentGeographicMapCellPosition()
            if (geographicMapCellPosition == null) {
                throw new Exception("Should never be running here")
            }
            waypointBehavior.setWaypointPathsList(this.targetPathFindingLayer.getWaypointBehavior().getWaypoint().getPathsListRunnable(geographicMapCellPosition))
            this.pathFindingLayer.getWaypointRunnableLogHelper().end(this.pathFindingLayer)
            //this.actuallyRunning = false;
            Thread.sleep((15).toLong + (this.priorityP * 2))
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
                //this.logUtil.put(commonStrings.EXCEPTION, this, "run", e);
                this.setRunning(false)
            }
        }
    }

    override def isDone() : Boolean = {
        return true
    }

}


