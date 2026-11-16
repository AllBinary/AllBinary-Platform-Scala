/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.midlet

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler

class GameMidletEventHandler private() extends BasicEventHandler {
    import _root_.org.allbinary.game.midlet.GameMidletEventHandler.{*}

    override def process(eventObject : AllBinaryEventObject, eventListenerInterface : EventListenerInterface) : Unit = {
        val gameMidletEventListener : GameMidletEventListener = eventListenerInterface.asInstanceOf[GameMidletEventListener]
        gameMidletEventListener.onGameEnd(eventObject)
    }

}

object GameMidletEventHandler {
    private val gameKeyEventHandler : GameMidletEventHandler = new GameMidletEventHandler()

    def getInstance() : GameMidletEventHandler = {
        return GameMidletEventHandler.gameKeyEventHandler
    }

}


