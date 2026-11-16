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
import _root_.org.allbinary.util.CircularIndexUtil

class TweenedImageAnimation(param_image : Image, param_dx : Int, param_dy : Int, param_totalFrames : Int, param_animationBehavior : AnimationBehavior) extends IndexedAnimation(param_animationBehavior) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var image : Image = null

    private var dx : Int = 0

    private var dy : Int = 0

    private var totalFrames : Int = 0

    var circularIndexUtil : CircularIndexUtil = null

    private var anchor : Int = Anchor.TOP_LEFT

    //Constructor
    {
        val image : Image = param_image
        val dx : Int = param_dx
        val dy : Int = param_dy
        val totalFrames : Int = param_totalFrames
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.image = image
        this.dx = dx
        this.dy = dy
        this.totalFrames = totalFrames
        this.circularIndexUtil = CircularIndexUtil.createInstance(this.totalFrames)
    }

    override def getAnimationSize() : Int = {
        return this.getSize()
    }

    override def nextFrame() : Unit = {
        this.circularIndexUtil.next()
    }

    override def previousFrame() : Unit = {
        this.circularIndexUtil.previous()
    }

    override def setFrame(index : Int) : Unit = {
        this.circularIndexUtil.setIndex(index)
    }

    override def getFrame() : Int = {
        return this.circularIndexUtil.getIndex()
    }

    override def getSize() : Int = {
        return this.totalFrames
    }

    override def setSequence(sequence : Array[Int]) : Unit = {
    }

    override def getSequence() : Array[Int] = {
        return PrimitiveIntUtil.getArrayInstance()
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        var frame : Int = this.getFrame()
        var currentX : Int = this.dx * frame
        var currentY : Int = this.dy * frame
        graphics.drawImage(this.image, x + currentX, y + currentY, this.anchor)
    }

    def close() : Unit = {
        DisposalUtil.getInstance().disposeImage(this.image)
    }

    override def finalize() : Unit = {
        DisposalUtil.getInstance().disposeImage(this.image)
    }

}


