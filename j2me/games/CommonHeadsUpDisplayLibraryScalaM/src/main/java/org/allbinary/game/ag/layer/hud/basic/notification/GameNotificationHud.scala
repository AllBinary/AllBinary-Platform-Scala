/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.hud.basic.notification

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.graphics.hud.BasicHud
import _root_.org.allbinary.game.graphics.hud.BasicHudFactory
import _root_.org.allbinary.game.layer.hud.event.GameNotificationEvent
import _root_.org.allbinary.game.layer.hud.event.GameNotificationListenerInterface
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings

class GameNotificationHud(param_location : Int, param_direction : Int, param_bufferZone : Int, param_basicColor : BasicColor) extends BasicHud(param_location, param_direction, param_bufferZone, param_basicColor) with GameNotificationListenerInterface {
    import _root_.org.allbinary.game.ag.layer.hud.basic.notification.GameNotificationHud.{NULL_GAME_NOTIFICATION as _, *}
    def NULL_GAME_NOTIFICATION : GameNotificationHud = _root_.org.allbinary.game.ag.layer.hud.basic.notification.GameNotificationHud.NULL_GAME_NOTIFICATION

    private val METHOD_NAME : String = "onGameNotificationEvent"

    private var lastGameNotificationEvent : GameNotificationEvent = GameNotification.NULL_GAME_NOTIFICATION_EVENT

    //Constructor
    {
        val location : Int = param_location
        val direction : Int = param_direction
        val bufferZone : Int = param_bufferZone
        val basicColor : BasicColor = param_basicColor
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def onGameNotificationEvent(gameNotificationEvent : GameNotificationEvent) : Unit = {
        if (this.lastGameNotificationEvent ne gameNotificationEvent) {
            this.lastGameNotificationEvent = gameNotificationEvent
            this.logUtil.putF(gameNotificationEvent.getString(), this, this.METHOD_NAME)
        }
        this.add(gameNotificationEvent.getString(), gameNotificationEvent.getSeconds(), gameNotificationEvent.getBasicColorP(), gameNotificationEvent.getPermanent())
    }

    def add(string : String, seconds : Integer, basicColor : BasicColor, permanent : _root_.java.lang.Boolean) : Unit = {
    }

    def processTick() : Unit = {
    }

    def paint(graphics : Graphics) : Unit = {
    }

    def clear() : Unit = {
    }

}

object GameNotificationHud {
    val NULL_GAME_NOTIFICATION : GameNotificationHud = new GameNotificationHud(BasicHudFactory.getInstance().TOPCENTER, BasicHudFactory.getInstance().HORIZONTAL, 0, BasicColorFactory.getInstance().RED)

}


