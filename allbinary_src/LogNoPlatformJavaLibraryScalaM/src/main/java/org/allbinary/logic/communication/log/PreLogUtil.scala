/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.org.allbinary.logic.NullUtil

//NoPlatform
class PreLogUtil() {
    import _root_.org.allbinary.logic.communication.log.PreLogUtil.{*}

}

object PreLogUtil {
    /*     public static void put(Log log)     {         throw new RuntimeException();     }     */
    def put(specialMessage : String, anyType : Object, functionName : String) : Unit = {
        PreLogUtil.putOE(specialMessage, anyType, functionName, NullUtil.getInstance().NULL_OBJECT)
    }

    def putOE(specialMessage : String, anyType : Object, functionName : String, exception : Object) : Unit = {
        throw new RuntimeException()
    }

    def putSE(specialMessage : String, className : String, functionName : String, exception : Object) : Unit = {
        throw new RuntimeException()
    }

}


