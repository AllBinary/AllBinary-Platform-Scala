/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.html.input

import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.visual.dhtml.html.HtmlTag

class HtmlInput(param_before : String, param_type : String, param_name : String, param_after : String) extends HtmlTag {

    private val END : String = ">"

    private val STARTINPUT : String = "<INPUT "

    private val ENDINPUT : String = "</INPUT>"

    private val TYPE : String = "TYPE=\""

    private val NAME : String = "NAME=\""

    private var before : String = null

    private var `type` : String = null

    private var name : String = null

    private var after : String = null

    //Constructor
    {
        val before : String = param_before
        val `type` : String = param_type
        val name : String = param_name
        val after : String = param_after
        this.before = before
        this.`type` = `type`
        this.name = name
        this.after = after
    }

    override def toString() : String = {
        val stringUtil : StringUtil = StringUtil.getInstance()
        var result : String = stringUtil.EMPTY_STRING
        var attributeKeys : Array[Object] = this.otherAttributes.keySet().toArray()
        var attributeSize : Int = attributeKeys.length
        result = this.before
        result += this.STARTINPUT
        result += this.TYPE
        result += this.`type`
        result += "\" "
        result += this.NAME
        result += this.name
        result += "\" "

        {
            var i : Int = 0
            while (i < attributeSize) {
                var key : String = attributeKeys(i).asInstanceOf[String]
                var value : String = otherAttributes.get(key).asInstanceOf[String]
                if ((value != null) && (value.compareTo(stringUtil.EMPTY_STRING) != 0)) {
                    result += key
                    result += "=\""
                    result += value
                    result += "\" "
                }
                i += 1
            }
        }
        result += this.END
        result += this.ENDINPUT
        result += this.after
        return result
    }

}


