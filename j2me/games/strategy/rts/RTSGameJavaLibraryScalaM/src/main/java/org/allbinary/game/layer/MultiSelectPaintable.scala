/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.logic.NullUtil

class MultiSelectPaintable() extends SelectionHudPaintable {

    private val rootNameList : BasicArrayList = new BasicArrayListD()

    private var totalCharArray : Array[Char] = NullUtil.getInstance().NULL_CHAR_ARRAY

    private var rootNamesString : String = StringUtil.getInstance().EMPTY_STRING

    //private final char[][] totalArray = char[10];
    private val TOTAL : String = "Total Selected: "

    private val backgroundColor : Int = BasicColorFactory.getInstance().GREY.intValue()

    //BasicColor.TRANSPARENT_GREY.intValue();
    private var totalWidth : Int = 0

    private var textLine2Y : Int = 0

    override def updateMeasurement(graphics : Graphics) : Unit = {
        super.updateMeasurement(graphics)
        val font : Font = graphics.getFont()
        this.totalWidth = font.stringWidth(this.TOTAL)
        this.textLine2Y = (this.y + font.getHeight())
    }

    def update(list : BasicArrayList) : Unit = {
        this.clear()
        var size : Int = list.size()
        this.totalCharArray = this.getPrimitiveLongUtil().getCharArray(size)

        {
            var index : Int = list.size() - 1
            while (index >= 0) {
                var rtsLayer : RTSLayer = list.get(index).asInstanceOf[RTSLayer]
                if (!this.rootNameList.contains(rtsLayer.getRootName())) {
                    this.rootNameList.add(rtsLayer.getRootName())
                }
                index -= 1
            }
        }
        val COMMA_SEP : String = CommonSeps.getInstance().COMMA_SEP
        val stringBuffer : StringMaker = new StringMaker()

        {
            var index : Int = this.rootNameList.size() - 1
            while (index >= 0) {
                var rootName : String = this.rootNameList.get(index).asInstanceOf[String]
                stringBuffer.append(rootName)
                if (index != 0) {
                    stringBuffer.append(COMMA_SEP)
                }
                index -= 1
            }
        }
        this.rootNamesString = stringBuffer.toString()
    }

    private def clear() : Unit = {
        this.rootNameList.clear()
    }

    override def paint(graphics : Graphics) : Unit = {
        graphics.setColor(this.backgroundColor)
        //graphics.fillRect(this.getX(), y, this.getWidth(), this.getHeight());
        graphics.drawRect(this.getX(), this.y, this.getWidth(), this.getHeight())
        graphics.setColor(this.getColor())
        graphics.drawString(this.TOTAL, this.textX, this.y, 0)
        graphics.drawChars(this.totalCharArray, 0, this.getPrimitiveLongUtil().getCurrentTotalDigits(), this.textX + this.totalWidth, this.y, 0)
        graphics.drawString(this.rootNamesString, this.textX, this.textLine2Y, 0)
    }

}


