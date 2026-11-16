/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic

import _root_.jsinterop.annotations.JsType

//ActualPlatform
@JsType
class NullUtil {
    import _root_.org.allbinary.logic.NullUtil.{*}

    //ActualPlatform
    val NULL_OBJECT : Object = new Object()

    //ActualPlatform
    val NULL_CLASS : Class[?] = this.NULL_OBJECT.getClass().asInstanceOf[Class[?]]

    //ActualPlatform
    val NULL_OBJECT_ARRAY : Array[Object] = new Array[Object](0)

    //ActualPlatform
    val NULL_CHAR_ARRAY : Array[Char] = new Array[Char](0)

    //ActualPlatform
    val NULL_BYTE_ARRAY : Array[Byte] = new Array[Byte](0)

    //ActualPlatform
    val NULL_SHORT_ARRAY_ARRAY : Array[Array[Short]] = Array.ofDim[Short](0, 0)

    //ActualPlatform
    val NULL_INT_ARRAY : Array[Int] = new Array[Int](0)

    //ActualPlatform
    val NULL_INT_ARRAY_ARRAY : Array[Array[Int]] = Array.ofDim[Int](0, 0)

    //ActualPlatform
    val NULL_INT_ARRAY_ARRAY_ARRAY : Array[Array[Array[Int]]] = Array.ofDim[Int](0, 0, 0)

    //ActualPlatform
    val NULL_FLOAT_ARRAY : Array[Float] = new Array[Float](0)

}

object NullUtil {
    private val instance : NullUtil = new NullUtil()

    //ActualPlatform
    def getInstance() : NullUtil = {
        return NullUtil.instance
    }

}


