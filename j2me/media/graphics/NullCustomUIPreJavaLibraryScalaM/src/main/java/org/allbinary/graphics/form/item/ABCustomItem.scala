/* Generated Code Do Not Modify */
package org.allbinary.graphics.form.item

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Screen
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.string.StringUtil

class ABCustomItem(param_label : String, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) {
    import _root_.org.allbinary.graphics.form.item.ABCustomItem.{*}

    //Constructor
    {
        val label : String = param_label
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
    }

    def setOwner(owner : Screen) : Unit = {
    }

    def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
    }

    def paintUnselected(graphics : Graphics, x : Int, y : Int) : Unit = {
    }

    def isFocusable() : Boolean = {
        return false
    }

    def getLabel() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    def setLabel(label : String) : Unit = {
    }

    def getHeight() : Int = {
        return 0
    }

    def setHeight(height : Int) : Unit = {
    }

    def getValue() : Float = {
        return 0.0f
    }

    def setValue(value : Float) : Unit = {
    }

    def getMinimumWidth() : Int = {
        return 0
    }

    def getMinimumHeight() : Int = {
        return 0
    }

    def preMeasurement(graphics : Graphics) : Unit = {
    }

}

object ABCustomItem {
    var NULL_CUSTOM_ITEM : Object = NullUtil.getInstance().NULL_OBJECT

    def getNullInstance() : ABCustomItem = {
        if (ABCustomItem.NULL_CUSTOM_ITEM eq NullUtil.getInstance().NULL_OBJECT) {
            ABCustomItem.NULL_CUSTOM_ITEM = new ABCustomItem(StringUtil.getInstance().EMPTY_STRING, BasicColorFactory.getInstance().BLACK, BasicColorFactory.getInstance().WHITE)
        }
        return ABCustomItem.NULL_CUSTOM_ITEM.asInstanceOf[ABCustomItem]
    }

}


