/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.byteutil


class ByteUtil private() {
    import _root_.org.allbinary.logic.java.byteutil.ByteUtil.{*}

    def xor(array : Array[Byte], mask : Byte) : Array[Byte] = {
        val bytes : Array[Byte] = new Array[Byte](array.length)
        val size : Int = array.length
        var index : Int = 0
        var currentByte : Byte = 0

        {
            while (index < size) {
                currentByte = array(index)
                //System.out.print("Dec: " + currentByte);
                bytes(index) = (currentByte ^ mask).toByte
                //System.out.println(" Crp: " + bytes[index]);
                index += 1
            }
        }
        return bytes
    }

    def not(array : Array[Byte]) : Array[Byte] = {
        val bytes : Array[Byte] = new Array[Byte](array.length)
        val size : Int = array.length
        var index : Int = 0

        {
            while (index < size) {
                bytes(index) = (~array(index)).toByte
                index += 1
            }
        }
        return bytes
    }

    def xorByte(array : Array[Byte], index : Int) : Array[Byte] = {
        var mask : Byte = 0
        if (index == 0) {
            mask = 1
        }
        if (index == 1) {
            mask = 2
        }
        if (index == 2) {
            mask = 4
        }
        if (index == 3) {
            mask = 8
        }
        if (index == 4) {
            mask = 16
        }
        if (index == 5) {
            mask = 32
        }
        if (index == 6) {
            mask = 64
        }
        if (index == 7) {
            mask = -127
        }
        return this.xor(array, mask)
    }

    def compare(newByteArray : Array[Byte], oldByteArray : Array[Byte]) : Boolean = {
        if (newByteArray.length != oldByteArray.length) {
            return false
        } else {
        }
        val size : Int = newByteArray.length

        {
            var index : Int = 0
            while (index < size) {
                if (newByteArray(index) != oldByteArray(index)) {
                    return false
                }
                index += 1
            }
        }
        return true
    }

    def compareWithStats(newByteArray : Array[Byte], newSize : Int, oldByteArray : Array[Byte], stats : Array[Int]) : Boolean = {
        if (newSize != oldByteArray.length) {
            stats(0) = -1
            stats(2) = newSize
            stats(3) = oldByteArray.length
            return false
        } else {
            stats(0) = newSize
        }
        stats(1) = 0
        val size : Int = newSize

        {
            var index : Int = 0
            while (index < size) {
                if (newByteArray(index) != oldByteArray(index)) {
                    return false
                }
                stats(1) += 1
                index += 1
            }
        }
        return true
    }

}

object ByteUtil {
    private val instance : ByteUtil = new ByteUtil()

    def getInstance() : ByteUtil = {
        return ByteUtil.instance
    }

}


