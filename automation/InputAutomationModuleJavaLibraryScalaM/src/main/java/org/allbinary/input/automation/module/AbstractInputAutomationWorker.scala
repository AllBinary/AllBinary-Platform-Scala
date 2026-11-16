/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module

import _root_.org.allbinary.input.media.image.capture.CaptureWorkerInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.media.image.comparison.ImageComparisonWorker
import _root_.org.allbinary.media.image.comparison.motion.MotionRectanglesWorker
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.thread.RunnableInterface
import _root_.org.allbinary.time.TimeDelayHelper

class AbstractInputAutomationWorker(param_inputAutomationActionInterface : InputAutomationActionInterface) extends RunnableInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var index : Long = 0L

    private var running : Boolean = false

    private var inputAutomationActionInterface : InputAutomationActionInterface = null

    private var captureWorkerInterface : CaptureWorkerInterface = null

    private var imageComparisonWorker : ImageComparisonWorker = null

    private var motionRectanglesWorker : MotionRectanglesWorker = null

    private var captureThread : Thread = null

    //Constructor
    {
        val inputAutomationActionInterface : InputAutomationActionInterface = param_inputAutomationActionInterface
    }

    /*     public void onCaptureEvent(         CapturedImageWorkerResultsEvent capturedImageWorkerResultsEvent)     {         try         {             this.logUtil.putF("Recieved Event", this, "onCaptureEvent");         }         catch (Exception e)         {             this.logUtil.put(this.commonStrings.EXCEPTION, this, "onCaptureEvent", e);         }     }          public void onEvent(AllBinaryEventObject allBinaryEventObject)     {         this.onCaptureEvent((CapturedImageWorkerResultsEvent)         allBinaryEventObject);     }     */
    def setThread(thread : Thread) : Unit = {
    }

    def isRunning() : Boolean = this.synchronized {
        return this.running
    }

    def setRunning(running : Boolean) : Unit = this.synchronized {
        this.running = running
    }

    def isAnyDataWorkerRunning() : Boolean = this.synchronized {
        if ((this.captureThread != null) && (((this.captureThread.isAlive() || this.getCaptureWorker().isRunning()) || this.getMotionRectanglesWorker().isRunning()) || this.getImageComparisonWorker().isRunning())) {
            return true
        }
        return false
    }

    def startDataWorkers() : Unit = this.synchronized {
        if (!isAnyDataWorkerRunning()) {
            this.captureThread = new Thread(this.getCaptureWorker())
            this.logUtil.putF("Starting CaptureWorkers - Need more images - Thread State: " + this.captureThread.getState().toString(), this, "startCaptureWorkers")
            this.captureThread.start()
        }
    }

    def waitForDataWorkers() : Unit = this.synchronized {

        {
            while (isAnyDataWorkerRunning()) {
                this.logUtil.putF("Waiting", this, this.commonStrings.RUN)
                Thread.sleep(250)
            }
        }
    }

    def stopDataWorkers() : Unit = {
        this.getCaptureWorker().setRunning(false)
    }

    def process() : Unit = {
        throw new RuntimeException()
    }

    def run() : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.RUN)
            this.setRunning(true)
            var timeHelper : TimeDelayHelper = new TimeDelayHelper(1000)
            /*         iterator = robotVector;         while(iterator.hasNext())         {             InputRobotInterface robot = (InputRobotInterface) iterator.next();             basicAttackInterface.test(robot);         }          */

            {
                while (this.isRunning()) {
                    timeHelper.setStartTimeTNT()
                    this.process()
                    this.index += 1
                    this.logUtil.putF(((CommonLabels.getInstance().ELAPSED + timeHelper.getElapsedTNT()) + " Index: ") + this.index, this, this.commonStrings.RUN)
                }
            }
            this.stopDataWorkers()
            this.waitForDataWorkers()
            this.logUtil.putF(this.commonStrings.END, this, this.commonStrings.RUN)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.RUN, e)
            }
        }
    }

    def getInputAutomationActionInterface() : InputAutomationActionInterface = {
        return this.inputAutomationActionInterface
    }

    def setInputAutomationActionInterface(inputAutomationActionInterface : InputAutomationActionInterface) : Unit = {
        this.inputAutomationActionInterface = inputAutomationActionInterface
    }

    def getCaptureWorker() : CaptureWorkerInterface = {
        return this.captureWorkerInterface
    }

    def setCaptureWorker(captureWorkerInterface : CaptureWorkerInterface) : Unit = {
        this.captureWorkerInterface = captureWorkerInterface
    }

    def getImageComparisonWorker() : ImageComparisonWorker = {
        return this.imageComparisonWorker
    }

    def setImageComparisonWorker(imageComparisonWorker : ImageComparisonWorker) : Unit = {
        this.imageComparisonWorker = imageComparisonWorker
    }

    def getMotionRectanglesWorker() : MotionRectanglesWorker = {
        return this.motionRectanglesWorker
    }

    def setMotionRectanglesWorker(motionRectanglesWorker : MotionRectanglesWorker) : Unit = {
        this.motionRectanglesWorker = motionRectanglesWorker
    }

}


