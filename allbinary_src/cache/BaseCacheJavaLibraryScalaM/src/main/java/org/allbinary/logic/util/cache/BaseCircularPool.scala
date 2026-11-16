/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.cache

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.util.CircularIndexUtil
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsProperty

@JsType
class BaseCircularPool {

    @JsProperty
    var circularIndexUtil : CircularIndexUtil = CircularIndexUtil.NULL_CIRCULAR_INDEX_UTIL

    @JsProperty
    var OBJECT_ARRAY : Array[Object] = NullUtil.getInstance().NULL_OBJECT_ARRAY

    @JsMethod
    def getNextInstance() : Object = this.synchronized {
        var anyType : Object = this.OBJECT_ARRAY(this.circularIndexUtil.getIndex())
        this.circularIndexUtil.next()
        return anyType
    }

    @JsMethod
    def init(allBinaryObjectFactoryInterface : AllBinaryObjectFactoryInterface) : Unit = {
        this.circularIndexUtil.setIndex(0)
        var size : Int = this.circularIndexUtil.getSize()

        {
            var index : Int = 0
            while (index < size) {
                this.OBJECT_ARRAY(index) = allBinaryObjectFactoryInterface.getInstance()
                index += 1
            }
        }
    }

    @JsMethod
    def getInstance(index : Int) : Object = {
        return this.OBJECT_ARRAY(index)
    }

}


