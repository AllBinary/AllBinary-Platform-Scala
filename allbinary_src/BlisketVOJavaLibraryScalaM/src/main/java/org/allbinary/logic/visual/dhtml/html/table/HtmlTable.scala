/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.html.table

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.visual.dhtml.html.HtmlTag
import _root_.org.allbinary.string.CommonPhoneStrings

class HtmlTable(param_before : String, param_cellpadding : String, param_cellspacing : String, param_after : String) extends HtmlTag {

    private val END : String = ">"

    private val START : String = "<table "

    private val ENDTAG : String = "</table>"

    private val CLASS : String = "class"

    private val DIRECTION : String = "dir"

    private val ID : String = "id"

    private val LANG : String = "lang"

    private val UNITS : String = "units"

    private val BORDER : String = "border"

    private val CELLPADDING : String = "cellpadding"

    private val CELLSPACING : String = "cellspacing"

    private val COLS : String = "cols"

    private val FLOAT : String = "float"

    private val FRAME : String = "frame"

    private val RULES : String = "rules"

    private val STYLE : String = "style"

    val BORDERCOLLAPSE : String = "border-collapse: collapse"

    private var numberOfColumns : Int = 0

    private var before : String = null

    private var border : String = null

    private var cellpadding : String = null

    private var cellspacing : String = null

    private var style : String = null

    private var name : String = null

    private var after : String = null

    private var htmlRowsVector : BasicArrayList = null

    //Constructor
    {
        val before : String = param_before
        val cellpadding : String = param_cellpadding
        val cellspacing : String = param_cellspacing
        val after : String = param_after
        this.before = before
        //this.border = new String(border);
        this.cellpadding = cellpadding
        this.cellspacing = cellspacing
        //this.style = new String(style);  
        this.after = after
        this.htmlRowsVector = new BasicArrayListD()
        addAttribute(this.BORDER, CommonPhoneStrings.getInstance().ZERO)
        addAttribute(this.CELLPADDING, this.cellpadding)
        addAttribute(this.CELLSPACING, this.cellspacing)
        addAttribute(this.STYLE, this.BORDERCOLLAPSE)
    }

    def addRow(htmlRow : HtmlRow) : Unit = {
        if (this.numberOfColumns < htmlRow.getNumberOfColumns()) {
            this.numberOfColumns = htmlRow.getNumberOfColumns()
        }
        this.htmlRowsVector.add(htmlRow)
    }

    override def toString() : String = {
        val stringUtil : StringUtil = StringUtil.getInstance()
        var result : String = stringUtil.EMPTY_STRING
        var attributeKeys : Array[Object] = this.otherAttributes.keySet().toArray()
        result = this.before
        result += this.START
        result += " "

        {
            var i : Int = 0
            while (i < attributeKeys.length) {
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
        val size : Int = this.htmlRowsVector.size()

        {
            var i : Int = 0
            while (i < size) {
                result += this.htmlRowsVector.get(i).toString()
                result += " "
                i += 1
            }
        }
        result += this.ENDTAG
        result += this.after
        return result
    }

}


