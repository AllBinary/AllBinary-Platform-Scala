/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.anyType.clazz

import _root_.org.allbinary.logic.java.anyType.ConstructorUtil
import _root_.org.allbinary.logic.java.anyType.InterfaceUtil
import _root_.org.allbinary.logic.java.anyType.MethodUtil
import _root_.org.allbinary.logic.string.StringMaker

class ClassUtil private() {
    import _root_.org.allbinary.logic.java.anyType.clazz.ClassUtil.{*}

}

object ClassUtil {
    // Usage = allbinary.util.objectinfo.ObjectInfo.viewAll(object);
    def viewAll(anyType : Object, lineBreak : String) : String = {
        if (anyType != null) {
            return ClassUtil.viewAll(anyType.getClass(), lineBreak)
        } else {
            return "Object Null"
        }
        throw new IllegalStateException()
    }

    // Usage = allbinary.util.objectinfo..viewAll(object);
    def viewAll(myClass : Class[?], lineBreak : String) : String = {
        if (myClass != null) {
            var stringBuffer : StringMaker = new StringMaker()
            var classes : Array[Class[?]] = myClass.getClasses()
            stringBuffer.append(lineBreak)
            stringBuffer.append("Class: ")
            stringBuffer.append(myClass.getName())
            stringBuffer.append(" uses ")
            stringBuffer.appendint(classes.length)
            stringBuffer.append(" other classes")
            stringBuffer.append(lineBreak)
            stringBuffer.append(lineBreak)
            stringBuffer.append("Classes: ")
            stringBuffer.append(lineBreak)

            {
                var index : Int = 0
                while (index < classes.length) {
                    stringBuffer.append("Class: ")
                    stringBuffer.append(classes(index).getName())
                    stringBuffer.append(lineBreak)
                    index += 1
                }
            }
            stringBuffer.append(InterfaceUtil.viewAll(myClass, lineBreak))
            stringBuffer.append(lineBreak)
            stringBuffer.append(ConstructorUtil.viewAll(myClass, lineBreak))
            stringBuffer.append(lineBreak)
            stringBuffer.append(MethodUtil.viewAll(myClass, lineBreak))
            return stringBuffer.toString()
        } else {
            return "Class Null"
        }
        throw new IllegalStateException()
    }

}


