/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.array

import _root_.org.allbinary.logic.string.StringMaker

class IntArrayUtil private() {
    import _root_.org.allbinary.logic.java.array.IntArrayUtil.{*}

}

object IntArrayUtil {
    def toString(array : Array[Int]) : String = {
        var stringBuffer : StringMaker = new StringMaker()

        {
            var index : Int = 0
            while (index < array.length) {
                stringBuffer.appendint(array(index))
                if (index < array.length) {
                    stringBuffer.append(", ")
                }
                index += 1
            }
        }
        return stringBuffer.toString()
    }

    def toString(array : Array[Array[Int]]) : String = {
        var stringBuffer : StringMaker = new StringMaker()

        {
            var index : Int = 0
            while (index < array.length) {
                stringBuffer.append("{")

                {
                    var index2 : Int = 0
                    while (index2 < array(index).length) {
                        stringBuffer.appendint(array(index)(index2))
                        if (index2 < (array(index).length - 1)) {
                            stringBuffer.append(", ")
                        }
                        index2 += 1
                    }
                }
                stringBuffer.append("}")
                if (index < (array.length - 1)) {
                    stringBuffer.append(", \n")
                }
                index += 1
            }
        }
        return stringBuffer.toString()
    }

    def toString(array : Array[Array[Array[Int]]]) : String = {
        var stringBuffer : StringMaker = new StringMaker()

        {
            var index : Int = 0
            while (index < array.length) {
                stringBuffer.append("{")

                {
                    var index2 : Int = 0
                    while (index2 < array(index).length) {
                        stringBuffer.append("{")

                        {
                            var index3 : Int = 0
                            while (index3 < array(index)(index2).length) {
                                stringBuffer.appendint(array(index)(index2)(index3))
                                if (index3 < (array(index)(index2).length - 1)) {
                                    stringBuffer.append(", ")
                                }
                                index3 += 1
                            }
                        }
                        stringBuffer.append("}")
                        if (index2 < (array(index).length - 1)) {
                            stringBuffer.append(", ")
                        }
                        index2 += 1
                    }
                }
                stringBuffer.append("}")
                if (index < (array.length - 1)) {
                    stringBuffer.append(", \n")
                }
                index += 1
            }
        }
        return stringBuffer.toString()
    }

}


