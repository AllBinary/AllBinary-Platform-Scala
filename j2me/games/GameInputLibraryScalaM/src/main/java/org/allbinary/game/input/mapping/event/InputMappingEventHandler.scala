/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.mapping.event

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler

class InputMappingEventHandler private() extends BasicEventHandler {
    import _root_.org.allbinary.game.input.mapping.event.InputMappingEventHandler.{*}

    override def process(eventObject : AllBinaryEventObject, eventListenerInterface : EventListenerInterface) : Unit = {
        val inputMappingEventListenerInterface : InputMappingEventListenerInterface = eventListenerInterface.asInstanceOf[InputMappingEventListenerInterface]
        inputMappingEventListenerInterface.onInputMappingEvent(eventObject.asInstanceOf[InputMappingEvent])
    }

}

object InputMappingEventHandler {
    private val gameKeyEventHandler : InputMappingEventHandler = new InputMappingEventHandler()

    def getInstance() : InputMappingEventHandler = {
        return InputMappingEventHandler.gameKeyEventHandler
    }

}


