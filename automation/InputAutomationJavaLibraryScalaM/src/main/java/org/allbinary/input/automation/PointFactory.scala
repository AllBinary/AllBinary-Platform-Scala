/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation

import _root_.java.awt.*

class PointFactory private() {
    import _root_.org.allbinary.input.automation.PointFactory.{*}

}

object PointFactory {
    private var pointArray : Array[Array[Point]] = Array.ofDim[Point](3000, 3000)

    def getInstance(x : Int, y : Int) : Point = {
        var point : Point = PointFactory.pointArray(x)(y)
        if (point == null) {
            point = { PointFactory.pointArray(x)(y) = new Point(x, y); PointFactory.pointArray(x)(y) }
        }
        return point
    }

}


