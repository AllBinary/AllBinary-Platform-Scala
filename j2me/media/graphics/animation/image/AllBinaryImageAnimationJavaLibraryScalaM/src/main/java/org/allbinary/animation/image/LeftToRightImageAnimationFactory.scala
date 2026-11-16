/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory

/**  *  * @author user  */
class LeftToRightImageAnimationFactory(param_image : Image, param_sequenceArray : Array[Int], param_dx : Int, param_dy : Int, param_animationBehaviorFactory : AnimationBehaviorFactory) extends BaseImageAnimationFactory(param_image, param_sequenceArray, param_image.getWidth(), param_image.getHeight(), param_dx, param_dy, param_animationBehaviorFactory) {

    //    }
    //Constructor
    {
        val image : Image = param_image
        val sequenceArray : Array[Int] = param_sequenceArray
        val dx : Int = param_dx
        val dy : Int = param_dy
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
    }

    //    }
    override def getInstance(instanceId : Int) : Animation = {
        val scaledImage : Image = this.animationFactoryImageScaleUtil.createImage(this.getImage(), this.animationFactoryInitializationVisitor.width, this.animationFactoryInitializationVisitor.height, this.scaleProperties.scaleWidth, this.scaleProperties.scaleHeight)
        if ((this.animationFactoryInitializationVisitor.dx != 0) || (this.animationFactoryInitializationVisitor.dy != 0)) {
            this.animationFactoryImageScaleUtil.processAdjust(this)
            return new AdjustedLeftToRightImageAnimation(scaledImage, this.getSequenceArray(), this.animationFactoryInitializationVisitor.dx, this.animationFactoryInitializationVisitor.dy, this.animationBehaviorFactory.getOrCreateInstance())
        } else {
            return new LeftToRightImageAnimation(scaledImage, this.getSequenceArray(), this.animationBehaviorFactory.getOrCreateInstance())
        }
        throw new IllegalStateException()
    }

}


