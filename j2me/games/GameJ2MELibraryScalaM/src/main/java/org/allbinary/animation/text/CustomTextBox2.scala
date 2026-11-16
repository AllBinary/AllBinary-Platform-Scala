/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.text

import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.Font
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.form.item.CustomTextBox

/**  *  * @author User  */
class CustomTextBox2(param_cmdListener : CommandListener, param_label : String, param_text : String, param_maxSize : Int, param_constraints : Int, param_font : Font, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends CustomTextBox(param_cmdListener, param_label, param_text, param_maxSize, param_constraints, param_font, param_backgroundBasicColor, param_foregroundBasicColor) {

    //Constructor
    {
        val cmdListener : CommandListener = param_cmdListener
        val label : String = param_label
        val text : String = param_text
        val maxSize : Int = param_maxSize
        val constraints : Int = param_constraints
        val font : Font = param_font
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        this.getTextFieldItem().setFocus(true)
    }

}


