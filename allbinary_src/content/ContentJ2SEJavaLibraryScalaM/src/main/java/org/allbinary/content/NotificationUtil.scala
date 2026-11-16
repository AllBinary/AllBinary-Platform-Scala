/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.content

import _root_.javax.microedition.lcdui.Command
import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.TsUtil

class NotificationUtil {
    import _root_.org.allbinary.content.NotificationUtil.{*}

    private var notificationManager : NotificationManager = ResourceUtil.getInstance().getContext().getSystemService(Context.NOTIFICATION_SERVICE).asInstanceOf[NotificationManager]

    def notify(command : Command, resource : String, message : String) : Unit = {
        var context : Context = ResourceUtil.getInstance().getContext()
        var intent : Intent = CommandUriAction.getInstance().getIntent(command)
        /*             intent.putExtra( "data", "test data");        */
        var integer : Integer = ResourceUtil.getInstance().getResourceId(resource)
        var notification : Notification = new Notification(integer.intValue(), message, System.currentTimeMillis())
        var pendingIntent : PendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
        notification.setLatestEventInfo(context, command.getLabel(), message, pendingIntent)
        this.notificationManager.notify(TsUtil.getInstance().hashCode(command), notification)
    }

}

object NotificationUtil {
    private val SINGLETON : NotificationUtil = new NotificationUtil()

    def getInstance() : NotificationUtil = {
        return NotificationUtil.SINGLETON
    }

}


