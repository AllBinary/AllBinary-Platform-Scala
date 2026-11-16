/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.GameFeatureFactory
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureFactory
import _root_.org.allbinary.graphics.opengles.OpenGLUtil
import _root_.org.allbinary.image.opengles.OpenGLESDeviceImageTranslate
import _root_.org.allbinary.image.opengles.OpenGLESImage
import _root_.org.allbinary.image.opengles.OpenGLESImageExclusionUtil
import _root_.org.allbinary.image.opengles.OpenGLESImageProperties
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.eclipse.swt.graphics.ImageData
import _root_.org.microemu.app.ui.swt.SwtDeviceComponent
import _root_.org.microemu.device.swt.PostLoadSwtImmutableImageProcessor
import _root_.org.microemu.device.swt.PostLoadSwtMutableImageProcessor
import _root_.org.microemu.device.swt.SwtImmutableImage
import _root_.org.microemu.device.swt.SwtMutableImage

class ImageCopyUtil private() {
    import _root_.org.allbinary.media.image.ImageCopyUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //private int anchor = Anchor.TOP_LEFT;
    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    //private final CommonSeps commonSeps = CommonSeps.getInstance();
    private val gameFeatureFactory : GameFeatureFactory = GameFeatureFactory.getInstance()

    private val features : Features = Features.getInstance()

    private val openGLFeatureFactory : OpenGLFeatureFactory = OpenGLFeatureFactory.getInstance()

    private val openGLUtil : OpenGLUtil = OpenGLUtil.getInstance()

    private val openGLESImageExclusionUtil : OpenGLESImageExclusionUtil = OpenGLESImageExclusionUtil.getInstance()

    private val NO_COPY : String = "SWT should not copy images after initial loading as the alpha is not honored"

    //private final String NO_COPY2 = "JOGL support for SWT Image copy is not implemented";
    private val UNABLE : String = "Unable to scale image without dimensions"

    private val INFORMATION : String = "about_"

    private val LEADERBOARD : String = "leaderboard"

    def createImageForRotation(originalImage : Image) : Image = {
        if (this.features.isFeature(this.openGLFeatureFactory.OPENGL)) {
            var image : Image = originalImage
            image = this.openGLUtil.addImage(image)
            return image
        } else {
            return this.createImage(originalImage)
        }
        throw new IllegalStateException()
    }

    // String resource,
    def createImage(originalImage : Image) : Image = {
        if (!this.features.isFeature(this.gameFeatureFactory.POST_IMAGE_LOADING_MODIFICATION)) {
            this.logUtil.putF(this.NO_COPY, this, this.commonStrings.CONSTRUCTOR)
            return originalImage
        }
        var originalImage2 : Image = originalImage
        if (this.features.isFeature(this.openGLFeatureFactory.OPENGL)) {
            //this.logUtil.putF(new StringMaker().append(NO_COPY2).append(" from: ").append(originalImage.getWidth()).append(commonSeps.SPACE).append(originalImage.getHeight()).append(" to: ").append(width).append(commonSeps.SPACE).append(height).toString(), this, this.commonStrings.CONSTRUCTOR);
            if (originalImage.getType() >= OpenGLESImage.TYPE) {
                val openGLESImage : OpenGLESImage = (originalImage.asInstanceOf[OpenGLESImage])
                originalImage2 = openGLESImage.openGLBitmap.getImage()
            }
        }
        //Image image = null;
        var image : Image = null
        //final org.eclipse.swt.graphics.Image swtImage = mutableImage.img;
        if (originalImage2.isMutable()) {
            val originalMutableImage : SwtMutableImage = originalImage2.asInstanceOf[SwtMutableImage]
            //            image = new SwtMutableImage(SwtDeviceComponent.createImage(imageData0));
            image = new SwtMutableImage(SwtDeviceComponent.createImage(originalMutableImage.image.getImageData()))
        } else {
            val originalImmutableImage : SwtImmutableImage = originalImage2.asInstanceOf[SwtImmutableImage]
            //              if(originalImmutableImage.getImage() != null) {
            image = new SwtMutableImage(SwtDeviceComponent.createImage(originalImmutableImage.image.getImageData()))
        }
        //            
        image = this.openGLUtil.addImage(image)
        return image
    }

