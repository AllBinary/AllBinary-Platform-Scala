/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison.motion

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.time.TimeDelayHelper

class SaveMotionRectanglesResultsWorker() extends MotionRectanglesResultsListener {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var running : Boolean = false

    private var motionRectanglesVector : BasicArrayList = null

    //Constructor
    {
        this.motionRectanglesVector = new BasicArrayListD()
    }

    def getMotionRectanglesVector() : BasicArrayList = {
        return this.motionRectanglesVector
    }

    def onMotionRectanglesImageComparisonResultsEvent(motionRectanglesResultsEvent : MotionRectanglesResultsEvent) : Unit = {
        this.getMotionRectanglesVector().add(motionRectanglesResultsEvent)
        this.run()
    }

    def onEvent(allBinaryEventObject : AllBinaryEventObject) : Unit = {
        this.onMotionRectanglesImageComparisonResultsEvent(allBinaryEventObject.asInstanceOf[MotionRectanglesResultsEvent])
    }

    def isRunning() : Boolean = this.synchronized {
        return this.running
    }

    def setRunning(running : Boolean) : Unit = this.synchronized {
        this.running = running
    }

    def run() : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.RUN)
            this.setRunning(true)
            var timeHelper : TimeDelayHelper = new TimeDelayHelper(1000)
            timeHelper.setStartTimeTNT()
            var motionRectanglesResultsEvent : MotionRectanglesResultsEvent = this.getMotionRectanglesVector().get(0).asInstanceOf[MotionRectanglesResultsEvent]
            var motionRectangles : MotionRectangles = motionRectanglesResultsEvent.getMotionRectangles()
            new MotionRectanglesImageInputOutput().save(motionRectangles, motionRectanglesResultsEvent.getFrame())
            this.getMotionRectanglesVector().remove(motionRectangles)
            this.logUtil.putF(CommonLabels.getInstance().ELAPSED + timeHelper.getElapsedTNT(), this, this.commonStrings.RUN)
            this.logUtil.putF(this.commonStrings.END, this, this.commonStrings.RUN)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.RUN, e)
            }
        }
    }

}


