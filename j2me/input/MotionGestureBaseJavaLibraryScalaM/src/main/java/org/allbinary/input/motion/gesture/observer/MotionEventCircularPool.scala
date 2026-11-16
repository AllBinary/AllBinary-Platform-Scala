/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.gesture.observer

import _root_.org.allbinary.game.input.InputFactory
import _root_.org.allbinary.input.motion.gesture.MotionGestureInput
import _root_.org.allbinary.input.motion.gesture.TouchMotionGestureFactory
import _root_.org.allbinary.logic.util.event.AllBinaryEventCircularPool

class MotionEventCircularPool private(param_id : Int) {
    import _root_.org.allbinary.input.motion.gesture.observer.MotionEventCircularPool.{*}

    private val MIN : Int = TouchMotionGestureFactory.getInstance().LAST_MOTION.getId()

    private var eventPool : AllBinaryEventCircularPool = new AllBinaryEventCircularPool((InputFactory.getInstance().MAX - 1) - this.MIN)

    //Constructor
    {
        val id : Int = param_id
        this.eventPool.initAllBinaryEventCircularPool(new MotionEventFactory(this.eventPool, id))
    }

    def getInstance(motionGestureInput : MotionGestureInput) : MotionGestureEvent = this.synchronized {
        return this.eventPool.getInstance(motionGestureInput.getId() - this.MIN).asInstanceOf[MotionGestureEvent]
    }

}

object MotionEventCircularPool {
    def createPool(id : Int) : MotionEventCircularPool = {
        return new MotionEventCircularPool(id)
    }

}


