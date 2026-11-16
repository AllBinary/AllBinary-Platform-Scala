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

/**  * This MotionGestureEventListener creates a list of gestures from press   * to release and then sends the list as a complete gesture.  *    * @author user  *  */
class ReleaseControlledMotionGestureListener(param_signed : CompleteMotionGestureListenerInterface) extends MotionGestureEventListener {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var currentMotionGesture : MotionGestureInput = TouchMotionGestureFactory.getInstance().NO_MOTION

    private var isMouseGestureOccurring : Boolean = false

    private var motionGestureCollection : BasicArrayList = new BasicArrayListD()

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
        this.isMouseGestureOccurring = true
        this.currentMotionGesture = TouchMotionGestureFactory.getInstance().NO_MOTION
        this.onMotionGestureEvent(ev)
    }

    override def onScrolledMotionGestureEvent(motionGestureEvent : MotionGestureEvent) : Unit = {
    }

    override def released(ev : MotionGestureEvent) : Unit = {
        try {
            if (this.isMouseGestureOccurring == false) {
                return
            }
            this.isMouseGestureOccurring = false
            //this.logUtil.putF(this.commonStrings.START_LABEL).append(ev.getMotionGesture(), this, "release");
            this.signed.onMotionGestureCompleted(this.motionGestureCollection)
            //TWB - Although this could be dangerous
            this.motionGestureCollection.clear()
        } catch {
            case e : Exception => {
                this.logUtil.put(new StringMaker().append(this.commonStrings.EXCEPTION_LABEL).append(StringUtil.getInstance().toString(ev.getMotionGesture())).toString(), this, "release", e)
            }
        }
    }

    override def onMotionGestureEvent(ev : MotionGestureEvent) : Unit = {
        //currentMotionGesture == TouchMotionGestureFactory.getInstance().NO_MOTION &&
        if (this.isMouseGestureOccurring == false) {
            return
        }
        var motionGestureInput : MotionGestureInput = ev.getMotionGesture()
        if (motionGestureInput eq TouchMotionGestureFactory.getInstance().PRESSED) {
            this.onPressedMotionGestureEvent(ev)
        } else if (motionGestureInput eq TouchMotionGestureFactory.getInstance().RELEASED) {
            this.released(ev)
        } else {
            if (this.currentMotionGesture ne motionGestureInput) {
                this.currentMotionGesture = motionGestureInput
                this.motionGestureCollection.add(ev.getMotionGesture())
            }
        }
    }

}


