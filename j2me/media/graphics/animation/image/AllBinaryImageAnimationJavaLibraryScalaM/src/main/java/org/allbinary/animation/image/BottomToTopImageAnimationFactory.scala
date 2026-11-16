/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.logic.math.PrimitiveIntUtil

/**  *  * @author user  */
class BottomToTopImageAnimationFactory(param_image : Image, param_animationBehaviorFactory : AnimationBehaviorFactory) extends BaseImageAnimationFactory(param_image, PrimitiveIntUtil.getArrayInstance(), param_image.getWidth(), param_image.getHeight(), 0, 0, param_animationBehaviorFactory) {

    //Constructor
    {
        val image : Image = param_image
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
    }

    override def getInstance(instanceId : Int) : Animation = {
        val scaledImage : Image = this.animationFactoryImageScaleUtil.createImage(this.getImage(), this.animationFactoryInitializationVisitor.width, this.animationFactoryInitializationVisitor.height, this.scaleProperties.scaleWidth, this.scaleProperties.scaleHeight)
        //final Image image = ImageCopyUtil.getInstance().createImage(this.image);
        return new BottomToTopImageAnimation(scaledImage, this.animationBehaviorFactory.getOrCreateInstance())
    }

}


