/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form.item.validation

import _root_.org.allbinary.graphics.form.item.ABTextFieldItem
import _root_.org.allbinary.logic.control.validate.ValidatorBase
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class NumberTextFieldItemValidator(param_textFieldItem : ABTextFieldItem, param_maxChars : Int, param_min : Int, param_max : Int) extends ValidatorBase {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var textFieldItem : ABTextFieldItem = null

    private var min : Int = 0

    private var max : Int = 0

    private var maxChars : Int = 0

    //Constructor
    {
        val textFieldItem : ABTextFieldItem = param_textFieldItem
        val maxChars : Int = param_maxChars
        val min : Int = param_min
        val max : Int = param_max
        this.textFieldItem = textFieldItem
        this.min = min
        this.max = max
        this.maxChars = maxChars
    }

    def isNumberValid(value : Integer) : _root_.java.lang.Boolean = {
        return BooleanFactory.getInstance().TRUE
    }

    def toNumberVector(value : Integer) : BasicArrayList = {
        return new BasicArrayListD()
    }

    override def isValid() : _root_.java.lang.Boolean = {
        var result : _root_.java.lang.Boolean = BooleanFactory.getInstance().TRUE
        val string : String = this.textFieldItem.getString()
        var textLength : Int = string.length()
        if ((textLength > 0) && (textLength < this.maxChars)) {
            // PreLogUtil.put(, this, "toVector");
            try {
                //result = this.isNumberValid(
                Integer.parseInt(this.textFieldItem.getString())
            } catch {
                case e : NumberFormatException => {
                    result = BooleanFactory.getInstance().FALSE
                }
            }
        } else {
            if (textLength < 1) {
                result = BooleanFactory.getInstance().FALSE
            } else if (textLength > this.maxChars) {
                result = BooleanFactory.getInstance().FALSE
            }
        }
        return result
    }

    override def toList() : BasicArrayList = {
        val list : BasicArrayList = new BasicArrayListD()
        val string : String = this.textFieldItem.getString()
        var textLength : Int = string.length()
        val label : String = this.textFieldItem.getLabel()
        val name : String = label.substring(0, label.length() - 2)
        val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()
        val stringMaker : StringMaker = new StringMaker()
        if ((textLength > 0) && (textLength < this.maxChars)) {
            try {
                var number : Integer = smallIntegerSingletonFactory.createInstance(Integer.parseInt(this.textFieldItem.getString()))
                //vector.addAll(this.toNumberVector(number));
                if (number.intValue() > this.min) {
                    stringMaker.delete(0, stringMaker.length())
                    list.add(stringMaker.append(name).append(" is to small").toString())
                } else if (number.intValue() > this.max) {
                    stringMaker.delete(0, stringMaker.length())
                    list.add(stringMaker.append(name).append(" is to large").toString())
                }
            } catch {
                case e : NumberFormatException => {
                    stringMaker.delete(0, stringMaker.length())
                    list.add(stringMaker.append(name).append(" is not a number").toString())
                }
            }
        } else {
            if (textLength < 1) {
                stringMaker.delete(0, stringMaker.length())
                list.add(stringMaker.append(name).append(" is to short").toString())
            } else if (textLength > this.maxChars) {
                stringMaker.delete(0, stringMaker.length())
                list.add(stringMaker.append(name).append(" is to long").toString())
            }
        }
        return list
    }

}


