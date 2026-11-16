/* * AllBinary Open License Version 1 * Copyright (c) 2009 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.input.motion.api1

import _root_.android.view.MotionEvent
import _root_.org.allbinary.android.input.motion.BaseGameInputMotionEventProcessor
import _root_.org.allbinary.input.motion.AllMotionRecognizer
import _root_.org.allbinary.input.motion.MotionRecognizer
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil

class GameInputMotionEventProcessorAPI1 private() extends BaseGameInputMotionEventProcessor {
    import _root_.org.allbinary.android.input.motion.api1.GameInputMotionEventProcessorAPI1.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val motionRecognizer : MotionRecognizer = new AllMotionRecognizer()

    override def process(motionEvent : MotionEvent) : Unit = {
        try {
            //API 1 is not scalable so no need to waste processing on it.
            var x : Int = motionEvent.getX().toInt
            var y : Int = motionEvent.getY().toInt
            var action : Int = motionEvent.getAction()
            if (action == MotionEvent.ACTION_DOWN) {
                this.motionRecognizer.processStartMotionEvent(x, y, motionEvent.getDeviceId(), 0)
            } else if ((action == MotionEvent.ACTION_UP) || (action == MotionEvent.ACTION_CANCEL)) {
                this.motionRecognizer.processEndMotionEvent(x, y, motionEvent.getDeviceId(), 0)
            } else if (action == MotionEvent.ACTION_MOVE) {
                this.motionRecognizer.processDraggedMotionEvent(x, y, motionEvent.getDeviceId(), 0)
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.PROCESS, e)
            }
        }
    }

}

object GameInputMotionEventProcessorAPI1 {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : GameInputMotionEventProcessorAPI1 = {
        //PROCESSOR.setMidlet(midlet);
        if (GameInputMotionEventProcessorAPI1.instance eq NullUtil.getInstance().NULL_OBJECT) {
            GameInputMotionEventProcessorAPI1.instance = new GameInputMotionEventProcessorAPI1()
        }
        return GameInputMotionEventProcessorAPI1.instance.asInstanceOf[GameInputMotionEventProcessorAPI1]
    }

}


