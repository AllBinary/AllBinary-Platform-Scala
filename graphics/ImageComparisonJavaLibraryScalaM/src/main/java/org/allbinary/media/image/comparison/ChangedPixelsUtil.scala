/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison

import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.util.cache.PoolInterface
import _root_.org.allbinary.media.image.cache.BufferedImageCacheable
import _root_.org.allbinary.media.image.cache.BufferedImageInfo
import _root_.org.allbinary.media.image.cache.BufferedImageInfoFactory
import _root_.org.allbinary.media.image.cache.BufferedImagePoolSingleton
import _root_.org.allbinary.media.image.comparison.pixel.PixelDelta

class ChangedPixelsUtil private() {
    import _root_.org.allbinary.media.image.comparison.ChangedPixelsUtil.{*}

}

object ChangedPixelsUtil {
    private val START_X : Int = 0

    private val START_Y : Int = 0

    private val OFFSET : Int = 0

    private val SCAN_SIZE : Int = 0

    private val CLEAR_INT_ARRAY : Array[Int] = new Array[Int](1800 * 1600)

    //GenerateImageWithBoundingBoxesAroundMovingArtifacts
    def generateBufferedImageChacheables(imageComparisonInfo : ImageComparisonResult) : Array[BufferedImageCacheable] = {
        var bufferedImageCacheables : Array[BufferedImageCacheable] = null
        var originalBufferedImage : BufferedImage = imageComparisonInfo.getBufferedImages()(0)
        bufferedImageCacheables = new Array[BufferedImageCacheable](2)
        var bufferedImageInfo : BufferedImageInfo = BufferedImageInfoFactory.getInstance(imageComparisonInfo.imageWidth, imageComparisonInfo.imageHeight, originalBufferedImage.getType())
        var poolInterface : PoolInterface = BufferedImagePoolSingleton.getInstance()

        {
            var index : Int = 0
            while (index < bufferedImageCacheables.length) {
                var bufferedImageCacheable : BufferedImageCacheable = poolInterface.remove(bufferedImageInfo).asInstanceOf[BufferedImageCacheable]
                bufferedImageCacheables(index) = bufferedImageCacheable
                //clear the image
                bufferedImageCacheables(index).getBufferedImage().setRGB(ChangedPixelsUtil.START_X, ChangedPixelsUtil.START_Y, bufferedImageInfo.getWidth(), bufferedImageInfo.getHeight(), ChangedPixelsUtil.CLEAR_INT_ARRAY, ChangedPixelsUtil.OFFSET, ChangedPixelsUtil.SCAN_SIZE)
                index += 1
            }
        }
        val vector : BasicArrayList = imageComparisonInfo.getNonMatchingPixelVector()
        val size : Int = vector.size()

        {
            var index : Int = 0
            while (index < size) {
                var pixelDelta : PixelDelta = vector.get(index).asInstanceOf[PixelDelta]
                if (pixelDelta.getColorDelta() == null) {
                    System.out.print("ColorDelta")
                    System.exit(0)
                }
                bufferedImageCacheables(0).getBufferedImage().setRGB(pixelDelta.getPoint().getX(), pixelDelta.getPoint().getY(), pixelDelta.getColorDelta().getRgb1())
                bufferedImageCacheables(1).getBufferedImage().setRGB(pixelDelta.getPoint().getX(), pixelDelta.getPoint().getY(), pixelDelta.getColorDelta().getRgb2())
                index += 1
            }
        }
        return bufferedImageCacheables
    }

}


