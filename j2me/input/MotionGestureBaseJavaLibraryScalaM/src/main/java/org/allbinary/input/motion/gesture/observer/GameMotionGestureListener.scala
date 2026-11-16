/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.gesture.observer

import _root_.org.allbinary.input.motion.gesture.MotionGestureInput
import _root_.org.allbinary.input.motion.gesture.TouchMotionGestureFactory
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class GameMotionGestureListener(param_signed : CompleteMotionGestureListenerInterface) extends MotionGestureEventListener {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var motionGestureCollection : BasicArrayList = new BasicArrayListD()

    private var touchGestureCollection : BasicArrayList = new BasicArrayListD()

    //private BasicArrayList scrolledGestureCollection = new BasicArrayListD();
    private var signed : CompleteMotionGestureListenerInterface = null

    //Constructor
    {
        val signed : CompleteMotionGestureListenerInterface = param_signed
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        this.signed = signed
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(this.commonStrings.NOT_IMPLEMENTED, this)
    }

    override def onUpMotionGestureEvent(ev : MotionGestureEvent) : Unit = {
        this.onMotionGestureEvent(ev)
    }

    override def onDownMotionGestureEvent(ev : MotionGestureEvent) : Unit = {
        this.onMotionGestureEvent(ev)
    }

    override def onLeftMotionGestureEvent(ev : MotionGestureEvent) : Unit = {
        this.onMotionGestureEvent(ev)
    }

    override def onRightMotionGestureEvent(ev : MotionGestureEvent) : Unit = {
        this.onMotionGestureEvent(ev)
    }

    override def onDiagonalDownRightMotionGestureEvent(ev : MotionGestureEvent) : Unit = {
        this.onMotionGestureEvent(ev)
    }

    override def onDiagonalDownLeftMotionGestureEvent(ev : MotionGestureEvent) : Unit = {
        this.onMotionGestureEvent(ev)
    }

    override def onDiagonalUpRightMotionGestureEvent(ev : MotionGestureEvent) : Unit = {
        this.onMotionGestureEvent(ev)
    }

    override def onDiagonalUpLeftMotionGestureEvent(ev : MotionGestureEvent) : Unit = {
        this.onMotionGestureEvent(ev)
    }

    override def onPressedMotionGestureEvent(ev : MotionGestureEvent) : Unit = {
        this.touchGestureCollection.add(ev.getMotionGesture())
    }

    override def released(ev : MotionGestureEvent) : Unit = {
        try {
            //{
            this.touchGestureCollection.add(ev.getMotionGesture())
            this.signed.onMotionGestureCompleted(this.touchGestureCollection)
            this.touchGestureCollection.clear()
        } catch {
            case e : Exception => {
                val stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append(this.commonStrings.EXCEPTION_LABEL)
                stringBuffer.append(StringUtil.getInstance().toString(ev.getMotionGesture()))
                this.logUtil.put(stringBuffer.toString(), this, "release", e)
            }
        }
    }

    override def onScrolledMotionGestureEvent(motionGestureEvent : MotionGestureEvent) : Unit = {
    }

    override def onMotionGestureEvent(ev : MotionGestureEvent) : Unit = {
        try {
            var motionGestureInput : MotionGestureInput = ev.getMotionGesture()
            if (motionGestureInput eq TouchMotionGestureFactory.getInstance().PRESSED) {
                this.onPressedMotionGestureEvent(ev)
            } else if (motionGestureInput eq TouchMotionGestureFactory.getInstance().RELEASED) {
                this.released(ev)
            } else {
                this.motionGestureCollection.add(motionGestureInput)
                this.signed.onMotionGestureCompleted(this.motionGestureCollection)
                this.motionGestureCollection.clear()
                this.touchGestureCollection.clear()
            }
        } catch {
            case e : Exception => {
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append(this.commonStrings.EXCEPTION_LABEL)
                stringBuffer.append(StringUtil.getInstance().toString(ev.getMotionGesture()))
                this.logUtil.put(stringBuffer.toString(), this, "onMotionGestureEvent", e)
            }
        }
    }

}


