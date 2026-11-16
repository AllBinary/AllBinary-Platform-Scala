/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory

/**  *  * @author user  */
class TopToBottomImageAnimationFactory(param_image : Image, param_sequenceArray : Array[Int], param_animationBehaviorFactory : AnimationBehaviorFactory) extends BaseImageAnimationFactory(param_image, param_sequenceArray, param_image.getWidth(), param_image.getHeight(), 0, 0, param_animationBehaviorFactory) {

    //Constructor
    {
        val image : Image = param_image
        val sequenceArray : Array[Int] = param_sequenceArray
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
    }

    override def getInstance(instanceId : Int) : Animation = {
        val scaledImage : Image = this.animationFactoryImageScaleUtil.createImage(this.getImage(), this.animationFactoryInitializationVisitor.width, this.animationFactoryInitializationVisitor.height, this.scaleProperties.scaleWidth, this.scaleProperties.scaleHeight)
        return new TopToBottomImageAnimation(scaledImage, this.getSequenceArray(), this.animationBehaviorFactory.getOrCreateInstance())
    }

}


