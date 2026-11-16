/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image.sprite

import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.game.Sprite
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.animation.image.BaseImageAnimationFactory
import _root_.org.allbinary.graphics.color.BasicColorUtil
import _root_.org.allbinary.image.sprite.AnimationFactorySpriteScaleUtil
import _root_.org.allbinary.logic.math.PrimitiveIntUtil

class OneRowSpriteIndexedAnimationFactory(param_image : Image, param_sequenceArray : Array[Int], param_width : Int, param_height : Int, param_dx : Int, param_dy : Int, param_animationBehaviorFactory : AnimationBehaviorFactory) extends BaseImageAnimationFactory(param_image, param_sequenceArray, param_width, param_height, param_dx, param_dy, param_animationBehaviorFactory) {
    import _root_.org.allbinary.animation.image.sprite.OneRowSpriteIndexedAnimationFactory.{*}

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
    }

    def init(dx : Int, dy : Int) : Unit = {
        this.animationFactoryInitializationVisitor.dx = dx
        this.animationFactoryInitializationVisitor.dy = dy
    }

    def initW(dx : Int) : Unit = {
        this.init(dx, 0)
        this.animationFactoryInitializationVisitor.dx += -(this.animationFactoryInitializationVisitor.width >> 2)
    }

    override def getInstance(instanceId : Int) : Animation = {
        val sprite : Sprite = this.animationFactorySpriteScaleUtil.createImage(this.getImage(), this.animationFactoryInitializationVisitor.width, this.animationFactoryInitializationVisitor.height, this.scaleProperties.scaleWidth, this.scaleProperties.scaleHeight)
        if ((this.animationFactoryInitializationVisitor.dx != 0) || (this.animationFactoryInitializationVisitor.dy != 0)) {
            return new AdjustedSpriteIndexedAnimation(sprite, this.getImage(), BasicColorUtil.getInstance().ZERO_ARRAY, this.animationFactoryInitializationVisitor.dx, this.animationFactoryInitializationVisitor.dy, this.animationBehaviorFactory.getOrCreateInstance())
        } else {
            return new SpriteIndexedAnimation(sprite, this.getImage(), BasicColorUtil.getInstance().ZERO_ARRAY, this.animationBehaviorFactory.getOrCreateInstance())
        }
        throw new IllegalStateException()
    }

}

object OneRowSpriteIndexedAnimationFactory {
    def createFactoryDX(image : Image, dx : Int, animationBehaviorFactory : AnimationBehaviorFactory) : OneRowSpriteIndexedAnimationFactory = {
        val oneRowSpriteIndexedAnimationFactory : OneRowSpriteIndexedAnimationFactory = new OneRowSpriteIndexedAnimationFactory(image, PrimitiveIntUtil.getArrayInstance(), image.getHeight(), image.getHeight(), 0, 0, animationBehaviorFactory)
        oneRowSpriteIndexedAnimationFactory.initW(dx)
        return oneRowSpriteIndexedAnimationFactory
    }

    //    }
    def createFactoryDXY(image : Image, dx : Int, dy : Int, animationBehaviorFactory : AnimationBehaviorFactory) : OneRowSpriteIndexedAnimationFactory = {
        //Future imp may include Control fidelity for non square frames
        val oneRowSpriteIndexedAnimationFactory : OneRowSpriteIndexedAnimationFactory = new OneRowSpriteIndexedAnimationFactory(image, PrimitiveIntUtil.getArrayInstance(), image.getHeight(), image.getHeight(), 0, 0, animationBehaviorFactory)
        oneRowSpriteIndexedAnimationFactory.init(dx, dy)
        return oneRowSpriteIndexedAnimationFactory
    }

    def createFactoryWH(image : Image, width : Int, height : Int, animationBehaviorFactory : AnimationBehaviorFactory) : OneRowSpriteIndexedAnimationFactory = {
        //Future imp may include Control fidelity for non square frames
        return new OneRowSpriteIndexedAnimationFactory(image, PrimitiveIntUtil.getArrayInstance(), width, height, 0, 0, animationBehaviorFactory)
    }

    def createFactory(image : Image, animationBehaviorFactory : AnimationBehaviorFactory) : OneRowSpriteIndexedAnimationFactory = {
        //Future imp may include Control fidelity for non square frames
        return new OneRowSpriteIndexedAnimationFactory(image, PrimitiveIntUtil.getArrayInstance(), image.getHeight(), image.getHeight(), 0, 0, animationBehaviorFactory)
    }

}


