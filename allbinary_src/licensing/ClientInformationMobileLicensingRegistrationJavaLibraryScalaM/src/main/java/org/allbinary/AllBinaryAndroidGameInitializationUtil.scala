/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary

import _root_.org.allbinary.business.init.LicenseInitInfoUtil
import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.logic.system.security.licensing.PartnerIdentifierFileUtil

class AllBinaryAndroidGameInitializationUtil {
    import _root_.org.allbinary.AllBinaryAndroidGameInitializationUtil.{*}

}

object AllBinaryAndroidGameInitializationUtil {
    def init() : Unit = {
        val resourceUtil : ResourceUtil = ResourceUtil.getInstance()
        val androidResources : AndroidResources = AndroidResources.getInstance()
        val licenseInitInfoUtil : LicenseInitInfoUtil = LicenseInitInfoUtil.getInstance()
        resourceUtil.addResource(licenseInitInfoUtil.INITFILENAME, Integer.valueOf(androidResources.raw.licenseinitdata))
        resourceUtil.addResource(PartnerIdentifierFileUtil.getInstance().FILE_NAME, Integer.valueOf(androidResources.raw.partner))
        resourceUtil.addResource(licenseInitInfoUtil.ABOUT, Integer.valueOf(androidResources.raw.about))
    }

}


