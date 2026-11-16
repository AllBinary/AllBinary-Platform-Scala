/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.hud.basic.level

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.graphics.hud.BasicHud
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.paint.PaintableInterface
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.math.PrimitiveLongUtil

class LevelHudWidget(param_maxlevel : Int, param_location : Int, param_direction : Int) extends BasicHud(param_location, param_direction, 2, BasicColorFactory.getInstance().GREY) with PaintableInterface {
    import _root_.org.allbinary.game.ag.layer.hud.basic.level.LevelHudWidget.{*}

    private var level : Int = 0

    private var maxlevel : Int = 0

    //private String levelString;
    private var levelString : Array[Char] = null

    private var levelNumberCharArray : Array[Char] = NullUtil.getInstance().NULL_CHAR_ARRAY

    private var levelNumberTotalDigits : Int = 0

    private var offset : Int = 0

    private var primitiveLongUtil : PrimitiveLongUtil = null

    //Constructor
    {
        val maxlevel : Int = param_maxlevel
        val location : Int = param_location
        val direction : Int = param_direction
        this.primitiveLongUtil = PrimitiveLongUtil.createPowerOfTen(1000)
        val LEVEL : String = "Lv "
        this.levelString = LEVEL.toCharArray()
        //Add size for space
        this.maxlevel = maxlevel
        this.level = maxlevel
        this.update()
        this.updateMaxHeight = 14
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.updateMaxWidth = font.getSize() * 4
        this.offset = font.charsWidth(this.levelString, 0, this.levelString.length) + font.getSize()
        super.updateMeasurement(graphics)
    }

    private def update() : Unit = {
        this.levelNumberCharArray = this.primitiveLongUtil.getCharArray(this.level)
        this.levelNumberTotalDigits = this.primitiveLongUtil.getCurrentTotalDigits()
    }

    def setLevel(level : Int) : Unit = {
        this.level = level
        this.update()
    }

    def nextLevel() : Unit = {
        this.level += 1
        this.update()
    }

    def previousLevel() : Unit = {
        this.level -= 1
        if (this.level < 0) {
            this.level = 0
        }
        this.update()
    }

    def isComplete() : Boolean = {
        if (this.level <= this.maxlevel) {
            return false
        } else {
            return true
        }
        throw new IllegalStateException()
    }

    override def paint(graphics : Graphics) : Unit = {
        super.paintDX(graphics, this.levelString, 0, this.levelString.length, this.levelNumberCharArray, 0, this.levelNumberTotalDigits, this.offset)
    }

    override def paintThreed(graphics : Graphics) : Unit = {
    }

}

object LevelHudWidget {
    def createHud(maxlevel : Int, location : Int, direction : Int) : LevelHudWidget = {
        return new LevelHudWidget(maxlevel, location, direction)
    }

}


