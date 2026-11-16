/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.android.graphics.Matrix
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.media.image.AndroidImageUtil
import _root_.org.allbinary.media.image.ImageModifierUtil

class AllBinaryFlickerAndroidImageRotationAnimation(param_originalImage : Image, param_image : Image, param_angleInfo : AngleInfo, param_totalAngle : Short, param_animationBehavior : AnimationBehavior) extends ImageBaseRotationAnimation(param_image, param_angleInfo, param_totalAngle, param_animationBehavior) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val imageModifierUtil : ImageModifierUtil = ImageModifierUtil.getInstanceOrCreate()

    private val androidImageUtil : AndroidImageUtil = AndroidImageUtil.getInstance()

    private val matrix : Matrix = new Matrix()

    //private final int height;
    private var halfWidth : Int = 0

    private var halfHeight : Int = 0

    private var increment : Short = 0

    private var originalImage : Image = null

    //protected
    //Constructor
    {
        val originalImage : Image = param_originalImage
        val image : Image = param_image
        val angleInfo : AngleInfo = param_angleInfo
        val totalAngle : Short = param_totalAngle
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.originalImage = originalImage
        //this.height = image.getHeight();
        this.halfWidth = (image.getWidth() >> 1)
        this.halfHeight = (image.getHeight() >> 1)
        this.increment = (this.angleInfo.getAngleIncrementInfo().getAngleIncrement()).toShort
    }

    override def setBasicColorP(basicColor : BasicColor) : Unit = {
        var changed : Boolean = false
        if ((this.getBasicColorP() == null) || (this.getBasicColorP().intValue() != basicColor.intValue())) {
            this.imageModifierUtil.setColor(this.originalImage, this.getImage(), 0, basicColor)
            changed = true
        }
        super.setBasicColorP(basicColor)
        if (changed) {
            this.matrix.setRotate(0.0f, this.halfWidth.toFloat, this.halfHeight.toFloat)
            this.updateImage()
        }
    }

    override def changeBasicColor(basicColor : BasicColor) : Unit = {
        this.setBasicColorP(basicColor)
    }

    override def setAlpha(alpha : Int) : Unit = {
        var changed : Boolean = false
        if (this.alphaP != alpha) {
            changed = true
        }
        super.setAlpha(alpha)
        this.imageModifierUtil.setAlpha(this.originalImage, this.getImage(), 0, this.alphaP)
        if (changed) {
            this.matrix.setRotate(0.0f, this.halfWidth.toFloat, this.halfHeight.toFloat)
            this.updateImage()
        }
    }

    override def nextRotation() : Unit = {
        super.nextRotation()
        //this.logUtil.putF("Frame: " + this.getFrame(), this, "nextRotation");
        this.matrix.setRotate(this.increment.toFloat, this.halfWidth.toFloat, this.halfHeight.toFloat)
        //matrix.setRotate(this.angleInfo.getAngle(), this.halfWidth, this.halfHeight);
        this.updateImage()
    }

    override def previousRotation() : Unit = {
        super.previousRotation()
        //this.logUtil.putF("Frame: " + this.getFrame(), this, "previousRotation");
        this.matrix.setRotate((-this.increment).toFloat, this.halfWidth.toFloat, this.halfHeight.toFloat)
        //matrix.setRotate(this.angleInfo.getAngle(), this.halfWidth, this.halfHeight);
        this.updateImage()
    }

    private def updateImage() : Unit = {
        this.androidImageUtil.rotate(this.getImage(), originalImage, matrix, imageModifierUtil.paint)
    }

    override def setFrame(index : Int) : Unit = {
        //this.logUtil.putF(this.commonLabels.INDEX_LABEL + index, this, "setRotation");
        val currentFrame : Int = this.circularIndexUtil.getIndex()
        //this.logUtil.putF("currentFrame: " + currentFrame, this, "setRotation");
        this.circularIndexUtil.setIndex(index)
        val newFrame : Int = this.circularIndexUtil.getIndex()
        //this.logUtil.putF("newFrame: " + newFrame, this, "setRotation");
        this.angleInfo.adjustAngle(newFrame)
        this.matrix.setRotate((newFrame - currentFrame).toFloat * this.increment, this.halfWidth.toFloat, this.halfHeight.toFloat)
        this.updateImage()
    }

}


