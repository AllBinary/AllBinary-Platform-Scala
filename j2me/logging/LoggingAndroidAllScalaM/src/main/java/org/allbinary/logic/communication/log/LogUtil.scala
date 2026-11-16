/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

//ActualPlatform
class LogUtil private() {
    import _root_.org.allbinary.logic.communication.log.LogUtil.{*}

    private val commonSeps : CommonSeps = CommonSeps.getInstance()

    private val logFormatUtil : LogFormatUtil = LogFormatUtil.getInstance()

    private val LABEL : String = "org.allbinary"

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
        this.put(specialMessage, anyType, functionName, NullUtil.getInstance().NULL_OBJECT)
    }

    def putFS(specialMessage : String, string : String, functionName : String) : Unit = {
        this.putS(specialMessage, string, functionName, NullUtil.getInstance().NULL_OBJECT)
    }

    //ActualPlatform
    def put(specialMessage : String, anyType : Object, functionName : String, exception : Object) : Unit = {
        var className : String = this.LABEL
        /*       if(exception == null && specialMessage.indexOf(this.commonStrings.EXCEPTION) < 0)       {           return;       }          */
        className = new String(new StringMaker().append(anyType.getClass().getName()).append(this.commonSeps.COLON).append(Integer.toHexString(TsUtil.getInstance().hashCode(anyType))).toString())
        val message : String = this.logFormatUtil.get(className, functionName, specialMessage, exception)
        _root_.android.util.Log.i(this.LABEL, message)
    }

    //ActualPlatform
    def putS(specialMessage : String, string : String, functionName : String, exception : Object) : Unit = {
        var className : String = this.LABEL
        /*       if(exception == null && specialMessage.indexOf(this.commonStrings.EXCEPTION) < 0)       {           return;       }          */
        className = new String(new StringMaker().append(string).append(this.commonSeps.COLON).append(Integer.toHexString(TsUtil.getInstance().hashCode(string))).toString())
        val message : String = this.logFormatUtil.get(className, functionName, specialMessage, exception)
        _root_.android.util.Log.i(this.LABEL, message)
    }

}

object LogUtil {
    private val instance : LogUtil = new LogUtil()

    //ActualPlatform
    def getInstance() : LogUtil = {
        return LogUtil.instance
    }

}


