/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.html.table

import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.visual.dhtml.html.HtmlTag

class HtmlCell(param_before : String, param_width : String, param_height : String, param_after : String) extends HtmlTag {

    private val END : String = ">"

    private val START : String = "<td "

    private val ENDTAG : String = "</td>"

    private val HEIGHT : String = "height"

    private val WIDTH : String = "width"

    private var height : String = null

    private var width : String = null

    private var before : String = null

    private var body : String = null

    private var after : String = null

    //Constructor
    {
        val before : String = param_before
        val width : String = param_width
        val height : String = param_height
        val after : String = param_after
        this.before = new String(before)
        this.after = new String(after)
        this.height = new String(height)
        this.width = new String(width)
        addAttribute(this.HEIGHT, this.height)
        addAttribute(this.WIDTH, this.width)
    }

    def addText(body : String) : Unit = {
        this.body = body
    }

    override def toString() : String = {
        val stringUtil : StringUtil = StringUtil.getInstance()
        var result : String = stringUtil.EMPTY_STRING
        var attributeKeys : Array[Object] = this.otherAttributes.keySet().toArray()
        var attributeSize : Int = attributeKeys.length
        result = this.before
        result += this.START
        result += " "

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
        result += this.body
        result += this.ENDTAG
        result += this.after
        return result
    }

}


