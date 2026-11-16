/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.html.input


class HtmlLengthInput(param_before : String, param_type : String, param_name : String, param_value : String, param_after : String) extends HtmlValueInput(param_before, param_type, param_name, param_value, param_after) {

    private val MAXLENGTH : String = "MAXLENGTH"

    private val SIZE : String = "SIZE"

    private var length : String = null

    private var size : String = null

    //Constructor
    {
        val before : String = param_before
        val `type` : String = param_type
        val name : String = param_name
        val value : String = param_value
        val after : String = param_after
    }

    def setMaxLength(length : Integer) : Unit = {
        this.length = new String(length.toString())
        addAttribute(this.MAXLENGTH, this.length)
    }

    def setSize(size : Integer) : Unit = {
        this.size = new String(size.toString())
        addAttribute(this.MAXLENGTH, this.size)
    }

}


