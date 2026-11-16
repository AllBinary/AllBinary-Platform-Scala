/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

//ActualPlatform
class LogUtil private() {
    import _root_.org.allbinary.logic.communication.log.LogUtil.{*}

    private val logFormatUtil : LogFormatUtil = LogFormatUtil.getInstance()

    private val LOG_SUCCESS : String = "org.allbinary: "

    //ActualPlatform
    def putL(log : Log) : Unit = {
        val specialMessage : String = log.getSpecialMessage()
        val anyType : Object = log.getObject()
        val functionName : String = log.getFunctionName()
        val exception : Object = log.getThrowable()
        this.put(specialMessage, anyType, functionName, exception)
    }

    //ActualPlatform
    def putF(specialMessage : String, anyType : Object, functionName : String) : Unit = {
        var className : String = CommonStrings.getInstance().EMPTY
        if (anyType.getClass().getName() != null) {
            className = new String(new StringMaker().append(anyType.getClass().getName()).append(CommonSeps.getInstance().COLON).append(Integer.toHexString(TsUtil.getInstance().hashCode(anyType))).toString())
        }
        val message : String = this.logFormatUtil.getS(className, functionName, specialMessage)
        System.out.print(this.LOG_SUCCESS)
        System.out.println(message)
    }

    //ActualPlatform
    def putFS(specialMessage : String, className : String, functionName : String) : Unit = {
        val message : String = this.logFormatUtil.getS(className, functionName, specialMessage)
        System.out.print(this.LOG_SUCCESS)
        System.out.println(message)
    }

    //ActualPlatform
    def put(specialMessage : String, anyType : Object, functionName : String, exception : Object) : Unit = {
        var className : String = CommonStrings.getInstance().EMPTY
        if (anyType.getClass().getName() != null) {
            val hashCodeValue : Int = TsUtil.getInstance().hashCode(anyType)
            val hexString : String = Integer.toHexString(hashCodeValue)
            className = new String(new StringMaker().append(anyType.getClass().getName()).append(CommonSeps.getInstance().COLON).append(hexString).toString())
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


