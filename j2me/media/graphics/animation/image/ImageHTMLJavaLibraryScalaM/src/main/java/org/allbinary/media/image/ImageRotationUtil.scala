/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.microemu.device.playn.PlaynImmutableImage
import _root_.org.microemu.device.playn.PlaynMutableImage
import _root_.playn.core.CanvasImage
import _root_.playn.core.CanvasSurface

class ImageRotationUtil private() {
    import _root_.org.allbinary.media.image.ImageRotationUtil.{*}

    def createRotatedImage(originalImage : Image, rotationInDegrees : Int) : Image = {
        //PreLogUtil.put("originalImage: " + originalImage + " rotationInDegrees: " + rotationInDegrees, this, "createRotatedImage");
        val image : Image = ImageCreationUtil.getInstance().getInstance(originalImage.getWidth(), originalImage.getHeight())
        if (image.isMutable()) {
            var originalPlayNImage : _root_.playn.core.Image = null
            if (originalImage.isMutable()) {
                //PreLogUtil.put("3a", this, "createRotatedImage");
                val originalHTMLImage : PlaynMutableImage = originalImage.asInstanceOf[PlaynMutableImage]
                originalPlayNImage = originalHTMLImage.getImage().asInstanceOf[_root_.playn.core.Image]
            } else {
                //PreLogUtil.put("3b", this, "createRotatedImage");
                val originalHTMLImage : PlaynImmutableImage = originalImage.asInstanceOf[PlaynImmutableImage]
                originalPlayNImage = originalHTMLImage.getImage().asInstanceOf[_root_.playn.core.Image]
            }
            val htmlImage : PlaynMutableImage = image.asInstanceOf[PlaynMutableImage]
            val canvasImage : CanvasImage = htmlImage.getImage().asInstanceOf[CanvasImage]
            val canvasSurface : CanvasSurface = htmlImage.getCanvasSurface(canvasImage)
            canvasSurface.translate(originalPlayNImage.width() / 2, originalPlayNImage.height() / 2)
            canvasSurface.rotate(Math.toRadians(rotationInDegrees).toFloat)
            canvasSurface.drawImage(originalPlayNImage, -originalPlayNImage.width() / 2, -originalPlayNImage.height() / 2)
            return image
        } else {
            throw new Exception("Not Mutable")
        }
        throw new IllegalStateException()
    }

}

object ImageRotationUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : ImageRotationUtil = new ImageRotationUtil()

    def getInstance() : ImageRotationUtil = {
        return ImageRotationUtil.instance
    }

}


