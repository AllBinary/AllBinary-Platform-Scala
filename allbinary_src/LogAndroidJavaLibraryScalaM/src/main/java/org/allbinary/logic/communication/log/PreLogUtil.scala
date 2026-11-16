/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogFormatUtil

//ActualPlatform
class PreLogUtil() {
    import _root_.org.allbinary.logic.communication.log.PreLogUtil.{*}

}

object PreLogUtil {
    //ActualPlatform
    def put(specialMessage : String, anyType : Object, functionName : String) : Unit = {
        PreLogUtil.putOE(specialMessage, anyType, functionName, NullUtil.getInstance().NULL_OBJECT)
    }

    private val LABEL : String = "org.allbinary"

    //ActualPlatform
    def putOE(specialMessage : String, anyType : Object, functionName : String, exception : Object) : Unit = {
        var className : String = PreLogUtil.LABEL
        var actualClassName : String = anyType.getClass().getName()
        if (actualClassName != null) {
            className = actualClassName
        }
        val message : String = LogFormatUtil.getInstance().get(className, functionName, specialMessage, exception)
        //android.util.Log.i(className, LOG_SUCCESS + message);
        _root_.android.util.Log.i(PreLogUtil.LABEL, message)
    }

    //ActualPlatform
    def putS(specialMessage : String, className : String, functionName : String) : Unit = {
        PreLogUtil.putSE(specialMessage, className, functionName, NullUtil.getInstance().NULL_OBJECT)
    }

    //ActualPlatform
    def putSE(specialMessage : String, className : String, functionName : String, exception : Object) : Unit = {
        val message : String = LogFormatUtil.getInstance().get(className, functionName, specialMessage, exception)
        //android.util.Log.i(className, LOG_SUCCESS + message);
        _root_.android.util.Log.i(className, message)
    }

}


