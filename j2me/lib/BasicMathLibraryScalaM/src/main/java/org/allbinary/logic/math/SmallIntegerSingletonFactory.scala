/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.math

import _root_.org.allbinary.AndroidUtil
import _root_.org.allbinary.J2MEUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker

class SmallIntegerSingletonFactory private() {
    import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory.{*}

    val NEGATIVE_MAX : Int = 500

    //500;
    val POSITIVE_MAX : Int = 0x2D1

    private val INTEGER_ARRAY : Array[Integer] = new Array[Integer](this.NEGATIVE_MAX + this.POSITIVE_MAX)

    private val STRING_ARRAY : Array[String] = new Array[String](this.NEGATIVE_MAX + this.POSITIVE_MAX)

    private var MIN : Int = 0

    private var lastMin : Int = 0

    private var lastNegativeMin : Int = 0

    //Constructor
    {
        this.initWithRange(23, 0)
    }

    def getMin() : Int = {
        val minAllowed : Int = this.getMinAllowed()
        //J2ME only needs 23, Androids starts with 0x101, but needs larger for Input, PC needs 0x2D0 for input
        if (this.MIN <= minAllowed) {
            if (J2MEUtil.isJ2ME()) {
            } else if (AndroidUtil.isAndroid()) {
                val logUtil : LogUtil = LogUtil.getInstance()
                logUtil.putF(new StringMaker().append("Android InputFactory was initialized before GameMidlet: ").appendint(this.MIN).toString(), this, "getMin")
                this.initWithRange(0x291, 6)
            } else {
                val logUtil : LogUtil = LogUtil.getInstance()
                logUtil.putF(new StringMaker().append("InputFactory was initialized before GameMidlet or KeyFactoryInitializer - Currently this is occurs on JS build by TouchMotionGestureFactory constructor: ").appendint(this.MIN).toString(), this, "getMin")
                this.initWithRange(0x2D0, 6)
            }
        }
        if (this.MIN <= minAllowed) {
            val logUtil : LogUtil = LogUtil.getInstance()
            logUtil.put("This means you loaded the InputFactory before determining the platform input size requirements.", this, "getMin", new Exception())
        }
        return this.MIN
    }

    private def getMinAllowed() : Int = {
        if (J2MEUtil.isJ2ME()) {
            return 0
        } else {
            if (AndroidUtil.isAndroid()) {
                return 0x101
            } else {
                return 23
            }
        }
        throw new IllegalStateException()
    }

    def initWithRange(value : Int, negativeValue : Int) : Unit = {

        {
            var index : Int = value - 1
            while (index >= this.lastMin) {
                this.INTEGER_ARRAY(index + this.NEGATIVE_MAX) = new Integer(index)
                index -= 1
            }
        }

        {
            var index : Int = negativeValue - 1
            while (index >= this.lastNegativeMin) {
                this.INTEGER_ARRAY(index) = new Integer(-index)
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
        if ((this.lastMin < this.POSITIVE_MAX) || (this.lastNegativeMin < this.NEGATIVE_MAX)) {

            {
                var index : Int = this.POSITIVE_MAX - 1
                while (index >= this.lastMin) {
                    this.INTEGER_ARRAY(index + this.NEGATIVE_MAX) = new Integer(index)
                    index -= 1
                }
            }

            {
                var index : Int = this.NEGATIVE_MAX - 1
                while (index >= this.lastNegativeMin) {
                    this.INTEGER_ARRAY(index) = new Integer(-index)
                    index -= 1
                }
            }
            this.lastMin = this.POSITIVE_MAX
            this.MIN = this.lastMin
            this.lastNegativeMin = this.NEGATIVE_MAX
        }
    }

    /*     public int highest = 0;     public void updateStats(int index)     {             if(index > this.highest)             {                 this.highest = index;             }     }     */
    def getAt(index : Int) : Integer = {
        //this.updateStats(index);
        return this.INTEGER_ARRAY(index + this.NEGATIVE_MAX)
    }

    def getAtNoThrow(index : Int) : Integer = {
        //this.updateStats(index);
        if ((index + this.NEGATIVE_MAX) > (this.INTEGER_ARRAY.length - 1)) {
            return this.INTEGER_ARRAY(-1 + this.NEGATIVE_MAX)
        }
        return this.INTEGER_ARRAY(index + this.NEGATIVE_MAX)
    }

    def createInstance(index : Int) : Integer = {
        //this.updateStats(index);
        var integer : Integer = this.getAt(index)
        if (integer == null) {
            integer = new Integer(index)
        }
        return integer
    }

    def getString(index : Int) : String = {
        val i : Int = index + this.NEGATIVE_MAX
        if (this.STRING_ARRAY(i) == null) {
            this.STRING_ARRAY(i) = this.INTEGER_ARRAY(i).toString()
        }
        return this.STRING_ARRAY(i)
    }

}

object SmallIntegerSingletonFactory {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : SmallIntegerSingletonFactory = new SmallIntegerSingletonFactory()

    def getInstance() : SmallIntegerSingletonFactory = {
        return SmallIntegerSingletonFactory.instance
    }

}


