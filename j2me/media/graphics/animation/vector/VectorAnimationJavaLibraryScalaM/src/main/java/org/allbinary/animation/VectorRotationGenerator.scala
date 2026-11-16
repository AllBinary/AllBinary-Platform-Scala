/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.pipeline.BasicGraphicsPipeline
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.math.Angle
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListS
import _root_.org.allbinary.vector.VectorInfo

class VectorRotationGenerator private() {
    import _root_.org.allbinary.animation.VectorRotationGenerator.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val vectorAnimationUtil : VectorAnimationUtil = VectorAnimationUtil.getInstance()

    private val angleFactory : AngleFactory = AngleFactory.getInstance()

    def getInstance(vectorRotationInfo : VectorInfo) : Array[Array[Array[Int]]] = {
        return this.getInstanceFrames(vectorRotationInfo.getWidth(), vectorRotationInfo.getHeight(), vectorRotationInfo.getPoints(), vectorRotationInfo.getTotalFrames())
    }

    def getInstanceFrames(width : Int, height : Int, points : Array[Array[Int]], frames : Int) : Array[Array[Array[Int]]] = {
        try {
            var totalAngle : Short = this.angleFactory.TOTAL_ANGLE
            var angleIncrement : Int = totalAngle / frames
            var pointsBasicArrayList : BasicArrayList = new BasicArrayListS(totalAngle / angleIncrement)
            var pointBasicArrayList : BasicArrayList = new BasicArrayListS(points.length)
            var pointFactory : PointFactory = PointFactory.getInstance()
            var size : Int = points.length

            {
                var index : Int = 0
                while (index < size) {
                    pointBasicArrayList.add(pointFactory.createXY(points(index)(0), points(index)(1)))
                    index += 1
                }
            }
            var index : Int = 0

            {
                while (index < totalAngle) {
                    pointsBasicArrayList.add(this.getListAtAngle(width, height, pointBasicArrayList, this.angleFactory.getAt(index)))
                    index += angleIncrement
                }
            }
            var newPoints : Array[Array[Array[Int]]] = this.vectorAnimationUtil.toAnimationArrayFromListOfPointListWithPointsPerFrame(pointsBasicArrayList, pointBasicArrayList.size())
            // this.logUtil.putF(IntArrayUtil.toString(newPoints), this, this.commonStrings.GET_INSTANCE);
            return newPoints
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.GET_INSTANCE, e)
                // throw e;
                return NullUtil.getInstance().NULL_INT_ARRAY_ARRAY_ARRAY
            }
        }
        throw new IllegalStateException()
    }

    def getListAtAngle(width : Int, height : Int, pointBasicArrayList : BasicArrayList, angle : Angle) : BasicArrayList = {
        var graphicsPipe : BasicGraphicsPipeline = new BasicGraphicsPipeline(pointBasicArrayList)
        graphicsPipe.createMatrix()
        graphicsPipe.translate(-(width >> 1), -(height >> 1))
        //graphicsPipe.rotate(Angle.getInstance(angle.getValue()));
        graphicsPipe.rotateToAngle(angle)
        graphicsPipe.translate((width >> 1), (height >> 1))
        return graphicsPipe.getMatrix()
    }

}

object VectorRotationGenerator {
    private val instance : VectorRotationGenerator = new VectorRotationGenerator()

    def getInstance() : VectorRotationGenerator = {
        return VectorRotationGenerator.instance
    }

}


