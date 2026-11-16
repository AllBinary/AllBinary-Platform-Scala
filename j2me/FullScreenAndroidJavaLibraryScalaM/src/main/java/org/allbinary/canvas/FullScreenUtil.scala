/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.canvas

import _root_.javax.microedition.lcdui.Canvas
import _root_.javax.microedition.lcdui.CommandListener

/**  *  * @author user  */
class FullScreenUtil {
    import _root_.org.allbinary.canvas.FullScreenUtil.{*}

    final def initOnRun(fullScreenInterface : Canvas, commandListener : CommandListener) : Unit = {
    }

    final def init(fullScreenInterface : Canvas) : Unit = {
    }

    final def isScreenChange(isFullScreen : Boolean) : Boolean = {
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


