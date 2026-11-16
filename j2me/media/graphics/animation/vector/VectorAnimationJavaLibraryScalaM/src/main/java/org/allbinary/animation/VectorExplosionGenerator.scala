/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.pipeline.RandomRotationFactory
import _root_.org.allbinary.graphics.pipeline.RandomTranslation
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.util.BasicArrayListS

class VectorExplosionGenerator private() {
    import _root_.org.allbinary.animation.VectorExplosionGenerator.{*}

    val RANDOM : VectorExplosionType = new VectorExplosionType()

    val ROTATION : VectorExplosionType = new VectorExplosionType()

    private val vectorAnimationUtil : VectorAnimationUtil = VectorAnimationUtil.getInstance()

    private val randomRotationFactory : RandomRotationFactory = RandomRotationFactory.getInstance()

    def createList(list : BasicArrayList, howMuch : Int, `type` : VectorExplosionType) : BasicArrayList = {
        var point : GPoint = null
        val size : Int = list.size()
        val points : Array[Array[Int]] = Array.ofDim[Int](size, 2)

        {
            var index : Int = 0
            while (index < size) {
                point = list.objectArray(index).asInstanceOf[GPoint]
                points(index)(0) = point.getX()
                points(index)(1) = point.getY()
                index += 1
            }
        }
        return this.createListFromPoints(list, points, howMuch, `type`)
    }

    def getInstance(points : Array[Array[Int]], howMuch : Int, `type` : VectorExplosionType) : Array[Array[Array[Int]]] = {
        val pointsBasicArrayList : BasicArrayList = this.getInstanceStartFrame(points, howMuch, `type`, true)
        val tempBasicArrayList : BasicArrayList = pointsBasicArrayList.objectArray(0).asInstanceOf[BasicArrayList]
        val newPoints : Array[Array[Array[Int]]] = this.vectorAnimationUtil.toAnimationArrayFromListOfPointListWithPointsPerFrame(pointsBasicArrayList, tempBasicArrayList.size())
        return newPoints
    }

    def getInstanceStartFrame(points : Array[Array[Int]], howMuch : Int, `type` : VectorExplosionType, startFrame : Boolean) : BasicArrayList = {
        try {
            val pointsBasicArrayList : BasicArrayList = new BasicArrayListS(howMuch)
            pointsBasicArrayList.add(this.createPointsBasicArrayList(points))
            var frameIndex : Int = 0
            var tempBasicArrayList : BasicArrayList = null
            var pointBasicArrayList : BasicArrayList = null

            {
                while (frameIndex < howMuch) {
                    tempBasicArrayList = pointsBasicArrayList.objectArray(frameIndex).asInstanceOf[BasicArrayList]
                    pointBasicArrayList = this.createListFromPoints(tempBasicArrayList, points, howMuch, `type`)
                    // this.logUtil.putF("Point BasicArrayList: " + pointBasicArrayList.toString(), this, this.commonStrings.GET_INSTANCE);
                    pointsBasicArrayList.add(pointBasicArrayList)
                    frameIndex += 1
                }
            }
            if (!startFrame) {
                pointsBasicArrayList.removeAt(0)
            }
            // this.logUtil.putF(IntArrayUtil.toString(newPoints), this, this.commonStrings.GET_INSTANCE);
            return pointsBasicArrayList
        } catch {
            case e : Exception => {
                //this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.GET_INSTANCE, e);
                throw e
            }
        }
        throw new IllegalStateException()
    }

    private def createListFromPoints(tempBasicArrayList : BasicArrayList, points : Array[Array[Int]], howMuch : Int, `type` : VectorExplosionType) : BasicArrayList = {
        var index : Int = 0
        val pointBasicArrayList : BasicArrayList = new BasicArrayListD()
        var sectionBasicArrayList : BasicArrayList = null
        // && index < tempBasicArrayList.size()

        {
            scala.util.boundary { (break_N68665 : scala.util.boundary.Label[Unit]) ?=>
                while (index < points.length) {
                    sectionBasicArrayList = new BasicArrayListD()
                    // && index < tempBasicArrayList.size()

                    {
                        scala.util.boundary { (break_N68702 : scala.util.boundary.Label[Unit]) ?=>
                            while (points(index)(0) != 1000) {
                                sectionBasicArrayList.add(tempBasicArrayList.objectArray(index))
                                index += 1
                                if (index >= points.length) {
                                    scala.util.boundary.break()(using break_N68702)
                                }
                            }
                        }
                    }
                    /*              * if(index < points.length && index < tempBasicArrayList.size()) {              * break; }              */
                    sectionBasicArrayList = RandomTranslation.getInstance(sectionBasicArrayList, howMuch)
                    if (`type` eq this.ROTATION) {
                        sectionBasicArrayList = this.randomRotationFactory.getInstanceList(sectionBasicArrayList, howMuch)
                    }
                    var size : Int = sectionBasicArrayList.size()

                    {
                        var index2 : Int = 0
                        while (index2 < size) {
                            pointBasicArrayList.add(sectionBasicArrayList.objectArray(index2))
                            index2 += 1
                        }
                    }
                    if (index >= points.length) {
                        scala.util.boundary.break()(using break_N68665)
                    } else if (points(index)(0) == 1000) {
                        pointBasicArrayList.add(tempBasicArrayList.objectArray(index))
                        index += 1
                    }
                }
            }
        }
        return pointBasicArrayList
    }

    private def createPointsBasicArrayList(points : Array[Array[Int]]) : BasicArrayList = {
        if (points.length == 0) {
            throw new Exception("Not Points Provided")
        }
        val firstPointBasicArrayList : BasicArrayList = new BasicArrayListS(points.length)
        val pointFactory : PointFactory = PointFactory.getInstance()

        {
            var index : Int = 0
            while (index < points.length) {
                firstPointBasicArrayList.add(pointFactory.createXY(points(index)(0), points(index)(1)))
                index += 1
            }
        }
        return firstPointBasicArrayList
    }

}

object VectorExplosionGenerator {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : VectorExplosionGenerator = new VectorExplosionGenerator()

    def getInstance() : VectorExplosionGenerator = {
        return VectorExplosionGenerator.instance
    }

}


