/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.util

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsConstructor
import _root_.jsinterop.annotations.JsProperty

@JsType
class CircularIndexUtil private(param_index : Int, param_size : Int) {
    import _root_.org.allbinary.util.CircularIndexUtil.{NULL_CIRCULAR_INDEX_UTIL as _, *}
    def NULL_CIRCULAR_INDEX_UTIL : CircularIndexUtil = _root_.org.allbinary.util.CircularIndexUtil.NULL_CIRCULAR_INDEX_UTIL

    private var index : Int = 0

    private var lastIndex : Int = 0

    private var size : Int = 0

    //Constructor
    {
        val index : Int = param_index
        val size : Int = param_size
        this.setSize(size)
        this.setIndex(index)
    }

    //    }
    @JsMethod
    def next() : Int = {
        if (this.index >= this.lastIndex) {
            this.index = 0
        } else {
            this.index += 1
        }
        return this.index
    }

    @JsMethod
    def previous() : Int = {
        if (this.index < 1) {
            this.index = this.lastIndex
        } else {
            this.index -= 1
        }
        return this.index
    }

    @JsMethod
    def setIndex(index : Int) : Unit = {
        if (index > this.lastIndex) {
            return
        }
        this.index = index
    }

    @JsMethod
    def getIndex() : Int = {
        return this.index
    }

    @JsMethod
    def setSize(size : Int) : Unit = {
        this.size = size
        this.lastIndex = size - 1
        this.index = 0
    }

    @JsMethod
    def getSize() : Int = {
        return this.size
    }

    @JsMethod
    override def toString() : String = {
        return new StringMaker().append(CommonLabels.getInstance().INDEX_LABEL).appendint(this.index).append("lastIndex: ").appendint(this.lastIndex).append("size: ").appendint(this.size).toString()
    }

}

object CircularIndexUtil {
    @JsProperty
    val NULL_CIRCULAR_INDEX_UTIL : CircularIndexUtil = new CircularIndexUtil(0, 0)

    @JsMethod
    def createInstance(max : Int) : CircularIndexUtil = {
        return new CircularIndexUtil(0, max)
    }

    @JsMethod
    def createInstanceAt(index : Int, max : Int) : CircularIndexUtil = {
        return new CircularIndexUtil(index, max)
    }

}


