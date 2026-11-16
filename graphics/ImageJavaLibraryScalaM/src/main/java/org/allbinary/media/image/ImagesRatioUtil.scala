/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.java.awt.*
import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonLabels

class ImagesRatioUtil private() {
    import _root_.org.allbinary.media.image.ImagesRatioUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val imageUtil : ImageUtil = ImageUtil.getInstance()

    def isEqual(bufferedImageArray : Array[BufferedImage], totalImages : Int) : Boolean = {
        var end : Int = totalImages
        if (bufferedImageArray.length < totalImages) {
            end = bufferedImageArray.length
        }
        val ratio : Double = (bufferedImageArray(0).getWidth().toDouble / bufferedImageArray(0).getHeight())

        {
            var index : Int = 1
            while (index < end) {
                if (ratio != (bufferedImageArray(index).getWidth().toDouble / bufferedImageArray(index).getHeight())) {
                    return false
                }
                index += 1
            }
        }
        return true
    }

    def getAverage(bufferedImageArray : Array[BufferedImage], totalImages : Int) : Double = {
        var ratio : Double = 0
        var end : Int = totalImages
        if (bufferedImageArray.length < totalImages) {
            end = bufferedImageArray.length
        }

        {
            var index : Int = 0
            while (index < end) {
                ratio += (bufferedImageArray(index).getWidth().toDouble / bufferedImageArray(index).getHeight())
                index += 1
            }
        }
        return (ratio.toDouble / end)
    }

    def fudge(bufferedImage : BufferedImage, ratio : Double) : BufferedImage = {
        var imageRatio : Double = (bufferedImage.getWidth().toDouble / bufferedImage.getHeight())
        var point : Point = new Point()
        //need a larger height
        var newHeight : Int = bufferedImage.getHeight()
        var newWidth : Int = bufferedImage.getWidth()
        if (ratio > imageRatio) {
            //need a larger width
            newWidth = (bufferedImage.getHeight().toDouble * ratio).toInt
            point.x = (newWidth - bufferedImage.getWidth()) / 2
        } else {
            //need a larger height
            newHeight = (bufferedImage.getWidth().toDouble / ratio).toInt
            point.y = (newHeight - bufferedImage.getHeight()) / 2
        }
        val commonLabels : CommonLabels = CommonLabels.getInstance()
        this.logUtil.putF(((((((((commonLabels.WIDTH_LABEL + bufferedImage.getWidth()) + " newWidth: ") + newWidth) + commonLabels.HEIGHT_LABEL) + bufferedImage.getHeight()) + " newHeight: ") + newHeight) + " needed ratio: ") + (newWidth.toDouble / newHeight), this, "fudge")
        var newBufferedImage : BufferedImage = this.imageUtil.create(newWidth, newHeight)
        var g : Graphics2D = newBufferedImage.createGraphics()
        if (point.x > 0) {
            /*             final int[] data = new int[bufferedImage.getHeight()];             final byte[] bytes = new byte[data.length * 4];                       this.logUtil.putF("Get the first column of the original of: " + bytes.length, this, "fudge");              bufferedImage.getRGB(                 0, //startX                 0, //startY                 1, //w                 bufferedImage.getHeight(), //h                 data, 0, 0);              for(int index = 0; index < data.length; index++)             {                 int intValue = Color.YELLOW.getRGB(); //data[index];                 bytes[(index * 4)] = (byte) ((intValue >>> 24)); //& 0xFF);                 bytes[(index * 4) + 1] = (byte) ((intValue >>> 16)); //& 0xFF);                 bytes[(index * 4) + 2] = (byte) ((intValue >>> 8)); //& 0xFF);                 bytes[(index * 4) + 3] = (byte) ((intValue >>> 0)); //& 0xFF);             }             */
            var firstColumnBufferedImage : BufferedImage = bufferedImage.getSubimage(0, 0, 1, bufferedImage.getHeight())
            var lastColumnBufferedImage : BufferedImage = bufferedImage.getSubimage(bufferedImage.getWidth() - 1, 0, 1, bufferedImage.getHeight())
            this.logUtil.putF("Draw some columns to fill in gap", this, "fudge")
            //g.setColor(Color.RED);

            {
                var index : Int = 0
                while (index < point.x) {
                    //g.drawLine(newWidth - index, 0, newWidth - index, bufferedImage.getHeight());
                    g.drawImage(firstColumnBufferedImage, index, 0, null)
                    g.drawImage(lastColumnBufferedImage, newWidth - index, 0, null)
                    index += 1
                }
            }
        }
        if (point.y > 0) {
            /*             final int[] data = new int[bufferedImage.getWidth()];             final byte[] bytes = new byte[data.length * 4];                       this.logUtil.putF("Get the first row of the original of: " + bytes.length, this, "fudge");              bufferedImage.getRGB(                 0, //startX                 0, //startY                 bufferedImage.getWidth(), //w                 1, //h                 data, 0, 0);                          for(int index = 0; index < data.length; index++)             {                 int intValue = Color.YELLOW.getRGB(); //data[index];                                  bytes[(index * 4)] = (byte) ((intValue >>> 24)); //& 0xFF);                 bytes[(index * 4) + 1] = (byte) ((intValue >>> 16)); //& 0xFF);                 bytes[(index * 4) + 2] = (byte) ((intValue >>> 8)); //& 0xFF);                 bytes[(index * 4) + 3] = (byte) ((intValue >>> 0)); //& 0xFF);             }              */
            var firstRowBufferedImage : BufferedImage = bufferedImage.getSubimage(0, 0, bufferedImage.getWidth(), 1)
            var lastRowBufferedImage : BufferedImage = bufferedImage.getSubimage(0, bufferedImage.getHeight() - 1, bufferedImage.getWidth(), 1)
            this.logUtil.putF("Draw some rows to fill in gap", this, "fudge")
            //g.setColor(Color.RED);

            {
                var index : Int = 0
                while (index < point.y) {
                    //g.drawLine(0, newHeight - index, bufferedImage.getWidth(), newHeight - index);
                    g.drawImage(firstRowBufferedImage, 0, index, null)
                    g.drawImage(lastRowBufferedImage, 0, newHeight - index, null)
                    index += 1
                }
            }
        }
        g.drawImage(bufferedImage, point.x, point.y, bufferedImage.getWidth(), bufferedImage.getHeight(), null)
        return newBufferedImage
    }

    def fudge(bufferedImageArray : Array[BufferedImage], totalImages : Int, ratio : Double) : Array[BufferedImage] = {
        var end : Int = totalImages
        if (bufferedImageArray.length < totalImages) {
            end = bufferedImageArray.length
        }
        val fudgedBufferedImageArray : Array[BufferedImage] = new Array[BufferedImage](end)

        {
            var index : Int = 0
            while (index < end) {
                fudgedBufferedImageArray(index) = fudge(bufferedImageArray(index), ratio)
                index += 1
            }
        }
        return fudgedBufferedImageArray
    }

}

object ImagesRatioUtil {
    private val instance : ImagesRatioUtil = new ImagesRatioUtil()

    /**      * @return the instance      */
    def getInstance() : ImagesRatioUtil = {
        return ImagesRatioUtil.instance
    }

}


