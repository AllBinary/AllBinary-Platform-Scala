/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.cache

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels

class BufferedImageInfo(param_width : Int, param_height : Int, param_type : Int) {

    private var width : Int = 0

    private var height : Int = 0

    private var `type` : Int = 0

    //Constructor
    {
        val width : Int = param_width
        val height : Int = param_height
        val `type` : Int = param_type
        this.width = width
        this.height = height
        this.`type` = `type`
    }

    def getWidth() : Int = {
        return this.width
    }

    def setWidth(width : Int) : Unit = {
        this.width = width
    }

    def getHeight() : Int = {
        return this.height
    }

    def setHeight(height : Int) : Unit = {
        this.height = height
    }

    def getType() : Int = {
        return this.`type`
    }

    def setType(`type` : Int) : Unit = {
        this.`type` = `type`
    }

    override def toString() : String = {
        val commonLabels : CommonLabels = CommonLabels.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("BufferedImageInfo -")
        stringBuffer.append(commonLabels.WIDTH_LABEL)
        stringBuffer.appendint(this.getWidth())
        stringBuffer.append(commonLabels.HEIGHT_LABEL)
        stringBuffer.appendint(this.getHeight())
        stringBuffer.append(" Type: ")
        stringBuffer.appendint(this.getType())
        return stringBuffer.toString()
    }

}


