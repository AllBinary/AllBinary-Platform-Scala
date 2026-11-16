/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.hardware.linux

import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.hardware.HardwareInterface
import _root_.org.allbinary.logic.system.hardware.components.interfaces.BridgeInterface
import _root_.org.allbinary.logic.system.hardware.components.interfaces.CpuInterface
import _root_.org.allbinary.logic.system.hardware.components.interfaces.EthernetInterface
import _root_.org.allbinary.logic.system.hardware.components.interfaces.FireWireInterface
import _root_.org.allbinary.logic.system.hardware.components.interfaces.HardDriveControllerInterface
import _root_.org.allbinary.logic.system.hardware.components.interfaces.HardDriveInterface
import _root_.org.allbinary.logic.system.hardware.components.interfaces.HardwareComponentInterface
import _root_.org.allbinary.logic.system.hardware.components.interfaces.MachineAccessControlAddressInterface
import _root_.org.allbinary.logic.system.hardware.components.interfaces.MediaInterface
import _root_.org.allbinary.logic.system.hardware.components.interfaces.MonitorInterface
import _root_.org.allbinary.logic.system.hardware.components.interfaces.UsbInterface
import _root_.org.allbinary.logic.system.hardware.components.interfaces.VideoInterface
import _root_.org.allbinary.util.ABHashtable

class LinuxHardware() extends HardwareInterface {

    def getMultimedia(index : Int) : MediaInterface = {
        throw new RuntimeException()
    }

    def getBridge(index : Int) : BridgeInterface = {
        throw new RuntimeException()
    }

    def getCpu(index : Int) : CpuInterface = {
        throw new RuntimeException()
    }

    def getEthernet(index : Int) : EthernetInterface = {
        throw new RuntimeException()
    }

    def getFireWire(index : Int) : FireWireInterface = {
        throw new RuntimeException()
    }

    def getHardDriveController(index : Int) : HardDriveControllerInterface = {
        throw new RuntimeException()
    }

    def getHardDrive(index : Int) : HardDriveInterface = {
        throw new RuntimeException()
    }

    def getMachineAccessControlAddress(index : Int) : MachineAccessControlAddressInterface = {
        throw new RuntimeException()
    }

    def getMonitor(index : Int) : MonitorInterface = {
        throw new RuntimeException()
    }

    def getUsb(index : Int) : UsbInterface = {
        throw new RuntimeException()
    }

    def getVideo(index : Int) : VideoInterface = {
        throw new RuntimeException()
    }

    override def getComponent(index : Int) : HardwareComponentInterface = {
        throw new RuntimeException()
    }

    override def toString() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    override def compareTo(hardwareInterface : HardwareInterface) : Boolean = {
        return true
    }

    override def difference(hardwareInterface : HardwareInterface) : ABHashtable[Object, Object] = {
        return StdUtil.getInstance().NULL_TABLE
    }

    def isNextHardware(nextLine : String) : Boolean = {
        return false
    }

}


