/* Generated Code Do Not Modify */
package org.allbinary.animation


class PGUtil {
    import _root_.org.allbinary.animation.PGUtil.{*}

    // Interpolates a cubic bezier curve and adds linear points to the array
    def flattenCubicBezier(x0 : Int, y0 : Int, x1 : Int, y1 : Int, x2 : Int, y2 : Int, x3 : Int, y3 : Int, outX : Array[Int], outY : Array[Int], count : Array[Int], maxPoints : Int) : Unit = {
        val fixedPoint : FixedPoint = FixedPoint.getInstance()
        // Increase steps for smoother curves
        var steps : Int = 10

        {
            var i : Int = 1
            while (i <= steps) {
                var t : Int = fixedPoint.div(fixedPoint.toFixed(i.toDouble), fixedPoint.toFixed(steps))
                var mt : Int = fixedPoint.ONE - t
                var mt3 : Int = fixedPoint.mul(fixedPoint.mul(mt, mt), mt)
                var mt2t3 : Int = 3 * fixedPoint.mul(fixedPoint.mul(mt, mt), t)
                var mtt23 : Int = 3 * fixedPoint.mul(fixedPoint.mul(mt, t), t)
                var t3 : Int = fixedPoint.mul(fixedPoint.mul(t, t), t)
                var x : Int = ((fixedPoint.mul(mt3, x0) + fixedPoint.mul(mt2t3, x1)) + fixedPoint.mul(mtt23, x2)) + fixedPoint.mul(t3, x3)
                var y : Int = ((fixedPoint.mul(mt3, y0) + fixedPoint.mul(mt2t3, y1)) + fixedPoint.mul(mtt23, y2)) + fixedPoint.mul(t3, y3)
                if (count(0) < maxPoints) {
                    outX(count(0)) = x
                    outY(count(0)) = y
                    count(0) += 1
                }
                i += 1
            }
        }
    }

}

object PGUtil {
    private val instance : PGUtil = new PGUtil()

    /**      * @return the instance      */
    def getInstance() : PGUtil = {
        return PGUtil.instance
    }

}


