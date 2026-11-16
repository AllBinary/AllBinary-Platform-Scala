/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.paint

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor

class SimpleTextPaintable(param_text : String, param_basicColor : BasicColor) extends Paintable with UpdateMyFontInterface {

    private val displayInfoSingleton : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()

    private val updateMyFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    private var myFontProcessor : MyFontProcessor = this.updateMyFontProcessor

    private var text : String = null

    private var basicColor : BasicColor = null

    private var topScoresWidth : Int = 0

    private var fontHeight : Int = 0

    private var anchor : Int = Anchor.TOP_LEFT

    //Constructor
    {
        val text : String = param_text
        val basicColor : BasicColor = param_basicColor
        this.text = text
        this.basicColor = basicColor
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.topScoresWidth = (font.stringWidth(this.text) >> 1)
        this.fontHeight = font.getHeight()
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    override def paint(graphics : Graphics) : Unit = {
        this.myFontProcessor.process(graphics)
        //int width = graphics.getClipWidth();
        val width : Int = this.displayInfoSingleton.getLast()(this.displayInfoSingleton.WIDTH)
        graphics.setColor(this.getBasicColorP().intValue())
        graphics.drawString(this.text, (width >> 1) - this.topScoresWidth, this.fontHeight, this.anchor)
    }

    override def setBasicColorP(basicColor : BasicColor) : Unit = {
        this.basicColor = basicColor
    }

    private def getBasicColorP() : BasicColor = {
        return this.basicColor
    }

    def setText(text : String) : Unit = {
        this.text = text
        this.myFontProcessor = this.updateMyFontProcessor
    }

    def getText() : String = {
        return this.text
    }

}


