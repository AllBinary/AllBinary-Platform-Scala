/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.anyType

import _root_.java.lang.reflect.Constructor
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

class ConstructorUtil private() {
    import _root_.org.allbinary.logic.java.anyType.ConstructorUtil.{*}

}

object ConstructorUtil {
    def viewAll(myClass : Class[?], lineBreak : String) : String = {
        val stringBuffer : StringMaker = new StringMaker()
        val constructor : Array[Constructor[?]] = myClass.getConstructors()
        stringBuffer.append("Constructors: ")
        stringBuffer.append(lineBreak)

        {
            var index : Int = 0
            while (index < constructor.length) {
                stringBuffer.append(ConstructorUtil.view(constructor(index), lineBreak))
                index += 1
            }
        }
        return stringBuffer.toString()
    }

    def view(constructor : Constructor[?], lineBreak : String) : String = {
        if (constructor != null) {
            val commonSeps : CommonSeps = CommonSeps.getInstance()
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(constructor.getName())
            val classes : Array[Class[?]] = constructor.getParameterTypes()

            {
                var index : Int = 0
                while (index < classes.length) {
                    stringBuffer.append(commonSeps.SPACE)
                    stringBuffer.append(classes(index).getName())
                    stringBuffer.append(commonSeps.COLON)
                    stringBuffer.appendint(index)
                    index += 1
                }
            }
            stringBuffer.append(lineBreak)
            return stringBuffer.toString()
        } else {
            return "Constructor Null"
        }
        throw new IllegalStateException()
    }

}


