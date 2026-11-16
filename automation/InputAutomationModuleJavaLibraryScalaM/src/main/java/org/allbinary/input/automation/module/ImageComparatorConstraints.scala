/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module

import _root_.java.awt.Color
import _root_.java.awt.Rectangle
import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.collision.RectangleCollisionUtil
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.media.image.comparison.ImageComparatorConstraintsInterface

class ImageComparatorConstraints(param_doImageComparisonEveryNthFrame : Int) extends ImageComparatorConstraintsInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var avoidVector : BasicArrayList = null

    private var maxNonMatchingPixelDeltas : Int = 0

    private var doImageComparisonEveryNthFrame : Int = 0

    //Constructor
    {
        val doImageComparisonEveryNthFrame : Int = param_doImageComparisonEveryNthFrame
        this.doImageComparisonEveryNthFrame = doImageComparisonEveryNthFrame
        this.setAvoidVector(new BasicArrayListD())
    }

    def getAvoidVector() : BasicArrayList = {
        return this.avoidVector
    }

    def isColorAllowed(frame : Int, point : GPoint, color : Color) : Boolean = {
        throw new RuntimeException()
    }

    def isCollisionWithAvoidRectangles(rectangle : Rectangle) : Boolean = {
        var isCollsionWithAvoidRectangles : Boolean = false
        val avoidVector : BasicArrayList = this.getAvoidVector()
        val size : Int = avoidVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var avoidRectangle : Rectangle = avoidVector.get(index).asInstanceOf[Rectangle]
                if (RectangleCollisionUtil.isCollision(avoidRectangle, rectangle)) {
                    // rectangle + " collided with " + avoidRectangle, this, "isCollisionWithAvoidRectangles");
                    isCollsionWithAvoidRectangles = true
                }
                index += 1
            }
        }
        return isCollsionWithAvoidRectangles
    }

    def isCollisionWithAvoidRectangles(point : GPoint) : Boolean = {
        var isCollsionWithAvoidRectangles : Boolean = false
        val avoidVector : BasicArrayList = this.getAvoidVector()
        val size : Int = avoidVector.size()

        {
            var index : Int = 0
            scala.util.boundary { (break_N69273 : scala.util.boundary.Label[Unit]) ?=>
                while (index < size) {
                    var avoidRectangle : Rectangle = avoidVector.get(index).asInstanceOf[Rectangle]
                    if (RectangleCollisionUtil.isCollision(avoidRectangle, point)) {
                        // rectangle + " collided with " + avoidRectangle, this, "isCollisionWithAvoidRectangles");
                        isCollsionWithAvoidRectangles = true
                        scala.util.boundary.break()(using break_N69273)
                    }
                    index += 1
                }
            }
        }
        return isCollsionWithAvoidRectangles
    }

    def setAvoidVector(avoidVector : BasicArrayList) : Unit = {
        this.avoidVector = avoidVector
    }

    def getMaxNonMatchingPixelDeltas() : Int = {
        return this.maxNonMatchingPixelDeltas
    }

    def setMaxNonMatchingPixelDeltas(maxNonMatchingPixelDeltas : Int) : Unit = {
        this.maxNonMatchingPixelDeltas = maxNonMatchingPixelDeltas
    }

    def isFrameAllowed(frame : Int) : Boolean = {
        var remainder : Int = ((frame + 1) % this.doImageComparisonEveryNthFrame)
        this.logUtil.putF(((((" Frame: " + frame) + " remainder: ") + remainder) + " this.doImageComparisonEveryNthFrame: ") + this.doImageComparisonEveryNthFrame, this, "isCollisionWithAvoidRectangles")
        if (remainder == 0) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def isImageValid(bufferedImage : BufferedImage) : Boolean = {
        throw new RuntimeException()
    }

    def log() : Unit = {
        val avoidVector : BasicArrayList = this.getAvoidVector()
        val size : Int = avoidVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var avoidRectangle : Rectangle = avoidVector.get(index).asInstanceOf[Rectangle]
                this.logUtil.putF("Avoid Rectangle: " + avoidRectangle, this, "log")
                index += 1
            }
        }
    }

}


