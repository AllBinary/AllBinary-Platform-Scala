/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary


//TempBase
class TsUtil {
    import _root_.org.allbinary.TsUtil.{*}

    def longBitsToDouble(bits : Long) : Double = {
        return _root_.java.lang.Double.longBitsToDouble(bits)
    }

    def intBitsToFloat(bits : Int) : Float = {
        return _root_.java.lang.Float.intBitsToFloat(bits)
    }

    def hashCode(anyType : Object) : Int = {
        return anyType.hashCode()
    }

    def waitFor(any : Object, timeoutMillis : Long) : Unit = {
        val anyType : Object = any.asInstanceOf[Object]
        anyType.wait(timeoutMillis)
    }

    def compareTo(a : String, b : String) : Int = {
        return a.compareTo(b)
    }

}

object TsUtil {
    private val instance : TsUtil = new TsUtil()

    /**      * @return the instance      */
    def getInstance() : TsUtil = {
        return TsUtil.instance
    }

}


