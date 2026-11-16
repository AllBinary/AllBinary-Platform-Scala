/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.java.util.logging.Level
import _root_.java.util.logging.Logger
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.string.CommonStrings

//ActualPlatform
class LogUtil private() {
    import _root_.org.allbinary.logic.communication.log.LogUtil.{*}

    private val logger : Logger = Logger.getLogger(classOf[LogUtil].getName())

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
        this.put(specialMessage, anyType, functionName, NullUtil.getInstance().NULL_OBJECT)
    }

    //ActualPlatform
    def putFS(specialMessage : String, className : String, functionName : String) : Unit = {
        this.putS(specialMessage, className, functionName, NullUtil.getInstance().NULL_OBJECT)
    }

    //ActualPlatform
    def put(specialMessage : String, anyType : Object, functionName : String, exception : Object) : Unit = {
        try {
            var className : String = CommonStrings.getInstance().EMPTY
            val clazz : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            if (clazz.getName() != null) {
                className = clazz.getName()
            }
            val message : String = this.logFormatUtil.getS(className, functionName, specialMessage)
            //className, functionName, specialMessage, exception);
            if (exception != null) {
                //logger.severe(message);
                this.logger.log(Level.SEVERE, message, exception)
            } else {
                //Change this back to warning when I get a stable version of gaefv without massive warnings
                this.logger.log(Level.INFO, message)
            }
        } catch {
            case e : Exception => {
            }
        }
    }

    //ActualPlatform
    def putS(specialMessage : String, className : String, functionName : String, exception : Object) : Unit = {
        try {
            val message : String = this.logFormatUtil.getS(className, functionName, specialMessage)
            //className, functionName, specialMessage, exception);
            if (exception != null) {
                //logger.severe(message);
                this.logger.log(Level.SEVERE, message, exception)
            } else {
                //Change this back to warning when I get a stable version of gaefv without massive warnings
                this.logger.log(Level.INFO, message)
            }
        } catch {
            case e : Exception => {
            }
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


