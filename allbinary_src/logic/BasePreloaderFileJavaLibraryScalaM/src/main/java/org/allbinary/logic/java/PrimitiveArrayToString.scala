/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java

import _root_.org.allbinary.logic.string.StringMaker

class PrimitiveArrayToString {
    import _root_.org.allbinary.logic.java.PrimitiveArrayToString.{*}

}

object PrimitiveArrayToString {
    def toString(floats : Array[Float]) : String = {
        val stringBuffer : StringMaker = new StringMaker()

        {
            var index : Int = 0
            while (index < floats.length) {
                stringBuffer.appendfloat(floats(index))
                index += 1
            }
        }
        return stringBuffer.toString()
    }

}


