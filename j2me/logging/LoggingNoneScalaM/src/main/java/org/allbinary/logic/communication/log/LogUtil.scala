/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log


//ActualPlatform
class LogUtil private() {
    import _root_.org.allbinary.logic.communication.log.LogUtil.{*}

    //ActualPlatform
    def putP(log : Log) : Unit = {
    }

    //ActualPlatform
    def putF(specialMessage : String, anyType : Object, functionName : String) : Unit = {
    }

    //ActualPlatform
    def putFS(specialMessage : String, className : String, functionName : String) : Unit = {
    }

    //ActualPlatform
    def put(specialMessage : String, anyType : Object, functionName : String, exception : Object) : Unit = {
    }

}

object LogUtil {
    private val instance : LogUtil = new LogUtil()

    //ActualPlatform
    def getInstance() : LogUtil = {
        return LogUtil.instance
    }

}


