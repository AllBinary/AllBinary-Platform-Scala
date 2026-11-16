/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic.constraints

import _root_.java.awt.*
import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.input.automation.module.MotionRectangleConstraints

class NoMotionRectangleConstraints() extends MotionRectangleConstraints {

    //Constructor
    {
        this.setMinDimension(new Dimension(0, 0))
        this.setMinArea(0)
        this.setMaxDimension(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE))
        this.setMaxMotionRectangles(Integer.MAX_VALUE)
    }

    override def isValid(frame : _root_.java.lang.Long, bufferedImage : BufferedImage, rectangle : Rectangle) : Boolean = {
        return true
    }

}


