/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.util.BasicArrayList

class VectorAnimationUtil private() {
    import _root_.org.allbinary.animation.VectorAnimationUtil.{*}

    def toAnimationArrayFromListOfPointListWithPointsPerFrame(vector : BasicArrayList, pointsPerFrame : Int) : Array[Array[Array[Int]]] = {
        val size : Int = vector.size()
        val points : Array[Array[Array[Int]]] = Array.ofDim[Int](size, pointsPerFrame, 2)
        var nextBasicArrayList : BasicArrayList = null
        var framePoints : Array[Array[Int]] = null

        {
            var index : Int = 0
            while (index < size) {
                nextBasicArrayList = vector.objectArray(index).asInstanceOf[BasicArrayList]
                framePoints = this.toFrameArrayFromPointBasicArrayList(nextBasicArrayList)

                {
                    var pointIndex : Int = 0
                    while (pointIndex < framePoints.length) {
                        points(index)(pointIndex)(0) = framePoints(pointIndex)(0)
                        points(index)(pointIndex)(1) = framePoints(pointIndex)(1)
                        pointIndex += 1
                    }
                }
                index += 1
            }
        }
        return points
    }

    def toAnimationArrayFromListOfPointList(vector : BasicArrayList) : Array[Array[Array[Int]]] = {
        val size : Int = vector.size()
        val points : Array[Array[Array[Int]]] = Array.ofDim[Int](size, 0, 0)
        var nextBasicArrayList : BasicArrayList = null
        var framePoints : Array[Array[Int]] = null

        {
            var index : Int = 0
            while (index < size) {
                nextBasicArrayList = vector.objectArray(index).asInstanceOf[BasicArrayList]
                framePoints = this.toFrameArrayFromPointBasicArrayList(nextBasicArrayList)
                points(index) = Array.ofDim[Int](framePoints.length, 2)

                {
                    var pointIndex : Int = 0
                    while (pointIndex < framePoints.length) {
                        // points[index][pointIndex] = new int[2];
                        points(index)(pointIndex)(0) = framePoints(pointIndex)(0)
                        points(index)(pointIndex)(1) = framePoints(pointIndex)(1)
                        pointIndex += 1
                    }
                }
                index += 1
            }
        }
        return points
    }

    /*     public float[][][] toFloatFromIntAnimationArray(             int[][][] pointIntArray)     {         int size = pointIntArray.length;         float[][][] points = new float[size][0][0];          for (int index = 0; index < size; index++)         {             int[][] framePoints = pointIntArray[index];             points[index] = new float[framePoints.length][2];             for (int pointIndex = 0; pointIndex < framePoints.length; pointIndex++)             {                 // points[index][pointIndex] = new int[2];                 points[index][pointIndex][0] = framePoints[pointIndex][0];                 points[index][pointIndex][1] = framePoints[pointIndex][1];             }         }         return points;     }      public float[][][] toFloatFromIntAnimationArray(int[][] pointIntArray)     {         float[][][] points = new float[1][0][0];          points[0] = new float[pointIntArray.length][2];         for (int pointIndex = 0; pointIndex < pointIntArray.length; pointIndex++)         {             // points[index][pointIndex] = new int[2];             points[0][pointIndex][0] = pointIntArray[pointIndex][0];             points[0][pointIndex][1] = pointIntArray[pointIndex][1];         }          return points;     }     */
    def toFrameArrayFromPointBasicArrayList(list : BasicArrayList) : Array[Array[Int]] = {
        var points : Array[Array[Int]] = Array.ofDim[Int](list.size(), 2)
        var size : Int = list.size()

        {
            var index : Int = 0
            while (index < size) {
                var nextPoint : GPoint = list.objectArray(index).asInstanceOf[GPoint]
                points(index)(0) = nextPoint.getX()
                points(index)(1) = nextPoint.getY()
                index += 1
            }
        }
        return points
    }

}

object VectorAnimationUtil {
    private val instance : VectorAnimationUtil = new VectorAnimationUtil()

    def getInstance() : VectorAnimationUtil = {
        return VectorAnimationUtil.instance
    }

}


