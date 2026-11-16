/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.org.allbinary.logic.NullUtil

class LogFactory {
    import _root_.org.allbinary.logic.communication.log.LogFactory.{*}

}

object LogFactory {
    //ActualPlatform
    def getInstance(specialMessage : String, anyType : Object, functionName : String, exception : Object) : Log = {
        /*         if(object instanceof String)         {             ForcedLogUtil.log("Don't use a String", object);         }         */
        return new Log(specialMessage, anyType, functionName, exception)
    }

    //ActualPlatform
    def getInstanceF(specialMessage : String, anyType : Object, functionName : String) : Log = {
        /*         if(object instanceof String)         {             ForcedLogUtil.log("Don't use a String", object);         }         */
        return new Log(specialMessage, anyType, functionName, NullUtil.getInstance().NULL_OBJECT)
    }

}


