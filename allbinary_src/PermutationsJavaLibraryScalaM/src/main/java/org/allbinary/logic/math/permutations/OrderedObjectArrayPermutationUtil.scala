/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.math.permutations

import _root_.java.util.Arrays
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.util.visitor.Visitor

class OrderedObjectArrayPermutationUtil private() {
    import _root_.org.allbinary.logic.math.permutations.OrderedObjectArrayPermutationUtil.{*}

    private val TOTAL_ITERATIONS_TABLE : String = "Total Iterations: "

    private val FINISHED : String = "\nFINISHED"

    def getNext(data : Array[Object]) : Unit = {
        var length : Int = data.length
        var i : Int = length - 1
        val tsUtil : TsUtil = TsUtil.getInstance()

        {
            while (tsUtil.hashCode(data(i - 1)) >= tsUtil.hashCode(data(i))) {
                i = i - 1
            }
        }
        var j : Int = length

        {
            while (tsUtil.hashCode(data(j - 1)) <= tsUtil.hashCode(data(i - 1))) {
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

    def swap(data : Array[Object], a : Int, b : Int) : Unit = {
        var temp : Object = data(a)
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

    def generate(data : Array[Object], visitor : Visitor) : Unit = {
        var iterations : Long = this.factorial(data.length)
        System.out.print(this.TOTAL_ITERATIONS_TABLE)
        System.out.println(iterations)

        {
            var count : Long = 0
            while (count < (iterations - 1)) {
                this.getNext(data)
                //System.out.println(count);
                visitor.visit(this)
                count += 1
            }
        }
        System.out.println(this.FINISHED)
    }

}

object OrderedObjectArrayPermutationUtil {
    private val instance : OrderedObjectArrayPermutationUtil = new OrderedObjectArrayPermutationUtil()

    /**      * @return the instance      */
    def getInstance() : OrderedObjectArrayPermutationUtil = {
        return OrderedObjectArrayPermutationUtil.instance
    }

    def main(args : Array[String]) : Unit = {
        //max for long 20;
        val TOTAL : Int = 7
        val data : Array[Object] = new Array[Object](TOTAL)

        {
            var i : Int = 0
            while (i < TOTAL) {
                data(i) = new ComparableObject()
                i += 1
            }
        }
        Arrays.sort(data)
        val permutationVisitor : ObjectPermutationVisitor = new ObjectPermutationVisitor(data)
        val ORIGINAL_DATA_LABEL : String = "Original Data: "
        System.out.print(ORIGINAL_DATA_LABEL)
        permutationVisitor.visit(data)
        OrderedObjectArrayPermutationUtil.getInstance().generate(data, permutationVisitor)
    }

}


