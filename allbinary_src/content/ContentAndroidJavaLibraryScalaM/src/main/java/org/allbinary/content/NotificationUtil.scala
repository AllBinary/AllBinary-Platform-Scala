/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.content

import _root_.javax.microedition.lcdui.Command
import _root_.android.app.Notification
import _root_.android.app.NotificationManager
import _root_.android.app.PendingIntent
import _root_.android.content.Context
import _root_.android.content.Intent
import _root_.org.allbinary.android.AndroidInfoFactory
import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class NotificationUtil private() {
    import _root_.org.allbinary.content.NotificationUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var notificationManager : NotificationManager = ResourceUtil.getInstance().getContext().getSystemService(Context.NOTIFICATION_SERVICE).asInstanceOf[NotificationManager]

    private var notificationBuilder : NotificationBuilder = null

    //Constructor
    {
        val SDK_VERSION : Int = AndroidInfoFactory.getInstance().getVersion()
        if (SDK_VERSION > 22) {
            this.notificationBuilder = new NotificationBuilderAPI23()
        } else {
            this.notificationBuilder = NotificationBuilder.NULL_NOTIFICATION_BUILDER
        }
    }

    def notify(command : Command, resource : String, message : String) : Unit = {
        val context : Context = ResourceUtil.getInstance().getContext()
        val intent : Intent = CommandUriAction.getInstance().getIntent(command)
        /*             intent.putExtra( "data", "test data");        */
        val integer : Integer = ResourceUtil.getInstance().getResourceId(resource)
        val FLAG_IMMUTABLE : Int = 1 << 26
        val SDK_VERSION : Int = AndroidInfoFactory.getInstance().getVersion()
        val pendingIntent : PendingIntent = PendingIntent.getActivity(context, 0, intent, (if (SDK_VERSION > 22) FLAG_IMMUTABLE else 0))
        if (this.notificationBuilder == null) {
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            this.logUtil.putF(commonStrings.EXCEPTION, this, commonStrings.NOT_IMPLEMENTED)
            return
        }
        //final Notification notification = (Notification) 
        this.notificationBuilder.build(context, command, message, integer, pendingIntent)
    }

}

object NotificationUtil {
    private val SINGLETON : NotificationUtil = new NotificationUtil()

    def getInstance() : NotificationUtil = {
        return NotificationUtil.SINGLETON
    }

}


