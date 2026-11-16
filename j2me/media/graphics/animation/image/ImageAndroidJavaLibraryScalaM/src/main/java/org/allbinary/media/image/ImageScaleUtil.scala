/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.android.graphics.Bitmap
import _root_.android.graphics.Canvas
import _root_.android.graphics.Matrix
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.image.ImageCache
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.microemu.android.device.AndroidImageInterface

class ImageScaleUtil private() {
    import _root_.org.allbinary.media.image.ImageScaleUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    //private final ImageCreationUtil imageCreationUtil = ImageCreationUtil.getInstance();
    private var anchor : Int = Anchor.TOP_LEFT

    private val imageBasicArrayList : BasicArrayList = new BasicArrayListD()

    private val scaledImageBasicArrayList : BasicArrayList = new BasicArrayListD()

    private val scaleXBasicArrayList : BasicArrayList = new BasicArrayListD()

    private val scaleYBasicArrayList : BasicArrayList = new BasicArrayListD()

    def createImage2(imageCache : ImageCache, originalImage : Image, scaleNominatorX : Float, scaleDenominatorX : Float, scaleNominatorY : Float, scaleDenominatorY : Float, cached : Boolean) : Image = {
        return this.createImage3(imageCache, originalImage, scaleNominatorX, scaleDenominatorX, scaleNominatorY, scaleDenominatorY, cached, true)
    }

    //private int anchor = Anchor.TOP_LEFT;
    def createImage3(imageCache : ImageCache, originalImage : Image, scaleNominatorX : Float, scaleDenominatorX : Float, scaleNominatorY : Float, scaleDenominatorY : Float, cached : Boolean, mutable : Boolean) : Image = {
        var scaleX : Float = scaleNominatorX / scaleDenominatorX
        var scaleY : Float = scaleNominatorY / scaleDenominatorY
        return this.createImage(imageCache, originalImage, scaleX, scaleY, cached)
    }

    def createImage(imageCache : ImageCache, originalImage : Image, scaleX : Float, scaleY : Float, cached : Boolean) : Image = {
        val originalAndroidImage : AndroidImageInterface = originalImage.asInstanceOf[AndroidImageInterface]
        val originalBitmap : Bitmap = originalAndroidImage.getBitmap()
        //this.logUtil.putF(CommonLabels.getInstance().COLON_SEP + scaleNominatorX + " / " + scaleDenominatorX + " = " + scaleX, this, this.commonStrings.CREATE_IMAGE);
        val width : Int = (originalBitmap.getWidth() * scaleX).toInt
        val height : Int = (originalBitmap.getHeight() * scaleY).toInt
        //if(width % 2 != 0 && 3d) throw new Exception because it is really a texture
        val index : Int = this.imageBasicArrayList.indexOf(originalImage)
        var alreadyAvailable : Boolean = false
        if (index >= 0) {
            val scaleX2Float : _root_.java.lang.Float = this.scaleXBasicArrayList.get(index).asInstanceOf[_root_.java.lang.Float]
            val scaleX2 : Float = scaleX2Float.floatValue()
            val scaleY2Float : _root_.java.lang.Float = this.scaleYBasicArrayList.get(index).asInstanceOf[_root_.java.lang.Float]
            val scaleY2 : Float = scaleY2Float.floatValue()
            if ((scaleX2 == scaleX) && (scaleY2 == scaleY)) {
                alreadyAvailable = true
            }
        }
        if (alreadyAvailable) {
            //this.logUtil.putF("Using existing scaled image at: " + index, this, this.commonStrings.CREATE_IMAGE);
            return this.scaledImageBasicArrayList.get(index).asInstanceOf[Image]
        } else {
            val scaledImage : Image = this.getScaledImage(imageCache, originalImage, scaleX, scaleY, width, height, cached)
            this.imageBasicArrayList.add(originalImage)
            this.scaledImageBasicArrayList.add(scaledImage)
            this.scaleXBasicArrayList.add(_root_.java.lang.Float.valueOf(scaleX))
            this.scaleYBasicArrayList.add(_root_.java.lang.Float.valueOf(scaleY))
            return scaledImage
        }
        throw new IllegalStateException()
    }

    private def getScaledImage(imageCache : ImageCache, originalImage : Image, scaleX : Float, scaleY : Float, width : Int, height : Int, cached : Boolean) : Image = {
        var image : Image = NullImage.NULL_IMAGE
        if (cached) {
            image = imageCache.get(this.getClass().getName(), width, height)
        } else {
            //image = Image.createImage(width, height);
            image = imageCache.get(this.commonStrings.CREATE_IMAGE, width, height)
        }
        if (image.isMutable()) {
            val matrix : Matrix = new Matrix()
            this.scale(image, matrix, scaleX, scaleY)
            image.getGraphics().drawImage(originalImage, 0, 0, this.anchor)
            return image
        } else {
            throw new Exception("Not Mutable")
        }
        throw new IllegalStateException()
    }

    private def scale(image : Image, matrix : Matrix, scaleX : Float, scaleY : Float) : Unit = {
        matrix.setScale(scaleX, scaleY)
        val canvas : Canvas = (image.asInstanceOf[AndroidImageInterface]).getCanvas()
        canvas.concat(matrix)
    }

}

object ImageScaleUtil {
    private val instance : ImageScaleUtil = new ImageScaleUtil()

    def getInstance() : ImageScaleUtil = {
        return ImageScaleUtil.instance
    }

}


