/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.event

import _root_.org.allbinary.game.input.LocalPlayerInputIdFactory
import _root_.org.allbinary.logic.util.event.EventListenerInterface

class UpGameKeyEventHandler private() extends UpGameKeyEventHandlerBase {
    import _root_.org.allbinary.game.input.event.UpGameKeyEventHandler.{*}

    private val playerInputIdFactory : LocalPlayerInputIdFactory = LocalPlayerInputIdFactory.getInstance()

    def getInstanceForDevice(deviceId : Int) : UpGameKeyEventHandlerBase = {
        val playerInputId : Int = this.playerInputIdFactory.getPlayerForDevice(deviceId)
        return UpGameKeyEventHandler.instanceArray(playerInputId)
    }

    def getInstanceForPlayer(playerInputId : Int) : UpGameKeyEventHandlerBase = {
        return UpGameKeyEventHandler.instanceArray(playerInputId)
    }

    override def removeAllListeners() : Unit = {
        super.removeAllListeners()

        {
            var index : Int = UpGameKeyEventHandler.instanceArray.length - 1
            while (index >= 0) {
                UpGameKeyEventHandler.instanceArray(index).removeAllListeners()
                index -= 1
            }
        }
    }

    override def removeListenerSingleThreaded(eventListenerInterface : EventListenerInterface) : Unit = {
        super.removeListenerSingleThreaded(eventListenerInterface)

        {
            var index : Int = UpGameKeyEventHandler.instanceArray.length - 1
            while (index >= 0) {
                UpGameKeyEventHandler.instanceArray(index).removeListenerSingleThreaded(eventListenerInterface)
                index -= 1
            }
        }
    }

    override def removeListener(eventListenerInterface : EventListenerInterface) : Unit = {
        super.removeListener(eventListenerInterface)

        {
            var index : Int = UpGameKeyEventHandler.instanceArray.length - 1
            while (index >= 0) {
                UpGameKeyEventHandler.instanceArray(index).removeListener(eventListenerInterface)
                index -= 1
            }
        }
    }

}

object UpGameKeyEventHandler {
    private val instance : UpGameKeyEventHandler = new UpGameKeyEventHandler()

    private val instanceArray : Array[UpGameKeyEventHandlerBase] = Array[UpGameKeyEventHandlerBase](new UpGameKeyEventHandlerBase(), new UpGameKeyEventHandlerBase(), new UpGameKeyEventHandlerBase(), new UpGameKeyEventHandlerBase(), new UpGameKeyEventHandlerBase(), new UpGameKeyEventHandlerBase())

    def getInstance() : UpGameKeyEventHandler = {
        return UpGameKeyEventHandler.instance
    }

}


