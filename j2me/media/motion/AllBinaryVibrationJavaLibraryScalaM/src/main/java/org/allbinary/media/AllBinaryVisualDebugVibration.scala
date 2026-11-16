/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.time.TimeDelayHelper

class AllBinaryVisualDebugVibration extends AllBinaryVibrationME with UpdateMyFontInterface {

    private val displayInfoSingleton : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()

    private val timeDelayHelper : TimeDelayHelper = new TimeDelayHelper(Integer.MAX_VALUE)

    private val VIBRATING : String = "Vibrating"

    private var myFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    private var anchor : Int = Anchor.TOP_LEFT

    private var width : Int = 0

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.width = font.stringWidth(this.VIBRATING)
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    override def vibrate(duration : Int, `type` : Int, volume : Int) : Unit = {
        this.timeDelayHelper.delay = duration
    }

    def paint(graphics : Graphics) : Unit = {
        if (this.timeDelayHelper.isTimeTNT()) {
            this.timeDelayHelper.delay = Integer.MAX_VALUE
            this.myFontProcessor.process(graphics)
            graphics.drawString(this.VIBRATING, this.displayInfoSingleton.getLastHalfWidth() - (width >> 1), 0, this.anchor)
        }
    }

}