    def createImageWH(originalImage : Image, width : Int, height : Int, mutable : Boolean) : Image = {
        var originalImage2 : Image = originalImage
        if (!this.features.isFeature(this.gameFeatureFactory.POST_IMAGE_LOADING_MODIFICATION)) {
            this.logUtil.putF(this.NO_COPY, this, this.commonStrings.CONSTRUCTOR)
            return originalImage
        }
        //if(originalImage instanceof OpenGLESImage) {
        if (this.features.isFeature(this.openGLFeatureFactory.OPENGL)) {
            if (this.openGLESImageExclusionUtil.isCustomScaling(originalImage)) {
                return this.createImage2(originalImage, width, height, mutable)
            }
            //this.logUtil.putF(new StringMaker().append(NO_COPY2).append(" from: ").append(originalImage.getWidth()).append(commonSeps.SPACE).append(originalImage.getHeight()).append(" to: ").append(width).append(commonSeps.SPACE).append(height).toString(), this, this.commonStrings.CONSTRUCTOR);
            if (originalImage.getType() >= OpenGLESImage.TYPE) {
                val openGLESImage : OpenGLESImage = (originalImage.asInstanceOf[OpenGLESImage])
                originalImage2 = openGLESImage.openGLBitmap.getImage()
            }
        }
        var image : Image = null
        if (originalImage2.isMutable() && mutable) {
            val originalMutableImage : SwtMutableImage = originalImage2.asInstanceOf[SwtMutableImage]
            if (originalMutableImage.getImage() != null) {
                val imageData2 : ImageData = originalMutableImage.image.getImageData()
                //                if(imageData2.data.length != 120000) {
                val imageData : ImageData = imageData2.scaledTo(width, height)
                image = new SwtMutableImage(SwtDeviceComponent.createImage(imageData))
            } else {
                image = new SwtMutableImage(originalMutableImage.getName(), new PostLoadSwtMutableImageProcessor(originalMutableImage))
            }
        } else {
            val originalImmutableImage : SwtImmutableImage = originalImage2.asInstanceOf[SwtImmutableImage]
            if (originalImmutableImage.getImage() != null) {
                val imageData2 : ImageData = originalImmutableImage.image.getImageData()
                //                if(imageData2.data.length != 120000) {
                if ((width > 0) && (height > 0)) {
                    val imageData : ImageData = imageData2.scaledTo(width, height)
                    image = new SwtImmutableImage(originalImage.getName(), SwtDeviceComponent.createImage(imageData))
                } else {
                    this.logUtil.putF(UNABLE, this, this.commonStrings.CONSTRUCTOR)
                    image = new SwtImmutableImage(originalImmutableImage.getName(), new PostLoadSwtImmutableImageProcessor(originalImmutableImage))
                }
            } else {
                image = new SwtImmutableImage(originalImmutableImage.getName(), new PostLoadSwtImmutableImageProcessor(originalImmutableImage))
            }
        }
        image = this.openGLUtil.addImage(image)
        return image
    }

