/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.event

import _root_.org.allbinary.game.input.LocalPlayerInputIdFactory
import _root_.org.allbinary.logic.util.event.EventListenerInterface

class DownKeyEventHandler private() extends DownKeyEventHandlerBase {
    import _root_.org.allbinary.game.input.event.DownKeyEventHandler.{*}

    private val playerInputIdFactory : LocalPlayerInputIdFactory = LocalPlayerInputIdFactory.getInstance()

    def getInstanceForDevice(deviceId : Int) : DownKeyEventHandlerBase = {
        val playerInputId : Int = this.playerInputIdFactory.getPlayerForDevice(deviceId)
        return DownKeyEventHandler.instanceArray(playerInputId)
    }

    def getInstanceForPlayer(playerInputId : Int) : DownKeyEventHandlerBase = {
        return DownKeyEventHandler.instanceArray(playerInputId)
    }

    override def removeAllListeners() : Unit = {
        super.removeAllListeners()

        {
            var index : Int = DownKeyEventHandler.instanceArray.length - 1
            while (index >= 0) {
                DownKeyEventHandler.instanceArray(index).removeAllListeners()
                index -= 1
            }
        }
    }

    override def removeListenerSingleThreaded(eventListenerInterface : EventListenerInterface) : Unit = {
        super.removeListenerSingleThreaded(eventListenerInterface)

        {
            var index : Int = DownKeyEventHandler.instanceArray.length - 1
            while (index >= 0) {
                DownKeyEventHandler.instanceArray(index).removeListenerSingleThreaded(eventListenerInterface)
                index -= 1
            }
        }
    }

    override def removeListener(eventListenerInterface : EventListenerInterface) : Unit = this.synchronized {
        super.removeListener(eventListenerInterface)

        {
            var index : Int = DownKeyEventHandler.instanceArray.length - 1
            while (index >= 0) {
                DownKeyEventHandler.instanceArray(index).removeListener(eventListenerInterface)
                index -= 1
            }
        }
    }

}

object DownKeyEventHandler {
    private val instance : DownKeyEventHandler = new DownKeyEventHandler()

    private val instanceArray : Array[DownKeyEventHandlerBase] = Array[DownKeyEventHandlerBase](new DownKeyEventHandlerBase(), new DownKeyEventHandlerBase(), new DownKeyEventHandlerBase(), new DownKeyEventHandlerBase(), new DownKeyEventHandlerBase(), new DownKeyEventHandlerBase())

    def getInstance() : DownKeyEventHandler = {
        return DownKeyEventHandler.instance
    }

}


