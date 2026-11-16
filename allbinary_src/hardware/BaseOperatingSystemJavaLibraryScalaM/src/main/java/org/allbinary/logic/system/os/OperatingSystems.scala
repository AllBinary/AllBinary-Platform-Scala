/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.os


class OperatingSystems private() {
    import _root_.org.allbinary.logic.system.os.OperatingSystems.{*}

    val LINUX : String = "Linux"

    val WINDOWS : String = "Windows"

    val SOLARIS : String = "Solaris"

    val WINDOWS2000 : String = "Windows 2000"

    val WINDOWS_NT : String = "Windows NT"

    val WINDOWS_10 : String = "Windows 10"

    val WINDOWS_11 : String = "Windows 11"

    val WINDOWS_VISTA : String = "Windows Vista"

    val WINDOWS_XP : String = "Windows XP"

    val ANDROID : String = this.LINUX

    //HongMeng Kernel
    val HARMONY : String = "HarmonyOS"

    private var unknownSpecificOSAllowed : Boolean = true

    def isUnknownSpecificOSAllowed() : Boolean = {
        return this.unknownSpecificOSAllowed
    }

    def setUnknownSpecificOSAllowed(aUnknownSpecificOSAllowed : Boolean) : Unit = {
        this.unknownSpecificOSAllowed = aUnknownSpecificOSAllowed
    }

}

object OperatingSystems {
    private val instance : OperatingSystems = new OperatingSystems()

    def getInstance() : OperatingSystems = {
        return OperatingSystems.instance
    }

}


