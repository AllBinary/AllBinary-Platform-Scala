/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.content

import _root_.javax.microedition.lcdui.Command
import _root_.android.content.Intent
import _root_.android.net.Uri
import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.ABHashtable

class CommandUriAction {
    import _root_.org.allbinary.content.CommandUriAction.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    def add(command : Command, url : String) : Unit = {
        this.hashtable.put(command, url)
    }

    def process(command : Command) : Unit = {
        try {
            /*              * Intent intent = new Intent();              *               * ComponentName comp = new ComponentName(              * "com.google.android.browser",              * "com.google.android.browser.BrowserActivity");              * intent.setComponent(comp);              * intent.setAction("android.intent.action.VIEW");              * intent.addCategory("android.intent.category.BROWSABLE"); Uri uri =              * Uri.parse(BrowserLoader.url); intent.setData(uri);              */
            var intent : Intent = this.getIntent(command)
            ResourceUtil.getInstance().getContext().startActivity(intent)
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.PROCESS, e)
            }
        }
    }

    def getIntent(command : Command) : Intent = {
        var url : String = this.hashtable.get(command).asInstanceOf[String]
        var uri : Uri = Uri.parse(url)
        var intent : Intent = new Intent(Intent.ACTION_VIEW, uri)
        return intent
    }

}

object CommandUriAction {
    private val instance : CommandUriAction = new CommandUriAction()

    def getInstance() : CommandUriAction = {
        return CommandUriAction.instance
    }

}


