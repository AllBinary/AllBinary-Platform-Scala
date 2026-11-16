/* * AllBinary Open License Version 1 * Copyright (c) 2023 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.microemu.device.playn.PlaynImmutableImage
import _root_.org.microemu.device.playn.PlaynMutableImage
import _root_.playn.core.CanvasImage
import _root_.playn.core.CanvasSurface

/**  *  * @author user  */
class ImageJ2MEScaleUtil private() {
    import _root_.org.allbinary.media.image.ImageJ2MEScaleUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def scaleArray(images : Array[Image], width : Int, height : Int) : Array[Image] = {
        var scaledImages : Array[Image] = new Array[Image](images.length)

        {
            var index : Int = images.length
            while ({ index -= 1; index } >= 0) {
                scaledImages(index) = this.scale(images(index), width, height)
            }
        }
        return scaledImages
    }

    def scale(image : Image, width : Int, height : Int) : Image = {
        var originalPlayNImage : _root_.playn.core.Image = null
        if (image.isMutable()) {
            //PreLogUtil.put("3a", this, "createImage");
            val originalHTMLImage : PlaynMutableImage = image.asInstanceOf[PlaynMutableImage]
            originalPlayNImage = originalHTMLImage.getImage().asInstanceOf[_root_.playn.core.Image]
        } else {
            //PreLogUtil.put("3b", this, "createImage");
            val originalHTMLImage : PlaynImmutableImage = image.asInstanceOf[PlaynImmutableImage]
            originalPlayNImage = originalHTMLImage.getImage().asInstanceOf[_root_.playn.core.Image]
        }
        val scaledImage : Image = Image.createImage(width, height)
        val htmlImage : PlaynMutableImage = scaledImage.asInstanceOf[PlaynMutableImage]
        val canvasImage : CanvasImage = htmlImage.getImage().asInstanceOf[CanvasImage]
        val canvasSurface : CanvasSurface = htmlImage.getCanvasSurface(canvasImage)
        //this.logUtil.putF(new StringMaker().append("TWB w:").append(image.getWidth()).append(" h: ").append(image.getHeight()).append(" w: ").append(scaledImage.getWidth()).append(" h: ").append(scaledImage.getHeight()).toString(), this, "scale");
        canvasSurface.drawImage(originalPlayNImage, 0, 0, scaledImage.getWidth(), scaledImage.getHeight(), 0, 0, image.getWidth(), image.getHeight())
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


