/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.util.CircularIndexUtil

/**  *  * @author user  */
class ImageSegmentAnimation(param_image : Image, param_sequenceArray : Array[Int], param_animationBehavior : AnimationBehavior) extends ImageAnimation(param_image, param_animationBehavior) {

    private var startX : Int = 0

    private var startY : Int = 0

    private var drawWidth : Int = 0

    private var drawHeight : Int = 0

    private var circularIndexUtil : CircularIndexUtil = null

    //private int diff;
    private var sequenceArray : Array[Int] = null

    //Constructor
    {
        val image : Image = param_image
        val sequenceArray : Array[Int] = param_sequenceArray
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.startX = 0
        this.startY = 0
        this.drawWidth = this.getImage().getWidth()
        this.drawHeight = this.getImage().getHeight()
        //this.circularIndexUtil = CircularIndexUtil.getInstance(this.diff);
        this.circularIndexUtil = CircularIndexUtil.createInstance(this.drawHeight)
        this.sequenceArray = sequenceArray
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
        return this.circularIndexUtil.getSize()
    }

    override def setSequence(sequenceArray : Array[Int]) : Unit = {
        this.sequenceArray = sequenceArray
    }

    override def getSequence() : Array[Int] = {
        return this.sequenceArray
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
    }

    /**      * @return the startX      */
    def getStartX() : Int = {
        return this.startX
    }

    /**      * @param startX the startX to set      */
    def setStartX(startX : Int) : Unit = {
        this.startX = startX
    }

    /**      * @return the startY      */
    def getStartY() : Int = {
        return this.startY
    }

    /**      * @param startY the startY to set      */
    def setStartY(startY : Int) : Unit = {
        this.startY = startY
    }

    /**      * @return the drawWidth      */
    def getDrawWidth() : Int = {
        return this.drawWidth
    }

    /**      * @param drawWidth the drawWidth to set      */
    def setDrawWidth(drawWidth : Int) : Unit = {
        this.drawWidth = drawWidth
    }

    /**      * @return the drawHeight      */
    def getDrawHeight() : Int = {
        return this.drawHeight
    }

    /**      * @param drawHeight the drawHeight to set      */
    def setDrawHeight(drawHeight : Int) : Unit = {
        this.drawHeight = drawHeight
    }

}


