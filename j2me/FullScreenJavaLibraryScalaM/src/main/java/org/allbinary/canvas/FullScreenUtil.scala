/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.canvas

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.MainFeatureFactory
import _root_.javax.microedition.lcdui.CommandListener

class FullScreenUtil {
    import _root_.org.allbinary.canvas.FullScreenUtil.{*}

    final def initOnRun(fullScreenInterface : Canvas, commandListener : CommandListener) : Unit = {
        (fullScreenInterface.asInstanceOf[RunnableCanvas]).waitOnNotify(0)
        if (commandListener != null) {
            this.init(fullScreenInterface)
        }
    }

    final def init(fullScreenInterface : Canvas) : Unit = {
        val mainFeatureFactory : MainFeatureFactory = MainFeatureFactory.getInstance()
        var features : Features = Features.getInstance()
        if (features.isFeature(mainFeatureFactory.FULL_SCREEN)) {
            fullScreenInterface.setFullScreenMode(true)
        } else {
            fullScreenInterface.setFullScreenMode(false)
        }
    }

    final def isScreenChange(isFullScreen : Boolean) : Boolean = {
        var mainFeatureFactory : MainFeatureFactory = MainFeatureFactory.getInstance()
        var features : Features = Features.getInstance()
        if (features.isFeature(mainFeatureFactory.FULL_SCREEN) != isFullScreen) {
            return true
        }
        return false
    }

    final def isScreenChangeCanvas(fullScreenInterface : Canvas) : Boolean = {
        return this.isScreenChange(fullScreenInterface.isFullScreenMode())
    }

}

object FullScreenUtil {
    private val instance : FullScreenUtil = new FullScreenUtil()

    /**      * @return the instance      */
    def getInstance() : FullScreenUtil = {
        return FullScreenUtil.instance
    }

}


