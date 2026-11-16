/* Generated Code Do Not Modify */
package org.allbinary.logic.math.permutations

import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.visitor.Visitor
import _root_.org.allbinary.string.CommonSeps

class IntPermutationVisitor(param_data : Array[Int]) extends Visitor {

    var data : Array[Int] = null

    private var stringBuilder : StringMaker = new StringMaker()

    //Constructor
    {
        val data : Array[Int] = param_data
        this.data = data
    }

    override def visit(anyType : Object) : Object = {
        this.stringBuilder.delete(0, stringBuilder.length())
        this.print(this.data, stringBuilder)
        return NullUtil.getInstance().NULL_OBJECT
    }

    def print(data : Array[Int]) : Unit = {
        val stringBuilder : StringMaker = new StringMaker()
        this.print(data, stringBuilder)
    }

    def print(data : Array[Int], stringBuilder : StringMaker) : Unit = {
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        val size : Int = data.length

        {
            var i : Int = 0
            while (i < size) {
                stringBuilder.appendint(data(i))
                stringBuilder.append(commonSeps.SPACE)
                i += 1
            }
        }
        //stringBuilder.append(CommonSeps.getInstance().NEW_LINE);
        System.out.println(stringBuilder.toString())
    }

}


