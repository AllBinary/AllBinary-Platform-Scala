/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.event


/**  *  * @author User  */
class NullEventListener extends EventListenerInterface {
    import _root_.org.allbinary.logic.util.event.NullEventListener.{NULL_EVENT_LISTENER as _, *}
    def NULL_EVENT_LISTENER : NullEventListener = _root_.org.allbinary.logic.util.event.NullEventListener.NULL_EVENT_LISTENER

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
    }

}

object NullEventListener {
    val NULL_EVENT_LISTENER : NullEventListener = new NullEventListener()

}


