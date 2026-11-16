/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.game.configuration.GameConfigurationCentral
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureFactory
import _root_.org.allbinary.logic.math.PrimitiveIntUtil
import _root_.org.allbinary.media.image.ImageCopyUtil
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.math.AngleInfo

class AllBinaryAndroidImageRotationAnimationFactory(param_image : Image, param_width : Int, param_height : Int, param_angleIncrement : Short, param_animationBehaviorFactory : AnimationBehaviorFactory, param_resizeCanvasForRotation : Boolean) extends BaseImageAnimationFactory(param_image, PrimitiveIntUtil.getArrayInstance(), param_width, param_height, 0, 0, param_animationBehaviorFactory) {
    import _root_.org.allbinary.animation.image.AllBinaryAndroidImageRotationAnimationFactory.{*}

    private var angleIncrement : Short = 0

    private var resizeCanvasForRotation : Boolean = false

    //    }
    //Constructor
    {
        val image : Image = param_image
        val width : Int = param_width
        val height : Int = param_height
        val angleIncrement : Short = param_angleIncrement
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
        val resizeCanvasForRotation : Boolean = param_resizeCanvasForRotation
        this.angleIncrement = angleIncrement
        this.resizeCanvasForRotation = resizeCanvasForRotation
    }

    def init(dx : Int, dy : Int) : Unit = {
        this.animationFactoryInitializationVisitor.dx = dx
        this.animationFactoryInitializationVisitor.dy = dy
        this.animationFactoryInitializationVisitor.originalDx = dx
        this.animationFactoryInitializationVisitor.originalDy = dy
    }

    private def getCanvasImage() : Image = {
        val features : Features = Features.getInstance()
        if (this.resizeCanvasForRotation && !features.isDefault(OpenGLFeatureFactory.getInstance().OPENGL)) {
            return ImageCopyUtil.getInstance().createImageScale(this.getImage(), 1.44f, false)
        } else {
            return this.getImage()
        }
        throw new IllegalStateException()
    }

    //    private Image secondImage = null;
    override def getInstance(instanceId : Int) : Animation = {
        val canvasImage : Image = this.getCanvasImage()
        val scaledImage : Image = this.animationFactoryImageScaleUtil.createImage(canvasImage, this.animationFactoryInitializationVisitor.width, this.animationFactoryInitializationVisitor.height, this.scaleProperties.scaleWidth, this.scaleProperties.scaleHeight)
        //        }
        val copyOfScaledImage : Image = ImageCopyUtil.getInstance().createImage(scaledImage)
        //        }
        if ((this.animationFactoryInitializationVisitor.dx != 0) || (this.animationFactoryInitializationVisitor.dy != 0)) {
            //this.logUtil.putF(new StringMaker().append(PositionStrings.getInstance().DX_LABEL).append((float) this.animationFactoryInitializationVisitor.dx).append(PositionStrings.getInstance().DY_LABEL).append((float) this.animationFactoryInitializationVisitor.dy).toString(), this, "getInstance");
            this.animationFactoryImageScaleUtil.processAdjust(this)
            return new AllBinaryAdjustedAndroidImageRotationAnimation(scaledImage, copyOfScaledImage, AngleInfo.getInstance(this.angleIncrement), AngleFactory.getInstance().TOTAL_ANGLE, this.animationFactoryInitializationVisitor.dx, this.animationFactoryInitializationVisitor.dy, animationBehaviorFactory.getOrCreateInstance())
        } else {
            //return new AllBinaryNoFlickerAndroidImageRotationAnimation(
            return new AllBinaryFlickerAndroidImageRotationAnimation(scaledImage, copyOfScaledImage, AngleInfo.getInstance(this.angleIncrement), AngleFactory.getInstance().TOTAL_ANGLE, this.animationBehaviorFactory.getOrCreateInstance())
        }
        throw new IllegalStateException()
    }

}

object AllBinaryAndroidImageRotationAnimationFactory {
    def createFactory(image : Image, width : Int, height : Int, animationBehaviorFactory : AnimationBehaviorFactory) : AllBinaryAndroidImageRotationAnimationFactory = {
        return new AllBinaryAndroidImageRotationAnimationFactory(image, width, height, (AngleFactory.getInstance().TOTAL_ANGLE / GameConfigurationCentral.getInstance().getGameControlFidelity()).toShort, animationBehaviorFactory, false)
    }

    def createFactoryA(image : Image, width : Int, height : Int, angleIncrement : Short, animationBehaviorFactory : AnimationBehaviorFactory) : AllBinaryAndroidImageRotationAnimationFactory = {
        return new AllBinaryAndroidImageRotationAnimationFactory(image, width, height, angleIncrement, animationBehaviorFactory, false)
    }

    //final Image image, final Object unused
    def createFactoryU(image : Image, animationBehaviorFactory : AnimationBehaviorFactory) : AllBinaryAndroidImageRotationAnimationFactory = {
        val androidImageRotationAnimationFactory : AllBinaryAndroidImageRotationAnimationFactory = new AllBinaryAndroidImageRotationAnimationFactory(image, image.getWidth(), image.getHeight(), (AngleFactory.getInstance().TOTAL_ANGLE / GameConfigurationCentral.getInstance().getGameControlFidelity()).toShort, animationBehaviorFactory, false)
        androidImageRotationAnimationFactory.init(-(image.getWidth() >> 2), -(image.getHeight() >> 2))
        return androidImageRotationAnimationFactory
    }

    //final Image image, final int dx, final int dy, final Object unused, final AnimationBehaviorFactory animationBehaviorFactory
    def createFactoryDXYU(image : Image, dx : Int, dy : Int, animationBehaviorFactory : AnimationBehaviorFactory) : AllBinaryAndroidImageRotationAnimationFactory = {
        val androidImageRotationAnimationFactory : AllBinaryAndroidImageRotationAnimationFactory = new AllBinaryAndroidImageRotationAnimationFactory(image, image.getWidth(), image.getHeight(), (AngleFactory.getInstance().TOTAL_ANGLE / GameConfigurationCentral.getInstance().getGameControlFidelity()).toShort, animationBehaviorFactory, false)
        androidImageRotationAnimationFactory.init(dx, dy)
        return androidImageRotationAnimationFactory
    }

    def createFactoryADXY(image : Image, width : Int, height : Int, dx : Int, dy : Int, angleIncrement : Short, animationBehaviorFactory : AnimationBehaviorFactory, resizeCanvasForRotation : Boolean) : AllBinaryAndroidImageRotationAnimationFactory = {
        val androidImageRotationAnimationFactory : AllBinaryAndroidImageRotationAnimationFactory = new AllBinaryAndroidImageRotationAnimationFactory(image, width, height, angleIncrement, animationBehaviorFactory, resizeCanvasForRotation)
        androidImageRotationAnimationFactory.init(dx, dy)
        return androidImageRotationAnimationFactory
    }

}


