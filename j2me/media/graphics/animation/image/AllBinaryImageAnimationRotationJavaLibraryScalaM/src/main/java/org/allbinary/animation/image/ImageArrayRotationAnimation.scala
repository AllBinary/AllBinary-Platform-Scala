/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.math.AngleInfo

class ImageArrayRotationAnimation(param_imageArray : Array[Image], param_angleInfo : AngleInfo, param_totalAngle : Int, param_animationBehavior : AnimationBehavior) extends ImageArrayBaseRotationAnimation(param_imageArray, param_angleInfo, param_animationBehavior) {
    import _root_.org.allbinary.animation.image.ImageArrayRotationAnimation.{*}

    // , 10, AngleIncrementInfo.TOTAL_ANGLE, angleIncrement, AngleIncrementInfo.TOTAL_ANGLE
    private var expectedTotalFrames : Int = 0

    //Constructor
    {
        val imageArray : Array[Image] = param_imageArray
        val angleInfo : AngleInfo = param_angleInfo
        val totalAngle : Int = param_totalAngle
        val animationBehavior : AnimationBehavior = param_animationBehavior
        // this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR);
        this.initImageArray(imageArray, angleInfo, totalAngle)
    }

    //    }
    private def initImageArray(imageArray : Array[Image], angleInfo : AngleInfo, totalAngle : Int) : Unit = {
        // this.logUtil.putF(this.commonStrings.START, // this, "AllBinaryImageRotationAnimation");
        this.expectedTotalFrames = totalAngle / this.angleInfo.getAngleIncrementInfo().getAngleIncrement()
        this.angleInfo.adjustAngle(0)
        if (this.expectedTotalFrames != this.getSize()) {
            throw new Exception("Wrong Number of Frames")
        }
    }

    override def setImageArray(imageArray : Array[Image]) : Unit = {
        super.setImageArray(imageArray)
        this.angleInfo.adjustAngle(0)
    }

}

object ImageArrayRotationAnimation {
    def createAnimation(anyType : Object, animationBehavior : AnimationBehavior) : ImageArrayRotationAnimation = {
        val imageRotationAnimationInfo : ImageArrayRotationAnimationInfo = anyType.asInstanceOf[ImageArrayRotationAnimationInfo]
        return new ImageArrayRotationAnimation(imageRotationAnimationInfo.getImageArray(), imageRotationAnimationInfo.getAngleInfoP(), imageRotationAnimationInfo.getTotalAngle(), animationBehavior)
    }

}


