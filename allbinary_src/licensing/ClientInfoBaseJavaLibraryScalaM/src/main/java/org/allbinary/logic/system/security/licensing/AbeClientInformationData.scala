/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing


class AbeClientInformationData private() {
    import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationData.{*}

    val KEY : String = "KEY"

    val NAME : String = "NAME"

    val VERSION : String = "VERSION"

    val SPECIALNAME : String = "SPECIALNAME"

    val LICENSEID : String = "LICENSEID"

    val LICENSE_TYPE : String = "LICENSETYPE"

    val PREVIOUSLICENSEID : String = "PREVIOUSLICENSEID"

    val OSNAME : String = "OSNAME"

    val OSARCH : String = "OSARCH"

    val OSVERSION : String = "OSVERSION"

    val OS : String = "OS"

    val HARDWARE : String = "HARDWARE"

    val LICENSESERVERS : String = "LICENSESERVERS"

    val NEWLICENSE : String = "NEWLICENSE"

    val ISNEW : String = "ISNEW"

    val SPECIAL : String = "SPECIAL"

}

object AbeClientInformationData {
    private val instance : AbeClientInformationData = new AbeClientInformationData()

    def getInstance() : AbeClientInformationData = {
        return AbeClientInformationData.instance
    }

}


