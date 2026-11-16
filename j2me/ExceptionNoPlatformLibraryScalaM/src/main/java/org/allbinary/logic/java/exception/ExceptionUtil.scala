/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.exception


//NoPlatform
class ExceptionUtil private() {
    import _root_.org.allbinary.logic.java.exception.ExceptionUtil.{*}

    val PRETEND_EXCEPTION : Exception = new Exception("Not Really An Exception")

    def getStackTrace(e : Throwable) : String = {
        throw new RuntimeException()
    }

}

object ExceptionUtil {
    private val instance : ExceptionUtil = new ExceptionUtil()

    /**      * @return the instance      */
    def getInstance() : ExceptionUtil = {
        return ExceptionUtil.instance
    }

}


