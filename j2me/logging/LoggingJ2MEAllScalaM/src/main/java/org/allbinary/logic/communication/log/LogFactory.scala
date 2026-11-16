/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.string.StringUtil

//ActualPlatform
class LogFactory {
    import _root_.org.allbinary.logic.communication.log.LogFactory.{*}

}

object LogFactory {
    //ActualPlatform
    def getInstanceD() : Log = {
        val stringUtil : StringUtil = StringUtil.getInstance()
        val nullUtil : NullUtil = NullUtil.getInstance()
        return new Log(stringUtil.EMPTY_STRING, nullUtil.NULL_OBJECT, stringUtil.EMPTY_STRING, nullUtil.NULL_OBJECT)
    }

    //ActualPlatform
    def getInstanceNoF(specialMessage : String, anyType : Object, exception : Object) : Log = {
        return new Log(specialMessage, anyType, StringUtil.getInstance().EMPTY_STRING, exception)
    }

    //ActualPlatform
    def getInstance(specialMessage : String, anyType : Object, functionName : String, exception : Object) : Log = {
        return new Log(specialMessage, anyType, functionName, exception)
    }

    //ActualPlatform
    def getInstanceF(specialMessage : String, anyType : Object, functionName : String) : Log = {
        val nullUtil : NullUtil = NullUtil.getInstance()
        return new Log(specialMessage, anyType, functionName, nullUtil.NULL_OBJECT)
    }

}


