/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.pipeline

import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.math.Angle
import _root_.org.allbinary.math.NoDecimalTrigTable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class BasicGraphicsPipeline(param_points : BasicArrayList) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    var pointBasicArrayList : BasicArrayList = null

    private val noDecimalTrigTable : NoDecimalTrigTable = NoDecimalTrigTable.getInstance()

    //Constructor
    {
        val points : BasicArrayList = param_points
        this.pointBasicArrayList = points
    }

    def setInitMatrix(points : BasicArrayList) : Unit = {
        this.pointBasicArrayList = points
    }

    def createMatrix() : Unit = {
    }

    def translate(x : Int, y : Int) : Unit = {
        var newBasicArrayList : BasicArrayList = new BasicArrayListD()
        var size : Int = this.pointBasicArrayList.size()
        var pointFactory : PointFactory = PointFactory.getInstance()
        var secondPoint : GPoint = null

        {
            var index : Int = 0
            while (index < size) {
                secondPoint = this.pointBasicArrayList.objectArray(index).asInstanceOf[GPoint]
                //Ignore end of lines
                if (secondPoint.getX() != 1000) {
                    newBasicArrayList.add(pointFactory.createXY(secondPoint.getX() + x, secondPoint.getY() + y))
                } else {
                    newBasicArrayList.add(secondPoint)
                }
                index += 1
            }
        }
        this.pointBasicArrayList = newBasicArrayList
    }

    def rotateToAngle(angle : Angle) : Unit = {
        this.rotate(angle.getValue().toInt)
    }

    private def rotate(angle : Int) : Unit = {
        var newBasicArrayList : BasicArrayList = new BasicArrayListD()
        var secondPoint : GPoint = null
        var y : Long = 0L
        var secondX : Long = 0L
        var secondY : Long = 0L
        var point : GPoint = null
        var pointFactory : PointFactory = PointFactory.getInstance()
        var size : Int = this.pointBasicArrayList.size()
        var sin : Long = 0L
        var cos : Long = 0L

        {
            var index : Int = 0
            while (index < size) {
                secondPoint = this.pointBasicArrayList.objectArray(index).asInstanceOf[GPoint]
                //Ignore end of lines
                if (secondPoint.getX() != 1000) {
                    sin = this.noDecimalTrigTable.sin(angle)
                    cos = this.noDecimalTrigTable.cos(angle)
                    y = secondPoint.getY() * sin
                    secondX = (secondPoint.getX() * cos) - y
                    secondY = (secondPoint.getX() * sin) + (secondPoint.getY() * cos)
                    //LogUtil.put("Calculated: X: " + secondX + " Y: " + secondY, this, "rotate");
                    point = pointFactory.createXY(secondX.toInt / 10000, secondY.toInt / 10000)
                    //LogUtil.put("New: " + point.toString(), this, "rotate");
                    newBasicArrayList.add(point)
                } else {
                    newBasicArrayList.add(secondPoint)
                }
                index += 1
            }
        }
        this.pointBasicArrayList = newBasicArrayList
    }

    def mirror(width : Int) : Unit = {
        val pointFactory : PointFactory = PointFactory.getInstance()
        val halfWidth : Int = (width >> 1)
        val newBasicArrayList : BasicArrayList = new BasicArrayListD()
        var secondPoint : GPoint = null
        var newX : Int = 0
        var point : GPoint = null
        val size : Int = this.pointBasicArrayList.size()

        {
            var index : Int = 0
            while (index < size) {
                secondPoint = this.pointBasicArrayList.objectArray(index).asInstanceOf[GPoint]
                //Ignore end of lines
                if (secondPoint.getX() != 1000) {
                    newX = 0
                    if (secondPoint.getX() > halfWidth) {
                        newX = halfWidth - (secondPoint.getX() - halfWidth)
                    } else {
                        newX = halfWidth + (halfWidth - secondPoint.getX())
                    }
                    point = pointFactory.createXY(newX, secondPoint.getY())
                    //LogUtil.put("New: " + point.toString(), this, "rotate");
                    newBasicArrayList.add(point)
                } else {
                    newBasicArrayList.add(secondPoint)
                }
                index += 1
            }
        }
        this.pointBasicArrayList = newBasicArrayList
    }

    def getMatrix() : BasicArrayList = {
        return this.pointBasicArrayList
    }

}


