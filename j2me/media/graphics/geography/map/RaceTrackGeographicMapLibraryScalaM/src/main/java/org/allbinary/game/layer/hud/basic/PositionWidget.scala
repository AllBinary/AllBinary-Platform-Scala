/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.hud.basic

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.game.graphics.hud.BasicHud
import _root_.org.allbinary.graphics.color.BasicColor

//super.paint(graphics, positionString, currentPostString, offset2, offset);
class PositionWidget(param_position : Int, param_location : Int, param_direction : Int, param_basicColor : BasicColor) extends BasicHud(param_location, param_direction, 2, param_basicColor) {
    import _root_.org.allbinary.game.layer.hud.basic.PositionWidget.{*}

    private var position : Int = 0

    private var positionString : String = StringUtil.getInstance().EMPTY_STRING

    //Constructor
    {
        val position : Int = param_position
        val location : Int = param_location
        val direction : Int = param_direction
        val basicColor : BasicColor = param_basicColor
        this.updateMaxHeight = 10
        this.updateMaxWidth = 40
    }

    def get() : Int = {
        return this.position
    }

    def set(position : Int) : Unit = {
        this.position = position
        this.positionString = PositionWidget.toString(this.get())
    }

    def paint(graphics : Graphics) : Unit = {
        super.paintString(graphics, this.positionString)
    }

}

object PositionWidget {
    def toString(position : Int) : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(Integer.toString(position))
        if (position == 1) {
            stringBuffer.append("st")
        } else if (position == 2) {
            stringBuffer.append("nd")
        } else if (position == 3) {
            stringBuffer.append("rd")
        } else {
            stringBuffer.append("th")
        }
        return stringBuffer.toString()
    }

}


