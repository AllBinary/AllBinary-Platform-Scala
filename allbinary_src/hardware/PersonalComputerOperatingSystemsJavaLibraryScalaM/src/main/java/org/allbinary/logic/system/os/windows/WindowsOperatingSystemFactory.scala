/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.os.windows

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes
import _root_.org.allbinary.logic.system.os.GenericOperatingSystem
import _root_.org.allbinary.logic.system.os.NoOperatingSystem
import _root_.org.allbinary.logic.system.os.OperatingSystems
import _root_.org.allbinary.logic.system.os.SystemProperties
import _root_.org.allbinary.string.CommonStrings

class WindowsOperatingSystemFactory private() {
    import _root_.org.allbinary.logic.system.os.windows.WindowsOperatingSystemFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getOperatingSystemInstance() : GenericOperatingSystem = {
        try {
            val operatingSystems : OperatingSystems = OperatingSystems.getInstance()
            val osName : String = SystemProperties.getInstance().getName()
            var operatingSystemInterface : GenericOperatingSystem = null
            if (osName.compareTo(operatingSystems.WINDOWS_NT) == 0) {
                operatingSystemInterface = new WindowsOS()
            } else if (osName.compareTo(operatingSystems.WINDOWS_10) == 0) {
                operatingSystemInterface = new WindowsOS()
            } else if (osName.compareTo(operatingSystems.WINDOWS_11) == 0) {
                operatingSystemInterface = new WindowsOS()
            } else if (osName.compareTo(operatingSystems.WINDOWS2000) == 0) {
                operatingSystemInterface = new WindowsOS()
            } else if (osName.compareTo(operatingSystems.WINDOWS_XP) == 0) {
                operatingSystemInterface = new WindowsOS()
            } else if (osName.compareTo(operatingSystems.WINDOWS_VISTA) == 0) {
                operatingSystemInterface = new WindowsOS()
            } else {
                if (operatingSystems.isUnknownSpecificOSAllowed()) {
                    operatingSystemInterface = new WindowsOS()
                } else {
                    throw new Exception("Specific Windows OS Not Supported: " + osName)
                }
            }
            return operatingSystemInterface
        } catch {
            case e : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().FACTORYERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.GET_INSTANCE, e)
                }
                return NoOperatingSystem.NO_OPERATING_SYSTEM
            }
        }
        throw new IllegalStateException()
    }

}

object WindowsOperatingSystemFactory {
    private val instance : WindowsOperatingSystemFactory = new WindowsOperatingSystemFactory()

    def getInstance() : WindowsOperatingSystemFactory = {
        return WindowsOperatingSystemFactory.instance
    }

}


