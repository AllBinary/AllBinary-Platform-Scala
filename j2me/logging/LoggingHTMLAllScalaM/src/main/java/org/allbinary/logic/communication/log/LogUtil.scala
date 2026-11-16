/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.org.allbinary.string.CommonStrings
import _root_.playn.core.PlayN

//ActualPlatform
class LogUtil private() {
    import _root_.org.allbinary.logic.communication.log.LogUtil.{*}

    private val LOG_SUCCESS : String = "org.allbinary: "

    private val logFormatUtil : LogFormatUtil = LogFormatUtil.getInstance()

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
        var className : String = PreLogUtil.getClassName(anyType)
        if (className == null) {
            className = CommonStrings.getInstance().EMPTY
        }
        //        }
        val message : String = this.logFormatUtil.getS(className, functionName, specialMessage)
        PlayN.log().debug(this.LOG_SUCCESS + message)
    }

    //ActualPlatform
    def putFS(specialMessage : String, className : String, functionName : String) : Unit = {
        //        }
        val message : String = this.logFormatUtil.getS(className, functionName, specialMessage)
        PlayN.log().debug(this.LOG_SUCCESS + message)
    }

    //ActualPlatform
    def put(specialMessage : String, anyType : Object, functionName : String, exception : Object) : Unit = {
        var className : String = PreLogUtil.getClassName(anyType)
        if (className == null) {
            className = CommonStrings.getInstance().EMPTY
        }
        //        }
        val message : String = this.logFormatUtil.get(className, functionName, specialMessage, exception)
        if (exception != null) {
            PlayN.log().error(this.LOG_SUCCESS + message, exception.asInstanceOf[Throwable])
        } else {
            PlayN.log().debug(this.LOG_SUCCESS + message)
        }
    }

}

object LogUtil {
    private val instance : LogUtil = new LogUtil()

    //ActualPlatform
    def getInstance() : LogUtil = {
        return LogUtil.instance
    }

}


