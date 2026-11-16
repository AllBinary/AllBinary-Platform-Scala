/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.thread.ARunnable
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.pathfinding.MultipassState
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingInfo
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListUtil

/**  *  * @author user  */
class MultipassWaypointPathRunnable() extends WaypointPathRunnableBase {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val basicArrayListUtil : BasicArrayListUtil = BasicArrayListUtil.getInstance()

    private val multipassState : MultipassState = new MultipassState()

    private var done : Boolean = false

    private var list : BasicArrayList = this.basicArrayListUtil.getImmutableInstance()

    private var pathFindingInfo : Object = NullUtil.getInstance().NULL_OBJECT

    private val FIRST_RUNNABLE : Runnable = new FirstRunnable(this)

    private val SECOND_RUNNABLE : Runnable = new SecondRunnable(this)

    private val END_RUNNABLE : Runnable = new EndRunnable(this)

    private val ALREADY_ENDED_RUNNABLE : Runnable = new ARunnable {
            override def run() : Unit = {
                throw new RuntimeException()
            }

        }

    private var currentPassRunnable : Runnable = this.FIRST_RUNNABLE

    class FirstRunnable(param_multipassWaypointPathRunnable : MultipassWaypointPathRunnable) extends ARunnable {

        private[FirstRunnable] var multipassWaypointPathRunnable : MultipassWaypointPathRunnable = null

        //Constructor
        {
            val multipassWaypointPathRunnable : MultipassWaypointPathRunnable = param_multipassWaypointPathRunnable
            this.multipassWaypointPathRunnable = multipassWaypointPathRunnable
        }

        override def run() : Unit = {
            this.multipassWaypointPathRunnable.processFirstRunnable()
        }

    }

    //    private boolean first = true;
    class SecondRunnable(param_multipassWaypointPathRunnable : MultipassWaypointPathRunnable) extends ARunnable {

        private[SecondRunnable] var multipassWaypointPathRunnable : MultipassWaypointPathRunnable = null

        //Constructor
        {
            val multipassWaypointPathRunnable : MultipassWaypointPathRunnable = param_multipassWaypointPathRunnable
            this.multipassWaypointPathRunnable = multipassWaypointPathRunnable
        }

        override def run() : Unit = {
            this.multipassWaypointPathRunnable.processSecondRunnable()
        }

    }

    class EndRunnable(param_multipassWaypointPathRunnable : MultipassWaypointPathRunnable) extends ARunnable {

        private[EndRunnable] var multipassWaypointPathRunnable : MultipassWaypointPathRunnable = null

        //Constructor
        {
            val multipassWaypointPathRunnable : MultipassWaypointPathRunnable = param_multipassWaypointPathRunnable
            this.multipassWaypointPathRunnable = multipassWaypointPathRunnable
        }

        override def run() : Unit = {
            this.multipassWaypointPathRunnable.processEndRunnable()
        }

    }

    override def setRunning(isRunning : Boolean) : Unit = {
        this.runningP = isRunning
        if (this.runningP) {
            this.reset()
            this.done = false
        }
    }

    override def run() : Unit = {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            this.currentPassRunnable.run()
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
                //logUtil.put(commonStrings.EXCEPTION, this, "run", e);
                this.setRunning(false)
            }
        }
    }

    private def reset2() : Unit = {
        this.multipassState.step = 0
        this.multipassState.iteration = 0
        this.multipassState.iteration2 = 0
        this.pathFindingInfo = NullUtil.getInstance().NULL_OBJECT
    }

    private def finish() : Unit = {
        this.reset2()
        this.currentPassRunnable = this.ALREADY_ENDED_RUNNABLE
        this.done = true
    }

    override def isDone() : Boolean = {
        return this.done
    }

    override def reset() : Unit = {
        this.reset2()
        this.currentPassRunnable = this.FIRST_RUNNABLE
        this.done = false
    }

    private def processFirstRunnable() : Unit = {
        try {
            this.pathFindingLayer.getWaypointRunnableLogHelper().start(this.pathFindingLayer)
            this.reset2()
            val geographicMapCellPosition : GeographicMapCellPosition = this.pathFindingLayer.getCurrentGeographicMapCellPosition()
            if (geographicMapCellPosition == null) {
                throw new Exception("Should never be running here")
            }
            this.pathFindingInfo = this.targetPathFindingLayer.getWaypointBehavior().getWaypoint().getPathFindingInfo(geographicMapCellPosition)
            val localPathFindingInfo : PathFindingInfo = this.pathFindingInfo.asInstanceOf[PathFindingInfo]
            //                logUtil.putF("first set: " + pathFindingInfo, this, "getPathsList");
            this.list = this.targetPathFindingLayer.getWaypointBehavior().getWaypoint().getPathsList(geographicMapCellPosition, localPathFindingInfo, this.multipassState)
            if (this.list ne this.basicArrayListUtil.getImmutableInstance()) {
                this.END_RUNNABLE.run()
            } else {
                this.currentPassRunnable = this.SECOND_RUNNABLE
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
                //logUtil.put(commonStrings.EXCEPTION, this, "run", e);
                this.setRunning(false)
                this.finish()
            }
        }
    }

    private def processSecondRunnable() : Unit = {
        try {
            //                }
            val geographicMapCellPosition : GeographicMapCellPosition = this.pathFindingLayer.getCurrentGeographicMapCellPosition()
            val localPathFindingInfo : PathFindingInfo = this.pathFindingInfo.asInstanceOf[PathFindingInfo]
            this.list = this.targetPathFindingLayer.getWaypointBehavior().getWaypoint().getPathsList(geographicMapCellPosition, localPathFindingInfo, this.multipassState)
            if (this.list ne this.basicArrayListUtil.getImmutableInstance()) {
                this.END_RUNNABLE.run()
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
                //logUtil.put(commonStrings.EXCEPTION, this, "run", e);
                this.setRunning(false)
                this.finish()
            }
        }
    }

    private def processEndRunnable() : Unit = {
        try {
            val waypointBehavior : WaypointBehaviorBase = this.pathFindingLayer.getWaypointBehavior()
            //                logUtil.putF("end: " + pathFindingInfo, this, "getPathsList");
            waypointBehavior.setWaypointPathsList(this.list)
            this.pathFindingLayer.getWaypointRunnableLogHelper().end(this.pathFindingLayer)
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
                //logUtil.put(commonStrings.EXCEPTION, this, "run", e);
                this.setRunning(false)
            }
        }
        this.finish()
    }

}


