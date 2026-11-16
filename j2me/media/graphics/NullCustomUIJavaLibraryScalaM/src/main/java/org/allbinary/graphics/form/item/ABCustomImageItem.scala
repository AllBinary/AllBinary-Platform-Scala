/* Generated Code Do Not Modify */
package org.allbinary.graphics.form.item

import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.graphics.color.BasicColor

class ABCustomImageItem(param_label : String, param_image : Image, param_layout : Int, param_altText : String, param_basicColor : BasicColor, param_yOffset : Int) extends ABCustomItem(param_label, param_basicColor, param_basicColor) {

    var yOffset : Int = 0

    //Constructor
    {
        val label : String = param_label
        val image : Image = param_image
        val layout : Int = param_layout
        val altText : String = param_altText
        val basicColor : BasicColor = param_basicColor
        val yOffset : Int = param_yOffset
    }

    def getImage() : Image = {
        return NullImage.NULL_IMAGE
    }

}


