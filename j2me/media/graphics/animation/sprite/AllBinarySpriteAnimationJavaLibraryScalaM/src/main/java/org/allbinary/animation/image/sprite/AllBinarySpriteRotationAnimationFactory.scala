/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image.sprite

import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.game.Sprite
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.animation.ProceduralAnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.image.BaseImageAnimationFactory
import _root_.org.allbinary.image.sprite.AnimationFactorySpriteScaleUtil
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.math.PrimitiveIntUtil

class AllBinarySpriteRotationAnimationFactory(param_image : Image, param_sequenceArray : Array[Int], param_width : Int, param_height : Int, param_dx : Int, param_dy : Int, param_animationBehaviorFactory : AnimationBehaviorFactory) extends BaseImageAnimationFactory(param_image, param_sequenceArray, param_width, param_height, param_dx, param_dy, param_animationBehaviorFactory) with ProceduralAnimationInterfaceFactoryInterface {
    import _root_.org.allbinary.animation.image.sprite.AllBinarySpriteRotationAnimationFactory.{*}

    private val animationFactorySpriteScaleUtil : AnimationFactorySpriteScaleUtil = AnimationFactorySpriteScaleUtil.getInstance()

    //Constructor
    {
        val image : Image = param_image
        val sequenceArray : Array[Int] = param_sequenceArray
        val width : Int = param_width
        val height : Int = param_height
        val dx : Int = param_dx
        val dy : Int = param_dy
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
        if (animationBehaviorFactory eq AnimationBehaviorFactory.getInstance()) {
            ForcedLogUtil.log("Using default AnimationBehaviorFactory with IndexedAnimationFactory", this)
        }
    }

    def init(dx : Int, dy : Int) : Unit = {
        this.animationFactoryInitializationVisitor.dx = dx
        this.animationFactoryInitializationVisitor.dy = dy
    }

    private def initWH(dx : Int, dy : Int) : Unit = {
        this.init(dx, dy)
        this.animationFactoryInitializationVisitor.dx += -this.animationFactoryInitializationVisitor.width / 5
        this.animationFactoryInitializationVisitor.dy += -this.animationFactoryInitializationVisitor.height / 5
    }

    override def getInstance(instanceId : Int) : Animation = {
        val sprite : Sprite = this.animationFactorySpriteScaleUtil.createImage(this.getImage(), this.animationFactoryInitializationVisitor.width, this.animationFactoryInitializationVisitor.height, this.scaleProperties.scaleWidth, this.scaleProperties.scaleHeight)
        if ((this.animationFactoryInitializationVisitor.dx != 0) || (this.animationFactoryInitializationVisitor.dy != 0)) {
            return new AllBinaryAdjustedSpriteRotationAnimation(sprite, this.getImage(), this.animationFactoryInitializationVisitor.dx, this.animationFactoryInitializationVisitor.dy, this.animationBehaviorFactory.getOrCreateInstance())
        } else {
            return new AllBinarySpriteRotationAnimation(sprite, this.getImage(), this.animationBehaviorFactory.getOrCreateInstance())
        }
        throw new IllegalStateException()
    }

    override def getInstanceAnimation(animationInterface : Animation) : Animation = {
        return this.getInstance(0)
    }

}

object AllBinarySpriteRotationAnimationFactory {
    //
    def createWHDY(image : Image, dx : Int, dy : Int, animationBehaviorFactory : AnimationBehaviorFactory) : AllBinarySpriteRotationAnimationFactory = {
        val spriteRotationAnimationFactory : AllBinarySpriteRotationAnimationFactory = new AllBinarySpriteRotationAnimationFactory(image, PrimitiveIntUtil.getArrayInstance(), (image.getHeight() >> 2), (image.getHeight() >> 2), 0, 0, animationBehaviorFactory)
        spriteRotationAnimationFactory.initWH(dx, dy)
        return spriteRotationAnimationFactory
    }

    def createWH(image : Image, animationBehaviorFactory : AnimationBehaviorFactory) : AllBinarySpriteRotationAnimationFactory = {
        return AllBinarySpriteRotationAnimationFactory.createWHDY(image, 0, 0, animationBehaviorFactory)
    }

    def createDXY(image : Image, dx : Int, dy : Int, animationBehaviorFactory : AnimationBehaviorFactory) : AllBinarySpriteRotationAnimationFactory = {
        val spriteRotationAnimationFactory : AllBinarySpriteRotationAnimationFactory = new AllBinarySpriteRotationAnimationFactory(image, PrimitiveIntUtil.getArrayInstance(), image.getHeight(), image.getHeight(), 0, 0, animationBehaviorFactory)
        spriteRotationAnimationFactory.init(dx, dy)
        return spriteRotationAnimationFactory
    }

    def createDXYQ(image : Image, dx : Int, dy : Int, animationBehaviorFactory : AnimationBehaviorFactory) : AllBinarySpriteRotationAnimationFactory = {
        val spriteRotationAnimationFactory : AllBinarySpriteRotationAnimationFactory = new AllBinarySpriteRotationAnimationFactory(image, PrimitiveIntUtil.getArrayInstance(), (image.getHeight() >> 2), (image.getHeight() >> 2), 0, 0, animationBehaviorFactory)
        spriteRotationAnimationFactory.init(dx, dy)
        return spriteRotationAnimationFactory
    }

    def createQ(image : Image, animationBehaviorFactory : AnimationBehaviorFactory) : AllBinarySpriteRotationAnimationFactory = {
        //4 rows
        return new AllBinarySpriteRotationAnimationFactory(image, PrimitiveIntUtil.getArrayInstance(), (image.getHeight() >> 2), (image.getHeight() >> 2), 0, 0, animationBehaviorFactory)
    }

    def createWHF(image : Image, animationBehaviorFactory : AnimationBehaviorFactory) : AllBinarySpriteRotationAnimationFactory = {
        //Future imp may include Control fidelity for non square frames
        return new AllBinarySpriteRotationAnimationFactory(image, PrimitiveIntUtil.getArrayInstance(), image.getHeight(), image.getHeight(), 0, 0, animationBehaviorFactory)
    }

}


