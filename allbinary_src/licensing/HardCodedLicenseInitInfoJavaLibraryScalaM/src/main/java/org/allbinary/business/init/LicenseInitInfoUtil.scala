/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.init


class LicenseInitInfoUtil private() {
    import _root_.org.allbinary.business.init.LicenseInitInfoUtil.{*}

    val INITFILENAME : String = "licenseinitdata.dat"

    val ABOUT : String = "about"

    val PRIVACY_POLICY : String = "privacy_policy"

    private val OFFICIAL_ALLBINARY_SERVICES_SERVER : String = "https://services.allbinary.com/LicServ/serverssl.php"

    def setFilePath(filePath : String) : Unit = this.synchronized {
    }

    def write(initData : LicenseInitInfo) : Unit = this.synchronized {
    }

    def read() : LicenseInitInfo = this.synchronized {
        return this.readAgain(0)
    }

    /*     public static synchronized boolean exists() throws Exception     {         AbPath abPath = new AbPath(URLGLOBALS.getMainPath() + PATH_GLOBALS.INIT_PATH,                 INITFILENAME);                  return FileUtil.isFile(abPath);     }     */
    def readAgain(initializeCounter : Int) : LicenseInitInfo = this.synchronized {
        var licenseInitInfo : LicenseInitInfo = new LicenseInitInfo()
        licenseInitInfo.clearServers()
        //Add your servers here
        licenseInitInfo.addServer(this.OFFICIAL_ALLBINARY_SERVICES_SERVER)
        return licenseInitInfo
    }

}

object LicenseInitInfoUtil {
    private val instance : LicenseInitInfoUtil = new LicenseInitInfoUtil()

    def getInstance() : LicenseInitInfoUtil = {
        return LicenseInitInfoUtil.instance
    }

}


