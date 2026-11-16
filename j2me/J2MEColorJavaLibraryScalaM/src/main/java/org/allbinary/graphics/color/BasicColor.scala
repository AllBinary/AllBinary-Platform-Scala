/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.color

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.logic.string.StringMaker
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsConstructor
import _root_.jsinterop.annotations.JsProperty

@JsType
class BasicColor(param_alphaValue : Int, param_value : Int, param_name : String) {

    // this.id = index++;
    private var name : String = null

    private var value : Int = 0

    private var redComponent : Float = 0.0f

    private var greenComponent : Float = 0.0f

    private var blueComponent : Float = 0.0f

    private var alphaComponent : Float = 0.0f

    @JsProperty
    var red : Short = 0

    @JsProperty
    var green : Short = 0

    @JsProperty
    var blue : Short = 0

    @JsProperty
    var alpha : Short = 0

    /*      * BasicColor.init(true, true);      *       * public static void setAlpha(boolean alpha) { BasicColor.alpha = alpha; }      *       * public static void init(boolean alpha, boolean ffOpaque) {      * BasicColor.setAlpha(alpha); BasicColor.ffOpaque = ffOpaque; }      */
    //Constructor
    {
        val alphaValue : Int = param_alphaValue
        val value : Int = param_value
        val name : String = param_name
        this.name = name
        var tempValue : Int = 0
        val basicColorUtil : BasicColorUtil = BasicColorUtil.getInstance()
        if (basicColorUtil.isAlpha) {
            if (basicColorUtil.ffOpaque) {
                tempValue = alphaValue | value
            } else {
                tempValue = 0x00000000 | value
            }
        } else {
            tempValue = value
        }
        var alphaInt : Int = ((tempValue >> 24) & 255)
        this.alpha = alphaInt.toShort
        this.alphaComponent = (alphaInt.toFloat) / 255
        var redInt : Int = ((tempValue >> 16) & 255)
        this.red = redInt.toShort
        this.redComponent = (redInt.toFloat) / 255
        var greenInt : Int = ((tempValue >> 8) & 255)
        this.green = greenInt.toShort
        this.greenComponent = (greenInt.toFloat) / 255
        var blueInt : Int = ((tempValue) & 255)
        this.blue = blueInt.toShort
        this.blueComponent = (blueInt.toFloat) / 255
        this.value = tempValue
    }

    //    }
    @JsMethod
    def intValue() : Int = {
        return this.value
    }

    @JsMethod
    def toInt() : Int = {
        return this.value
    }

    @JsMethod
    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("BasicColor: ")
        stringBuffer.append("Alpha: ")
        stringBuffer.appendshort(this.alpha)
        stringBuffer.append(" Red: ")
        stringBuffer.appendshort(this.red)
        stringBuffer.append(" Green: ")
        stringBuffer.appendshort(this.green)
        stringBuffer.append(" Blue: ")
        stringBuffer.appendshort(this.blue)
        stringBuffer.append(" Value: ")
        stringBuffer.appendint(this.value)
        return stringBuffer.toString()
    }

    /**      * @return the name      */
    @JsMethod
    def getName() : String = {
        return this.name
    }

    @JsMethod
    def getRedComponent() : Float = {
        return this.redComponent
    }

    @JsMethod
    def getGreenComponent() : Float = {
        return this.greenComponent
    }

    @JsMethod
    def getBlueComponent() : Float = {
        return this.blueComponent
    }

    @JsMethod
    def getAlphaComponent() : Float = {
        return this.alphaComponent
    }

}


