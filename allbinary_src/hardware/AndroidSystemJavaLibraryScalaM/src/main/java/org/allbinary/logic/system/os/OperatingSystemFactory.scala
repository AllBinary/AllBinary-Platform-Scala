/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.os

import _root_.org.allbinary.logic.system.os.android.AndroidOperatingSystemFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings

class OperatingSystemFactory private() {
    import _root_.org.allbinary.logic.system.os.OperatingSystemFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var genericOperatingSystem : GenericOperatingSystem = NoOperatingSystem.NO_OPERATING_SYSTEM

    private var hasDetected : Boolean = false

    def getOperatingSystemInstance() : GenericOperatingSystem = this.synchronized {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        try {
            val systemProperties : SystemProperties = SystemProperties.getInstance()
            var osName : String = systemProperties.getName()
            //String osVersion = SystemProperties.getVersion();
            if (!this.hasDetected) {
                this.hasDetected = true
                if (osName.indexOf(OperatingSystems.getInstance().ANDROID) >= 0) {
                    this.logUtil.putF("Found a Android OS", this, commonStrings.GET_INSTANCE)
                    this.genericOperatingSystem = AndroidOperatingSystemFactory.getInstance().getOperatingSystemInstance()
                    //PreLogUtil.put(log.toString());
                    this.logUtil.putF(new StringMaker().append("Operating System Info: ").append(this.genericOperatingSystem.toString()).toString(), this, commonStrings.GET_INSTANCE)
                } else if (osName.indexOf(OperatingSystems.getInstance().HARMONY) >= 0) {
                    this.logUtil.putF("Found a Harmony OS", this, commonStrings.GET_INSTANCE)
                    this.genericOperatingSystem = AndroidOperatingSystemFactory.getInstance().getOperatingSystemInstance()
                    //PreLogUtil.put(log.toString());
                    this.logUtil.putF(new StringMaker().append("Operating System Info: ").append(this.genericOperatingSystem.toString()).toString(), this, commonStrings.GET_INSTANCE)
                } else {
                    throw new Exception(new StringMaker().append("OS Not Supported: ").append(osName).toString())
                }
            }
        } catch {
            case e : Exception => {
                this.genericOperatingSystem = NoOperatingSystem.NO_OPERATING_SYSTEM
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.GET_INSTANCE, e)
            }
        }
        return this.genericOperatingSystem
    }

}

object OperatingSystemFactory {
    private val instance : OperatingSystemFactory = new OperatingSystemFactory()

    def getInstance() : OperatingSystemFactory = {
        return OperatingSystemFactory.instance
    }

}


