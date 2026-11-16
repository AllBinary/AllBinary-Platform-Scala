/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.input

import _root_.org.allbinary.input.event.VirtualKeyboardEvent
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings

class VirtualKeyboard {
    import _root_.org.allbinary.android.input.VirtualKeyboard.{NULL_VIRTUAL_KEYBOARD as _, *}
    def NULL_VIRTUAL_KEYBOARD : VirtualKeyboard = _root_.org.allbinary.android.input.VirtualKeyboard.NULL_VIRTUAL_KEYBOARD

    //protected final LogUtil logUtil = LogUtil.getInstance();
    def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    def onVirtualKeyboardEvent(virtualKeyboardEvent : VirtualKeyboardEvent) : Unit = {
    }

    def forceHide() : Unit = {
    }

    def hide() : Unit = {
    }

}

object VirtualKeyboard {
    val NULL_VIRTUAL_KEYBOARD : VirtualKeyboard = new VirtualKeyboard()

}


