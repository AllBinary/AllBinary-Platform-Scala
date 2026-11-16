/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log


//ActualPlatform
class LogUtil private() {
    import _root_.org.allbinary.logic.communication.log.LogUtil.{*}

    private val logFormatUtil : LogFormatUtil = LogFormatUtil.getInstance()

    private val LABEL : String = "org.allbinary"

    private val LOG_SUCCESS : String = "org.allbinary: "

    //ActualPlatform
    def putL(log : Log) : Unit = {
        val specialMessage : String = log.getSpecialMessage()
        val anyType : Object = log.getObject()
        val functionName : String = log.getFunctionName()
        val exception : Object = log.getThrowable()
        if (log != null) {
            this.put(specialMessage, anyType, functionName, exception)
        }
    }

    //ActualPlatform
    def putF(specialMessage : String, anyType : Object, functionName : String) : Unit = {
    }

    //ActualPlatform
    def putFS(specialMessage : String, className : String, functionName : String) : Unit = {
    }

    //ActualPlatform
    def put(specialMessage : String, anyType : Object, functionName : String, exception : Object) : Unit = {
        var className : String = this.LABEL
        /*       if(object != null && object.getClass().getName() != null)       {          className = new String(object.getClass().getName());       }          */
        className = anyType.getClass().getName()
        val message : String = this.logFormatUtil.get(className, functionName, specialMessage, exception)
        _root_.android.util.Log.i(this.LABEL, this.LOG_SUCCESS + message)
    }

}

object LogUtil {
    private val instance : LogUtil = new LogUtil()

    //ActualPlatform
    def getInstance() : LogUtil = {
        return LogUtil.instance
    }

}


