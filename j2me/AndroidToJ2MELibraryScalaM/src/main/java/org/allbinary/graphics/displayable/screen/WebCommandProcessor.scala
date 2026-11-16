/* * AllBinary Open License Version 1 * Copyright (c) 2022 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot * */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.displayable.screen

import _root_.android.content.Context
import _root_.javax.microedition.lcdui.Canvas
import _root_.javax.microedition.lcdui.Command
import _root_.javax.microedition.lcdui.CommandListener
import _root_.android.content.Intent
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

/**  *  * @author User  */
class WebCommandProcessor {
    import _root_.org.allbinary.graphics.displayable.screen.WebCommandProcessor.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val aboutCommandProcessor : AboutCommandProcessor = AboutCommandProcessor.getInstance()

    private val WEB_VIEW_ACTIVITY : String = "org.allbinary.android.activity.WebViewActivity"

    //Hack
    val list : BasicArrayList = new BasicArrayListD()

    def process(midletCommandListener : CommandListener, command : Command, canvas : Canvas) : Unit = {
        try {
            //midletCommandListener.commandAction(command, canvas);
            val context : Context = this.aboutCommandProcessor.getContext().asInstanceOf[Context]
            val intent : Intent = new Intent(context, TsUtil.getInstance().getClassClassLoader(this).loadClass(this.WEB_VIEW_ACTIVITY))
            intent.putExtra(this.aboutCommandProcessor.URL, this.list.removeAt(0).asInstanceOf[String])
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        } catch {
            case e : ClassNotFoundException => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, "process", e)
            }
        }
    }

}

object WebCommandProcessor {
    private val instance : WebCommandProcessor = new WebCommandProcessor()

    /**      * @return the instance      */
    def getInstance() : WebCommandProcessor = {
        return WebCommandProcessor.instance
    }

}


