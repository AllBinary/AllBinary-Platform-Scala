/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.canvas.GameStatisticsFactory
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.graphics.paint.InitUpdatePaintable

class GamePerformanceInitUpdatePaintable extends InitUpdatePaintable with UpdateMyFontInterface {

    //private String[] baseRefreshHelperStringArray = StringUtil.getArrayInstance();
    private val halfHeight : Int = DisplayInfoSingleton.getInstance().getLastHalfHeight()

    private val yArray : Array[Int] = Array[Int](this.halfHeight + 30, this.halfHeight + 30, (this.halfHeight + 30) + 15, (this.halfHeight + 30) + 15, (this.halfHeight + 30) + 30, (this.halfHeight + 30) + 30, (this.halfHeight + 30) + 45, (this.halfHeight + 30) + 45)

    private var myFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    //private String[] baseRefreshHelperStringArray = StringUtil.getArrayInstance();
    private var baseRefreshHelperCharArray : Array[Array[Char]] = Array.ofDim[Char](0, 0)

    private var defaultStringWidth : Int = 0

    private val RED : Int = BasicColorFactory.getInstance().RED.intValue()

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.defaultStringWidth = MyFontProcessor.defaultStringWidth(font, 2)
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    override def init() : Unit = {
    }

    override def update() : Unit = {
        //baseRefreshHelperStringArray = GameStatisticsFactory.getInstance().toStringArray();
        this.baseRefreshHelperCharArray = GameStatisticsFactory.getInstance().to2DCharArray()
    }

    override def paint(graphics : Graphics) : Unit = {
        this.myFontProcessor.process(graphics)
        graphics.setColor(this.RED)
        var charArray : Array[Char] = null
        var charArray2 : Array[Char] = null
        var size2 : Int = 0
        var size3 : Int = 0
        val size : Int = this.baseRefreshHelperCharArray.length - 2

        {
            var index : Int = size
            while (index >= 0) {
                charArray = this.baseRefreshHelperCharArray(index)
                charArray2 = this.baseRefreshHelperCharArray(index + 1)
                size2 = charArray.length
                size3 = charArray2.length
                graphics.drawChars(charArray, 0, size2, 0, this.yArray(index), 0)
                graphics.drawChars(charArray2, 0, size3, size2 * this.defaultStringWidth, this.yArray(index + 1), 0)
                index -= 2
            }
        }
    }

}


