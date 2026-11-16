/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.input.motion.gesture.MotionGestureInput
import _root_.org.allbinary.input.motion.gesture.TouchMotionGestureFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.string.CommonStrings

class CompleteMotionGestureInputEvent(param_name : String, param_motionGestureInput : MotionGestureInput) extends AllBinaryEventObject(param_motionGestureInput) with CompleteMotionGestureInputInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var name : String = StringUtil.getInstance().EMPTY_STRING

    private var motionGestureInput : MotionGestureInput = TouchMotionGestureFactory.getInstance().NO_MOTION

    //Constructor
    {
        val name : String = param_name
        val motionGestureInput : MotionGestureInput = param_motionGestureInput
        this.setName(name)
        try {
            this.setMotionGestureInput(motionGestureInput)
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, "InputToGameKeyEventAction", e)
            }
        }
    }

    def setName(name : String) : Unit = {
        this.name = name
    }

    override def getName() : String = {
        return this.name
    }

    def setMotionGestureInput(motionGestureInput : MotionGestureInput) : Unit = {
        this.motionGestureInput = motionGestureInput
    }

    def getMotionGestureInput() : MotionGestureInput = {
        return this.motionGestureInput
    }

}


