/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.DisposalUtil
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.RotationAnimation
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.logic.math.PrimitiveIntUtil
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.media.image.ImageModifierUtil
import _root_.org.allbinary.util.CircularIndexUtil

class ImageArrayBaseRotationAnimation(param_originalImageArray : Array[Image], param_angleInfo : AngleInfo, param_animationBehavior : AnimationBehavior) extends RotationAnimation(param_angleInfo, CircularIndexUtil.createInstance(360 / param_angleInfo.getAngleIncrementInfo().getAngleIncrement()), param_animationBehavior) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val imageModifierUtil : ImageModifierUtil = ImageModifierUtil.getInstanceOrCreate()

    private var originalImageArray : Array[Image] = null

    private var imageArray : Array[Image] = NullImage.NULL_IMAGE_ARRAY

    private var currentImage : Image = null

    private var totalFrames : Int = 0

    private var anchor : Int = Anchor.TOP_LEFT

    //Constructor
    {
        val originalImageArray : Array[Image] = param_originalImageArray
        val angleInfo : AngleInfo = param_angleInfo
        val animationBehavior : AnimationBehavior = param_animationBehavior
        //this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR);
        this.originalImageArray = originalImageArray
        this.setImageArray(this.imageModifierUtil.getImageArray(originalImageArray))
        //this.setImageArray(originalImageArray);
        this.currentImage = this.imageArray(this.circularIndexUtil.getIndex())
    }

    override def getAnimationSize() : Int = {
        return this.getSize()
    }

    override def setAlpha(alpha : Int) : Unit = {
        if (this.alphaP != alpha) {
            super.setAlpha(alpha)
            this.imageModifierUtil.reset()
            val index : Int = this.circularIndexUtil.getIndex()
            this.imageModifierUtil.setAlpha(this.originalImageArray(index), this.imageArray(index), index, this.alphaP)
        }
    }

    override def nextRotation() : Unit = {
        super.nextRotation()
        val index : Int = this.circularIndexUtil.getIndex()
        this.imageModifierUtil.setAlpha(this.originalImageArray(index), this.imageArray(index), index, this.alphaP)
        this.currentImage = this.imageArray(index)
    }

    override def previousRotation() : Unit = {
        super.previousRotation()
        val index : Int = this.circularIndexUtil.getIndex()
        this.imageModifierUtil.setAlpha(this.originalImageArray(index), this.imageArray(index), index, this.alphaP)
        this.currentImage = this.imageArray(index)
    }

    override def setFrame(index2 : Int) : Unit = {
        super.setFrame(index2)
        val index : Int = this.circularIndexUtil.getIndex()
        this.imageModifierUtil.setAlpha(this.originalImageArray(index), this.imageArray(index), index, this.alphaP)
        this.currentImage = this.imageArray(index)
    }

    override def setSequence(sequence : Array[Int]) : Unit = {
    }

    override def getSequence() : Array[Int] = {
        return PrimitiveIntUtil.getArrayInstance()
    }

    def setImageArray(imageArray : Array[Image]) : Unit = {
        this.imageArray = imageArray
        this.totalFrames = imageArray.length
        this.circularIndexUtil = CircularIndexUtil.createInstance(this.totalFrames)
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        graphics.drawImage(this.currentImage, x, y, this.anchor)
    }

    def close() : Unit = {
        val disposalUtil : DisposalUtil = DisposalUtil.getInstance()
        val size2 : Int = this.imageArray.length

        {
            var index : Int = 0
            while (index < size2) {
                disposalUtil.disposeImage(this.imageArray(index))
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
        disposalUtil.disposeImage(this.currentImage)
    }

    override def finalize() : Unit = {
        val disposalUtil : DisposalUtil = DisposalUtil.getInstance()
        val size2 : Int = this.imageArray.length

        {
            var index : Int = 0
            while (index < size2) {
                disposalUtil.disposeImage(this.imageArray(index))
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
        disposalUtil.disposeImage(this.currentImage)
    }

}


