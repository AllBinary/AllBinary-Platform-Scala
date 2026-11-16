/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.graphics.Anchor

class ImageRotationUtil private() {
    import _root_.org.allbinary.media.image.ImageRotationUtil.{*}

    private var anchor : Int = Anchor.TOP_LEFT

    // String resource,
    def createRotatedImage(originalImage : Image, rotationInDegrees : Int) : Image = {
        return originalImage
    }

}

object ImageRotationUtil {
    private val instance : ImageRotationUtil = new ImageRotationUtil()

    def getInstance() : ImageRotationUtil = {
        return ImageRotationUtil.instance
    }

}


