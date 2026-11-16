/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.io

import _root_.java.awt.image.BufferedImage
import _root_.javax.imageio.IIOImage
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.cache.CacheableInterface

class IIOImageCacheable(param_key : String) extends CacheableInterface {

    private var key : String = null

    private var iioImage : IIOImage = null

    //Constructor
    {
        val key : String = param_key
        this.key = key
    }

    def getKey() : Object = {
        return this.key
    }

    def setBufferedImage(bufferedImage : BufferedImage) : Unit = {
        this.setIioImage(new IIOImage(bufferedImage, null, null))
    }

    def getIioImage() : IIOImage = {
        return this.iioImage
    }

    private def setIioImage(iioImage : IIOImage) : Unit = {
        this.iioImage = iioImage
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.getClass().getName())
        stringBuffer.append(" Reusable IIOImage")
        return stringBuffer.toString()
    }

}


