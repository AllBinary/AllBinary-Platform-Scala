/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison.motion

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler
import _root_.org.allbinary.media.image.comparison.ImageComparisonResult
import _root_.org.allbinary.media.image.comparison.ImageComparisonResultsEvent
import _root_.org.allbinary.media.image.comparison.ImageComparisonResultsListener
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.time.TimeDelayHelper

class MotionRectanglesWorker(param_motionRectangleConstraintsInterface : MotionRectangleConstraintsInterface) extends BasicEventHandler with ImageComparisonResultsListener {

    val logUtil_MotionRectanglesWorker : LogUtil = LogUtil.getInstance()

    val commonStrings_MotionRectanglesWorker : CommonStrings = CommonStrings.getInstance()

    private val imageComparisonInfoVector : BasicArrayList = new BasicArrayListD()

    private var motionRectangleConstraintsInterface : MotionRectangleConstraintsInterface = null

    private var index : Long = 0L

    private var running : Boolean = false

    //Constructor
    {
        val motionRectangleConstraintsInterface : MotionRectangleConstraintsInterface = param_motionRectangleConstraintsInterface
        this.motionRectangleConstraintsInterface = motionRectangleConstraintsInterface
    }

    def onImageComparisonResultsEvent(imageComparisonResultsEvent : ImageComparisonResultsEvent) : Unit = {
        this.imageComparisonInfoVector.add(imageComparisonResultsEvent)
        this.run()
    }

    def onEvent(allBinaryEventObject : AllBinaryEventObject) : Unit = {
        this.onImageComparisonResultsEvent(allBinaryEventObject.asInstanceOf[ImageComparisonResultsEvent])
    }

    def isRunning() : Boolean = this.synchronized {
        return this.running
    }

    def setRunning(running : Boolean) : Unit = this.synchronized {
        this.running = running
    }

    def run() : Unit = {
        try {
            this.logUtil_MotionRectanglesWorker.putF(this.commonStrings_MotionRectanglesWorker.START, this, this.commonStrings_MotionRectanglesWorker.RUN)
            this.setRunning(true)
            val timeHelper : TimeDelayHelper = new TimeDelayHelper(1000)
            timeHelper.setStartTimeTNT()
            val imageComparisonResultsEvent : ImageComparisonResultsEvent = this.imageComparisonInfoVector.get(0).asInstanceOf[ImageComparisonResultsEvent]
            val imageComparisonInfo : ImageComparisonResult = imageComparisonResultsEvent.getImageComparisonResult().asInstanceOf[ImageComparisonResult]
            this.logUtil_MotionRectanglesWorker.putF(imageComparisonInfo.toString(), this, this.commonStrings_MotionRectanglesWorker.RUN)
            //final BufferedImage latestBufferedImage = imageComparisonInfo.getBufferedImages()[1];
            val allMotionRectangles : AllMotionRectangles = new AllMotionRectangles(imageComparisonInfo)
            AllMotionRectanglesResultsCacheSingleton.getInstance().add(new MotionRectanglesResultsFrameCacheable(allMotionRectangles, imageComparisonInfo.getFrameTwo()))
            val consolidatedMotionRectangles : ConsolidateMotionRectangles = new ConsolidateMotionRectangles(allMotionRectangles)
            ConsolidatedMotionRectanglesResultsCacheSingleton.getInstance().add(new MotionRectanglesResultsFrameCacheable(consolidatedMotionRectangles, imageComparisonInfo.getFrameTwo()))
            val constrainedMotionRectangles : ConstrainedMotionRectangles = new ConstrainedMotionRectangles(this.motionRectangleConstraintsInterface, consolidatedMotionRectangles)
            constrainedMotionRectangles.applyMotionRectangleConstraints(consolidatedMotionRectangles)
            ConstrainedMotionRectanglesResultsCacheSingleton.getInstance().add(new MotionRectanglesResultsFrameCacheable(constrainedMotionRectangles, imageComparisonInfo.getFrameTwo()))
            this.fireEvent(new MotionRectanglesResultsEvent(this, imageComparisonInfo.getFrameTwo(), constrainedMotionRectangles.asInstanceOf[MotionRectangles]))
            this.imageComparisonInfoVector.remove(imageComparisonResultsEvent)
            this.index += 1
            this.logUtil_MotionRectanglesWorker.putF(CommonLabels.getInstance().ELAPSED + timeHelper.getElapsedTNT(), this, this.commonStrings_MotionRectanglesWorker.RUN)
            this.setRunning(false)
            this.logUtil_MotionRectanglesWorker.putF(this.commonStrings_MotionRectanglesWorker.END, this, this.commonStrings_MotionRectanglesWorker.RUN)
        } catch {
            case e : Exception => {
                this.logUtil_MotionRectanglesWorker.put(this.commonStrings_MotionRectanglesWorker.EXCEPTION, this, this.commonStrings_MotionRectanglesWorker.RUN, e)
            }
        }
    }

}


