/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.html.select

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.io.LineReader
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.visual.dhtml.html.HtmlTag

class HtmlSelect(param_before : String, param_size : String, param_name : String, param_after : String) extends HtmlTag {

    private val END : String = ">"

    private val STARTSELECT : String = "<SELECT "

    private val ENDSELECT : String = "</SELECT>"

    private val SIZE : String = "SIZE=\""

    private val NAME : String = "NAME=\""

    private val STARTOPTION : String = "<OPTION"

    private val SELETED : String = "SELECTED"

    private val ENDOPTION : String = "</OPTION>"

    private var before : String = null

    private var name : String = null

    private var after : String = null

    private var size : String = null

    private var selected : String = null

    private var options : BasicArrayList = null

    private var multiple : String = "multiple"

    private var isMultipleSelect : Boolean = false

    //Constructor
    {
        val before : String = param_before
        val size : String = param_size
        val name : String = param_name
        val after : String = param_after
        this.before = before
        this.size = size
        this.name = name
        this.after = after
        this.options = new BasicArrayListD()
    }

    def addOption(key : String) : Unit = {
        this.options.add(key)
    }

    def addOptions(fileName : String) : Unit = {
        try {
            var lineReader : LineReader = new LineReader(fileName)

            {
                while (lineReader.hasNext()) {
                    var option : String = lineReader.next()
                    this.addOption(option)
                }
            }
        } catch {
            case e : Exception => {
                this.addOption("Error")
            }
        }
    }

    def setSelected(selected : String) : Unit = {
        this.selected = selected
    }

    def isMultiple() : Boolean = {
        return this.isMultipleSelect
    }

    def setMultiple(value : Boolean) : Unit = {
        this.isMultipleSelect = value
    }

    private def getOptions() : String = {
        val stringUtil : StringUtil = StringUtil.getInstance()
        var result : String = stringUtil.EMPTY_STRING
        var optionsArray : Array[Object] = this.options.toArray()
        var optionsSize : Int = optionsArray.length

        {
            var i : Int = 0
            while (i < optionsSize) {
                var value : String = optionsArray(i).asInstanceOf[String]
                if ((value != null) && (value.compareTo(stringUtil.EMPTY_STRING) != 0)) {
                    result += this.STARTOPTION
                    result += this.END
                    result += value
                    result += this.ENDOPTION
                }
                i += 1
            }
        }
        return result
    }

    override def toString() : String = {
        val stringUtil : StringUtil = StringUtil.getInstance()
        var result : String = stringUtil.EMPTY_STRING
        var attributeKeys : Array[Object] = this.otherAttributes.keySet().toArray()
        var attributeSize : Int = attributeKeys.length
        result = this.before
        result += this.STARTSELECT
        result += this.NAME
        result += this.name
        result += "\" "
        result += this.SIZE
        result += this.size
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
        if (this.isMultiple()) {
            result += (" " + this.multiple) + " "
        }
        result += this.END
        result += this.getOptions()
        result += this.ENDSELECT
        result += this.after
        return result
    }

}


