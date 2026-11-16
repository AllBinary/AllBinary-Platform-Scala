/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.microemu.device.playn.PlaynImage
import _root_.org.microemu.device.ResourceCallbackStrings
import _root_.playn.core.Canvas
import _root_.playn.core.CanvasImage
import _root_.playn.core.util.Callback

/**  *  * @author User  */
class ImageModifierUtil {
    import _root_.org.allbinary.media.image.ImageModifierUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val resourceCallbackStrings : ResourceCallbackStrings = ResourceCallbackStrings.getInstance()

    private var alphaArray : Array[Boolean] = null

    def setColor(unusedOriginalImage : Image, image : Image, imageIndex : Int, basicColor : BasicColor) : Unit = {
    }

    def changeColor(unusedOriginalImage : Image, image : Image, imageIndex : Int, basicColor : BasicColor) : Unit = {
    }

    def setAlpha(originalImage : Image, image : Image, imageIndex : Int, alpha : Int) : Unit = {
        val alphaF : Float = alpha
        val alphaFloat : Float = alphaF / 255
        //final int alphaInt = alpha * 100 / 255;
        this.setAlphaF(originalImage, image, imageIndex, alphaFloat)
    }

    def setAlphaF(originalImage : Image, image : Image, imageIndex : Int, alpha : Float) : Unit = {
        if (this.alphaArray(imageIndex)) {
            this.alphaArray(imageIndex) = false
            this.setAlpha2(originalImage, image, imageIndex, alpha)
        }
    }

    def setAlpha2(originalImage : Image, image : Image, imageIndex : Int, alpha : Float) : Unit = {
        //            if(originalImage != null) {
        val htmlImage : PlaynImage = image.asInstanceOf[PlaynImage]
        //                if (htmlImage != null) {
        val canvasImage : CanvasImage = htmlImage.getImage().asInstanceOf[CanvasImage]
        //this.logUtil.putF("alpha: " + alpha, this, "setAlpha");
        val originalPlaynImage : _root_.playn.core.Image = (originalImage.asInstanceOf[PlaynImage]).getImage().asInstanceOf[_root_.playn.core.Image]
        //                        if(originalPlaynImage != null) {
        val canvas : Canvas = canvasImage.canvas()
        canvas.clear()
        canvas.setAlpha(alpha)
        canvas.drawImage(originalPlaynImage, 0, 0)
    }

    def setAlpha3(image : Image, alpha : Float) : Unit = {
        val alphaF : Float = alpha
        val alphaFloat : Float = alphaF / 255
        val htmlImage : PlaynImage = image.asInstanceOf[PlaynImage]
        val canvasImage : CanvasImage = htmlImage.getImage().asInstanceOf[CanvasImage]
        val canvas : Canvas = canvasImage.canvas()
        canvas.setAlpha(alphaFloat)
    }

    def getImageArray(originalImageArray : Array[Image]) : Array[Image] = {
        val size : Int = originalImageArray.length
        this.alphaArray = new Array[Boolean](size)
        val imageArray : Array[Image] = new Array[Image](size)

        {
            var index : Int = 0
            while (index < size) {
                imageArray(index) = originalImageArray(index)
                this.handleImage(imageArray, index, originalImageArray(index))
                index += 1
            }
        }
        return imageArray
    }

    def handleImage(imageArray : Array[Image], index : Int, image : Image) : Unit = {
        val image3 : _root_.playn.core.Image = (image.asInstanceOf[PlaynImage]).getImage().asInstanceOf[_root_.playn.core.Image]
        if (image3 != null) {
            if ((image3.isReady() || ((image3.width() + image3.height()) <= 0)) || (image.getName() == this.resourceCallbackStrings.FROM_DATA)) {
                this.copy(imageArray, index, image, image3)
            } else {
                val callback : Callback = new Callback {
                        override def onSuccess(resource : Object) : Unit = {
                            val logUtil : LogUtil = LogUtil.getInstance()
                            logUtil.putF(resourceCallbackStrings.DONE + image.getName(), this, resourceCallbackStrings.HANDLE_IMAGE)
                            copy(imageArray, index, image, image3)
                        }

                        override def onFailure(e : Throwable) : Unit = {
                            val logUtil : LogUtil = LogUtil.getInstance()
                            logUtil.putF(new StringMaker().append(commonStrings.EXCEPTION_LABEL).append(resourceCallbackStrings.ERROR).append(image.getName()).toString(), this, resourceCallbackStrings.HANDLE_IMAGE)
                        }

                    }
                image3.addCallback(callback)
            }
        } else {
            this.logUtil.putF(this.resourceCallbackStrings.NULL + image.isMutable(), this, this.resourceCallbackStrings.HANDLE_IMAGE)
        }
    }

    def copy(imageArray : Array[Image], index : Int, image : Image, image3 : _root_.playn.core.Image) : Unit = {
        try {
            //this.logUtil.put(DONE + image3.width() + ", " + image3.height(), this, HANDLE_IMAGE);
            val image2 : Image = Image.createImage(image3.width(), image3.height())
            val graphics : Graphics = image2.getGraphics()
            graphics.drawImage(image, 0, 0, Anchor.TOP_LEFT)
            imageArray(index) = image2
        } catch {
            case e : Exception => {
                this.logUtil.putF(this.commonStrings.EXCEPTION_LABEL + resourceCallbackStrings.DONE, this, resourceCallbackStrings.HANDLE_IMAGE)
            }
        }
    }

    def reset() : Unit = {
        val size : Int = this.alphaArray.length

        {
            var index : Int = 0
            while (index < size) {
                this.alphaArray(index) = true
                index += 1
            }
        }
    }

}

object ImageModifierUtil {
    def getInstanceOrCreate() : ImageModifierUtil = {
        return new ImageModifierUtil()
    }

}


