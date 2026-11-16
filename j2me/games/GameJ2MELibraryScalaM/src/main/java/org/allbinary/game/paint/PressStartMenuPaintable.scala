/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.paint

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.AppletUtil
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.input.motion.button.TouchScreenFactory
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.time.TimeDelayHelper

/**  *   * @author Berthelot, Travis  * @version 1.0  */
class PressStartMenuPaintable() extends Paintable with UpdateMyFontInterface {

    private val displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()

    private val PRESS_START : String = "Press Screen To Start"

    private val KEY_START : String = "Press or Click F2 To Begin"

    private val MENU_START : String = "Press Start From The Menu To Begin"

    private var myFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    private var startString : String = StringUtil.getInstance().EMPTY_STRING

    private var timeDelayHelper : TimeDelayHelper = new TimeDelayHelper(1100)

    private var flash : Boolean = false

    private var anchor : Int = Anchor.TOP_LEFT

    private var beginWidth : Int = 0

    private var line : Int = 0

    //Constructor
    {
        if (TouchScreenFactory.getInstance().isTouch()) {
            this.startString = this.PRESS_START
        } else if (AppletUtil.isAppletLoader(this)) {
            this.startString = this.KEY_START
        } else {
            this.startString = this.MENU_START
        }
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.beginWidth = (graphics.getFont().stringWidth(this.startString) >> 1)
        this.line = (4 * MyFontProcessor.defaultCharWidth(font)) + (font.getHeight() >> 1)
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    override def paint(graphics : Graphics) : Unit = {
        if (this.timeDelayHelper.isTimeTNT()) {
            if (this.isFlash()) {
                this.setFlash(false)
            } else {
                this.setFlash(true)
            }
        }
        if (this.isFlash()) {
            this.myFontProcessor.process(graphics)
            graphics.drawString(this.startString, displayInfo.getLastHalfWidth() - beginWidth, displayInfo.getLastHeight() - line, this.anchor)
        }
    }

    private def setFlash(flash : Boolean) : Unit = {
        this.flash = flash
    }

    private def isFlash() : Boolean = {
        return this.flash
    }

}


