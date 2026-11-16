/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.template.customizer.widgets.title


class TitleData private() {
    import _root_.org.allbinary.logic.visual.transform.template.customizer.widgets.title.TitleData.{*}

    val NAME : String = "TITLE_NAME"

    val TEXT : String = "TITLE_TEXT"

    val VIEWNAMEKEY : String = "Title"

    val MAXLEN : Int = 255

}

object TitleData {
    private val instance : TitleData = new TitleData()

    def getInstance() : TitleData = {
        return TitleData.instance
    }

}


