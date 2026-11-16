/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.media.image.capture

import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler
import _root_.org.allbinary.media.image.cache.BufferedImageFrameCacheable
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.time.TimeDelayHelper

class ScreenCaptureImagesWorker() extends BasicEventHandler with CaptureWorkerInterface {
    import _root_.org.allbinary.input.media.image.capture.ScreenCaptureImagesWorker.{*}

    val logUtil_ScreenCaptureImagesWorker : LogUtil = LogUtil.getInstance()

    val commonStrings_ScreenCaptureImagesWorker : CommonStrings = CommonStrings.getInstance()

    private var running : Boolean = false

    private var screenScavangerRobot : ScreenScavangerRobot = null

    //Constructor
    {
        screenScavangerRobot = new ScreenScavangerRobot()
        ScreenCaptureImagesWorker.index = ProcessingFrameIndexFactory.next()
    }

    def isRunning() : Boolean = this.synchronized {
        return this.running
    }

    def setRunning(running : Boolean) : Unit = this.synchronized {
        this.running = running
    }

    def setThread(thread : Thread) : Unit = {
    }

    def run() : Unit = {
        try {
            this.logUtil_ScreenCaptureImagesWorker.putF(this.commonStrings_ScreenCaptureImagesWorker.START, this, this.commonStrings_ScreenCaptureImagesWorker.RUN)
            this.setRunning(true)
            var timeHelper : TimeDelayHelper = new TimeDelayHelper(1000)

            {
                while (isRunning()) {
                    timeHelper.setStartTimeTNT()
                    var bufferedImage : BufferedImage = this.screenScavangerRobot.getScreenAsBufferedImages()(0)
                    var frame : _root_.java.lang.Long = new _root_.java.lang.Long(index)
                    ScreenCaptureImagesWorker.index += 1
                    CapturedBufferedImagesCacheSingleton.getInstance().add(new BufferedImageFrameCacheable(bufferedImage, frame))
                    var capturedImageEvent : CapturedImageWorkerResultsEvent = new CapturedImageWorkerResultsEvent(this, frame, bufferedImage)
                    fireEvent(capturedImageEvent)
                    this.logUtil_ScreenCaptureImagesWorker.putF(CommonLabels.getInstance().ELAPSED + timeHelper.getElapsedTNT(), this, this.commonStrings_ScreenCaptureImagesWorker.RUN)
                    this.setRunning(false)
                }
            }
            this.logUtil_ScreenCaptureImagesWorker.putF(this.commonStrings_ScreenCaptureImagesWorker.END, this, this.commonStrings_ScreenCaptureImagesWorker.RUN)
        } catch {
            case e : Exception => {
                this.logUtil_ScreenCaptureImagesWorker.put(this.commonStrings_ScreenCaptureImagesWorker.EXCEPTION, this, this.commonStrings_ScreenCaptureImagesWorker.RUN, e)
            }
        }
    }

}

object ScreenCaptureImagesWorker {
    private var index : Long = 0L

}


