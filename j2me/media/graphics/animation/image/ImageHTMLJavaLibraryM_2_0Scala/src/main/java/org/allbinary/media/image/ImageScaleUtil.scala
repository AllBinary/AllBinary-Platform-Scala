/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.image.ImageCache
import _root_.org.microemu.device.playn.PlaynImmutableImage
import _root_.org.microemu.device.playn.PlaynMutableImage
import _root_.playn.core.Canvas
import _root_.playn.core.CoreImage
import _root_.playn.core.ImageImpl
import _root_.playn.html.HTMLPlaynUtil

class ImageScaleUtil private() {
    import _root_.org.allbinary.media.image.ImageScaleUtil.{*}

    private val playnUtil : HTMLPlaynUtil = HTMLPlaynUtil.getInstance()

    def createImage2(imageCache : ImageCache, originalImage : Image, scaleNominatorX : Float, scaleDenominatorX : Float, scaleNominatorY : Float, scaleDenominatorY : Float, cached : Boolean) : Image = {
        return this.createImage3(imageCache, originalImage, scaleNominatorX, scaleDenominatorX, scaleNominatorY, scaleDenominatorY, cached, true)
    }

    //private int anchor = Anchor.TOP_LEFT;
    def createImage3(imageCache : ImageCache, originalImage : Image, scaleNominatorX : Float, scaleDenominatorX : Float, scaleNominatorY : Float, scaleDenominatorY : Float, cached : Boolean, mutable : Boolean) : Image = {
        val scaleX : Float = scaleNominatorX / scaleDenominatorX
        val scaleY : Float = scaleNominatorY / scaleDenominatorY
        return this.createImage(imageCache, originalImage, scaleX, scaleY, cached)
    }

    def createImage(imageCache : ImageCache, originalImage : Image, scaleX : Float, scaleY : Float, cached : Boolean) : Image = {
        return this.createImageInternal(originalImage, scaleX, scaleY)
    }

    def createImageInternal(originalImage : Image, scaleX : Float, scaleY : Float) : Image = {
        //PreLogUtil.put("originalImage: " + originalImage.getWidth() + " " + originalImage.getHeight(), this, "createImage");
        val image : Image = ImageCreationUtil.getInstance().createImageWH((originalImage.getWidth() * scaleX).toInt, (originalImage.getHeight() * scaleY).toInt)
        //PreLogUtil.put("Image: " + image.getWidth() + " " + image.getHeight(), this, "createImage");
        if (image.isMutable()) {
            var originalPlayNImage : CoreImage = null
            if (originalImage.isMutable()) {
                //PreLogUtil.put("3a", this, "createImage");
                val originalHTMLImage : PlaynMutableImage = originalImage.asInstanceOf[PlaynMutableImage]
                originalPlayNImage = originalHTMLImage.getImage().asInstanceOf[CoreImage]
            } else {
                //PreLogUtil.put("3b", this, "createImage");
                val originalHTMLImage : PlaynImmutableImage = originalImage.asInstanceOf[PlaynImmutableImage]
                originalPlayNImage = originalHTMLImage.getImage().asInstanceOf[CoreImage]
            }
            val htmlImage : PlaynMutableImage = image.asInstanceOf[PlaynMutableImage]
            val canvasImage : ImageImpl = htmlImage.getImage().asInstanceOf[ImageImpl]
            val canvas : Canvas = this.playnUtil.getCanvas(canvasImage)
            //canvasSurface.drawImage(originalPlayNImage, 0, 0, image.getWidth() + 3, image.getHeight(), 0, 0, originalImage.getWidth(), originalImage.getHeight());
            canvas.drawScale(originalPlayNImage, 0, 0, image.getWidth(), image.getHeight(), 0, 0, originalImage.getWidth(), originalImage.getHeight())
            return image
        } else {
            throw new Exception("Not Mutable")
        }
        throw new IllegalStateException()
    }

}

object ImageScaleUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : ImageScaleUtil = new ImageScaleUtil()

    def getInstance() : ImageScaleUtil = {
        return ImageScaleUtil.instance
    }

}


