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

    def rotateImage(originalImage : Image, image : Image, totalAngle : Int) : Image = {
        if (image.isMutable()) {
            val htmlImage : PlaynMutableImage = image.asInstanceOf[PlaynMutableImage]
            val canvasImage : CanvasImage = htmlImage.getImage().asInstanceOf[CanvasImage]
            val canvasSurface : CanvasSurface = htmlImage.getCanvasSurface(canvasImage)
            canvasSurface.translate(originalImage.getWidth() / 2, originalImage.getHeight() / 2)
            val image2 : Image = this.rotateImageCanvasSurface(originalImage, image, canvasSurface, totalAngle)
            this.drawImage(originalImage, image, canvasSurface)
            return image2
        } else {
            return null
        }
        throw new IllegalStateException()
    }

    def rotateImageCanvasSurfaceClear(originalImage : Image, image : Image, canvasSurface : CanvasSurface, totalAngle : Int) : Image = {
        if (image.isMutable()) {
            canvasSurface.translate(-originalImage.getWidth() / 2, -originalImage.getHeight() / 2)
            canvasSurface.clear()
            canvasSurface.translate(originalImage.getWidth() / 2, originalImage.getHeight() / 2)
            return this.rotateImageCanvasSurface(originalImage, image, canvasSurface, totalAngle)
        } else {
            return null
        }
        throw new IllegalStateException()
    }

    def rotateImageCanvasSurface(originalImage : Image, image : Image, canvasSurface : CanvasSurface, totalAngle : Int) : Image = {
        if (image.isMutable()) {
            canvasSurface.rotate(Math.toRadians(totalAngle).toFloat)
            return image
        } else {
            return null
        }
        throw new IllegalStateException()
    }

    def drawImage(originalImage : Image, image : Image, canvasSurface : CanvasSurface) : Unit = {
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
        canvasSurface.drawImage(originalPlayNImage, -originalImage.getWidth() / 2, -originalImage.getHeight() / 2)
    }

    def createRotatedImage(originalImage : Image, rotationInDegrees : Int) : Image = {
        //PreLogUtil.put("originalImage: " + originalImage + " rotationInDegrees: " + rotationInDegrees, this, "createRotatedImage");
        val image : Image = ImageCreationUtil.getInstance().createImageWH(originalImage.getWidth(), originalImage.getHeight())
        val rotatedImage : Image = this.rotateImage(originalImage, image, rotationInDegrees)
        if (rotatedImage == null) {
            throw new Exception("Not Mutable")
        }
        return rotatedImage
    }

}

object ImageRotationUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : ImageRotationUtil = new ImageRotationUtil()

    def getInstance() : ImageRotationUtil = {
        return ImageRotationUtil.instance
    }

}


