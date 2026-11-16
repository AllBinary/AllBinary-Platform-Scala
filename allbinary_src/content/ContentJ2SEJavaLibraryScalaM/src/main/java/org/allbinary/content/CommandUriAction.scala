/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.content

import _root_.javax.microedition.lcdui.Command
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.ABHashtable

class CommandUriAction {
    import _root_.org.allbinary.content.CommandUriAction.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    def add(command : Command, url : String) : Unit = {
        this.hashtable.put(command, url)
    }

    def process(command : Command) : Unit = {
        try {
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.PROCESS, e)
            }
        }
    }

    def getIntent(command : Command) : Intent = {
        var url : String = this.hashtable.get(command).asInstanceOf[String]
        //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        return intent
    }

}

object CommandUriAction {
    private val instance : CommandUriAction = new CommandUriAction()

    def getInstance() : CommandUriAction = {
        return CommandUriAction.instance
    }

}


