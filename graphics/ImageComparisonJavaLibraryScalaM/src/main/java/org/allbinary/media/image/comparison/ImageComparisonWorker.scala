/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.input.media.image.capture.CapturedImageWorkerResultsEvent
import _root_.org.allbinary.input.media.image.capture.CapturedImageWorkerResultsListener
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.time.TimeDelayHelper

class ImageComparisonWorker(param_imageComparatorConstraintsInterface : ImageComparatorConstraintsInterface) extends BasicEventHandler with CapturedImageWorkerResultsListener {

    val logUtil_ImageComparisonWorker : LogUtil = LogUtil.getInstance()

    private val commonStrings_ImageComparisonWorker : CommonStrings = CommonStrings.getInstance()

    private val bufferedImageVector : BasicArrayList = new BasicArrayListD()

    private var imageComparatorConstraintsInterface : ImageComparatorConstraintsInterface = null

    private var imageComparator : ImageComparator = null

    private var running : Boolean = false

    private var index2 : Int = 0

    //Constructor
    {
        val imageComparatorConstraintsInterface : ImageComparatorConstraintsInterface = param_imageComparatorConstraintsInterface
        this.imageComparatorConstraintsInterface = imageComparatorConstraintsInterface
        this.imageComparator = new ImageComparator(imageComparatorConstraintsInterface)
    }

    def isRunning() : Boolean = this.synchronized {
        return this.running
    }

    def setRunning(running : Boolean) : Unit = this.synchronized {
        this.running = running
    }

    def onCaptureEvent(capturedImageWorkerResultsEvent : CapturedImageWorkerResultsEvent) : Unit = this.synchronized {
        this.bufferedImageVector.add(capturedImageWorkerResultsEvent)
        if (this.bufferedImageVector.size() > 1) {
            this.run()
        }
    }

    def onEvent(allBinaryEventObject : AllBinaryEventObject) : Unit = this.synchronized {
        this.onCaptureEvent(allBinaryEventObject.asInstanceOf[CapturedImageWorkerResultsEvent])
    }

    def run() : Unit = {
        try {
            this.logUtil_ImageComparisonWorker.putF(this.commonStrings_ImageComparisonWorker.START, this, this.commonStrings_ImageComparisonWorker.RUN)
            this.setRunning(true)
            var timeHelper : TimeDelayHelper = new TimeDelayHelper(1000)
            timeHelper.setStartTimeTNT()
            if (this.imageComparatorConstraintsInterface.isFrameAllowed(this.index2)) {
                val capturedImageWorkerResultsEvent : Array[CapturedImageWorkerResultsEvent] = new Array[CapturedImageWorkerResultsEvent](2)
                capturedImageWorkerResultsEvent(0) = this.bufferedImageVector.get(0).asInstanceOf[CapturedImageWorkerResultsEvent]
                capturedImageWorkerResultsEvent(1) = this.bufferedImageVector.get(1).asInstanceOf[CapturedImageWorkerResultsEvent]
                if (this.imageComparatorConstraintsInterface.isImageValid(capturedImageWorkerResultsEvent(0).getBufferedImage()) && this.imageComparatorConstraintsInterface.isImageValid(capturedImageWorkerResultsEvent(1).getBufferedImage())) {
                    val imageComparisonResult : ImageComparisonResult = this.imageComparator.compare(capturedImageWorkerResultsEvent(0).getBufferedImage(), capturedImageWorkerResultsEvent(1).getBufferedImage(), capturedImageWorkerResultsEvent(0).getFrame(), capturedImageWorkerResultsEvent(1).getFrame(), 0)
                    val frame : _root_.java.lang.Long = capturedImageWorkerResultsEvent(1).getFrame()
                    val imageComparisonResultFrameCacheable : ImageComparisonResultFrameCacheable = new ImageComparisonResultFrameCacheable(imageComparisonResult, frame)
                    ImageComparisonResultCacheSingleton.getInstance().add(imageComparisonResultFrameCacheable)
                    this.fireEvent(new ImageComparisonResultsEvent(this, imageComparisonResult))
                    this.logUtil_ImageComparisonWorker.putF(new StringMaker().append("Image Comparison Result: ").append(imageComparisonResult.toString()).append(" for frame: ").appendlong(frame).toString(), this, this.commonStrings_ImageComparisonWorker.RUN)
                } else {
                    this.logUtil_ImageComparisonWorker.putF("An Image Was Not Valid: Image Worker Event Processing terminated", this, this.commonStrings_ImageComparisonWorker.RUN)
                }
            }
            //Remove the first frame compared or not
            this.bufferedImageVector.remove(Integer.valueOf(0))
            this.index2 += 1
            val message : String = new StringMaker().append("Frame: ").appendint(this.index2).append(CommonLabels.getInstance().ELAPSED).appendlong(timeHelper.getElapsedTNT()).toString()
            this.logUtil_ImageComparisonWorker.putF(message, this, this.commonStrings_ImageComparisonWorker.RUN)
            this.setRunning(false)
            this.logUtil_ImageComparisonWorker.putF(this.commonStrings_ImageComparisonWorker.END, this, this.commonStrings_ImageComparisonWorker.RUN)
        } catch {
            case e : Exception => {
                this.logUtil_ImageComparisonWorker.put(this.commonStrings_ImageComparisonWorker.EXCEPTION, this, this.commonStrings_ImageComparisonWorker.RUN, e)
            }
        }
    }

}


