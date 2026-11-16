/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.hardware

import _root_.org.allbinary.logic.system.os.OperatingSystemInterface

class HardwareFactory private() {
    import _root_.org.allbinary.logic.system.hardware.HardwareFactory.{*}

    private val SINGLETON : HardwareInterface = NoHardware.getInstance()

    def getInstance(os : OperatingSystemInterface) : HardwareInterface = {
        try {
            //throw new Exception("NoSystemJavaLibrary - No Hardware Imp for: " + os.getName());
            return this.SINGLETON
        } catch {
            case e : Exception => {
                throw e
            }
        }
        throw new IllegalStateException()
    }

}

object HardwareFactory {
    private val instance : HardwareFactory = new HardwareFactory()

    /**      * @return the instance      */
    def getInstance() : HardwareFactory = {
        return HardwareFactory.instance
    }

}


