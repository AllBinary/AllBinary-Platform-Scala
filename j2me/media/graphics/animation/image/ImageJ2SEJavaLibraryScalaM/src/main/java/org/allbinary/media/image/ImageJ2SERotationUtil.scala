/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.java.awt.Graphics2D
import _root_.java.awt.Image
import _root_.java.awt.image.BufferedImage

class ImageJ2SERotationUtil private() {
    import _root_.org.allbinary.media.image.ImageJ2SERotationUtil.{*}

    private val imageUtil : ImageUtil = ImageUtil.getInstance()

    private val imageJ2SEUtil : ImageJ2SEUtil = ImageJ2SEUtil.getInstance()

    private val TWO_PIE : Double = 2 * Math.PI

    def getRotatedImage(bufferedImage : Image, totalAngle : Int) : BufferedImage = {
        return this.getRotatedImageRadians(bufferedImage, (TWO_PIE * totalAngle) / 360)
    }

    def getRotatedImageRadians(bufferedImage : Image, radians : Double) : BufferedImage = {
        val newBufferedImage : BufferedImage = this.imageUtil.create(bufferedImage.getWidth(null), bufferedImage.getHeight(null))
        return this.drawRotatedImageRadians(bufferedImage, newBufferedImage, newBufferedImage.createGraphics(), radians)
    }

    private def drawRotatedImageRadians(bufferedImage : Image, newBufferedImage : BufferedImage, g : Graphics2D, radians : Double) : BufferedImage = {
        //g.translate((neww-w)/2, (newh-h)/2);
        g.rotate(radians, newBufferedImage.getWidth(null) / 2, newBufferedImage.getHeight(null) / 2)
        g.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth(null), bufferedImage.getHeight(null), null)
        //g.drawRenderedImage(image, null);
        g.dispose()
        return newBufferedImage
    }

    def rotateImage(bufferedImage : Image, newBufferedImage : BufferedImage, totalAngle : Int) : BufferedImage = {
        val g : Graphics2D = newBufferedImage.createGraphics()
        g.setBackground(this.imageJ2SEUtil.TRANSPARENT_COLOR)
        g.clearRect(0, 0, newBufferedImage.getWidth(), newBufferedImage.getHeight())
        return this.drawRotatedImageRadians(bufferedImage, newBufferedImage, g, (TWO_PIE * totalAngle) / 360)
    }

    def createRotatedImage(bufferedImage : Image, newBufferedImage : BufferedImage, totalAngle : Int) : BufferedImage = {
        val g : Graphics2D = newBufferedImage.createGraphics()
        return this.drawRotatedImageRadians(bufferedImage, newBufferedImage, g, (TWO_PIE * totalAngle) / 360)
    }

    def getRotatedImages(bufferedImage : Image, numberOfFrames : Int, totalAngle : Int) : Array[BufferedImage] = {
        val bufferedImageArray : Array[BufferedImage] = new Array[BufferedImage](numberOfFrames)
        val arc : Double = ((this.TWO_PIE) * totalAngle) / 360
        val size : Int = bufferedImageArray.length

        {
            var index : Int = 0
            while (index < size) {
                val radians : Double = (arc / size) * index
                bufferedImageArray(index) = this.getRotatedImageRadians(bufferedImage, radians)
                index += 1
            }
        }
        return bufferedImageArray
    }

    def createSpriteImage(bufferedImageArray : Array[BufferedImage]) : BufferedImage = {
        var columns : Int = 9
        var rows : Int = 0
        val size : Int = bufferedImageArray.length
        if (size < columns) {
            columns = size
        }
        rows = (size / columns)
        //Extra row for incomplete but needed row
        if ((size % columns) != 0) {
            rows += 1
        }
        val firstBufferedImage : BufferedImage = bufferedImageArray(0)
        val bufferedImage : BufferedImage = this.imageUtil.create(firstBufferedImage.getWidth(null) * columns, firstBufferedImage.getHeight(null) * rows)
        val g : Graphics2D = bufferedImage.createGraphics()
        //g.translate((neww-w)/2, (newh-h)/2);
        var columnIndex : Int = 0
        var rowIndex : Int = 0
        var nextBufferedImage : BufferedImage = null

        {
            var index : Int = 0
            while (index < size) {
                if (((index / 9) != 0) && ((index % 9) == 0)) {
                    rowIndex += 1
                    columnIndex = 0
                }
                nextBufferedImage = bufferedImageArray(index)
                g.drawImage(nextBufferedImage, nextBufferedImage.getWidth(null) * columnIndex, nextBufferedImage.getHeight(null) * rowIndex, nextBufferedImage.getWidth(null), nextBufferedImage.getHeight(null), null)
                //g.drawRenderedImage(image, null);
                columnIndex += 1
                index += 1
            }
        }
        g.dispose()
        return bufferedImage
    }

}

object ImageJ2SERotationUtil {
    private val instance : ImageJ2SERotationUtil = new ImageJ2SERotationUtil()

    /**      * @return the instance      */
    def getInstance() : ImageJ2SERotationUtil = {
        return ImageJ2SERotationUtil.instance
    }

}


