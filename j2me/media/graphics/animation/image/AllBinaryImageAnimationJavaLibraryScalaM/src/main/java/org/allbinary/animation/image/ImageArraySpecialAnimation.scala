/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.special.SpecialAnimationInterface
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory
import _root_.org.allbinary.time.TimeDelayHelper

class ImageArraySpecialAnimation(param_imageArray : Array[Image], param_animationBehavior : AnimationBehavior) extends ImageArrayAnimation(param_imageArray, param_animationBehavior) with SpecialAnimationInterface {

    private val timeDelayHelper : TimeDelayHelper = new TimeDelayHelper(270)

    private var loopCount : Int = 0

    private val loopCountTotal : Int = 1

    //Constructor
    {
        val imageArray : Array[Image] = param_imageArray
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.reset()
    }

    def getLoopCount() : Int = {
        return this.loopCount
    }

    override def setLastFrame() : Unit = {
        this.circularIndexUtil.setIndex(this.circularIndexUtil.getSize() - 1)
    }

    override def reset() : Unit = {
        this.setFrame(this.getSize() - 1)
        this.loopCount = 0
    }

    override def nextFrame() : Unit = {
        if (this.getFrame() > 0) {
            // If Frame is up long enough
            if (this.timeDelayHelper.isTime(GameTickTimeDelayHelperFactory.getInstance().startTime)) {
                this.previousFrame()
                if (this.getFrame() == 0) {
                    this.loopCount += 1
                }
            }
        }
    }

    override def isComplete() : Boolean = {
        if ((this.loopCount < this.loopCountTotal) || (this.getFrame() != 0)) {
            return false
        } else {
            return true
        }
        throw new IllegalStateException()
    }

    override def paintXY(graphics : Graphics, param_x : Int, param_y : Int) : Unit = {
        var x : Int = param_x
        var y : Int = param_y
        x = DisplayInfoSingleton.getInstance().getLastHalfWidth() - (this.getImage(this.circularIndexUtil.getIndex()).getWidth() >> 1)
        y = 5
        super.paintXY(graphics, x, y)
    }

}


