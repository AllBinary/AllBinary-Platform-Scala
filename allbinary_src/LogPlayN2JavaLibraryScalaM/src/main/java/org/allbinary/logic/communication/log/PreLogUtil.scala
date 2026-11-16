/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.playn.core.PlayN

//ActualPlatform
@JsType
class PreLogUtil() {
    import _root_.org.allbinary.logic.communication.log.PreLogUtil.{*}

}

object PreLogUtil {
    //ActualPlatform
    def put(specialMessage : String, anyType : Object, functionName : String) : Unit = {
        //       String className = EMPTY;
        var className : String = PreLogUtil.getClassName(anyType)
        if (className == null) {
            className = CommonStrings.getInstance().EMPTY
        }
        className = new StringMaker().append(className).append(CommonSeps.getInstance().FORWARD_SLASH).append(StringUtil.getInstance().toString(anyType)).toString()
        val message : String = LogFormatUtil.getInstance().getS(className, functionName, specialMessage)
        PlayN.getInstance().log().debug(PreLogUtil.LOG_SUCCESS + message)
    }

    private val LOG_SUCCESS : String = "org.allbinary: "

    //ActualPlatform
    def putOE(specialMessage : String, anyType : Object, functionName : String, exception : Object) : Unit = {
        //       String className = EMPTY;
        var className : String = PreLogUtil.getClassName(anyType)
        if (className == null) {
            className = CommonStrings.getInstance().EMPTY
        }
        className = new StringMaker().append(className).append(CommonSeps.getInstance().FORWARD_SLASH).append(StringUtil.getInstance().toString(anyType)).toString()
        val message : String = LogFormatUtil.getInstance().get(className, functionName, specialMessage, exception)
        PlayN.getInstance().log().error(PreLogUtil.LOG_SUCCESS + message, exception.asInstanceOf[Throwable])
    }

    //ActualPlatform
    def putS(specialMessage : String, className : String, functionName : String) : Unit = {
        val message : String = LogFormatUtil.getInstance().getS(className, functionName, specialMessage)
        PlayN.getInstance().log().debug(PreLogUtil.LOG_SUCCESS + message)
    }

    //ActualPlatform
    def putSE(specialMessage : String, className : String, functionName : String, exception : Object) : Unit = {
        val message : String = LogFormatUtil.getInstance().get(className, functionName, specialMessage, exception)
        PlayN.getInstance().log().error(PreLogUtil.LOG_SUCCESS + message, exception.asInstanceOf[Throwable])
    }

    //ActualPlatform
    def getClassName(anyType : Object) : String

}


