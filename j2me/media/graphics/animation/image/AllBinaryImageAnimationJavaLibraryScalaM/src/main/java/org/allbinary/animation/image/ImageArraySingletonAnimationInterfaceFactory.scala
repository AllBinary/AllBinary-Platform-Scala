/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.animation.SingletonAnimationInterfaceFactory
import _root_.org.allbinary.image.IndexedAnimationToImageArrayUtil

class ImageArraySingletonAnimationInterfaceFactory(param_imageArray : Array[Image]) extends SingletonAnimationInterfaceFactory(new ImageArrayAnimation(param_imageArray, AnimationBehavior.getInstance())) {

    //    }
    //Constructor
    {
        val imageArray : Array[Image] = param_imageArray
    }

}


