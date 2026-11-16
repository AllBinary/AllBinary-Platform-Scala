/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot * */
/* Generated Code Do Not Modify */
package org.allbinary.string

import _root_.jsinterop.annotations.JsType
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsProperty

/**  *  * @author User  */
@JsType
class CommonLabels {
    import _root_.org.allbinary.string.CommonLabels.{*}

    @JsProperty
    val WIDTH_LABEL : String = " Width: "

    @JsProperty
    val HEIGHT_LABEL : String = " Height: "

    @JsProperty
    val END_LABEL : String = "End: "

    @JsProperty
    val TOTAL_LABEL : String = "Total: "

    @JsProperty
    val INDEX_LABEL : String = "index: "

    @JsProperty
    val START_LABEL : String = "Start: "

    @JsProperty
    val COMMAND_LABEL : String = "Command: "

    @JsProperty
    val NAME_LABEL : String = "Name: "

    @JsProperty
    val START : String = this.START_LABEL

    @JsProperty
    val ELAPSED : String = " Elapsed: "

    @JsProperty
    val CURRENT : String = " Current: "

    @JsProperty
    val NEXT : String = "Next"

    @JsProperty
    val ITEM_LABEL : String = "Item: "

    @JsProperty
    val RESULT_ : String = "Result: "

    @JsProperty
    val COLON_SEP : String = ": "

}

object CommonLabels {
    private val instance : CommonLabels = new CommonLabels()

    /**      * @return the instance      */
    @JsMethod
    def getInstance() : CommonLabels = {
        return CommonLabels.instance
    }

}


