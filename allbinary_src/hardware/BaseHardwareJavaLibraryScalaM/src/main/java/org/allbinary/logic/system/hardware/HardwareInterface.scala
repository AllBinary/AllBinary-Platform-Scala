/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.hardware

import _root_.org.allbinary.logic.system.hardware.components.interfaces.HardwareComponentInterface
import _root_.org.allbinary.util.ABHashtable

trait HardwareInterface {

    /*     public MediaInterface getMultimedia(int index);      public BridgeInterface getBridge(int index);      public CpuInterface getCpu(int index);      public EthernetInterface getEthernet(int index);      public FireWireInterface getFireWire(int index);      public HardDriveControllerInterface getHardDriveController(int index);      public HardDriveInterface getHardDrive(int index);      public MachineAccessControlAddressInterface getMachineAccessControlAddress(int index);      public MonitorInterface getMonitor(int index);      public UsbInterface getUsb(int index);      public VideoInterface getVideo(int index);     */
    def getComponent(index : Int) : HardwareComponentInterface

    override def toString() : String

    def compareTo(hardwareInterface : HardwareInterface) : Boolean

    def difference(hardwareInterface : HardwareInterface) : ABHashtable[Object, Object]

}


