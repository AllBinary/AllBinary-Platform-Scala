/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary


//import org.allbinary.logic.communication.log.PreLogUtil;
class AppletUtil private() {
    import _root_.org.allbinary.AppletUtil.{*}

}

object AppletUtil {
    private var applet : Boolean = false

    def setApplet() : Unit = {
        AppletUtil.applet = true
    }

    //private static final String APPLET = "sun.plugin.security.PluginClassLoader".toLowerCase();
    def isAppletLoader(anyType : Object) : Boolean = {
        //}
        return AppletUtil.applet
    }

}


