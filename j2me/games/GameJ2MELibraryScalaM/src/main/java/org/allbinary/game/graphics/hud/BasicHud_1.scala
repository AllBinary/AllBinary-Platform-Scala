/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.graphics.hud

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.color.BasicColorSetUtil
import _root_.org.allbinary.graphics.displayable.CanvasStrings
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEvent
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.string.CommonStrings

class BasicHud_1(param_location : Int, param_direction : Int, param_bufferZone : Int, param_basicColor : BasicColor) extends UpdateMyFontInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val canvasStrings : CanvasStrings = CanvasStrings.getInstance()

    val basicSetColorUtil : BasicColorSetUtil = BasicColorSetUtil.getInstance()

    private val displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()

    private val updateMyFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    private var myFontProcessor : MyFontProcessor = this.updateMyFontProcessor

    private var location : Int = 0

    private var direction : Int = 0

    private var bufferZone : Int = 0

    private var hudGraphicsPosition : HudGraphicsPosition = HudGraphicsPosition.NULL_HUD_GRAPHICS_POSITION

    private var x : Int = 0

    private var y : Int = 0

    private var basicColor : BasicColor = BasicColorFactory.getInstance().BLACK

    private var color : Int = 0

    var updateMaxWidth : Int = 0

    var updateMaxHeight : Int = 0

    var offsetY : Int = 0

    //Constructor
    {
        val location : Int = param_location
        val direction : Int = param_direction
        val bufferZone : Int = param_bufferZone
        val basicColor : BasicColor = param_basicColor
        this.setLocation(location)
        this.setDirection(direction)
        this.setBufferZone(bufferZone)
        this.onDisplayChangeEvent(DisplayInfoSingleton.getInstance().displayChangeEvent)
        this.setBasicColorP(basicColor)
        this.color = basicColor.intValue()
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        try {
            //            this.logUtil.putF(new StringMaker().append(this.commonStrings.START).append(this.canvasStrings.FD_WIDTH).appendint(this.updateMaxWidth).append(this.canvasStrings.FD_HEIGHT).appendint(this.updateMaxHeight).toString(), this, this.canvasStrings.UPDATE_MEASUREMENT);
            this.hudGraphicsPosition = this.getHudGraphicsPositionWH(this.displayInfo.getLastWidth(), this.displayInfo.getLastHeight(), this.updateMaxWidth, this.updateMaxHeight)
            this.x = this.hudGraphicsPosition.getPoint().getX()
            this.setY(this.hudGraphicsPosition.getPoint().getY())
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, this.canvasStrings.ON_DISPLAY_CHANGE_EVENT, e)
            }
        }
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    def getLocation() : Int = {
        return this.location
    }

    def getDirection() : Int = {
        return this.direction
    }

    /*    public HudGraphicsPosition getHudGraphicsPosition(Graphics graphics)            throws Exception    {       return this.getHudGraphicsPosition(this.displayInfoSingleton.getLastWidth(), graphics.getClipHeight());       return this.getHudGraphicsPosition(this.displayInfoSingleton.getLastWidth(), this.displayInfoSingleton.getLastHeight());    }      */
    def getHudGraphicsPositionWH(width : Int, height : Int, maxWidth : Int, maxHeight : Int) : HudGraphicsPosition = {
        var x : Int = 0
        var y : Int = 0
        var anchor : Int = 0
        val basicHudFactory : BasicHudFactory = BasicHudFactory.getInstance()
        if (basicHudFactory.BOTTOMLEFT == this.getLocation()) {
            x = this.bufferZone + 2
            y = (height - maxHeight) - this.bufferZone
            anchor = Graphics.BOTTOM & Graphics.LEFT
        } else if (basicHudFactory.BOTTOMRIGHT == this.getLocation()) {
            x = width - maxWidth
            y = (height - maxHeight) - this.bufferZone
            anchor = Graphics.BOTTOM & Graphics.RIGHT
        } else if (basicHudFactory.TOPLEFT == this.getLocation()) {
            x = this.bufferZone + 2
            y = this.bufferZone + 5
            anchor = Anchor.TOP_LEFT
        } else if (basicHudFactory.TOPRIGHT == this.getLocation()) {
            x = width - maxWidth
            y = this.bufferZone + 5
            anchor = Graphics.TOP & Graphics.RIGHT
        } else if (basicHudFactory.TOPCENTER == this.getLocation()) {
            x = ((width - maxWidth) / 2)
            y = this.bufferZone + 5
            anchor = Graphics.TOP & Graphics.HCENTER
        } else if (basicHudFactory.BOTTOMCENTER == this.getLocation()) {
            x = ((width - maxWidth) / 2)
            y = (height - maxHeight) - this.bufferZone
            anchor = Graphics.BOTTOM & Graphics.HCENTER
        } else if (basicHudFactory.ABSOLUTE == this.getLocation()) {
            x = maxHeight
            y = maxWidth
            anchor = 0
        }
        return new HudGraphicsPosition(this.getPoint(x, y), anchor)
    }

    def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    def onDisplayChangeEvent(displayChangeEvent : DisplayChangeEvent) : Unit = {
        //        this.logUtil.putF(new StringMaker().append(this.commonStrings.START).append(DisplayInfoSingleton.getInstance().toString()).toString(), this, this.canvasStrings.ON_DISPLAY_CHANGE_EVENT);
        this.myFontProcessor = this.updateMyFontProcessor
    }

    def getPoint(x : Int, y : Int) : GPoint = {
        return PointFactory.getInstance().createXY(x, y)
    }

    def getBufferZone() : Int = {
        return this.bufferZone
    }

    def setBufferZone(bufferZone : Int) : Unit = {
        this.bufferZone = bufferZone
    }

    def setLocation(location : Int) : Unit = {
        this.location = location
    }

    def setDirection(direction : Int) : Unit = {
        this.direction = direction
    }

    def getHudGraphicsPosition() : HudGraphicsPosition = {
        return this.hudGraphicsPosition
    }

    /**      * @return the color      */
    def getColor() : Int = {
        return this.color
    }

    /**      * @return the x      */
    def getX() : Int = {
        return this.x
    }

    /**      * @param x the x to set      */
    def setX(x : Int) : Unit = {
        this.x = x
    }

    def setBasicColorP(basicColor : BasicColor) : Unit = {
        this.basicColor = basicColor
    }

    def getBasicColorP() : BasicColor = {
        return this.basicColor
    }

    def setY(y : Int) : Unit = {
        this.y = y
    }

    def getY() : Int = {
        return this.y
    }

    def paintSSO(graphics : Graphics, string : String, string2 : String, offset : Int) : Unit = {
        this.myFontProcessor.process(graphics)
        this.basicSetColorUtil.setBasicColorP(graphics, this.getBasicColorP())
        graphics.drawString(string, this.x, this.getY(), this.hudGraphicsPosition.getAnchor())
        graphics.drawString(string2, this.x + offset, this.getY(), this.hudGraphicsPosition.getAnchor())
    }

    def paintSSOO(graphics : Graphics, string : String, string2 : String, offset : Int, offset2 : Int) : Unit = {
        this.myFontProcessor.process(graphics)
        graphics.setColor(this.getColor())
        graphics.drawString(string, this.x + offset, this.getY(), this.hudGraphicsPosition.getAnchor())
        graphics.drawString(string2, this.x + offset2, this.getY(), this.hudGraphicsPosition.getAnchor())
    }

    def paintDXY(graphics : Graphics, charArray : Array[Char], offset : Int, len : Int, charArray2 : Array[Char], offset2 : Int, len2 : Int, xOffset : Int, xOffset2 : Int) : Unit = {
        this.myFontProcessor.process(graphics)
        this.basicSetColorUtil.setBasicColorP(graphics, this.getBasicColorP())
        val y : Int = this.getY()
        graphics.drawChars(charArray, offset, len, this.x + xOffset, y, this.hudGraphicsPosition.getAnchor())
        graphics.drawChars(charArray2, offset2, len2, this.x + xOffset2, y, this.hudGraphicsPosition.getAnchor())
    }

    def paintDX(graphics : Graphics, charArray : Array[Char], offset : Int, len : Int, charArray2 : Array[Char], offset2 : Int, len2 : Int, xOffset : Int) : Unit = {
        this.myFontProcessor.process(graphics)
        this.basicSetColorUtil.setBasicColorP(graphics, this.getBasicColorP())
        val y : Int = this.getY()
        graphics.drawChars(charArray, offset, len, this.x, y, this.hudGraphicsPosition.getAnchor())
        graphics.drawChars(charArray2, offset2, len2, this.x + xOffset, y, this.hudGraphicsPosition.getAnchor())
    }

    def paintOffsetAndLength(graphics : Graphics, charArray : Array[Char], offset : Int, len : Int) : Unit = {
        this.myFontProcessor.process(graphics)
        this.basicSetColorUtil.setBasicColorP(graphics, this.getBasicColorP())
        val y : Int = this.getY()
        graphics.drawChars(charArray, offset, len, this.x, y, this.hudGraphicsPosition.getAnchor())
    }

    def paintString(graphics : Graphics, string : String) : Unit = {
        this.myFontProcessor.process(graphics)
        this.basicSetColorUtil.setBasicColorP(graphics, this.getBasicColorP())
        val y : Int = this.getY() + this.offsetY
        graphics.drawString(string, this.x, y, this.hudGraphicsPosition.getAnchor())
    }

}


