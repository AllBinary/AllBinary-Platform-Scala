/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureFactory
import _root_.org.allbinary.graphics.opengles.OpenGLUtil
import _root_.org.allbinary.logic.math.PrimitiveIntUtil
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.media.image.ImageCopyUtil

class AllBinaryJ2SEImageRotationAnimationFactory(param_image : Image, param_width : Int, param_height : Int, param_angleIncrement : Short, param_animationBehaviorFactory : AnimationBehaviorFactory, param_resizeCanvasForRotation : Boolean) extends BaseImageAnimationFactory(param_image, PrimitiveIntUtil.getArrayInstance(), param_width, param_height, 0, 0, param_animationBehaviorFactory) {
    import _root_.org.allbinary.animation.image.AllBinaryJ2SEImageRotationAnimationFactory.{*}

    var angleIncrementP : Short = 0

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
        this.angleIncrementP = angleIncrement
        this.resizeCanvasForRotation = resizeCanvasForRotation
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

    //final LogUtil logUtil = LogUtil.getInstance();
    override def getInstance(instanceId : Int) : Animation = {
        val imageCopyUtil : ImageCopyUtil = ImageCopyUtil.getInstance()
        val canvasImage : Image = this.getCanvasImage()
        var scaledImage : Image = this.animationFactoryImageScaleUtil.createImage(canvasImage, this.animationFactoryInitializationVisitor.width, this.animationFactoryInitializationVisitor.height, this.scaleProperties.scaleWidth, this.scaleProperties.scaleHeight)
        val openGLUtil : OpenGLUtil = OpenGLUtil.getInstance()
        scaledImage = openGLUtil.addImage(scaledImage)
        //final Image image = imageCopyUtil.createImage(this.image);
        val copyOfScaledImage : Image = imageCopyUtil.createImageForRotation(scaledImage)
        if ((this.animationFactoryInitializationVisitor.dx != 0) || (this.animationFactoryInitializationVisitor.dy != 0)) {
            //this.logUtil.putF(new StringMaker().append(PositionStrings.getInstance().DX_LABEL).append((float) this.animationFactoryInitializationVisitor.dx).append(PositionStrings.getInstance().DY_LABEL).append((float) this.animationFactoryInitializationVisitor.dy).toString(), this, "getInstance");
            this.animationFactoryImageScaleUtil.processAdjust(this)
            return new AllBinaryAdjustedJ2SEImageRotationAnimation(scaledImage, copyOfScaledImage, AngleInfo.getInstance(this.angleIncrementP), AngleFactory.getInstance().TOTAL_ANGLE, this.animationFactoryInitializationVisitor.dx, this.animationFactoryInitializationVisitor.dy, this.animationBehaviorFactory.getOrCreateInstance())
        } else {
            return new AllBinaryJ2SEImageRotationAnimation(scaledImage, copyOfScaledImage, AngleInfo.getInstance(this.angleIncrementP), AngleFactory.getInstance().TOTAL_ANGLE, this.animationBehaviorFactory.getOrCreateInstance())
        }
        throw new IllegalStateException()
    }

    def getAngleIncrement() : Short = {
        return this.angleIncrementP
    }

}

object AllBinaryJ2SEImageRotationAnimationFactory {
    def createDXY(image : Image, width : Int, height : Int, dx : Int, dy : Int, angleIncrement : Short, animationBehaviorFactory : AnimationBehaviorFactory, resizeCanvasForRotation : Boolean) : AllBinaryJ2SEImageRotationAnimationFactory = {
        val imageRotationAnimationFactory : AllBinaryJ2SEImageRotationAnimationFactory = new AllBinaryJ2SEImageRotationAnimationFactory(image, width, height, angleIncrement, animationBehaviorFactory, resizeCanvasForRotation)
        imageRotationAnimationFactory.animationFactoryInitializationVisitor.dx = dx
        imageRotationAnimationFactory.animationFactoryInitializationVisitor.dy = dy
        imageRotationAnimationFactory.animationFactoryInitializationVisitor.originalDx = dx
        imageRotationAnimationFactory.animationFactoryInitializationVisitor.originalDy = dy
        return imageRotationAnimationFactory
    }

}


