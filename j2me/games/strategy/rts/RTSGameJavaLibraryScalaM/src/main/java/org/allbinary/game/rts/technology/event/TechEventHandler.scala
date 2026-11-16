/*  * AllBinary Open License Version 1  * Copyright (c) 2002 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  */
/* Generated Code Do Not Modify */
package org.allbinary.game.rts.technology.event

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler

class TechEventHandler private() extends BasicEventHandler {
    import _root_.org.allbinary.game.rts.technology.event.TechEventHandler.{*}

    override def process(eventObject : AllBinaryEventObject, eventListenerInterface : EventListenerInterface) : Unit = {
        val techEventListenerInterface : TechEventListenerInterface = (eventListenerInterface.asInstanceOf[TechEventListenerInterface])
        techEventListenerInterface.onTechEvent(eventObject)
    }

}

object TechEventHandler {
    private val eventHandler : TechEventHandler = new TechEventHandler()

    def getInstance() : TechEventHandler = {
        return TechEventHandler.eventHandler
    }

}


