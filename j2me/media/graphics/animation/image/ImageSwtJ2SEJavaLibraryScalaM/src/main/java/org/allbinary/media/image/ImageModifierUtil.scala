/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureFactory
import _root_.org.allbinary.image.opengles.ModifierOpenGLESImageProcessor
import _root_.org.allbinary.image.opengles.OpenGLESImage
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.eclipse.swt.graphics.ImageData
import _root_.org.microemu.device.swt.SwtImmutableImage
import _root_.org.microemu.device.swt.SwtMutableImage

/**  *  * @author User  */
class ImageModifierUtil {
    import _root_.org.allbinary.media.image.ImageModifierUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //private final ImageCreationUtil imageCreationUtil = ImageCreationUtil.getInstance();
    private val imageCopyUtil : ImageCopyUtil = ImageCopyUtil.getInstance()

    private val features : Features = Features.getInstance()

    def setBasicColorP(basicColor : BasicColor) : Unit = {
    }

    //private final int[] colorArray = new int[1];
    def setColor(unusedOriginalImage : Image, image : Image, imageIndex : Int, basicColor : BasicColor) : Unit = {
        var newBufferedImage : _root_.org.eclipse.swt.graphics.Image = null
        if (image.isMutable()) {
            val swtImage : SwtMutableImage = image.asInstanceOf[SwtMutableImage]
            newBufferedImage = swtImage.getImage().asInstanceOf[_root_.org.eclipse.swt.graphics.Image]
        } else {
            val swtImage : SwtImmutableImage = image.asInstanceOf[SwtImmutableImage]
            //X cannot be cast to class java.awt.image.org.eclipse.swt.graphics.Image
            newBufferedImage = swtImage.getImage().asInstanceOf[_root_.org.eclipse.swt.graphics.Image]
        }
        val r : Short = basicColor.red
        val g : Short = basicColor.green
        val b : Short = basicColor.blue
        val width : Int = image.getWidth()
        val height : Int = image.getHeight()
        val imageData : ImageData = newBufferedImage.getImageData()
        if (imageData.depth == 24) {
            //int ax;
            var rx : Int = 0
            var gx : Int = 0
            var bx : Int = 0
            var index3 : Int = 0

            {
                var index : Int = 0
                while (index < width) {

                    {
                        var index2 : Int = 0
                        while (index2 < height) {
                            //pixel = imageData.getPixel(index, index2);
                            index3 = (index2 * imageData.bytesPerLine) + (index * 4)
                            rx = (imageData.data(index3) & 0xFF) << 16
                            gx = (imageData.data(index3 + 1) & 0xFF) << 8
                            bx = (imageData.data(index3 + 2) & 0xFF)
                            if (((rx != 0) || (gx != 0)) || (bx != 0)) {
                                imageData.data(index3) = r.toByte
                                imageData.data(index3 + 1) = g.toByte
                                imageData.data(index3 + 2) = b.toByte
                            }
                            index2 += 1
                        }
                    }
                    index += 1
                }
            }
        }
    }

    def changeColor(unusedOriginalImage : Image, image : Image, imageIndex : Int, basicColor : BasicColor) : Unit = {
        if (this.features.isFeature(OpenGLFeatureFactory.getInstance().OPENGL)) {
            //this.logUtil.putF(new StringMaker().append(NO_COPY2).append(" from: ").append(originalImage.getWidth()).append(commonSeps.SPACE).append(originalImage.getHeight()).append(" to: ").append(width).append(commonSeps.SPACE).append(height).toString(), this, this.commonStrings.CONSTRUCTOR);
            if (image.getType() >= OpenGLESImage.TYPE) {
                val openGLESImage : OpenGLESImage = (image.asInstanceOf[OpenGLESImage])
                openGLESImage.imageProcessor = ModifierOpenGLESImageProcessor.getInstance()
                openGLESImage.openGLESImageProperties.redf = basicColor.getRedComponent()
                openGLESImage.openGLESImageProperties.greenf = basicColor.getGreenComponent()
                openGLESImage.openGLESImageProperties.bluef = basicColor.getBlueComponent()
                return
            }
        }
        var newBufferedImage : _root_.org.eclipse.swt.graphics.Image = null
        if (image.isMutable()) {
            val swtImage : SwtMutableImage = image.asInstanceOf[SwtMutableImage]
            newBufferedImage = swtImage.getImage().asInstanceOf[_root_.org.eclipse.swt.graphics.Image]
        } else {
            val swtImage : SwtImmutableImage = image.asInstanceOf[SwtImmutableImage]
            //X cannot be cast to class java.awt.image.org.eclipse.swt.graphics.Image
            newBufferedImage = swtImage.getImage().asInstanceOf[_root_.org.eclipse.swt.graphics.Image]
        }
        val MAX : Float = 255
        val r : Float = (basicColor.red.toFloat) / MAX
        val g : Float = (basicColor.green.toFloat) / MAX
        val b : Float = (basicColor.blue.toFloat) / MAX
        //int ax;
        var rx : Int = 0
        var gx : Int = 0
        var bx : Int = 0
        val imageData : ImageData = newBufferedImage.getImageData()
        if (imageData.depth == 24) {
            //            }
            val size : Int = imageData.data.length

            {
                var index : Int = 0
                while (index < size) {
                    //pixel = imageData.getPixel(index, index2);
                    rx = (imageData.data(index) & 0xFF) << 16
                    gx = (imageData.data(index + 1) & 0xFF) << 8
                    bx = (imageData.data(index + 2) & 0xFF)
                    //ax *= a;
                    rx = (rx * r).toInt
                    gx = (gx * g).toInt
                    bx = (bx * b).toInt
                    imageData.data(index) = rx.toByte
                    imageData.data(index + 1) = gx.toByte
                    imageData.data(index + 2) = bx.toByte
                    index += 4
                }
            }
        }
    }

