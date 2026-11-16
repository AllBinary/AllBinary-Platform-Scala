/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.search

import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.media.image.ImageUtil
import _root_.org.allbinary.media.image.comparison.pixel.PixelDelta
import _root_.org.allbinary.string.CommonStrings

class ImageComparisonSearch(param_bufferedImage : BufferedImage, param_bufferedImage2 : BufferedImage, param_tolerance : Int) {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    var isSameHeight : Boolean = false

    var isSameWidth : Boolean = false

    var pixelsThatMatch : Int = 0

    var pixelsIgnored : Int = 0

    var imageHeight : Int = 0

    var imageWidth : Int = 0

    private var tolerance : Int = 0

    private var nonMatchingPixelVector : BasicArrayList = null

    private var bufferedImages : Array[BufferedImage] = null

    private var matchingPercent : Float = -1

    //Constructor
    {
        val bufferedImage : BufferedImage = param_bufferedImage
        val bufferedImage2 : BufferedImage = param_bufferedImage2
        val tolerance : Int = param_tolerance
        this.nonMatchingPixelVector = new BasicArrayListD()
        this.setBufferedImages(new Array[BufferedImage](2))
        this.getBufferedImages()(0) = bufferedImage
        this.getBufferedImages()(1) = bufferedImage2
        this.imageHeight = bufferedImage.getHeight()
        this.imageWidth = bufferedImage.getWidth()
        if (bufferedImage.getHeight() != bufferedImage2.getHeight()) {
            this.isSameHeight = false
            if (this.imageHeight > bufferedImage2.getHeight()) {
                this.imageHeight = bufferedImage2.getHeight()
            }
        } else {
            this.isSameHeight = true
        }
        if (bufferedImage.getWidth() != bufferedImage2.getWidth()) {
            this.isSameWidth = false
            if (this.imageWidth > bufferedImage2.getWidth()) {
                this.imageWidth = bufferedImage2.getWidth()
            }
        } else {
            this.isSameWidth = true
        }
        if (!this.isSameWidth || !this.isSameHeight) {
            val imageUtil : ImageUtil = ImageUtil.getInstance()
            this.logUtil.putF("Images were not the same size? Most likely a resolution change.", this, this.commonStrings.CONSTRUCTOR)
            this.logUtil.putF("1: " + imageUtil.toString(bufferedImage), this, this.commonStrings.CONSTRUCTOR)
            this.logUtil.putF("2: " + imageUtil.toString(bufferedImage2), this, this.commonStrings.CONSTRUCTOR)
        }
    }

    private def getMatchingPercent() : Float = {
        if (this.matchingPercent == -1) {
            this.matchingPercent = this.pixelsThatMatch.toFloat / (this.imageWidth * this.imageHeight)
        }
        return this.matchingPercent
    }

    def add(pixel : PixelDelta) : Unit = {
        this.nonMatchingPixelVector.add(pixel)
    }

    def getNonMatchingPixelVector() : BasicArrayList = {
        return this.nonMatchingPixelVector
    }

    override def toString() : String = {
        return ((((((("ImageComparisonInfo: " + " Number Of Matching Pixels: ") + this.pixelsThatMatch) + "\nNumber Of Non-Matching Pixels: ") + this.getNonMatchingPixelVector().size()) + "\nNumber Of Pixels Ignored: ") + this.pixelsIgnored) + "\nMatching Percentage: ") + this.getMatchingPercent()
    }

    def getBufferedImages() : Array[BufferedImage] = {
        return this.bufferedImages
    }

    private def setBufferedImages(bufferedImages : Array[BufferedImage]) : Unit = {
        this.bufferedImages = bufferedImages
    }

    def getTolerance() : Int = {
        return this.tolerance
    }

    def setTolerance(tolerance : Int) : Unit = {
        this.tolerance = tolerance
    }

}


