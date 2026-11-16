/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.html.table

import _root_.org.allbinary.string.CommonStrings

class HtmlTableData {
    import _root_.org.allbinary.logic.visual.dhtml.html.table.HtmlTableData.{*}

    val LEFT : String = CommonStrings.getInstance().LEFT

    val RIGHT : String = CommonStrings.getInstance().RIGHT

    val NONE : String = "none"

    val TOP : String = "top"

    val BOTTOM : String = "bottom"

    val TOPBOT : String = "topbot"

    val SIDES : String = "sides"

    val ALL : String = "all"

    val BORDERED : String = "border"

    val BASIC : String = "basic"

    val ROWS : String = "rows"

    val FRAMES : Array[String] = Array[String](this.NONE, this.TOP, this.BOTTOM, this.TOPBOT, this.SIDES, this.ALL, this.BORDERED)

}

object HtmlTableData {
    private val instance : HtmlTableData = new HtmlTableData()

    def getInstance() : HtmlTableData = {
        return HtmlTableData.instance
    }

}


