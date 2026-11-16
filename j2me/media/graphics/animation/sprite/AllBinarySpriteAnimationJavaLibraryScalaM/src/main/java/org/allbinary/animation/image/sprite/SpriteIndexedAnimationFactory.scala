/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image.sprite

import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.game.Sprite
import _root_.org.allbinary.AndroidUtil
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.animation.ProceduralAnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.image.BaseImageAnimationFactory
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorUtil
import _root_.org.allbinary.image.sprite.AnimationFactorySpriteScaleUtil
import _root_.org.allbinary.logic.math.PrimitiveIntUtil

class SpriteIndexedAnimationFactory private(param_image : Image, param_basicColorArray : Array[BasicColor], param_sequenceArray : Array[Int], param_width : Int, param_height : Int, param_dx : Int, param_dy : Int, param_animationBehaviorFactory : AnimationBehaviorFactory) extends BaseImageAnimationFactory(param_image, param_sequenceArray, param_width, param_height, param_dx, param_dy, param_animationBehaviorFactory) with ProceduralAnimationInterfaceFactoryInterface {
    import _root_.org.allbinary.animation.image.sprite.SpriteIndexedAnimationFactory.{*}

    private val animationFactorySpriteScaleUtil : AnimationFactorySpriteScaleUtil = AnimationFactorySpriteScaleUtil.getInstance()

    private var basicColorArray : Array[BasicColor] = BasicColorUtil.getInstance().ZERO_ARRAY

    //Constructor
    {
        val image : Image = param_image
        val basicColorArray : Array[BasicColor] = param_basicColorArray
        val sequenceArray : Array[Int] = param_sequenceArray
        val width : Int = param_width
        val height : Int = param_height
        val dx : Int = param_dx
        val dy : Int = param_dy
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
        this.basicColorArray = basicColorArray
    }

    private def initHWH() : Unit = {
        //J2ME
        this.animationFactoryInitializationVisitor.dx = -(this.animationFactoryInitializationVisitor.width >> 2)
        this.animationFactoryInitializationVisitor.dy = -(this.animationFactoryInitializationVisitor.height >> 2)
        if (AndroidUtil.isAndroid()) {
            this.animationFactoryInitializationVisitor.dx += 3
        }
    }

    override def getInstance(instanceId : Int) : Animation = {
        val sprite : Sprite = this.animationFactorySpriteScaleUtil.createImage(this.getImage(), this.animationFactoryInitializationVisitor.width, this.animationFactoryInitializationVisitor.height, this.scaleProperties.scaleWidth, this.scaleProperties.scaleHeight)
        if ((this.animationFactoryInitializationVisitor.dx != 0) || (this.animationFactoryInitializationVisitor.dy != 0)) {
            return new AdjustedSpriteIndexedAnimation(sprite, this.getImage(), this.basicColorArray, this.animationFactoryInitializationVisitor.dx, this.animationFactoryInitializationVisitor.dy, this.animationBehaviorFactory.getOrCreateInstance())
        } else {
            return new SpriteIndexedAnimation(sprite, this.getImage(), this.basicColorArray, this.animationBehaviorFactory.getOrCreateInstance())
        }
        throw new IllegalStateException()
    }

    override def getInstanceAnimation(animationInterface : Animation) : Animation = {
        return this.getInstance(0)
    }

}

object SpriteIndexedAnimationFactory {
    def createCWHDXY(image : Image, basicColorArray : Array[BasicColor], width : Int, height : Int, dx : Int, dy : Int, animationBehaviorFactory : AnimationBehaviorFactory) : SpriteIndexedAnimationFactory = {
        return new SpriteIndexedAnimationFactory(image, basicColorArray, PrimitiveIntUtil.getArrayInstance(), width, height, dx, dy, animationBehaviorFactory)
    }

    def createCWH(image : Image, basicColorArray : Array[BasicColor], width : Int, height : Int, animationBehaviorFactory : AnimationBehaviorFactory) : SpriteIndexedAnimationFactory = {
        val spriteIndexedAnimationFactory : SpriteIndexedAnimationFactory = new SpriteIndexedAnimationFactory(image, basicColorArray, PrimitiveIntUtil.getArrayInstance(), width, height, 0, 0, animationBehaviorFactory)
        spriteIndexedAnimationFactory.initHWH()
        return spriteIndexedAnimationFactory
    }

    def createWH(image : Image, width : Int, height : Int, animationBehaviorFactory : AnimationBehaviorFactory) : SpriteIndexedAnimationFactory = {
        return new SpriteIndexedAnimationFactory(image, BasicColorUtil.getInstance().ZERO_ARRAY, PrimitiveIntUtil.getArrayInstance(), width, height, 0, 0, animationBehaviorFactory)
    }

}


