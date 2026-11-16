/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input

import _root_.org.allbinary.input.motion.AllMotionRecognizer
import _root_.org.allbinary.input.motion.gesture.observer.BasicMotionGesturesHandler
import _root_.org.allbinary.input.motion.gesture.observer.GameMotionGestureListener
import _root_.org.allbinary.input.motion.gesture.observer.MotionGestureReceiveInterfaceFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

//TouchJ2ME
class TouchJ2ME() {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val DEVICE_ID : Int = 0

    private var motionRecognizer : AllMotionRecognizer = new AllMotionRecognizer()

    //Constructor
    {
        var motionGesturesHandler : BasicMotionGesturesHandler = this.motionRecognizer.getMotionGestureRecognizer().getMotionGesturesHandler()
        motionGesturesHandler.addListenerInterface(new GameMotionGestureListener(MotionGestureReceiveInterfaceFactory.getInstance()))
    }

    def pointerDragged(x : Int, y : Int) : Unit = {
        try {
            this.motionRecognizer.processDraggedMotionEvent(x, y, DEVICE_ID, 0)
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, "pointerDragged", e)
            }
        }
    }

    def pointerPressed(x : Int, y : Int) : Unit = {
        try {
            this.motionRecognizer.processStartMotionEvent(x, y, DEVICE_ID, 0)
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, "pointerPressed", e)
            }
        }
    }

    def pointerReleased(x : Int, y : Int) : Unit = {
        try {
            this.motionRecognizer.processEndMotionEvent(x, y, DEVICE_ID, 0)
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, "pointerReleased", e)
            }
        }
    }

}


