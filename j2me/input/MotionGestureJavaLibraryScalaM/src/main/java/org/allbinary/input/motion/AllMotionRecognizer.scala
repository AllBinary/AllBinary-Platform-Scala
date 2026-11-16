/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion

import _root_.org.allbinary.graphics.CustomGPoint
import _root_.org.allbinary.graphics.GPointCircularPool
import _root_.org.allbinary.input.motion.button.TouchButtonRecognizer
import _root_.org.allbinary.input.motion.gesture.MotionGestureRecognizer
import _root_.org.allbinary.logic.communication.log.LogUtil

/**  *   * @author user  */
class AllMotionRecognizer() extends MotionRecognizer {
    import _root_.org.allbinary.input.motion.AllMotionRecognizer.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var motionGestureRecognizer : MotionGestureRecognizer = null

    private var touchButtonProcessing : Boolean = false

    private var touchButtonRecognizer : TouchButtonRecognizer = null

    private var id : Int = 0

    private var lastX : Int = 0

    private var lastY : Int = 0

    //Constructor
    {
        this.id = { val value_N68271 = AllMotionRecognizer.index; AllMotionRecognizer.index += 1; value_N68271 }
        this.motionGestureRecognizer = new MotionGestureRecognizer(this.id)
        this.touchButtonRecognizer = new TouchButtonRecognizer()
    }

    override def processStartMotionEvent(x : Int, y : Int, deviceId : Int, modifiers : Int) : Unit = {
        // !touchButtonProcessing &&
        if (this.touchButtonRecognizer.pressTouchButtonInput(x, y, deviceId)) {
            this.touchButtonProcessing = true
        }
        // Only if touch buttons are not in processing can a gesture start
        if (!this.touchButtonProcessing) {
            val point : CustomGPoint = AllMotionRecognizer.pointCircularPool.getNextInstance().asInstanceOf[CustomGPoint]
            point.setX(x)
            point.setY(y)
            //                            .append("point: ").append(point.toString()).toString(), //                    this, "processStartMotionEvent");
            this.motionGestureRecognizer.processPressedMotionEvent(point, deviceId, modifiers)
        }
    }

    override def processEndMotionEvent(x : Int, y : Int, deviceId : Int, modifiers : Int) : Unit = {
        if (this.touchButtonRecognizer.releaseTouchButtonInput(x, y, deviceId)) {
        }
        if (!this.touchButtonProcessing) {
            val point : CustomGPoint = AllMotionRecognizer.pointCircularPool.getNextInstance().asInstanceOf[CustomGPoint]
            point.setX(x)
            point.setY(y)
            //                            .append("point: ").append(point.toString()).toString(), //                    this, "processEndMotionEvent");
            this.motionGestureRecognizer.processReleasedMotionEvent(point, deviceId, modifiers)
        }
        if (this.touchButtonProcessing) {
            this.touchButtonProcessing = false
        }
    }

    override def processDraggedMotionEvent(x : Int, y : Int, deviceId : Int, modifiers : Int) : Unit = {
        // if a button press was already processing
        if (this.touchButtonProcessing) {
            this.touchButtonRecognizer.pressTouchButtonInput(x, y, deviceId)
        }
        if (!this.touchButtonProcessing) {
            val point : CustomGPoint = AllMotionRecognizer.pointCircularPool.getNextInstance().asInstanceOf[CustomGPoint]
            point.setX(x)
            point.setY(y)
            this.motionGestureRecognizer.processDraggedMotionEvent(point, deviceId, modifiers)
        }
    }

    def processMovedMotionEvent(x : Int, y : Int, deviceId : Int, modifiers : Int) : Unit = {
        if ((x != this.lastX) || (y != this.lastY)) {
            this.lastX = x
            this.lastY = y
            val point : CustomGPoint = AllMotionRecognizer.pointCircularPool.getNextInstance().asInstanceOf[CustomGPoint]
            point.setX(x)
            point.setY(y)
            this.motionGestureRecognizer.processMovedMotionEvent(point, deviceId, modifiers)
        }
    }

    def processScrolledMotionEvent(x : Int, y : Int, deviceId : Int, modifiers : Int) : Unit = {
        //this.lastY = y;
        val point : CustomGPoint = AllMotionRecognizer.pointCircularPool.getNextInstance().asInstanceOf[CustomGPoint]
        point.setX(x)
        point.setY(y)
        this.motionGestureRecognizer.processScrolledMotionEvent(point, deviceId, modifiers)
    }

    final def getMotionGestureRecognizer() : MotionGestureRecognizer = {
        return this.motionGestureRecognizer
    }

}

object AllMotionRecognizer {
    private var index : Int = 0

    private val pointCircularPool : GPointCircularPool = new GPointCircularPool(40)

}


