/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.exception

import _root_.jsinterop.annotations.JsType

//ActualPlatform
@JsType
class ExceptionUtil private() {
    import _root_.org.allbinary.logic.java.exception.ExceptionUtil.{PRETEND_EXCEPTION as _, *}
    def PRETEND_EXCEPTION : Exception = _root_.org.allbinary.logic.java.exception.ExceptionUtil.PRETEND_EXCEPTION

    private val NONE : String = "No Stack Trace"

    //ActualPlatform
    def getStackTrace(e : Throwable) : String = {
        e.printStackTrace()
        return this.NONE
    }

}

object ExceptionUtil {
    private val instance : ExceptionUtil = new ExceptionUtil()

    //ActualPlatform
    def getInstance() : ExceptionUtil = {
        return ExceptionUtil.instance
    }

    //ActualPlatform
    val PRETEND_EXCEPTION : Exception = new Exception("Not Really An Exception")

}


