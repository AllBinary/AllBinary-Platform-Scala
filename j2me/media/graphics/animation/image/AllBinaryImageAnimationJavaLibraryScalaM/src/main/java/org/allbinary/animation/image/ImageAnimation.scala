/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.DisposalUtil
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.logic.math.PrimitiveIntUtil

class ImageAnimation(param_image : Image, param_animationBehavior : AnimationBehavior) extends IndexedAnimation(param_animationBehavior) {

    private var image : Image = null

    private var anchor : Int = Anchor.TOP_LEFT

    //Constructor
    {
        val image : Image = param_image
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.image = image
    }

    override def getAnimationSize() : Int = {
        return this.getSize()
    }

    override def nextFrame() : Unit = {
    }

    override def previousFrame() : Unit = {
    }

    override def setFrame(index : Int) : Unit = {
    }

    override def getFrame() : Int = {
        return 0
    }

    override def getSize() : Int = {
        return 1
    }

    override def setSequence(sequence : Array[Int]) : Unit = {
    }

    override def getSequence() : Array[Int] = {
        return PrimitiveIntUtil.getArrayInstance()
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        graphics.drawImage(this.image, x, y, this.anchor)
    }

    /**      * @return the image      */
    def getImage() : Image = {
        return this.image
    }

    //java.lang.ref.PhantomReference
    def close() : Unit = {
        DisposalUtil.getInstance().disposeImage(this.image)
    }

    override def finalize() : Unit = {
        DisposalUtil.getInstance().disposeImage(this.image)
    }

}


