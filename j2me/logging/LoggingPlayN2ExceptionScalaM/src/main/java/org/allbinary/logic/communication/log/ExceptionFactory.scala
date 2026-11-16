/*  * AllBinary Open License Version 1  * Copyright (c) 2026 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.jsinterop.annotations.JsType

@JsType
class ExceptionFactory {
    import _root_.org.allbinary.logic.communication.log.ExceptionFactory.{*}

}

object ExceptionFactory {
    def createThrowable(message : String) : Throwable = {
        return new Throwable(message)
    }

}


