/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.animation.VectorAnimation
import _root_.org.allbinary.game.configuration.GameConfigurationCentral
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.image.AnimationFrameToImageUtil
import _root_.org.allbinary.logic.math.PrimitiveIntUtil
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.media.ScaleProperties
import _root_.org.allbinary.media.image.ImageToRotationImageArrayUtil
import _root_.org.allbinary.vector.VectorInfo

class VectorToImageArrayRotationAnimationFactory(param_vectorInfo : VectorInfo, param_basicColor : BasicColor, param_animationBehaviorFactory : AnimationBehaviorFactory) extends BaseImageAnimationFactory(AnimationFrameToImageUtil.getInstance().getInstanceTranslate(param_vectorInfo.getWidth(), param_vectorInfo.getHeight(), VectorAnimation.createVectorAnimation(param_vectorInfo.getPoints(), param_basicColor, param_animationBehaviorFactory.getOrCreateInstance())), PrimitiveIntUtil.getArrayInstance(), 0, 0, 0, 0, param_animationBehaviorFactory) {

    private var imageArray : Array[Image] = NullImage.NULL_IMAGE_ARRAY

    private var angleIncrement : Int = 0

    //    }
    //Constructor
    {
        val vectorInfo : VectorInfo = param_vectorInfo
        val basicColor : BasicColor = param_basicColor
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
        this.init()
    }

    def init() : Unit = {
        val angleFactory : AngleFactory = AngleFactory.getInstance()
        this.angleIncrement = angleFactory.TOTAL_ANGLE / GameConfigurationCentral.getInstance().getGameControlFidelity()
        this.imageArray = ImageToRotationImageArrayUtil.getInstance().generate(this.getImage(), this.getAngleIncrement(), angleFactory.TOTAL_ANGLE.toInt)
    }

    override def getInstance(instanceId : Int) : Animation = {
        if ((this.animationFactoryInitializationVisitor.dx != 0) || (this.animationFactoryInitializationVisitor.dy != 0)) {
            return new AdjustedImageArrayRotationAnimation(this.imageArray, AngleInfo.getInstance(this.getAngleIncrement().toShort), AngleFactory.getInstance().TOTAL_ANGLE.toInt, this.animationFactoryInitializationVisitor.dx, this.animationFactoryInitializationVisitor.dy, this.animationBehaviorFactory.getOrCreateInstance())
        } else {
            //This still offsets.
            return AdjustedImageArrayRotationAnimation.createAnimation(this.imageArray, AngleInfo.getInstance(this.angleIncrement.toShort), AngleFactory.getInstance().TOTAL_ANGLE.toInt, this.animationBehaviorFactory.getOrCreateInstance())
        }
        throw new IllegalStateException()
    }

    def getAngleIncrement() : Int = {
        return this.angleIncrement
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
    }

}


