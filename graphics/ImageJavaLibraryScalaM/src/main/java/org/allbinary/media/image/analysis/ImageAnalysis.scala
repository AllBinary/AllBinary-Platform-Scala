/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.analysis

import _root_.java.awt.*
import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.graphics.color.ColorCacheFactory
import _root_.org.allbinary.graphics.color.ColorCacheable
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings

class ImageAnalysis private() {
    import _root_.org.allbinary.media.image.analysis.ImageAnalysis.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def process(bufferedImageArray : Array[BufferedImage], colorRangeInterface : ColorRangeInterface) : Array[ImageAnalysisResults] = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        this.logUtil.putF(CommonLabels.getInstance().START + colorRangeInterface.toString(), this, commonStrings.PROCESS)
        var imageAnalysisResultsArray : Array[ImageAnalysisResults] = new Array[ImageAnalysisResults](bufferedImageArray.length)

        {
            var index : Int = 0
            while (index < bufferedImageArray.length) {
                imageAnalysisResultsArray(index) = ImageAnalysis.process(bufferedImageArray(index), colorRangeInterface)
                index += 1
            }
        }
        return imageAnalysisResultsArray
    }

}

object ImageAnalysis {
    private val instance : ImageAnalysis = new ImageAnalysis()

    /**      * @return the instance      */
    def getInstance() : ImageAnalysis = {
        return ImageAnalysis.instance
    }

    def process(bufferedImage : BufferedImage, colorRangeInterface : ColorRangeInterface) : ImageAnalysisResults = {
        var imageAnalysisResults : ImageAnalysisResults = new ImageAnalysisResults()
        var redTotal : Long = 0
        var greenTotal : Long = 0
        var blueTotal : Long = 0

        {
            var indexY : Int = 0
            while (indexY < bufferedImage.getHeight()) {

                {
                    var indexX : Int = 0
                    while (indexX < bufferedImage.getWidth()) {
                        var keyInteger : Integer = Integer.valueOf(bufferedImage.getRGB(indexX, indexY))
                        var colorCacheable : ColorCacheable = ColorCacheFactory.getInstance().get(keyInteger).asInstanceOf[ColorCacheable]
                        var color : Color = colorCacheable.getColor()
                        ImageAnalysis.processColorRangeResults(imageAnalysisResults, colorRangeInterface, color)
                        ImageAnalysis.processImageColorResults(imageAnalysisResults.getImageColorResults(), colorRangeInterface, color)
                        redTotal += color.getRed()
                        greenTotal += color.getGreen()
                        blueTotal += color.getBlue()
                        indexX += 1
                    }
                }
                indexY += 1
            }
        }
        var totalPixels : Long = imageAnalysisResults.getImageColorRangeResults().getTotalPixelsChecked()
        val colorAverage : ColorAverage = imageAnalysisResults.getImageColorResults().getColorAverage()
        colorAverage.setAvgRed(redTotal.toFloat / totalPixels)
        colorAverage.setAvgGreen(greenTotal.toFloat / totalPixels)
        colorAverage.setAvgBlue(blueTotal.toFloat / totalPixels)
        return imageAnalysisResults
    }

    private def processColorRangeResults(imageAnalysisResults : ImageAnalysisResults, colorRangeInterface : ColorRangeInterface, color : Color) : Unit = {
        if (colorRangeInterface.isInRange(color)) {
            imageAnalysisResults.getImageColorRangeResults().addMatchingPixelsChecked()
        } else {
        }
        imageAnalysisResults.getImageColorRangeResults().addTotalPixelsChecked()
    }

    private def processImageColorResults(imageColorResults : ImageColorResults, colorRangeInterface : ColorRangeInterface, color : Color) : Unit = {
        if (color.getRed() < imageColorResults.getColorRange().getMinRed()) {
            imageColorResults.getColorRange().setMinRed(color.getRed())
        }
        if (color.getGreen() < imageColorResults.getColorRange().getMinGreen()) {
            imageColorResults.getColorRange().setMinGreen(color.getGreen())
        }
        if (color.getBlue() < imageColorResults.getColorRange().getMinBlue()) {
            imageColorResults.getColorRange().setMinBlue(color.getBlue())
        }
        if (color.getRed() > imageColorResults.getColorRange().getMaxRed()) {
            imageColorResults.getColorRange().setMaxRed(color.getRed())
        }
        if (color.getGreen() > imageColorResults.getColorRange().getMaxGreen()) {
            imageColorResults.getColorRange().setMaxGreen(color.getGreen())
        }
        if (color.getBlue() > imageColorResults.getColorRange().getMaxBlue()) {
            imageColorResults.getColorRange().setMaxBlue(color.getBlue())
        }
    }

}


