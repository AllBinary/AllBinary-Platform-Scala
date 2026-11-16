/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.color

import _root_.org.allbinary.logic.string.StringUtil

class SmallBasicColorCacheFactory private() {
    import _root_.org.allbinary.graphics.color.SmallBasicColorCacheFactory.{*}

    private val SIZE : Int = 255

    private val INDEX_TO_COLOR : Array[Int] = new Array[Int](this.SIZE)

    private val BASIC_COLOR_ARRAY : Array[BasicColor] = new Array[BasicColor](this.SIZE)

    private var colorIndex : Int = 0

    def add(basicDefaultColor : BasicColor) : Unit = {
        this.BASIC_COLOR_ARRAY(this.colorIndex) = basicDefaultColor
        this.INDEX_TO_COLOR(this.colorIndex) = basicDefaultColor.intValue()
        this.colorIndex += 1
    }

    def getAndOrCreate(colorAsInt : Int) : BasicColor = {
        var basicColor : BasicColor = null

        {
            var index : Int = 0
            while (index < this.SIZE) {
                if (this.INDEX_TO_COLOR(index) == colorAsInt) {
                    return this.BASIC_COLOR_ARRAY(index)
                }
                index += 1
            }
        }
        val ALPHA_MASK : Int = (0xFF000000).toInt
        basicColor = BasicColorFactory.getInstance().createInstanceAN(colorAsInt & ALPHA_MASK, colorAsInt & 0x00FFFFFF, StringUtil.getInstance().EMPTY_STRING)
        this.add(basicColor)
        return basicColor
    }

}

object SmallBasicColorCacheFactory {
    private val instance : SmallBasicColorCacheFactory = new SmallBasicColorCacheFactory()

    def getInstance() : SmallBasicColorCacheFactory = {
        return SmallBasicColorCacheFactory.instance
    }

}


