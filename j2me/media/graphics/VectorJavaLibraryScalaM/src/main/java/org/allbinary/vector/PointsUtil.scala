/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.vector


class PointsUtil {
    import _root_.org.allbinary.vector.PointsUtil.{*}

    def adjustXY(points : Array[Array[Array[Int]]], x : Int, y : Int) : Array[Array[Array[Int]]] = {
        // StringMaker stringBuffer = new StringMaker();
        val size : Int = points.length
        val newPoints : Array[Array[Array[Int]]] = Array.ofDim[Int](size, 0, 0)
        // Frame

        {
            var index : Int = 0
            while (index < size) {
                val size2 : Int = points(index).length
                newPoints(index) = Array.ofDim[Int](size2, 2)
                // Point

                {
                    var index2 : Int = 0
                    while (index2 < size2) {
                        if (points(index)(index2)(0) != 1000) {
                            newPoints(index)(index2)(0) = points(index)(index2)(0) + x
                            newPoints(index)(index2)(1) = points(index)(index2)(1) + y
                        } else {
                            newPoints(index)(index2)(0) = 1000
                            newPoints(index)(index2)(1) = 1000
                        }
                        index2 += 1
                    }
                }
                index += 1
            }
        }
        // this.logUtil.putF("New Points: " + stringBuffer, this, this.commonStrings.GET_INSTANCE);
        return newPoints
    }

    def adjust(points : Array[Array[Int]], both : Int) : Array[Array[Int]] = {
        return this.adjust(points, both, both)
    }

    def adjust(points : Array[Array[Int]], x : Int, y : Int) : Array[Array[Int]] = {
        var newPoints : Array[Array[Int]] = Array.ofDim[Int](points.length, 2)

        {
            var index2 : Int = 0
            while (index2 < points.length) {
                if (points(index2)(0) != 1000) {
                    newPoints(index2)(0) = points(index2)(0) + x
                    newPoints(index2)(1) = points(index2)(1) + y
                } else {
                    newPoints(index2)(0) = 1000
                    newPoints(index2)(1) = 1000
                }
                index2 += 1
            }
        }
        return newPoints
    }

}

object PointsUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : PointsUtil = new PointsUtil()

    def getInstance() : PointsUtil = {
        return PointsUtil.instance
    }

}


