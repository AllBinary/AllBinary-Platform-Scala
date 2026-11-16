/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.canvas

import _root_.javax.microedition.lcdui.Canvas
import _root_.javax.microedition.lcdui.CommandListener
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.MainFeatureFactory

class FullScreenUtil {
    import _root_.org.allbinary.canvas.FullScreenUtil.{*}

    final def initOnRun(fullScreenInterface : Canvas, commandListener : CommandListener) : Unit = {
        if (commandListener != null) {
            this.init(fullScreenInterface)
        }
    }

    final def init(fullScreenInterface : Canvas) : Unit = {
    }

    final def isScreenChange(isFullScreen : Boolean) : Boolean = {
        val mainFeatureFactory : MainFeatureFactory = MainFeatureFactory.getInstance()
        val features : Features = Features.getInstance()
        if (features.isFeature(mainFeatureFactory.FULL_SCREEN) != isFullScreen) {
            return true
        }
        return false
    }

    final def isScreenChangeCanvas(fullScreenInterface : Canvas) : Boolean = {
        return this.isScreenChange(false)
    }

}

object FullScreenUtil {
    private val instance : FullScreenUtil = new FullScreenUtil()

    /**      * @return the instance      */
    def getInstance() : FullScreenUtil = {
        return FullScreenUtil.instance
    }

}


