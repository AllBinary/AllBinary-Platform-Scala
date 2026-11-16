/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.GameFeatureFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.eclipse.swt.SWT
import _root_.org.eclipse.swt.graphics.GC
import _root_.org.eclipse.swt.graphics.ImageData

class ImageSwtRotationUtil private() {
    import _root_.org.allbinary.media.image.ImageSwtRotationUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val imageUtil : ImageUtil = ImageUtil.getInstance()

    //private final ImageSwtUtil imageJ2SEUtil = ImageSwtUtil.getInstance();
    private val gameFeatureFactory : GameFeatureFactory = GameFeatureFactory.getInstance()

    private val features : Features = Features.getInstance()

    private val NO_COPY : String = "SWT should not copy images after initial loading as the alpha is not honored"

    def getRotatedImage(bufferedImage : _root_.org.eclipse.swt.graphics.Image, totalAngle : Int) : _root_.org.eclipse.swt.graphics.Image = {
        if (!this.features.isFeature(this.gameFeatureFactory.POST_IMAGE_LOADING_MODIFICATION)) {
            this.logUtil.putF(this.NO_COPY, this, this.commonStrings.CONSTRUCTOR)
            return bufferedImage
        }
        //        return this.getRotatedImage(bufferedImage, copySwtImage, newGC, totalAngle);
        return bufferedImage
    }

    private def getRotatedImage2(bufferedImage : _root_.org.eclipse.swt.graphics.Image, newBufferedImage : _root_.org.eclipse.swt.graphics.Image, gc : GC, angle : Float) : _root_.org.eclipse.swt.graphics.Image = {
        if (!this.features.isFeature(this.gameFeatureFactory.POST_IMAGE_LOADING_MODIFICATION)) {
            this.logUtil.putF(this.NO_COPY, this, this.commonStrings.CONSTRUCTOR)
            return bufferedImage
        }
        //        return newBufferedImage;
        return bufferedImage
    }

    def rotateImage(originalSwtImage : _root_.org.eclipse.swt.graphics.Image, newSwtImage : _root_.org.eclipse.swt.graphics.Image, gc : GC, totalAngle : Int) : _root_.org.eclipse.swt.graphics.Image = {
        //final org.eclipse.swt.graphics.Image bufferedImage
        return this.getRotatedImage2(originalSwtImage, newSwtImage, gc, totalAngle)
    }

    def getRotatedImageSWT(bufferedImage : _root_.org.eclipse.swt.graphics.Image, newSwtImage : _root_.org.eclipse.swt.graphics.Image, gc : GC, totalAngle : Int) : _root_.org.eclipse.swt.graphics.Image = {
        return this.getRotatedImage2(bufferedImage, newSwtImage, gc, totalAngle)
    }

    def getRotatedImages(bufferedImage : _root_.org.eclipse.swt.graphics.Image, numberOfFrames : Int, totalAngle : Int) : Array[_root_.org.eclipse.swt.graphics.Image] = {
        val bufferedImageArray : Array[_root_.org.eclipse.swt.graphics.Image] = new Array[_root_.org.eclipse.swt.graphics.Image](numberOfFrames)
        var angle : Int = 0
        val size : Int = bufferedImageArray.length

        {
            var index : Int = 0
            while (index < size) {
                angle = (totalAngle / size) * index
                bufferedImageArray(index) = this.getRotatedImage(bufferedImage, angle)
                index += 1
            }
        }
        return bufferedImageArray
    }

    def createSpriteImage(bufferedImageArray : Array[_root_.org.eclipse.swt.graphics.Image]) : _root_.org.eclipse.swt.graphics.Image = {
        var columns : Int = 9
        var rows : Int = 0
        val size : Int = bufferedImageArray.length
        if (size < columns) {
            columns = size
        }
        rows = (size / columns)
        //Extra row for incomplete but needed row
        if ((size % columns) != 0) {
            rows += 1
        }
        val firstBufferedImage : _root_.org.eclipse.swt.graphics.Image = bufferedImageArray(0)
        var imageData : ImageData = firstBufferedImage.getImageData()
        val bufferedImage : _root_.org.eclipse.swt.graphics.Image = this.imageUtil.create(imageData.width * columns, imageData.height * rows)
        val gc : GC = new GC(bufferedImage)
        //g.clearRect(0, 0, newBufferedImage.getWidth(), newBufferedImage.getHeight());
        gc.setAntialias(SWT.ON)
        gc.setInterpolation(SWT.HIGH)
        var columnIndex : Int = 0
        var rowIndex : Int = 0
        var nextBufferedImage : _root_.org.eclipse.swt.graphics.Image = null

        {
            var index : Int = 0
            while (index < size) {
                if (((index / 9) != 0) && ((index % 9) == 0)) {
                    rowIndex += 1
                    columnIndex = 0
                }
                nextBufferedImage = bufferedImageArray(index)
                imageData = nextBufferedImage.getImageData()
                gc.drawImage(bufferedImage, 0, 0, bufferedImage.getBounds().width, bufferedImage.getBounds().height, imageData.width * columnIndex, imageData.height * rowIndex, imageData.width, imageData.height)
                columnIndex += 1
                index += 1
            }
        }
        gc.dispose()
        return bufferedImage
    }

}

object ImageSwtRotationUtil {
    private val instance : ImageSwtRotationUtil = new ImageSwtRotationUtil()

    /**      * @return the instance      */
    def getInstance() : ImageSwtRotationUtil = {
        return ImageSwtRotationUtil.instance
    }

}


