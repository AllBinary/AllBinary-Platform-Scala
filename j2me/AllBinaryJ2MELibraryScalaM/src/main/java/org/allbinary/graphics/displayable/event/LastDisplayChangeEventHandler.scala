/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.displayable.event

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler

/**  *  * @author User  */
class LastDisplayChangeEventHandler private() extends BasicEventHandler {
    import _root_.org.allbinary.graphics.displayable.event.LastDisplayChangeEventHandler.{*}

    override def process(eventObject : AllBinaryEventObject, eventListenerInterface : EventListenerInterface) : Unit = {
        val displayChangeEventListener : DisplayChangeEventListener = (eventListenerInterface.asInstanceOf[DisplayChangeEventListener])
        displayChangeEventListener.onDisplayChangeEvent(eventObject.asInstanceOf[DisplayChangeEvent])
    }

}

object LastDisplayChangeEventHandler {
    private val SINGLETON : LastDisplayChangeEventHandler = new LastDisplayChangeEventHandler()

    def getInstance() : LastDisplayChangeEventHandler = {
        return LastDisplayChangeEventHandler.SINGLETON
    }

}


