/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.hardware

import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.hardware.android.AndroidHardware
import _root_.org.allbinary.logic.system.os.GenericOperatingSystem
import _root_.org.allbinary.logic.system.os.OperatingSystems
import _root_.org.allbinary.string.CommonStrings

class HardwareFactory private() {
    import _root_.org.allbinary.logic.system.hardware.HardwareFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val tsUtil : TsUtil = TsUtil.getInstance()

    def getInstance(os : GenericOperatingSystem) : HardwareInterface = {
        try {
            val operatingSystems : OperatingSystems = OperatingSystems.getInstance()
            if (this.tsUtil.compareTo(os.getName(), operatingSystems.ANDROID) == 0) {
                return new AndroidHardware()
            } else if (this.tsUtil.compareTo(os.getName(), operatingSystems.HARMONY) == 0) {
                return new AndroidHardware()
            }
            throw new Exception("No Hardware Imp for: " + os.getName())
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put("Ignoring Exception Returning NoHardware", this, commonStrings.GET_INSTANCE, e)
                return new NoHardware()
            }
        }
        throw new IllegalStateException()
    }

}

object HardwareFactory {
    private val instance : HardwareFactory = new HardwareFactory()

    def getInstance() : HardwareFactory = {
        return HardwareFactory.instance
    }

}


