/* * AllBinary Open License Version 1 * Copyright (c) 2023 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.microemu.device.playn.PlaynImmutableImage
import _root_.org.microemu.device.playn.PlaynMutableImage
import _root_.playn.core.Canvas
import _root_.playn.core.CoreImage
import _root_.playn.core.ImageImpl
import _root_.playn.core.PlayN
import _root_.playn.html.HtmlGraphics
import _root_.playn.html.HtmlImage

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
        var originalPlayNImage : CoreImage = null
        if (image.isMutable()) {
            //PreLogUtil.put("3a", this, "createImage");
            val originalHTMLImage : PlaynMutableImage = image.asInstanceOf[PlaynMutableImage]
            originalPlayNImage = originalHTMLImage.getImage().asInstanceOf[CoreImage]
        } else {
            //PreLogUtil.put("3b", this, "createImage");
            val originalHTMLImage : PlaynImmutableImage = image.asInstanceOf[PlaynImmutableImage]
            originalPlayNImage = originalHTMLImage.getImage().asInstanceOf[CoreImage]
        }
        val scaledImage : Image = Image.createImageWH(width, height)
        val htmlImage : PlaynMutableImage = scaledImage.asInstanceOf[PlaynMutableImage]
        val scaledPlayNImage : ImageImpl = htmlImage.getImage().asInstanceOf[ImageImpl]
        val canvas : Canvas = (PlayN.getInstance().graphics().asInstanceOf[HtmlGraphics]).get(scaledPlayNImage.asInstanceOf[HtmlImage])
        //Canvas.drawScale calls ImageImpl.draw(gc(), ...) and is available to the JS build
        canvas.drawScale(originalPlayNImage, 0, 0, scaledImage.getWidth(), scaledImage.getHeight(), 0, 0, image.getWidth(), image.getHeight())
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


