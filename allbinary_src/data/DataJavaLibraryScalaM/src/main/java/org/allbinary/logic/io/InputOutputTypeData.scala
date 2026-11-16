/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io


class InputOutputTypeData private() {
    import _root_.org.allbinary.logic.io.InputOutputTypeData.{*}

    //Use File for testing purposes or DB blob limitations
    val NAME : String = "INPUT_OUTPUT_TYPE_NAME"

    val FILE : String = "INPUT_OUTPUT_TYPE_FILE"

    val RESPONSE : String = "INPUT_OUTPUT_TYPE_RESPONSE"

    val DB : String = "INPUT_OUTPUT_TYPE_DB"

    val JSP : String = "jsp"

    val JSP_FRAGMENT : String = "jspf"

    val PHP : String = "php"

    val ASP : String = "asp"

    val PL : String = "pl"

    val DEFAULT : String = this.JSP

    val DEFAULT_FRAGMENT : String = this.JSP_FRAGMENT

}

object InputOutputTypeData {
    private val instance : InputOutputTypeData = new InputOutputTypeData()

    def getInstance() : InputOutputTypeData = {
        return InputOutputTypeData.instance
    }

}


