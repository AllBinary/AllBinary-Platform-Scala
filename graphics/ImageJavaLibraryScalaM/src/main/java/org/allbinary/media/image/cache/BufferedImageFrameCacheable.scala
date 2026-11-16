/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.cache

import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.cache.CacheableInterface

class BufferedImageFrameCacheable(param_bufferedImage : BufferedImage, param_frame : _root_.java.lang.Long) extends CacheableInterface {

    private var frame : _root_.java.lang.Long = null

    private var bufferedImage : BufferedImage = null

    //Constructor
    {
        val bufferedImage : BufferedImage = param_bufferedImage
        val frame : _root_.java.lang.Long = param_frame
        this.frame = frame
        this.setBufferedImage(bufferedImage)
    }

    def getKey() : Object = {
        return this.frame
    }

    def getBufferedImage() : BufferedImage = {
        return this.bufferedImage
    }

    private def setBufferedImage(bufferedImage : BufferedImage) : Unit = {
        this.bufferedImage = bufferedImage
    }

    def getFrame() : _root_.java.lang.Long = {
        return this.frame
    }

    def setFrame(frame : _root_.java.lang.Long) : Unit = {
        this.frame = frame
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.getClass().getName())
        stringBuffer.append(" Frame: ")
        stringBuffer.appendlong(this.getFrame())
        return stringBuffer.toString()
    }

}


