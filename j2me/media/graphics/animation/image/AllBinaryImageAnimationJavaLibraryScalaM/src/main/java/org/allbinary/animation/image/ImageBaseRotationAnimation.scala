/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.DisposalUtil
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.RotationAnimation
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.logic.math.PrimitiveIntUtil
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.util.CircularIndexUtil

class ImageBaseRotationAnimation(param_image : Image, param_angleInfo : AngleInfo, param_totalAngle : Short, param_animationBehavior : AnimationBehavior) extends RotationAnimation(param_angleInfo, CircularIndexUtil.createInstance(param_totalAngle / param_angleInfo.getAngleIncrementInfo().getAngleIncrement()), param_animationBehavior) {

    private var image : Image = null

    var anchor : Int = Anchor.TOP_LEFT

    //private static final int totalFrames = 1;
    //Constructor
    {
        val image : Image = param_image
        val angleInfo : AngleInfo = param_angleInfo
        val totalAngle : Short = param_totalAngle
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.image = image
    }

    override def getAnimationSize() : Int = {
        return this.getSize()
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

    override def getWidth() : Int = {
        return this.image.getWidth()
    }

    override def getHeight() : Int = {
        return this.image.getHeight()
    }

    /*     public void paint(Graphics graphics) {     graphics.drawImage(this.image, 0, 0, Anchor.TOP_LEFT);     }      */
    def close() : Unit = {
        DisposalUtil.getInstance().disposeImage(this.image)
    }

    override def finalize() : Unit = {
        DisposalUtil.getInstance().disposeImage(this.image)
    }

}


