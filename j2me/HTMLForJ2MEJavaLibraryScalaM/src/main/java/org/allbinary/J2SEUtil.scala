/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary

import _root_.java.util.HashMap
import _root_.java.util.Map
import _root_.java.util.Set

//HTMLForJ2ME
class J2SEUtil {
    import _root_.org.allbinary.J2SEUtil.{*}

    def getHashMapAsArray(hashMap : HashMap[Object, Object]) : Array[Object] = {
        val objectArray : Array[Object] = hashMap.keySet().toArray()
        return objectArray
    }

    def getMapAsArray(map : Map[Object, Object]) : Array[Object] = {
        val objectArray : Array[Object] = map.keySet().toArray()
        return objectArray
    }

    def getSetAsArray(set : Set[String]) : Array[Object] = {
        val objectArray : Array[Object] = set.toArray()
        return objectArray
    }

}

object J2SEUtil {
    private val instance : J2SEUtil = new J2SEUtil()

    /**      * @return the instance      */
    def getInstance() : J2SEUtil = {
        return J2SEUtil.instance
    }

}


