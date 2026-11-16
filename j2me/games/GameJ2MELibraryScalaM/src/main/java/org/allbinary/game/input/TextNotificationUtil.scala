/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.game.layer.hud.event.GameNotificationEvent
import _root_.org.allbinary.game.layer.hud.event.GameNotificationEventHandler
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.media.audio.ErrorSound
import _root_.org.allbinary.media.audio.PrimaryPlayerQueueFactory
import _root_.org.allbinary.media.audio.SelectSound

class TextNotificationUtil {
    import _root_.org.allbinary.game.input.TextNotificationUtil.{*}

    private val TWO : Integer = SmallIntegerSingletonFactory.getInstance().getAt(2)

    private val FALSE : _root_.java.lang.Boolean = BooleanFactory.getInstance().FALSE

    private val gameNotificationEventHandler : GameNotificationEventHandler = GameNotificationEventHandler.getInstance()

    def fireError(message : String) : Unit = {
        PrimaryPlayerQueueFactory.getInstance().add(ErrorSound.getInstance())
        this.fire(message)
    }

    def fireNew(message : String) : Unit = {
        PrimaryPlayerQueueFactory.getInstance().add(SelectSound.getInstance())
        this.fire(message)
    }

    def fireSuccess(message : String) : Unit = {
        PrimaryPlayerQueueFactory.getInstance().add(SelectSound.getInstance())
        this.fire(message)
    }

    def fire(message : String) : Unit = {
        var gameNotificationEvent : GameNotificationEvent = new GameNotificationEvent(this, message, this.TWO, BasicColorFactory.getInstance().RED, this.FALSE)
        this.gameNotificationEventHandler.fireEvent(gameNotificationEvent)
    }

}

object TextNotificationUtil {
    private val instance : TextNotificationUtil = new TextNotificationUtil()

    def getInstance() : TextNotificationUtil = {
        return TextNotificationUtil.instance
    }

}


