/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.paint

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.logic.communication.log.LogUtil

//SWTToJ2ME
class OwnershipPaintable private() extends Paintable with UpdateMyFontInterface {
    import _root_.org.allbinary.game.paint.OwnershipPaintable.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()

    private var myFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    //private final static OwnershipPaintable SINGLETON = new OwnershipPaintable();
    private val COPYRIGHT : String = "AllBinary Copyright (c) 2011"

    //private final String COMPANY = "AllBinary";
    private var basicColor : BasicColor = BasicColorFactory.getInstance().WHITE

    private var color : Int = this.basicColor.intValue()

    private var anchor : Int = Anchor.TOP_LEFT

    private var COPYRIGHT_Y : Int = 0

    private var beginWidth : Int = 0

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.COPYRIGHT_Y = 2 * font.getHeight()
        this.beginWidth = (font.stringWidth(this.COPYRIGHT) >> 1)
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    override def setBasicColorP(basicColor : BasicColor) : Unit = {
        this.basicColor = basicColor
        this.color = basicColor.intValue()
    }

    def getBasicColorP() : BasicColor = {
        return this.basicColor
    }

    override def paint(graphics : Graphics) : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, canvasStrings.PAINT);
        this.myFontProcessor.process(graphics)
        graphics.setColor(this.color)
        val halfWidth : Int = this.displayInfo.getLastHalfWidth()
        //int height = graphics.getClipHeight();
        val height : Int = this.displayInfo.getLastHeight()
        graphics.drawString(this.COPYRIGHT, halfWidth - this.beginWidth, height - this.COPYRIGHT_Y, this.anchor)
    }

}

object OwnershipPaintable {
    def getInstance() : OwnershipPaintable = {
        //return SINGLETON;
        return new OwnershipPaintable()
    }

}


