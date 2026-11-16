/* * AllBinary Open License Version 1 * Copyright (c) 2009 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.input.motion

import _root_.android.view.MotionEvent
import _root_.org.allbinary.game.input.motion.action.SingleKeyPressGameKeyFromMotionGestureEventListener
import _root_.org.allbinary.input.motion.trackball.action.DownTrackballInputToGameKeyEventAction
import _root_.org.allbinary.input.motion.trackball.action.LeftTrackballInputToGameKeyEventAction
import _root_.org.allbinary.input.motion.trackball.action.RightTrackballInputToGameKeyEventAction
import _root_.org.allbinary.input.motion.trackball.action.UpTrackballInputToGameKeyEventAction
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class TrackballGameInputMotionEventProcessor private() extends MotionEventProcessor {
    import _root_.org.allbinary.android.input.motion.TrackballGameInputMotionEventProcessor.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val listener : SingleKeyPressGameKeyFromMotionGestureEventListener = new SingleKeyPressGameKeyFromMotionGestureEventListener()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    override def process(motionEvent : MotionEvent) : Unit = {
        try {
            //    + " y: " + motionEvent.getY(), this, this.commonStrings.PROCESS);
            var x : Float = motionEvent.getX()
            var y : Float = motionEvent.getY()
            // motionEvent.getAction();
            if (x < 0) {
                this.listener.onCompleteMotionGestureInputEvent(LeftTrackballInputToGameKeyEventAction.getInstance())
            } else if (x > 0) {
                this.listener.onCompleteMotionGestureInputEvent(RightTrackballInputToGameKeyEventAction.getInstance())
            }
            if (y < 0) {
                this.listener.onCompleteMotionGestureInputEvent(UpTrackballInputToGameKeyEventAction.getInstance())
            } else if (y > 0) {
                this.listener.onCompleteMotionGestureInputEvent(DownTrackballInputToGameKeyEventAction.getInstance())
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.PROCESS, e)
            }
        }
    }

}

object TrackballGameInputMotionEventProcessor {
    private var PROCESSOR : TrackballGameInputMotionEventProcessor = new TrackballGameInputMotionEventProcessor()

    def getInstance() : TrackballGameInputMotionEventProcessor = {
        //PROCESSOR.setMidlet(midlet);
        return TrackballGameInputMotionEventProcessor.PROCESSOR
    }

}


