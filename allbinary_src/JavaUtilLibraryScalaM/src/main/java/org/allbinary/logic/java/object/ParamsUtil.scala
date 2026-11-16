/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.anyType

import _root_.org.allbinary.logic.string.StringMaker

class ParamsUtil private() {
    import _root_.org.allbinary.logic.java.anyType.ParamsUtil.{*}

}

object ParamsUtil {
    def viewParams(params : Array[Class[?]]) : String = {
        if (params != null) {
            var stringBuffer : StringMaker = new StringMaker()

            {
                var index : Int = 0
                while (index < params.length) {
                    stringBuffer.append(" ")
                    stringBuffer.append(params(index).getName())
                    index += 1
                }
            }
            return stringBuffer.toString()
        } else {
            return "Params Null"
        }
        throw new IllegalStateException()
    }

}


