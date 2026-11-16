/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.string

import _root_.org.allbinary.TsUtil

class StringValidationUtil private() {
    import _root_.org.allbinary.logic.string.StringValidationUtil.{*}

    private val stringUtil : StringUtil = StringUtil.getInstance()

    private val tsUtil : TsUtil = TsUtil.getInstance()

    def containsSpaces(value : String) : Boolean = {
        if (value.indexOf(' ') >= 0) {
            return true
        }
        return false
    }

    def isNumber(value : String) : Boolean = {
        var numberOfDecimalPoints : Int = 0

        {
            var index : Int = 0
            while (index < value.length()) {
                var digit : Char = value.charAt(index)
                if (!this.isNumberFromChar(digit) && (digit != '.')) {
                    return false
                }
                if (digit == '.') {
                    numberOfDecimalPoints += 1
                    if (numberOfDecimalPoints > 1) {
                        return false
                    }
                }
                index += 1
            }
        }
        return true
    }

    def isNumberFromChar(digit : Char) : Boolean = {
        if ((((((((((digit != '0') && (digit != '1')) && (digit != '2')) && (digit != '3')) && (digit != '4')) && (digit != '5')) && (digit != '6')) && (digit != '7')) && (digit != '8')) && (digit != '9')) {
            return false
        }
        return true
    }

    def isValidRequired(value : String, min : Int, max : Int) : Boolean = {
        //value.compareTo(stringUtil.EMPTY_STRING)==0 ||
        if ((value.length() < min) || (value.length() > max)) {
            return false
        }
        return true
    }

    def isValidRequiredNumber(value : String, min : Int, max : Int) : Boolean = {
        if ((this.isEmpty(value) || (value.length() < min)) || (value.length() > max)) {
            return false
        }
        if (!this.isNumber(value)) {
            return false
        }
        return true
    }

    def isValidNotRequired(value : String, min : Int, max : Int) : Boolean = {
        //value.compareTo(stringUtil.EMPTY_STRING)==0 ||
        if (value.length() > 0) {
            if ((value.length() < min) || (value.length() > max)) {
                return false
            }
        }
        return true
    }

    def isValidNotRequiredNumber(value : String, min : Int, max : Int) : Boolean = {
        if (value.length() > 0) {
            if (((this.tsUtil.compareTo(value, this.stringUtil.NULL_STRING) == 0) || (value.length() < min)) || (value.length() > max)) {
                return false
            }
            if (!this.isNumber(value)) {
                return false
            }
        }
        return true
    }

    def isEmpty(string : String) : Boolean = {
        if ((this.tsUtil.compareTo(string, this.stringUtil.NULL_STRING) != 0) && (this.tsUtil.compareTo(string, this.stringUtil.EMPTY_STRING) != 0)) {
            return false
        } else {
            return true
        }
        throw new IllegalStateException()
    }

}

object StringValidationUtil {
    private val instance : StringValidationUtil = new StringValidationUtil()

    def getInstance() : StringValidationUtil = {
        return StringValidationUtil.instance
    }

}


