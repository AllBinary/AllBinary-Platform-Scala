/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.input.api1

import _root_.org.allbinary.android.input.VirtualKeyboard
import _root_.org.allbinary.input.event.VirtualKeyboardEventListenerInterface
import _root_.android.app.Activity
import _root_.org.allbinary.input.event.VirtualKeyboardEvent
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class VirtualKeyboardAPI1(param_activity : Activity) extends VirtualKeyboard with VirtualKeyboardEventListenerInterface {
    import _root_.org.allbinary.android.input.api1.VirtualKeyboardAPI1.{*}

    //Constructor
    {
        val activity : Activity = param_activity
    }

    //Needed for polyglot do not remove
    override def onVirtualKeyboardEvent(virtualKeyboardEvent : VirtualKeyboardEvent) : Unit = {
        super.onVirtualKeyboardEvent(virtualKeyboardEvent)
    }

    //Needed for polyglot do not remove
    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        super.onEvent(eventObject)
    }

}

object VirtualKeyboardAPI1 {
    var MIN_API : Int = 1

    var MAX_API : Int = 2

}


