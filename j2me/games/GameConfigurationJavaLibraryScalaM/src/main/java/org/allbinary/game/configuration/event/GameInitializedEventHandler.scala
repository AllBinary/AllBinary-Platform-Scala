/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.event

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler

class GameInitializedEventHandler private() extends BasicEventHandler {
    import _root_.org.allbinary.game.configuration.event.GameInitializedEventHandler.{*}

    override def process(eventObject : AllBinaryEventObject, eventListenerInterface : EventListenerInterface) : Unit = {
        val gameInitializedListenerInterface : GameInitializedListenerInterface = (eventListenerInterface.asInstanceOf[GameInitializedListenerInterface])
        gameInitializedListenerInterface.onGameInitialized(eventObject.asInstanceOf[GameInitializedEvent])
    }

}

object GameInitializedEventHandler {
    private val gameKeyEventHandler : GameInitializedEventHandler = new GameInitializedEventHandler()

    def getInstance() : GameInitializedEventHandler = {
        return GameInitializedEventHandler.gameKeyEventHandler
    }

}


