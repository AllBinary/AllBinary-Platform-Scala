/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.hud.basic.notification

import _root_.org.allbinary.game.graphics.hud.BasicHudFactory
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class NoGameNotificationHudSingleton private() {
    import _root_.org.allbinary.game.ag.layer.hud.basic.notification.NoGameNotificationHudSingleton.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var gameNotificationHud : GameNotificationHud = GameNotificationHud.NULL_GAME_NOTIFICATION

    //Constructor
    {
        try {
            val basicHudFactory : BasicHudFactory = BasicHudFactory.getInstance()
            this.gameNotificationHud = new NoGameGameNotificationHud()
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.CONSTRUCTOR, e)
            }
        }
    }

    def getGameNotificationHud() : GameNotificationHud = {
        return this.gameNotificationHud
    }

}

object NoGameNotificationHudSingleton {
    private val instance : NoGameNotificationHudSingleton = new NoGameNotificationHudSingleton()

    def getInstance() : NoGameNotificationHudSingleton = {
        return NoGameNotificationHudSingleton.instance
    }

}


