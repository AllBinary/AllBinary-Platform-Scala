/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.hud.basic

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureUtil
import _root_.org.allbinary.game.graphics.hud.BasicHud
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.logic.math.MathUtil
import _root_.org.allbinary.logic.math.PrimitiveLongSingleton
import _root_.org.allbinary.logic.math.PrimitiveLongUtil

class VelocityWidget(param_powerOfTenVelocity : Int, param_location : Int, param_direction : Int, param_basicColor : BasicColor) extends BasicHud(param_location, param_direction, 2, param_basicColor) {

    //private final String KILOMETERS_PER_HOUR_STR = " km/h";
    private val KILOMETERS_PER_HOUR_STR : Array[Char] = Array[Char](' ', 'k', 'm', '/', 'h')

    private val totalChars : Int = this.KILOMETERS_PER_HOUR_STR.length

    private var velocity : Int = 0

    private var maxVelocity : Int = 0

    //private String string = StringUtil.getInstance();
    private var string : Array[Char] = PrimitiveLongSingleton.getInstance().ZERO

    private var totalDigits : Int = 1

    private var powerOfTenVelocity : Int = 0

    private var primitiveLongUtil : PrimitiveLongUtil = null

    private var offset : Int = 0

    private var offset2 : Int = 0

    //Constructor
    {
        val powerOfTenVelocity : Int = param_powerOfTenVelocity
        val location : Int = param_location
        val direction : Int = param_direction
        val basicColor : BasicColor = param_basicColor
        this.powerOfTenVelocity = powerOfTenVelocity
        this.maxVelocity = powerOfTenVelocity
        this.velocity = 0
        this.primitiveLongUtil = PrimitiveLongUtil.createPowerOfTen(powerOfTenVelocity)
        this.updateMaxHeight = 14
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.updateMaxWidth = font.getSize() * ((5 + MathUtil.getInstance().getTotalDigits(this.powerOfTenVelocity)) + 1)
        super.updateMeasurement(graphics)
        this.offset = MyFontProcessor.defaultStringWidth(font, this.primitiveLongUtil.getMaxDigits()) + MyFontProcessor.defaultStringWidth(font, 2)
        this.offset2 = (this.offset - MyFontProcessor.defaultStringWidth(font, this.totalDigits)) - MyFontProcessor.defaultStringWidth(font, 2)
    }

    def get() : Int = {
        return this.velocity
    }

    def add(value : Int) : Unit = {
        this.set(this.velocity + value)
    }

    def set(value : Int) : Unit = {
        var lastVelocity : Int = this.velocity
        this.velocity = value
        if (this.velocity > this.maxVelocity) {
            this.velocity = 0
        }
        if (lastVelocity != this.velocity) {
            //this.string = primitiveLongUtil.getString(this.velocity * 18);
            this.string = this.primitiveLongUtil.getCharArray(this.velocity * 18)
            //I add one extra for open gl font issue
            if (OpenGLFeatureUtil.getInstance().isAnyThreed()) {
                this.totalDigits = this.primitiveLongUtil.getCurrentTotalDigits() + 1
            } else {
                this.totalDigits = this.primitiveLongUtil.getCurrentTotalDigits()
            }
            this.myFontProcessor = this.updateMyFontProcessor
        }
    }

    def reduce(value : Int) : Unit = {
        this.set(this.velocity - value)
    }

    def paint(graphics : Graphics) : Unit = {
        //super.paint(graphics, string, KILOMETERS_PER_HOUR_STR, offset2, offset);
        super.paintDXY(graphics, this.string, 0, this.totalDigits, this.KILOMETERS_PER_HOUR_STR, 0, this.totalChars, this.offset2, this.offset)
    }

}


