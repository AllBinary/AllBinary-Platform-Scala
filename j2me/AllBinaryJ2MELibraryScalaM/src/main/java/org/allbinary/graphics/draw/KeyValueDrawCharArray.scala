/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.draw

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.logic.java.character.CharArrayFactory
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor

/**  *  * @author user  */
class KeyValueDrawCharArray(param_label : String, param_x : Int) extends UpdateMyFontInterface {

    private var myFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    private var LABEL : String = null

    private var labelX : Int = 0

    private var valueX : Int = 0

    private var value : Array[Char] = CharArrayFactory.getInstance().getZeroCharArray()

    private var len : Int = 0

    //private String value = StringUtil.getInstance();
    //Constructor
    {
        val label : String = param_label
        val x : Int = param_x
        this.LABEL = label
        this.labelX = x
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        var labelWidth : Int = graphics.getFont().stringWidth(this.LABEL) - this.LABEL.length()
        this.valueX = labelWidth + this.labelX
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    def paint(graphics : Graphics, y : Int) : Unit = {
        this.myFontProcessor.process(graphics)
        graphics.drawString(this.LABEL, this.labelX, y, 0)
        graphics.drawChars(this.value, 0, this.len, this.valueX, y, 0)
    }

    def update(value : Array[Char], len : Int) : Unit = {
        this.value = value
        this.len = len
    }

}


