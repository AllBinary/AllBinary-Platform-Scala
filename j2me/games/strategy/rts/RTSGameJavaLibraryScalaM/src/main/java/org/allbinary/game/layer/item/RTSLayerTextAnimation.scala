/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.item

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor

class RTSLayerTextAnimation(param_text : String, param_image : Image) extends Animation with UpdateMyFontInterface {

    private var image : Image = null

    private var text : String = null

    private var myFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    //private final int adjustedCostX;
    private var fontHeight : Int = 0

    //Constructor
    {
        val text : String = param_text
        val image : Image = param_image
        //this.adjustedCostX = 2 + (text.length() * (MyFont.MYFONT.DEFAULT_CHAR_WIDTH - 1));
        this.text = text
        this.image = image
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.fontHeight = font.getHeight()
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.myFontProcessor.process(graphics)
        super.paintXY(graphics, x, y)
        val adjustedCostY : Int = this.image.getHeight() - this.fontHeight
        graphics.drawString(this.text, x, y + adjustedCostY, 0)
    }

}


