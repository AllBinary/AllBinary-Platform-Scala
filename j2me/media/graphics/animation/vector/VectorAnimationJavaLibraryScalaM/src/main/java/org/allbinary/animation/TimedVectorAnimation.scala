/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory
import _root_.org.allbinary.time.TimeDelayHelper

/**  *  * @author user  */
class TimedVectorAnimation(param_currentPoints : Array[Array[Array[Int]]], param_basicColor : BasicColor, param_animationBehavior : AnimationBehavior) extends VectorAnimation(param_currentPoints, param_basicColor, param_animationBehavior) {

    private var timeElapsedHelper : TimeDelayHelper = new TimeDelayHelper(200)

    //Constructor
    {
        val currentPoints : Array[Array[Array[Int]]] = param_currentPoints
        val basicColor : BasicColor = param_basicColor
        val animationBehavior : AnimationBehavior = param_animationBehavior
    }

    //    }
    override def nextFrame() : Unit = {
        if (this.timeElapsedHelper.isTime(GameTickTimeDelayHelperFactory.getInstance().startTime)) {
            super.nextFrame()
        }
    }

}


