/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.vector

import _root_.java.util.HashMap
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.j2me.workarea.tools.GraphicItemInterface
import _root_.org.allbinary.graphics.j2me.workarea.tools.LinesGraphicItem
import _root_.org.allbinary.graphics.j2me.workarea.tools.Points
import _root_.org.allbinary.graphics.pipeline.BasicGraphicsPipeline
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList

class VectorCenterGenerator() {
    import _root_.org.allbinary.animation.vector.VectorCenterGenerator.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    var minX : Int = Integer.MAX_VALUE

    var minY : Int = Integer.MAX_VALUE

    var maxX : Int = Integer.MIN_VALUE

    var maxY : Int = Integer.MIN_VALUE

    private var dx : Int = 0

    private var dy : Int = 0

    private var width : Int = 0

    private var height : Int = 0

    def calculate(hashMap : HashMap[Object, Object]) : Unit = {
        val graphicItemArray : Array[Object] = hashMap.keySet().toArray()
        val size : Int = graphicItemArray.length

        {
            var index : Int = 0
            while (index < size) {
                var item : GraphicItemInterface = hashMap.get(graphicItemArray(index)).asInstanceOf[GraphicItemInterface]
                if (item.getName() eq LinesGraphicItem.getStaticName()) {
                    this.getInstance(item.getPointsInterface().getPoints())
                }
                index += 1
            }
        }
        this.logUtil.putF((((((("minX: " + this.minX) + " minY: ") + this.minY) + " maxX: ") + this.maxX) + " maxY: ") + this.maxY, this, this.commonStrings.GET_INSTANCE)
        this.setWidth(this.maxX - this.minX)
        this.setHeight(this.maxY - this.minY)
        var max : Int = this.getWidth()
        if (getHeight() > max) {
            max = this.getHeight()
        }
        //max = max + 1;
        var middle : Int = max / 2
        val commonLabels : CommonLabels = CommonLabels.getInstance()
        val s : String = new StringMaker().append(commonLabels.WIDTH_LABEL).appendint(getWidth()).append(commonLabels.HEIGHT_LABEL).appendint(getHeight()).append(" max: ").appendint(max).append(" middle: ").appendint(middle).toString()
        this.logUtil.putF(s, this, this.commonStrings.GET_INSTANCE)
        var currentMiddleX : Int = this.minX + (this.getWidth() / 2)
        var currentMiddleY : Int = this.minY + (this.getHeight() / 2)
        this.dx = middle - currentMiddleX
        this.dy = middle - currentMiddleY
    }

    def transform(hashMap : HashMap[Object, Object]) : Unit = {
        this.calculate(hashMap)
        this.logUtil.putF(new StringMaker().append(" dx: ").appendint(this.dx).append(" dy: ").appendint(this.dy).toString(), this, this.commonStrings.GET_INSTANCE)
        val graphicItemArray : Array[Object] = hashMap.keySet().toArray()
        val size : Int = graphicItemArray.length

        {
            var index : Int = 0
            while (index < size) {
                var item : GraphicItemInterface = hashMap.get(graphicItemArray(index)).asInstanceOf[GraphicItemInterface]
                var list : BasicArrayList = VectorCenterGenerator.translate(item.getPointsInterface().getPoints(), dx, dy)
                var newPoints : Points = new Points()
                newPoints.addPoints(list)
                item.setPointsInterface(newPoints)
                index += 1
            }
        }
    }

    private def getInstance(pointVector : BasicArrayList) : Unit = {
        try {
            val size : Int = pointVector.size()

            {
                var index : Int = 0
                while (index < size) {
                    var point : GPoint = pointVector.get(index).asInstanceOf[GPoint]
                    if (point.getX() < this.minX) {
                        this.minX = point.getX()
                    }
                    if (point.getX() > this.maxX) {
                        this.maxX = point.getX()
                    }
                    if (point.getY() < this.minY) {
                        this.minY = point.getY()
                    }
                    if (point.getY() > this.maxY) {
                        this.maxY = point.getY()
                    }
                    index += 1
                }
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.GET_INSTANCE, e)
                throw e
            }
        }
    }

    def getWidth() : Int = {
        return this.width
    }

    def setWidth(width : Int) : Unit = {
        this.width = width
    }

    def getHeight() : Int = {
        return this.height
    }

    def setHeight(height : Int) : Unit = {
        this.height = height
    }

}

object VectorCenterGenerator {
    def translate(list : BasicArrayList, x : Int, y : Int) : BasicArrayList = {
        var graphicsPipe : BasicGraphicsPipeline = new BasicGraphicsPipeline(list)
        graphicsPipe.createMatrix()
        graphicsPipe.translate(x, y)
        return graphicsPipe.getMatrix()
    }

}


