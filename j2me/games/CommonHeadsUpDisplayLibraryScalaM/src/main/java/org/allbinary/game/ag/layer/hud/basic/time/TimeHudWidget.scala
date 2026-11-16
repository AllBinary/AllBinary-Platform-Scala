/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.hud.basic.time

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.graphics.hud.BasicHud
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.logic.math.PrimitiveLongSingleton

class TimeHudWidget(param_location : Int, param_direction : Int, param_bufferZone : Int, param_basicColor : BasicColor, param_timer : HudTimer) extends BasicHud(param_location, param_direction, param_bufferZone, param_basicColor) {
    import _root_.org.allbinary.game.ag.layer.hud.basic.time.TimeHudWidget.{*}

    private val TIME_STRING : String = "Time "

    private val TIME_CHAR_ARRAY : Array[Char] = Array[Char]('T', 'i', 'm', 'e', ' ')

    private var offset : Int = 0

    // private String string = StringUtil.getInstance();
    private var string : Array[Char] = PrimitiveLongSingleton.getInstance().ZERO

    private var totalDigits : Int = 1

    private var timer : HudTimer = null

    //Constructor
    {
        val location : Int = param_location
        val direction : Int = param_direction
        val bufferZone : Int = param_bufferZone
        val basicColor : BasicColor = param_basicColor
        val timer : HudTimer = param_timer
        this.timer = timer
        this.set()
        this.updateMaxHeight = 14
    }

    //    }
    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.updateMaxWidth = font.getSize() * 5
        this.offset = font.stringWidth(this.TIME_STRING) + MyFontProcessor.defaultStringWidth(font, 3)
        super.updateMeasurement(graphics)
    }

    def update() : Unit = {
        this.timer.update()
        this.set()
    }

    private def set() : Unit = {
        // this.string = trackTimer;
        this.string = this.timer.getTimeChars()
        this.totalDigits = this.timer.getCurrentTotalDigits()
    }

    /*     public void setTrackTimer(HudTimer trackTimer)     {         this.trackTimer = trackTimer;     }     */
    def getTimer() : HudTimer = {
        return this.timer
    }

    def paint(graphics : Graphics) : Unit = {
        super.paintDX(graphics, this.TIME_CHAR_ARRAY, 0, this.TIME_CHAR_ARRAY.length, this.string, 0, this.totalDigits, this.offset)
    }

}

object TimeHudWidget {
    def getInstance(location : Int, direction : Int, basicColor : BasicColor, timer : HudTimer) : TimeHudWidget = {
        return new TimeHudWidget(location, direction, 2, basicColor, timer)
    }

}


