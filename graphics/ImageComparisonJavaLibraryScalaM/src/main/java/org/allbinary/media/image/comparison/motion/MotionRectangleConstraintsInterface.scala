/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison.motion

import _root_.java.awt.*
import _root_.java.awt.image.BufferedImage

trait MotionRectangleConstraintsInterface {

    def getMaxMotionRectangles() : Int

    def getMinDimension() : Dimension

    def getMinArea() : Int

    def getMaxDimension() : Dimension

    def isTooSmall(rectangle : Rectangle) : Boolean

    def isAreaTooSmall(rectangle : Rectangle) : Boolean

    def isTooBig(rectangle : Rectangle) : Boolean

    def isValid(frame : _root_.java.lang.Long, bufferedImage : BufferedImage, rectangle : Rectangle) : Boolean

}


