/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.init

import _root_.org.allbinary.game.configuration.event.GameInitializedEvent
import _root_.org.allbinary.game.configuration.event.GameInitializedEventHandler
import _root_.org.allbinary.game.configuration.event.GameInitializedListenerInterface
import _root_.org.allbinary.game.resource.FeatureResourceInitializationUtil
import _root_.org.allbinary.graphics.threed.SWTJOGLProcessor
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.string.CommonStrings

class DefaultGameInitializationListener() extends GameInitializedListenerInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val swtJOGLProcessor : SWTJOGLProcessor = SWTJOGLProcessor.getInstance()

    var firstTime : Boolean = true

    //Constructor
    {
        var gameInitializedEventHandler : GameInitializedEventHandler = GameInitializedEventHandler.getInstance()
        gameInitializedEventHandler.removeAllListeners()
        gameInitializedEventHandler.addListenerInterface(this.asInstanceOf[GameInitializedListenerInterface])
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def onGameInitialized(gameInitializedEvent : GameInitializedEvent) : Unit = {
        val ON_GAME_INITIALIZED : String = "onGameInitialized"
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        try {
            this.logUtil.putF(commonStrings.START, this, ON_GAME_INITIALIZED)

            {
                while (!this.swtJOGLProcessor.isHolderCreated()) {
                    this.logUtil.putF(commonStrings.UPDATE, this, ON_GAME_INITIALIZED)
                    Thread.sleep(20)
                }
            }
            FeatureResourceInitializationUtil.getInstance().init(gameInitializedEvent.getLevel())
            if (this.firstTime) {
                this.firstTime = false
            } else {
                this.swtJOGLProcessor.onSurfaceChanged()
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(commonStrings.EXCEPTION, this, ON_GAME_INITIALIZED, e)
            }
        }
    }

}


