/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing.client

import _root_.org.allbinary.business.init.LicenseInitInfo
import _root_.org.allbinary.business.init.LicenseInitInfoUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.xmlrpc.XmlRpcAbeClient
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.AbeLicenseInterface
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList

class AbeLicenseClient() {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val MINSERVERS : Int = 3

    def get(abeClientInformation : AbeClientInformationInterface) : AbeLicenseInterface = this.synchronized {
        try {
            //{
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.GET)
            //}
            val xmlRpcAbeLicenseClient : XmlRpcAbeClient = new XmlRpcAbeLicenseRetrievalClient(abeClientInformation)
            val abeLicenseInterface : AbeLicenseInterface = xmlRpcAbeLicenseClient.get(null).asInstanceOf[AbeLicenseInterface]
            //
            val licenseId : String = abeLicenseInterface.getLicenseId()
            val servers : BasicArrayList = abeLicenseInterface.getServers()
            var isNewLicenseId : Boolean = false
            var isBetterServerList : Boolean = false
            val stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
            if (stringValidationUtil.isEmpty(abeClientInformation.getLicenseId()) && !abeClientInformation.isSameId(licenseId)) {
                isNewLicenseId = true
            }
            if ((servers.size() >= this.MINSERVERS) && abeClientInformation.isLargerOrDifferentServerList(servers)) {
                isBetterServerList = true
            }
            if (isBetterServerList || isNewLicenseId) {
                val initInfo : LicenseInitInfo = LicenseInitInfoUtil.getInstance().read()
                initInfo.setLicenseId(licenseId)
                initInfo.setServerList(servers)
                LicenseInitInfoUtil.getInstance().write(initInfo)
                abeClientInformation.init()
            }
            //{
            this.logUtil.putF(this.commonStrings.END, this, this.commonStrings.GET)
            //}
            return abeLicenseInterface
        } catch {
            case e : Exception => {
                //}
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


