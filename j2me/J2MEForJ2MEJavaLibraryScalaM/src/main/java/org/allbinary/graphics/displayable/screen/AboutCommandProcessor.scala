/* * AllBinary Open License Version 1 * Copyright (c) 2022 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot * */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.displayable.screen

import _root_.javax.microedition.lcdui.Canvas
import _root_.javax.microedition.lcdui.Command
import _root_.javax.microedition.lcdui.CommandListener

/**  *  * @author User  */
class AboutCommandProcessor {
    import _root_.org.allbinary.graphics.displayable.screen.AboutCommandProcessor.{*}

    def process(midletCommandListener : CommandListener, command : Command, canvas : Canvas) : Unit = {
        midletCommandListener.commandAction(command, canvas)
    }

}

object AboutCommandProcessor {
    private val instance : AboutCommandProcessor = new AboutCommandProcessor()

    /**      * @return the instance      */
    def getInstance() : AboutCommandProcessor = {
        return AboutCommandProcessor.instance
    }

}


