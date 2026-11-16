/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.math.vector

import _root_.org.allbinary.logic.math.BasicDecimal

class MathVector(param_magnitudeBasicDecimal : BasicDecimal, param_direction : Int) extends MathVectorInterface {

    private var magnitudeBasicDecimal : BasicDecimal = null

    private var direction : Int = 0

    var resultBasicDecimal : BasicDecimal = null

    //Constructor
    {
        val magnitudeBasicDecimal : BasicDecimal = param_magnitudeBasicDecimal
        val direction : Int = param_direction
        this.magnitudeBasicDecimal = magnitudeBasicDecimal
        this.direction = direction
    }

    def getMagnitude() : BasicDecimal = {
        return this.magnitudeBasicDecimal
    }

    def getDirection() : Int = {
        return this.direction
    }

    /*    public void setMagnitude(BasicDecimal magnitudeBasicDecimal)    {       this.magnitudeBasicDecimal = magnitudeBasicDecimal;    }     public void setDirection(int direction)    {       this.direction = direction;    }    */
    def getResult() : BasicDecimal = {
        return this.resultBasicDecimal
    }

}


