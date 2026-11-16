/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game

import _root_.org.allbinary.business.advertisement.GameAdStateBase
import _root_.org.allbinary.business.advertisement.AdConfiguration
import _root_.org.allbinary.input.event.VirtualKeyboardEvent
import _root_.org.allbinary.input.event.VirtualKeyboardEventHandler
import _root_.org.allbinary.input.event.VirtualKeyboardEventListenerInterface
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class GameAdState(param_adConfiguration : AdConfiguration) extends GameAdStateBase(param_adConfiguration) with VirtualKeyboardEventListenerInterface {

    //Constructor
    {
        val adConfiguration : AdConfiguration = param_adConfiguration
        VirtualKeyboardEventHandler.getInstance().addListenerInterface(this)
    }

    override def onVirtualKeyboardEvent(virtualKeyboardEvent : VirtualKeyboardEvent) : Unit = {
    }

    //Needed for polyglot do not remove
    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        super.onEvent(eventObject)
    }

}


