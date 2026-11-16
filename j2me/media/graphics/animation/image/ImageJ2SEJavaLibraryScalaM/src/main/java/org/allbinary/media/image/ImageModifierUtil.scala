/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.java.awt.image.BufferedImage
import _root_.java.awt.image.ColorModel
import _root_.java.awt.image.WritableRaster
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author User  */
class ImageModifierUtil {
    import _root_.org.allbinary.media.image.ImageModifierUtil.{*}

    private val imageUtil : ImageUtil = ImageUtil.getInstance()

    //private final int[] alphaArray = new int[MAX_WIDTH * MAX_HEIGHT];
    private val colorArray : Array[Int] = new Array[Int](1)

    def setBasicColorP(basicColor : BasicColor) : Unit = {
    }

    def setColor(unusedOriginalImage : Image, image : Image, imageIndex : Int, basicColor : BasicColor) : Unit = {
        val newBufferedImage : BufferedImage = this.imageUtil.getBufferedImage(image)
        //java.awt.Image newBufferedImage;
        val r : Short = basicColor.red
        val g : Short = basicColor.green
        val b : Short = basicColor.blue
        val width : Int = image.getWidth()
        val height : Int = image.getHeight()
        var colorModel : ColorModel = null
        var dataElements : Object = null
        var ax : Int = 0
        var rx : Int = 0
        var gx : Int = 0
        var bx : Int = 0

        {
            var index : Int = 0
            while (index < width) {

                {
                    var index2 : Int = 0
                    while (index2 < height) {
                        colorModel = newBufferedImage.getColorModel()
                        dataElements = newBufferedImage.getRaster().getDataElements(index, index2, null)
                        ax = colorModel.getAlpha(dataElements)
                        rx = colorModel.getRed(dataElements)
                        gx = colorModel.getGreen(dataElements)
                        bx = colorModel.getBlue(dataElements)
                        if (((rx != 0) || (gx != 0)) || (bx != 0)) {
                            newBufferedImage.setRGB(index, index2, (((ax << 24) | (r << 16)) | (g << 8)) | (b))
                        }
                        index2 += 1
                    }
                }
                index += 1
            }
        }
    }

    def changeColor(unusedOriginalImage : Image, image : Image, imageIndex : Int, basicColor : BasicColor) : Unit = {
        val newBufferedImage : BufferedImage = this.imageUtil.getBufferedImage(image)
        //java.awt.Image newBufferedImage;
        val MAX : Float = 255
        val r : Float = (basicColor.red.toFloat) / MAX
        val g : Float = (basicColor.green.toFloat) / MAX
        val b : Float = (basicColor.blue.toFloat) / MAX
        val width : Int = image.getWidth()
        val height : Int = image.getHeight()
        var colorModel : ColorModel = null
        var dataElements : Object = null
        var ax : Int = 0
        var rx : Int = 0
        var gx : Int = 0
        var bx : Int = 0

        {
            var index : Int = 0
            while (index < width) {

                {
                    var index2 : Int = 0
                    while (index2 < height) {
                        colorModel = newBufferedImage.getColorModel()
                        dataElements = newBufferedImage.getRaster().getDataElements(index, index2, null)
                        ax = colorModel.getAlpha(dataElements)
                        rx = colorModel.getRed(dataElements)
                        gx = colorModel.getGreen(dataElements)
                        bx = colorModel.getBlue(dataElements)
                        //ax *= a;
                        rx = (rx * r).toInt
                        gx = (gx * g).toInt
                        bx = (bx * b).toInt
                        newBufferedImage.setRGB(index, index2, (((ax << 24) | (rx << 16)) | (gx << 8)) | (bx))
                        index2 += 1
                    }
                }
                index += 1
            }
        }
    }

    def setAlpha(unusedOriginalImage : Image, image : Image, imageIndex : Int, alphaInt : Int) : Unit = {
        var alpha : Byte = alphaInt.toByte
        val newBufferedImage : BufferedImage = this.imageUtil.getBufferedImage(image)
        //java.awt.Image newBufferedImage;
        val width : Int = image.getWidth()
        val height : Int = image.getHeight()
        val raster : WritableRaster = newBufferedImage.getAlphaRaster()
        //raster.getPixels(0, 0, width, height, alphaArray);

        {
            var index : Int = 0
            while (index < width) {

                {
                    var index2 : Int = 0
                    while (index2 < height) {
                        raster.getPixel(index, index2, this.colorArray)
                        this.colorArray(0) = alpha & this.colorArray(0)
                        raster.setPixel(index, index2, this.colorArray)
                        index2 += 1
                    }
                }
                index += 1
            }
        }
    }

    def getImageArray(originalImageArray : Array[Image]) : Array[Image] = {
        //return originalImageArray;
        try {
            val newImageArray : Array[Image] = new Array[Image](originalImageArray.length)
            val size : Int = newImageArray.length
            var originalImage : Image = null

            {
                var index : Int = 0
                while (index < size) {
                    originalImage = originalImageArray(index)
                    val image : Image = ImageCreationUtil.getInstance().createImageWH(originalImage.getWidth(), originalImage.getHeight())
                    image.getGraphics().drawImage(originalImage, 0, 0, Anchor.TOP_LEFT)
                    newImageArray(index) = image
                    index += 1
                }
            }
            return newImageArray
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                PreLogUtil.putOE(commonStrings.EXCEPTION, this, "getImageArray", e)
                return originalImageArray
            }
        }
        throw new IllegalStateException()
    }

    def handleImage(imageArray : Array[Image], index : Int, image : Image) : Unit = {
    }

    def reset() : Unit = {
    }

}

object ImageModifierUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : ImageModifierUtil = new ImageModifierUtil()

    /**      * @return the instance      */
    def getInstanceOrCreate() : ImageModifierUtil = {
        return ImageModifierUtil.instance
    }

}


