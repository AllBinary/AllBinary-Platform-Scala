/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.event

import _root_.org.allbinary.game.input.LocalPlayerInputIdFactory
import _root_.org.allbinary.logic.util.event.EventListenerInterface

class DownGameKeyEventHandler private() extends DownGameKeyEventHandlerBase {
    import _root_.org.allbinary.game.input.event.DownGameKeyEventHandler.{*}

    private val playerInputIdFactory : LocalPlayerInputIdFactory = LocalPlayerInputIdFactory.getInstance()

    def getInstanceForDevice(deviceId : Int) : DownGameKeyEventHandlerBase = {
        val playerInputId : Int = this.playerInputIdFactory.getPlayerForDevice(deviceId)
        return DownGameKeyEventHandler.instanceArray(playerInputId)
    }

    def getInstanceForPlayer(playerInputId : Int) : DownGameKeyEventHandlerBase = {
        return DownGameKeyEventHandler.instanceArray(playerInputId)
    }

    override def removeAllListeners() : Unit = {
        super.removeAllListeners()

        {
            var index : Int = DownGameKeyEventHandler.instanceArray.length - 1
            while (index >= 0) {
                DownGameKeyEventHandler.instanceArray(index).removeAllListeners()
                index -= 1
            }
        }
    }

    override def removeListenerSingleThreaded(eventListenerInterface : EventListenerInterface) : Unit = {
        super.removeListenerSingleThreaded(eventListenerInterface)

        {
            var index : Int = DownGameKeyEventHandler.instanceArray.length - 1
            while (index >= 0) {
                DownGameKeyEventHandler.instanceArray(index).removeListenerSingleThreaded(eventListenerInterface)
                index -= 1
            }
        }
    }

    override def removeListener(eventListenerInterface : EventListenerInterface) : Unit = this.synchronized {
        super.removeListener(eventListenerInterface)

        {
            var index : Int = DownGameKeyEventHandler.instanceArray.length - 1
            while (index >= 0) {
                DownGameKeyEventHandler.instanceArray(index).removeListener(eventListenerInterface)
                index -= 1
            }
        }
    }

}

object DownGameKeyEventHandler {
    private val instance : DownGameKeyEventHandler = new DownGameKeyEventHandler()

    private val instanceArray : Array[DownGameKeyEventHandlerBase] = Array[DownGameKeyEventHandlerBase](new DownGameKeyEventHandlerBase(), new DownGameKeyEventHandlerBase(), new DownGameKeyEventHandlerBase(), new DownGameKeyEventHandlerBase(), new DownGameKeyEventHandlerBase(), new DownGameKeyEventHandlerBase())

    def getInstance() : DownGameKeyEventHandler = {
        return DownGameKeyEventHandler.instance
    }

}


