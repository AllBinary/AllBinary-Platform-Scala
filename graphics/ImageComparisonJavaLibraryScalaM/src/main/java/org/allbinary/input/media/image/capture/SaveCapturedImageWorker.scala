/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.media.image.capture

import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.time.TimeDelayHelper

class SaveCapturedImageWorker() extends BasicEventHandler with CapturedImageWorkerResultsListener {

    val logUtil_SaveCapturedImageWorker : LogUtil = LogUtil.getInstance()

    val commonStrings_SaveCapturedImageWorker : CommonStrings = CommonStrings.getInstance()

    private var running : Boolean = false

    private var capturedImageWorkerResultsEventVector : BasicArrayList = new BasicArrayListD()

    def isRunning() : Boolean = this.synchronized {
        return this.running
    }

    def setRunning(running : Boolean) : Unit = this.synchronized {
        this.running = running
    }

    def onCaptureEvent(capturedImageEvent : CapturedImageWorkerResultsEvent) : Unit = {
        this.capturedImageWorkerResultsEventVector.add(capturedImageEvent)
        this.run()
    }

    def onEvent(allBinaryEventObject : AllBinaryEventObject) : Unit = {
        this.onCaptureEvent(allBinaryEventObject.asInstanceOf[CapturedImageWorkerResultsEvent])
    }

    def run() : Unit = {
        try {
            this.logUtil_SaveCapturedImageWorker.putF(this.commonStrings_SaveCapturedImageWorker.START, this, this.commonStrings_SaveCapturedImageWorker.RUN)
            this.setRunning(true)
            var timeHelper : TimeDelayHelper = new TimeDelayHelper(1000)
            timeHelper.setStartTimeTNT()
            var capturedImageWorkerResultsEvent : CapturedImageWorkerResultsEvent = (this.capturedImageWorkerResultsEventVector.get(0).asInstanceOf[CapturedImageWorkerResultsEvent])
            var screenBufferedImage : BufferedImage = capturedImageWorkerResultsEvent.getBufferedImage()
            new CapturedImageInputOutput().save(screenBufferedImage, capturedImageWorkerResultsEvent.getFrame())
            this.capturedImageWorkerResultsEventVector.remove(capturedImageWorkerResultsEvent)
            this.logUtil_SaveCapturedImageWorker.putF(CommonLabels.getInstance().ELAPSED + timeHelper.getElapsedTNT(), this, this.commonStrings_SaveCapturedImageWorker.RUN)
            this.setRunning(false)
            this.logUtil_SaveCapturedImageWorker.putF(this.commonStrings_SaveCapturedImageWorker.END, this, this.commonStrings_SaveCapturedImageWorker.RUN)
        } catch {
            case e : Exception => {
                this.logUtil_SaveCapturedImageWorker.put(this.commonStrings_SaveCapturedImageWorker.EXCEPTION, this, this.commonStrings_SaveCapturedImageWorker.RUN, e)
            }
        }
    }

}


