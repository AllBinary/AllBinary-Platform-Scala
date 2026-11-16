/* Generated Code Do Not Modify */
package org.allbinary.util

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.logic.math.MathUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.jsinterop.annotations.JsMethod

@JsType
class ArrayUtil {
    import _root_.org.allbinary.util.ArrayUtil.{*}

    private val mathUtil : MathUtil = MathUtil.getInstance()

    @JsMethod
    def copyOf(original : Array[Object], newLength : Int) : Array[Object] = {
        return this.copyOfType(original, newLength, original.getClass())
    }

    @JsMethod
    def copyOfType(original : Array[Object], newLength : Int, newType : Class[?]) : Array[Object] = {
        val copy : Array[Object] = new Array[Object](newLength)
        System.arraycopy(original, 0, copy, 0, this.mathUtil.min(original.length, newLength))
        return copy
    }

    @JsMethod
    def copyOfbyte(original : Array[Byte], newLength : Int) : Array[Byte] = {
        val copy : Array[Byte] = new Array[Byte](newLength)
        System.arraycopy(original, 0, copy, 0, this.mathUtil.min(original.length, newLength))
        return copy
    }

    @JsMethod
    def copyOfshort(original : Array[Short], newLength : Int) : Array[Short] = {
        val copy : Array[Short] = new Array[Short](newLength)
        System.arraycopy(original, 0, copy, 0, this.mathUtil.min(original.length, newLength))
        return copy
    }

    @JsMethod
    def copyOfint(original : Array[Int], newLength : Int) : Array[Int] = {
        val copy : Array[Int] = new Array[Int](newLength)
        System.arraycopy(original, 0, copy, 0, this.mathUtil.min(original.length, newLength))
        return copy
    }

    @JsMethod
    def copyOflong(original : Array[Long], newLength : Int) : Array[Long] = {
        val copy : Array[Long] = new Array[Long](newLength)
        System.arraycopy(original, 0, copy, 0, this.mathUtil.min(original.length, newLength))
        return copy
    }

    @JsMethod
    def copyOfchar(original : Array[Char], newLength : Int) : Array[Char] = {
        val copy : Array[Char] = new Array[Char](newLength)
        System.arraycopy(original, 0, copy, 0, this.mathUtil.min(original.length, newLength))
        return copy
    }

    @JsMethod
    def copyOffloat(original : Array[Float], newLength : Int) : Array[Float] = {
        val copy : Array[Float] = new Array[Float](newLength)
        System.arraycopy(original, 0, copy, 0, this.mathUtil.min(original.length, newLength))
        return copy
    }

    @JsMethod
    def copyOfdouble(original : Array[Double], newLength : Int) : Array[Double] = {
        val copy : Array[Double] = new Array[Double](newLength)
        System.arraycopy(original, 0, copy, 0, this.mathUtil.min(original.length, newLength))
        return copy
    }

    @JsMethod
    def copyOfboolean(original : Array[Boolean], newLength : Int) : Array[Boolean] = {
        val copy : Array[Boolean] = new Array[Boolean](newLength)
        System.arraycopy(original, 0, copy, 0, this.mathUtil.min(original.length, newLength))
        return copy
    }

    @JsMethod
    def reverse(intArray : Array[Int]) : Unit = {
        val length : Int = intArray.length - 1
        var temp : Int = 0
        val size : Int = length / 2

        {
            var index : Int = 0
            while (index <= size) {
                temp = intArray(index)
                intArray(index) = intArray(length - index)
                intArray(length - index) = temp
                index += 1
            }
        }
    }

    @JsMethod
    def flip(intArray : Array[Int], width : Int, height : Int) : Unit = {
        val length : Int = height - 1
        var temp : Int = 0
        var index : Int = 0
        var rowIndex : Int = 0

        {
            var y : Int = 0
            while (y <= (length / 2)) {

                {
                    var x : Int = 0
                    while (x < width) {
                        rowIndex = ((length - y) * width)
                        index = x + (y * width)
                        temp = intArray(index)
                        intArray(index) = intArray(rowIndex + x)
                        intArray(rowIndex + x) = temp
                        x += 1
                    }
                }
                y += 1
            }
        }
    }

    @JsMethod
    def toStringFromTwoDimensionaArray(twoDimensionalIntArray : Array[Array[Int]]) : String = {
        val stringBuffer : StringMaker = new StringMaker()
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        val endIndex : Int = twoDimensionalIntArray.length
        val endIndex2 : Int = twoDimensionalIntArray(0).length

        {
            var index : Int = 0
            while (index < endIndex) {
                stringBuffer.append(commonSeps.BRACE_OPEN)

                {
                    var index2 : Int = 0
                    while (index2 < endIndex2) {
                        stringBuffer.appendint(twoDimensionalIntArray(index)(index2))
                        stringBuffer.append(commonSeps.COMMA_SEP)
                        index2 += 1
                    }
                }
                stringBuffer.append(commonSeps.BRACE_CLOSE)
                stringBuffer.append(commonSeps.NEW_LINE)
                index += 1
            }
        }
        return stringBuffer.toString()
    }

    @JsMethod
    def toStringFromObjectArray(objectArray : Array[Object]) : String = {
        val stringBuffer : StringMaker = new StringMaker()
        val commonSeps : CommonSeps = CommonSeps.getInstance()

        {
            var index : Int = 0
            while (index < objectArray.length) {
                stringBuffer.append(StringUtil.getInstance().toString(objectArray(index)))
                stringBuffer.append(commonSeps.COMMA_SEP)
                index += 1
            }
        }
        return stringBuffer.toString()
    }

    @JsMethod
    def toStringFromByteArray(byteArray : Array[Byte]) : String = {
        val stringBuffer : StringMaker = new StringMaker()
        val commonSeps : CommonSeps = CommonSeps.getInstance()

        {
            var index : Int = 0
            while (index < byteArray.length) {
                stringBuffer.appendbyte(byteArray(index))
                stringBuffer.append(commonSeps.COMMA_SEP)
                index += 1
            }
        }
        return stringBuffer.toString()
    }

}

object ArrayUtil {
    private val instance : ArrayUtil = new ArrayUtil()

    @JsMethod
    def getInstance() : ArrayUtil = {
        return ArrayUtil.instance
    }

}


