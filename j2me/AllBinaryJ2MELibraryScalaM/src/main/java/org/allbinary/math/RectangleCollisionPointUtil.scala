/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.math

import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.util.BasicArrayList

class RectangleCollisionPointUtil private() {
    import _root_.org.allbinary.math.RectangleCollisionPointUtil.{*}

}

object RectangleCollisionPointUtil {
    def allPointsInside(rectX1 : Int, rectY1 : Int, rectX2 : Int, rectY2 : Int, list : BasicArrayList) : Boolean = {
        val rectangleCollisionUtil : RectangleCollisionUtil = RectangleCollisionUtil.getInstance()
        var point : GPoint = null

        {
            var index : Int = list.size()
            while ({ index -= 1; index } >= 0) {
                point = list.objectArray(index).asInstanceOf[GPoint]
                if (!rectangleCollisionUtil.isInside(rectX1, rectY1, rectX2, rectY2, point.getX(), point.getY())) {
                    return false
                }
            }
        }
        return true
    }

    def allPointsInsideCell(rectX1 : Int, rectY1 : Int, rectX2 : Int, rectY2 : Int, list : BasicArrayList, xCellSize : Int, yCellSize : Int) : Boolean = {
        val rectangleCollisionUtil : RectangleCollisionUtil = RectangleCollisionUtil.getInstance()
        var point : GPoint = null

        {
            var index : Int = list.size()
            while ({ index -= 1; index } >= 0) {
                point = list.objectArray(index).asInstanceOf[GPoint]
                if (!rectangleCollisionUtil.isInside(rectX1, rectY1, rectX2, rectY2, point.getX() * xCellSize, point.getY() * yCellSize)) {
                    return false
                }
            }
        }
        return true
    }

}


