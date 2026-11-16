/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image.sprite

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.game.Sprite
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorUtil

class AdjustedSpriteIndexedAnimation(param_sprite : Sprite, param_image : Image, param_basicColorArray : Array[BasicColor], param_dx : Int, param_dy : Int, param_animationBehavior : AnimationBehavior) extends SpriteIndexedAnimation(param_sprite, param_image, param_basicColorArray, param_animationBehavior) {

    private var dx : Int = 0

    private var dy : Int = 0

    //Constructor
    {
        val sprite : Sprite = param_sprite
        val image : Image = param_image
        val basicColorArray : Array[BasicColor] = param_basicColorArray
        val dx : Int = param_dx
        val dy : Int = param_dy
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.dx = dx
        this.dy = dy
    }

    override def paintFrame(graphics : Graphics, frame : Int, x : Int, y : Int) : Unit = {
        this.setFrame(frame)
        this.sprite.setPosition(x + this.dx, y + this.dy)
        super.paint(graphics)
    }

    override def paintXY(g : Graphics, x : Int, y : Int) : Unit = {
        this.sprite.setPosition(x + this.dx, y + this.dy)
        super.paint(g)
    }

    override def paint(g : Graphics) : Unit = {
        this.sprite.setPosition(this.dx, this.dy)
        super.paint(g)
    }

}


