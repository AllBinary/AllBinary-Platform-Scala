/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.color


class BasicColorUtil {
    import _root_.org.allbinary.graphics.color.BasicColorUtil.{*}

    val ZERO_ARRAY : Array[BasicColor] = new Array[BasicColor](0)

    val ALPHA : Int = (0xFF000000).toInt

    val isAlpha : Boolean = true

    val ffOpaque : Boolean = true

    def getRGB(red : Int, green : Int, blue : Int) : Int = {
        var value : Int = 0
        if (this.isAlpha) {
            if (this.ffOpaque) {
                value = this.ALPHA
            }
        }
        value = (red << 16) | value
        value = (green << 8) | value
        value = blue | value
        return value
    }

    def getARGB(alphaValue : Int, r : Int, g : Int, b : Int) : Int = {
        return ((((alphaValue << 24) & this.ALPHA) + ((r << 16) & 0x00FF0000)) + ((g << 8) & 0x0000FF00)) + (b & 0x000000FF)
    }

    def get(alphaValue : Int, color : Int) : Int = {
        return ((alphaValue << 24) & this.ALPHA) + color
    }

    def invert(color : Int) : Int = {
        return (0xFFFFFF - color) | this.ALPHA
    }

}

object BasicColorUtil {
    private val instance : BasicColorUtil = new BasicColorUtil()

    def getInstance() : BasicColorUtil = {
        return BasicColorUtil.instance
    }

}


