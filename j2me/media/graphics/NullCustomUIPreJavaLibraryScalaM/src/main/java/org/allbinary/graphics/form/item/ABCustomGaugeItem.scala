/* Generated Code Do Not Modify */
package org.allbinary.graphics.form.item

import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.logic.string.StringUtil

class ABCustomGaugeItem(param_label : String, param_maxValue : Int, param_initialValue : Int, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends ABCustomItem(param_label, param_backgroundBasicColor, param_foregroundBasicColor) {
    import _root_.org.allbinary.graphics.form.item.ABCustomGaugeItem.{NULL_GAUGE_ITEM as _, *}
    def NULL_GAUGE_ITEM : ABCustomGaugeItem = _root_.org.allbinary.graphics.form.item.ABCustomGaugeItem.NULL_GAUGE_ITEM

    //Constructor
    {
        val label : String = param_label
        val maxValue : Int = param_maxValue
        val initialValue : Int = param_initialValue
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
    }

}

object ABCustomGaugeItem {
    val NULL_GAUGE_ITEM : ABCustomGaugeItem = new ABCustomGaugeItem(StringUtil.getInstance().EMPTY_STRING, 1, 0, BasicColorFactory.getInstance().BLACK, BasicColorFactory.getInstance().WHITE)

}


