/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.hardware.linux

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes
import _root_.org.allbinary.logic.system.hardware.components.ComponentFactory
import _root_.org.allbinary.logic.system.hardware.components.interfaces.HardwareComponentInterface
import _root_.org.allbinary.logic.system.hardware.components.linux.Bridge
import _root_.org.allbinary.logic.system.hardware.components.linux.Ethernet
import _root_.org.allbinary.logic.system.hardware.components.linux.HardDriveController
import _root_.org.allbinary.logic.system.hardware.components.linux.Media
import _root_.org.allbinary.logic.system.hardware.components.linux.PCI
import _root_.org.allbinary.logic.system.hardware.components.linux.Unknown
import _root_.org.allbinary.logic.system.hardware.components.linux.Usb
import _root_.org.allbinary.logic.system.hardware.components.linux.Video
import _root_.org.allbinary.string.CommonStrings

class PCComponentFactory private() {
    import _root_.org.allbinary.logic.system.hardware.linux.PCComponentFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val componentFactory : ComponentFactory = ComponentFactory.getInstance()

    def getInstance(component : String, componentData : String) : HardwareComponentInterface = {
        try {
            if (component != null) {
                if (component.compareTo(this.componentFactory.ETHERNET.toString()) == 0) {
                    return (new Ethernet(componentData)).asInstanceOf[HardwareComponentInterface]
                } else if (component.compareTo(this.componentFactory.BRIDGE.toString()) == 0) {
                    return (new Bridge(componentData)).asInstanceOf[HardwareComponentInterface]
                } else if (component.compareTo(this.componentFactory.IDE.toString()) == 0) {
                    return (new HardDriveController(componentData)).asInstanceOf[HardwareComponentInterface]
                } else if (component.compareTo(this.componentFactory.MULTIMEDIA.toString()) == 0) {
                    return (new Media(componentData)).asInstanceOf[HardwareComponentInterface]
                } else if (component.compareTo(this.componentFactory.SCSI.toString()) == 0) {
                    return (new HardDriveController(componentData)).asInstanceOf[HardwareComponentInterface]
                } else if (component.compareTo(this.componentFactory.USB.toString()) == 0) {
                    return (new Usb(componentData)).asInstanceOf[HardwareComponentInterface]
                } else if (component.compareTo(this.componentFactory.VGA.toString()) == 0) {
                    return (new Video(componentData)).asInstanceOf[HardwareComponentInterface]
                } else if (component.compareTo(this.componentFactory.PCI.toString()) == 0) {
                    return (new PCI(componentData)).asInstanceOf[HardwareComponentInterface]
                }
            }
            return (new Unknown(componentData)).asInstanceOf[HardwareComponentInterface]
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().FACTORYERROR)) {
                    //String error = "Failed to getInstance for: " + component;
                    this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.GET_INSTANCE, e)
                }
                return new Unknown(commonStrings.EXCEPTION)
            }
        }
        throw new IllegalStateException()
    }

    def getComponentType(component : String) : String = {
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
        } else if (component.compareTo(this.componentFactory.PCI.toString()) == 0) {
            return this.componentFactory.PCI.toString()
        }
        return this.componentFactory.UNKNOWN.toString()
    }

}

object PCComponentFactory {
    private val instance : PCComponentFactory = new PCComponentFactory()

    /**      * @return the instance      */
    def getInstance() : PCComponentFactory = {
        return PCComponentFactory.instance
    }

}


