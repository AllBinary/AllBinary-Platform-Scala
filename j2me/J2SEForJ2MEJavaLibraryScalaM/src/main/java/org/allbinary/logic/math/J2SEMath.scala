/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.math


/**  *  * @author User  */
class J2SEMath {
    import _root_.org.allbinary.logic.math.J2SEMath.{*}

    def round(value : Float) : Int = {
        return Math.round(value)
    }

    def abs(value : Float) : Float = {
        return (if ((value < 0)) -value else value)
    }

    def absdouble(value : Double) : Double = {
        return (if ((value < 0)) -value else value)
    }

}

object J2SEMath {
    private val instance : J2SEMath = new J2SEMath()

    /**      * @return the instance      */
    def getInstance() : J2SEMath = {
        return J2SEMath.instance
    }

}


