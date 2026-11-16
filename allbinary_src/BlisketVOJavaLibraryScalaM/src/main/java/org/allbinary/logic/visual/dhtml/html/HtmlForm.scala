/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.html

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.visual.dhtml.html.input.HtmlInput
import _root_.org.allbinary.logic.visual.dhtml.html.table.HtmlTable

class HtmlForm(param_action : String) {

    private val FORMBEGIN : String = "<form "

    private val END : String = ">"

    private val FORMEND : String = "</form>"

    private val ACTION : String = "ACTION=\""

    private val GET : String = "GET\""

    private val POST : String = "POST\""

    private val METHODS : Array[String] = Array[String](this.GET, this.POST)

    private val METHOD : String = "METHOD=\""

    //private final String ENCTYPE
    private var method : String = null

    private var action : String = null

    var inputs : BasicArrayList = null

    //Constructor
    {
        val action : String = param_action
        this.action = action
        this.inputs = new BasicArrayListD()
    }

    def setPost() : Unit = {
        this.method = this.POST
    }

    def setGet() : Unit = {
        this.method = this.GET
    }

    def addInput(htmlInput : HtmlInput) : Unit = {
        this.inputs.add(htmlInput)
    }

    def addTable(htmlTable : HtmlTable) : Unit = {
        this.inputs.add(htmlTable)
    }

    override def toString() : String = {
        val stringUtil : StringUtil = StringUtil.getInstance()
        var result : String = stringUtil.EMPTY_STRING
        var inputArray : Array[Object] = this.inputs.toArray()
        var inputSize : Int = inputArray.length
        result = this.FORMBEGIN
        result += this.METHOD
        result += this.method
        result += "\" "
        result += this.ACTION
        result += this.action
        result += "\" "
        result += this.END

        {
            var i : Int = 0
            while (i < inputSize) {
                result += inputArray(i).toString()
                result += " "
                i += 1
            }
        }
        result += this.FORMEND
        return result
    }

}


