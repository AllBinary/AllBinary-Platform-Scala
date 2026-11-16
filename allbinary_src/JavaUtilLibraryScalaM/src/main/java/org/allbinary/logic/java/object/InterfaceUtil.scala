/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.anyType

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

class InterfaceUtil private() {
    import _root_.org.allbinary.logic.java.anyType.InterfaceUtil.{*}

}

object InterfaceUtil {
    def viewAll(myClass : Class[?], lineBreak : String) : String = {
        val stringBuffer : StringMaker = new StringMaker()
        val interfaces : Array[Class[?]] = myClass.getInterfaces()
        stringBuffer.append(lineBreak)
        stringBuffer.append("Interfaces: ")
        stringBuffer.append(lineBreak)

        {
            var index : Int = 0
            while (index < interfaces.length) {
                stringBuffer.append("Interface: ")
                stringBuffer.append(interfaces(index).getName())
                stringBuffer.append(lineBreak)
                index += 1
            }
        }
        return stringBuffer.toString()
    }

    def getClass(interfaceName : String, interfaces : Array[Class[?]]) : Class[?] = {
        if (((interfaceName != null) && (interfaces != null)) && (interfaces.length > 0)) {

            {
                var index : Int = 0
                while (index < interfaces.length) {
                    if (interfaces(index).getName().indexOf(interfaceName) >= 0) {
                        return interfaces(index)
                    }
                    index += 1
                }
            }
        }
        return null
    }

    def isImplemented(clazz : Class[?], anyType : Object) : Boolean = {
        var classes : Array[Class[?]] = anyType.getClass().getInterfaces()

        {
            var index : Int = 0
            while (index < classes.length) {
                if (clazz.getName().compareTo(classes(index).getName()) == 0) {
                    return true
                }
                index += 1
            }
        }
        return false
    }

    def isImplemented(className : String, anyType : Object) : Boolean = {
        var classes : Array[Class[?]] = anyType.getClass().getInterfaces()

        {
            var index : Int = 0
            while (index < classes.length) {
                if (classes(index).getName().indexOf(className) == 0) {
                    return true
                }
                index += 1
            }
        }
        return false
    }

    def isImplementedView(clazz : Class[?], anyType : Object) : String = {
        var stringBuffer : StringMaker = new StringMaker()
        var classes : Array[Class[?]] = anyType.getClass().getInterfaces()
        stringBuffer.append("isImplementedView: \n")

        {
            var index : Int = 0
            while (index < classes.length) {
                stringBuffer.append(clazz.getName())
                stringBuffer.append(" should be = ")
                stringBuffer.append(classes(index).getName())
                stringBuffer.append(classes(index).getName())
                stringBuffer.append(CommonSeps.getInstance().NEW_LINE)
                index += 1
            }
        }
        return stringBuffer.toString()
    }

}


