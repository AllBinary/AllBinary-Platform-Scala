/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.html.table

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.visual.dhtml.html.HtmlTag

class HtmlRow(param_before : String, param_after : String) extends HtmlTag {

    private val END : String = ">"

    private val START : String = "<tr "

    private val ENDTAG : String = "</tr>"

    private var numberOfColumns : Int = 0

    private var before : String = null

    private var after : String = null

    private var htmlCellsVector : BasicArrayList = null

    //Constructor
    {
        val before : String = param_before
        val after : String = param_after
        this.before = new String(before)
        this.after = new String(after)
        this.htmlCellsVector = new BasicArrayListD()
    }

    def addCell(htmlCell : HtmlCell) : Unit = {
        this.htmlCellsVector.add(htmlCell)
        this.numberOfColumns += 1
    }

    def getNumberOfColumns() : Int = {
        return this.numberOfColumns
    }

    override def toString() : String = {
        val stringUtil : StringUtil = StringUtil.getInstance()
        var result : String = stringUtil.EMPTY_STRING
        var attributeKeys : Array[Object] = this.otherAttributes.keySet().toArray()
        var attributeSize : Int = attributeKeys.length
        var cellSize : Int = this.htmlCellsVector.size()
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

        {
            var i : Int = 0
            while (i < cellSize) {
                result += this.htmlCellsVector.get(i).toString()
                result += " "
                i += 1
            }
        }
        result += this.ENDTAG
        result += this.after
        return result
    }

}


