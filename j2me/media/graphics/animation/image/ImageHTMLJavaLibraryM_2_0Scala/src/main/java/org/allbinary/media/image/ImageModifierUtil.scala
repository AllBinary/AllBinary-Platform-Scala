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
import _root_.playn.core.Callback
import _root_.playn.core.Canvas
import _root_.playn.core.CoreImage
import _root_.playn.core.ImageImpl
import _root_.playn.html.HTMLPlaynUtil

/**  *  * @author User  */
class ImageModifierUtil {
    import _root_.org.allbinary.media.image.ImageModifierUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val resourceCallbackStrings : ResourceCallbackStrings = ResourceCallbackStrings.getInstance()

    private val playnUtil : HTMLPlaynUtil = HTMLPlaynUtil.getInstance()

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
        val canvasImage : ImageImpl = htmlImage.getImage().asInstanceOf[ImageImpl]
        //this.logUtil.putF("alpha: " + alpha, this, "setAlpha");
        val originalPlaynImage : CoreImage = (originalImage.asInstanceOf[PlaynImage]).getImage().asInstanceOf[CoreImage]
        //                        if(originalPlaynImage != null) {
        val canvas : Canvas = this.playnUtil.getCanvas(canvasImage)
        canvas.clear()
        canvas.setAlpha(alpha)
        canvas.draw(originalPlaynImage, 0, 0)
    }

    def setAlpha3(image : Image, alpha : Float) : Unit = {
        val alphaF : Float = alpha
        val alphaFloat : Float = alphaF / 255
        val htmlImage : PlaynImage = image.asInstanceOf[PlaynImage]
        val canvasImage : ImageImpl = htmlImage.getImage().asInstanceOf[ImageImpl]
        val canvas : Canvas = this.playnUtil.getCanvas(canvasImage)
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

    class ImageCopyCallback(param_imageModifierUtil : ImageModifierUtil, param_imageArray : Array[Image], param_index : Int, param_image : Image, param_image3 : CoreImage) extends Callback {

        private[ImageCopyCallback] var imageModifierUtil : ImageModifierUtil = null

        private[ImageCopyCallback] var imageArray : Array[Image] = null

        private[ImageCopyCallback] var index : Int = 0

        private[ImageCopyCallback] var image : Image = null

        private[ImageCopyCallback] var image3 : CoreImage = null

        //Constructor
        {
            val imageModifierUtil : ImageModifierUtil = param_imageModifierUtil
            val imageArray : Array[Image] = param_imageArray
            val index : Int = param_index
            val image : Image = param_image
            val image3 : CoreImage = param_image3
            this.imageModifierUtil = imageModifierUtil
            this.imageArray = imageArray
            this.index = index
            this.image = image
            this.image3 = image3
        }

        override def onSuccess(resource : Object) : Unit = {
            val logUtil : LogUtil = LogUtil.getInstance()
            val resourceCallbackStrings : ResourceCallbackStrings = this.imageModifierUtil.resourceCallbackStrings
            logUtil.putF(resourceCallbackStrings.DONE + this.image.getName(), this, resourceCallbackStrings.HANDLE_IMAGE)
            this.imageModifierUtil.copy(this.imageArray, this.index, this.image, this.image3)
        }

        override def onFailure(e : Throwable) : Unit = {
            val logUtil : LogUtil = LogUtil.getInstance()
            val resourceCallbackStrings : ResourceCallbackStrings = this.imageModifierUtil.resourceCallbackStrings
            logUtil.put(new StringMaker().append(this.imageModifierUtil.commonStrings.EXCEPTION_LABEL).append(resourceCallbackStrings.ERROR).append(this.image.getName()).toString(), this, resourceCallbackStrings.HANDLE_IMAGE, e)
        }

    }

    def handleImage(imageArray : Array[Image], index : Int, image : Image) : Unit = {
        val image3 : CoreImage = (image.asInstanceOf[PlaynImage]).getImage().asInstanceOf[CoreImage]
        if (image3 != null) {
            //PreLogUtil.put("playnCoreImage: " + (image3 != null ? image3.toString() : StringUtil.getInstance().NULL_STRING), this, "handleImage");
            if ((image3.isReady() || ((image3.width() + image3.height()) <= 0)) || (image.getName() == this.resourceCallbackStrings.FROM_DATA)) {
                this.copy(imageArray, index, image, image3)
            } else {
                val callback : Callback = new ImageCopyCallback(this, imageArray, index, image, image3)
                image3.addCallback(callback)
            }
        } else {
            this.logUtil.putF(this.resourceCallbackStrings.NULL + image.isMutable(), this, this.resourceCallbackStrings.HANDLE_IMAGE)
        }
    }

    def copy(imageArray : Array[Image], index : Int, image : Image, image3 : CoreImage) : Unit = {
        try {
            //this.logUtil.put(DONE + image3.width() + ", " + image3.height(), this, HANDLE_IMAGE);
            val image2 : Image = Image.createImageWH(image3.width().toInt, image3.height().toInt)
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


