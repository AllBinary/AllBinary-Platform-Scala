/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.hud.event

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.NullEventListener
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler
import _root_.org.allbinary.util.BasicArrayList

class GameNotificationEventHandler private() extends BasicEventHandler {
    import _root_.org.allbinary.game.layer.hud.event.GameNotificationEventHandler.{*}

    var enabled : Boolean = true

    //This is not the default optimal method
    override def removeAllListeners() : Unit = this.synchronized {
        var eventListenerInterface : EventListenerInterface = NullEventListener.NULL_EVENT_LISTENER
        //Keep the system specific listener around
        var list : BasicArrayList = this.eventListenerInterfaceList
        if (list.size() > 0) {
            eventListenerInterface = list.objectArray(0).asInstanceOf[EventListenerInterface]
        }
        super.removeAllListeners()
        if (eventListenerInterface ne NullEventListener.NULL_EVENT_LISTENER) {
            this.addListenerInterface(eventListenerInterface)
        }
    }

    override def process(eventObject : AllBinaryEventObject, eventListenerInterface : EventListenerInterface) : Unit = {
        if (!this.enabled) {
            return
        }
        val gameNotificationListenerInterface : GameNotificationListenerInterface = eventListenerInterface.asInstanceOf[GameNotificationListenerInterface]
        gameNotificationListenerInterface.onGameNotificationEvent(eventObject.asInstanceOf[GameNotificationEvent])
    }

}

object GameNotificationEventHandler {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : GameNotificationEventHandler = new GameNotificationEventHandler()

    def getInstance() : GameNotificationEventHandler = {
        return GameNotificationEventHandler.instance
    }

}


