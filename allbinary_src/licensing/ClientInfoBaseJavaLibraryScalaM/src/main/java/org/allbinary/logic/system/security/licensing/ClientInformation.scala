/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing

import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.hardware.HardwareInterface
import _root_.org.allbinary.logic.system.hardware.SystemHardwareFactory
import _root_.org.allbinary.logic.system.os.GenericOperatingSystem
import _root_.org.allbinary.logic.system.os.NoOperatingSystem
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListUtil
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.ABHashtable

// This is the information sent to the license server
class ClientInformation(param_name : String, param_version : String, param_specialName : String, param_shortName : String) extends AbeClientInformationInterface {

    private var operatingSystemInterface : GenericOperatingSystem = NoOperatingSystem.NO_OPERATING_SYSTEM

    private val tsUtil : TsUtil = TsUtil.getInstance()

    private var name : String = null

    private var shortName : String = null

    private var version : String = null

    private var specialName : String = null

    private var hardSale : Boolean = true

    private var licenseId : String = StringUtil.getInstance().EMPTY_STRING

    private var licenseServers : BasicArrayList = BasicArrayListUtil.getInstance().getImmutableInstance()

    //Constructor
    {
        val name : String = param_name
        val version : String = param_version
        val specialName : String = param_specialName
        val shortName : String = param_shortName
        this.name = name
        this.version = version
        this.specialName = specialName
        this.shortName = new StringMaker().append(shortName).append(CommonSeps.getInstance().UNDERSCORE).append(version).toString()
        this.init()
    }

    override def init() : Unit = {
    }

    /*      * (non-Javadoc)      *       * @seeabcs.logic.system.security.licensing.AbeClientInformationInterface#      * getOperatingSystemInterface()      */
    override def getOperatingSystemInterface() : GenericOperatingSystem = {
        return this.operatingSystemInterface
    }

    /*      * (non-Javadoc)      *       * @see      * abcs.logic.system.security.licensing.AbeClientInformationInterface#getName      * ()      */
    override def getName() : String = {
        return this.name
    }

    /*      * (non-Javadoc)      *       * @seeabcs.logic.system.security.licensing.AbeClientInformationInterface#      * getSpecialName()      */
    override def getSpecialName() : String = {
        return this.specialName
    }

    /*      * (non-Javadoc)      *       * @see      * abcs.logic.system.security.licensing.AbeClientInformationInterface#getVersion      * ()      */
    override def getVersion() : String = {
        return this.version
    }

    /*      * (non-Javadoc)      *       * @seeabcs.logic.system.security.licensing.AbeClientInformationInterface#      * getLicenseId()      */
    override def getLicenseId() : String = {
        return this.licenseId
    }

    /*      * (non-Javadoc)      *       * @seeabcs.logic.system.security.licensing.AbeClientInformationInterface#      * getLicenseServers()      */
    override def getLicenseServers() : BasicArrayList = {
        return this.licenseServers
    }

    /*      * (non-Javadoc)      *       * @seeabcs.logic.system.security.licensing.AbeClientInformationInterface#      * getLicenseServer(int)      */
    override def getLicenseServer(index : Int) : String = {
        return this.licenseServers.objectArray(index).asInstanceOf[String]
    }

    /*      * (non-Javadoc)      *       * @seeabcs.logic.system.security.licensing.AbeClientInformationInterface#      * getNumberOfLicenseServers()      */
    override def getNumberOfLicenseServers() : Int = {
        return this.licenseServers.size()
    }

    /*      * (non-Javadoc)      *       * @seeabcs.logic.system.security.licensing.AbeClientInformationInterface#      * toHashtable()      */
    override def toHashtable() : ABHashtable[Object, Object] = {
        val abeClientInformationData : AbeClientInformationData = AbeClientInformationData.getInstance()
        val genericOperatingSystem : GenericOperatingSystem = this.getOperatingSystemInterface()
        val clientInfoHashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()
        clientInfoHashtable.put(abeClientInformationData.NAME, this.name)
        clientInfoHashtable.put(abeClientInformationData.VERSION, this.version)
        clientInfoHashtable.put(abeClientInformationData.SPECIALNAME, this.specialName)
        clientInfoHashtable.put(abeClientInformationData.LICENSEID, this.getLicenseId())
        clientInfoHashtable.put(abeClientInformationData.OSNAME, genericOperatingSystem.getName())
        clientInfoHashtable.put(abeClientInformationData.OSARCH, genericOperatingSystem.getArch())
        clientInfoHashtable.put(abeClientInformationData.OSVERSION, genericOperatingSystem.getVersion())
        clientInfoHashtable.put(abeClientInformationData.OS, genericOperatingSystem.toString())
        val hardwareInterface : HardwareInterface = SystemHardwareFactory.getInstance().getInstance(genericOperatingSystem)
        var hardwareString : String = hardwareInterface.toString()
        clientInfoHashtable.put(abeClientInformationData.HARDWARE, hardwareString)
        return clientInfoHashtable
    }

    override def isSameId(alicenseId : String) : Boolean = {
        if (this.tsUtil.compareTo(this.getLicenseId(), alicenseId) == 0) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    override def isLargerOrDifferentServerList(list : BasicArrayList) : Boolean = {
        val size : Int = list.size() - 1
        val currentSize : Int = this.licenseServers.size() - 1
        if (size > currentSize) {
            return true
        }

        {
            var index : Int = size
            while (index >= 0) {
                val newServerName : String = list.objectArray(index).asInstanceOf[String]

                {
                    var index2 : Int = currentSize
                    while (index2 >= 0) {
                        val nextOldServerName : String = this.licenseServers.objectArray(index).asInstanceOf[String]
                        if (this.tsUtil.compareTo(newServerName, nextOldServerName) != 0) {
                            return true
                        }
                        index2 -= 1
                    }
                }
                index -= 1
            }
        }
        return false
    }

    def setHardSale(hardSale : Boolean) : Unit = {
        this.hardSale = hardSale
    }

    override def isHardSale() : Boolean = {
        return this.hardSale
    }

    def setOperatingSystemInterface(operatingSystemInterface : GenericOperatingSystem) : Unit = {
        this.operatingSystemInterface = operatingSystemInterface
    }

    def setLicenseId(licenseId : String) : Unit = {
        this.licenseId = licenseId
    }

    def setLicenseServers(licenseServers : BasicArrayList) : Unit = {
        this.licenseServers = licenseServers
    }

    override def toShortString() : String = {
        return this.shortName
    }

}


