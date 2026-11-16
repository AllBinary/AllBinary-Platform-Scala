/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.media


class MediaDataFactory {
    import _root_.org.allbinary.logic.visual.media.MediaDataFactory.{*}

    val AVI : MediaData = new MediaData("avi")

    val BMP : MediaData = new MediaData("bmp")

    val CEL : MediaData = new MediaData("cel")

    val FITS : MediaData = new MediaData("fits")

    val FLI : MediaData = new MediaData("fli")

    val GBR : MediaData = new MediaData("gbr")

    val GIF : MediaData = new MediaData("gif")

    val GIH : MediaData = new MediaData("gih")

    val JPG : MediaData = new MediaData("jpg")

    val PIX : MediaData = new MediaData("pix")

    val PNG : MediaData = new MediaData("png")

    val PNM : MediaData = new MediaData("pnm")

    val PSD : MediaData = new MediaData("psd")

    val PSP : MediaData = new MediaData("psp")

    val PS : MediaData = new MediaData("ps")

    val SGI : MediaData = new MediaData("SGI")

    val SWF : MediaData = new MediaData("swf")

    val TGA : MediaData = new MediaData("tga")

    val TIFF : MediaData = new MediaData("tiff")

    val WMF : MediaData = new MediaData("wmf")

}

object MediaDataFactory {
    private val instance : MediaDataFactory = new MediaDataFactory()

    def getInstance() : MediaDataFactory = {
        return MediaDataFactory.instance
    }

}


