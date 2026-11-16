/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.search

import _root_.java.awt.image.BufferedImage
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

class ImageComparisonSearchWorker(param_imageSearchConstraintsInterface : ImageComparisonSearchConstraintsInterface) extends BasicEventHandler with ImageComparisonResultsListener {

    val logUtil_ImageComparisonSearchWorker : LogUtil = LogUtil.getInstance()

    val commonStrings_ImageComparisonSearchWorker : CommonStrings = CommonStrings.getInstance()

    private var imageComparisonInfoVector : BasicArrayList = null

    private var index : Long = 0L

    private var running : Boolean = false

    private var imageSearchConstraintsInterface : ImageComparisonSearchConstraintsInterface = null

    //Constructor
    {
        val imageSearchConstraintsInterface : ImageComparisonSearchConstraintsInterface = param_imageSearchConstraintsInterface
        this.imageComparisonInfoVector = new BasicArrayListD()
        this.imageSearchConstraintsInterface = imageSearchConstraintsInterface
    }

    def onImageComparisonResultsEvent(imageComparisonResultsEvent : ImageComparisonResultsEvent) : Unit = {
        this.imageComparisonInfoVector.add(imageComparisonResultsEvent.getImageComparisonResult())
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
            this.logUtil_ImageComparisonSearchWorker.putF(this.commonStrings_ImageComparisonSearchWorker.START, this, this.commonStrings_ImageComparisonSearchWorker.RUN)
            this.setRunning(true)
            var timeHelper : TimeDelayHelper = new TimeDelayHelper(1000)
            timeHelper.setStartTimeTNT()
            var imageComparisonInfo : ImageComparisonResult = this.imageComparisonInfoVector.get(0).asInstanceOf[ImageComparisonResult]
            this.logUtil_ImageComparisonSearchWorker.putF(imageComparisonInfo.toString(), this, this.commonStrings_ImageComparisonSearchWorker.RUN)
            var latestBufferedImage : BufferedImage = imageComparisonInfo.getBufferedImages()(1)
            //this.fireEvent(new ImageComparisonSearchResultsEvent(this, imageSearch));
            this.imageComparisonInfoVector.remove(imageComparisonInfo)
            this.index += 1
            this.logUtil_ImageComparisonSearchWorker.putF(CommonLabels.getInstance().ELAPSED + timeHelper.getElapsedTNT(), this, this.commonStrings_ImageComparisonSearchWorker.RUN)
            this.setRunning(false)
            this.logUtil_ImageComparisonSearchWorker.putF(this.commonStrings_ImageComparisonSearchWorker.END, this, this.commonStrings_ImageComparisonSearchWorker.RUN)
        } catch {
            case e : Exception => {
                this.logUtil_ImageComparisonSearchWorker.put(this.commonStrings_ImageComparisonSearchWorker.EXCEPTION, this, this.commonStrings_ImageComparisonSearchWorker.RUN, e)
            }
        }
    }

}


