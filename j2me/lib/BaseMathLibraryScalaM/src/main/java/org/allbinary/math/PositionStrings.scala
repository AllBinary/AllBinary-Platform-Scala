/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.math

import _root_.jsinterop.annotations.JsType
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsProperty

@JsType
class PositionStrings {
    import _root_.org.allbinary.math.PositionStrings.{*}

    @JsProperty
    val X : String = "x"

    @JsProperty
    val Y : String = "y"

    @JsProperty
    val X_LABEL : String = "x: "

    @JsProperty
    val Y_LABEL : String = "y: "

    @JsProperty
    val Z_LABEL : String = "z: "

    @JsProperty
    val DX_LABEL : String = "dx: "

    @JsProperty
    val DY_LABEL : String = "dy: "

    @JsProperty
    val DZ_LABEL : String = "dz: "

}

object PositionStrings {
    private val instance : PositionStrings = new PositionStrings()

    @JsMethod
    def getInstance() : PositionStrings = {
        return PositionStrings.instance
    }

}


