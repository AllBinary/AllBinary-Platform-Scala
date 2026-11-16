/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.util

import _root_.jsinterop.annotations.JsType
import _root_.java.util.Enumeration
import _root_.jsinterop.annotations.JsMethod

//ArkTs does not have this.  So this is for the ArkTs build.
@JsType
class EnumerationUtil {
    import _root_.org.allbinary.util.EnumerationUtil.{*}

    @JsMethod
    def hasMoreElements(enumeration : Enumeration[? <: Object]) : Boolean = {
        return enumeration.hasMoreElements()
    }

    @JsMethod
    def nextElement(enumeration : Enumeration[? <: Object]) : Object = {
        return enumeration.nextElement()
    }

    @JsMethod
    def getAsArray(enumeration : Enumeration[? <: Object]) : Array[Object] = {
        val basicArrayList : BasicArrayList = new BasicArrayListD()

        {
            while (this.hasMoreElements(enumeration)) {
                basicArrayList.add(this.nextElement(enumeration))
            }
        }
        return basicArrayList.toArray()
    }

}

object EnumerationUtil {
    private val instance : EnumerationUtil = new EnumerationUtil()

    /**      * @return the instance      */
    @JsMethod
    def getInstance() : EnumerationUtil = {
        return EnumerationUtil.instance
    }

}


