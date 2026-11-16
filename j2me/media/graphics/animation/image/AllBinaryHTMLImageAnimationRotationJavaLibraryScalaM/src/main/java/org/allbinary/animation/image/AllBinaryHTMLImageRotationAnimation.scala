/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.media.image.ImageCopyUtil
import _root_.org.allbinary.media.image.ImageModifierUtil
import _root_.org.allbinary.media.image.ImageRotationUtil
import _root_.org.microemu.device.playn.PlaynMutableImage
import _root_.playn.core.CanvasImage
import _root_.playn.core.CanvasSurface

class AllBinaryHTMLImageRotationAnimation(param_originalImage : Image, param_image : Image, param_angleInfo : AngleInfo, param_totalAngle : Short, param_animationBehavior : AnimationBehavior) extends ImageBaseRotationAnimation(param_image, param_angleInfo, param_totalAngle, param_animationBehavior) {

    //private final ImageCreationUtil imageCreationUtil = ImageCreationUtil.getInstance();
    private val imageRotationUtil : ImageRotationUtil = ImageRotationUtil.getInstance()

    private val imageModifierUtil : ImageModifierUtil = ImageModifierUtil.getInstanceOrCreate()

    //private final float increment;
    private var originalImage : Image = null

    private val twoImages : Array[Image] = new Array[Image](2)

    private val canvasSurfaceArray : Array[CanvasSurface] = new Array[CanvasSurface](2)

    private var imageToShow : Image = null

    private var bufferedImageIndex : Int = 0

    private var alphaProcessor : AlphaBaseProcessor = AlphaBaseProcessor.getInstance()

    //Constructor
    {
        val originalImage : Image = param_originalImage
        val image : Image = param_image
        val angleInfo : AngleInfo = param_angleInfo
        val totalAngle : Short = param_totalAngle
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.originalImage = originalImage
        //this.increment = (short)(this.angleInfo.getAngleIncrementInfo().getAngleIncrement() * 2.44);
        this.imageToShow = image
        this.twoImages(0) = image
        this.twoImages(1) = ImageCopyUtil.getInstance().createImage(image)
        //this.twoImages[1] = this.imageCreationUtil.getInstance(image.getWidth(), image.getHeight());
        this.canvasSurfaceArray(0) = this.getCanvasSurface(this.twoImages(0))
        this.canvasSurfaceArray(1) = this.getCanvasSurface(this.twoImages(1))
    }

    def getCanvasSurface(image : Image) : CanvasSurface = {
        val htmlImage : PlaynMutableImage = image.asInstanceOf[PlaynMutableImage]
        val canvasImage : CanvasImage = htmlImage.getImage().asInstanceOf[CanvasImage]
        val canvasSurface : CanvasSurface = htmlImage.getCanvasSurface(canvasImage)
        canvasSurface.translate(this.originalImage.getWidth() / 2, this.originalImage.getHeight() / 2)
        return canvasSurface
    }

    override def setBasicColorP(basicColor : BasicColor) : Unit = {
        var changed : Boolean = false
        if ((this.getBasicColorP() == null) || (this.getBasicColorP().intValue() != basicColor.intValue())) {
            changed = true
        }
        super.setBasicColorP(basicColor)
        if (changed) {
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

    override def nextRotation() : Unit = {
        super.nextRotation()
        this.updateImage()
    }

    override def previousRotation() : Unit = {
        super.previousRotation()
        this.updateImage()
    }

    private def updateImage() : Unit = {
        val canvasSurface : CanvasSurface = this.canvasSurfaceArray(this.bufferedImageIndex)
        canvasSurface.save()
        this.imageRotationUtil.rotateImageCanvasSurfaceClear(this.originalImage, this.twoImages(this.bufferedImageIndex), canvasSurface, this.angleInfo.getAngle() + 90)
        this.alphaProcessor.setAlpha(this.imageModifierUtil, this.originalImage, this.twoImages(this.bufferedImageIndex), this.alphaP)
        this.imageRotationUtil.drawImage(this.originalImage, imageToShow, canvasSurface)
        canvasSurface.restore()
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
        graphics.drawImage(this.imageToShow, x, y, this.anchor)
    }

}


