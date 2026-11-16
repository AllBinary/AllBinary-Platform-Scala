/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.paint

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.graphics.displayable.CanvasStrings
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.graphics.paint.Paintable

//J2MEForJ2ME
class AboutPaintable private(param_info : Array[String], param_developers : Array[String]) extends Paintable with UpdateMyFontInterface {
    import _root_.org.allbinary.game.paint.AboutPaintable.{*}

    private val displayInfoSingleton : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()

    private val ABOUT : String = CanvasStrings.getInstance().ABOUT

    private var info : Array[String] = null

    private var developers : Array[String] = null

    private val paintableArray : Array[Paintable] = Array[Paintable](this)

    private var myFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    private var charHeight : Int = 0

    private var aboutBeginWidth : Int = 0

    private var infoBeginWidth : Array[Int] = null

    private var developersBeginWidth : Array[Int] = null

    private var anchor : Int = Anchor.TOP_LEFT

    //Constructor
    {
        val info : Array[String] = param_info
        val developers : Array[String] = param_developers
        this.info = info
        this.infoBeginWidth = new Array[Int](this.info.length)
        this.developers = developers
        this.developersBeginWidth = new Array[Int](this.developers.length)
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.charHeight = font.getHeight()
        this.aboutBeginWidth = (font.stringWidth(this.ABOUT) >> 1)
        val infoSize : Int = this.info.length

        {
            var index : Int = 0
            while (index < infoSize) {
                this.infoBeginWidth(index) = (font.stringWidth(this.info(index)) >> 1)
                index += 1
            }
        }
        val size : Int = this.developers.length

        {
            var index : Int = 0
            while (index < size) {
                this.developersBeginWidth(index) = (font.stringWidth(this.developers(index)) >> 1)
                index += 1
            }
        }
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    def getPaintableArrayInstance() : Array[Paintable] = {
        return this.paintableArray
    }

    override def paint(graphics : Graphics) : Unit = {
        this.myFontProcessor.process(graphics)
        val halfWidth : Int = this.displayInfoSingleton.getLastHalfWidth()
        graphics.drawString(this.ABOUT, halfWidth - this.aboutBeginWidth, 2 * this.charHeight, this.anchor)
        val infoSize : Int = this.info.length

        {
            var index : Int = 0
            while (index < infoSize) {
                graphics.drawString(this.info(index), halfWidth - this.infoBeginWidth(index), (4 + index) * this.charHeight, this.anchor)
                index += 1
            }
        }
        val size : Int = this.developers.length

        {
            var index : Int = 0
            while (index < size) {
                graphics.drawString(this.developers(index), halfWidth - this.developersBeginWidth(index), ((5 + infoSize) + index) * this.charHeight, this.anchor)
                index += 1
            }
        }
    }

}

object AboutPaintable {
    def getInstance(info : Array[String], developers : Array[String]) : AboutPaintable = {
        return new AboutPaintable(info, developers)
    }

}


