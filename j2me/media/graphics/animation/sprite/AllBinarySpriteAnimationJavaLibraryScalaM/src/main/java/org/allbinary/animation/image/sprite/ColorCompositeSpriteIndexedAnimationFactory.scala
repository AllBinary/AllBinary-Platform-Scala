/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image.sprite

import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.game.Sprite
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.animation.ProceduralAnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.image.BaseImageAnimationFactory
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.image.sprite.AnimationFactorySpriteScaleUtil
import _root_.org.allbinary.logic.math.PrimitiveIntUtil

class ColorCompositeSpriteIndexedAnimationFactory(param_image : Image, param_basicColorArray : Array[BasicColor], param_width : Int, param_height : Int, param_animationBehaviorFactory : AnimationBehaviorFactory) extends BaseImageAnimationFactory(param_image, PrimitiveIntUtil.getArrayInstance(), param_width, param_height, 0, 0, param_animationBehaviorFactory) with ProceduralAnimationInterfaceFactoryInterface {

    private val animationFactorySpriteScaleUtil : AnimationFactorySpriteScaleUtil = AnimationFactorySpriteScaleUtil.getInstance()

    private var basicColorArray : Array[BasicColor] = null

    //Constructor
    {
        val image : Image = param_image
        val basicColorArray : Array[BasicColor] = param_basicColorArray
        val width : Int = param_width
        val height : Int = param_height
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
        this.basicColorArray = basicColorArray
    }

    /*     public SpriteIndexedAnimationFactory(MEImage image, int width, int height, int dx, int dy)     throws Exception     {     this.image = image;     this.width = width;     this.height = height;     this.dx = dx;     this.dy = dy;     }      */
    override def getInstance(instanceId : Int) : Animation = {
        val sprite : Sprite = this.animationFactorySpriteScaleUtil.createImage(this.getImage(), this.animationFactoryInitializationVisitor.width, this.animationFactoryInitializationVisitor.height, this.scaleProperties.scaleWidth, this.scaleProperties.scaleHeight)
        return new SpriteIndexedAnimation(sprite, this.getImage(), this.basicColorArray, this.animationBehaviorFactory.getOrCreateInstance())
    }

    override def getInstanceAnimation(animationInterface : Animation) : Animation = {
        return this.getInstance(0)
    }

}


