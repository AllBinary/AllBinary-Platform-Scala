/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.color

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.util.CircularIndexUtil
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsConstructor

@JsType
class BasicColorArrayIndexer(param_basicColorArray : Array[BasicColor]) {

    private var basicColorArray : Array[BasicColor] = null

    private var circularIndexUtil : CircularIndexUtil = null

    //Constructor
    {
        val basicColorArray : Array[BasicColor] = param_basicColorArray
        this.basicColorArray = basicColorArray
        this.circularIndexUtil = CircularIndexUtil.createInstance(this.basicColorArray.length)
    }

    @JsMethod
    def next() : Unit = {
        this.circularIndexUtil.next()
    }

    @JsMethod
    def get() : BasicColor = {
        return this.basicColorArray(this.circularIndexUtil.getIndex())
    }

    @JsMethod
    def getBasicColorArray() : Array[BasicColor] = {
        return this.basicColorArray
    }

}


