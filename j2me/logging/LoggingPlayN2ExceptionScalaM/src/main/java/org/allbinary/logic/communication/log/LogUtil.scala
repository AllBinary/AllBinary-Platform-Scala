/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.string.CommonStrings
import _root_.playn.core.PlayN
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsConstructor

//ActualPlatform
@JsType
class LogUtil private() {
    import _root_.org.allbinary.logic.communication.log.LogUtil.{*}

    private val logFormatUtil : LogFormatUtil = LogFormatUtil.getInstance()

    private val LOG_SUCCESS : String = "org.allbinary: "

    //ActualPlatform
    @JsMethod
    def putL(log : Log) : Unit = {
        if (log == null) {
            return
        }
        val specialMessage : String = log.getSpecialMessage()
        val anyType : Object = log.getObject()
        val functionName : String = log.getFunctionName()
        val exception : Object = log.getThrowable()
        this.put(specialMessage, anyType, functionName, exception)
    }

    //ActualPlatform
    @JsMethod
    def putF(specialMessage : String, anyType : Object, functionName : String) : Unit = {
        var className : String = PreLogUtil.getClassName(anyType)
        if (className == null) {
            className = CommonStrings.getInstance().EMPTY
        }
        //        }
        val message : String = this.logFormatUtil.getS(className, functionName, specialMessage)
        val playN : PlayN = PlayN.getInstance()
        playN.log().debug(this.LOG_SUCCESS + message)
    }

    //ActualPlatform
    @JsMethod
    def putFS(specialMessage : String, className : String, functionName : String) : Unit = {
        //        }
        val message : String = this.logFormatUtil.getS(className, functionName, specialMessage)
        //@playn.core.PlayN::debug(Ljava/lang/String;)(this.LOG_SUCCESS + message);
        val playN : PlayN = PlayN.getInstance()
        playN.log().debug(this.LOG_SUCCESS + message)
    }

    //ActualPlatform
    @JsMethod
    def put(specialMessage : String, anyType : Object, functionName : String, exception : Object) : Unit = {
        var className : String = PreLogUtil.getClassName(anyType)
        if (className == null) {
            className = CommonStrings.getInstance().EMPTY
        }
        //        }
        val message : String = this.logFormatUtil.get(className, functionName, specialMessage, exception)
        val playN : PlayN = PlayN.getInstance()
        if (exception != null) {
            //@playn.core.PlayN::error(Ljava/lang/String;, Ljava/lang/Throwable;)(this.LOG_SUCCESS + message, exception);
            playN.log().error(this.LOG_SUCCESS + message, exception.asInstanceOf[Throwable])
        } else {
            //@playn.core.PlayN::debug(Ljava/lang/String;)(this.LOG_SUCCESS + message);
            playN.log().debug(this.LOG_SUCCESS + message)
        }
    }

}

object LogUtil {
    private val instance : LogUtil = new LogUtil()

    //ActualPlatform
    @JsMethod
    def getInstance() : LogUtil = {
        return LogUtil.instance
    }

}


