/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.color.BasicColor

/**  *  * @author user  */
class AdjustedVectorAnimation(param_currentPoints : Array[Array[Array[Int]]], param_basicColor : BasicColor, param_dx : Int, param_dy : Int, param_animationBehavior : AnimationBehavior) extends VectorAnimation(param_currentPoints, param_basicColor, param_animationBehavior) {

    private var dx : Int = 0

    private var dy : Int = 0

    //Constructor
    {
        val currentPoints : Array[Array[Array[Int]]] = param_currentPoints
        val basicColor : BasicColor = param_basicColor
        val dx : Int = param_dx
        val dy : Int = param_dy
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.dx = dx
        this.dy = dy
    }

    // }
    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        super.paintXY(graphics, x + this.dx, y + this.dy)
    }

}


