/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.content

import _root_.javax.microedition.lcdui.Command
import _root_.android.app.Notification
import _root_.android.app.Notification.Builder
import _root_.android.app.PendingIntent
import _root_.android.content.Context
import _root_.android.os.Parcelable

/**  *  * @author user  */
class NotificationBuilderAPI23 extends NotificationBuilder {

    override def build(context : Context, command : Command, message : String, integer : Integer, pendingIntent : PendingIntent) : Parcelable = {
        //int icon, java.lang.CharSequence tickerText, long when
        val notification : Notification = new Builder(context).setSmallIcon(integer.intValue()).setTicker(message).setWhen(System.currentTimeMillis()).setContentTitle(command.getLabel()).setContentText(message).setContentIntent(pendingIntent).build()
        return notification
    }

}


