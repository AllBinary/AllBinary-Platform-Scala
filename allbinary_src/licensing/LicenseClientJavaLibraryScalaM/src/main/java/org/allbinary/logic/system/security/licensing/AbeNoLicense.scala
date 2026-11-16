/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing

import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class AbeNoLicense private() extends AbeLicenseInterface {
    import _root_.org.allbinary.logic.system.security.licensing.AbeNoLicense.{*}

    var serverVector : BasicArrayList = new BasicArrayListD()

    def hasKey() : Boolean = {
        return false
    }

    def getKey(keyName : String) : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    def getLicenseId() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    def getSpecial() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    def getServers() : BasicArrayList = {
        return this.serverVector
    }

    def isValid() : Boolean = {
        return false
    }

    def getLicenseType() : LicenseType = {
        return LicenseTypeFactory.getInstance().UNKNOWN
    }

}

object AbeNoLicense {
    private var abeNoLicense : AbeNoLicense = new AbeNoLicense()

    def getInstance() : AbeNoLicense = {
        return AbeNoLicense.abeNoLicense
    }

}


