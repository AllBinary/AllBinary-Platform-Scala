/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.string

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.logic.string.StringMaker
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsProperty

@JsType
class CommonSeps {
    import _root_.org.allbinary.string.CommonSeps.{*}

    @JsProperty
    val NEW_LINE : String = "\n"

    @JsProperty
    val SEMICOLON : String = ";"

    @JsProperty
    val EQUALS : String = "="

    @JsProperty
    val SPACE : String = " "

    @JsProperty
    val COMMA : String = ","

    @JsProperty
    val COLON : String = ":"

    @JsProperty
    val PERIOD : String = "."

    @JsProperty
    val UNDERSCORE : String = "_"

    @JsProperty
    val COLON_SEP : String = new StringMaker().append(this.COLON).append(this.SPACE).toString()

    @JsProperty
    val COMMA_SEP : String = new StringMaker().append(this.COMMA).append(this.SPACE).toString()

    @JsProperty
    val PARENTHESIS_OPEN : String = "("

    @JsProperty
    val PARENTHESIS_CLOSE : String = ")"

    @JsProperty
    val BRACE_OPEN : String = "{"

    @JsProperty
    val BRACE_CLOSE : String = "}"

    @JsProperty
    val BRACKET_OPEN : String = "["

    @JsProperty
    val BRACKET_CLOSE : String = "]"

    @JsProperty
    val DASH : String = "-"

    @JsProperty
    val PERCENT : String = "%"

    @JsProperty
    val AMPERSAND : String = "&"

    @JsProperty
    val FORWARD_SLASH : String = "/"

    @JsProperty
    val BACK_SLASH : String = "\\"

    @JsProperty
    val QUESTION : String = "?"

    @JsProperty
    val QUOTE : String = "\""

    @JsProperty
    val QUOTE_END : String = "\","

    @JsProperty
    val COMMENT : String = "//"

    @JsProperty
    val INDENT : String = "    "

}

object CommonSeps {
    private val instance : CommonSeps = new CommonSeps()

    @JsMethod
    def getInstance() : CommonSeps = {
        return CommonSeps.instance
    }

}


