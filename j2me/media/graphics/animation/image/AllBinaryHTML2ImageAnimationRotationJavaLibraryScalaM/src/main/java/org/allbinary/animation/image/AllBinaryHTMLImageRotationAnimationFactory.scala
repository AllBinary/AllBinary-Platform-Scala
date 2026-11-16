/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.game.configuration.GameConfigurationCentral
import _root_.org.allbinary.logic.math.PrimitiveIntUtil
import _root_.org.allbinary.media.image.ImageCopyUtil
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.math.AngleInfo

class AllBinaryHTMLImageRotationAnimationFactory(param_image : Image, param_width : Int, param_height : Int, param_angleIncrement : Short, param_animationBehaviorFactory : AnimationBehaviorFactory) extends BaseImageAnimationFactory(param_image, PrimitiveIntUtil.getArrayInstance(), param_width, param_height, 0, 0, param_animationBehaviorFactory) {
    import _root_.org.allbinary.animation.image.AllBinaryHTMLImageRotationAnimationFactory.{*}

    var angleIncrement : Short = 0

    //Constructor
    {
        val image : Image = param_image
        val width : Int = param_width
        val height : Int = param_height
        val angleIncrement : Short = param_angleIncrement
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
        this.angleIncrement = angleIncrement
    }

    def init(dx : Int, dy : Int) : Unit = {
        this.animationFactoryInitializationVisitor.dx = dx
        this.animationFactoryInitializationVisitor.dy = dy
        this.animationFactoryInitializationVisitor.originalDx = dx
        this.animationFactoryInitializationVisitor.originalDy = dy
    }

    override def getInstance(instanceId : Int) : Animation = {
        //        }
        val scaledImage : Image = this.animationFactoryImageScaleUtil.createImage(this.getImage(), this.animationFactoryInitializationVisitor.width, this.animationFactoryInitializationVisitor.height, this.scaleProperties.scaleWidth, this.scaleProperties.scaleHeight)
        //final Image image = ImageCreationUtil.getInstance().getInstance(this.image.getWidth(), this.image.getHeight());
        val copyOfScaledImage : Image = ImageCopyUtil.getInstance().createImage(scaledImage)
        if ((this.animationFactoryInitializationVisitor.dx != 0) || (this.animationFactoryInitializationVisitor.dy != 0)) {
            //this.logUtil.putF(new StringMaker().append(PositionStrings.getInstance().DX_LABEL).append((float) this.animationFactoryInitializationVisitor.dx).append(PositionStrings.getInstance().DY_LABEL).append((float) this.animationFactoryInitializationVisitor.dy).toString(), this, "getInstance");
            this.animationFactoryImageScaleUtil.processAdjust(this)
            return new AllBinaryAdjustedHTMLImageRotationAnimation(scaledImage, copyOfScaledImage, AngleInfo.getInstance(this.getAngleIncrement()), AngleFactory.getInstance().TOTAL_ANGLE, this.animationFactoryInitializationVisitor.dx, this.animationFactoryInitializationVisitor.dy, this.animationBehaviorFactory.getOrCreateInstance())
        } else {
            return new AllBinaryHTMLImageRotationAnimation(scaledImage, copyOfScaledImage, AngleInfo.getInstance(this.angleIncrement), AngleFactory.getInstance().TOTAL_ANGLE, this.animationBehaviorFactory.getOrCreateInstance())
        }
        throw new IllegalStateException()
    }

    def getAngleIncrement() : Short = {
        return this.angleIncrement
    }

}

object AllBinaryHTMLImageRotationAnimationFactory {
    //    }
    def createFactoryADXY(image : Image, width : Int, height : Int, dx : Int, dy : Int, angleIncrement : Short, animationBehaviorFactory : AnimationBehaviorFactory) : AllBinaryHTMLImageRotationAnimationFactory = {
        val htmlImageRotationAnimationFactory : AllBinaryHTMLImageRotationAnimationFactory = new AllBinaryHTMLImageRotationAnimationFactory(image, width, height, angleIncrement, animationBehaviorFactory)
        htmlImageRotationAnimationFactory.init(dx, dy)
        return htmlImageRotationAnimationFactory
    }

}


