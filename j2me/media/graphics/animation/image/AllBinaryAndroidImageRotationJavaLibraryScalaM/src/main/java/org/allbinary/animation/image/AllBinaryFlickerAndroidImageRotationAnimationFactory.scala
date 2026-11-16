/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.media.image.ImageCopyUtil
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.media.ScaleProperties

class AllBinaryFlickerAndroidImageRotationAnimationFactory(param_image : Image, param_width : Int, param_height : Int, param_angleIncrement : Short, param_animationBehaviorFactory : AnimationBehaviorFactory) extends AnimationInterfaceFactoryInterface {

    //    }
    private var image : Image = NullImage.NULL_IMAGE

    private var angleIncrement : Short = 0

    var animationBehaviorFactory : AnimationBehaviorFactory = null

    //Constructor
    {
        val image : Image = param_image
        val width : Int = param_width
        val height : Int = param_height
        val angleIncrement : Short = param_angleIncrement
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
        this.setImage(image)
        this.angleIncrement = angleIncrement
        this.animationBehaviorFactory = animationBehaviorFactory
    }

    override def getInstance(instanceId : Int) : Animation = {
        val image : Image = ImageCopyUtil.getInstance().createImage(this.getImage())
        return new AllBinaryFlickerAndroidImageRotationAnimation(this.getImage(), image, AngleInfo.getInstance(this.angleIncrement), AngleFactory.getInstance().TOTAL_ANGLE, this.animationBehaviorFactory.getOrCreateInstance())
    }

    def getAngleIncrement() : Short = {
        return this.angleIncrement
    }

    def setImage(image : Image) : Unit = {
        this.image = image
    }

    def getImage() : Image = {
        return this.image
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
    }

}


