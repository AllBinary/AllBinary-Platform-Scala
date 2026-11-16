/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.paint

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.graphics.paint.Paintable

//SwtToJ2ME
class FullScreenPaintable private() extends Paintable with UpdateMyFontInterface {
    import _root_.org.allbinary.game.paint.FullScreenPaintable.{*}

    private val displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()

    private var myFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    private val FULLSCREEN_TEXT : String = "F11 - Toggle Fullscreen"

    private var anchor : Int = Anchor.TOP_LEFT

    private var Y : Int = 0

    private var beginWidth : Int = 0

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.Y = 4 * font.getHeight()
        this.beginWidth = (font.stringWidth(this.FULLSCREEN_TEXT) >> 1)
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    override def paint(graphics : Graphics) : Unit = {
        this.myFontProcessor.process(graphics)
        val halfWidth : Int = this.displayInfo.getLastHalfWidth()
        //int height = graphics.getClipHeight();
        val height : Int = this.displayInfo.getLastHeight()
        graphics.drawString(this.FULLSCREEN_TEXT, halfWidth - this.beginWidth, height - this.Y, this.anchor)
    }

}

object FullScreenPaintable {
    def getInstance() : FullScreenPaintable = {
        return new FullScreenPaintable()
    }

}


