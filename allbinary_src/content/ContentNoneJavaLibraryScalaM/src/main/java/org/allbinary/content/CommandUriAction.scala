/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.content

import _root_.javax.microedition.lcdui.Command
import _root_.org.allbinary.logic.communication.log.LogUtil

class CommandUriAction {
    import _root_.org.allbinary.content.CommandUriAction.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //private Hashtable hashtable = StdUtil.getInstance().createHashtable();
    def add(command : Command, url : String) : Unit = {
    }

    def process(command : Command) : Unit = {
    }

}

object CommandUriAction {
    private val instance : CommandUriAction = new CommandUriAction()

    def getInstance() : CommandUriAction = {
        return CommandUriAction.instance
    }

}


