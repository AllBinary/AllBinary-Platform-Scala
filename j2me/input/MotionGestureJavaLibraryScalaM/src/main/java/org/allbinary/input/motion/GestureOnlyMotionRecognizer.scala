/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion

import _root_.org.allbinary.graphics.CustomGPoint
import _root_.org.allbinary.graphics.GPointCircularPool
import _root_.org.allbinary.input.motion.gesture.MotionGestureRecognizer

/**  *   * @author user  */
class GestureOnlyMotionRecognizer() extends MotionRecognizer {
    import _root_.org.allbinary.input.motion.GestureOnlyMotionRecognizer.{*}

    private var motionGestureRecognizer : MotionGestureRecognizer = null

    private var id : Int = 0

    //Constructor
    {
        this.id = { val value_N66906 = GestureOnlyMotionRecognizer.index; GestureOnlyMotionRecognizer.index += 1; value_N66906 }
        this.motionGestureRecognizer = new MotionGestureRecognizer(this.id)
    }

    override def processStartMotionEvent(x : Int, y : Int, deviceId : Int, modifiers : Int) : Unit = {
        var point : CustomGPoint = GestureOnlyMotionRecognizer.pointCircularPool.getNextInstance().asInstanceOf[CustomGPoint]
        point.setX(x)
        point.setY(y)
        this.motionGestureRecognizer.processPressedMotionEvent(point, deviceId, modifiers)
    }

    override def processEndMotionEvent(x : Int, y : Int, deviceId : Int, modifiers : Int) : Unit = {
        var point : CustomGPoint = GestureOnlyMotionRecognizer.pointCircularPool.getNextInstance().asInstanceOf[CustomGPoint]
        point.setX(x)
        point.setY(y)
        this.motionGestureRecognizer.processReleasedMotionEvent(point, deviceId, modifiers)
    }

    override def processDraggedMotionEvent(x : Int, y : Int, deviceId : Int, modifiers : Int) : Unit = {
        var point : CustomGPoint = GestureOnlyMotionRecognizer.pointCircularPool.getNextInstance().asInstanceOf[CustomGPoint]
        point.setX(x)
        point.setY(y)
        this.motionGestureRecognizer.processDraggedMotionEvent(point, deviceId, modifiers)
    }

}

object GestureOnlyMotionRecognizer {
    private var index : Int = 0

    private val pointCircularPool : GPointCircularPool = new GPointCircularPool(40)

}


