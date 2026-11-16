/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.game.configuration.GameConfigurationCentral
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.media.ScaleProperties
import _root_.org.allbinary.media.image.ImageToRotationImageArrayUtil

//TWB - Adjustments should be done in the resource creation and not at the animation level
class PooledImageArrayRotationAnimationFactory(param_image : Image, param_width : Int, param_height : Int, param_dx : Int, param_dy : Int, param_angleIncrement : Int, param_animationBehaviorFactory : AnimationBehaviorFactory) extends AnimationInterfaceFactoryInterface {
    import _root_.org.allbinary.animation.image.PooledImageArrayRotationAnimationFactory.{*}

    // private int height;
    private var allBinaryImageRotationAnimationInfo : Object = NullUtil.getInstance().NULL_OBJECT

    private var animationBehaviorFactory : AnimationBehaviorFactory = null

    //    }
    //Constructor
    {
        val image : Image = param_image
        val width : Int = param_width
        val height : Int = param_height
        val dx : Int = param_dx
        val dy : Int = param_dy
        val angleIncrement : Int = param_angleIncrement
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
        this.animationBehaviorFactory = animationBehaviorFactory
        val totalAngle : Int = AngleFactory.getInstance().TOTAL_ANGLE.toInt
        // this.height = height;
        val imageArray : Array[Image] = ImageToRotationImageArrayUtil.getInstance().generate(image, angleIncrement, totalAngle)
        this.allBinaryImageRotationAnimationInfo = new ImageArrayRotationAnimationInfo(imageArray, angleIncrement, totalAngle, dx, dy)
    }

    override def getInstance(instanceId : Int) : Animation = {
        // AngleInfo.getInstance(angleIncrement), totalAngle, dx, dy);
        return AdjustedImageArrayRotationAnimation.createAdjustedImageArrayRotationAnimationInfo(this.allBinaryImageRotationAnimationInfo, this.animationBehaviorFactory.getOrCreateInstance())
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
    }

}

object PooledImageArrayRotationAnimationFactory {
    def createFactory(image : Image, animationBehaviorFactory : AnimationBehaviorFactory) : PooledImageArrayRotationAnimationFactory = {
        val totalAngle : Int = AngleFactory.getInstance().TOTAL_ANGLE.toInt
        val angleIncrement : Int = (totalAngle / GameConfigurationCentral.getInstance().getGameControlFidelity())
        return new PooledImageArrayRotationAnimationFactory(image, image.getWidth(), image.getHeight(), -(image.getWidth() >> 2), -(image.getHeight() >> 2), angleIncrement, animationBehaviorFactory)
    }

    def createDXY(image : Image, dx : Int, dy : Int, animationBehaviorFactory : AnimationBehaviorFactory) : PooledImageArrayRotationAnimationFactory = {
        val totalAngle : Int = AngleFactory.getInstance().TOTAL_ANGLE.toInt
        val angleIncrement : Int = (totalAngle / GameConfigurationCentral.getInstance().getGameControlFidelity())
        return new PooledImageArrayRotationAnimationFactory(image, image.getWidth(), image.getHeight(), dx, dy, angleIncrement, animationBehaviorFactory)
    }

}


