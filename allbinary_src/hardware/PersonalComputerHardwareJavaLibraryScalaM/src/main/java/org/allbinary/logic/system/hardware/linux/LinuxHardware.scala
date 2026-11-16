/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.hardware.linux

import _root_.java.io.FileReader
import _root_.java.io.LineNumberReader
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.FilePathData
import _root_.org.allbinary.logic.io.file.directory.SubDirectory
import _root_.org.allbinary.logic.string.StringMaker
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
import _root_.org.allbinary.logic.system.hardware.components.linux.Cpu
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList

class LinuxHardware() extends HardwareInterface {
    import _root_.org.allbinary.logic.system.hardware.linux.LinuxHardware.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

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

    private val NAME : String = "Linux Hardware Profile"

    private val MINHARDWARE : Int = 5

    //Constructor
    {
        this.init(PCIFILE)
        if (this.componentInterfaceVector.size() < this.MINHARDWARE) {
            throw new Exception("Not Enough Data For A Valid License On Linux")
        }
        var cpu : Cpu = new Cpu()
        if (cpu != null) {
            this.cpuInterfaceVector.add(cpu)
            this.componentInterfaceVector.add(cpu)
        }
        if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().OS)) {
            this.logUtil.putF("Hardware Data: " + this.toString(), this, this.commonStrings.CONSTRUCTOR)
        }
    }

    //Testing
    def this(path : String) = {
        this()
        this.init(path)
    }

    private def init(filePath : String) : Unit = {
        var lineNumberReader : LineNumberReader = null
        try {
            this.init(lineNumberReader, filePath)
        } catch {
            case e : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().OS)) {
                    this.logUtil.put("Hardware Data: " + this.toString(), this, this.commonStrings.CONSTRUCTOR, e)
                }
                throw e
            }
        }
    }

    private def init(param_lineNumberReader : LineNumberReader, filePath : String) : Unit = {
        var lineNumberReader : LineNumberReader = param_lineNumberReader
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
            var pciFile : FileReader = new FileReader(filePath)
            lineNumberReader = new LineNumberReader(pciFile)
            if (lineNumberReader == null) {
                //Find file
                val fileVector : BasicArrayList = SubDirectory.getInstance().search(filePath, AbFile.createAbFile(FilePathData.getInstance().PATH_START))
                //if(fileVector.size() > 0)
                if (!fileVector.isEmpty()) {
                    val file : AbFile = fileVector.get(0).asInstanceOf[AbFile]
                    lineNumberReader = new LineNumberReader(new FileReader(file.getPath()))
                }
                if (lineNumberReader == null) {
                    throw new Exception("No Linux File Data")
                }
            }
            if (lineNumberReader != null) {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().OS)) {
                    this.logUtil.putF("PCI File Found", this, this.commonStrings.CONSTRUCTOR)
                }
                var nextLine : String = lineNumberReader.readLine()
                //lineNumberReader != null && 

                {
                    scala.util.boundary { (break_N76249 : scala.util.boundary.Label[Unit]) ?=>
                        while (nextLine != null) {
                            //System.out.println(nextLine);
                            if (this.isNextHardware(nextLine)) {
                                scala.util.boundary.break()(using break_N76249)
                            }
                            nextLine = lineNumberReader.readLine()
                        }
                    }
                }

                {
                    while (this.isNextHardware(nextLine)) {
                        var componentData : StringMaker = new StringMaker()
                        if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().OS)) {
                            this.logUtil.putF("Found Hardware Device: " + this.componentInterfaceVector.size(), this, this.commonStrings.CONSTRUCTOR)
                        }
                        componentData.append(nextLine)
                        componentData.append(CommonSeps.getInstance().NEW_LINE)
                        //System.out.println(nextLine);
                        nextLine = lineNumberReader.readLine()
                        var componentType : String = PCComponentFactory.getInstance().getComponentType(nextLine)
                        //lineNumberReader != null

                        {
                            scala.util.boundary { (break_N76715 : scala.util.boundary.Label[Unit]) ?=>
                                while (true) {
                                    componentData.append(nextLine)
                                    componentData.append(CommonSeps.getInstance().NEW_LINE)
                                    nextLine = lineNumberReader.readLine()
                                    if ((nextLine == null) || this.isNextHardware(nextLine)) {
                                        scala.util.boundary.break()(using break_N76715)
                                    }
                                }
                            }
                        }
                        //System.out.println(componentType);
                        var componentInterface : HardwareComponentInterface = PCComponentFactory.getInstance().getInstance(componentType, componentData.toString())
                        if (componentInterface != null) {
                            this.componentInterfaceVector.add(componentInterface)
                        }
                    }
                }
            } else {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().OS)) {
                    this.logUtil.putF("Could not load PCI File", this, this.commonStrings.CONSTRUCTOR)
                }
            }
            lineNumberReader.close()
        } finally {
            if (lineNumberReader != null) {
                lineNumberReader.close()
            }
        }
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

    override def getComponent(index : Int) : HardwareComponentInterface = {
        return this.componentInterfaceVector.get(index).asInstanceOf[HardwareComponentInterface]
    }

    override def toString() : String = {
        val hardwareBuffer : StringMaker = new StringMaker()
        val size : Int = this.componentInterfaceVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var componentInterface : HardwareComponentInterface = this.componentInterfaceVector.get(index).asInstanceOf[HardwareComponentInterface]
                hardwareBuffer.append("Component ")
                hardwareBuffer.appendint(index)
                hardwareBuffer.append(": \n")
                hardwareBuffer.append(componentInterface.toString())
                hardwareBuffer.append(CommonSeps.getInstance().NEW_LINE)
                index += 1
            }
        }
        return hardwareBuffer.toString()
    }

    override def compareTo(hardwareInterface : HardwareInterface) : Boolean = {
        return true
    }

    override def difference(hardwareInterface : HardwareInterface) : ABHashtable[Object, Object] = {
        return StdUtil.getInstance().NULL_TABLE
    }

    def isNextHardware(nextLine : String) : Boolean = {
        if (nextLine != null) {
            var index : Int = nextLine.indexOf("Bus")
            if ((index >= 0) && (index < 4)) {
                return true
            }
        }
        return false
    }

}

object LinuxHardware {
    private val PCIFILE : String = "/proc/pci"

}


