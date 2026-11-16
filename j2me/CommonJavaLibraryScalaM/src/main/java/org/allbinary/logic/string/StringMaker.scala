/* Generated Code Do Not Modify */
package org.allbinary.logic.string

import _root_.jsinterop.annotations.JsType
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsConstructor

@JsType
class StringMaker() {

    //private final StringUtil stringUtil = StringUtil.getInstance();
    private var charArray : Array[Char] = null

    private var currentLength : Int = 0

    //Constructor
    {
        this.charArray = new Array[Char](20)
    }

    @JsMethod
    def append(string : String) : StringMaker = {
        val stringLength : Int = string.length()
        this.ensureCapacity(this.currentLength + stringLength)
        string.getChars(0, stringLength, this.charArray, this.currentLength)
        this.currentLength += stringLength
        return this
    }

    //    }
    @JsMethod
    def appendchar(c : Char) : StringMaker = {
        this.ensureCapacity(this.currentLength + 1)
        this.charArray({ val value_N68311 = this.currentLength; this.currentLength += 1; value_N68311 }) = c
        return this
    }

    @JsMethod
    def appendCharArray(charArray : Array[Char], start : Int, end : Int) : StringMaker = {
        this.ensureCapacity(this.currentLength + (end - start))

        {
            var index : Int = start
            while (index < end) {
                this.charArray({ val value_N68501 = this.currentLength; this.currentLength += 1; value_N68501 }) = charArray(index)
                index += 1
            }
        }
        return this
    }

    @JsMethod
    def appendbyte(b : Byte) : StringMaker = {
        //change to PrimitiveLongUtil
        this.append(Integer.toString(b))
        return this
    }

    @JsMethod
    def appendshort(b : Short) : StringMaker = {
        //change to PrimitiveLongUtil
        this.append(Integer.toString(b))
        return this
    }

    @JsMethod
    def appendint(i : Int) : StringMaker = {
        //change to PrimitiveLongUtil
        this.append(Integer.toString(i))
        return this
    }

    @JsMethod
    def appendlong(l : Long) : StringMaker = {
        //change to PrimitiveLongUtil
        this.append(_root_.java.lang.Long.toString(l))
        return this
    }

    @JsMethod
    def appendfloat(f : Float) : StringMaker = {
        //change to PrimitiveLongUtil
        this.append(_root_.java.lang.Float.toString(f))
        return this
    }

    //    }
    @JsMethod
    def appendboolean(bool : Boolean) : StringMaker = {
        if (bool) {
            this.ensureCapacity(this.currentLength + 4)
            this.charArray({ val value_N69659 = this.currentLength; this.currentLength += 1; value_N69659 }) = 't'
            this.charArray({ val value_N69703 = this.currentLength; this.currentLength += 1; value_N69703 }) = 'r'
            this.charArray({ val value_N69747 = this.currentLength; this.currentLength += 1; value_N69747 }) = 'u'
            this.charArray({ val value_N69791 = this.currentLength; this.currentLength += 1; value_N69791 }) = 'e'
        } else {
            this.ensureCapacity(this.currentLength + 5)
            this.charArray({ val value_N69394 = this.currentLength; this.currentLength += 1; value_N69394 }) = 'f'
            this.charArray({ val value_N69438 = this.currentLength; this.currentLength += 1; value_N69438 }) = 'a'
            this.charArray({ val value_N69482 = this.currentLength; this.currentLength += 1; value_N69482 }) = 'l'
            this.charArray({ val value_N69526 = this.currentLength; this.currentLength += 1; value_N69526 }) = 's'
            this.charArray({ val value_N69570 = this.currentLength; this.currentLength += 1; value_N69570 }) = 'e'
        }
        return this
    }

    @JsMethod
    def ensureCapacity(minSize : Int) : Unit = {
        val oldCapacity : Int = this.charArray.length
        if (minSize > oldCapacity) {
            var newCapacity : Int = oldCapacity * 3
            if (newCapacity < minSize) {
                newCapacity = minSize
            }
            val copy : Array[Char] = new Array[Char](newCapacity)
            val min : Int = this.min(this.charArray.length, newCapacity)
            System.arraycopy(this.charArray, 0, copy, 0, min)
            this.charArray = copy
        }
    }

    //mathUtil.min(this.charArray.length, newCapacity)
    @JsMethod
    def min(value : Int, value2 : Int) : Int = {
        return (if ((value <= value2)) value else value2)
    }

    @JsMethod
    def delete(start : Int, end : Int) : StringMaker = {
        this.currentLength -= (end - start)
        return this
    }

    @JsMethod
    def length() : Int = {
        return this.currentLength
    }

    @JsMethod
    override def toString() : String = {
        return new String(this.charArray, 0, this.currentLength)
    }

}


