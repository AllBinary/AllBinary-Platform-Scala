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

//NoPlatform
class LogFormatUtil private() {
    import _root_.org.allbinary.logic.communication.log.LogFormatUtil.{*}

    def get(className : String, functionName : String, specialMessage : String, exception : Object) : String = {
        throw new RuntimeException()
    }

    def getS(className : String, functionName : String, specialMessage : String) : String = {
        throw new RuntimeException()
    }

    def getO(exception : Object) : String = {
        throw new RuntimeException()
    }

}

object LogFormatUtil {
    private val instance : LogFormatUtil = new LogFormatUtil()

    def getInstance() : LogFormatUtil = {
        return LogFormatUtil.instance
    }

}


