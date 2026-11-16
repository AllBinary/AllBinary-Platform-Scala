/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.registration.RegistrationConfiguration
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.ABHashtable

class MobileClientInformation(param_name : String, param_version : String, param_specialName : String, param_shortName : String) extends AbeClientInformation(param_name, param_version, new StringMaker().append(param_specialName).append(CommonSeps.getInstance().SPACE).append(PartnerIdentifierFileUtil.getInstance().get()).toString(), param_shortName) {
    import _root_.org.allbinary.logic.system.security.licensing.MobileClientInformation.{DESC as _, ANDROID_DESC as _, *}
    def DESC : String = _root_.org.allbinary.logic.system.security.licensing.MobileClientInformation.DESC
    def ANDROID_DESC : String = _root_.org.allbinary.logic.system.security.licensing.MobileClientInformation.ANDROID_DESC

    //Constructor
    {
        val name : String = param_name
        val version : String = param_version
        val specialName : String = param_specialName
        val shortName : String = param_shortName
        val string : String = this.getSpecialName()
        val number : String = string.substring(string.length() - 1)
        if (Integer.getInteger(number) == null) {
            this.setHardSale(false)
        }
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        if (this.isHardSale()) {
            this.logUtil.putF("Use Hard Coded Selling", this, commonStrings.CONSTRUCTOR)
        } else {
            this.logUtil.putF("Don't Use Hard Coded Selling", this, commonStrings.CONSTRUCTOR)
        }
    }

    override def toHashtable() : ABHashtable[Object, Object] = {
        val hashtable : ABHashtable[Object, Object] = super.toHashtable()
        val registrationConfiguration : RegistrationConfiguration = RegistrationConfiguration.getInstance()
        hashtable.put(registrationConfiguration.NAME, registrationConfiguration.getRegistrationCode())
        return hashtable
    }

}

object MobileClientInformation {
    val DESC : String = "Mobile"

    val ANDROID_DESC : String = "Android" + MobileClientInformation.DESC

}


