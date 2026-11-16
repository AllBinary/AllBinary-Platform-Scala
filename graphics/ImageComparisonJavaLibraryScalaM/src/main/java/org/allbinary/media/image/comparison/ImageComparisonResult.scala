/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison

import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.media.image.ImageUtil
import _root_.org.allbinary.media.image.comparison.pixel.PixelDelta
import _root_.org.allbinary.string.CommonStrings

class ImageComparisonResult(param_name : String, param_bufferedImage : BufferedImage, param_bufferedImage2 : BufferedImage, param_frameOne : _root_.java.lang.Long, param_frameTwo : _root_.java.lang.Long, param_tolerance : Int) {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val bufferedImages : Array[BufferedImage] = new Array[BufferedImage](2)

    var name : String = null

    var isSameHeight : Boolean = false

    var isSameWidth : Boolean = false

    var imageHeight : Int = 0

    var imageWidth : Int = 0

    private var nonMatchingPixelVector : BasicArrayList = null

    private var frameOne : _root_.java.lang.Long = null

    private var frameTwo : _root_.java.lang.Long = null

    var pixelsThatMatch : Int = 0

    var pixelsIgnored : Int = 0

    private var tolerance : Int = 0

    private var matchingPercent : Float = -1

    //Constructor
    {
        val name : String = param_name
        val bufferedImage : BufferedImage = param_bufferedImage
        val bufferedImage2 : BufferedImage = param_bufferedImage2
        val frameOne : _root_.java.lang.Long = param_frameOne
        val frameTwo : _root_.java.lang.Long = param_frameTwo
        val tolerance : Int = param_tolerance
        this.name = name
        this.nonMatchingPixelVector = new BasicArrayListD()
        this.bufferedImages(0) = bufferedImage
        this.bufferedImages(1) = bufferedImage2
        this.frameOne = frameOne
        this.frameTwo = frameTwo
        this.setTolerance(0)
        var imageHeight : Int = bufferedImage.getHeight()
        var imageWidth : Int = bufferedImage.getWidth()
        if (bufferedImage.getHeight() != bufferedImage2.getHeight()) {
            this.isSameHeight = false
            if (imageHeight > bufferedImage2.getHeight()) {
                imageHeight = bufferedImage2.getHeight()
            }
        } else {
            this.isSameHeight = true
        }
        if (bufferedImage.getWidth() != bufferedImage2.getWidth()) {
            this.isSameWidth = false
            if (imageWidth > bufferedImage2.getWidth()) {
                imageWidth = bufferedImage2.getWidth()
            }
        } else {
            this.isSameWidth = true
        }
        this.imageWidth = imageWidth
        this.imageHeight = imageHeight
        if (!this.isSameWidth || !this.isSameHeight) {
            val imageUtil : ImageUtil = ImageUtil.getInstance()
            this.logUtil.putF("Images were not the same size? Most likely a resolution change.", this, this.commonStrings.CONSTRUCTOR)
            this.logUtil.putF("1: " + imageUtil.toString(bufferedImage), this, this.commonStrings.CONSTRUCTOR)
            this.logUtil.putF("2: " + imageUtil.toString(bufferedImage2), this, this.commonStrings.CONSTRUCTOR)
        }
    }

    def getMatchingPercent() : Float = {
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
        return new StringMaker().append("ImageComparisonInfo: ").append(this.name).append(" Number Of Matching Pixels: ").appendint(this.pixelsThatMatch).append("\nNumber Of Non-Matching Pixels: ").appendint(this.getNonMatchingPixelVector().size()).append("\nNumber Of Pixels Ignored: ").appendint(this.pixelsIgnored).append("\nMatching Percentage: ").appendfloat(this.getMatchingPercent()).toString()
    }

    def getBufferedImages() : Array[BufferedImage] = {
        return this.bufferedImages
    }

    def getTolerance() : Int = {
        return this.tolerance
    }

    private def setTolerance(tolerance : Int) : Unit = {
        this.tolerance = tolerance
    }

    def getFrameOne() : _root_.java.lang.Long = {
        return this.frameOne
    }

    def getFrameTwo() : _root_.java.lang.Long = {
        return this.frameTwo
    }

}


