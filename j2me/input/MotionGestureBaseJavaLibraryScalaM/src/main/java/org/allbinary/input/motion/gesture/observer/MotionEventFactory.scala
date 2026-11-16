/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.gesture.observer

import _root_.org.allbinary.game.input.Input
import _root_.org.allbinary.game.input.InputFactory
import _root_.org.allbinary.input.motion.gesture.MotionGestureInput
import _root_.org.allbinary.input.motion.gesture.TouchMotionGestureFactory
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.AllBinaryEventObjectFactoryInterface

class MotionEventFactory(param_source : Object, param_id : Int) extends AllBinaryEventObjectFactoryInterface {
    import _root_.org.allbinary.input.motion.gesture.observer.MotionEventFactory.{*}

    private var source : Object = null

    private var id : Int = 0

    //Constructor
    {
        val source : Object = param_source
        val id : Int = param_id
        this.source = source
        this.id = id
        MotionEventFactory.index = TouchMotionGestureFactory.getInstance().LAST_MOTION.getId()
    }

    override def getInstance() : AllBinaryEventObject = {
        val inputFactory : InputFactory = InputFactory.getInstance()
        val input : Input = inputFactory.getInstanceById({ val value_N67166 = MotionEventFactory.index; MotionEventFactory.index += 1; value_N67166 })
        //this.logUtil.putF("Input: " + input, this, this.commonStrings.GET_INSTANCE);
        if (input eq inputFactory.NO_INPUT) {
            return new MotionGestureEvent(this.source, this.id, TouchMotionGestureFactory.getInstance().NO_MOTION.asInstanceOf[MotionGestureInput])
        } else {
            return new MotionGestureEvent(this.source, this.id, input.asInstanceOf[MotionGestureInput])
        }
        throw new IllegalStateException()
    }

}

object MotionEventFactory {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var index : Int = 0

}


