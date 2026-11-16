/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.anyType

import _root_.java.lang.reflect.Method
import _root_.org.allbinary.logic.string.StringMaker

class MethodUtil private() {
    import _root_.org.allbinary.logic.java.anyType.MethodUtil.{*}

}

object MethodUtil {
    def viewAll(myClass : Class[?], lineBreak : String) : String = {
        var stringBuffer : StringMaker = new StringMaker()
        var method : Array[Method] = myClass.getMethods()
        stringBuffer.append("Methods: ")
        stringBuffer.append(lineBreak)

        {
            var index : Int = 0
            while (index < method.length) {
                stringBuffer.append(method(index).getReturnType().getName())
                stringBuffer.append(" ")
                stringBuffer.append(method(index).getName())
                stringBuffer.append("(")
                ParamsUtil.viewParams(method(index).getParameterTypes())
                stringBuffer.append(")")
                stringBuffer.append(lineBreak)
                index += 1
            }
        }
        return stringBuffer.toString()
    }

}


