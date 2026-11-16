/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps

class Rectangle(param_point : GPoint, param_width : Int, param_height : Int) {

    private var point : GPoint = null

    private var width : Int = 0

    private var height : Int = 0

    //Constructor
    {
        val point : GPoint = param_point
        val width : Int = param_width
        val height : Int = param_height
        //throw new Exception("Invalid Point");
        this.point = point
        this.width = width
        this.height = height
    }

    def getPoint() : GPoint = {
        return this.point
    }

    def setPoint(point : GPoint) : Unit = {
        this.point = point
    }

    def getMaxX() : Int = {
        return this.point.getX() + this.width
    }

    def getMaxY() : Int = {
        return this.point.getY() + this.height
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

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.getPoint().toString())
        stringBuffer.append(CommonSeps.getInstance().SPACE)
        stringBuffer.append(CommonLabels.getInstance().WIDTH_LABEL)
        stringBuffer.appendint(this.getWidth())
        stringBuffer.append(CommonSeps.getInstance().SPACE)
        stringBuffer.append(CommonLabels.getInstance().HEIGHT_LABEL)
        stringBuffer.appendint(this.getHeight())
        stringBuffer.append(" MaxX: ")
        stringBuffer.appendint(this.getMaxX())
        stringBuffer.append(" MaxY: ")
        stringBuffer.appendint(this.getMaxY())
        return stringBuffer.toString()
    }

}


