/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.gesture.observer

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList

class NullCompleteMotionGestureReceiver() extends CompleteMotionGestureListenerInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        this.logUtil.putF("Null Gesture Reciever", this, commonStrings.CONSTRUCTOR)
    }

    override def onMotionGestureCompleted(list : BasicArrayList) : Unit = {
    }

}


