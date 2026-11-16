/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.os

import _root_.org.allbinary.logic.communication.log.Log
import _root_.org.allbinary.logic.communication.log.LogFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.os.linux.LinuxOperatingSystemFactory
import _root_.org.allbinary.logic.system.os.solaris.SolarisOperatingSystemFactory
import _root_.org.allbinary.logic.system.os.windows.WindowsOperatingSystemFactory
import _root_.org.allbinary.string.CommonStrings

class OperatingSystemFactory private() {
    import _root_.org.allbinary.logic.system.os.OperatingSystemFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var genericOperatingSystem : GenericOperatingSystem = NoOperatingSystem.NO_OPERATING_SYSTEM

    private var hasDetected : Boolean = false

    def getOperatingSystemInstance() : GenericOperatingSystem = this.synchronized {
        try {
            val operatingSystems : OperatingSystems = OperatingSystems.getInstance()
            val systemProperties : SystemProperties = SystemProperties.getInstance()
            val osName : String = systemProperties.getName()
            val osArch : String = systemProperties.getArch()
            val osVersion : String = systemProperties.getVersion()
            if (!this.hasDetected) {
                this.logUtil.putF("osName: " + osName, this, this.commonStrings.GET_INSTANCE)
                this.hasDetected = true
                if (osName.indexOf(operatingSystems.LINUX) >= 0) {
                    if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().FACTORYERROR)) {
                        this.logUtil.putF("Found a Linux OS", this, this.commonStrings.GET_INSTANCE)
                    }
                    this.genericOperatingSystem = LinuxOperatingSystemFactory.getInstance().getOperatingSystemInstance()
                } else if (osName.indexOf(operatingSystems.WINDOWS) >= 0) {
                    if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().FACTORYERROR)) {
                        this.logUtil.putF("Found a Windows OS", this, this.commonStrings.GET_INSTANCE)
                    }
                    this.genericOperatingSystem = WindowsOperatingSystemFactory.getInstance().getOperatingSystemInstance()
                } else if (osName.indexOf(operatingSystems.SOLARIS) >= 0) {
                    if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().FACTORYERROR)) {
                        this.logUtil.putF("Found a Solaris OS", this, this.commonStrings.GET_INSTANCE)
                    }
                    this.genericOperatingSystem = SolarisOperatingSystemFactory.getInstance().getOperatingSystemInstance()
                } else {
                    throw new Exception(new StringMaker().append("OS Not Supported: ").append(osName).toString())
                }
                var log : Log = LogFactory.getInstanceF(new StringMaker().append("OperatingSystem Info: ").append(StringUtil.getInstance().toString(this.genericOperatingSystem)).toString(), this, this.commonStrings.GET_INSTANCE)
                System.out.println(log.toString())
                this.logUtil.putL(log)
            }
            return this.genericOperatingSystem
        } catch {
            case e : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().FACTORYERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.GET_INSTANCE, e)
                }
                //throw e;
                return NoOperatingSystem.NO_OPERATING_SYSTEM
            }
        }
        throw new IllegalStateException()
    }

}

object OperatingSystemFactory {
    private val instance : OperatingSystemFactory = new OperatingSystemFactory()

    /**      * @return the instance      */
    def getInstance() : OperatingSystemFactory = {
        return OperatingSystemFactory.instance
    }

}


