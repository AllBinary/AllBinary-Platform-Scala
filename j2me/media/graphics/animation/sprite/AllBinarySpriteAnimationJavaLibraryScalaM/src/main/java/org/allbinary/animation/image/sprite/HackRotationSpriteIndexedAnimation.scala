/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image.sprite

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.game.Sprite
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.RotationAnimation
import _root_.org.allbinary.logic.math.PrimitiveIntUtil
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.util.CircularIndexUtil

class HackRotationSpriteIndexedAnimation(param_sprite : Sprite, param_image : Image, param_angleInfo : AngleInfo, param_animationBehavior : AnimationBehavior) extends RotationAnimation(param_angleInfo, CircularIndexUtil.createInstance(360 / param_angleInfo.getAngleIncrementInfo().getAngleIncrement()), param_animationBehavior) {

    var sprite : Sprite = null

    private var image : Image = null

    //Constructor
    {
        val sprite : Sprite = param_sprite
        val image : Image = param_image
        val angleInfo : AngleInfo = param_angleInfo
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.sprite = sprite
        this.image = image
    }

    /*      * public SpriteIndexedAnimation(MESprite sprite, int dx, int dy) {      * this.setSprite(sprite);      *       * this.setDx(dx); this.setDy(dy); }      */
    override def getAnimationSize() : Int = {
        return this.getSize()
    }

    def paintFrame(g : Graphics, frame : Int, x : Int, y : Int) : Unit = {
        this.setFrame(frame)
        this.paintXY(g, x, y)
    }

    override def paintXY(g : Graphics, x : Int, y : Int) : Unit = {
        this.sprite.setPosition(x, y)
        this.paint(g)
    }

    def paint(g : Graphics) : Unit = {
        this.sprite.paint(g)
    }

    override def nextRotation() : Unit = {
        this.sprite.nextFrame()
    }

    override def previousRotation() : Unit = {
        this.sprite.prevFrame()
    }

    override def getSize() : Int = {
        // .getFrameSequenceLength()
        return this.sprite.getRawFrameCount()
    }

    override def setFrame(frame : Int) : Unit = {
        this.sprite.setFrame(frame)
    }

    override def getFrame() : Int = {
        return this.sprite.getFrame()
    }

    override def setSequence(sequence : Array[Int]) : Unit = {
    }

    override def getSequence() : Array[Int] = {
        return PrimitiveIntUtil.getArrayInstance()
    }

}


