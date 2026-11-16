/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.displayable

import _root_.javax.microedition.lcdui.Command
import _root_.javax.microedition.lcdui.CommandListener

trait DisplayableInterface {

    def addCommand(cmd : Command) : Unit

    def getHeight() : Int

    //String getTitle();
    def getWidth() : Int

    //boolean isShown();
    def removeCommand(cmd : Command) : Unit

    def setCommandListener(l : CommandListener) : Unit

}


