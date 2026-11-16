/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.hardware.windows

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.hardware.HardwareInterface
import _root_.org.allbinary.logic.system.hardware.components.ComponentFactory
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
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.util.ABHashtable

class WindowsHardware() extends HardwareInterface {

    private var componentInterfaceVector : BasicArrayList = null

    private var videoInterfaceVector : BasicArrayList = null

    private var hardDriveControllerInterfaceVector : BasicArrayList = null

    private var cpuInterfaceVector : BasicArrayList = null

    private var usbInterfaceVector : BasicArrayList = null

    private var ethernetInterfaceVector : BasicArrayList = null

    private var multimediaInterfaceVector : BasicArrayList = null

    private var fireWireInterfaceVector : BasicArrayList = null

    private var bridgeInterfaceVector : BasicArrayList = null

    private var hardDriveInterfaceVector : BasicArrayList = null

    private var macInterfaceVector : BasicArrayList = null

    private var monitorInterfaceVector : BasicArrayList = null

    private val NAME : String = "Windows Hardware Profile"

    private val MINHARDWARE : Int = 0

    private val componentFactory : ComponentFactory = ComponentFactory.getInstance()

    //Constructor
    {
        try {
            this.componentInterfaceVector = new BasicArrayListD()
            this.videoInterfaceVector = new BasicArrayListD()
            this.hardDriveControllerInterfaceVector = new BasicArrayListD()
            this.cpuInterfaceVector = new BasicArrayListD()
            this.usbInterfaceVector = new BasicArrayListD()
            this.ethernetInterfaceVector = new BasicArrayListD()
            this.multimediaInterfaceVector = new BasicArrayListD()
            this.fireWireInterfaceVector = new BasicArrayListD()
            this.bridgeInterfaceVector = new BasicArrayListD()
            this.hardDriveInterfaceVector = new BasicArrayListD()
            this.macInterfaceVector = new BasicArrayListD()
            this.monitorInterfaceVector = new BasicArrayListD()
            if (this.componentInterfaceVector.size() < this.MINHARDWARE) {
                throw new Exception("Not Enough Data For A Valid License On Windows")
            }
        } catch {
            case e : Exception => {
                throw e
            }
        }
    }

    private def getComponentType(component : String) : String = {
        if (component.indexOf(this.componentFactory.ETHERNET.toString()) >= 0) {
            return this.componentFactory.ETHERNET.toString()
        } else if (component.indexOf(this.componentFactory.BRIDGE.toString()) >= 0) {
            return this.componentFactory.BRIDGE.toString()
        } else if (component.indexOf(this.componentFactory.IDE.toString()) >= 0) {
            return this.componentFactory.IDE.toString()
        } else if (component.indexOf(this.componentFactory.MULTIMEDIA.toString()) >= 0) {
            return this.componentFactory.MULTIMEDIA.toString()
        } else if (component.indexOf(this.componentFactory.SCSI.toString()) >= 0) {
            return this.componentFactory.SCSI.toString()
        } else if (component.indexOf(this.componentFactory.USB.toString()) >= 0) {
            return this.componentFactory.USB.toString()
        } else if (component.indexOf(this.componentFactory.VGA.toString()) >= 0) {
            return this.componentFactory.VGA.toString()
        } else {
            return null
        }
        throw new IllegalStateException()
    }

    def getMultimedia(index : Int) : MediaInterface = {
        return this.multimediaInterfaceVector.get(index).asInstanceOf[MediaInterface]
    }

    def getBridge(index : Int) : BridgeInterface = {
        return this.bridgeInterfaceVector.get(index).asInstanceOf[BridgeInterface]
    }

    def getCpu(index : Int) : CpuInterface = {
        return this.cpuInterfaceVector.get(index).asInstanceOf[CpuInterface]
    }

    def getEthernet(index : Int) : EthernetInterface = {
        return this.ethernetInterfaceVector.get(index).asInstanceOf[EthernetInterface]
    }

    def getFireWire(index : Int) : FireWireInterface = {
        return this.fireWireInterfaceVector.get(index).asInstanceOf[FireWireInterface]
    }

    def getHardDriveController(index : Int) : HardDriveControllerInterface = {
        return this.hardDriveControllerInterfaceVector.get(index).asInstanceOf[HardDriveControllerInterface]
    }

    def getHardDrive(index : Int) : HardDriveInterface = {
        return this.hardDriveInterfaceVector.get(index).asInstanceOf[HardDriveInterface]
    }

    def getMachineAccessControlAddress(index : Int) : MachineAccessControlAddressInterface = {
        return this.macInterfaceVector.get(index).asInstanceOf[MachineAccessControlAddressInterface]
    }

    def getMonitor(index : Int) : MonitorInterface = {
        return this.monitorInterfaceVector.get(index).asInstanceOf[MonitorInterface]
    }

    def getUsb(index : Int) : UsbInterface = {
        return this.usbInterfaceVector.get(index).asInstanceOf[UsbInterface]
    }

    def getVideo(index : Int) : VideoInterface = {
        return this.videoInterfaceVector.get(index).asInstanceOf[VideoInterface]
    }

    def getComponent(index : Int) : HardwareComponentInterface = {
        return this.componentInterfaceVector.get(index).asInstanceOf[HardwareComponentInterface]
    }

    override def toString() : String = {
        val hardwareBuffer : StringMaker = new StringMaker()
        val size : Int = this.componentInterfaceVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var componentInterface : HardwareComponentInterface = this.componentInterfaceVector.get(index).asInstanceOf[HardwareComponentInterface]
                hardwareBuffer.append(componentInterface.toString())
                hardwareBuffer.append(CommonSeps.getInstance().NEW_LINE)
                index += 1
            }
        }
        return hardwareBuffer.toString()
    }

    def compareTo(hardwareInterface : HardwareInterface) : Boolean = {
        return true
    }

    def difference(hardwareInterface : HardwareInterface) : ABHashtable[Object, Object] = {
        return StdUtil.getInstance().NULL_TABLE
    }

}


