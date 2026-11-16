/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.graphics.Anchor
import _root_.android.graphics.Bitmap
import _root_.android.graphics.Canvas
import _root_.android.graphics.Matrix
import _root_.org.microemu.android.device.AndroidImageInterface

class ImageRotationUtil private() {
    import _root_.org.allbinary.media.image.ImageRotationUtil.{*}

    private val matrix : Matrix = new Matrix()

    private var anchor : Int = Anchor.TOP_LEFT

    // String resource,
    def createRotatedImage(originalImage : Image, rotationInDegrees : Int) : Image = {
        val image : Image = ImageCreationUtil.getInstance().createImageWH(originalImage.getWidth(), originalImage.getHeight())
        if (image.isMutable()) {
            //Bitmap originalBitmap = originalImage.getBitmap();
            val bitmap : Bitmap = (image.asInstanceOf[AndroidImageInterface]).getBitmap()
            val width : Int = bitmap.getWidth()
            val height : Int = bitmap.getHeight()
            //image.getGraphics().drawRect(0, 0, width, height);
            this.matrix.setRotate(rotationInDegrees.toFloat, (width >> 1).toFloat, (height >> 1).toFloat)
            val canvas : Canvas = (image.asInstanceOf[AndroidImageInterface]).getCanvas()
            //canvas.save();
            canvas.concat(this.matrix)
            image.getGraphics().drawImage(originalImage, 0, 0, this.anchor)
            //canvas.restore();
            return image
        } else {
            throw new Exception("Not Mutable")
        }
        throw new IllegalStateException()
    }

}

object ImageRotationUtil {
    private val instance : ImageRotationUtil = new ImageRotationUtil()

    def getInstance() : ImageRotationUtil = {
        return ImageRotationUtil.instance
    }

}


