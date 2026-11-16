/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.java.exception.ExceptionUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.time.TimeStampUtil

//ActualPlatform
class LogFormatUtil private() {
    import _root_.org.allbinary.logic.communication.log.LogFormatUtil.{*}

    private val timeStampUtil : TimeStampUtil = TimeStampUtil.getInstance()

    private val commonSeps : CommonSeps = CommonSeps.getInstance()

    private val NONE : String = "None"

    private val LOG_ERROR : String = "\nLog-Error: "

    private val EMPTY : String = "Empty"

    private val STACK_TRACE : String = "\nStack Trace: "

    private val TIME : String = "Time: "

    //private final String SPECIAL_MESSAGE = "\nSpecial Msg: ";
    private val CLASS_NAME : String = this.commonSeps.SPACE

    private val FUNCTION_CALL : String = CommonLabels.getInstance().COLON_SEP

    private val SPECIAL_MESSAGE : String = "> "

    private val stringUtil : StringUtil = StringUtil.getInstance()

    private val exceptionUtil : ExceptionUtil = ExceptionUtil.getInstance()

    private val nullUtil : NullUtil = NullUtil.getInstance()

    //ActualPlatform
    def get(className : String, functionName : String, specialMessage : String, exception : Object) : String = {
        val stringBuffer : StringMaker = this.getF(className, functionName)
        stringBuffer.append(this.getO(exception))
        stringBuffer.append(this.SPECIAL_MESSAGE)
        stringBuffer.append(specialMessage)
        stringBuffer.append(this.commonSeps.NEW_LINE)
        //"\nClassLoader: " +  hashCode +
        return stringBuffer.toString()
    }

    //ActualPlatform
    def getS(className : String, functionName : String, specialMessage : String) : String = {
        val stringBuffer : StringMaker = this.getF(className, functionName)
        stringBuffer.append(this.SPECIAL_MESSAGE)
        stringBuffer.append(specialMessage)
        stringBuffer.append(this.commonSeps.NEW_LINE)
        //"\nClassLoader: " +  hashCode +
        return stringBuffer.toString()
    }

    //private final Calendar calendar = Calendar.getInstance();
    private def getF(className : String, functionName : String) : StringMaker = {
        //int hashCode = TsUtil.getInstance().hashCode(LogUtil.class.getClassLoader().getClass());
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.TIME)
        stringBuffer.append(this.timeStampUtil.getAsString())
        stringBuffer.append(this.CLASS_NAME)
        stringBuffer.append(className)
        stringBuffer.append(this.FUNCTION_CALL)
        stringBuffer.append(functionName)
        //"\nClassLoader: " +  hashCode +
        return stringBuffer
    }

    //ActualPlatform
    def getO(exception : Object) : String = {
        if (exception ne this.nullUtil.NULL_OBJECT) {
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(this.LOG_ERROR)
            val exceptionAsString : String = exception.toString()
            //            {
            stringBuffer.append(exceptionAsString)
            //            }
            stringBuffer.append(this.STACK_TRACE)
            if (exception ne this.nullUtil.NULL_OBJECT) {
                stringBuffer.append(this.exceptionUtil.getStackTrace(exception.asInstanceOf[Throwable]))
            } else {
                stringBuffer.append(this.stringUtil.NULL_STRING)
            }
            //"\nLog-Error: " + exceptionMessage;
            return stringBuffer.toString()
        } else {
            return StringUtil.getInstance().EMPTY_STRING
        }
        throw new IllegalStateException()
    }

}

object LogFormatUtil {
    private val instance : LogFormatUtil = new LogFormatUtil()

    //ActualPlatform
    def getInstance() : LogFormatUtil = {
        return LogFormatUtil.instance
    }

}


