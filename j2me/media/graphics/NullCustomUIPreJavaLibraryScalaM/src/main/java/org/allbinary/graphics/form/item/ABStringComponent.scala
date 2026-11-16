/* Generated Code Do Not Modify */
package org.allbinary.graphics.form.item

import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory

class ABStringComponent(param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) {
    import _root_.org.allbinary.graphics.form.item.ABStringComponent.{NULL_STRING_COMPONENT as _, *}
    def NULL_STRING_COMPONENT : ABStringComponent = _root_.org.allbinary.graphics.form.item.ABStringComponent.NULL_STRING_COMPONENT

    //Constructor
    {
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
    }

    def getBackgroundBasicColor() : BasicColor = {
        return BasicColorFactory.getInstance().WHITE
    }

    def getForegroundBasicColor() : BasicColor = {
        return BasicColorFactory.getInstance().WHITE
    }

    def setForegroundBasicColor(foregroundBasicColor : BasicColor) : Unit = {
    }

}

object ABStringComponent {
    val NULL_STRING_COMPONENT : ABStringComponent = new ABStringComponent(BasicColorFactory.getInstance().BLACK, BasicColorFactory.getInstance().WHITE)

}


