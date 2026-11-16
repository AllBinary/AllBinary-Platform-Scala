/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.system

import _root_.org.allbinary.logic.string.StringMaker

//ActualPlatform
class Memory {
    import _root_.org.allbinary.system.Memory.{*}

}

object Memory {
    //ActualPlatform
    def getInfo() : String = {
        //VMRuntime vm = VMRuntime.getRuntime();
        var stringBuffer : StringMaker = new StringMaker()
        //stringBuffer.append(Runtime.getRuntime().freeMemory());
        var maxUtilizedMemoryAvailable : Long = Runtime.getRuntime().maxMemory()
        var memoryUsed : Long = Runtime.getRuntime().totalMemory()
        stringBuffer.append("APK Memory: Available: ")
        stringBuffer.appendlong(maxUtilizedMemoryAvailable)
        stringBuffer.append("/")
        stringBuffer.appendlong(Runtime.getRuntime().maxMemory())
        stringBuffer.append(" Used: ")
        stringBuffer.appendlong(memoryUsed)
        stringBuffer.append(" Free: ")
        stringBuffer.appendlong(maxUtilizedMemoryAvailable - memoryUsed)
        stringBuffer.append("/")
        stringBuffer.appendlong(Runtime.getRuntime().maxMemory() - memoryUsed)
        return stringBuffer.toString()
    }

}


