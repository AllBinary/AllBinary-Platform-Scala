/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.os


//ActualPlatform
class SystemProperties private() {
    import _root_.org.allbinary.logic.system.os.SystemProperties.{*}

    private val OS_NAME : String = "os.name"

    private val OS_ARCH : String = "os.arch"

    private val OS_VERSION : String = "os.version"

    //ActualPlatform
    def getName() : String = {
        return System.getProperty(this.OS_NAME)
    }

    //ActualPlatform
    def getArch() : String = {
        return System.getProperty(this.OS_ARCH)
    }

    //ActualPlatform
    def getVersion() : String = {
        return System.getProperty(this.OS_VERSION)
    }

    def getUserHomePath() : String = {
        throw new RuntimeException()
    }

}

object SystemProperties {
    private val instance : SystemProperties = new SystemProperties()

    //ActualPlatform
    def getInstance() : SystemProperties = {
        return SystemProperties.instance
    }

}


