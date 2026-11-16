/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image

import _root_.org.allbinary.util.BasicArrayList

class ImageTypeUtil private() {
    import _root_.org.allbinary.image.ImageTypeUtil.{*}

    val PNG : String = "png"

    val JPG : String = "jpg"

    val GIF : String = "gif"

    private val list : BasicArrayList = new BasicArrayListD()

    //Constructor
    {
        this.list.add(JPG)
        this.list.add(GIF)
        this.list.add(PNG)
    }

    //MPEG4, H.264, MP3, AAC, AMR, JPG, PNG, GIF
    def isSupported(param_mediaFileType : String) : Boolean = {
        var mediaFileType : String = param_mediaFileType
        mediaFileType = mediaFileType.toLowerCase()

        {
            var index : Int = this.list.size() - 1
            while (index >= 0) {
                var name : String = this.list.objectArray(index).asInstanceOf[String]
                if (mediaFileType.compareTo(name) == 0) {
                    return true
                }
                index -= 1
            }
        }
        return false
    }

}

object ImageTypeUtil {
    private var SINGLETON : ImageTypeUtil = new ImageTypeUtil()

    def getInstance() : ImageTypeUtil = {
        return ImageTypeUtil.SINGLETON
    }

}


