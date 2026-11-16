/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.canvas

import _root_.android.view.View
import _root_.org.allbinary.logic.string.StringMaker

class ProfilingRefreshHelper private() extends AndroidGameStatistics {
    import _root_.org.allbinary.canvas.ProfilingRefreshHelper.{*}

    private var firstTime : Boolean = true

    private var bestFrameProcessingTime : Int = 0

    // private long averageFrameProcessingTime;
    private var worstFrameProcessingTime : Int = 0

    private var frameProcessingTimeElapsed : Long = 0L

    override def initView(view : View) : Unit = {
        super.initView(view)
        this.frameProcessingTimeElapsed = this.getTimeDelayHelper().getStartTime()
        this.bestFrameProcessingTime = Integer.MAX_VALUE
        // averageFrameProcessingTime = 0;
        this.worstFrameProcessingTime = 0
    }

    override def nextFrame() : Unit = {
        this.frameProcessingTimeElapsed = System.currentTimeMillis() - this.frameProcessingTimeElapsed
        if (this.firstTime != true) {
            if (this.frameProcessingTimeElapsed > this.worstFrameProcessingTime) {
                this.worstFrameProcessingTime = this.frameProcessingTimeElapsed.toInt
            }
            if (this.frameProcessingTimeElapsed < this.bestFrameProcessingTime) {
                this.bestFrameProcessingTime = this.frameProcessingTimeElapsed.toInt
            }
        } else {
            this.firstTime = false
        }
        // averageFrameProcessingTime = 0;
        super.nextFrame()
    }

    override def toString() : String = {
        return new StringMaker().append(super.toString()).append(" Worst: ").appendint(this.worstFrameProcessingTime).append(" Best: ").appendint(this.bestFrameProcessingTime).toString()
    }

}

object ProfilingRefreshHelper {
    private val instance : ProfilingRefreshHelper = new ProfilingRefreshHelper()

    def getInstance() : AndroidGameStatistics = {
        return ProfilingRefreshHelper.instance
    }

}


