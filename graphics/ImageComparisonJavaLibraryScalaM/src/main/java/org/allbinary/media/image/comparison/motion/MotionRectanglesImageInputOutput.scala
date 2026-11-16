/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison.motion

import _root_.java.awt.*
import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.input.automation.ImageOutputData
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.java.number.LongUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.cache.AutomaticCacheInterface
import _root_.org.allbinary.logic.util.cache.PoolInterface
import _root_.org.allbinary.logic.visual.media.MediaDataFactory
import _root_.org.allbinary.media.image.ImagePersistanceUtil
import _root_.org.allbinary.media.image.cache.BufferedImageCacheable
import _root_.org.allbinary.media.image.cache.BufferedImageInfo
import _root_.org.allbinary.media.image.cache.BufferedImageInfoFactory
import _root_.org.allbinary.media.image.cache.BufferedImagePoolSingleton
import _root_.org.allbinary.media.image.comparison.ImageComparisonResult
import _root_.org.allbinary.media.image.io.ImageIOInterface
import _root_.org.allbinary.string.CommonStrings

class MotionRectanglesImageInputOutput() extends ImageIOInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    //1,2, or 3
    private val NUMBER_OF_IMAGES : Int = 1

    def save(frame : _root_.java.lang.Long) : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        var motionRectanglesResultsFrameCacheable : MotionRectanglesResultsFrameCacheable = (AllMotionRectanglesResultsCacheSingleton.getInstance().asInstanceOf[AutomaticCacheInterface]).get(frame).asInstanceOf[MotionRectanglesResultsFrameCacheable]
        if (motionRectanglesResultsFrameCacheable != null) {
            var motionRectangles : MotionRectangles = motionRectanglesResultsFrameCacheable.getMotionRectangles()
            this.save(motionRectangles, frame)
            motionRectanglesResultsFrameCacheable = (ConsolidatedMotionRectanglesResultsCacheSingleton.getInstance().asInstanceOf[AutomaticCacheInterface]).get(frame).asInstanceOf[MotionRectanglesResultsFrameCacheable]
            motionRectangles = motionRectanglesResultsFrameCacheable.getMotionRectangles()
            this.save(motionRectangles, frame)
            motionRectanglesResultsFrameCacheable = (ConstrainedMotionRectanglesResultsCacheSingleton.getInstance().asInstanceOf[AutomaticCacheInterface]).get(frame).asInstanceOf[MotionRectanglesResultsFrameCacheable]
            motionRectangles = motionRectanglesResultsFrameCacheable.getMotionRectangles()
            this.save(motionRectangles, frame)
        } else {
            this.logUtil.putF("No Motion Rectangle Results for Frame: " + frame, this, commonStrings.SAVE)
        }
    }

    def save(motionRectangles : MotionRectangles, frame : _root_.java.lang.Long) : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        val filePathStringBuffer : StringMaker = new StringMaker()
        filePathStringBuffer.append(ImageOutputData.SAVE_PATH)
        filePathStringBuffer.append(LongUtil.fillIn(frame.toString()))
        filePathStringBuffer.append("_")
        filePathStringBuffer.append(motionRectangles.getName())
        var filePathStringBuffer1 : StringMaker = new StringMaker()
        filePathStringBuffer1.append(filePathStringBuffer.toString())
        filePathStringBuffer1.append("_1")
        filePathStringBuffer1.append(MediaDataFactory.getInstance().JPG.getExtension())
        var filePathStringBuffer2 : StringMaker = new StringMaker()
        filePathStringBuffer2.append(filePathStringBuffer.toString())
        filePathStringBuffer2.append("_2")
        filePathStringBuffer2.append(MediaDataFactory.getInstance().JPG.getExtension())
        var filePathStringBuffer3 : StringMaker = new StringMaker()
        filePathStringBuffer3.append(filePathStringBuffer.toString())
        filePathStringBuffer3.append(MediaDataFactory.getInstance().JPG.getExtension())
        this.logUtil.putF("Motion Image File Path 1: " + filePathStringBuffer1.toString(), this, commonStrings.SAVE)
        this.logUtil.putF("Motion Image File Path 2: " + filePathStringBuffer2.toString(), this, commonStrings.SAVE)
        this.logUtil.putF("Motion Image File Path 2: " + filePathStringBuffer3.toString(), this, commonStrings.SAVE)
        var bufferedImageCacheables : Array[BufferedImageCacheable] = new Array[BufferedImageCacheable](this.NUMBER_OF_IMAGES)
        var imageComparisonInfo : ImageComparisonResult = motionRectangles.getImageComparisonResult()
        var originalBufferedImage : BufferedImage = imageComparisonInfo.getBufferedImages()(0)
        var bufferedImageInfo : BufferedImageInfo = BufferedImageInfoFactory.getInstance(imageComparisonInfo.imageWidth, imageComparisonInfo.imageHeight, originalBufferedImage.getType())
        var poolInterface : PoolInterface = BufferedImagePoolSingleton.getInstance()

        {
            var index : Int = 0
            while (index < this.NUMBER_OF_IMAGES) {
                bufferedImageCacheables(index) = poolInterface.remove(bufferedImageInfo).asInstanceOf[BufferedImageCacheable]
                index += 1
            }
        }
        bufferedImageCacheables(0).getBufferedImage().setData(imageComparisonInfo.getBufferedImages()(1).getData())
        if (this.NUMBER_OF_IMAGES > 1) {
            bufferedImageCacheables(1).getBufferedImage().setData(imageComparisonInfo.getBufferedImages()(1).getData())
        }
        /*             for(int heightIndex = 0; heightIndex < imageComparisonInfo.imageHeight; heightIndex++)             {                 for(int widthIndex = 0; widthIndex < imageComparisonInfo.imageWidth; widthIndex++)                 {                     int rgb1 = imageComparisonInfo.getBufferedImages()[1].getRGB(widthIndex, heightIndex);// & 0xFF; // assuming grayscale, so r==g==b                                   bufferedImages[0].setRGB(widthIndex, heightIndex, rgb1);                                   if(this.NUMBER_OF_IMAGES > 1)                     {                        int rgb2 = imageComparisonInfo.getBufferedImages()[0].getRGB(widthIndex, heightIndex);// & 0xFF; // assuming grayscale, so r==g==b                        bufferedImages[1].setRGB(widthIndex, heightIndex, rgb2);                     }                 }             }              */
        var bufferedImageGraphicsArray : Array[Graphics] = null
        bufferedImageGraphicsArray = new Array[Graphics](this.NUMBER_OF_IMAGES)

        {
            var index : Int = 0
            while (index < this.NUMBER_OF_IMAGES) {
                bufferedImageGraphicsArray(index) = bufferedImageCacheables(index).getBufferedImage().getGraphics()
                index += 1
            }
        }
        val rectangelList : BasicArrayList = motionRectangles.getVector()
        val size : Int = rectangelList.size()

        {
            var index2 : Int = 0
            while (index2 < size) {
                var motionRectangle : MotionRectangle = rectangelList.get(index2).asInstanceOf[MotionRectangle]
                var rectangle : Rectangle = motionRectangle.getRectangle()

                {
                    var index : Int = 0
                    while (index < this.NUMBER_OF_IMAGES) {
                        bufferedImageGraphicsArray(index).setColor(Color.ORANGE)
                        bufferedImageGraphicsArray(index).drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height)
                        index += 1
                    }
                }
                index2 += 1
            }
        }
        val imagePersistanceUtil : ImagePersistanceUtil = ImagePersistanceUtil.getInstance()
        if (this.NUMBER_OF_IMAGES > 1) {
            imagePersistanceUtil.saveWithImageIO(filePathStringBuffer1.toString(), bufferedImageCacheables(1).getBufferedImage())
        }
        //0 frame is the second image
        imagePersistanceUtil.saveWithImageIO(filePathStringBuffer2.toString(), bufferedImageCacheables(0).getBufferedImage())
        if (this.NUMBER_OF_IMAGES > 2) {
            imagePersistanceUtil.saveWithImageIO(filePathStringBuffer3.toString(), bufferedImageCacheables(2).getBufferedImage())
        }
    }

}


