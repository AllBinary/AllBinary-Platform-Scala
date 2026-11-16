/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison.motion

import _root_.java.awt.*
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil

class ConsolidateMotionRectangles(param_motionRectangles : MotionRectangles) extends MotionRectangles(_root_.org.allbinary.media.image.comparison.motion.ConsolidateMotionRectangles.NAME, param_motionRectangles.getImageComparisonResult()) {
    import _root_.org.allbinary.media.image.comparison.motion.ConsolidateMotionRectangles.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val motionRectangles : MotionRectangles = param_motionRectangles
        val vector : BasicArrayList = motionRectangles.getVector()
        val size : Int = vector.size()

        {
            var index : Int = 0
            while (index < size) {
                var motionRectangle : MotionRectangle = vector.get(index).asInstanceOf[MotionRectangle]
                vector.add(motionRectangle.clone())
                index += 1
            }
        }
        this.consolidateMotionRectangles()
    }

    private def consolidateMotionRectangles() : Unit = {
        val vector : BasicArrayList = this.getVector()
        this.logUtil.putF("Start - Size Before: " + vector.size(), this, "consolidateMotionRectangleConstraints")
        val removeVector : BasicArrayList = new BasicArrayListD()
        val size : Int = vector.size()

        {
            var index : Int = 0
            while (index < size) {
                var motionRectangle : MotionRectangle = vector.get(index).asInstanceOf[MotionRectangle]

                {
                    var i : Int = index + 1
                    while (i < vector.size()) {
                        var motionRectangle2 : MotionRectangle = vector.get(i).asInstanceOf[MotionRectangle]
                        //Only remove encapsulated rectangles
                        var rectangle : Rectangle = motionRectangle.getRectangle()
                        var rectangle2 : Rectangle = motionRectangle2.getRectangle()
                        var x2 : Int = rectangle.x + rectangle.width
                        var y2 : Int = rectangle.y + rectangle.height
                        var rightX : Int = rectangle2.x + rectangle2.width
                        var bottomY : Int = rectangle2.y + rectangle2.height
                        if ((((rectangle.x <= rectangle2.x) && (rectangle.y <= rectangle2.y)) && (x2 >= rightX)) && (y2 >= bottomY)) {
                            /*         this.logUtil.putF(new StringMaker().append("Should Consolidating: " + rectangle.x + "<" + rectangle2.x + " " +              rectangle.y + "<" + rectangle2.y + " " + x2 + ">" + rightX + " " + y2 + ">" + bottomY, this, "consolidateMotionRectangleConstraints");                         */
                            removeVector.add(motionRectangle2)
                        }
                        i += 1
                    }
                }
                index += 1
            }
        }
        this.remove(removeVector)
    }

    private def remove(removeVector : BasicArrayList) : Unit = {
        val vector : BasicArrayList = this.getVector()
        //Remove the consolidated rectangles
        val size : Int = removeVector.size()

        {
            var index : Int = 0
            while (index < size) {
                vector.remove(removeVector.get(index))
                index += 1
            }
        }
    }

}

object ConsolidateMotionRectangles {
    private val NAME : String = "consolidatedMotionRectangles_"

}


