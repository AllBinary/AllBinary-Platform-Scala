/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.paint.help

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.string.StringUtil

class HelpPaintable(param_title : String, param_backgroundBasicColor : BasicColor, param_basicColor : BasicColor) extends Paintable with UpdateMyFontInterface {

    val displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()

    val updateMyFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    var myFontProcessor : MyFontProcessor = this.updateMyFontProcessor

    var anchor : Int = Anchor.TOP_LEFT

    var title : String = null

    var inputInfo : Array[String] = StringUtil.getInstance().getArrayInstance()

    //protected ColorFillPaintable colorFillPaintable;
    var basicColor : BasicColor = null

    //private int color;
    var titleBeginWidth : Int = 0

    private var beginWidthArray : Array[Int] = NullUtil.getInstance().NULL_INT_ARRAY

    private var charHeight : Int = 0

    //Constructor
    {
        val title : String = param_title
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val basicColor : BasicColor = param_basicColor
        this.title = title
        //this.colorFillPaintable = new ColorFillPaintable(backgroundBasicColor);
        this.basicColor = basicColor
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.titleBeginWidth = (font.stringWidth(this.title) >> 1)
        this.charHeight = font.getHeight()
        val size : Int = this.inputInfo.length

        {
            var index : Int = 0
            while (index < size) {
                this.beginWidthArray(index) = (font.stringWidth(this.inputInfo(index)) >> 1)
                index += 1
            }
        }
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    def setInputInfoP(inputInfo : Array[String]) : Unit = {
        this.inputInfo = inputInfo
        this.beginWidthArray = new Array[Int](this.inputInfo.length)
        this.myFontProcessor = this.updateMyFontProcessor
    }

    //    }
    override def paint(graphics : Graphics) : Unit = {
        this.myFontProcessor.process(graphics)
        val halfWidth : Int = this.displayInfo.getLastHalfWidth()
        //this.colorFillPaintable.paint(graphics);
        graphics.setColor(this.basicColor.intValue())
        graphics.drawString(this.title, halfWidth - this.titleBeginWidth, this.charHeight, this.anchor)
        val size : Int = this.inputInfo.length

        {
            var index : Int = 0
            while (index < size) {
                graphics.drawString(this.inputInfo(index), halfWidth - this.beginWidthArray(index), (index + 3) * this.charHeight, this.anchor)
                index += 1
            }
        }
    }

}


