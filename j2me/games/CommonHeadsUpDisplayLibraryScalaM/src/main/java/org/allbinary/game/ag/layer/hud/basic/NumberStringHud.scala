/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.hud.basic

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.graphics.hud.BasicHud
import _root_.org.allbinary.game.graphics.hud.BasicHudFactory
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.paint.PaintableInterface
import _root_.org.allbinary.logic.math.PrimitiveLongSingleton
import _root_.org.allbinary.logic.math.PrimitiveLongUtil

class NumberStringHud(param_prependString : String, param_max : Int, param_location : Int, param_direction : Int, param_bufferZone : Int, param_basicColor : BasicColor) extends BasicHud(param_location, param_direction, param_bufferZone, param_basicColor) with PaintableInterface {

    private var primitiveLongUtil : PrimitiveLongUtil = null

    private var prependString : String = null

    //private final String PREPEND_STRING;
    private var PREPEND_STRING : Array[Char] = null

    private var value : Int = 0

    private var max : Int = 0

    private var offset : Int = 0

    //private String valueString;
    private var valueString : Array[Char] = null

    private var valueTotalDigits : Int = 0

    //Constructor
    {
        val prependString : String = param_prependString
        val max : Int = param_max
        val location : Int = param_location
        val direction : Int = param_direction
        val bufferZone : Int = param_bufferZone
        val basicColor : BasicColor = param_basicColor
        this.prependString = prependString
        this.PREPEND_STRING = prependString.toCharArray()
        //this.PREPEND_STRING = prependString;
        this.valueString = PrimitiveLongSingleton.getInstance().NUMBER_CHAR_ARRAYS(0)
        //Note score must be (10 X 10^n) - 1
        this.primitiveLongUtil = PrimitiveLongUtil.createPowerOfTen(max + 1)
        this.max = max
        this.value = 0
        if (direction == 0) {
            //            throw new Exception(BasicHudFactory.getInstance().DIRECTION_EXCEPTION);
            throw new RuntimeException(BasicHudFactory.getInstance().DIRECTION_EXCEPTION)
        }
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.offset = font.stringWidth(this.prependString) + MyFontProcessor.defaultCharWidth(font)
        super.updateMeasurement(graphics)
    }

    def get() : Int = {
        return this.value
    }

    def add(value : Int) : Unit = {
        this.set(this.value + value)
    }

    def set(value : Int) : Unit = {
        this.value = value
        if (this.value > this.max) {
            this.value = 0
        }
        this.valueString = this.primitiveLongUtil.getCharArray(this.value)
        //this.valueString = this.primitiveLongUtil.getString(this.value);
        this.valueTotalDigits = this.primitiveLongUtil.getCurrentTotalDigits()
    }

    def reduce(value : Int) : Unit = {
        this.set(this.value - value)
    }

    override def paint(graphics : Graphics) : Unit = {
        super.paintDX(graphics, this.PREPEND_STRING, 0, this.PREPEND_STRING.length, this.valueString, 0, this.valueTotalDigits, this.offset)
    }

    def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.myFontProcessor.process(graphics)
        var charArray : Array[Char] = this.PREPEND_STRING
        //int offset = 0;
        var len : Int = this.PREPEND_STRING.length
        var charArray2 : Array[Char] = this.valueString
        //int offset2 = 0;
        var len2 : Int = this.valueTotalDigits
        this.basicSetColorUtil.setBasicColorP(graphics, this.getBasicColorP())
        graphics.drawChars(charArray, 0, len, x, y, 0)
        graphics.drawChars(charArray2, 0, len2, x - this.offset, y, 0)
    }

    override def paintThreed(graphics : Graphics) : Unit = {
    }

}


