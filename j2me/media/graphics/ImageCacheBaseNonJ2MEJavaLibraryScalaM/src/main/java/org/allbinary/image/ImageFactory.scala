/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.image

import _root_.java.io.InputStream
import _root_.javax.microedition.lcdui.Image

//ImageCacheBaseAndroidJavaLibrary
class ImageFactory {
    import _root_.org.allbinary.image.ImageFactory.{*}

    def createImageUrl(url : String) : Image = {
        return Image.createImage(url)
    }

    def createImage(caller : String, width : Int, height : Int) : Image = {
        return Image.createImageWH(width, height)
    }

    def createImageFromInputStream(key : Object, inputStream : InputStream) : Image = {
        val image : Image = Image.createImageFromInputStream(inputStream)
        //image.init(image.getImage());
        return image
    }

    def createImageFromInputStream(inputStream : InputStream) : Image = {
        return Image.createImageFromInputStream(inputStream)
    }

}

object ImageFactory {
    private val instance : ImageFactory = new ImageFactory()

    /**      * @return the instance      */
    def getInstance() : ImageFactory = {
        return ImageFactory.instance
    }

}


