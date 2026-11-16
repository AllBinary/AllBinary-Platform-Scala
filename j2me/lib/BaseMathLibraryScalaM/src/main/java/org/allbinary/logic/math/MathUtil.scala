/* Generated Code Do Not Modify */
package org.allbinary.logic.math

import _root_.jsinterop.annotations.JsType

/**  *  * @author user  */
@JsType
class MathUtil {
    import _root_.org.allbinary.logic.math.MathUtil.{*}

    //1000
    private val ACCURACY : Int = 100

    def getTotalDigits(param_digits : Int) : Int = {
        var digits : Int = param_digits
        var total : Int = 0

        {
            while (digits > 0) {
                digits = digits / 10
                total += 1
            }
        }
        return total
    }

    def sqrt(value : Int) : Int = {
        if (value <= 1) {
            return value
        }
        var accumulated : Int = value >> 1
        var result : Int = (accumulated + (value / accumulated)) >> 1

        {
            while ({
                accumulated = result
                result = (accumulated + (value / accumulated)) >> 1
                accumulated > result
            }) ()
        }
        return accumulated
    }

    def sqrtd(x : Int) : Double = {
        if (x == 0) {
            return (0.0f).toDouble
        }
        if (x < 0) {
            return (-1.0f).toDouble
        }
        var result : Double = x.toDouble

        {
            var index : Int = 0
            while (index < this.ACCURACY) {
                result = (result + (x / result)) / 2
                index += 1
            }
        }
        return result
    }

    def abs(value : Int) : Int = {
        return (if ((value < 0)) -value else value)
    }

    def abslong(value : Long) : Long = {
        return (if ((value < 0)) -value else value)
    }

    def min(value : Int, value2 : Int) : Int = {
        return (if ((value <= value2)) value else value2)
    }

    def max(value : Int, value2 : Int) : Int = {
        return (if ((value >= value2)) value else value2)
    }

}

object MathUtil {
    private val instance : MathUtil = new MathUtil()

    def getInstance() : MathUtil = {
        return MathUtil.instance
    }

}


