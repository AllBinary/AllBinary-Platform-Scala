/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.javax.microedition.lcdui.Image

class ImageToRotationImageArrayUtil private() {
    import _root_.org.allbinary.media.image.ImageToRotationImageArrayUtil.{*}

    def generate(image : Image, angleIncrement : Int, totalAngle : Int) : Array[Image] = {
        val imageRotationUtil : ImageRotationUtil = ImageRotationUtil.getInstance()
        val totalFrames : Int = totalAngle / angleIncrement
        val imageArray : Array[Image] = new Array[Image](totalFrames)
        imageArray(0) = image

        {
            var index : Int = 1
            while (index < totalFrames) {
                //PreLogUtil.put(commonLabels.INDEX_LABEL + index + "/" + totalFrames + " Angle: " + index * angleIncrement, this, "generate");
                imageArray(index) = imageRotationUtil.createRotatedImage(image, index * angleIncrement)
                index += 1
            }
        }
        return imageArray
    }

}

object ImageToRotationImageArrayUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : ImageToRotationImageArrayUtil = new ImageToRotationImageArrayUtil()

    def getInstance() : ImageToRotationImageArrayUtil = {
        return ImageToRotationImageArrayUtil.instance
    }

}


