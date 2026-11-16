/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.math

import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class PrimitiveLongUtil(param_powerOfTen : Int, param_unused : Object) {
    import _root_.org.allbinary.logic.math.PrimitiveLongUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //private final CommonStrings commonStrings = CommonStrings.getInstance();
    private var powerOfTen : Int = 0

    private var maxValue : Int = 0

    private var maxDigits : Int = 0

    private var charArray : Array[Char] = null

    private var currentTotalDigits : Int = 0

    private val primitiveLongSingleton : PrimitiveLongSingleton = PrimitiveLongSingleton.getInstance()

    //Constructor
    {
        val powerOfTen : Int = param_powerOfTen
        val unused : Object = param_unused
        this.maxDigits = MathUtil.getInstance().getTotalDigits(powerOfTen)
        this.powerOfTen = powerOfTen
        this.maxValue = (powerOfTen * 10) - 1
        this.charArray = new Array[Char](this.maxDigits)
    }

    /*     private final StringMaker stringBuffer = new StringMaker();     public String getString(int value)     {         if(value == 0)         {             return NUMBER_STRING_ARRAY[0];         }                                      if(value > this.maxValue)         {             return PrimitiveLongUtil.UNK;         }                  this.stringBuffer.delete(0, this.stringBuffer.length());         int div = this.powerOfTen;         int lastValue = 0;         while(div >= 1)         {             int digit = (int) (value - lastValue) / div;             if(digit >= 0 && digit < 10)             {                 if(digit == 0 && this.stringBuffer.length() == 0)                 {                                   }                 else                 {                     this.stringBuffer.append(NUMBER_STRING_ARRAY[digit]);                 }                 lastValue += digit * div;             }             div = div / 10;         }         return stringBuffer.toString();     }     */
    def getCharArray(value : Int) : Array[Char] = {
        if (value < 10) {
            this.setCurrentTotalDigits(1)
            return this.primitiveLongSingleton.NUMBER_CHAR_ARRAYS(value)
        }
        if (value > this.maxValue) {
            this.setCurrentTotalDigits(3)
            return this.primitiveLongSingleton.UNK
        }
        var index : Int = 0
        var div : Int = this.powerOfTen
        var lastValue : Int = 0

        {
            while (div >= 1) {
                var digit : Int = (value - lastValue) / div
                if ((digit >= 0) && (digit < 10)) {
                    if ((digit == 0) && (index == 0)) {
                    } else {
                        this.charArray({ val value_N68296 = index; index += 1; value_N68296 }) = this.primitiveLongSingleton.NUMBER_CHAR_ARRAY(digit)
                    }
                    lastValue += digit * div
                }
                div = div / 10
            }
        }
        this.setCurrentTotalDigits(index)
        /*         while(index < this.maxDigits)         {             this.charArray[index] = ' ';             index++;         }         */
        return this.charArray
    }

    private def setCurrentTotalDigits(currentTotalDigits : Int) : Unit = {
        this.currentTotalDigits = currentTotalDigits
    }

    def getCurrentTotalDigits() : Int = {
        return this.currentTotalDigits
    }

    def getMaxDigits() : Int = {
        return this.maxDigits
    }

}

object PrimitiveLongUtil {
    def createPowerOfTen(powerOfTen : Int) : PrimitiveLongUtil = {
        val primitiveLongUtil : PrimitiveLongUtil = new PrimitiveLongUtil(powerOfTen, NullUtil.getInstance().NULL_OBJECT)
        if ((powerOfTen % 10) != 0) {
            val logUtil : LogUtil = LogUtil.getInstance()
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            logUtil.put(commonStrings.EXCEPTION, primitiveLongUtil, commonStrings.CONSTRUCTOR, new Exception("Max must be power of 10"))
        }
        return primitiveLongUtil
    }

}


