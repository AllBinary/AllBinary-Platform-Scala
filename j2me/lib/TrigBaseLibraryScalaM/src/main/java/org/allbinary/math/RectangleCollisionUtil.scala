/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.math

import _root_.jsinterop.annotations.JsType
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsConstructor

@JsType
class RectangleCollisionUtil private() {
    import _root_.org.allbinary.math.RectangleCollisionUtil.{*}

    @JsMethod
    def isCollision(rectX1 : Int, rectY1 : Int, rectX2 : Int, rectY2 : Int, rect2X1 : Int, rect2Y1 : Int, rect2X2 : Int, rect2Y2 : Int) : Boolean = {
        if ((((rect2X1 >= rectX2) || (rect2Y1 >= rectY2)) || (rect2X2 <= rectX1)) || (rect2Y2 <= rectY1)) {
            return false
        } else {
            return true
        }
        throw new IllegalStateException()
    }

    @JsMethod
    def isInside(rectX1 : Int, rectY1 : Int, rectX2 : Int, rectY2 : Int, x : Int, y : Int) : Boolean = {
        if ((((x >= rectX2) || (y >= rectY2)) || (x <= rectX1)) || (y <= rectY1)) {
            return false
        } else {
            return true
        }
        throw new IllegalStateException()
    }

}

object RectangleCollisionUtil {
    private val instance : RectangleCollisionUtil = new RectangleCollisionUtil()

    /**      * @return the instance      */
    @JsMethod
    def getInstance() : RectangleCollisionUtil = {
        return RectangleCollisionUtil.instance
    }

}


