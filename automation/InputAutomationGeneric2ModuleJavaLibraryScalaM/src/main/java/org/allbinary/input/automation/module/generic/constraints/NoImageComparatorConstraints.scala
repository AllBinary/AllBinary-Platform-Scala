/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic.constraints

import _root_.java.awt.*
import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.input.automation.module.ImageComparatorConstraints

class NoImageComparatorConstraints() extends ImageComparatorConstraints(1) {

    //Constructor
    {
        this.setMaxNonMatchingPixelDeltas(Integer.MAX_VALUE)
    }

    override def isColorAllowed(frame : Int, point : GPoint, color : Color) : Boolean = {
        return true
    }

    override def isImageValid(bufferedImage : BufferedImage) : Boolean = {
        return true
    }

}


