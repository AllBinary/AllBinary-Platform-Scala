/* Generated Code Do Not Modify */
package org.allbinary.animation


class FixedPoint {
    import _root_.org.allbinary.animation.FixedPoint.{*}

    val ONE : Int = 1 << 16

    def toFixed(`val` : Double) : Int = {
        return (`val` * 65536.0).toInt
    }

    def toFixed(`val` : Float) : Int = {
        return (`val` * 65536.0f).toInt
    }

    def mul(a : Int, b : Int) : Int = {
        return ((a.toLong * b) >> 16).toInt
    }

    def div(a : Int, b : Int) : Int = {
        return (((a.toLong) << 16) / b).toInt
    }

    def toInt(fixed : Int) : Int = {
        return fixed >> 16
    }

}

object FixedPoint {
    private val instance : FixedPoint = new FixedPoint()

    /**      * @return the instance      */
    def getInstance() : FixedPoint = {
        return FixedPoint.instance
    }

}


