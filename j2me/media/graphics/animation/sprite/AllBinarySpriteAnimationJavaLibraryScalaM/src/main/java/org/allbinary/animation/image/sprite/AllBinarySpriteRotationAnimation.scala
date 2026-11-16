/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image.sprite

import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.game.Sprite
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.direction.Direction
import _root_.org.allbinary.math.Angle
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.math.AngleInfo

class AllBinarySpriteRotationAnimation(param_sprite : Sprite, param_image : Image, param_animationBehavior : AnimationBehavior) extends HackRotationSpriteIndexedAnimation(param_sprite, param_image, AngleInfo.getInstance((AngleFactory.getInstance().TOTAL_ANGLE / param_sprite.getRawFrameCount()).toShort), param_animationBehavior) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    //Constructor
    {
        val sprite : Sprite = param_sprite
        val image : Image = param_image
        val animationBehavior : AnimationBehavior = param_animationBehavior
        //this.logUtil.putF(new StringMaker().append("sprite.getRawFrameCount(): ").append(sprite.getRawFrameCount()).toString(), this, this.commonStrings.CONSTRUCTOR);
        this.angleInfo.adjustAngle(this.sprite.getFrame())
    }

    /*     public AllBinarySpriteRotationAnimation(MESprite sprite, int x, int y, final AnimationBehavior animationBehavior)     {     super(sprite, x, y);      int angleIncrement = Angle.THREE_SIXTY/this.getSprite().getRawFrameCount();      this.setAngleInfo(AngleInfo.getInstance(angleIncrement));     this.angleInfo.adjustAngle(this.getSprite().getFrame());     }      */
    override def nextRotation() : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, "nextFrame");
        this.sprite.nextFrame()
        this.angleInfo.adjustAngle(this.sprite.getFrame())
    }

    override def previousRotation() : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, "previousFrame");
        this.sprite.prevFrame()
        this.angleInfo.adjustAngle(this.sprite.getFrame())
    }

    override def setFrameByDirection(direction : Direction) : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, "setFrame");
        var angle : Angle = this.directionUtil.getFrameAngle(direction)
        this.adjustFrameToAngle(angle)
    }

    override def setFrameToAngle(angle : Angle) : Unit = {
        this.adjustFrameToAngle(angle)
    }

    override def setFrame(index : Int) : Unit = {
        this.sprite.setFrame(index)
        this.angleInfo.adjustAngle(this.getFrame())
    }

    override def adjustFrameToAngle(angle : Angle) : Unit = {
        this.adjustFrame(angle.getValue())
    }

    override def adjustFrame(angle : Short) : Unit = {
        this.setFrame(this.frameUtil.getFrameForAngle(angle, this.angleInfo.getAngleIncrementInfo().getAngleIncrement().toInt))
    }

}


