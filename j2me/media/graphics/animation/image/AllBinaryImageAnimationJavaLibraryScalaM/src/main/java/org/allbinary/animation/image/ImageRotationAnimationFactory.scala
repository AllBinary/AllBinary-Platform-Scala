/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.game.configuration.GameConfigurationCentral
import _root_.org.allbinary.logic.math.PrimitiveIntUtil
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.math.AngleInfo

class ImageRotationAnimationFactory(param_image : Image, param_width : Int, param_height : Int, param_dx : Int, param_dy : Int, param_angleIncrement : Short, param_animationBehaviorFactory : AnimationBehaviorFactory) extends BaseImageAnimationFactory(param_image, PrimitiveIntUtil.getArrayInstance(), param_width, param_height, 0, 0, param_animationBehaviorFactory) {

    var angleIncrement : Short = 0

    //    }
    //Constructor
    {
        val image : Image = param_image
        val width : Int = param_width
        val height : Int = param_height
        val dx : Int = param_dx
        val dy : Int = param_dy
        val angleIncrement : Short = param_angleIncrement
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
        this.angleIncrement = angleIncrement
        //this(image, width, height, angleIncrement, animationBehaviorFactory);
        this.animationFactoryInitializationVisitor.dx = dx
        this.animationFactoryInitializationVisitor.dy = dy
    }

    //    }
    override def getInstance(instanceId : Int) : Animation = {
        if ((this.animationFactoryInitializationVisitor.dx != 0) || (this.animationFactoryInitializationVisitor.dy != 0)) {
            this.animationFactoryImageScaleUtil.processAdjust(this)
            return new AdjustedImageBaseRotationAnimation(this.getImage(), AngleInfo.getInstance(this.angleIncrement), AngleFactory.getInstance().TOTAL_ANGLE, this.animationFactoryInitializationVisitor.dx, this.animationFactoryInitializationVisitor.dy, this.animationBehaviorFactory.getOrCreateInstance())
        } else {
            return new ImageBaseRotationAnimation(this.getImage(), AngleInfo.getInstance(this.angleIncrement), AngleFactory.getInstance().TOTAL_ANGLE, this.animationBehaviorFactory.getOrCreateInstance())
        }
        throw new IllegalStateException()
    }

    def getAngleIncrementP() : Short = {
        return this.angleIncrement
    }

}


