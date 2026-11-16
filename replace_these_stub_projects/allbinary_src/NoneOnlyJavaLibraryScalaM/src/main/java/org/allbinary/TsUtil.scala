/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary


//None - Do not use
class TsUtil {
    import _root_.org.allbinary.TsUtil.{*}

    def hashCode(anyType : Object) : Int = {
        return anyType.hashCode()
    }

    def waitFor(any : Object, timeoutMillis : Long) : Unit = {
        val anyType : Object = any.asInstanceOf[Object]
        anyType.wait(timeoutMillis)
    }

    def getRecord(anyType : Object, recordId : Int) : Array[Byte] = {
        return new Array[Byte](0)
    }

    def compareTo(a : String, b : String) : Int = {
        return a.compareTo(b)
    }

    def equalIgnoreCase(a : String, b : String) : Boolean = {
        return a.equalsIgnoreCase(b)
    }

    def equalsNotstring(anyType : Object, object2 : Object) : Boolean = {
        return anyType.equals(object2)
    }

    //    }
    def toNumberFromChar(value : Char) : Int = {
        return value.toInt
    }

    def toNumber(value : Int) : Int = {
        return value
    }

    def getByteArray(string : String) : Array[Byte] = {
        return string.getBytes()
    }

    def isItemListener(owner : Object) : Boolean = {
        return false
    }

    def printAvailableMethods(anyType : Object) : Unit = {
    }

    def gc() : Unit = {
        System.gc()
    }

}

object TsUtil {
    private val instance : TsUtil = new TsUtil()

    /**      * @return the instance      */
    def getInstance() : TsUtil = {
        return TsUtil.instance
    }

}


