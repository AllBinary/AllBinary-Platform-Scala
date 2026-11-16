/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.string.StringUtil

//NoPlatform
class LogFactory {
    import _root_.org.allbinary.logic.communication.log.LogFactory.{LOG as _, *}
    def LOG : Log = _root_.org.allbinary.logic.communication.log.LogFactory.LOG

}

object LogFactory {
    val LOG : Log = new Log(StringUtil.getInstance().EMPTY_STRING, NullUtil.getInstance().NULL_OBJECT, StringUtil.getInstance().EMPTY_STRING, NullUtil.getInstance().NULL_OBJECT)

    def getInstance(specialMessage : String, anyType : Object, functionName : String, exception : Object) : Log = {
        throw new RuntimeException()
    }

    def getInstanceF(specialMessage : String, anyType : Object, functionName : String) : Log = {
        throw new RuntimeException()
    }

}


