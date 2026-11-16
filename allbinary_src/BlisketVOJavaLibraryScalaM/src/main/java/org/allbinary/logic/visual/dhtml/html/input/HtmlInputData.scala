/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.html.input


class HtmlInputData {
    import _root_.org.allbinary.logic.visual.dhtml.html.input.HtmlInputData.{*}

    val TEXT : String = "text"

    val RADIO : String = "radio"

    val CHECKBOX : String = "checkbox"

    val HIDDEN : String = "hidden"

    val IMAGE : String = "image"

    val PASSWORD : String = "password"

    val RESET : String = "reset"

    val SUBMIT : String = "submit"

    val TYPES : Array[String] = Array[String](this.TEXT, this.RADIO, this.CHECKBOX, this.HIDDEN, this.IMAGE, this.PASSWORD, this.RADIO, this.RESET, this.SUBMIT)

}

object HtmlInputData {
    private val instance : HtmlInputData = new HtmlInputData()

    def getInstance() : HtmlInputData = {
        return HtmlInputData.instance
    }

}


