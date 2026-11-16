/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.hardware.components.interfaces

import _root_.org.allbinary.logic.string.StringUtil

/**  *  * @author User  */
class NoHardwareComponent extends HardwareComponentInterface {
    import _root_.org.allbinary.logic.system.hardware.components.interfaces.NoHardwareComponent.{*}

    override def compareTo(componentInterface : HardwareComponentInterface) : Boolean = {
        if (this eq componentInterface) {
            return true
        }
        return false
    }

    override def toString() : String = {
        return StringUtil.getInstance().NULL_STRING
    }

}

object NoHardwareComponent {
    private val instance : NoHardwareComponent = new NoHardwareComponent()

    /**      * @return the instance      */
    def getInstance() : NoHardwareComponent = {
        return NoHardwareComponent.instance
    }

}


