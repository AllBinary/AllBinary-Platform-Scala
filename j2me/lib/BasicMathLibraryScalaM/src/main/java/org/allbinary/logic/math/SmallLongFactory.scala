/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.math


class SmallLongFactory private() {
    import _root_.org.allbinary.logic.math.SmallLongFactory.{*}

    val NEGATIVE_MAX : Int = 500

    //500;
    val POSITIVE_MAX : Int = 0x2D1

    private val INTEGER_ARRAY : Array[_root_.java.lang.Long] = new Array[_root_.java.lang.Long](this.NEGATIVE_MAX + this.POSITIVE_MAX)

    private val STRING_ARRAY : Array[String] = new Array[String](this.NEGATIVE_MAX + this.POSITIVE_MAX)

    var MIN : Int = 0

    var lastMin : Int = 0

    var lastNegativeMin : Int = 0

    def initWithRange(value : Int, negativeValue : Int) : Unit = {

        {
            var index : Int = value - 1
            while (index >= this.lastMin) {
                this.INTEGER_ARRAY(index + this.NEGATIVE_MAX) = new _root_.java.lang.Long(index)
                index -= 1
            }
        }

        {
            var index : Int = negativeValue - 1
            while (index >= this.lastNegativeMin) {
                this.INTEGER_ARRAY(index) = new _root_.java.lang.Long(-index)
                index -= 1
            }
        }
        if (this.lastMin < value) {
            this.lastMin = value
            this.MIN = value
        }
        if (this.lastNegativeMin < negativeValue) {
            this.lastNegativeMin = negativeValue
        }
    }

    def init() : Unit = {
        if (this.INTEGER_ARRAY(0) == null) {
            if ((this.lastMin < this.POSITIVE_MAX) || (this.lastNegativeMin < this.NEGATIVE_MAX)) {

                {
                    var index : Int = this.POSITIVE_MAX - 1
                    while (index >= this.lastMin) {
                        this.INTEGER_ARRAY(index + this.NEGATIVE_MAX) = new _root_.java.lang.Long(index)
                        index -= 1
                    }
                }

                {
                    var index : Int = this.NEGATIVE_MAX - 1
                    while (index >= this.lastNegativeMin) {
                        this.INTEGER_ARRAY(index) = new _root_.java.lang.Long(-index)
                        index -= 1
                    }
                }
                //this.logUtil.putF("? " + NEGATIVE_INTEGER_ARRAY[5], CommonPhoneStrings.getInstance().TWO, "?????????");
                this.lastMin = this.POSITIVE_MAX
                this.lastNegativeMin = this.NEGATIVE_MAX
            }
        }
    }

    def getInstanceNoThrow(index : Long) : _root_.java.lang.Long = {
        //this.updateStats(index);
        if ((index + this.NEGATIVE_MAX) > (this.INTEGER_ARRAY.length - 1)) {
            return this.INTEGER_ARRAY(-1 + this.NEGATIVE_MAX)
        }
        return this.INTEGER_ARRAY((index.toInt) + this.NEGATIVE_MAX)
    }

    def getString(index : Int) : String = {
        val i : Int = index + this.NEGATIVE_MAX
        if (this.STRING_ARRAY(i) == null) {
            this.STRING_ARRAY(i) = this.INTEGER_ARRAY(i).toString()
        }
        return this.STRING_ARRAY(i)
    }

}

object SmallLongFactory {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : SmallLongFactory = new SmallLongFactory()

    def getInstance() : SmallLongFactory = {
        return SmallLongFactory.instance
    }

}


