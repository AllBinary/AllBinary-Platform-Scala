/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.bool

import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringValidationUtil

class BooleanUtil private() {
    import _root_.org.allbinary.logic.java.bool.BooleanUtil.{*}

    private val tsUtil : TsUtil = TsUtil.getInstance()

    def getFromString(booleanString : String) : Boolean = {
        val stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        val booleanFactory : BooleanFactory = BooleanFactory.getInstance()
        if (stringValidationUtil.isEmpty(booleanString)) {
            return false
        }
        val booleanStringLowerCase : String = booleanString.toLowerCase()
        //compareToIgnoreCase is probably faster
        if (this.tsUtil.compareTo(booleanStringLowerCase, booleanFactory.TRUE_STRING) == 0) {
            return true
        } else if (this.tsUtil.compareTo(booleanStringLowerCase, booleanFactory.FALSE_STRING) == 0) {
            return false
        } else {
            throw new Exception("Invalid booleanString - Must be true or false")
        }
        throw new IllegalStateException()
    }

    def isStringBoolean(booleanString : String) : Boolean = {
        val booleanFactory : BooleanFactory = BooleanFactory.getInstance()
        val booleanStringLowerCase : String = booleanString.toLowerCase()
        //compareToIgnoreCase is probably faster
        if ((booleanStringLowerCase.compareTo(booleanFactory.TRUE_STRING) == 0) || (booleanStringLowerCase.compareTo(booleanFactory.FALSE_STRING) == 0)) {
            return true
        }
        return false
    }

    def toStringFromBooleanArray(booleanArray : Array[Boolean]) : String = {
        val stringMaker : StringMaker = new StringMaker()
        val size : Int = booleanArray.length

        {
            var index : Int = 0
            while (index < size) {
                stringMaker.appendboolean(booleanArray(index))
                index += 1
            }
        }
        return stringMaker.toString()
    }

}

object BooleanUtil {
    private val instance : BooleanUtil = new BooleanUtil()

    /**      * @return the instance      */
    def getInstance() : BooleanUtil = {
        return BooleanUtil.instance
    }

}


