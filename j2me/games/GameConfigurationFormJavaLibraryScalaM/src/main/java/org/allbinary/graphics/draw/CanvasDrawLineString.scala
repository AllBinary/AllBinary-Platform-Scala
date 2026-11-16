/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.draw

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor

class CanvasDrawLineString(param_x : Int, param_y : Int) extends UpdateMyFontInterface {
    import _root_.org.allbinary.graphics.draw.CanvasDrawLineString.{NULL_CANVAS_DRAW_LINE_STRING as _, *}
    def NULL_CANVAS_DRAW_LINE_STRING : CanvasDrawLineString = _root_.org.allbinary.graphics.draw.CanvasDrawLineString.NULL_CANVAS_DRAW_LINE_STRING

    private val drawStringUtil : DrawStringUtil = DrawStringUtil.getInstance()

    private var myFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    private var x : Int = 0

    private var y : Int = 0

    private var fontHeight : Int = 0

    //Constructor
    {
        val x : Int = param_x
        val y : Int = param_y
        this.x = x
        this.y = y
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.fontHeight = font.getHeight()
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    def paint(graphics : Graphics, string : String, line : Int) : Unit = {
        this.myFontProcessor.process(graphics)
        //graphics.setFont(Font.getFont(font.getFace(), font.getStyle(), Font.SIZE_LARGE));
        this.drawStringUtil.drawCenterString(graphics, string, 0, string.length(), this.x, this.y + (line * this.fontHeight))
    }

}

object CanvasDrawLineString {
    val NULL_CANVAS_DRAW_LINE_STRING : CanvasDrawLineString = new CanvasDrawLineString(0, 0)

}


