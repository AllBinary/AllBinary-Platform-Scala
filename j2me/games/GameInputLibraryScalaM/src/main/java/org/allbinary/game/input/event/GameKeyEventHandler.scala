/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.event

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.string.CommonStrings

class GameKeyEventHandler {
    import _root_.org.allbinary.game.input.event.GameKeyEventHandler.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val pressGameKeyEventHandler : PressGameKeyEventHandler = PressGameKeyEventHandler.getInstance()

    private val upGameKeyEventHandler : UpGameKeyEventHandler = UpGameKeyEventHandler.getInstance()

    private val downGameKeyEventHandler : DownGameKeyEventHandler = DownGameKeyEventHandler.getInstance()

    def removeAllListeners() : Unit = this.synchronized {
        this.pressGameKeyEventHandler.removeAllListeners()
        this.upGameKeyEventHandler.removeAllListeners()
        this.downGameKeyEventHandler.removeAllListeners()
    }

    //synchronized 
    def addListenerForPlayer(eventListenerInterface : EventListenerInterface, playerInputId : Int) : Unit = {
        this.logUtil.putF(eventListenerInterface.toString(), this, this.commonStrings.ADD_LISTENER)
        //ForcedLogUtil.log(eventListenerInterface.toString(), this);
        this.pressGameKeyEventHandler.addListenerSingleThreaded(eventListenerInterface)
        this.upGameKeyEventHandler.getInstanceForPlayer(playerInputId).addListenerSingleThreaded(eventListenerInterface)
        this.downGameKeyEventHandler.getInstanceForPlayer(playerInputId).addListenerSingleThreaded(eventListenerInterface)
    }

    def addListener(eventListenerInterface : EventListenerInterface) : Unit = {
        this.logUtil.putF(eventListenerInterface.toString(), this, this.commonStrings.ADD_LISTENER)
        //ForcedLogUtil.log(eventListenerInterface.toString(), this);
        this.pressGameKeyEventHandler.addListenerSingleThreaded(eventListenerInterface)
        this.upGameKeyEventHandler.addListenerSingleThreaded(eventListenerInterface)
        this.downGameKeyEventHandler.addListenerSingleThreaded(eventListenerInterface)
    }

    //synchronized 
    def removeListener(eventListenerInterface : EventListenerInterface) : Unit = {
        this.logUtil.putF(eventListenerInterface.toString(), this, this.commonStrings.REMOVE_LISTENER)
        //ForcedLogUtil.log(eventListenerInterface.toString(), this);
        this.pressGameKeyEventHandler.removeListenerSingleThreaded(eventListenerInterface)
        this.upGameKeyEventHandler.removeListenerSingleThreaded(eventListenerInterface)
        this.downGameKeyEventHandler.removeListenerSingleThreaded(eventListenerInterface)
    }

}

object GameKeyEventHandler {
    private val instance : GameKeyEventHandler = new GameKeyEventHandler()

    def getInstance() : GameKeyEventHandler = {
        return GameKeyEventHandler.instance
    }

}


