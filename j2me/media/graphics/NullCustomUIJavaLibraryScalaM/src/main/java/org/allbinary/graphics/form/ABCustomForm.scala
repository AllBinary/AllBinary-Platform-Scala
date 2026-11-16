/* Generated Code Do Not Modify */
package org.allbinary.graphics.form

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.form.item.ABCustomItem
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings

class ABCustomForm(param_title : String, param_items : Array[ABCustomItem], param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends CustomScreen {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    //Constructor
    {
        val title : String = param_title
        val items : Array[ABCustomItem] = param_items
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
    }

    def getAllitems() : Array[ABCustomItem] = {
        return new Array[ABCustomItem](0)
    }

    def size() : Int = {
        return 0
    }

    def setSelectedIndex(index : Int) : Unit = {
    }

    def getSelectedIndex() : Int = {
        return 0
    }

    def deleteAll() : Unit = {
    }

    def delete(itemNum : Int) : Unit = {
    }

    def append(item : ABCustomItem) : Int = {
        return -1
    }

    def insert(itemNum : Int, item : ABCustomItem) : Unit = {
    }

    def set(itemNum : Int, item : ABCustomItem) : Unit = {
    }

    def get(itemNum : Int) : ABCustomItem = {
        return ABCustomItem.getNullInstance()
    }

    def getWidth() : Int = {
        throw new RuntimeException()
    }

    def paint(graphics : Graphics) : Unit = {
    }

    def getTitle() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

}


