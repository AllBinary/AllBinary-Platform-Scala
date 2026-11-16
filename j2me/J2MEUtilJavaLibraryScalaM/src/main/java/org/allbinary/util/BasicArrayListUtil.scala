/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.util

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.game.rand.MyRandomFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsProperty

/**  *   * @author user  */
@JsType
class BasicArrayListUtil {
    import _root_.org.allbinary.util.BasicArrayListUtil.{*}

    @JsProperty
    val NULL_ARRAY_OF_ARRAY : Array[Array[BasicArrayList]] = Array.ofDim[BasicArrayList](0, 0)

    private val myRandomFactory : MyRandomFactory = MyRandomFactory.getInstance()

    // I should make immutable and throw on attempted edit
    private val immutableInstance : BasicArrayList = new ImmutableBasicArrayList("Immutable", 0)

    @JsMethod
    def getRandom(list : BasicArrayList) : Object = {
        //}
        var i_random : Int = this.getRandomIndex(list)
        return list.objectArray(i_random)
    }

    @JsMethod
    def getRandomIndex(list : BasicArrayList) : Int = {
        return this.myRandomFactory.getAbsoluteNextInt(list.size())
    }

    @JsMethod
    def reverse(list : BasicArrayList) : Unit = {
        val lastMinusOneIndex : Int = list.size() - 2
        var temp : Object = null
        val size : Int = lastMinusOneIndex / 2
        var secondSwapIndex : Int = 0

        {
            var index : Int = 0
            while (index <= size) {
                secondSwapIndex = lastMinusOneIndex - index
                temp = list.removeAt(index)
                list.addAt(index, list.removeAt(secondSwapIndex))
                list.addAt(secondSwapIndex + 1, temp)
                index += 1
            }
        }
    }

    @JsMethod
    def log(list : BasicArrayList) : String = {
        val S_LABEL : String = " s: "
        val size : Int = list.size()
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(CommonLabels.getInstance().TOTAL_LABEL)
        stringBuffer.appendint(size)

        {
            var index : Int = size - 1
            while (index >= 0) {
                var usedList : BasicArrayList = list.objectArray(index).asInstanceOf[BasicArrayList]
                stringBuffer.append(S_LABEL)
                stringBuffer.appendint(usedList.size())
                index -= 1
            }
        }
        return stringBuffer.toString()
    }

    /**      * @return the immutableInstance      */
    @JsMethod
    def getImmutableInstance() : BasicArrayList = {
        return this.immutableInstance
    }

}

object BasicArrayListUtil {
    private val instance : BasicArrayListUtil = new BasicArrayListUtil()

    @JsMethod
    def getInstance() : BasicArrayListUtil = {
        return BasicArrayListUtil.instance
    }

    @JsMethod
    def main(args : Array[String]) : Unit = {
        val commonPhoneStrings : CommonPhoneStrings = CommonPhoneStrings.getInstance()
        val list : BasicArrayList = new BasicArrayListD()
        list.add(commonPhoneStrings.ONE)
        list.add(commonPhoneStrings.TWO)
        list.add(commonPhoneStrings.THREE)
        list.add(commonPhoneStrings.FOUR)
        list.add(commonPhoneStrings.FIVE)
        list.add(commonPhoneStrings.SIX)
        list.add(commonPhoneStrings.SEVEN)
        list.add(commonPhoneStrings.EIGHT)
        list.add(commonPhoneStrings.NINE)
        BasicArrayListUtil.getInstance().reverse(list)
        System.out.println(list.toString())
    }

}


