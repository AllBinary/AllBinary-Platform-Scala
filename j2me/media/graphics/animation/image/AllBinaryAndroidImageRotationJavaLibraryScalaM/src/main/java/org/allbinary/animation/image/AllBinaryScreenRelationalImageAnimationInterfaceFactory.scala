/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.image.GameFeatureImageCacheFactory
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.graphics.displayable.ScreenRelationalUtil
import _root_.org.allbinary.logic.math.PrimitiveIntUtil
import _root_.org.allbinary.media.image.ImageScaleUtil
import _root_.org.microemu.android.device.AndroidImageInterface

class AllBinaryScreenRelationalImageAnimationInterfaceFactory(param_image : Image, param_animationBehaviorFactory : AnimationBehaviorFactory) extends BaseImageAnimationFactory(param_image, PrimitiveIntUtil.getArrayInstance(), 0, 0, 0, 0, param_animationBehaviorFactory) {

    private var lastImage : Image = NullImage.NULL_IMAGE

    //Constructor
    {
        val image : Image = param_image
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
        //Image image = this.getImage();
        if (this.lastImage ne NullImage.NULL_IMAGE) {
            val androidImageInterface : AndroidImageInterface = this.lastImage.asInstanceOf[AndroidImageInterface]
            androidImageInterface.getBitmap().recycle()
        }
        var scale : Float = ScreenRelationalUtil.getInstance().getScaleImage(image)
        this.lastImage = ImageScaleUtil.getInstance().createImage(GameFeatureImageCacheFactory.getInstance(), this.getImage(), scale, scale, false)
    }

    override def getInstance(instanceId : Int) : Animation = {
        return new ImageAnimation(this.lastImage, this.animationBehaviorFactory.getOrCreateInstance())
    }

}


