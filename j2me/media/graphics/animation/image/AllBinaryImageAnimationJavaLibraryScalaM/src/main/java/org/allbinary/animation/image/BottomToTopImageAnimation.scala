/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.game.Sprite
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.logic.math.PrimitiveIntUtil

/**  *  * @author user  */
class BottomToTopImageAnimation(param_image : Image, param_animationBehavior : AnimationBehavior) extends ImageSegmentAnimation(param_image, PrimitiveIntUtil.getArrayInstance(), param_animationBehavior) {

    private var startHeight : Int = 0

    private var currentHeight : Int = 0

    private var anchor : Int = Anchor.TOP_LEFT

    //Constructor
    {
        val image : Image = param_image
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.setFrame(this.getSize() - 1)
    }

    override def nextFrame() : Unit = {
        super.previousFrame()
        this.update()
    }

    override def previousFrame() : Unit = {
        super.nextFrame()
        this.update()
    }

    override def setFrame(index : Int) : Unit = {
        super.setFrame(index)
        this.update()
    }

    private def update() : Unit = {
        this.startHeight = (this.getDrawHeight() * this.getFrame()) / this.getSize()
        this.currentHeight = this.getDrawHeight() - this.startHeight
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        //  int x_dst, int y_dst, int anchor
        graphics.drawRegion(this.getImage(), this.getStartX(), this.startHeight, this.getDrawWidth(), this.currentHeight, Sprite.TRANS_NONE, x, y + this.startHeight, this.anchor)
    }

}


