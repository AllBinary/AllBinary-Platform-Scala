/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing


class LicenseInterfaceSingleton {
    import _root_.org.allbinary.logic.system.security.licensing.LicenseInterfaceSingleton.{*}

}

object LicenseInterfaceSingleton {
    private var licenseInterface : AbeLicenseInterface = AbeNoLicense.getInstance()

    def getInstance() : AbeLicenseInterface = {
        return LicenseInterfaceSingleton.licenseInterface
    }

    def init(licenseInterface : AbeLicenseInterface) : Unit = {
        if (licenseInterface != null) {
            LicenseInterfaceSingleton.licenseInterface = licenseInterface
        }
    }

}


