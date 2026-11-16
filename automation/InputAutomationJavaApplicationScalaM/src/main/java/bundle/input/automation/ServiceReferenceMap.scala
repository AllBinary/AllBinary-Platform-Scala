/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package bundle.input.automation

import _root_.java.util.Collection
import _root_.java.util.Map
import _root_.java.util.Set
import _root_.org.osgi.framework.ServiceReference
import _root_.org.allbinary.logic.string.StringMaker

class ServiceReferenceMap(param_serviceReference : ServiceReference) extends Map[Object, Object] {
    import _root_.bundle.input.automation.ServiceReferenceMap.{*}

    private var serviceReference : ServiceReference = null

    //Constructor
    {
        val serviceReference : ServiceReference = param_serviceReference
        this.serviceReference = serviceReference
    }

    def size() : Int = {
        return -1
    }

    def isEmpty() : Boolean = {
        return false
    }

    def containsKey(key : Object) : Boolean = {
        return false
    }

    def containsValue(value : Object) : Boolean = {
        return false
    }

    def get(key : Object) : Object = {
        return this.serviceReference.getProperty(key.asInstanceOf[String])
    }

    def put(key : Object, value : Object) : Object = {
        return null
    }

    def remove(key : Object) : Object = {
        return null
    }

    def putAll(m : Map[? <: Object, ? <: Object]) : Unit = {
    }

    def clear() : Unit = {
    }

    def keySet() : Set[Object] = {
        //Set set
        var keyStringArray : Array[String] = this.serviceReference.getPropertyKeys()
        return null
    }

    def values() : Collection[Object] = {
        return null
    }

    def entrySet() : Set[Map.Entry[Object, Object]] = {
        return null
    }

}

object ServiceReferenceMap {
    def toString(map : Map[?, ?]) : String = {
        var stringBuffer : StringMaker = new StringMaker()
        /*         for(int index2 = 0; index2 < map.keySet().length; index2++)         {             stringBuffer.append(keyStringArray[index2]);             stringBuffer.append(" = ");             Object value = serviceReference.getProperty(keyStringArray[index2]);             if(value instanceof String)             {                 stringBuffer.append(value);             }             else                 if(value instanceof String[])                 {                 String[] stringArray = (String[]) value;                 for(int index3 = 0; index3 < stringArray.length; index3++)                 {                     stringBuffer.append(stringArray[index3]);                     stringBuffer.append(", ");                 }                 }             stringBuffer.append(" ");         }         */
        return stringBuffer.toString()
    }

}


