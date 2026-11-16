/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.AbeLicenseInterfaceFactory
import _root_.org.allbinary.logic.system.security.licensing.LicensingException

class AbKeys private() {
    import _root_.org.allbinary.logic.system.security.AbKeys.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getKey(abeClientInformation : AbeClientInformationInterface, keyName : String) : String = this.synchronized {
        try {
            //{
            this.logUtil.putF("Getting Key: " + keyName, this, "getKey")
            //TWB - Replace with key from server
            if ((((keyName.compareTo("DirectX 8") == 0) || (keyName.compareTo("DirectX") == 0)) || (keyName.compareTo("Low Level") == 0)) || (keyName.compareTo("System Drivers") == 0)) {
                return "Temp For Input Library"
            }
            return AbeLicenseInterfaceFactory.getInstance().getLicenseInstance(abeClientInformation).getKey(keyName)
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                //{
                this.logUtil.put("Licensing Failure", this, "getKey()", e)
                //}
                throw new LicensingException("Unknown License Failure")
            }
        }
        throw new IllegalStateException()
    }

}

object AbKeys {
    private val instance : AbKeys = new AbKeys()

    def getInstance() : AbKeys = {
        return AbKeys.instance
    }

}


