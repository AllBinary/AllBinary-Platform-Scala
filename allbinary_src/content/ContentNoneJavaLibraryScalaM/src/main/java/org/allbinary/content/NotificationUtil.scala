/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.content

import _root_.javax.microedition.lcdui.Command

class NotificationUtil {
    import _root_.org.allbinary.content.NotificationUtil.{*}

    def notify(command : Command, resource : String, message : String) : Unit = {
    }

}

object NotificationUtil {
    private val SINGLETON : NotificationUtil = new NotificationUtil()

    def getInstance() : NotificationUtil = {
        return NotificationUtil.SINGLETON
    }

}


