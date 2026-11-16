/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.logic.math.PrimitiveIntUtil
import _root_.org.allbinary.util.CircularIndexUtil

class ImageArrayAnimation(param_imageArray : Array[Image], param_animationBehavior : AnimationBehavior) extends IndexedAnimation(param_animationBehavior) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var imageArray : Array[Image] = NullImage.NULL_IMAGE_ARRAY

    // private int totalAngle;
    private var totalFrames : Int = 0

    var circularIndexUtil : CircularIndexUtil = CircularIndexUtil.NULL_CIRCULAR_INDEX_UTIL

    private var anchor : Int = Anchor.TOP_LEFT

    //Constructor
    {
        val imageArray : Array[Image] = param_imageArray
        val animationBehavior : AnimationBehavior = param_animationBehavior
        // this.logUtil.putF(, this, );
        this.setImageArray(imageArray)
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

    def getImage(index : Int) : Image = {
        return this.imageArray(index)
    }

    def getImageArray() : Array[Image] = {
        return this.imageArray
    }

    def setImageArray(imageArray : Array[Image]) : Unit = {
        this.imageArray = imageArray
        this.totalFrames = imageArray.length
        this.circularIndexUtil = CircularIndexUtil.createInstance(this.totalFrames)
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        graphics.drawImage(this.imageArray(this.circularIndexUtil.getIndex()), x, y, this.anchor)
    }

}


