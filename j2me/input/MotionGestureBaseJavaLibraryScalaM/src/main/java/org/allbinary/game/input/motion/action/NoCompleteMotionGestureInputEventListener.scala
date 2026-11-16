/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.motion.action

import _root_.org.allbinary.game.input.CompleteMotionGestureInputEvent
import _root_.org.allbinary.game.input.CompleteMotionGestureInputEventListener
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings

class NoCompleteMotionGestureInputEventListener private() extends CompleteMotionGestureInputEventListener {
    import _root_.org.allbinary.game.input.motion.action.NoCompleteMotionGestureInputEventListener.{*}

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def onCompleteMotionGestureInputEvent(completeMotionGestureInputEvent : CompleteMotionGestureInputEvent) : Unit = {
    }

}

object NoCompleteMotionGestureInputEventListener {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : NoCompleteMotionGestureInputEventListener = new NoCompleteMotionGestureInputEventListener()

    def getInstance() : NoCompleteMotionGestureInputEventListener = {
        return NoCompleteMotionGestureInputEventListener.instance
    }

}


