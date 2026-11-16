/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison.color

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.util.cache.CacheableInterface
import _root_.org.allbinary.string.CommonSeps

class ColorDelta(param_rgb1 : Int, param_rgb2 : Int) extends CacheableInterface {
    import _root_.org.allbinary.media.image.comparison.color.ColorDelta.{*}

    private var rgb1 : Int = 0

    private var rgb2 : Int = 0

    private var key : Object = null

    //Constructor
    {
        val rgb1 : Int = param_rgb1
        val rgb2 : Int = param_rgb2
        this.setRgb1(rgb1)
        this.setRgb2(rgb2)
        this.key = ColorDelta.getKey(rgb1, rgb2)
    }

    def getKey() : Object = {
        return this.key
    }

    def getRgb1() : Int = {
        return this.rgb1
    }

    def setRgb1(rgb1 : Int) : Unit = {
        this.rgb1 = rgb1
    }

    def getRgb2() : Int = {
        return this.rgb2
    }

    def setRgb2(rgb2 : Int) : Unit = {
        this.rgb2 = rgb2
    }

    override def toString() : String = {
        return new StringMaker().append("ColorDelta: ").append(StringUtil.getInstance().toString(this.getKey())).append(" RGB1: ").appendint(this.getRgb1()).append(" RGB2: ").appendint(this.getRgb2()).toString()
    }

}

object ColorDelta {
    def getKey(rgb1 : Int, rgb2 : Int) : Object = {
        return new StringMaker().append(Integer.toString(rgb1)).append(CommonSeps.getInstance().UNDERSCORE).append(Integer.toString(rgb2)).toString()
    }

}


