/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.caption

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.Animation

/**  *   * @author user  */
class CaptionAnimation(param_animationInterface : Animation, param_overlayAnimationInterface : Animation, param_captionDx : Int, param_captionDy : Int, param_dx : Int, param_dy : Int) extends Animation {

    private var animationInterface : Animation = null

    private var overlayAnimationInterface : Animation = null

    private var captionDx : Int = 0

    private var captionDy : Int = 0

    private var dx : Int = 0

    private var dy : Int = 0

    //Constructor
    {
        val animationInterface : Animation = param_animationInterface
        val overlayAnimationInterface : Animation = param_overlayAnimationInterface
        val captionDx : Int = param_captionDx
        val captionDy : Int = param_captionDy
        val dx : Int = param_dx
        val dy : Int = param_dy
        this.animationInterface = animationInterface
        this.overlayAnimationInterface = overlayAnimationInterface
        this.captionDx = captionDx
        this.captionDy = captionDy
        this.dx = dx
        this.dy = dy
    }

    override def nextFrame() : Unit = {
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.animationInterface.paintXY(graphics, x + this.captionDx, y + this.captionDy)
        this.overlayAnimationInterface.paintXY(graphics, (x + this.captionDx) + this.dx, (y + this.captionDy) + this.dy)
    }

    override def paintThreedXYZ(graphics : Graphics, x : Int, y : Int, z : Int) : Unit = {
        this.animationInterface.paintThreedXYZ(graphics, x + this.captionDx, y + this.captionDy, z)
        this.overlayAnimationInterface.paintThreedXYZ(graphics, (x + this.captionDx) + this.dx, (y + this.captionDy) + this.dy, z)
    }

}


