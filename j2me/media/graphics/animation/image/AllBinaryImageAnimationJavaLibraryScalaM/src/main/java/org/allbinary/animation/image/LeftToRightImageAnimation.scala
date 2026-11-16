/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.game.Sprite
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.graphics.Anchor

/**  *  * @author user  */
class LeftToRightImageAnimation(param_image : Image, param_sequenceArray : Array[Int], param_animationBehavior : AnimationBehavior) extends ImageSegmentAnimation(param_image, param_sequenceArray, param_animationBehavior) {

    private var currentWidth : Int = 0

    private var anchor : Int = Anchor.TOP_LEFT

    //Constructor
    {
        val image : Image = param_image
        val sequenceArray : Array[Int] = param_sequenceArray
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.currentWidth = 0
        if (this.getSequence()(0) == -1) {
            this.setFrame(this.getSize() - 1)
        }
    }

    override def nextFrame() : Unit = {
        if (this.getSequence()(0) == -1) {
            super.previousFrame()
        } else {
            super.nextFrame()
        }
        this.update()
    }

    override def previousFrame() : Unit = {
        if (this.getSequence()(0) == -1) {
            super.nextFrame()
        } else {
            super.previousFrame()
        }
        this.update()
    }

    override def setFrame(index : Int) : Unit = {
        super.setFrame(index)
        this.update()
    }

    private def update() : Unit = {
        this.currentWidth = (this.getDrawWidth() * this.getFrame()) / this.getSize()
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        //  int x_dst, int y_dst, int anchor
        graphics.drawRegion(this.getImage(), this.getStartX(), this.getStartY(), this.currentWidth, this.getDrawHeight(), Sprite.TRANS_NONE, x, y, this.anchor)
    }

}


