/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.hud.basic.notification

import _root_.org.allbinary.game.layer.hud.event.GameNotificationEvent
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class GameNotification {
    import _root_.org.allbinary.game.ag.layer.hud.basic.notification.GameNotification.{NULL_GAME_NOTIFICATION_EVENT as _, *}
    def NULL_GAME_NOTIFICATION_EVENT : GameNotificationEvent = _root_.org.allbinary.game.ag.layer.hud.basic.notification.GameNotification.NULL_GAME_NOTIFICATION_EVENT

    val stringList : BasicArrayList = new BasicArrayListD()

    val timeList : BasicArrayList = new BasicArrayListD()

    val colorList : BasicArrayList = new BasicArrayListD()

    def add(string : String, seconds : Integer, basicColor : BasicColor) : Unit = {
        if (!this.stringList.contains(string)) {
            this.stringList.add(string)
            this.timeList.add(seconds)
            this.colorList.add(basicColor)
        }
    }

    def clear() : Unit = {
        this.stringList.clear()
        this.timeList.clear()
        this.colorList.clear()
    }

    def getSize() : Int = {
        return this.stringList.size()
    }

}

object GameNotification {
    val NULL_GAME_NOTIFICATION_EVENT : GameNotificationEvent = new GameNotificationEvent(NullUtil.getInstance().NULL_OBJECT, StringUtil.getInstance().EMPTY_STRING, new Integer(0), BasicColorFactory.getInstance().RED, BooleanFactory.getInstance().FALSE)

}


