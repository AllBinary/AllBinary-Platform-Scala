/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form.item.validation

import _root_.org.allbinary.graphics.form.item.ABTextFieldItem
import _root_.org.allbinary.logic.control.validate.ValidatorBase
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class TextFieldItemValidator(param_textFieldItem : ABTextFieldItem, param_min : Int, param_max : Int, param_allowOnEmpty : Boolean) extends ValidatorBase {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var textFieldItem : ABTextFieldItem = null

    private var min : Int = 0

    private var max : Int = 0

    private var allowOnEmpty : Boolean = false

    //Constructor
    {
        val textFieldItem : ABTextFieldItem = param_textFieldItem
        val min : Int = param_min
        val max : Int = param_max
        val allowOnEmpty : Boolean = param_allowOnEmpty
        this.textFieldItem = textFieldItem
        this.min = min
        this.max = max
        this.allowOnEmpty = allowOnEmpty
    }

    override def isValid() : _root_.java.lang.Boolean = {
        var booleanFactory : BooleanFactory = BooleanFactory.getInstance()
        var result : _root_.java.lang.Boolean = booleanFactory.TRUE
        val string : String = this.textFieldItem.getString()
        var textLength : Int = string.length()
        if (((textLength == 0) && this.allowOnEmpty) || ((textLength > this.min) && (textLength < this.max))) {
        } else {
            if (textLength < this.min) {
                result = booleanFactory.FALSE
            } else if (textLength > this.max) {
                result = booleanFactory.FALSE
            }
        }
        return result
    }

    override def toList() : BasicArrayList = {
        val list : BasicArrayList = new BasicArrayListD()
        val string : String = this.textFieldItem.getString()
        var textLength : Int = string.length()
        if ((textLength > this.min) && (textLength < this.max)) {
        } else {
            val label : String = this.textFieldItem.getLabel()
            val name : String = label.substring(0, label.length() - 2)
            if (textLength < this.min) {
                list.add(new StringMaker().append(name).append(" is to short").toString())
            } else if (textLength > this.max) {
                list.add(new StringMaker().append(name).append(" is to long").toString())
            }
        }
        return list
    }

}


