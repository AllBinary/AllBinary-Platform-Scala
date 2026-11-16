/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form.item

import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.J2MEUtil
import _root_.org.allbinary.game.displayable.canvas.GameCommandCanvas
import _root_.org.allbinary.game.input.Input
import _root_.org.allbinary.game.input.InputFactory
import _root_.org.allbinary.game.input.PlatformKeyFactory
import _root_.org.allbinary.game.input.event.RawKeyEventListener
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.form.item.validation.TextItemVisitor
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonSeps

class CustomTextBox(param_cmdListener : CommandListener, param_label : String, param_text : String, param_maxSize : Int, param_constraints : Int, param_font : Font, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends GameCommandCanvas(param_cmdListener, param_label, param_backgroundBasicColor, param_foregroundBasicColor) with RawKeyEventListener {

    private var textFieldItem : ABTextFieldItem = null

    private val inputFactory : InputFactory = InputFactory.getInstance()

    //Constructor
    {
        val cmdListener : CommandListener = param_cmdListener
        val label : String = param_label
        val text : String = param_text
        val maxSize : Int = param_maxSize
        val constraints : Int = param_constraints
        val font : Font = param_font
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        val stringUtil : StringUtil = StringUtil.getInstance()
        val textFieldItem : ABTextFieldItem = new ABTextFieldItem(this, new TextItemVisitor(), stringUtil.EMPTY_STRING, stringUtil.EMPTY_STRING, maxSize, 0, stringUtil.EMPTY_STRING, font, backgroundBasicColor, foregroundBasicColor)
        textFieldItem.setString(text)
        this.textFieldItem = textFieldItem
        //this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR);
        this.setTitle(label)
    }

    def submit() : Unit = {
    }

    override def onEventRaw(keyCode : Int, deviceId : Int, repeated : Boolean) : Unit = {
        this.logUtil.putF(new StringMaker().append(this.commonStrings.START).appendint(keyCode).toString(), this, "onEvent")
        this.keyPressedByDevice(keyCode, deviceId)
    }

    override def keyPressed(keyCode : Int) : Unit = {
        this.keyPressedByDevice(keyCode, 0)
    }

    override def keyReleased(keyCode : Int) : Unit = {
        this.keyReleasedByDevice(keyCode, 0)
    }

    override def keyRepeated(keyCode : Int) : Unit = {
        this.keyRepeatedByDevice(keyCode, 0)
    }

    override def keyPressedByDevice(keyCode : Int, deviceId : Int) : Unit = {
        try {
            this.logUtil.putF(new StringMaker().append(CommonSeps.getInstance().SPACE).appendint(keyCode).toString(), this, this.gameInputStrings.KEY_PRESSED)
            val platformKeyFactory : PlatformKeyFactory = PlatformKeyFactory.getInstance()
            val input : Input = this.inputFactory.getInstanceById(keyCode)
            if (platformKeyFactory.isSubmission(input)) {
                this.submit()
            } else {
                this.textFieldItem.keyPressed(keyCode)
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.gameInputStrings.KEY_PRESSED, e)
            }
        }
    }

    override def keyReleasedByDevice(keyCode : Int, deviceId : Int) : Unit = {
    }

    override def paint(graphics : Graphics) : Unit = {
        graphics.setColor(this.backgroundColor)
        //graphics.fillRect(0, 0, graphics.getClipWidth(), graphics.getClipHeight());
        graphics.fillRect(0, 0, this.displayInfo.getLastWidth(), this.displayInfo.getLastHeight())
        //g.translate(0, viewPortY);
        graphics.setColor(this.foregroundColor)
        if (!J2MEUtil.isJ2ME()) {
            graphics.drawString(this.getTitle(), 8, 1, 0)
        }
        //g.translate(0, -viewPortY);
        this.paintXY(graphics, 8, graphics.getFont().getHeight() + 2)
        super.paint(graphics)
    }

    def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.textFieldItem.paintXY(graphics, x, y)
    }

    def getTextFieldItem() : ABTextFieldItem = {
        return this.textFieldItem
    }

}


