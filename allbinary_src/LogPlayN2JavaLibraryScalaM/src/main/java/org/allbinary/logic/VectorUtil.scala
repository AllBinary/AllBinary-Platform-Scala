/*  * AllBinary Open License Version 1  * Copyright (c) 2026 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic

import _root_.java.util.Vector
import _root_.jsinterop.annotations.JsType

/**  *  * @author User  */
@JsType
class VectorUtil {
    import _root_.org.allbinary.logic.VectorUtil.{*}

    def getSize(anyType : Object) : Int = {
        val vector : Vector[Object] = anyType.asInstanceOf[Vector[Object]]
        return vector.size()
    }

    def elementAt(anyType : Object, index : Int) : Object = {
        val vector : Vector[Object] = anyType.asInstanceOf[Vector[Object]]
        return vector.elementAt(index)
    }

}

object VectorUtil {
    private val instance : VectorUtil = new VectorUtil()

    /**      * @return the instance      */
    def getInstance() : VectorUtil = {
        return VectorUtil.instance
    }

}


