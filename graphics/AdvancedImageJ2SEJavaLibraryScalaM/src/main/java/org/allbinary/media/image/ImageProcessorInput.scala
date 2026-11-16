/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.java.awt.image.BufferedImage
import _root_.java.io.File

class ImageProcessorInput(param_files : Array[File], param_bufferedImageArray : Array[BufferedImage]) {

    private var bufferedImageArray : Array[BufferedImage] = null

    private var files : Array[File] = null

    //Constructor
    {
        val files : Array[File] = param_files
        val bufferedImageArray : Array[BufferedImage] = param_bufferedImageArray
        this.bufferedImageArray = bufferedImageArray
        this.files = files
    }

    def getBufferedImageArray() : Array[BufferedImage] = {
        return this.bufferedImageArray
    }

    def getFiles() : Array[File] = {
        return this.files
    }

}


