/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.html.input


class HtmlPasswordInput(param_before : String, param_name : String, param_value : String, param_after : String) extends HtmlLengthInput(param_before, HtmlInputData.getInstance().PASSWORD, param_name, param_value, param_after) {

    //Constructor
    {
        val before : String = param_before
        val name : String = param_name
        val value : String = param_value
        val after : String = param_after
        setSize(new Integer(32))
        setMaxLength(new Integer(128))
    }

}


