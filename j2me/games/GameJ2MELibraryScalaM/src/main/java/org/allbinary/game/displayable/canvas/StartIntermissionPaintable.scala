/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.color.BasicColorSetUtil
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.font.FontDebugFactory
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.graphics.paint.InitUpdatePaintable
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

class StartIntermissionPaintable(param_gameCanvas : AllBinaryGameCanvas, param_stringArray : Array[String], param_basicColor : BasicColor, param_font : Font) extends InitUpdatePaintable with UpdateMyFontInterface {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    val fontDebugFactory : FontDebugFactory = FontDebugFactory.getInstance()

    val basicSetColorUtil : BasicColorSetUtil = BasicColorSetUtil.getInstance()

    var gameCanvas : AllBinaryGameCanvas = null

    var stringArray : Array[String] = null

    var fontSize : Int = 0

    var font : Font = null

    var lastWidth : Array[Int] = null

    private val updateMyFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    private var myFontProcessor : MyFontProcessor = this.updateMyFontProcessor

    private var basicColor : BasicColor = BasicColorFactory.getInstance().BLACK

    private var color : Int = 0

    var lineYOffsetArray : Array[Int] = NullUtil.getInstance().NULL_INT_ARRAY

    private var hasChanged : Boolean = true

    private var anchor : Int = Anchor.TOP_LEFT

    var fontHeightP : Int = 0

    private val BEGIN_LEVEL : String = "Begin Level "

    private val EMPTY_STRING : String = StringUtil.getInstance().EMPTY_STRING

    //Constructor
    {
        val gameCanvas : AllBinaryGameCanvas = param_gameCanvas
        val stringArray : Array[String] = param_stringArray
        val basicColor : BasicColor = param_basicColor
        val font : Font = param_font
        this.gameCanvas = gameCanvas
        this.stringArray = stringArray
        this.lastWidth = new Array[Int](this.stringArray.length)
        this.setBasicColorP(basicColor)
        this.color = basicColor.intValue()
        this.fontSize = font.getSize()
        this.font = font
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.fontHeightP = font.getHeight()
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    override def paint(graphics : Graphics) : Unit = {
        //this.logUtil.putF("Intermission Processing: ", this, "draw");
        this.myFontProcessor.process(graphics)
        val existingFont : Font = graphics.getFont()
        this.fontDebugFactory.setFont(this.font, graphics)
        val displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        this.basicSetColorUtil.setBasicColorP3(graphics, this.basicColor, this.color)
        var beginWidth : Int = 0

        {
            var index : Int = this.lineYOffsetArray.length - 1
            while (index >= 0) {
                if (this.hasChanged) {
                    this.lastWidth(index) = (graphics.getFont().stringWidth(this.stringArray(index)) >> 1)
                }
                beginWidth = this.lastWidth(index)
                graphics.drawString(this.stringArray(index), displayInfo.getLastHalfWidth() - beginWidth, displayInfo.getLastHalfHeight() - this.lineYOffsetArray(index), this.anchor)
                index -= 1
            }
        }
        this.hasChanged = false
        this.fontDebugFactory.setFont(existingFont, graphics)
    }

    override def update() : Unit = {
        var level : Int = this.gameCanvas.getLayerManager().getGameInfo().getCurrentLevel()
        this.stringArray(0) = new StringMaker().append(this.BEGIN_LEVEL).appendint(level).toString()

        {
            var index : Int = this.stringArray.length - 1
            while (index >= 1) {
                this.stringArray(index) = this.EMPTY_STRING
                index -= 1
            }
        }
    }

    override def setBasicColorP(basicColor : BasicColor) : Unit = {
        this.basicColor = basicColor
    }

    def getBasicColorP() : BasicColor = {
        return this.basicColor
    }

}


