/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing.registration

import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.canvas.SpecialMessageUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.util.ABHashtable

class LicenseRegistrationUtil private() {
    import _root_.org.allbinary.logic.system.security.licensing.registration.LicenseRegistrationUtil.{*}

}

object LicenseRegistrationUtil {
    def process(abeClientInformation : AbeClientInformationInterface, registrationId : String) : Unit = this.synchronized {
        try {
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            PreLogUtil.put(CommonLabels.getInstance().START_LABEL + "License Registration", "LicenseRegistrationUtil", commonStrings.PROCESS)
            val registrationConfiguration : RegistrationConfiguration = RegistrationConfiguration.getInstance()
            registrationConfiguration.setRegistrationCode(registrationId)
            registrationConfiguration.write()
            val hashtable : ABHashtable[Object, Object] = abeClientInformation.toHashtable()
            hashtable.put(RegistrationConfiguration.getInstance().NAME, registrationId)
            hashtable.put("message", SpecialMessageUtil.getInstance().get())
            new XmlRpcRemoteLicenseRegistrationClient(abeClientInformation).get(hashtable)
        } catch {
            case e : Exception => {
                PreLogUtil.putOE("License Registration Exception", "LicenseRegistrationUtil", "License Registration", e)
            }
        }
    }

}


