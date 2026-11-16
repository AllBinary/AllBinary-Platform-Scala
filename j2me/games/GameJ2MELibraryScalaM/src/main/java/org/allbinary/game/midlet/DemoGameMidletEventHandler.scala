/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.midlet

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler

class DemoGameMidletEventHandler private() extends BasicEventHandler {
    import _root_.org.allbinary.game.midlet.DemoGameMidletEventHandler.{*}

    override def process(eventObject : AllBinaryEventObject, eventListenerInterface : EventListenerInterface) : Unit = {
        val demoGameMidletEventListener : DemoGameMidletEventListener = eventListenerInterface.asInstanceOf[DemoGameMidletEventListener]
        demoGameMidletEventListener.onDemoGameMidletEvent(eventObject.asInstanceOf[DemoGameMidletEvent])
    }

}

object DemoGameMidletEventHandler {
    private val gameKeyEventHandler : DemoGameMidletEventHandler = new DemoGameMidletEventHandler()

    def getInstance() : DemoGameMidletEventHandler = {
        return DemoGameMidletEventHandler.gameKeyEventHandler
    }

}


