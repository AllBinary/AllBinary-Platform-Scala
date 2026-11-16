/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.text

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.graphics.font.FontDebugFactory
import _root_.org.allbinary.logic.string.StringUtil

/**  *  * @author User  */
class CustomTextAnimation(param_text : String, param_fontSize : Int, param_animationBehavior : AnimationBehavior) extends TextAnimation(param_text, param_animationBehavior) with TextInterface {

    val fontDebugFactory : FontDebugFactory = FontDebugFactory.getInstance()

    var fontSize : Int = 0

    var font : Font = null

    private var lastText : String = StringUtil.getInstance().INIT_STRING

    var hasChanged : Boolean = true

    private var textWidth : Int = 0

    //Constructor
    {
        val text : String = param_text
        val fontSize : Int = param_fontSize
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.fontSize = fontSize
        this.font = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, fontSize)
    }

    //    }
    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.myFontProcessor.process(graphics)
        val existingFont : Font = graphics.getFont()
        this.fontDebugFactory.setFont(this.font, graphics)
        //super.paint(graphics, x + this.xtraWidth, y);
        super.paintXYNoUpdate(graphics, x, y)
        this.fontDebugFactory.setFont(existingFont, graphics)
    }

    override def setScale(scaleX : Float, scaleY : Float) : Unit = {
        if (scaleX != scaleY) {
            throw new RuntimeException()
        }
        //this.logUtil.putF(new StringMaker().append("setScale font: ").append((fontSize * scaleX)).append(" text: ").append(this.getText()).toString(), this, this.commonStrings.PROCESS);
        this.hasChanged = true
        this.font = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, (this.fontSize * scaleX).toInt)
    }

    //Needed for polyglot do not remove
    override def setTextWithOnMeasure(text : String, textChangeListener : TextChangeListener) : Unit = {
        super.setTextWithOnMeasure(text, textChangeListener)
    }

    override def setText(text : String) : Unit = {
        //this.logUtil.putF(new StringMaker().append(" text: ").append(text).toString(), this, this.commonStrings.PROCESS);        
        if (this.lastText ne text) {
            this.hasChanged = true
            this.lastText = text
            super.setText(text)
        }
    }

    override def getText() : String = {
        return this.lastText
    }

    override def getWidth() : Int = {
        if (this.hasChanged) {
            this.textWidth = this.font.stringWidth(this.textArrayP(0))
            this.hasChanged = false
        }
        return this.textWidth
    }

    override def getFontHeight() : Int = {
        return this.font.getHeight()
    }

}


