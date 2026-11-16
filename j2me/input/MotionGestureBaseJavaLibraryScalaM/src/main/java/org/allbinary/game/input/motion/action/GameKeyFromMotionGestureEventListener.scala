/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.motion.action

import _root_.org.allbinary.game.input.CompleteMotionGestureInputEvent
import _root_.org.allbinary.game.input.CompleteMotionGestureInputEventListener
import _root_.org.allbinary.game.input.event.DownGameKeyEventHandler
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.game.input.event.UpGameKeyEventHandler
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.string.CommonStrings

class GameKeyFromMotionGestureEventListener extends CompleteMotionGestureInputEventListener {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var previousGameKeyEvent : GameKeyEvent = GameKeyEvent.NONE

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    //ReleaseTouchInputToGameKeyEventAction.getInstance().getGameKeyEvent();
    override def onCompleteMotionGestureInputEvent(completeMotionGestureInputEvent : CompleteMotionGestureInputEvent) : Unit = {
        try {
            var gameKeyCompleteMotionGestureInputEvent : GameKeyCompleteMotionGestureInputEvent = completeMotionGestureInputEvent.asInstanceOf[GameKeyCompleteMotionGestureInputEvent]
            //PreLogUtil.put(commonStrings.START_LABEL + gameKeyCompleteMotionGestureInputEvent.getGameKey(), this, "onCompleteMotionGestureInputEvent");
            var gameKeyEvent : GameKeyEvent = gameKeyCompleteMotionGestureInputEvent.getGameKeyEvent()
            if (gameKeyEvent ne this.previousGameKeyEvent) {
                if (this.previousGameKeyEvent ne GameKeyEvent.NONE) {
                    //this.logUtil.putF("Up: " + previousGameKeyEvent.toString(), this, "onCompleteMotionGestureInputEvent");
                    UpGameKeyEventHandler.getInstance().fireEvent(this.previousGameKeyEvent)
                }
                /*                 else                 {                     this.logUtil.putF("No Key", this, "onCompleteMotionGestureInputEvent");                 }                 */
                this.previousGameKeyEvent = gameKeyEvent
                //if(gameKeyEvent != releaseGameKeyEvent)
                if ((gameKeyEvent != null) && (gameKeyEvent ne GameKeyEvent.NONE)) {
                    //this.logUtil.putF("Down: " + gameKeyCompleteMotionGestureInputEvent.getGameKey(), this, "onCompleteMotionGestureInputEvent");
                    DownGameKeyEventHandler.getInstance().fireEvent(gameKeyEvent)
                }
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, "onCompleteMotionGestureInputEvent", e)
            }
        }
    }

}


