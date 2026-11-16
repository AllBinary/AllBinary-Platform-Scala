/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing

import _root_.org.allbinary.game.layer.hud.event.GameNotificationEvent
import _root_.org.allbinary.game.layer.hud.event.GameNotificationEventHandler
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.media.audio.ErrorSound
import _root_.org.allbinary.media.audio.PrimaryPlayerQueueFactory

class LockedFeatureNotificationUtil {
    import _root_.org.allbinary.logic.system.security.licensing.LockedFeatureNotificationUtil.{*}

    private val gameNotificationEvent : GameNotificationEvent = new GameNotificationEvent(this, LicenseStrings.getInstance().LOCKED, SmallIntegerSingletonFactory.getInstance().getAt(3), BasicColorFactory.getInstance().RED, BooleanFactory.getInstance().FALSE)

    def fire() : Unit = {
        PrimaryPlayerQueueFactory.getInstance().add(ErrorSound.getInstance())
        GameNotificationEventHandler.getInstance().fireEvent(this.gameNotificationEvent)
    }

    def fireWithColor(basicColor : BasicColor) : Unit = {
        PrimaryPlayerQueueFactory.getInstance().add(ErrorSound.getInstance())
        this.gameNotificationEvent.setBasicColorP(basicColor)
        GameNotificationEventHandler.getInstance().fireEvent(this.gameNotificationEvent)
    }

}

object LockedFeatureNotificationUtil {
    private val instance : LockedFeatureNotificationUtil = new LockedFeatureNotificationUtil()

    def getInstance() : LockedFeatureNotificationUtil = {
        return LockedFeatureNotificationUtil.instance
    }

}


