/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics


class ScreenListenerHandler {
    import _root_.org.allbinary.graphics.ScreenListenerHandler.{*}

    private var screenListenerInterface : ScreenListenerInterface = new ScreenEmptyListener()

    def setListener(screenListenerInterface : ScreenListenerInterface) : Unit = {
        this.screenListenerInterface = screenListenerInterface
    }

    def fireWithState(isFullScreen : Boolean) : Unit = {
        this.screenListenerInterface.onFullScreen(isFullScreen)
    }

    def fire() : Unit = {
        this.screenListenerInterface.onFullScreenDisplay()
    }

}

object ScreenListenerHandler {
    private val instance : ScreenListenerHandler = new ScreenListenerHandler()

    /**      * @return the instance      */
    def getInstance() : ScreenListenerHandler = {
        return ScreenListenerHandler.instance
    }

}


