/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.hardware

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.os.GenericOperatingSystem
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author user  */
class SystemHardwareFactory private() {
    import _root_.org.allbinary.logic.system.hardware.SystemHardwareFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var hardwareInterface : HardwareInterface = NoHardware.getInstance()

    def getInstance(operatingSystemInterface : GenericOperatingSystem) : HardwareInterface = {
        try {
            if (this.hardwareInterface eq NoHardware.getInstance()) {
                this.hardwareInterface = HardwareFactory.getInstance().getInstance(operatingSystemInterface)
            }
            //this.logUtil.putF(static_toString(), this, this.commonStrings.CONSTRUCTOR);
            this.logUtil.putF("Found Hardware", this, this.commonStrings.CONSTRUCTOR)
        } catch {
            case e : Exception => {
                //{
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.CONSTRUCTOR, e)
            }
        }
        return this.hardwareInterface
    }

}

object SystemHardwareFactory {
    private val instance : SystemHardwareFactory = new SystemHardwareFactory()

    def getInstance() : SystemHardwareFactory = {
        return SystemHardwareFactory.instance
    }

    /*    public HardwareInterface getHardware()    {       return this.hardwareInterface;    }    */
    def static_toString() : String = {
        val systemHardwareFactory : SystemHardwareFactory = SystemHardwareFactory.getInstance()
        val osBuffer : StringMaker = new StringMaker()
        osBuffer.append("Hardware Info: \n")
        if (systemHardwareFactory.hardwareInterface != null) {
            osBuffer.append(systemHardwareFactory.hardwareInterface.toString())
        } else {
            osBuffer.append(StringUtil.getInstance().NULL_STRING)
        }
        return osBuffer.toString()
    }

}