    //private final String GREEN_BUTTON = "green_button";
    def createImage2(originalImage : Image, width : Int, height : Int, mutable : Boolean) : Image = {
        var originalImage2 : Image = originalImage
        if (!this.features.isFeature(this.gameFeatureFactory.POST_IMAGE_LOADING_MODIFICATION)) {
            this.logUtil.putF(this.NO_COPY, this, this.commonStrings.CONSTRUCTOR)
            return originalImage
        }
        var image : Image = null
        //if(originalImage instanceof OpenGLESImage) {
        if (this.features.isFeature(this.openGLFeatureFactory.OPENGL)) {
            //this.logUtil.putF(new StringMaker().append(NO_COPY2).append(" from: ").append(width2).append(commonSeps.SPACE).append(height2).append(" to: ").append(width).append(commonSeps.SPACE).append(height).toString(), this, this.commonStrings.CONSTRUCTOR);
            val displayInfoSingleton : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
            if (originalImage.getType() >= OpenGLESImage.TYPE) {
                //this.logUtil.putF("TWB0: " + originalImage.getWidth() + " h: " + originalImage.getHeight(), this, this.commonStrings.CONSTRUCTOR);
                val openGLESImage : OpenGLESImage = (originalImage.asInstanceOf[OpenGLESImage])
                val openGLESImageProperties : OpenGLESImageProperties = openGLESImage.openGLESImageProperties
                //this.logUtil.putF(new StringMaker().append("0sx: ").append(openGLESImageProperties.scaleX2).append(" sy: ").append(openGLESImageProperties.scaleY2).toString(), this, this.commonStrings.CONSTRUCTOR);
                val openGLWidth : Int = openGLESImage.openGLBitmap.getWidth()
                val openGLHeight : Int = openGLESImage.openGLBitmap.getHeight()
                openGLESImageProperties.scaleX = { openGLESImageProperties.scaleX2 = ((width.toFloat) / openGLWidth); openGLESImageProperties.scaleX2 }
                openGLESImageProperties.scaleY = { openGLESImageProperties.scaleY2 = ((height.toFloat) / openGLHeight); openGLESImageProperties.scaleY2 }
                openGLESImageProperties.scaleX = openGLESImageProperties.scaleX * 0.75f
                openGLESImageProperties.scaleY = openGLESImageProperties.scaleY * 0.75f
                if ((originalImage.getHeight() % 2) != 0) {
                    //this.logUtil.putF(new StringMaker().append("sx: ").append(openGLESImageProperties.scaleX2).append(" sy: ").append(openGLESImageProperties.scaleY2).toString(), this, this.commonStrings.CONSTRUCTOR);
                    openGLESImageProperties.scaleX2 += 1.0f / openGLWidth
                    openGLESImageProperties.scaleY2 += 1.0f / openGLHeight
                }
                //openGLESImageProperties.translateY = -displayInfoSingleton.getLastHeight() / 40 / openGLESImage.scaleY;
                image = openGLESImage
            } else {
                //this.logUtil.putF("type: " + originalImage.getType(), this, this.commonStrings.CONSTRUCTOR);
                image = originalImage
                val openGLESImage : OpenGLESImage = this.openGLUtil.addImage(image).asInstanceOf[OpenGLESImage]
                val openGLESImageProperties : OpenGLESImageProperties = openGLESImage.openGLESImageProperties
                openGLESImageProperties.scaleX = { openGLESImageProperties.scaleX2 = ((width.toFloat) / openGLESImage.getWidth()).toFloat; openGLESImageProperties.scaleX2 }
                openGLESImageProperties.scaleY = { openGLESImageProperties.scaleY2 = ((height.toFloat) / openGLESImage.getHeight()).toFloat; openGLESImageProperties.scaleY2 }
                if (image.getName().startsWith(this.INFORMATION)) {
                    openGLESImage.openGLESImageTranslate = new OpenGLESDeviceImageTranslate()
                    val openGLESDeviceImageTranslate : OpenGLESDeviceImageTranslate = openGLESImage.openGLESImageTranslate.asInstanceOf[OpenGLESDeviceImageTranslate]
                    openGLESDeviceImageTranslate.translateX = (displayInfoSingleton.getLastWidth() / 1.4f) / openGLESImageProperties.scaleX
                    openGLESDeviceImageTranslate.translateY = (displayInfoSingleton.getLastHeight() / 4) / openGLESImageProperties.scaleY
                    openGLESImageProperties.scaleX = openGLESImageProperties.scaleX * 0.25f
                    openGLESImageProperties.scaleY = openGLESImageProperties.scaleY * 0.25f
                } else {
                    //                    } else {
                    openGLESImageProperties.scaleX = openGLESImageProperties.scaleX * 0.75f
                    openGLESImageProperties.scaleY = openGLESImageProperties.scaleY * 0.75f
                    //                    }
                    if (image.getName().startsWith(this.LEADERBOARD)) {
                        openGLESImage.openGLESImageTranslate = new OpenGLESDeviceImageTranslate()
                        val openGLESDeviceImageTranslate : OpenGLESDeviceImageTranslate = openGLESImage.openGLESImageTranslate.asInstanceOf[OpenGLESDeviceImageTranslate]
                        openGLESDeviceImageTranslate.translateX = (-displayInfoSingleton.getLastWidth() / 40) / openGLESImageProperties.scaleX
                    }
                    if (image.getName().startsWith(this.LEADERBOARD)) {
                    } else {
                        openGLESImageProperties.scaleX = 1.0f
                        openGLESImageProperties.scaleY = 1.0f
                    }
                }
                //this.logUtil.putF(new StringMaker().append("sx: ").append(openGLESImageProperties.scaleX).append(" sy: ").append(openGLESImage.scaleY).append(" tx: ").append(openGLESImageProperties.translateX).append(" ty: ").append(openGLESImageProperties.translateY).toString(), this, this.commonStrings.CONSTRUCTOR);
                image = openGLESImage
            }
        } else {
            if (originalImage2.isMutable() && mutable) {
                val originalMutableImage : SwtMutableImage = originalImage2.asInstanceOf[SwtMutableImage]
                if (originalMutableImage.getImage() != null) {
                    val imageData2 : ImageData = originalMutableImage.image.getImageData()
                    //                    if (imageData2.data.length != 120000) {
                    val imageData : ImageData = imageData2.scaledTo(width, height)
                    image = new SwtMutableImage(SwtDeviceComponent.createImage(imageData))
                } else {
                    image = new SwtMutableImage(originalMutableImage.getName(), new PostLoadSwtMutableImageProcessor(originalMutableImage))
                }
            } else {
                val originalImmutableImage : SwtImmutableImage = originalImage2.asInstanceOf[SwtImmutableImage]
                if (originalImmutableImage.getImage() != null) {
                    val imageData2 : ImageData = originalImmutableImage.image.getImageData()
                    //                    if (imageData2.data.length != 120000) {
                    val imageData : ImageData = imageData2.scaledTo(width, height)
                    image = new SwtImmutableImage(originalImage.getName(), SwtDeviceComponent.createImage(imageData))
                } else {
                    image = new SwtImmutableImage(originalImmutableImage.getName(), new PostLoadSwtImmutableImageProcessor(originalImmutableImage))
                }
            }
            image = this.openGLUtil.addImage(image)
        }
        return image
    }

