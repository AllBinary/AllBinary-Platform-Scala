/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.cache.CacheableInterface

class ImageComparisonResultFrameCacheable(param_imageComparisonResult : ImageComparisonResult, param_frame : _root_.java.lang.Long) extends CacheableInterface {

    private var frame : _root_.java.lang.Long = null

    private var imageComparisonResult : ImageComparisonResult = null

    //Constructor
    {
        val imageComparisonResult : ImageComparisonResult = param_imageComparisonResult
        val frame : _root_.java.lang.Long = param_frame
        this.setImageComparisonResult(imageComparisonResult)
        this.frame = frame
    }

    def getKey() : Object = {
        return this.frame
    }

    def getFrame() : _root_.java.lang.Long = {
        return this.frame
    }

    def setFrame(frame : _root_.java.lang.Long) : Unit = {
        this.frame = frame
    }

    def getImageComparisonResult() : ImageComparisonResult = {
        return this.imageComparisonResult
    }

    def setImageComparisonResult(imageComparisonResult : ImageComparisonResult) : Unit = {
        this.imageComparisonResult = imageComparisonResult
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.getClass().getName())
        stringBuffer.append(" Frame: ")
        stringBuffer.appendlong(this.getFrame())
        return stringBuffer.toString()
    }

}


