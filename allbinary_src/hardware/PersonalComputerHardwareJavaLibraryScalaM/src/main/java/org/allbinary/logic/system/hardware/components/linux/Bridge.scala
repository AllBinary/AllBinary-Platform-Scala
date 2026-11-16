/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.hardware.components.linux

import _root_.org.allbinary.logic.system.hardware.components.interfaces.BridgeInterface
import _root_.org.allbinary.logic.system.hardware.components.interfaces.HardwareComponentInterface

class Bridge(param_data : String) extends HardwareComponentInterface with BridgeInterface {

    private var data : String = null

    //Constructor
    {
        val data : String = param_data
        this.data = data
    }

    def compareTo(componentInterface : HardwareComponentInterface) : Boolean = {
        return true
    }

    override def toString() : String = {
        return this.data
    }

}


