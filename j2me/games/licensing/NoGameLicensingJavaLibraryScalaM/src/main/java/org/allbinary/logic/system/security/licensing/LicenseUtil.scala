/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing

import _root_.javax.microedition.lcdui.CommandListener

/**  *  * @author user  */
class LicenseUtil {
    import _root_.org.allbinary.logic.system.security.licensing.LicenseUtil.{*}

    /*     public boolean isLicenseServerError(             AbeLicenseInterface licenseInterface)     {         return false;     }      */
    def init() : Unit = {
    }

    def isRunning() : Boolean = this.synchronized {
        return false
    }

    def setRunning(running : Boolean) : Unit = this.synchronized {
    }

    def shouldWait(commandListener : CommandListener) : Boolean = {
        return this.isRunning()
    }

}

object LicenseUtil {
    private val instance : LicenseUtil = new LicenseUtil()

    def getInstance() : LicenseUtil = {
        return LicenseUtil.instance
    }

}


