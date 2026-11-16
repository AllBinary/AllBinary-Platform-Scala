/* Generated Code Do Not Modify */
package org.allbinary.graphics.form.item

import _root_.javax.microedition.lcdui.Canvas
import _root_.javax.microedition.lcdui.Font
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.util.visitor.Visitor

class ABTextFieldItem(param_canvas : Canvas, param_visitor : Visitor, param_label : String, param_value : String, param_maxSize : Int, param_layout : Int, param_altText : String, param_font : Font, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends ABTextItem(param_label, param_layout, param_altText, param_backgroundBasicColor, param_foregroundBasicColor) {

    private var font : Font = null

    //Constructor
    {
        val canvas : Canvas = param_canvas
        val visitor : Visitor = param_visitor
        val label : String = param_label
        val value : String = param_value
        val maxSize : Int = param_maxSize
        val layout : Int = param_layout
        val altText : String = param_altText
        val font : Font = param_font
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        this.font = font
    }

    override def getLabel() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    override def setLabel(label : String) : Unit = {
    }

    def getString() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    def setString(string : String) : Unit = {
    }

    def setFocus(state : Boolean) : Unit = {
    }

    def getFontHeight() : Int = {
        return this.font.getHeight()
    }

    def setBackgroundBasicColorP(basicColor : BasicColor) : Unit = {
    }

    def setForegroundBasicColorP(basicColor : BasicColor) : Unit = {
    }

}


