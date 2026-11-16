/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log


//NoPlatform
class LogUtil private() {
    import _root_.org.allbinary.logic.communication.log.LogUtil.{*}

    def putL(log : Log) : Unit = {
        throw new RuntimeException()
    }

    def putF(specialMessage : String, anyType : Object, functionName : String) : Unit = {
    }

    def putFS(specialMessage : String, className : String, functionName : String) : Unit = {
    }

    def put(specialMessage : String, anyType : Object, functionName : String, exception : Object) : Unit = {
        throw new RuntimeException()
    }

}

object LogUtil {
    private val instance : LogUtil = new LogUtil()

    def getInstance() : LogUtil = {
        return LogUtil.instance
    }

}


