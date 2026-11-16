/* * AllBinary Open License Version 1 * Copyright (c) 2023 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.image.GameFeatureImageCacheFactory

/**  *  * @author user  */
class ImageJ2MEScaleUtil private() {
    import _root_.org.allbinary.media.image.ImageJ2MEScaleUtil.{*}

    def scaleArray(images : Array[Image], width : Int, height : Int) : Array[Image] = {

        {
            var index : Int = 0
            while (index < images.length) {
                var image : Image = images(index)
                images(index) = ImageScaleUtil.getInstance().createImage2(GameFeatureImageCacheFactory.getInstance(), image, width.toFloat / 2, image.getWidth().toFloat, height.toFloat, image.getHeight().toFloat, false)
                index += 1
            }
        }
        return images
    }

    def scale(image : Image, width : Int, height : Int) : Image = {
        return ImageScaleUtil.getInstance().createImage2(GameFeatureImageCacheFactory.getInstance(), image, width.toFloat, image.getWidth().toFloat, height.toFloat, image.getHeight().toFloat, false)
    }

}

object ImageJ2MEScaleUtil {
    private val instance : ImageJ2MEScaleUtil = new ImageJ2MEScaleUtil()

    /**      * @return the instance      */
    def getInstance() : ImageJ2MEScaleUtil = {
        return ImageJ2MEScaleUtil.instance
    }

}


