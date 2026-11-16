/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.hardware.components

import _root_.org.allbinary.string.CommonStrings

/**  *  * @author user  */
class ComponentFactory {
    import _root_.org.allbinary.logic.system.hardware.components.ComponentFactory.{*}

    val VGA : Component = new Component("VGA")

    val IDE : Component = new Component("IDE")

    val SCSI : Component = new Component("SCSI")

    val BRIDGE : Component = new Component("bridge")

    val ETHERNET : Component = new Component("Ethernet")

    val USB : Component = new Component("USB")

    val MULTIMEDIA : Component = new Component("Multimedia")

    val PCI : Component = new Component("PCI")

    //new not impelemented
    val RAID : Component = new Component("RAID")

    val SMBUS : Component = new Component("SMBus")

    val PIC : Component = new Component("PIC")

    val Class : Component = new Component("Class")

    val UNKNOWN : Component = new Component(CommonStrings.getInstance().UNKNOWN)

}

object ComponentFactory {
    private val instance : ComponentFactory = new ComponentFactory()

    /**      * @return the instance      */
    def getInstance() : ComponentFactory = {
        return ComponentFactory.instance
    }

}


