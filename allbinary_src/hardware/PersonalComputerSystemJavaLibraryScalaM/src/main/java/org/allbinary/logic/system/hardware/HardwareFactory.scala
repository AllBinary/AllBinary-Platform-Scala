/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.hardware

import _root_.org.allbinary.logic.system.os.GenericOperatingSystem
import _root_.org.allbinary.logic.system.os.OperatingSystems
import _root_.org.allbinary.logic.system.hardware.linux.LinuxHardware
import _root_.org.allbinary.logic.system.hardware.windows.WindowsHardware

class HardwareFactory private() {
    import _root_.org.allbinary.logic.system.hardware.HardwareFactory.{*}

}

object HardwareFactory {
    private val instance : HardwareFactory = new HardwareFactory()

    /**      * @return the instance      */
    def getInstance() : HardwareFactory = {
        return HardwareFactory.instance
    }

    def getInstance(os : GenericOperatingSystem) : HardwareInterface = {
        try {
            val operatingSystems : OperatingSystems = OperatingSystems.getInstance()
            if (os.getName().compareTo(operatingSystems.LINUX) == 0) {
                return (new LinuxHardware()).asInstanceOf[HardwareInterface]
            } else if (os.getName().indexOf(operatingSystems.WINDOWS) >= 0) {
                return (new WindowsHardware()).asInstanceOf[HardwareInterface]
            }
            /*              else              if(os.getName().compareTo(OperatingSystems.SOLARIS)==0)              {                         }*/
            throw new Exception("No Hardware Imp for: " + os.getName())
        } catch {
            case e : Exception => {
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


