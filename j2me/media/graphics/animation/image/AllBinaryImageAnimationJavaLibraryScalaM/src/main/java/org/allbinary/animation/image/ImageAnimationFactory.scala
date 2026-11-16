/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.graphics.opengles.OpenGLUtil
import _root_.org.allbinary.logic.math.PrimitiveIntUtil

/**  *  * @author User  */
class ImageAnimationFactory(param_image : Image, param_width : Int, param_height : Int, param_dx : Int, param_dy : Int, param_animationBehaviorFactory : AnimationBehaviorFactory) extends BaseImageAnimationFactory(param_image, PrimitiveIntUtil.getArrayInstance(), param_width, param_height, param_dx, param_dy, param_animationBehaviorFactory) {
    import _root_.org.allbinary.animation.image.ImageAnimationFactory.{*}

    //    }
    //Constructor
    {
        val image : Image = param_image
        val width : Int = param_width
        val height : Int = param_height
        val dx : Int = param_dx
        val dy : Int = param_dy
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
    }

    override def getInstance(instanceId : Int) : Animation = {
        //final ImageCopyUtil imageCopyUtil = ImageCopyUtil.getInstance();
        var scaledImage : Image = this.animationFactoryImageScaleUtil.createImage(this.getImage(), this.animationFactoryInitializationVisitor.width, this.animationFactoryInitializationVisitor.height, this.scaleProperties.scaleWidth, this.scaleProperties.scaleHeight)
        val openGLUtil : OpenGLUtil = OpenGLUtil.getInstance()
        scaledImage = openGLUtil.addImage(scaledImage)
        //final Image copyOfScaledImage = ImageCopyUtil.getInstance().createImage(scaledImage);
        if ((this.animationFactoryInitializationVisitor.dx != 0) || (this.animationFactoryInitializationVisitor.dy != 0)) {
            this.animationFactoryImageScaleUtil.processAdjust(this)
            return new AdjustedImageAnimation(scaledImage, this.animationFactoryInitializationVisitor.dx, this.animationFactoryInitializationVisitor.dy, this.animationBehaviorFactory.getOrCreateInstance())
        } else {
            return new ImageAnimation(scaledImage, this.animationBehaviorFactory.getOrCreateInstance())
        }
        throw new IllegalStateException()
    }

}

object ImageAnimationFactory {
    def createFactory(image : Image) : ImageAnimationFactory = {
        return new ImageAnimationFactory(image, image.getWidth(), image.getHeight(), 0, 0, AnimationBehaviorFactory.getInstance())
    }

}


