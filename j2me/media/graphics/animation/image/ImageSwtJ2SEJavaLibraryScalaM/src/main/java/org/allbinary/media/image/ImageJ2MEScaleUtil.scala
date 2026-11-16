/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
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
        val scaledImage : Image = ImageCopyUtil.getInstance().createImageWH(image, width, height, true)
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


