/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.math


class BasicDecimal(param_units : Long) {
    import _root_.org.allbinary.logic.math.BasicDecimal.{ZERO_BIGDECIMAL as _, *}
    def ZERO_BIGDECIMAL : BasicDecimal = _root_.org.allbinary.logic.math.BasicDecimal.ZERO_BIGDECIMAL

    private var units : Long = 0L

    private var scaled : Int = 0

    private val factor : Int = ScaleFactorFactory.getInstance().DEFAULT_SCALE_FACTOR

    private val factorValue : Int = ScaleFactorFactory.getInstance().DEFAULT_SCALE_VALUE

    //Constructor
    {
        val units : Long = param_units
        this.units = units
        this.updateScaled()
    }

    /*    public boolean isValid()    {       if(this.units < Long.MAX_VALUE  &&          //Make sure that the scaled value is also valid          (this.units >> is it positve this.scaleFactor) < Integer.MAX_VALUE)       {          return true;       }       else       {          return false;       }    }    */
    def setint(value : Int) : Unit = {
        this.units = value.toLong
        this.updateScaled()
    }

    def setlong(value : Long) : Unit = {
        this.units = value
        this.updateScaled()
    }

    def set(bigDecimal : BasicDecimal) : Unit = {
        this.units = bigDecimal.getUnscaled()
        this.updateScaled()
    }

    def addint(value : Int) : Unit = {
        this.units = this.units + value
        this.updateScaled()
    }

    def addlong(value : Long) : Unit = {
        this.units = this.units + value
        this.updateScaled()
    }

    def add(bigDecimal : BasicDecimal) : Unit = {
        this.units = this.units + bigDecimal.getUnscaled()
        this.updateScaled()
    }

    def subtractint(value : Int) : Unit = {
        this.units = this.units - value
        this.updateScaled()
    }

    def subtractlong(value : Long) : Unit = {
        this.units = this.units - value
        this.updateScaled()
    }

    def subtract(bigDecimal : BasicDecimal) : Unit = {
        this.units = this.units - bigDecimal.getUnscaled()
        this.updateScaled()
    }

    def multiplyint(value : Int) : Unit = {
        this.units = this.units * value
        this.updateScaled()
    }

    def multiplylong(value : Long) : Unit = {
        this.units = this.units * value
        this.updateScaled()
    }

    def multiply(bigDecimal : BasicDecimal) : Unit = {
        this.units = this.units * bigDecimal.getUnscaled()
        this.updateScaled()
    }

    def divideint(value : Int) : Unit = {
        this.units = this.units / value
        this.updateScaled()
    }

    def dividelong(value : Long) : Unit = {
        this.units = this.units / value
        this.updateScaled()
    }

    def divide(bigDecimal : BasicDecimal) : Unit = {
        this.units = this.units / bigDecimal.getUnscaled()
        this.updateScaled()
    }

    /*    public void add(String decimalStr)    {    this.updateScaled();       this.units = this.units + this.convertToUnits(decimalStr);    }     public void subtract(String decimalStr)    {    this.updateScaled();       this.units = this.units - this.convertToUnits(decimalStr);    }        private long convertToUnits(String decimalStr)    {    this.updateScaled();       long localUnit=0;       int index = decimalStr.indexOf(AbPathData.EXTENSION_SEP);              String beforeDecimalStr = StringUtil.getInstance().EMPTY_STRING;       String afterDecimalStr = StringUtil.getInstance().EMPTY_STRING;       if(index < 1)       {          beforeDecimalStr = new String(decimalStr);          afterDecimalStr = "00";       }       else       {          beforeDecimalStr = new String(decimalStr.substring(0,index));          afterDecimalStr = new String(decimalStr.substring(index+1));       }        localUnit = new Long(new Long(decimalStr).longValue() * scaleFactor).longValue();       localUnit += new Long(afterDecimalStr).longValue();       return localUnit;    }    */
    def getUnscaled() : Long = {
        return this.units
    }

    private def updateScaled() : Unit = {
        //this.scaled = (int) (this.units >> this.getScaledFactor());
        this.scaled = (this.units / this.factorValue).toInt
    }

    def getScaled() : Int = {
        return this.scaled
    }

    override def toString() : String = {
        //return stringBuffer.toString();
        return _root_.java.lang.Long.toString(this.units)
    }

    def getScaledFactor() : Int = {
        return this.factor
    }

    def getScaledFactorValue() : Int = {
        return this.factorValue
    }

}

object BasicDecimal {
    val ZERO_BIGDECIMAL : BasicDecimal = new BasicDecimal(0)

    def createBigDecimal(bigDecimal : BasicDecimal) : BasicDecimal = {
        return new BasicDecimal(bigDecimal.getUnscaled())
    }

}


