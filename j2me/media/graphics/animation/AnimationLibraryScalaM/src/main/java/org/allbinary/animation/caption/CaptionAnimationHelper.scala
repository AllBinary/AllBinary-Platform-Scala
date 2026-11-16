/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.caption

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.animation.text.TextAnimation
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory
import _root_.org.allbinary.time.TimeDelayHelper

class CaptionAnimationHelper(param_captionAnimation : Animation, param_captionDx : Int, param_captionDy : Int, param_dx : Int, param_dy : Int) extends CaptionAnimationHelperBase {

    private val timeHelper : TimeDelayHelper = new TimeDelayHelper(620)

    private val textAnimation : TextAnimation = new TextAnimation(StringUtil.getInstance().EMPTY_STRING, AnimationBehavior.getInstance())

    private var captionAnimation : Animation = null

    private var animation : Animation = NullAnimationFactory.getFactoryInstance().getInstance(0)

    //Constructor
    {
        val captionAnimation : Animation = param_captionAnimation
        val captionDx : Int = param_captionDx
        val captionDy : Int = param_captionDy
        val dx : Int = param_dx
        val dy : Int = param_dy
        this.captionAnimation = new CaptionAnimation(captionAnimation, this.textAnimation, captionDx, captionDy, dx, dy)
    }

    override def isShowing() : Boolean = {
        if (this.animation eq this.captionAnimation) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    override def tick() : Unit = {
        if (this.timeHelper.isTime(GameTickTimeDelayHelperFactory.getInstance().startTime)) {
            this.animation = NullAnimationFactory.getFactoryInstance().getInstance(0)
        }
    }

    override def update(message : String, basicColor : BasicColor) : Unit = {
        this.textAnimation.setBasicColorP(basicColor)
        this.textAnimation.setText(message)
        this.animation = this.captionAnimation
        this.timeHelper.setStartTimeTNT()
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.animation.paintXY(graphics, x, y)
    }

}


