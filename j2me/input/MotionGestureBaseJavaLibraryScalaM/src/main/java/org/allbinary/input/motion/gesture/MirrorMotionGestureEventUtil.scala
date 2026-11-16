/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.gesture

import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.input.motion.gesture.observer.MotionEventCircularPool
import _root_.org.allbinary.input.motion.gesture.observer.MotionGestureEvent

class MirrorMotionGestureEventUtil private() {
    import _root_.org.allbinary.input.motion.gesture.MirrorMotionGestureEventUtil.{*}

    private var motionEventCircularPool : MotionEventCircularPool = null

    //Constructor
    {
        this.motionEventCircularPool = MotionEventCircularPool.createPool(Integer.MAX_VALUE)
    }

    def mirrorVerticle(motionGestureEvent : MotionGestureEvent, halfWidth : Int) : MotionGestureEvent = {
        val event : MotionGestureEvent = this.motionEventCircularPool.getInstance(motionGestureEvent.getMotionGesture())
        val previousNewX : Int = this.getNewX(motionGestureEvent.getPreviousPoint().getX(), halfWidth)
        val currentNewX : Int = this.getNewX(motionGestureEvent.getCurrentPoint().getX(), halfWidth)
        val pointFactory : PointFactory = PointFactory.getInstance()
        val mirroredPreviousPoint : GPoint = pointFactory.createXY(previousNewX, motionGestureEvent.getPreviousPoint().getY())
        val mirroredCurrentPoint : GPoint = pointFactory.createXY(currentNewX, motionGestureEvent.getCurrentPoint().getY())
        event.setPreviousPoint(mirroredPreviousPoint)
        event.setCurrentPoint(mirroredCurrentPoint)
        return event
    }

    def getNewX(x : Int, halfWidth : Int) : Int = {
        var newX : Int = 0
        if (x > halfWidth) {
            newX = halfWidth - (x - halfWidth)
        } else {
            newX = halfWidth + (halfWidth - x)
        }
        return newX
    }

}

object MirrorMotionGestureEventUtil {
    private val instance : MirrorMotionGestureEventUtil = new MirrorMotionGestureEventUtil()

    def getInstance() : MirrorMotionGestureEventUtil = {
        return MirrorMotionGestureEventUtil.instance
    }

}


