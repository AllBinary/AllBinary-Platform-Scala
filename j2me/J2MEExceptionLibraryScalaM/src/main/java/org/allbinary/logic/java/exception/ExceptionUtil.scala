/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.exception

import _root_.java.io.ByteArrayOutputStream

//ActualPlatform
class ExceptionUtil private() {
    import _root_.org.allbinary.logic.java.exception.ExceptionUtil.{*}

    //ActualPlatform
    val PRETEND_EXCEPTION : Exception = new Exception("Not Really An Exception")

    private val NONE : String = "No Stack Trace"

    //ActualPlatform
    def getStackTrace(e : Throwable) : String = {
        val bs : ByteArrayOutputStream = new ByteArrayOutputStream()
        e.printStackTrace()
        val output : String = bs.toString()
        //        if (output != null) {
        return new String(output)
    }

}

object ExceptionUtil {
    private val instance : ExceptionUtil = new ExceptionUtil()

    //ActualPlatform
    def getInstance() : ExceptionUtil = {
        return ExceptionUtil.instance
    }

}


