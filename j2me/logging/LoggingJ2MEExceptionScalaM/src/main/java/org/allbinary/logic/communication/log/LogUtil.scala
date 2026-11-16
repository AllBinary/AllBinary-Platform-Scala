/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.org.allbinary.string.CommonStrings

//ActualPlatform
class LogUtil private() {
    import _root_.org.allbinary.logic.communication.log.LogUtil.{*}

    private val logFormatUtil : LogFormatUtil = LogFormatUtil.getInstance()

    private val LOG_SUCCESS : String = "org.allbinary: "

    //ActualPlatform
    def putL(log : Log) : Unit = {
        if (log eq LogFactory.LOG) {
            return
        }
        val exception : Object = log.getThrowable()
        if (exception == null) {
            return
        }
        val specialMessage : String = log.getSpecialMessage()
        val anyType : Object = log.getObject()
        val functionName : String = log.getFunctionName()
        this.put(specialMessage, anyType, functionName, exception)
    }

    //ActualPlatform
    def putF(specialMessage : String, anyType : Object, functionName : String) : Unit = {
    }

    //ActualPlatform
    def putFS(specialMessage : String, className : String, functionName : String) : Unit = {
    }

    //ActualPlatform
    def put(specialMessage : String, anyType : Object, functionName : String, exception : Object) : Unit = {
        var className : String = CommonStrings.getInstance().EMPTY
        if (anyType.getClass().getName() != null) {
            className = new String(anyType.getClass().getName())
        }
        val message : String = this.logFormatUtil.get(className, functionName, specialMessage, exception)
        System.out.print(this.LOG_SUCCESS)
        System.out.println(message)
    }

}

object LogUtil {
    private val instance : LogUtil = new LogUtil()

    //ActualPlatform
    def getInstance() : LogUtil = {
        return LogUtil.instance
    }

}


