/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.math

import _root_.org.allbinary.logic.string.StringMaker

class PrimitiveLongSingleton {
    import _root_.org.allbinary.logic.math.PrimitiveLongSingleton.{*}

    val UNK : Array[Char] = Array[Char]('U', 'n', 'k')

    //public final String[] NUMBER_STRING_ARRAY = {CommonPhoneStrings.getInstance().ZERO, CommonPhoneStrings.getInstance().ONE, CommonPhoneStrings.getInstance().TWO, CommonPhoneStrings.getInstance().THREE, CommonPhoneStrings.getInstance().FOUR, CommonPhoneStrings.getInstance().FIVE, CommonPhoneStrings.getInstance().SIX, CommonPhoneStrings.getInstance().SEVEN, CommonPhoneStrings.getInstance().EIGHT, CommonPhoneStrings.getInstance().NINE};
    val NUMBER_ARRAY : Array[Byte] = Array[Byte](0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    val NUMBER_CHAR_ARRAY : Array[Char] = Array[Char]('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

    val NUMBER_CHAR_ARRAYS : Array[Array[Char]] = Array[Array[Char]](Array[Char]('0'), Array[Char]('1'), Array[Char]('2'), Array[Char]('3'), Array[Char]('4'), Array[Char]('5'), Array[Char]('6'), Array[Char]('7'), Array[Char]('8'), Array[Char]('9'))

    val ZERO : Array[Char] = Array[Char](this.NUMBER_CHAR_ARRAY(0))

    def getNumberFromChar(numberAsChar : Char) : Byte = {
        val size : Int = this.NUMBER_CHAR_ARRAY.length

        {
            var index : Int = 0
            while (index < size) {
                if (this.NUMBER_CHAR_ARRAY(index) == numberAsChar) {
                    return this.NUMBER_ARRAY(index)
                }
                index += 1
            }
        }
        throw new Exception(new StringMaker().append("numberAsChar was not in array: ").appendchar(numberAsChar).toString())
    }

}

object PrimitiveLongSingleton {
    private val instance : PrimitiveLongSingleton = new PrimitiveLongSingleton()

    def getInstance() : PrimitiveLongSingleton = {
        return PrimitiveLongSingleton.instance
    }

}


