/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary

import _root_.javax.microedition.lcdui.Displayable
import _root_.javax.microedition.lcdui.Form
import _root_.javax.microedition.rms.InvalidRecordIDException
import _root_.javax.microedition.rms.RecordStore
import _root_.javax.microedition.rms.RecordStoreException
import _root_.javax.microedition.rms.RecordStoreNotOpenException
import _root_.org.allbinary.logic.NullUtil

//J2SE
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

    def getRecord(anyType : Object, recordId : Int) : Array[Byte] = {
        val recordStore : RecordStore = anyType.asInstanceOf[RecordStore]
        var data : Array[Byte] = null
        this.synchronized {
            data = new Array[Byte](recordStore.getRecordSize(recordId))
            recordStore.getRecord(recordId, data, 0)
        }
        return (if (data.length < 1) NullUtil.getInstance().NULL_BYTE_ARRAY else data)
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

    def getClassClassLoader(anyType : Object) : ClassLoader = {
        return anyType.getClass().getClassLoader()
    }

    def toNumberFromChar(value : Char) : Int = {
        return value.toInt
    }

    def toNumber(value : Int) : Int = {
        return value
    }

    def getByteArray(string : String) : Array[Byte] = {
        return string.getBytes()
    }

    def isItemListener(owner : Displayable) : Boolean = {
        if (owner.isInstanceOf[Form]) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
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


