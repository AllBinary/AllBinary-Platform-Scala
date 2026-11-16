/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.rand

import _root_.java.util.Random
import _root_.jsinterop.annotations.JsType
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsConstructor
import _root_.org.allbinary.logic.math.MathUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

//Do not use in client code for money related things.
@JsType
class MyRandomFactory private() {
    import _root_.org.allbinary.game.rand.MyRandomFactory.{*}

    private val mathUtil : MathUtil = MathUtil.getInstance()

    private var rand : Random = null

    //Constructor
    {
        this.rand = new Random(System.currentTimeMillis())
    }

    @JsMethod
    def setSeed(seed : Long) : Unit = {
        this.rand = new Random(seed)
    }

    //Example: 3 would result in the possible results 0, 1, 2, -1, -2.
    @JsMethod
    def getNextInt(range : Int) : Int = {
        var div : Int = (Integer.MAX_VALUE / range) + 1
        return (this.rand.nextInt() / div).toInt
    }

    @JsMethod
    def getAbsoluteNextInt(range : Int) : Int = {
        return this.mathUtil.abs(this.getNextInt(range))
    }

    @JsMethod
    def getAbsoluteNextIntAllowZero(range : Int) : Int = {
        if (range == 0) {
            return 0
        } else {
            return this.mathUtil.abs(this.getNextInt(range))
        }
        throw new IllegalStateException()
    }

    @JsMethod
    def shuffle(intArray : Array[Int]) : Unit = {
        this.shuffleTotal(intArray, intArray.length * 7)
    }

    @JsMethod
    def shuffleTotal(intArray : Array[Int], shuffleTotal : Int) : Unit = {
        val size : Int = intArray.length
        var randomIndex : Int = 0
        var randomIndex2 : Int = 0
        var value : Int = 0

        {
            var index : Int = 0
            while (index < shuffleTotal) {
                randomIndex = this.getAbsoluteNextIntAllowZero(size)
                randomIndex2 = this.getAbsoluteNextIntAllowZero(size)
                value = intArray(randomIndex)
                intArray(randomIndex) = intArray(randomIndex2)
                intArray(randomIndex2) = value
                index += 1
            }
        }
    }

    @JsMethod
    def shuffle2(intArray : Array[Int], intArray2 : Array[Int]) : Unit = {
        this.shuffle2Total(intArray, intArray2, intArray.length * 7)
    }

    @JsMethod
    def shuffle2Total(intArray : Array[Int], intArray2 : Array[Int], shuffleTotal : Int) : Unit = {
        val size : Int = intArray.length
        var randomIndex : Int = 0
        var randomIndex2 : Int = 0
        var value : Int = 0
        var value2 : Int = 0

        {
            var index : Int = 0
            while (index < shuffleTotal) {
                randomIndex = this.getAbsoluteNextIntAllowZero(size)
                randomIndex2 = this.getAbsoluteNextIntAllowZero(size)
                value = intArray(randomIndex)
                value2 = intArray2(randomIndex)
                intArray(randomIndex) = intArray(randomIndex2)
                intArray(randomIndex2) = value
                intArray2(randomIndex) = intArray2(randomIndex2)
                intArray2(randomIndex2) = value2
                index += 1
            }
        }
    }

}

object MyRandomFactory {
    private val instance : MyRandomFactory = new MyRandomFactory()

    @JsMethod
    def getInstance() : MyRandomFactory = {
        return MyRandomFactory.instance
    }

    @JsMethod
    def main(args : Array[String]) : Unit = {
        val randomFactory : MyRandomFactory = MyRandomFactory.getInstance()
        val stringBuilder : StringMaker = new StringMaker()
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        val size2 : Int = 100

        {
            var index : Int = 0
            while (index < size2) {
                stringBuilder.appendint(randomFactory.getAbsoluteNextInt(3)).append(commonSeps.COMMA)
                index += 1
            }
        }
        System.out.println(stringBuilder.toString())
        stringBuilder.delete(0, stringBuilder.length())
        val intArray : Array[Int] = new Array[Int](52)
        val intArray2 : Array[Int] = new Array[Int](52)
        val size : Int = intArray.length

        {
            var index : Int = 0
            while (index < size) {
                intArray(index) = index
                intArray2(index) = index
                index += 1
            }
        }
        randomFactory.shuffle2(intArray, intArray2)

        {
            var index : Int = 0
            while (index < size) {
                stringBuilder.appendint(intArray(index)).append(commonSeps.COMMA)
                index += 1
            }
        }
        System.out.println(stringBuilder.toString())
        stringBuilder.delete(0, stringBuilder.length())

        {
            var index : Int = 0
            while (index < size) {
                stringBuilder.appendint(intArray2(index)).append(commonSeps.COMMA)
                index += 1
            }
        }
        System.out.println(stringBuilder.toString())
        //Validation
        var found : Boolean = false

        {
            var index : Int = 0
            while (index < size) {
                found = false

                {
                    var index2 : Int = 0
                    while (index2 < size) {
                        if (intArray(index2) == index) {
                            found = true
                        }
                        index2 += 1
                    }
                }
                if (!found) {
                    throw new RuntimeException()
                }
                index += 1
            }
        }
    }

}


