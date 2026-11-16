/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.mapping.event

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

/**  *  * @author User  */
class NullInputMappingEventListener extends InputMappingEventListenerInterface {
    import _root_.org.allbinary.game.input.mapping.event.NullInputMappingEventListener.{NULL_INPUT_MAPPING_EVENT_LISTENER as _, *}
    def NULL_INPUT_MAPPING_EVENT_LISTENER : NullInputMappingEventListener = _root_.org.allbinary.game.input.mapping.event.NullInputMappingEventListener.NULL_INPUT_MAPPING_EVENT_LISTENER

    override def onInputMappingEvent(inputMappingEvent : InputMappingEvent) : Unit = {
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
    }

}

object NullInputMappingEventListener {
    val NULL_INPUT_MAPPING_EVENT_LISTENER : NullInputMappingEventListener = new NullInputMappingEventListener()

}


