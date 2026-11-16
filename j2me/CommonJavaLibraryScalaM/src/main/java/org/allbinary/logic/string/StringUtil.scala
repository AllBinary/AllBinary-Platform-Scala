/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.string

import _root_.jsinterop.annotations.JsType
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsConstructor
import _root_.jsinterop.annotations.JsProperty

@JsType
class StringUtil private() {
    import _root_.org.allbinary.logic.string.StringUtil.{*}

    @JsProperty
    val INIT_STRING : String = new String("")

    @JsProperty
    val NULL_STRING : String = "null"

    @JsProperty
    val EMPTY_STRING : String = ""

    @JsProperty
    var ONE_EMPTY_STRING_ARRAY : Array[String] = Array[String](this.EMPTY_STRING)

    @JsProperty
    var ONE_EMPTY_STRING_ARRAY_OF_ARRAYS : Array[Array[String]] = Array.ofDim[String](0, 0)

    private val stringArray : Array[String] = new Array[String](0)

    //TWB - Could return a NULL_STRING
    @JsMethod
    def getNonNull(string : String) : String = {
        //        } else {
        return string
    }

    @JsMethod
    def getArrayInstance() : Array[String] = {
        return this.stringArray
    }

    @JsMethod
    def count(string : String, aChar : Char) : Int = {
        var count : Int = 0
        val size : Int = string.length()

        {
            var index : Int = 0
            while (index < size) {
                if (string.charAt(index) == aChar) {
                    count += 1
                }
                index += 1
            }
        }
        return count
    }

    @JsMethod
    def toString(anyType : Object) : String = {
        if (anyType != null) {
            return anyType.toString()
        } else {
            return this.NULL_STRING
        }
        throw new IllegalStateException()
    }

}

object StringUtil {
    private val instance : StringUtil = new StringUtil()

    @JsMethod
    def getInstance() : StringUtil = {
        return StringUtil.instance
    }

}


