/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.text

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.game.input.event.RawKeyEventListener
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.form.item.CustomTextBox
import _root_.org.allbinary.logic.string.StringUtil

/**  *  * @author User  */
class CustomTextBoxIndexedAnimation(param_customTextBox : CustomTextBox) extends IndexedAnimation(AnimationBehavior.getInstance()) with RawKeyEventListener with UpdateMyFontInterface with TextInterface {

    //GameKeyEventListenerInterface 
    private var customTextBox : CustomTextBox = null

    //private final int HEIGHT = 8;
    private var lastText : String = StringUtil.getInstance().INIT_STRING

    var hasChanged : Boolean = true

    private var textChangeListener : TextChangeListener = TextChangeListener.getInstance()

    //Constructor
    {
        val customTextBox : CustomTextBox = param_customTextBox
        this.customTextBox = customTextBox
    }

    override def setBasicColorP(basicColor : BasicColor) : Unit = {
        this.customTextBox.getTextFieldItem().setForegroundBasicColorP(basicColor)
    }

    override def setBackgroundBasicColorP(basicColor : BasicColor) : Unit = {
        this.customTextBox.getTextFieldItem().setBackgroundBasicColorP(basicColor)
    }

    override def setTextWithOnMeasure(text : String, textChangeListener : TextChangeListener) : Unit = {
        this.setText(text)
        this.textChangeListener = textChangeListener
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        //this.offsetY = SWTJOGLProcessor.getInstance().isJOGL() ? (int) -(this.fontHeight * 1.33) : 0;
        this.textChangeListener.onMeasure()
        this.textChangeListener = TextChangeListener.getInstance()
    }

    override def setText(text : String) : Unit = {
        //this.logUtil.putF(new StringMaker().append(" text: ").append(text).toString(), this, this.commonStrings.PROCESS);        
        if (this.lastText ne text) {
            this.hasChanged = true
            this.lastText = text
            this.customTextBox.getTextFieldItem().setString(text)
        }
    }

    override def getText() : String = {
        return this.customTextBox.getTextFieldItem().getString()
    }

    override def onEventRaw(keyCode : Int, deviceId : Int, repeated : Boolean) : Unit = {
        this.customTextBox.onEventRaw(keyCode, deviceId, repeated)
    }

    override def getFontHeight() : Int = {
        return this.customTextBox.getTextFieldItem().getFontHeight()
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.customTextBox.paintXY(graphics, x, y)
    }

    override def paintThreedXYZ(graphics : Graphics, x : Int, y : Int, z : Int) : Unit = {
    }

    //Needed for polyglot do not remove
    override def getWidth() : Int = {
        return super.getWidth()
    }

}


