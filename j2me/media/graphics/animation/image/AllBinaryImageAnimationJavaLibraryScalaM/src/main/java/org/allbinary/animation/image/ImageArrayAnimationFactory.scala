/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.media.ScaleProperties

class ImageArrayAnimationFactory(param_imageArray : Array[Image], param_dx : Int, param_dy : Int, param_animationBehaviorFactory : AnimationBehaviorFactory) extends AnimationInterfaceFactoryInterface {

    private var dx : Int = 0

    private var dy : Int = 0

    private var imageArray : Array[Image] = null

    private var animationBehaviorFactory : AnimationBehaviorFactory = null

    //Constructor
    {
        val imageArray : Array[Image] = param_imageArray
        val dx : Int = param_dx
        val dy : Int = param_dy
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
        this.imageArray = imageArray
        this.animationBehaviorFactory = animationBehaviorFactory
        this.dx = dx
        this.dy = dy
    }

    override def getInstance(instanceId : Int) : Animation = {
        if ((this.dx != 0) || (this.dy != 0)) {
            return new AdjustedImageArrayAnimation(this.imageArray, this.dx, this.dy, this.animationBehaviorFactory.getOrCreateInstance())
        } else {
            return new ImageArrayAnimation(this.imageArray, AnimationBehavior.getInstance())
        }
        throw new IllegalStateException()
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
    }

}


