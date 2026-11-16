/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.AnimationBehavior

class AdjustedLeftToRightImageAnimation(param_image : Image, param_sequenceArray : Array[Int], param_dx : Int, param_dy : Int, param_animationBehavior : AnimationBehavior) extends LeftToRightImageAnimation(param_image, param_sequenceArray, param_animationBehavior) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var dx : Int = 0

    private var dy : Int = 0

    //Constructor
    {
        val image : Image = param_image
        val sequenceArray : Array[Int] = param_sequenceArray
        val dx : Int = param_dx
        val dy : Int = param_dy
        val animationBehavior : AnimationBehavior = param_animationBehavior
        // this.logUtil.putF(, this, );
        this.init(dx, dy)
    }

    def init(dx : Int, dy : Int) : Unit = {
        this.dx = dx
        this.dy = dy
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        super.paintXY(graphics, x + this.dx, y + this.dy)
    }

}


