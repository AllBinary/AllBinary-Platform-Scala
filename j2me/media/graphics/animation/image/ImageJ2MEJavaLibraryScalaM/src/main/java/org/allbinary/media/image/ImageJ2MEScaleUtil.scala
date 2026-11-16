/* * AllBinary Open License Version 1 * Copyright (c) 2023 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.javax.microedition.lcdui.Image

/**  *  * @author user  */
class ImageJ2MEScaleUtil private() {
    import _root_.org.allbinary.media.image.ImageJ2MEScaleUtil.{*}

    def scaleArray(images : Array[Image], width : Int, height : Int) : Array[Image] = {
        val scaledImages : Array[Image] = new Array[Image](images.length)

        {
            var index : Int = images.length
            while ({ index -= 1; index } >= 0) {
                scaledImages(index) = this.scale(images(index), width, height)
            }
        }
        return scaledImages
    }

    def scale(image : Image, width : Int, height : Int) : Image = {
        val sourceWidth : Int = image.getWidth()
        val sourceHeight : Int = image.getHeight()
        val originalData : Array[Int] = new Array[Int](image.getWidth() * image.getHeight())
        image.getRGB(originalData, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight())
        val scaledData : Array[Int] = new Array[Int](width * height)
        val heightRatioFactor : Int = (8 * sourceHeight) / height
        val widthRatioFactor : Int = (8 * sourceWidth) / width
        var scaledIndex : Int = scaledData.length - 1
        var dx : Int = 0
        var dy : Int = 0

        {
            var index : Int = height
            while ({ index -= 1; index } >= 0) {
                dy = (index * heightRatioFactor) >> 3

                {
                    var index2 : Int = width
                    while ({ index2 -= 1; index2 } >= 0) {
                        dx = (index2 * widthRatioFactor) >> 3
                        scaledData({ val value_N67058 = scaledIndex; scaledIndex -= 1; value_N67058 }) = originalData((sourceWidth * dy) + dx)
                    }
                }
            }
        }
        //final Image scaledImage = Image.createRGBImage(originalData, sourceWidth, sourceHeight, true);
        val scaledImage : Image = Image.createRGBImage(scaledData, width, height, true)
        /*         Image scaledImage = GameFeatureImageCacheFactory.getInstance().get(this, width, height);         Graphics graphics = scaledImage.getGraphics();          for(int index = sourceWidth; --index >= 0;)         {             for(int index2 = sourceHeight; --index2 >= 0;)             {                 graphics.setClip(index, index2, 1, 1);                  dx = index * sourceWidth / width;                 dy = index2 * sourceHeight / height;                  graphics.drawImage(image, index - dx, index2 - dy, 0);             }         }         */
        return scaledImage
    }

}

object ImageJ2MEScaleUtil {
    private val instance : ImageJ2MEScaleUtil = new ImageJ2MEScaleUtil()

    /**      * @return the instance      */
    def getInstance() : ImageJ2MEScaleUtil = {
        return ImageJ2MEScaleUtil.instance
    }

}


