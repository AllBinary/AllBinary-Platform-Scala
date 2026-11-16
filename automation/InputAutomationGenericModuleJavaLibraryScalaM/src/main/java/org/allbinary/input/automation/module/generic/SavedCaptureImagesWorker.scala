/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic

import _root_.java.awt.image.BufferedImage
import _root_.java.io.File
import _root_.javax.imageio.ImageIO
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.SavedCaptureGenericProfileDataWorkerType
import _root_.org.allbinary.input.media.image.capture.CaptureWorkerInterface
import _root_.org.allbinary.input.media.image.capture.CapturedBufferedImagesCacheSingleton
import _root_.org.allbinary.input.media.image.capture.CapturedImageWorkerResultsEvent
import _root_.org.allbinary.input.media.image.capture.ProcessingFrameIndexFactory
import _root_.org.allbinary.input.media.image.capture.ScreenScavangerRobot
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.java.number.LongUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler
import _root_.org.allbinary.logic.visual.media.MediaDataFactory
import _root_.org.allbinary.media.image.cache.BufferedImageFrameCacheable
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.time.TimeDelayHelper

class SavedCaptureImagesWorker(param_savedCaptureGenericProfileDataWorkerType : SavedCaptureGenericProfileDataWorkerType) extends BasicEventHandler with CaptureWorkerInterface {
    import _root_.org.allbinary.input.automation.module.generic.SavedCaptureImagesWorker.{*}

    val logUtil_SavedCaptureImagesWorker : LogUtil = LogUtil.getInstance()

    private val commonStrings_SavedCaptureImagesWorker : CommonStrings = CommonStrings.getInstance()

    private var running : Boolean = false

    private var screenScavangerRobot : ScreenScavangerRobot = null

    private var savedCaptureGenericProfileDataWorkerType : SavedCaptureGenericProfileDataWorkerType = null

    //Constructor
    {
        val savedCaptureGenericProfileDataWorkerType : SavedCaptureGenericProfileDataWorkerType = param_savedCaptureGenericProfileDataWorkerType
        this.savedCaptureGenericProfileDataWorkerType = savedCaptureGenericProfileDataWorkerType
        this.screenScavangerRobot = new ScreenScavangerRobot()
        SavedCaptureImagesWorker.index = ProcessingFrameIndexFactory.next()
    }

    def setThread(thread : Thread) : Unit = {
    }

    def isRunning() : Boolean = this.synchronized {
        return this.running
    }

    def setRunning(running : Boolean) : Unit = this.synchronized {
        this.running = running
    }

    def run() : Unit = {
        try {
            this.logUtil_SavedCaptureImagesWorker.putF(this.commonStrings_SavedCaptureImagesWorker.START, this, this.commonStrings_SavedCaptureImagesWorker.RUN)
            this.setRunning(true)
            var timeHelper : TimeDelayHelper = new TimeDelayHelper(1000)

            {
                while (this.isRunning()) {
                    timeHelper.setStartTimeTNT()
                    var frame : _root_.java.lang.Long = new _root_.java.lang.Long(index)
                    var filePathStringBuffer : StringMaker = new StringMaker()
                    filePathStringBuffer.append(this.savedCaptureGenericProfileDataWorkerType.getPath())
                    filePathStringBuffer.append(LongUtil.fillIn(frame.toString()))
                    filePathStringBuffer.append(MediaDataFactory.getInstance().JPG.getExtension())
                    var filePath : String = filePathStringBuffer.toString()
                    this.logUtil_SavedCaptureImagesWorker.putF("Loading Image File Path: " + filePath, this, this.commonStrings_SavedCaptureImagesWorker.RUN)
                    var file : File = new File(filePath)
                    if (file.isFile()) {
                        var bufferedImage : BufferedImage = ImageIO.read(file)
                        SavedCaptureImagesWorker.index += 1
                        CapturedBufferedImagesCacheSingleton.getInstance().add(new BufferedImageFrameCacheable(bufferedImage, frame))
                        var capturedImageEvent : CapturedImageWorkerResultsEvent = new CapturedImageWorkerResultsEvent(this, frame, bufferedImage)
                        this.fireEvent(capturedImageEvent)
                    } else {
                        this.logUtil_SavedCaptureImagesWorker.putF("Could Not Load File: " + filePath, this, this.commonStrings_SavedCaptureImagesWorker.RUN)
                    }
                    this.logUtil_SavedCaptureImagesWorker.putF(CommonLabels.getInstance().ELAPSED + timeHelper.getElapsedTNT(), this, this.commonStrings_SavedCaptureImagesWorker.RUN)
                    this.setRunning(false)
                }
            }
            this.logUtil_SavedCaptureImagesWorker.putF(this.commonStrings_SavedCaptureImagesWorker.END, this, this.commonStrings_SavedCaptureImagesWorker.RUN)
        } catch {
            case e : Exception => {
                this.logUtil_SavedCaptureImagesWorker.put(this.commonStrings_SavedCaptureImagesWorker.EXCEPTION, this, this.commonStrings_SavedCaptureImagesWorker.RUN, e)
            }
        }
    }

}

object SavedCaptureImagesWorker {
    private var index : Long = 0L

}


