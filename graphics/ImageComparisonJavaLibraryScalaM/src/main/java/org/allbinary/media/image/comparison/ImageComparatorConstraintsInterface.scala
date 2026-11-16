/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison

import _root_.java.awt.*
import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.graphics.GPoint

trait ImageComparatorConstraintsInterface {

    def getMaxNonMatchingPixelDeltas() : Int

    //BasicArrayList getAvoidVector();
    def isCollisionWithAvoidRectangles(rectangle : Rectangle) : Boolean

    def isCollisionWithAvoidRectangles(point : GPoint) : Boolean

    def isColorAllowed(frame : Int, point : GPoint, color : Color) : Boolean

    def isImageValid(bufferedImage : BufferedImage) : Boolean

    def isFrameAllowed(frame : Int) : Boolean

}


