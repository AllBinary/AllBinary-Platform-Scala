/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.hud.basic

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.game.graphics.hud.BasicHud
import _root_.org.allbinary.game.layer.hud.LapInfo
import _root_.org.allbinary.graphics.color.BasicColor

class LapWidget(param_location : Int, param_direction : Int, param_basicColor : BasicColor) extends BasicHud(param_location, param_direction, 2, param_basicColor) {

    private val LAP_STR : String = "Lap "

    private val OF_STR : String = " of "

    private var string : String = StringUtil.getInstance().EMPTY_STRING

    //Constructor
    {
        val location : Int = param_location
        val direction : Int = param_direction
        val basicColor : BasicColor = param_basicColor
        this.updateMaxHeight = 15
        this.updateMaxWidth = 40
    }

    def update(lapInfo : LapInfo) : Unit = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(this.LAP_STR)
        stringBuffer.appendint(lapInfo.getCurrentLap())
        stringBuffer.append(this.OF_STR)
        stringBuffer.appendint(lapInfo.getTotalLaps())
        this.string = stringBuffer.toString()
    }

    def paint(graphics : Graphics) : Unit = {
        super.paintString(graphics, this.string)
    }

}


