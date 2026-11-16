/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.template.customizer.widgets.logo


class LogoData private() {
    import _root_.org.allbinary.logic.visual.transform.template.customizer.widgets.logo.LogoData.{*}

    val NAME : String = "LOGO_NAME"

    val IMAGEPATH : String = "LOGO_IMAGE_PATH"

    val IMAGEFILENAME : String = "LOGO_IMAGE_FILE_NAME"

    val IMAGE : String = "LOGO_IMAGE"

}

object LogoData {
    private val instance : LogoData = new LogoData()

    def getInstance() : LogoData = {
        return LogoData.instance
    }

}


