/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.cache

import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.cache.CacheableInterface

class BufferedImageCacheable(param_key : BufferedImageInfo) extends CacheableInterface {

    private var key : BufferedImageInfo = null

    private var bufferedImage : BufferedImage = null

    //Constructor
    {
        val key : BufferedImageInfo = param_key
        this.key = key
        this.setBufferedImage(new BufferedImage(key.getWidth(), key.getHeight(), key.getType()))
    }

    def getKey() : Object = {
        return this.key
    }

    def getBufferedImage() : BufferedImage = {
        return this.bufferedImage
    }

    private def setBufferedImage(bufferedImage : BufferedImage) : Unit = {
        this.bufferedImage = bufferedImage
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.getClass().getName())
        stringBuffer.append(" ")
        stringBuffer.append(this.getKey().toString())
        return stringBuffer.toString()
    }

}


