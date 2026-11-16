/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.gesture.observer

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler

class BasicMotionGesturesHandler() extends BasicEventHandler {
    import _root_.org.allbinary.input.motion.gesture.observer.BasicMotionGesturesHandler.{*}

    override def process(eventObject : AllBinaryEventObject, eventListenerInterface : EventListenerInterface) : Unit = {
        val baseMotionGestureEventListener : BaseMotionGestureEventListener = eventListenerInterface.asInstanceOf[BaseMotionGestureEventListener]
        baseMotionGestureEventListener.onMotionGestureEvent(eventObject.asInstanceOf[MotionGestureEvent])
    }

}

object BasicMotionGesturesHandler {
    private val SINGLETON : BasicMotionGesturesHandler = new BasicMotionGesturesHandler()

    def getInstance() : BasicMotionGesturesHandler = {
        return BasicMotionGesturesHandler.SINGLETON
    }

}


