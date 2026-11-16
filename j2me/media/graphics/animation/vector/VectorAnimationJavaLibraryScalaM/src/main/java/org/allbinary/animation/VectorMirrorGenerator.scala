/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.pipeline.BasicGraphicsPipeline
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListS

class VectorMirrorGenerator private() {
    import _root_.org.allbinary.animation.VectorMirrorGenerator.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val vectorAnimationUtil : VectorAnimationUtil = VectorAnimationUtil.getInstance()

    def getInstance(points : Array[Array[Array[Int]]], width : Int) : Array[Array[Array[Int]]] = {
        try {
            val pointFactory : PointFactory = PointFactory.getInstance()
            var pointBasicArrayList : BasicArrayList = null
            var nextPoints : Array[Array[Int]] = null
            var size2 : Int = 0
            val size : Int = points.length
            val pointsBasicArrayList : BasicArrayList = new BasicArrayListS(size)

            {
                var frame : Int = 0
                while (frame < size) {
                    nextPoints = points(frame)
                    size2 = nextPoints.length
                    pointBasicArrayList = new BasicArrayListS(size2)

                    {
                        var index : Int = 0
                        while (index < size2) {
                            pointBasicArrayList.add(pointFactory.createXY(nextPoints(index)(0), nextPoints(index)(1)))
                            index += 1
                        }
                    }
                    pointsBasicArrayList.add(pointBasicArrayList)
                    frame += 1
                }
            }

            {
                var index : Int = 0
                while (index < points.length) {
                    pointsBasicArrayList.add(this.getInstance(pointsBasicArrayList.objectArray(index).asInstanceOf[BasicArrayList], width))
                    index += 1
                }
            }
            var newPoints : Array[Array[Array[Int]]] = this.vectorAnimationUtil.toAnimationArrayFromListOfPointList(pointsBasicArrayList)
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

    def getInstance(pointBasicArrayList : BasicArrayList, width : Int) : BasicArrayList = {
        var graphicsPipe : BasicGraphicsPipeline = new BasicGraphicsPipeline(pointBasicArrayList)
        graphicsPipe.createMatrix()
        graphicsPipe.mirror(width)
        return graphicsPipe.getMatrix()
    }

}

object VectorMirrorGenerator {
    private val instance : VectorMirrorGenerator = new VectorMirrorGenerator()

    def getInstance() : VectorMirrorGenerator = {
        return VectorMirrorGenerator.instance
    }

}


