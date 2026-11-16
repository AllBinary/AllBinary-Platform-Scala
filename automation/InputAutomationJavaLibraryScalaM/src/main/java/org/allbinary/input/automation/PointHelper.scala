/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation

import _root_.java.awt.*

class PointHelper() {
    import _root_.org.allbinary.input.automation.PointHelper.{*}

}

object PointHelper {
    private val two : Double = 2

    def getCenterPoint(rectangle : Rectangle) : Point = {
        var x : Double = rectangle.getX() + (rectangle.getWidth() / PointHelper.two)
        var y : Double = rectangle.getY() + (rectangle.getHeight() / PointHelper.two)
        return PointFactory.getInstance(x.toInt, y.toInt)
    }

}


