/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.text

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.AnimationBehavior

/**  *  * @author User  */
class AdjustCustomTextAnimation(param_text : String, param_fontSize : Int, param_dx : Int, param_dy : Int, param_animationBehavior : AnimationBehavior) extends CustomTextAnimation(param_text, param_fontSize, param_animationBehavior) {

    private var dx : Int = 0

    private var dy : Int = 0

    //Constructor
    {
        val text : String = param_text
        val fontSize : Int = param_fontSize
        val dx : Int = param_dx
        val dy : Int = param_dy
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.dx = dx
        this.dy = dy
    }

    override def getDx() : Int = {
        return this.dx
    }

    override def setDx(dx : Int) : Unit = {
        this.dx = dx
    }

    override def getDy() : Int = {
        return this.dy
    }

    override def setDy(dy : Int) : Unit = {
        this.dy = dy
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        super.paintXY(graphics, x + this.dx, y + this.dy)
    }

}


