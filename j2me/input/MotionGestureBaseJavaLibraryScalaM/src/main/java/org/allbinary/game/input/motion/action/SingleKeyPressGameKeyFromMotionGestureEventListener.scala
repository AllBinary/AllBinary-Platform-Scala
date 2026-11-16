/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.motion.action

import _root_.org.allbinary.game.input.CompleteMotionGestureInputEvent
import _root_.org.allbinary.game.input.CompleteMotionGestureInputEventListener
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.game.input.event.PressGameKeyEventHandler
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.string.CommonStrings

class SingleKeyPressGameKeyFromMotionGestureEventListener extends CompleteMotionGestureInputEventListener {

    val logUtil : LogUtil = LogUtil.getInstance()

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def onCompleteMotionGestureInputEvent(completeMotionGestureInputEvent : CompleteMotionGestureInputEvent) : Unit = {
        try {
            //this.logUtil.putF("Start GameKey: " + ((GameKeyCompleteMotionGestureInputEvent) completeMotionGestureInputEvent).getGameKey(), this, "onCompleteMotionGestureInputEvent");
            val gameKeyCompleteMotionGestureInputEvent : GameKeyCompleteMotionGestureInputEvent = completeMotionGestureInputEvent.asInstanceOf[GameKeyCompleteMotionGestureInputEvent]
            val gameKeyEvent : GameKeyEvent = gameKeyCompleteMotionGestureInputEvent.getGameKeyEvent()
            //this.logUtil.putF("gameKeyEvent: " + gameKeyEvent, this, "onCompleteMotionGestureInputEvent");
            PressGameKeyEventHandler.getInstance().fireEvent(gameKeyEvent)
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, "onCompleteMotionGestureInputEvent", e)
            }
        }
    }

}


