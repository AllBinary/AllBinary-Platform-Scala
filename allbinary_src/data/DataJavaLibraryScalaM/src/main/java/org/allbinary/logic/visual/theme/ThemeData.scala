/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.theme


class ThemeData private() {
    import _root_.org.allbinary.logic.visual.theme.ThemeData.{*}

    val NAME : String = "THEME_NAME"

    val PATH : String = "THEME_PATH"

    val PREVIEW_IMAGE_NAME : String = "THEME_PREVIEW_IMAGE_NAME"

    val PREVIEW_IMAGE_PATH : String = "THEME_PREVIEW_IMAGE_PATH"

}

object ThemeData {
    private val instance : ThemeData = new ThemeData()

    def getInstance() : ThemeData = {
        return ThemeData.instance
    }

}


