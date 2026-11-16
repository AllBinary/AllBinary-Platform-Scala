/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.collision

import _root_.java.awt.*
import _root_.org.allbinary.graphics.GPoint

class RectangleCollisionUtil private() {
    import _root_.org.allbinary.collision.RectangleCollisionUtil.{*}

}

object RectangleCollisionUtil {
    def isCollision(rectangle : Rectangle, point : GPoint) : Boolean = {
        if ((((point.getX() > (rectangle.x.toInt + rectangle.getWidth())) || (point.getY() > (rectangle.y.toInt + rectangle.getHeight()))) || (point.getX() < rectangle.x)) || (point.getY() < rectangle.y)) {
            return false
        } else {
            return true
        }
        throw new IllegalStateException()
    }

    def isCollision(rectangle1 : Rectangle, rectangle2 : Rectangle) : Boolean = {
        return RectangleCollisionUtil.isCollision(rectangle1.x, rectangle1.y, rectangle1.x + rectangle1.width, rectangle1.y + rectangle1.height, rectangle2.x, rectangle2.y, rectangle2.x + rectangle2.width, rectangle2.y + rectangle2.height)
    }

    private def isCollision(rectX1 : Int, rectY1 : Int, rectX2 : Int, rectY2 : Int, rect2X1 : Int, rect2Y1 : Int, rect2X2 : Int, rect2Y2 : Int) : Boolean = {
        if ((((rect2X1 >= rectX2) || (rect2Y1 >= rectY2)) || (rect2X2 <= rectX1)) || (rect2Y2 <= rectY1)) {
            return false
        } else {
            return true
        }
        throw new IllegalStateException()
    }

}


