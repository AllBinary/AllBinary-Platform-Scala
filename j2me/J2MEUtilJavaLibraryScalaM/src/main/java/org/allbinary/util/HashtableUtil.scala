/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.util

import _root_.java.util.Enumeration
import _root_.jsinterop.annotations.JsType

@JsType
class HashtableUtil {
    import _root_.org.allbinary.util.HashtableUtil.{*}

    private val enumerationUtil : EnumerationUtil = EnumerationUtil.getInstance()

    def putAll(fromHashtable : ABHashtable[Object, Object], hashtable : ABHashtable[Object, Object]) : Unit = {
        val enumeration : Enumeration[? <: Object] = fromHashtable.keys().asInstanceOf[Enumeration[? <: Object]]
        var keyCanBeNull : Object = null
        var valueCanBeNull : Object = null

        {
            while (this.enumerationUtil.hasMoreElements(enumeration)) {
                keyCanBeNull = this.enumerationUtil.nextElement(enumeration)
                valueCanBeNull = hashtable.get(keyCanBeNull)
                if (valueCanBeNull == null) {
                } else {
                    hashtable.put(keyCanBeNull, valueCanBeNull)
                }
            }
        }
    }

    def getKeysAsArray(hashtable : ABHashtable[Object, Object]) : Array[Object] = {
        //return hashtable.keySet().toArray();
        val objectArray : Array[Object] = new Array[Object](hashtable.size())
        var index : Int = 0
        val enumeration : Enumeration[? <: Object] = hashtable.keys().asInstanceOf[Enumeration[? <: Object]]

        {
            while (this.enumerationUtil.hasMoreElements(enumeration)) {
                objectArray({ val value_N67452 = index; index += 1; value_N67452 }) = this.enumerationUtil.nextElement(enumeration)
            }
        }
        return objectArray
    }

    def getKeysAsList(hashtable : ABHashtable[Object, Object]) : BasicArrayList = {
        //return hashtable.keySet().toArray();
        val list : BasicArrayList = new BasicArrayListS(hashtable.size())
        val enumeration : Enumeration[? <: Object] = hashtable.keys().asInstanceOf[Enumeration[? <: Object]]

        {
            while (this.enumerationUtil.hasMoreElements(enumeration)) {
                list.add(this.enumerationUtil.nextElement(enumeration))
            }
        }
        return list
    }

}

object HashtableUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : HashtableUtil = new HashtableUtil()

    def getInstance() : HashtableUtil = {
        return HashtableUtil.instance
    }

}


