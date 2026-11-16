/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic

import _root_.org.allbinary.util.ABHashMap
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.ABStack
import _root_.org.allbinary.util.ABVector

//NoPlatform
class StdUtil {
    import _root_.org.allbinary.logic.StdUtil.{*}

    //ActualPlatform
    val EMPTY_VECTOR : ABVector[Object] = this.createVector()

    //ActualPlatform
    val NULL_TABLE : ABHashtable[Object, Object] = this.createHashtable()

    //ActualPlatform
    val NULL_MAP : ABHashMap[Object, Object] = this.createHashMap()

    final def createStack() : ABStack[Object] = {
        return new ABStack[Object]()
    }

    final def createVector() : ABVector[Object] = {
        return new ABVector[Object]()
    }

    final def createHashtable() : ABHashtable[Object, Object] = {
        return new ABHashtable[Object, Object]()
    }

    final def createHashMap() : ABHashMap[Object, Object] = {
        return new ABHashMap[Object, Object]()
    }

}

object StdUtil {
    private val instance : StdUtil = new StdUtil()

    //ActualPlatform
    def getInstance() : StdUtil = {
        return StdUtil.instance
    }

}


