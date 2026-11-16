/*  * AllBinary Open License Version 1  * Copyright (c) 2026 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic

import _root_.jsinterop.annotations.JsType

/**  *  * @author User  */
@JsType
class ABSystemWrapper {
    import _root_.org.allbinary.logic.ABSystemWrapper.{*}

    def arraycopy(src : Object, srcPos : Int, dest : Object, destPos : Int, length : Int) : Unit = {
        System.arraycopy(src, srcPos, dest, destPos, length)
    }

    def currentTimeMillis() : Long = {
        return System.currentTimeMillis()
    }

}

object ABSystemWrapper {
    private val instance : ABSystemWrapper = new ABSystemWrapper()

    /**      * @return the instance      */
    def getInstance() : ABSystemWrapper = {
        return ABSystemWrapper.instance
    }

}


