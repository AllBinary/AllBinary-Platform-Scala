/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing

import _root_.java.io.IOException
import _root_.java.util.Calendar
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.client.AbeLicenseClient
import _root_.org.allbinary.string.CommonStrings

class AbeLicenseInterfaceFactory private() {
    import _root_.org.allbinary.logic.system.security.licensing.AbeLicenseInterfaceFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var time : Long = 0

    //100000;
    private var check : Boolean = false

    //100000;
    private var checkPeriod : Int = 36000000

    private var abeLicenseInterface : AbeLicenseInterface = null

    def getLicenseInstance(abeClientInformation : AbeClientInformationInterface) : AbeLicenseInterface = {
        if (isTimeToGetKey()) {
            return this.get(abeClientInformation)
        } else {
            return this.abeLicenseInterface
        }
        throw new IllegalStateException()
    }

    private def get(abeClientInformation : AbeClientInformationInterface) : AbeLicenseInterface = {
        try {
            //{
            this.logUtil.putF("Getting Keys", this, this.commonStrings.GET)
            //}
            this.abeLicenseInterface = AbeNoLicense.getInstance()
            var licenseClient : AbeLicenseClient = new AbeLicenseClient()
            this.abeLicenseInterface = licenseClient.get(abeClientInformation)
            //{
            if (this.abeLicenseInterface != null) {
                this.logUtil.putF("Default Key: " + this.abeLicenseInterface.getKey(AbeClientInformationData.getInstance().KEY), this, this.commonStrings.GET)
            }
            //}
            return this.abeLicenseInterface
        } catch {
            case e : IOException => {
                //{
                this.logUtil.put("Licensing IO Error", this, this.commonStrings.GET, e)
                //}
                throw new LicensingException("License Server Connection Error")
            }
            case e : Exception => {
                //{
                this.logUtil.put("Licensing Failure", this, this.commonStrings.GET, e)
                //}
                throw new LicensingException("Unknown License Failure: " + this.getClass().getName())
            }
        }
        throw new IllegalStateException()
    }

    private def isTimeToGetKey() : Boolean = {
        var calendar : Calendar = Calendar.getInstance()
        var currentTime : Long = calendar.getTimeInMillis()
        if (((((this.abeLicenseInterface == null) || (this.abeLicenseInterface eq AbeNoLicense.getInstance())) || !this.abeLicenseInterface.hasKey()) || isCheck()) || ((currentTime - checkPeriod) > time)) {
            this.abeLicenseInterface = null
            this.time = currentTime
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def setCheck(check : Boolean) : Unit = {
        this.check = check
    }

    private def isCheck() : Boolean = {
        return this.check
    }

}

object AbeLicenseInterfaceFactory {
    private val SINGLETON : AbeLicenseInterfaceFactory = new AbeLicenseInterfaceFactory()

    def getInstance() : AbeLicenseInterfaceFactory = {
        return AbeLicenseInterfaceFactory.SINGLETON
    }

}


