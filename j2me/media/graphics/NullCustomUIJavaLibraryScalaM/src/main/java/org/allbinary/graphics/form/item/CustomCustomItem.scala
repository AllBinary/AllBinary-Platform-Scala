/* Generated Code Do Not Modify */
package org.allbinary.graphics.form.item

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor

class CustomCustomItem(param_label : String, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends ABCustomItem(param_label, param_backgroundBasicColor, param_foregroundBasicColor) with UpdateMyFontInterface {

    val updateMyFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    var myFontProcessor : MyFontProcessor = this.updateMyFontProcessor

    //Constructor
    {
        val label : String = param_label
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
    }

}