    def createImageScale(originalImage : Image, canvasScale : Float, resize : Boolean) : Image = {
        if (!this.features.isFeature(this.gameFeatureFactory.POST_IMAGE_LOADING_MODIFICATION)) {
            this.logUtil.putF(this.NO_COPY, this, this.commonStrings.CONSTRUCTOR)
            return originalImage
        }
        //        this.logUtil.putF(new StringMaker().append(spacialStrings.WIDTH_LABEL).append(originalImage.getWidth()).append(spacialStrings.HEIGHT_LABEL).append(originalImage.getHeight()).toString(), this, this.commonStrings.CONSTRUCTOR);
        var newWidth : Int = (originalImage.getWidth() * canvasScale).toInt
        var newHeight : Int = (originalImage.getHeight() * canvasScale).toInt
        if (resize) {
            if (newWidth < newHeight) {
                newWidth = newHeight
            }
            if (newHeight < newWidth) {
                newHeight = newWidth
            }
        }
        //final Image image = imageCreationUtil.getInstance(newWidth, newHeight);
        val image : Image = this.createImageWH(originalImage, newWidth, newHeight, true)
        if (image.isMutable()) {
            var originalImageData : ImageData = (originalImage.getImage().asInstanceOf[_root_.org.eclipse.swt.graphics.Image]).getImageData()
            val mutableImage2 : SwtMutableImage = image.asInstanceOf[SwtMutableImage]
            val halfWidthDelta : Int = (newWidth - originalImage.getWidth()) / 2
            val halfHeightDelta : Int = (newHeight - originalImage.getHeight()) / 2
            val originalPixelArray : Array[Int] = new Array[Int](originalImage.getWidth() * originalImage.getHeight())
            val newPixelArray : Array[Int] = new Array[Int](image.getWidth() * image.getHeight())
            val width : Int = originalImage.getWidth()
            val height : Int = originalImage.getHeight()

            {
                var i : Int = 0
                while (i < height) {
                    originalImageData.getPixels(0, i, width, originalPixelArray, (i * width))
                    i += 1
                }
            }

            {
                var index : Int = halfWidthDelta
                while (index < width) {

                    {
                        var index2 : Int = halfHeightDelta
                        while (index2 < height) {
                            newPixelArray(index + (index2 * width)) = originalPixelArray((index - halfWidthDelta) + ((index2 - halfHeightDelta) * width))
                            index2 += 1
                        }
                    }
                    index += 1
                }
            }
            (mutableImage2.getImage().asInstanceOf[_root_.org.eclipse.swt.graphics.Image]).getImageData().setPixels(0, 0, image.getWidth(), newPixelArray, 0)
            //graphics.drawRect(0, 0, newWidth, newHeight);
            return image
        } else {
            val originalImmutableImage : SwtImmutableImage = image.asInstanceOf[SwtImmutableImage]
            var originalImageData : ImageData = (originalImage.getImage().asInstanceOf[_root_.org.eclipse.swt.graphics.Image]).getImageData()
            val halfWidthDelta : Int = (newWidth - originalImage.getWidth()) / 2
            val halfHeightDelta : Int = (newHeight - originalImage.getHeight()) / 2
            val originalPixelArray : Array[Int] = new Array[Int](originalImage.getWidth() * originalImage.getHeight())
            val newPixelArray : Array[Int] = new Array[Int](image.getWidth() * image.getHeight())
            val width : Int = originalImage.getWidth()
            val height : Int = originalImage.getHeight()

            {
                var i : Int = 0
                while (i < height) {
                    originalImageData.getPixels(0, i, width, originalPixelArray, (i * width))
                    i += 1
                }
            }

            {
                var index : Int = halfWidthDelta
                while (index < width) {

                    {
                        var index2 : Int = halfHeightDelta
                        while (index2 < height) {
                            newPixelArray(index + (index2 * width)) = originalPixelArray((index - halfWidthDelta) + ((index2 - halfHeightDelta) * width))
                            index2 += 1
                        }
                    }
                    index += 1
                }
            }
            (originalImmutableImage.getImage().asInstanceOf[_root_.org.eclipse.swt.graphics.Image]).getImageData().setPixels(0, 0, image.getWidth(), newPixelArray, 0)
            return image
        }
        throw new IllegalStateException()
    }

}

object ImageCopyUtil {
    private val instance : ImageCopyUtil = new ImageCopyUtil()

    def getInstance() : ImageCopyUtil = {
        return ImageCopyUtil.instance
    }

}


