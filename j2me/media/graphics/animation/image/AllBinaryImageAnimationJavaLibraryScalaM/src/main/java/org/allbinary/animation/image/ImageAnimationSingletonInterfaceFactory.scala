/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.SingletonAnimationInterfaceFactory
import _root_.org.allbinary.image.AnimationFrameToImageUtil

class ImageAnimationSingletonInterfaceFactory(param_animationInterface : Animation, param_width : Int, param_height : Int) extends SingletonAnimationInterfaceFactory(new ImageAnimation(AnimationFrameToImageUtil.getInstance().getInstanceWH(param_width, param_height, param_animationInterface), AnimationBehavior.getInstance())) {

    //Constructor
    {
        val animationInterface : Animation = param_animationInterface
        val width : Int = param_width
        val height : Int = param_height
    }

}


