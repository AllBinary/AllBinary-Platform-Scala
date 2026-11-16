/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.media


class MediaTypeData private() {
    import _root_.org.allbinary.logic.visual.media.MediaTypeData.{*}

    //ImageIO supported image
    val RESIZABLE_MEDIA : String = "RESIZABLE_MEDIA"

    val NOT_RESIZABLE_MEDIA : String = "NOT_RESIZABLE_MEDIA"

}

object MediaTypeData {
    private val instance : MediaTypeData = new MediaTypeData()

    def getInstance() : MediaTypeData = {
        return MediaTypeData.instance
    }

}