    def setAlpha(unusedOriginalImage : Image, image : Image, imageIndex : Int, alphaInt : Int) : Unit = {
        if (this.features.isFeature(OpenGLFeatureFactory.getInstance().OPENGL)) {
            //this.logUtil.putF(new StringMaker().append(NO_COPY2).append(" from: ").append(originalImage.getWidth()).append(commonSeps.SPACE).append(originalImage.getHeight()).append(" to: ").append(width).append(commonSeps.SPACE).append(height).toString(), this, this.commonStrings.CONSTRUCTOR);
            if (image.getType() >= OpenGLESImage.TYPE) {
                val openGLESImage : OpenGLESImage = (image.asInstanceOf[OpenGLESImage])
                openGLESImage.imageProcessor = ModifierOpenGLESImageProcessor.getInstance()
                openGLESImage.openGLESImageProperties.alphaf = (alphaInt.toFloat) / 255f
                return
            }
        }
        this.setAlphaSWT(image, alphaInt)
    }

    def setAlphaSWT(image : Image, alphaInt : Int) : Unit = {
        var alpha : Byte = alphaInt.toByte
        var newBufferedImage : _root_.org.eclipse.swt.graphics.Image = null
        if (image.isMutable()) {
            val swtImage : SwtMutableImage = image.asInstanceOf[SwtMutableImage]
            newBufferedImage = swtImage.getImage().asInstanceOf[_root_.org.eclipse.swt.graphics.Image]
        } else {
            val swtImage : SwtImmutableImage = image.asInstanceOf[SwtImmutableImage]
            //X cannot be cast to class java.awt.image.org.eclipse.swt.graphics.Image
            newBufferedImage = swtImage.getImage().asInstanceOf[_root_.org.eclipse.swt.graphics.Image]
        }
        newBufferedImage.getImageData().alpha = alpha
    }

    def getImageArray(originalImageArray : Array[Image]) : Array[Image] = {
        //return originalImageArray;
        try {
            val newImageArray : Array[Image] = new Array[Image](originalImageArray.length)
            val size : Int = newImageArray.length
            var originalImage : Image = null

            {
                var index : Int = 0
                while (index < size) {
                    originalImage = originalImageArray(index)
                    //image.getGraphics().drawImage(originalImage, 0, 0, Anchor.TOP_LEFT);
                    val image : Image = this.imageCopyUtil.createImage(originalImage)
                    newImageArray(index) = image
                    index += 1
                }
            }
            return newImageArray
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                PreLogUtil.putOE(commonStrings.EXCEPTION, this, "getImageArray", e)
                return originalImageArray
            }
        }
        throw new IllegalStateException()
    }

    def handleImage(imageArray : Array[Image], index : Int, image : Image) : Unit = {
    }

    def reset() : Unit = {
    }

}

object ImageModifierUtil {
    private val instance : ImageModifierUtil = new ImageModifierUtil()

    /**      * @return the instance      */
    def getInstanceOrCreate() : ImageModifierUtil = {
        return ImageModifierUtil.instance
    }

}


