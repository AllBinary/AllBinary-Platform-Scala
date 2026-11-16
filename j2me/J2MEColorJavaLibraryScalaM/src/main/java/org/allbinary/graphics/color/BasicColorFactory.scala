/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.color

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.logic.string.StringUtil
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsProperty

@JsType
class BasicColorFactory {
    import _root_.org.allbinary.graphics.color.BasicColorFactory.{*}

    @JsProperty
    val NULL_COLOR : BasicColor = this.createInstanceARGB(255, 255, 255, 255, "null color")

    //C9B895
    @JsProperty
    val TAN : BasicColor = this.createInstance(0xE9D8B5)

    @JsProperty
    val SKIN_PINK : BasicColor = this.createInstance(0xFDCECE)

    // public final BasicColor LIGHT_BROWN = BasicColorFactory.getInstance().createInstance(0xFFFF00);
    @JsProperty
    val RED : BasicColor = this.createInstanceAN(BasicColorUtil.getInstance().ALPHA, 0xFF0000, "red")

    @JsProperty
    val LIGHT_RED : BasicColor = this.createInstanceAN(BasicColorUtil.getInstance().ALPHA, 0xFFA0A0, "light red")

    @JsProperty
    val DARK_GREEN : BasicColor = this.createInstance(0x00FF00)

    @JsProperty
    val GREEN : BasicColor = this.createInstanceAN(BasicColorUtil.getInstance().ALPHA, 0x00DD00, "green")

    @JsProperty
    val LIGHT_GREEN : BasicColor = this.createInstance(0x007700)

    @JsProperty
    val PURPLE : BasicColor = this.createInstanceAN(BasicColorUtil.getInstance().ALPHA, 0x400040, "purple")

    @JsProperty
    val BLUE : BasicColor = this.createInstanceAN(BasicColorUtil.getInstance().ALPHA, 0x0000FF, "blue")

    @JsProperty
    val LIGHT_BLUE : BasicColor = this.createInstance(0x00aaff)

    @JsProperty
    val VERY_LIGHT_BLUE : BasicColor = this.createInstance(0x000033)

    // public final BasicColor LIGHT_BLUE = BasicColorFactory.getInstance().createInstance(0x000077);
    @JsProperty
    val PUCE : BasicColor = this.createInstance(0xFF00AA)

    @JsProperty
    val AQUA : BasicColor = this.createInstance(0x00FFFF)

    @JsProperty
    val YELLOW : BasicColor = this.createInstanceAN(BasicColorUtil.getInstance().ALPHA, 0xFFFF00, "yellow")

    // MAGENTA
    @JsProperty
    val PINK : BasicColor = this.createInstance(0xFF00FF)

    @JsProperty
    val BLACK : BasicColor = this.createInstanceAN(BasicColorUtil.getInstance().ALPHA, 0x000000, "black")

    @JsProperty
    val GREY : BasicColor = this.createInstanceAN(BasicColorUtil.getInstance().ALPHA, 0xAAAAAA, "grey")

    @JsProperty
    val LIGHT_GREY : BasicColor = this.createInstance(0xC0C0C0)

    @JsProperty
    val DARK_GREY : BasicColor = this.createInstance(0x404040)

    // public final BasicColor ORANGE = BasicColorFactory.getInstance().createInstance(0xFFC800);
    @JsProperty
    val ORANGE : BasicColor = this.createInstance(0xe07718)

    @JsProperty
    val BROWN : BasicColor = this.createInstance(0x956B00)

    @JsProperty
    val WHITE : BasicColor = this.createInstance(0xFFFFFF)

    @JsProperty
    val TRANSPARENT_COLOR : BasicColor = this.createInstanceAN(0x00000000, 0x000000, StringUtil.getInstance().EMPTY_STRING)

    @JsProperty
    val TRANSPARENT_GREY : BasicColor = this.createInstanceAN(0x52000000, 0xECECEC, StringUtil.getInstance().EMPTY_STRING)

    @JsProperty
    val TRANSPARENT_BLACK : BasicColor = this.createInstanceAN(0x52000000, 0x000000, StringUtil.getInstance().EMPTY_STRING)

    @JsProperty
    val TRANSPARENT_RED : BasicColor = this.createInstanceAN(0x52000000, 0xFF0000, StringUtil.getInstance().EMPTY_STRING)

    @JsProperty
    val CLEAR_COLOR : BasicColor = this.BLACK

    @JsProperty
    val BORDER_COLOR : BasicColor = this.WHITE

    @JsMethod
    def createInstance(value : Int) : BasicColor = {
        return new BasicColor(BasicColorUtil.getInstance().ALPHA, value, StringUtil.getInstance().EMPTY_STRING)
    }

    @JsMethod
    def createInstanceA(alphaValue : Int, value : Int) : BasicColor = {
        return new BasicColor(alphaValue, value, StringUtil.getInstance().EMPTY_STRING)
    }

    @JsMethod
    def createInstanceAN(alphaValue : Int, value : Int, name : String) : BasicColor = {
        return new BasicColor(alphaValue, value, name)
    }

    @JsMethod
    def createInstanceARGB(alphaValue : Int, r : Int, g : Int, b : Int, name : String) : BasicColor = {
        val ALPHA_MASK : Int = (0xFF000000).toInt
        return new BasicColor(alphaValue, ((((alphaValue << 24) & ALPHA_MASK) + ((r << 16) & 0x00FF0000)) + ((g << 8) & 0x0000FF00)) + (b & 0x000000FF), StringUtil.getInstance().EMPTY_STRING)
    }

}

object BasicColorFactory {
    private val instance : BasicColorFactory = new BasicColorFactory()

    @JsMethod
    def getInstance() : BasicColorFactory = {
        return BasicColorFactory.instance
    }

}


