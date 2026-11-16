/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.math.permutations

import _root_.org.allbinary.logic.util.visitor.Visitor
import _root_.org.allbinary.logic.string.StringMaker

class OrderedIntArrayPermutationUtil private() {
    import _root_.org.allbinary.logic.math.permutations.OrderedIntArrayPermutationUtil.{*}

    private val TOTAL_ITERATIONS_TABLE : String = "Total Iterations: "

    private val FINISHED : String = "\nFINISHED"

    def getNext(data : Array[Int]) : Unit = {
        var length : Int = data.length
        var i : Int = length - 1

        {
            while (data(i - 1) >= data(i)) {
                i = i - 1
            }
        }
        var j : Int = length

        {
            while (data(j - 1) <= data(i - 1)) {
                j = j - 1
            }
        }
        this.swap(data, i - 1, j - 1)
        i += 1
        j = length

        {
            while (i < j) {
                this.swap(data, i - 1, j - 1)
                i += 1
                j -= 1
            }
        }
    }

    def swap(data : Array[Int], a : Int, b : Int) : Unit = {
        var temp : Int = data(a)
        data(a) = data(b)
        data(b) = temp
    }

    def factorial(dataLength : Int) : Long = {
        var temp : Long = 1
        if (dataLength > 1) {

            {
                var i : Int = 1
                while (i <= dataLength) {
                    temp *= i
                    i += 1
                }
            }
        }
        return temp
    }

    def generate(data : Array[Int], visitor : Visitor) : Unit = {
        var iterations : Long = this.factorial(data.length)
        System.out.print(this.TOTAL_ITERATIONS_TABLE)
        System.out.println(iterations)

        {
            var count : Long = 0
            while (count < (iterations - 1)) {
                this.getNext(data)
                visitor.visit(this)
                count += 1
            }
        }
        System.out.println(this.FINISHED)
    }

}

object OrderedIntArrayPermutationUtil {
    private val instance : OrderedIntArrayPermutationUtil = new OrderedIntArrayPermutationUtil()

    /**      * @return the instance      */
    def getInstance() : OrderedIntArrayPermutationUtil = {
        return OrderedIntArrayPermutationUtil.instance
    }

    def main(args : Array[String]) : Unit = {
        //max for long 20;
        val TOTAL : Int = 3
        val data : Array[Int] = new Array[Int](TOTAL)

        {
            var i : Int = 0
            while (i < TOTAL) {
                data(i) = i
                i += 1
            }
        }
        val permutationVisitor : IntPermutationVisitor = new IntPermutationVisitor(data)
        val ORIGINAL_DATA_LABEL : String = "Original Data: "
        System.out.print(ORIGINAL_DATA_LABEL)
        permutationVisitor.print(data, new StringMaker())
        OrderedIntArrayPermutationUtil.getInstance().generate(data, permutationVisitor)
    }

}


