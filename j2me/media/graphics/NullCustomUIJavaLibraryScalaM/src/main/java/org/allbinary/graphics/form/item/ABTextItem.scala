/* Generated Code Do Not Modify */
package org.allbinary.graphics.form.item

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.color.BasicColor

class ABTextItem(param_label : String, param_layout : Int, param_altText : String, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends CustomCustomItem(param_label, param_backgroundBasicColor, param_foregroundBasicColor) with ABCustomItemInterface {

    //Constructor
    {
        val label : String = param_label
        val layout : Int = param_layout
        val altText : String = param_altText
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
    }

    def keyPressed(keyCode : Int) : Unit = {
    }

    override def paintUnselected(graphics : Graphics, x : Int, y : Int) : Unit = {
    }

    def getLabelStringComponent() : ABStringComponent = {
        return ABStringComponent.NULL_STRING_COMPONENT
    }

    //Needed for polyglot do not remove
    override def getMinimumWidth() : Int = {
        return super.getMinimumWidth()
    }

    //Needed for polyglot do not remove
    override def getMinimumHeight() : Int = {
        return super.getMinimumHeight()
    }

    //Needed for polyglot do not remove
    override def getLabel() : String = {
        return super.getLabel()
    }

    //Needed for polyglot do not remove
    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        super.paintXY(graphics, x, y)
    }

}


