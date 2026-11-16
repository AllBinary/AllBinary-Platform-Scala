/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.GameFeatureFactory
import _root_.org.allbinary.image.ImageCache
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class ImageScaleUtil private() {
    import _root_.org.allbinary.media.image.ImageScaleUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    //private final ImageCreationUtil imageCreationUtil = ImageCreationUtil.getInstance();
    private val imageCopyUtil : ImageCopyUtil = ImageCopyUtil.getInstance()

    private val gameFeatureFactory : GameFeatureFactory = GameFeatureFactory.getInstance()

    private val features : Features = Features.getInstance()

    private val NO_COPY : String = "SWT should not copy images after initial loading as the alpha is not honored"

    def createImage2(imageCache : ImageCache, originalImage : Image, scaleNominatorX : Float, scaleDenominatorX : Float, scaleNominatorY : Float, scaleDenominatorY : Float, cached : Boolean) : Image = {
        return this.createImage3(imageCache, originalImage, scaleNominatorX, scaleDenominatorX, scaleNominatorY, scaleDenominatorY, cached, true)
    }

    //private int anchor = Anchor.TOP_LEFT;
    def createImage3(imageCache : ImageCache, originalImage : Image, scaleNominatorX : Float, scaleDenominatorX : Float, scaleNominatorY : Float, scaleDenominatorY : Float, cached : Boolean, mutable : Boolean) : Image = {
        if (!this.features.isFeature(this.gameFeatureFactory.POST_IMAGE_LOADING_MODIFICATION)) {
            this.logUtil.putF(this.NO_COPY, this, this.commonStrings.CONSTRUCTOR)
            return originalImage
        }
        val width : Int = originalImage.getWidth()
        val height : Int = originalImage.getHeight()
        val scaleX : Float = scaleNominatorX / scaleDenominatorX
        val scaleY : Float = scaleNominatorY / scaleDenominatorY
        //        this.scale(originalImage, image, scaleX, scaleY);
        val scaledImage : Image = this.imageCopyUtil.createImageWH(originalImage, (scaleX * width).toInt, (scaleY * height).toInt, mutable)
        return scaledImage
    }

    def scale2(originalImage : Image, originalImageArray : Array[Image], ximageToShowArray : Array[Image], unused : Int, scaleX : Float, scaleY : Float, maxScaleX : Float, maxScaleY : Float) : Unit = {
        this.scale(originalImage, originalImageArray, ximageToShowArray, unused, scaleX, scaleY, maxScaleX, maxScaleY, true)
    }

    def scale(originalImage : Image, originalImageArray : Array[Image], ximageToShowArray : Array[Image], unused : Int, scaleX : Float, scaleY : Float, maxScaleX : Float, maxScaleY : Float, mutable : Boolean) : Unit = {
        val width : Int = originalImage.getWidth()
        val height : Int = originalImage.getHeight()
        val scaledImage : Image = this.imageCopyUtil.createImageWH(originalImage, (scaleX * width).toInt, (scaleY * height).toInt, mutable)
        originalImageArray(0) = scaledImage
    }

}

object ImageScaleUtil {
    private val instance : ImageScaleUtil = new ImageScaleUtil()

    def getInstance() : ImageScaleUtil = {
        return ImageScaleUtil.instance
    }

}


