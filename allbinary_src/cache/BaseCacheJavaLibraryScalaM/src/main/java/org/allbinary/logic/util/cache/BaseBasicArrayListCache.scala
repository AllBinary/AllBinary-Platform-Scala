/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.cache

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsProperty

/**  *  * @author user  */
@JsType
class BaseBasicArrayListCache {

    @JsProperty
    val list : BasicArrayList = new BasicArrayListD()

    @JsMethod
    def log() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("S: ")
        stringBuffer.appendint(this.list.size())
        return stringBuffer.toString()
    }

}


