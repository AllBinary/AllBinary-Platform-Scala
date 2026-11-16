/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.util.cache.CacheableInterface

class ImageArrayRotationAnimationCacheable(param_anyType : Object, param_animationBehavior : AnimationBehavior) extends AdjustedImageArrayRotationAnimation((param_anyType.asInstanceOf[ImageArrayRotationAnimationInfo]).getImageArray(), (param_anyType.asInstanceOf[ImageArrayRotationAnimationInfo]).getAngleInfoP(), (param_anyType.asInstanceOf[ImageArrayRotationAnimationInfo]).getTotalAngle(), (param_anyType.asInstanceOf[ImageArrayRotationAnimationInfo]).getDx(), (param_anyType.asInstanceOf[ImageArrayRotationAnimationInfo]).getDy(), param_animationBehavior) with CacheableInterface {

    //private Object key;
    //Constructor
    {
        val anyType : Object = param_anyType
        val animationBehavior : AnimationBehavior = param_animationBehavior
    }

    /*  public AllBinaryImageRotationAnimationCacheable(    MEImage[] imageArray, int angleIncrement, int totalAngle, int dx, int dy)   throws Exception   {   super(imageArray, angleIncrement, totalAngle, dx, dy);  }  */
    override def getKey() : Object = {
        return NullUtil.getInstance().NULL_OBJECT
    }

    override def toString() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

}


