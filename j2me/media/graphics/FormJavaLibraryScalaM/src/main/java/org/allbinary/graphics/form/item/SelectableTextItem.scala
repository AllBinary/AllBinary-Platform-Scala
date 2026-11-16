/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form.item

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.color.BasicColor

class SelectableTextItem(param_label : String, param_layout : Int, param_altText : String, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends ABTextItem(param_label, param_layout, param_altText, param_backgroundBasicColor, param_foregroundBasicColor) {

    //Constructor
    {
        val label : String = param_label
        val layout : Int = param_layout
        val altText : String = param_altText
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
    }

    override def isFocusable() : Boolean = {
        return true
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.myFontProcessor.process(graphics)
        var stringComponent : ABStringComponent = this.getLabelStringComponent()
        if (stringComponent != null) {
            graphics.setColor(stringComponent.getForegroundBasicColor().intValue())
        }
        graphics.drawString(this.getLabel(), x + 2, y, 0)
    }

}


