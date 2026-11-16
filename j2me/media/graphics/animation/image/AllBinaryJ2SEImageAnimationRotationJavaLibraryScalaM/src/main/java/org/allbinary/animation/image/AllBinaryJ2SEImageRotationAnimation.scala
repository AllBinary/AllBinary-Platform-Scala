/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.DisposalUtil
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.media.image.ImageCopyUtil
import _root_.org.allbinary.media.image.ImageModifierUtil
import _root_.org.allbinary.media.image.ImageRotationUtil

class AllBinaryJ2SEImageRotationAnimation(param_originalImage : Image, param_image : Image, param_angleInfo : AngleInfo, param_totalAngle : Short, param_animationBehavior : AnimationBehavior) extends ImageBaseRotationAnimation(param_image, param_angleInfo, param_totalAngle, param_animationBehavior) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val imageRotationUtil : ImageRotationUtil = ImageRotationUtil.getInstance()

    private val imageModifierUtil : ImageModifierUtil = ImageModifierUtil.getInstanceOrCreate()

    //private final float increment;
    private var realOriginalImage : Image = null

    private val originalImageArray : Array[Image] = new Array[Image](1)

    private val twoImages : Array[Image] = new Array[Image](2)

    private var imageToShow : Image = null

    private var bufferedImageIndex : Int = 0

    private var lastScaleX : Float = 1.0f

    private var lastScaleY : Float = 1.0f

    private var scaleX : Float = 1.0f

    private var scaleY : Float = 1.0f

    private var maxScaleX : Float = 0.0f

    private var maxScaleY : Float = 0.0f

    private var alphaProcessor : ModifierBaseProcessor = ModifierBaseProcessor.getInstance()

    private var setColorProcessor : ModifierBaseProcessor = ModifierBaseProcessor.getInstance()

    private var changeColorProcessor : ModifierBaseProcessor = ModifierBaseProcessor.getInstance()

    private var scaleProcessor : ScaleBaseProcessor = ScaleProcessor.getInstance()

    //protected
    //Constructor
    {
        val originalImage : Image = param_originalImage
        val image : Image = param_image
        val angleInfo : AngleInfo = param_angleInfo
        val totalAngle : Short = param_totalAngle
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.realOriginalImage = originalImage
        this.originalImageArray(0) = originalImage
        //this.increment = (short)(this.angleInfo.getAngleIncrementInfo().getAngleIncrement() * 2.44);
        this.imageToShow = image
        this.twoImages(0) = image
        this.twoImages(1) = ImageCopyUtil.getInstance().createImageForRotation(image)
    }

    override def setBasicColorP(basicColor : BasicColor) : Unit = {
        var changed : Boolean = false
        if ((this.getBasicColorP() == null) || (this.getBasicColorP().intValue() != basicColor.intValue())) {
            changed = true
        }
        super.setBasicColorP(basicColor)
        if (changed) {
            this.setColorProcessor = SetColorProcessor.getInstance()
            this.updateImage()
        }
    }

    override def changeBasicColor(basicColor : BasicColor) : Unit = {
        var changed : Boolean = false
        //if(this.getBasicColorP() == null || this.getBasicColorP().intValue() != basicColor.intValue()) {
        if ((this.getChangeBasicColor() == null) || (this.getChangeBasicColor().intValue() != basicColor.intValue())) {
            changed = true
        }
        super.changeBasicColor(basicColor)
        if (changed) {
            this.changeColorProcessor = ChangeColorProcessor.getInstance()
            this.updateImage()
        }
    }

    override def setAlpha(alpha : Int) : Unit = {
        var changed : Boolean = false
        if (this.alphaP != alpha) {
            changed = true
        }
        super.setAlpha(alpha)
        if (changed) {
            this.alphaProcessor = AlphaProcessor.getInstance()
            this.updateImage()
        }
    }

    override def setScale(scaleX : Float, scaleY : Float) : Unit = {
        //this.logUtil.putF(new StringMaker().append("scaleX: ").append(scaleX).append("scaleY: ").append(scaleY).toString(), this, "setScale");
        this.scaleX = scaleX
        this.scaleY = scaleY
        if ((this.scaleX != this.lastScaleX) || (this.scaleY != this.lastScaleY)) {
            this.scaleProcessor.update(this.realOriginalImage, this.originalImageArray, this.twoImages, this.bufferedImageIndex, this.scaleX, this.scaleY, this.maxScaleX, this.maxScaleY)
            this.updateImage()
        }
        this.lastScaleX = this.scaleX
        this.lastScaleY = this.scaleY
    }

    override def setMaxScale(maxScaleX : Float, maxScaleY : Float) : Unit = {
        //this.logUtil.putF("maxScaleX: " + maxScaleX, this, "setMaxScale");
        this.maxScaleX = maxScaleX
        this.maxScaleY = maxScaleY
        this.scaleProcessor.update(this.realOriginalImage, this.originalImageArray, this.twoImages, this.bufferedImageIndex, this.scaleX, this.scaleY, this.maxScaleX, this.maxScaleY)
        this.updateImage()
    }

    override def nextRotation() : Unit = {
        super.nextRotation()
        this.updateImage()
    }

    override def previousRotation() : Unit = {
        super.previousRotation()
        this.updateImage()
    }

    private def updateImage() : Unit = {
        this.imageRotationUtil.rotateImage(this.originalImageArray(0), this.twoImages(this.bufferedImageIndex), this.angleInfo.getAngle() + 90)
        this.alphaProcessor.updateAlpha(this.imageModifierUtil, NullImage.NULL_IMAGE, this.twoImages(this.bufferedImageIndex), 0, this.alphaP)
        this.setColorProcessor.updateColor(this.imageModifierUtil, NullImage.NULL_IMAGE, this.twoImages(this.bufferedImageIndex), 0, this.basicColor)
        this.changeColorProcessor.updateColor(this.imageModifierUtil, NullImage.NULL_IMAGE, this.twoImages(this.bufferedImageIndex), 0, this.changeBasicColorP)
        this.swap()
    }

    override def setFrame(index : Int) : Unit = {
        //this.logUtil.putF("currentFrame: " + currentFrame, this, "setRotation");
        super.setFrame(index)
        this.updateImage()
    }

    def swap() : Unit = {
        this.imageToShow = this.twoImages(this.bufferedImageIndex)
        if (this.bufferedImageIndex == 0) {
            this.bufferedImageIndex = 1
        } else {
            this.bufferedImageIndex = 0
        }
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        //graphics.drawString(this.toString(), x, y, anchor);
        graphics.drawImage(this.imageToShow, x, y, this.anchor)
    }

    override def close() : Unit = {
        super.close()
        val disposalUtil : DisposalUtil = DisposalUtil.getInstance()
        val size2 : Int = this.twoImages.length

        {
            var index : Int = 0
            while (index < size2) {
                disposalUtil.disposeImage(this.twoImages(index))
                index += 1
            }
        }
        val size : Int = this.originalImageArray.length

        {
            var index : Int = 0
            while (index < size) {
                disposalUtil.disposeImage(this.originalImageArray(index))
                index += 1
            }
        }
        disposalUtil.disposeImage(this.realOriginalImage)
        disposalUtil.disposeImage(this.imageToShow)
    }

    override def finalize() : Unit = {
        super.finalize()
        val disposalUtil : DisposalUtil = DisposalUtil.getInstance()
        val size2 : Int = this.twoImages.length

        {
            var index : Int = 0
            while (index < size2) {
                disposalUtil.disposeImage(this.twoImages(index))
                index += 1
            }
        }
        val size : Int = this.originalImageArray.length

        {
            var index : Int = 0
            while (index < size) {
                disposalUtil.disposeImage(this.originalImageArray(index))
                index += 1
            }
        }
        disposalUtil.disposeImage(this.realOriginalImage)
        disposalUtil.disposeImage(this.imageToShow)
    }

}


