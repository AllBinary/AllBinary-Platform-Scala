/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.html.input

import _root_.org.allbinary.logic.string.StringUtil

class HtmlValueInput(param_before : String, param_type : String, param_name : String, param_value : String, param_after : String) extends HtmlInput(param_before, param_type, param_name, param_after) {

    private var value : String = null

    private val VALUE : String = "VALUE"

    //Constructor
    {
        val before : String = param_before
        val `type` : String = param_type
        val name : String = param_name
        val value : String = param_value
        val after : String = param_after
        val stringUtil : StringUtil = StringUtil.getInstance()
        this.value = stringUtil.EMPTY_STRING
        addAttribute(this.VALUE, value)
    }

}


