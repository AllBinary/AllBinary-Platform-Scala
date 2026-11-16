/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.error


class ErrorData private() {
    import _root_.org.allbinary.business.error.ErrorData.{*}

    val NAME : String = "ERROR_NAME"

    val TEXT : String = "ERROR_TEXT"

}

object ErrorData {
    private val instance : ErrorData = new ErrorData()

    def getInstance() : ErrorData = {
        return ErrorData.instance
    }

}


