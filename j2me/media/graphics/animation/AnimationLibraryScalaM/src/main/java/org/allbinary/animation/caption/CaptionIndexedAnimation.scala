/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.caption

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.media.Player
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.AnimationEventHandler
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.logic.math.PrimitiveIntUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory
import _root_.org.allbinary.time.TimeDelayHelper

/**  *   * @author user  */
class CaptionIndexedAnimation(param_animationInterface : Animation, param_movieIndexedAnimationInterface : IndexedAnimation, param_player : Player, param_captionDx : Int, param_captionDy : Int, param_dx : Int, param_dy : Int, param_time : Int, param_animationBehavior : AnimationBehavior) extends IndexedAnimation(param_animationBehavior) {

    private var animationInterface : Animation = null

    // private PaintableInterface paintableInterface;
    private var movieIndexedAnimationInterface : IndexedAnimation = null

    private var captionDx : Int = 0

    private var captionDy : Int = 0

    private var dx : Int = 0

    private var dy : Int = 0

    private var time : Int = 0

    private var END_EVENT : AllBinaryEventObject = null

    private var timeDelayHelper : TimeDelayHelper = null

    private var player : Player = null

    //Constructor
    {
        val animationInterface : Animation = param_animationInterface
        val movieIndexedAnimationInterface : IndexedAnimation = param_movieIndexedAnimationInterface
        val player : Player = param_player
        val captionDx : Int = param_captionDx
        val captionDy : Int = param_captionDy
        val dx : Int = param_dx
        val dy : Int = param_dy
        val time : Int = param_time
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.animationInterface = animationInterface
        this.movieIndexedAnimationInterface = movieIndexedAnimationInterface
        this.captionDx = captionDx
        this.captionDy = captionDy
        this.dx = dx
        this.dy = dy
        this.time = time
        this.END_EVENT = new AllBinaryEventObject(this)
        var timePerFrame : Int = this.time / this.getSize()
        this.timeDelayHelper = new TimeDelayHelper(timePerFrame)
        this.player = player
        this.player.start()
    }

    override def nextFrame() : Unit = {
        if (this.timeDelayHelper.isTime(GameTickTimeDelayHelperFactory.getInstance().startTime)) {
            this.movieIndexedAnimationInterface.nextFrame()
        }
        if (this.isLastFrame()) {
            AnimationEventHandler.getInstance().fireEvent(this.END_EVENT)
        }
    }

    override def isLastFrame() : Boolean = {
        if (this.movieIndexedAnimationInterface.getFrame() == (this.getSize() - 1)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    override def previousFrame() : Unit = {
        this.movieIndexedAnimationInterface.previousFrame()
    }

    override def setFrame(index : Int) : Unit = {
        this.movieIndexedAnimationInterface.setFrame(index)
    }

    override def getFrame() : Int = {
        return this.movieIndexedAnimationInterface.getFrame()
    }

    override def getSize() : Int = {
        return this.movieIndexedAnimationInterface.getSize()
    }

    override def setSequence(sequence : Array[Int]) : Unit = {
    }

    override def getSequence() : Array[Int] = {
        return PrimitiveIntUtil.getArrayInstance()
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.animationInterface.paintXY(graphics, x + this.captionDx, y + this.captionDy)
        this.movieIndexedAnimationInterface.paintXY(graphics, (x + this.captionDx) + this.dx, (y + this.captionDy) + this.dy)
    }

    override def paintThreedXYZ(graphics : Graphics, x : Int, y : Int, z : Int) : Unit = {
        this.animationInterface.paintThreedXYZ(graphics, x + this.captionDx, y + this.captionDy, z)
        this.movieIndexedAnimationInterface.paintThreedXYZ(graphics, (x + this.captionDx) + this.dx, (y + this.captionDy) + this.dy, z)
    }

}


