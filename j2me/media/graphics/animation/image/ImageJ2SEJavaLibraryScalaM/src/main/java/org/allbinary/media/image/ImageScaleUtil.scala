/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.java.awt.Graphics2D
import _root_.java.awt.geom.AffineTransform
import _root_.java.awt.image.BufferedImage
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.image.ImageCache

class ImageScaleUtil private() {
    import _root_.org.allbinary.media.image.ImageScaleUtil.{*}

    private val imageUtil : ImageUtil = ImageUtil.getInstance()

    private val imageJ2SEUtil : ImageJ2SEUtil = ImageJ2SEUtil.getInstance()

    private val imageCreationUtil : ImageCreationUtil = ImageCreationUtil.getInstance()

    //private int anchor = Anchor.TOP_LEFT;
    def createImage2(imageCache : ImageCache, originalImage : Image, scaleNominatorX : Float, scaleDenominatorX : Float, scaleNominatorY : Float, scaleDenominatorY : Float, cached : Boolean) : Image = {
        return this.createImage3(imageCache, originalImage, scaleNominatorX, scaleDenominatorX, scaleNominatorY, scaleDenominatorY, cached, true)
    }

    //private int anchor = Anchor.TOP_LEFT;
    def createImage3(imageCache : ImageCache, originalImage : Image, scaleNominatorX : Float, scaleDenominatorX : Float, scaleNominatorY : Float, scaleDenominatorY : Float, cached : Boolean, mutable : Boolean) : Image = {
        val width : Int = originalImage.getWidth()
        val height : Int = originalImage.getHeight()
        val scaleX : Float = scaleNominatorX / scaleDenominatorX
        val scaleY : Float = scaleNominatorY / scaleDenominatorY
        var image : Image = null
        if (cached) {
            image = imageCache.get(this.getClass().getName(), (width * scaleX).toInt, (height * scaleY).toInt)
        } else {
            //image = Image.createImage(width, height);
            image = imageCache.get("createImage", (width * scaleX).toInt, (height * scaleY).toInt)
        }
        this.scale(originalImage, image, scaleX, scaleY, true)
        return image
    }

    def scale2(originalImage : Image, originalImageArray : Array[Image], ximageToShowArray : Array[Image], unused : Int, scaleX : Float, scaleY : Float, maxScaleX : Float, maxScaleY : Float) : Unit = {
        //Set the max image size needed.
        if (((maxScaleX * originalImage.getWidth()) > originalImageArray(0).getWidth()) || ((maxScaleY * originalImage.getHeight()) > originalImageArray(0).getHeight())) {
            //this.logUtil.putF(new StringMaker().append("scale canvas: ").append(maxScaleX).toString(), this, this.commonStrings.UPDATE);
            originalImageArray(0) = this.imageCreationUtil.createImage(originalImage.getWidth(), originalImage.getHeight(), maxScaleX, maxScaleY)
        }
        //this.logUtil.putF(new StringMaker().append("scaleX: ").append(scaleX).append("scaleY: ").append(scaleY).toString(), this, this.commonStrings.UPDATE);
        this.scale(originalImage, originalImageArray(0), scaleX, scaleY, false)
    }

    def scale(originalImage : Image, newMaxSizeImage : Image, scaleX : Float, scaleY : Float, clear : Boolean) : Unit = {
        val bufferedImage : BufferedImage = this.imageUtil.getBufferedImage(originalImage)
        val newBufferedImage : BufferedImage = this.imageUtil.getBufferedImage(newMaxSizeImage)
        val at : AffineTransform = AffineTransform.getScaleInstance(scaleX, scaleY)
        val g : Graphics2D = newBufferedImage.createGraphics()
        if (clear) {
            g.setBackground(this.imageJ2SEUtil.TRANSPARENT_COLOR)
            g.clearRect(0, 0, newBufferedImage.getWidth(), newBufferedImage.getHeight())
        }
        g.drawRenderedImage(bufferedImage, at)
        g.dispose()
    }

}

object ImageScaleUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : ImageScaleUtil = new ImageScaleUtil()

    def getInstance() : ImageScaleUtil = {
        return ImageScaleUtil.instance
    }

}


