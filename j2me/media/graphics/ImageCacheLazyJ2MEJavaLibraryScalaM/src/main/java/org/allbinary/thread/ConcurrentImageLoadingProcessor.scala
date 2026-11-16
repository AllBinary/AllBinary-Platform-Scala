/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.thread

import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvas
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import _root_.org.allbinary.image.ImageCache
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author User  */
class ConcurrentImageLoadingProcessor(param_imageCache : ImageCache) extends BaseImageLoadingProcessor {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var runnable : ABRunnable = null

    //Constructor
    {
        val imageCache : ImageCache = param_imageCache
        this.runnable = new ImageCacheRunnable(imageCache)
    }

    class ImageCacheRunnable(param_imageCache : ImageCache) extends ABRunnable {

        private[ImageCacheRunnable] var imageCache : ImageCache = null

        //Constructor
        {
            val imageCache : ImageCache = param_imageCache
            this.imageCache = imageCache
        }

        override def run() : Unit = {
            val logUtil : LogUtil = LogUtil.getInstance()
            try {
                this.setRunning(true)
                //logUtil.putF(this.commonStrings.START, this, this.commonStrings.RUN);
                this.imageCache.waitForLoadNow()
                //logUtil.putF("found animation that has attempted to paint so load animations and images", this, this.commonStrings.RUN);
                this.imageCache.loadImages()
                this.imageCache.loadRemainingAnimations()
                this.setRunning(false)
                val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
                if (!progressCanvas.inProgress) {
                    progressCanvas.endFromInitialLazyLoadingComplete()
                }
            } catch {
                case e : Exception => {
                    this.setRunning(false)
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
                }
            }
        }

    }

    override def runTask() : Unit = {
        if (!this.runnable.isRunning()) {
            ImageThreadPool.getInstance().runTask(this.runnable)
        }
    }

}


