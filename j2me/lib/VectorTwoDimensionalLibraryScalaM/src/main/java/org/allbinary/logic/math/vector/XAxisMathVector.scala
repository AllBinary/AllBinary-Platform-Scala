/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.math.vector

import _root_.org.allbinary.logic.math.BasicDecimal

class XAxisMathVector(param_magnitudeBasicDecimal : BasicDecimal, param_direction : Int) extends MathVector(param_magnitudeBasicDecimal, param_direction) {

    //Constructor
    {
        val magnitudeBasicDecimal : BasicDecimal = param_magnitudeBasicDecimal
        val direction : Int = param_direction
        this.calculate()
    }

    private def calculate() : Unit = {
        var result : Long = YAxisMathVectorUtil.calculate(this.getMagnitude().getUnscaled(), this.getDirection())
        this.resultBasicDecimal = new BasicDecimal(result)
    }

}


