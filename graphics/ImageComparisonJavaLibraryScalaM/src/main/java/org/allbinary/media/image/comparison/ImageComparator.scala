/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison

import _root_.java.awt.*
import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.color.ColorCacheFactory
import _root_.org.allbinary.graphics.color.ColorCacheable
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.util.cache.AutomaticCacheInterface
import _root_.org.allbinary.media.image.comparison.pixel.PixelDeltaFactory

class ImageComparator(param_imageComparatorConstraintsInterface : ImageComparatorConstraintsInterface) {

    private var imageComparatorConstraintsInterface : ImageComparatorConstraintsInterface = null

    //Constructor
    {
        val imageComparatorConstraintsInterface : ImageComparatorConstraintsInterface = param_imageComparatorConstraintsInterface
        this.imageComparatorConstraintsInterface = imageComparatorConstraintsInterface
    }

    private def process(imageComparisonInfo : ImageComparisonResult, point : GPoint) : Unit = {
        val isCollsionWithAvoidRectangles : Boolean = this.imageComparatorConstraintsInterface.isCollisionWithAvoidRectangles(point)
        /*       if(isCollsionWithAvoidRectangles)       {       this.logUtil.putF("Pixel Collided with 1 or more avoid Rectangle(s): " +       point, this, "compare");       }        */
        if (!isCollsionWithAvoidRectangles) {
            val rgb1 : Int = imageComparisonInfo.getBufferedImages()(0).getRGB(point.getX(), point.getY())
            // & 0xFF; // assuming grayscale, so r==g==b
            val rgb2 : Int = imageComparisonInfo.getBufferedImages()(1).getRGB(point.getX(), point.getY())
            // & 0xFF; // assuming grayscale, so r==g==b
            val automaticCacheInterface : AutomaticCacheInterface = ColorCacheFactory.getInstance()
            val colorInteger : Integer = Integer.valueOf(rgb1)
            val colorCacheable : ColorCacheable = automaticCacheInterface.get(colorInteger).asInstanceOf[ColorCacheable]
            val color : Color = colorCacheable.getColor()
            val colorInteger2 : Integer = Integer.valueOf(rgb2)
            val colorCacheable2 : ColorCacheable = automaticCacheInterface.get(colorInteger).asInstanceOf[ColorCacheable]
            val color2 : Color = colorCacheable.getColor()
            if (this.imageComparatorConstraintsInterface.isColorAllowed(0, point, color) || this.imageComparatorConstraintsInterface.isColorAllowed(1, point, color2)) {
                if (Math.abs(rgb1 - rgb2) <= imageComparisonInfo.getTolerance()) {
                    imageComparisonInfo.pixelsThatMatch += 1
                } else {
                    imageComparisonInfo.add(PixelDeltaFactory.getInstance(point.getX(), point.getY(), rgb1, rgb2))
                }
            }
        } else {
            imageComparisonInfo.pixelsIgnored += 1
        }
    }

    def compare(bufferedImage1 : BufferedImage, bufferedImage2 : BufferedImage, frameOne : _root_.java.lang.Long, frameTwo : _root_.java.lang.Long, tolerance : Int) : ImageComparisonResult = {
        return this.compare(bufferedImage1, bufferedImage2, frameOne, frameTwo, tolerance, StringUtil.getInstance().EMPTY_STRING)
    }

    def compare(bufferedImage1 : BufferedImage, bufferedImage2 : BufferedImage, frameOne : _root_.java.lang.Long, frameTwo : _root_.java.lang.Long, tolerance : Int, name : String) : ImageComparisonResult = {
        //this.logUtil.putF(this.commonStrings.START, this, "compare");
        if ((bufferedImage1 == null) || (bufferedImage2 == null)) {
            throw new Exception("Input images must not be null.")
        }
        val imageComparisonInfo : ImageComparisonResult = new ImageComparisonResult(name, bufferedImage1, bufferedImage2, frameOne, frameTwo, tolerance)

        {
            var indexY : Int = 0
            while (indexY < imageComparisonInfo.imageHeight) {

                {
                    var indexX : Int = 0
                    scala.util.boundary { (break_N72296 : scala.util.boundary.Label[Unit]) ?=>
                        while (indexX < imageComparisonInfo.imageWidth) {
                            this.process(imageComparisonInfo, PointFactory.getInstance().createXY(indexX, indexY))
                            if (imageComparisonInfo.getNonMatchingPixelVector().size() > this.imageComparatorConstraintsInterface.getMaxNonMatchingPixelDeltas()) {
                                scala.util.boundary.break()(using break_N72296)
                            }
                            indexX += 1
                        }
                    }
                }
                indexY += 1
            }
        }
        //this.logUtil.putF(this.commonStrings.END, this, "compare");
        return imageComparisonInfo
    }

}


