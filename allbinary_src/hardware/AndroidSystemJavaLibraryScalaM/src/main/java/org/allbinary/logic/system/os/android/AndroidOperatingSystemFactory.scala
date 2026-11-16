/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.os.android

import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.os.GenericOperatingSystem
import _root_.org.allbinary.logic.system.os.NoOperatingSystem
import _root_.org.allbinary.logic.system.os.OperatingSystems
import _root_.org.allbinary.logic.system.os.SystemProperties
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author Berthelot, Travis  * @version 1.0  */
class AndroidOperatingSystemFactory private() {
    import _root_.org.allbinary.logic.system.os.android.AndroidOperatingSystemFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val tsUtil : TsUtil = TsUtil.getInstance()

    def getOperatingSystemInstance() : GenericOperatingSystem = {
        try {
            var GenericOperatingSystem : GenericOperatingSystem = null
            val systemProperties : SystemProperties = SystemProperties.getInstance()
            var osName : String = systemProperties.getName()
            if (this.tsUtil.compareTo(osName, OperatingSystems.getInstance().ANDROID) == 0) {
                GenericOperatingSystem = new AndroidOS()
            } else {
                if (OperatingSystems.getInstance().isUnknownSpecificOSAllowed()) {
                    GenericOperatingSystem = new AndroidOS()
                } else {
                    throw new Exception("Specific Android OS Not Supported: " + osName)
                }
            }
            return GenericOperatingSystem
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put("Failed to get OperatingSystem returning NoOperatingSystem", this, commonStrings.GET_INSTANCE, e)
                return NoOperatingSystem.NO_OPERATING_SYSTEM
            }
        }
        throw new IllegalStateException()
    }

}

object AndroidOperatingSystemFactory {
    private val instance : AndroidOperatingSystemFactory = new AndroidOperatingSystemFactory()

    def getInstance() : AndroidOperatingSystemFactory = {
        return AndroidOperatingSystemFactory.instance
    }

}


