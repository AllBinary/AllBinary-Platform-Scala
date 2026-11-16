/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image.sprite

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.game.Sprite
import _root_.org.allbinary.animation.AnimationBehavior

class AllBinaryAdjustedSpriteRotationAnimation(param_sprite : Sprite, param_image : Image, param_dx : Int, param_dy : Int, param_animationBehavior : AnimationBehavior) extends AllBinarySpriteRotationAnimation(param_sprite, param_image, param_animationBehavior) {

    private var dx : Int = 0

    private var dy : Int = 0

    //Constructor
    {
        val sprite : Sprite = param_sprite
        val image : Image = param_image
        val dx : Int = param_dx
        val dy : Int = param_dy
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.dx = dx
        this.dy = dy
    }

    override def paintXY(g : Graphics, x : Int, y : Int) : Unit = {
        this.sprite.setPosition(x + this.dx, y + this.dy)
        this.paint(g)
    }

}


