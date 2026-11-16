/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.analysis

import _root_.java.awt.*
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

class ColorRange() extends ColorRangeInterface {

    private var minRed : Int = 0

    private var maxRed : Int = 0

    private var minGreen : Int = 0

    private var maxGreen : Int = 0

    private var minBlue : Int = 0

    private var maxBlue : Int = 0

    //Constructor
    {
        this.minRed = 0
        this.maxRed = 0
        this.minGreen = 0
        this.maxGreen = 0
        this.minBlue = 0
        this.maxBlue = 0
    }

    def getMinRed() : Int = {
        return this.minRed
    }

    def setMinRed(minRed : Int) : Unit = {
        this.minRed = minRed
    }

    def getMaxRed() : Int = {
        return this.maxRed
    }

    def setMaxRed(maxRed : Int) : Unit = {
        this.maxRed = maxRed
    }

    def getMinGreen() : Int = {
        return this.minGreen
    }

    def setMinGreen(minGreen : Int) : Unit = {
        this.minGreen = minGreen
    }

    def getMaxGreen() : Int = {
        return this.maxGreen
    }

    def setMaxGreen(maxGreen : Int) : Unit = {
        this.maxGreen = maxGreen
    }

    def getMinBlue() : Int = {
        return this.minBlue
    }

    def setMinBlue(minBlue : Int) : Unit = {
        this.minBlue = minBlue
    }

    def getMaxBlue() : Int = {
        return this.maxBlue
    }

    def setMaxBlue(maxBlue : Int) : Unit = {
        this.maxBlue = maxBlue
    }

    def isInRange(color : Color) : Boolean = {
        if ((((((color.getRed() >= this.getMinRed()) && (color.getRed() <= this.getMaxRed())) && (color.getGreen() >= this.getMinGreen())) && (color.getGreen() <= this.getMaxGreen())) && (color.getBlue() >= this.getMinBlue())) && (color.getBlue() <= this.getMaxBlue())) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("getMinRed(): ")
        stringBuffer.appendint(this.getMinRed())
        stringBuffer.append(CommonSeps.getInstance().NEW_LINE)
        stringBuffer.append("getMaxRed(): ")
        stringBuffer.appendint(this.getMaxRed())
        stringBuffer.append(CommonSeps.getInstance().NEW_LINE)
        stringBuffer.append("getMinGreen(): ")
        stringBuffer.appendint(this.getMinGreen())
        stringBuffer.append(CommonSeps.getInstance().NEW_LINE)
        stringBuffer.append("getMaxGreen(): ")
        stringBuffer.appendint(this.getMaxGreen())
        stringBuffer.append(CommonSeps.getInstance().NEW_LINE)
        stringBuffer.append("getMinBlue(): ")
        stringBuffer.appendint(this.getMinGreen())
        stringBuffer.append(CommonSeps.getInstance().NEW_LINE)
        stringBuffer.append("getMaxBlue(): ")
        stringBuffer.appendint(this.getMaxBlue())
        return stringBuffer.toString()
    }

}


