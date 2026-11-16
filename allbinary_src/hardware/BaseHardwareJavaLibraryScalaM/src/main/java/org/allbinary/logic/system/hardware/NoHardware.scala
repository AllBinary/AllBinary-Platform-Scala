/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.hardware

import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.system.hardware.components.interfaces.HardwareComponentInterface
import _root_.org.allbinary.logic.system.hardware.components.interfaces.NoHardwareComponent
import _root_.org.allbinary.util.ABHashtable

/**  *  * @author Berthelot, Travis  * @version 1.0  */
class NoHardware extends HardwareInterface {
    import _root_.org.allbinary.logic.system.hardware.NoHardware.{*}

    override def getComponent(index : Int) : HardwareComponentInterface = {
        return NoHardwareComponent.getInstance()
    }

    override def toString() : String = {
        return "No Hardware"
    }

    override def compareTo(hardwareInterface : HardwareInterface) : Boolean = {
        return true
    }

    override def difference(hardwareInterface : HardwareInterface) : ABHashtable[Object, Object] = {
        return StdUtil.getInstance().NULL_TABLE
    }

}

object NoHardware {
    private val instance : HardwareInterface = new NoHardware()

    /**      * @return the instance      */
    def getInstance() : HardwareInterface = {
        return NoHardware.instance
    }

}


