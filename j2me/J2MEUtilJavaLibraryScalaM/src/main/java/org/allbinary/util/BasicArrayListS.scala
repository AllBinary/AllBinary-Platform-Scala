/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.util

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.jsinterop.annotations.JsConstructor

/**  *  * @author User  */
@JsType
class BasicArrayListS(param_size : Int) extends BasicArrayList(NullUtil.getInstance().NULL_OBJECT_ARRAY) {

    //Constructor
    {
        val size : Int = param_size
        //currentIndex = 0;
        if (size < 0) {
            throw new IllegalArgumentException(new StringMaker().append("Init Size Exception: ").appendint(size).toString())
        }
        this.objectArray = new Array[Object](size)
    }

}


