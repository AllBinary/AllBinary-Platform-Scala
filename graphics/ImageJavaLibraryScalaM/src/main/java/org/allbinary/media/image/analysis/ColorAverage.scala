/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.analysis

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

class ColorAverage() {

    private var avgRed : Float = 0.0f

    private var avgGreen : Float = 0.0f

    private var avgBlue : Float = 0.0f

    //Constructor
    {
        this.setAvgRed(0)
        this.setAvgGreen(0)
        this.setAvgBlue(0)
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("getAvgRed(): ")
        stringBuffer.appendfloat(this.getAvgRed())
        stringBuffer.append(CommonSeps.getInstance().NEW_LINE)
        stringBuffer.append("getAvgRed(): ")
        stringBuffer.appendfloat(this.getAvgRed())
        stringBuffer.append(CommonSeps.getInstance().NEW_LINE)
        stringBuffer.append("getAvgGreen(): ")
        stringBuffer.appendfloat(this.getAvgGreen())
        stringBuffer.append(CommonSeps.getInstance().NEW_LINE)
        return stringBuffer.toString()
    }

    def getAvgRed() : Float = {
        return this.avgRed
    }

    def setAvgRed(avgRed : Float) : Unit = {
        this.avgRed = avgRed
    }

    def getAvgGreen() : Float = {
        return this.avgGreen
    }

    def setAvgGreen(avgGreen : Float) : Unit = {
        this.avgGreen = avgGreen
    }

    def getAvgBlue() : Float = {
        return this.avgBlue
    }

    def setAvgBlue(avgBlue : Float) : Unit = {
        this.avgBlue = avgBlue
    }

}


