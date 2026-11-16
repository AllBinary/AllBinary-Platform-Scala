/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module

import _root_.java.awt.*
import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.media.image.comparison.motion.MotionRectangleConstraintsInterface

class MotionRectangleConstraints() extends MotionRectangleConstraintsInterface {

    private var minDimension : Dimension = null

    private var maxDimension : Dimension = null

    private var maxMotionRectangles : Int = 0

    private var minArea : Int = 0

    def getMinDimension() : Dimension = {
        return this.minDimension
    }

    def getMaxDimension() : Dimension = {
        return this.maxDimension
    }

    def isTooSmall(rectangle : Rectangle) : Boolean = {
        /*         this.logUtil.putF(             rectangle.width + " < " + this.getMinDimension().width + " || " +              rectangle.height + " < " + this.getMinDimension().height, this, "isTooSmall");         */
        if ((rectangle.width < this.getMinDimension().width) || (rectangle.height < this.getMinDimension().height)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def isAreaTooSmall(rectangle : Rectangle) : Boolean = {
        if ((rectangle.width * rectangle.height) < this.getMinArea()) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def isTooBig(rectangle : Rectangle) : Boolean = {
        /*         this.logUtil.putF(             rectangle.width + " > " + this.getMaxDimension().width + " || " +              rectangle.height + " > " + this.getMaxDimension().height, this, "isTooBig");          */
        if ((rectangle.width > this.getMaxDimension().width) || (rectangle.height > this.getMaxDimension().height)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def isValid(frame : _root_.java.lang.Long, bufferedImage : BufferedImage, rectangle : Rectangle) : Boolean = {
        throw new RuntimeException()
    }

    def setMinDimension(minDimension : Dimension) : Unit = {
        this.minDimension = minDimension
    }

    def setMaxDimension(maxDimension : Dimension) : Unit = {
        this.maxDimension = maxDimension
    }

    def getMaxMotionRectangles() : Int = {
        return this.maxMotionRectangles
    }

    def setMaxMotionRectangles(maxMotionRectangles : Int) : Unit = {
        this.maxMotionRectangles = maxMotionRectangles
    }

    def getMinArea() : Int = {
        return this.minArea
    }

    def setMinArea(minArea : Int) : Unit = {
        this.minArea = minArea
    }

}


