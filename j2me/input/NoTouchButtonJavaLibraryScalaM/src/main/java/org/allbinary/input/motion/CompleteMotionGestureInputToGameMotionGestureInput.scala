/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion

import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.string.CommonStrings

class CompleteMotionGestureInputToGameMotionGestureInput {
    import _root_.org.allbinary.input.motion.CompleteMotionGestureInputToGameMotionGestureInput.{*}

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    def init() : Unit = {
        PreLogUtil.put("No Touch Button = No Compound Motion Gestures", this, this.commonStrings.INIT)
    }

}

object CompleteMotionGestureInputToGameMotionGestureInput {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : CompleteMotionGestureInputToGameMotionGestureInput = new CompleteMotionGestureInputToGameMotionGestureInput()

    def getInstance() : CompleteMotionGestureInputToGameMotionGestureInput = {
        return CompleteMotionGestureInputToGameMotionGestureInput.instance
    }

}


