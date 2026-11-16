/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.color.BasicColorFactory

class ColorLessVectorAnimation(param_currentPoints : Array[Array[Array[Int]]], param_animationBehavior : AnimationBehavior) extends VectorAnimation(param_currentPoints, BasicColorFactory.getInstance().WHITE, param_animationBehavior) {

    //Constructor
    {
        val currentPoints : Array[Array[Array[Int]]] = param_currentPoints
        val animationBehavior : AnimationBehavior = param_animationBehavior
    }

    //    }
    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.paintVectors(graphics, x, y)
    }

}


