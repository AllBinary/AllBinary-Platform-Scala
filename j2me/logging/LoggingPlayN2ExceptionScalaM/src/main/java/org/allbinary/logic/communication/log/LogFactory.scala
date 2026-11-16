/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log


//ActualPlatform
class LogFactory {
    import _root_.org.allbinary.logic.communication.log.LogFactory.{*}

}

object LogFactory {
    //ActualPlatform
    def getInstance(specialMessage : String, anyType : Object, functionName : String, exception : Object) : Log = {
        return new Log(specialMessage, anyType, functionName, exception)
    }

    //ActualPlatform
    def getInstanceF(specialMessage : String, anyType : Object, functionName : String) : Log = {
        return null
    }

}


