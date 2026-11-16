/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money

import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.string.CommonPhoneStrings

class Money() {

    private var units : _root_.java.lang.Long = null

    private val DEFAULT_CURRENCY : String = "USD"

    //Constructor
    {
        this.units = new _root_.java.lang.Long(0)
    }

    //    centsStr=new String(usDollarStr.substring(index+1));
    def this(money : Money) = {
        this()
        this.units = new _root_.java.lang.Long(money.getUnits())
    }

    def this(usDollarStr : String) = {
        this()
        if ((usDollarStr != null) && StringValidationUtil.getInstance().isNumber(usDollarStr)) {
            this.units = new _root_.java.lang.Long(convertUsdToUnits(usDollarStr))
        }
    }

    def this(units : Long) = {
        this()
        this.units = new _root_.java.lang.Long(units)
    }

    def isValid() : Boolean = {
        if (((this.units != null) && (this.units.longValue() > 0)) && (this.units.longValue() < _root_.java.lang.Long.MAX_VALUE)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    /*    public Money get(String currencyType)    {    }        public void setCurrency(String currency)    {    }    */
    def add(moreMoney : Money) : Unit = {
        this.add(moreMoney.toString())
    }

    def add(usDollarStr : String) : Unit = {
        this.units = new _root_.java.lang.Long(this.units.longValue() + convertUsdToUnits(usDollarStr))
    }

    def subtract(usDollarStr : String) : Unit = {
        this.units = new _root_.java.lang.Long(this.units.longValue() - convertUsdToUnits(usDollarStr))
    }

    def multiply(multiplier : _root_.java.lang.Float) : Unit = {
        this.units = new _root_.java.lang.Long(new _root_.java.lang.Float(this.units.longValue() * multiplier.floatValue()).longValue())
    }

    def multiply(multiplier : Int) : Unit = {
        this.units = new _root_.java.lang.Long(this.units.longValue() * multiplier)
    }

    /*    public void add(String money, String currencyType)    {    }     public void subtract(String money, String currencyType)    {    }     public void multiply(String money, String currencyType)    {    }    */
    private def convertUnitsTo(currency : String) : String = {
        val stringBuffer : StringMaker = new StringMaker()
        if (currency.compareTo(this.DEFAULT_CURRENCY) == 0) {
            var dollar : Long = this.units.longValue() / 100
            var cents : Long = this.units.longValue() - (dollar * 100)
            //if(mark==true) value += "$";
            stringBuffer.append(new _root_.java.lang.Long(dollar).toString())
            stringBuffer.append(AbPathData.getInstance().EXTENSION_SEP)
            if (cents < 10) {
                stringBuffer.append(CommonPhoneStrings.getInstance().ZERO)
            }
            stringBuffer.append(new _root_.java.lang.Long(cents).toString())
        }
        return stringBuffer.toString()
    }

    private def convertUsdToUnits(usDollarStr : String) : Long = {
        var localUnit : Long = 0
        var index : Int = usDollarStr.indexOf(AbPathData.getInstance().EXTENSION_SEP)
        val stringUtil : StringUtil = StringUtil.getInstance()
        var dollarStr : String = stringUtil.EMPTY_STRING
        var centsStr : String = stringUtil.EMPTY_STRING
        if (index < 1) {
            dollarStr = new String(usDollarStr)
            centsStr = "00"
        } else {
            dollarStr = new String(usDollarStr.substring(0, index))
            centsStr = new String(usDollarStr.substring(index + 1))
        }
        localUnit = new _root_.java.lang.Long(new _root_.java.lang.Long(dollarStr).longValue() * 100).longValue()
        localUnit += new _root_.java.lang.Long(centsStr).longValue()
        return localUnit
    }

    /*    public String getUsDollar()    {                   return new String(convertUnitsToSetCurrency(false));    }    */
    def getUnits() : Long = {
        return this.units.longValue()
    }

    def getUnitsLong() : _root_.java.lang.Long = {
        return this.units
    }

    override def toString() : String = {
        return new String(convertUnitsTo(this.DEFAULT_CURRENCY))
    }

}


