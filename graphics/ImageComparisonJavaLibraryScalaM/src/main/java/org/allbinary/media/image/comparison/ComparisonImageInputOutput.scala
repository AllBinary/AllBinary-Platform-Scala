/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison

import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.input.automation.ImageOutputData
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.java.number.LongUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.cache.AutomaticCacheInterface
import _root_.org.allbinary.logic.visual.media.MediaDataFactory
import _root_.org.allbinary.media.image.ImagePersistanceUtil
import _root_.org.allbinary.media.image.cache.BufferedImageCacheable
import _root_.org.allbinary.media.image.io.ImageIOInterface
import _root_.org.allbinary.string.CommonStrings

class ComparisonImageInputOutput() extends ImageIOInterface {
    import _root_.org.allbinary.media.image.comparison.ComparisonImageInputOutput.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def save(frame : _root_.java.lang.Long) : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        if (frame > 0) {
            val imageComparisonResultFrameCacheable : ImageComparisonResultFrameCacheable = (ImageComparisonResultCacheSingleton.getInstance().asInstanceOf[AutomaticCacheInterface]).get(frame).asInstanceOf[ImageComparisonResultFrameCacheable]
            if (imageComparisonResultFrameCacheable != null) {
                val imageComparisonResult : ImageComparisonResult = imageComparisonResultFrameCacheable.getImageComparisonResult()
                this.save(imageComparisonResult, imageComparisonResultFrameCacheable.getFrame())
            } else {
                this.logUtil.putF("Comparison Results Not Available for Output: " + frame, this, commonStrings.SAVE)
            }
        } else {
            this.logUtil.putF("No Comparison Results: for first frame: " + frame, this, commonStrings.SAVE)
        }
    }

    def save(imageComparisonResult : ImageComparisonResult, frame : _root_.java.lang.Long) : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        val filePathStringBuffer : StringMaker = new StringMaker()
        filePathStringBuffer.append(ImageOutputData.SAVE_PATH)
        filePathStringBuffer.append(LongUtil.fillIn(frame.toString()))
        filePathStringBuffer.append(ComparisonImageInputOutput.ROOT_NAME)
        val filePathStringBuffer1 : StringMaker = new StringMaker()
        filePathStringBuffer1.append(filePathStringBuffer.toString())
        filePathStringBuffer1.append("_1")
        filePathStringBuffer1.append(MediaDataFactory.getInstance().JPG.getExtension())
        var filePath1 : String = filePathStringBuffer1.toString()
        val filePathStringBuffer2 : StringMaker = new StringMaker()
        filePathStringBuffer2.append(filePathStringBuffer.toString())
        filePathStringBuffer2.append("_2")
        filePathStringBuffer2.append(MediaDataFactory.getInstance().JPG.getExtension())
        var filePath2 : String = filePathStringBuffer2.toString()
        val bufferedImageCacheables : Array[BufferedImageCacheable] = ChangedPixelsUtil.generateBufferedImageChacheables(imageComparisonResult)
        this.logUtil.putF("Comparison Image File Path 1: " + filePath1, this, commonStrings.SAVE)
        this.logUtil.putF("Comparison Image File Path 2: " + filePath2, this, commonStrings.SAVE)
        val bufferedImageArray : Array[BufferedImage] = new Array[BufferedImage](2)
        bufferedImageArray(0) = bufferedImageCacheables(0).getBufferedImage()
        bufferedImageArray(1) = bufferedImageCacheables(1).getBufferedImage()
        val imagePersistanceUtil : ImagePersistanceUtil = ImagePersistanceUtil.getInstance()
        imagePersistanceUtil.saveWithImageIO(filePath1, bufferedImageArray(0))
        imagePersistanceUtil.saveWithImageIO(filePath2, bufferedImageArray(1))
    }

}

object ComparisonImageInputOutput {
    private val ROOT_NAME : String = "_Changed_"

}


