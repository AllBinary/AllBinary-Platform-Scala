/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.game.configuration.GameConfigurationCentral
import _root_.org.allbinary.logic.math.PrimitiveIntUtil
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.media.image.ImageToRotationImageArrayUtil

class AllBinaryArrayImageRotationAnimationFactory(param_image : Image, param_width : Int, param_height : Int, param_angleIncrement : Int, param_animationBehaviorFactory : AnimationBehaviorFactory) extends BaseImageAnimationFactory(param_image, PrimitiveIntUtil.getArrayInstance(), param_width, param_height, 0, 0, param_animationBehaviorFactory) {
    import _root_.org.allbinary.animation.image.AllBinaryArrayImageRotationAnimationFactory.{*}

    private var imageArray : Array[Image] = NullImage.NULL_IMAGE_ARRAY

    private var angleIncrement : Int = 0

    //    }
    //Constructor
    {
        val image : Image = param_image
        val width : Int = param_width
        val height : Int = param_height
        val angleIncrement : Int = param_angleIncrement
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
        this.angleIncrement = angleIncrement
        this.init()
    }

    private def init() : Unit = {
        this.setImageArray(ImageToRotationImageArrayUtil.getInstance().generate(this.getImage(), this.getAngleIncrement(), AngleFactory.getInstance().TOTAL_ANGLE.toInt))
    }

    private def initDXY(dx : Int, dy : Int) : Unit = {
        this.animationFactoryInitializationVisitor.dx = dx
        this.animationFactoryInitializationVisitor.dy = dy
        this.animationFactoryInitializationVisitor.originalDx = dx
        this.animationFactoryInitializationVisitor.originalDy = dy
    }

    override def getInstance(instanceId : Int) : Animation = {
        val scaledImageArray : Array[Image] = new Array[Image](this.imageArray.length)
        val size : Int = scaledImageArray.length
        val image : Image = this.getImage()

        {
            var index : Int = 0
            while (index < size) {
                scaledImageArray(index) = this.animationFactoryImageScaleUtil.createImage(image, image.getWidth(), image.getHeight(), this.scaleProperties.scaleWidth, this.scaleProperties.scaleHeight)
                index += 1
            }
        }
        if ((this.animationFactoryInitializationVisitor.dx != 0) || (this.animationFactoryInitializationVisitor.dy != 0)) {
            //this.logUtil.putF(new StringMaker().append(PositionStrings.getInstance().DX_LABEL).append((float) this.animationFactoryInitializationVisitor.dx).append(PositionStrings.getInstance().DY_LABEL).append((float) this.animationFactoryInitializationVisitor.dy).toString(), this, "getInstance");
            this.animationFactoryImageScaleUtil.processAdjust(this)
            return new AdjustedImageArrayRotationAnimation(scaledImageArray, AngleInfo.getInstance(this.getAngleIncrement().toShort), AngleFactory.getInstance().TOTAL_ANGLE.toInt, this.animationFactoryInitializationVisitor.dx, this.animationFactoryInitializationVisitor.dy, this.animationBehaviorFactory.getOrCreateInstance())
        } else {
            return new ImageArrayRotationAnimation(scaledImageArray, AngleInfo.getInstance(this.getAngleIncrement().toShort), AngleFactory.getInstance().TOTAL_ANGLE.toInt, this.animationBehaviorFactory.getOrCreateInstance())
        }
        throw new IllegalStateException()
    }

    def setImageArray(imageArray : Array[Image]) : Unit = {
        this.imageArray = imageArray
    }

    def getAngleIncrement() : Int = {
        return this.angleIncrement
    }

}

object AllBinaryArrayImageRotationAnimationFactory {
    def createFactory(image : Image, dx : Int, dy : Int) : AllBinaryArrayImageRotationAnimationFactory = {
        val arrayImageRotationAnimationFactory : AllBinaryArrayImageRotationAnimationFactory = new AllBinaryArrayImageRotationAnimationFactory(image, image.getWidth(), image.getHeight(), AngleFactory.getInstance().TOTAL_ANGLE / GameConfigurationCentral.getInstance().getGameControlFidelity(), AnimationBehaviorFactory.getInstance())
        arrayImageRotationAnimationFactory.initDXY(dx, dy)
        return arrayImageRotationAnimationFactory
    }

    def createFactoryA(image : Image, dx : Int, dy : Int, angleIncrement : Int) : AllBinaryArrayImageRotationAnimationFactory = {
        val arrayImageRotationAnimationFactory : AllBinaryArrayImageRotationAnimationFactory = new AllBinaryArrayImageRotationAnimationFactory(image, image.getWidth(), image.getHeight(), angleIncrement, AnimationBehaviorFactory.getInstance())
        arrayImageRotationAnimationFactory.initDXY(dx, dy)
        return arrayImageRotationAnimationFactory
    }

}


