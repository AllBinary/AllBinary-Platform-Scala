/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison.motion

import _root_.java.awt.Rectangle
import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil

class ConstrainedMotionRectangles(param_motionRectangleConstraintsInterface : MotionRectangleConstraintsInterface, param_motionRectangles : MotionRectangles) extends MotionRectangles(_root_.org.allbinary.media.image.comparison.motion.ConstrainedMotionRectangles.NAME, param_motionRectangles.getImageComparisonResult()) {
    import _root_.org.allbinary.media.image.comparison.motion.ConstrainedMotionRectangles.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var motionRectangleConstraintsInterface : MotionRectangleConstraintsInterface = null

    //GenerateImageWithBoundingBoxesAroundMovingArtifacts
    //Constructor
    {
        val motionRectangleConstraintsInterface : MotionRectangleConstraintsInterface = param_motionRectangleConstraintsInterface
        val motionRectangles : MotionRectangles = param_motionRectangles
        this.setMotionRectangleConstraintsInterface(motionRectangleConstraintsInterface)
    }

    def applyMotionRectangleConstraints(motionRectangles : MotionRectangles) : Unit = {
        this.logUtil.putF("Start - Size Before: " + motionRectangles.getVector().size(), this, "applyMotionRectangleConstraints")
        val bufferedImageArray : Array[BufferedImage] = motionRectangles.getImageComparisonResult().getBufferedImages()
        var bufferedImage : BufferedImage = bufferedImageArray(1)
        val vector : BasicArrayList = new BasicArrayListD()
        val vector2 : BasicArrayList = motionRectangles.getVector()
        val size : Int = vector2.size()

        {
            var index : Int = 0
            while (index < size) {
                scala.util.boundary { (continue_N72086 : scala.util.boundary.Label[Unit]) ?=>
                    val motionRectangle : MotionRectangle = vector2.get(index).asInstanceOf[MotionRectangle]
                    val rectangle : Rectangle = motionRectangle.getRectangle()
                    val isTooSmall : Boolean = this.getMotionRectangleConstraintsInterface().isTooSmall(rectangle)
                    if (isTooSmall) {
                        //  rectangle, this, "getTargetableRectangles");
                        scala.util.boundary.break()(using continue_N72086)
                    }
                    var isAreaTooSmall : Boolean = this.getMotionRectangleConstraintsInterface().isAreaTooSmall(rectangle)
                    if (isAreaTooSmall) {
                        //  rectangle, this, "getTargetableRectangles");
                        scala.util.boundary.break()(using continue_N72086)
                    }
                    var isTooBig : Boolean = this.getMotionRectangleConstraintsInterface().isTooBig(rectangle)
                    if (isTooBig) {
                        //  rectangle, this, "getTargetableRectangles");
                        scala.util.boundary.break()(using continue_N72086)
                    }
                    var isValid : Boolean = this.getMotionRectangleConstraintsInterface().isValid(this.getImageComparisonResult().getFrameTwo(), bufferedImage, motionRectangle.getRectangle())
                    if (!isValid) {
                        scala.util.boundary.break()(using continue_N72086)
                    }
                    if (((!isTooSmall && !isAreaTooSmall) && !isTooBig) && isValid) {
                        vector.add(motionRectangle)
                    }
                }
                index += 1
            }
        }
        this.setVector(vector)
    }

    def getMotionRectangleConstraintsInterface() : MotionRectangleConstraintsInterface = {
        return this.motionRectangleConstraintsInterface
    }

    def setMotionRectangleConstraintsInterface(motionRectangleConstraintsInterface : MotionRectangleConstraintsInterface) : Unit = {
        this.motionRectangleConstraintsInterface = motionRectangleConstraintsInterface
    }

}

object ConstrainedMotionRectangles {
    private val NAME : String = "constrainedMotionRectangles_"

}


