/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing

import _root_.org.allbinary.business.init.LicenseInitInfo
import _root_.org.allbinary.business.init.LicenseInitInfoUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.system.os.OperatingSystemFactory
import _root_.org.allbinary.string.CommonStrings

// This is the information sent to the license server
class AbeClientInformation(param_name : String, param_version : String, param_specialName : String, param_shortName : String) extends ClientInformation(param_name, param_version, param_specialName, param_shortName) {

    val logUtil : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val name : String = param_name
        val version : String = param_version
        val specialName : String = param_specialName
        val shortName : String = param_shortName
    }

    override def init() : Unit = {
        try {
            this.setOperatingSystemInterface(OperatingSystemFactory.getInstance().getOperatingSystemInstance())
            val licenseInitInfo : LicenseInitInfo = LicenseInitInfoUtil.getInstance().read()
            this.setLicenseId(licenseInitInfo.getLicenseId())
            this.setLicenseServers(licenseInitInfo.getServerList())
            val stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
            if (stringValidationUtil.isEmpty(this.getLicenseId())) {
                val NONE : String = "No License Id"
                this.setLicenseId(NONE)
            }
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            PreLogUtil.put(new StringMaker().append("Special Name: ").append(this.getSpecialName()).toString(), this, commonStrings.CONSTRUCTOR)
        } catch {
            case e : Exception => {
                val logUtil : LogUtil = LogUtil.getInstance()
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                logUtil.put(commonStrings.EXCEPTION, this, commonStrings.CONSTRUCTOR, e)
            }
        }
    }

}


