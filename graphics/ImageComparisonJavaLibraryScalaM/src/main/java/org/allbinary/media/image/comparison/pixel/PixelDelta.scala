/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison.pixel

import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.cache.CacheableInterface
import _root_.org.allbinary.media.image.comparison.color.ColorDelta
import _root_.org.allbinary.string.CommonSeps

class PixelDelta(param_point : GPoint, param_colorDelta : ColorDelta) extends CacheableInterface {
    import _root_.org.allbinary.media.image.comparison.pixel.PixelDelta.{*}

    private var point : GPoint = null

    private var colorDelta : ColorDelta = null

    private var key : Object = null

    //Constructor
    {
        val point : GPoint = param_point
        val colorDelta : ColorDelta = param_colorDelta
        this.setPoint(point)
        this.setColorDelta(colorDelta)
        this.key = PixelDelta.getKey(this.getPoint(), this.getColorDelta())
    }

    def getKey() : Object = {
        return this.key
    }

    def getPoint() : GPoint = {
        return this.point
    }

    def setPoint(point : GPoint) : Unit = {
        this.point = point
    }

    def getColorDelta() : ColorDelta = {
        return this.colorDelta
    }

    def setColorDelta(colorDelta : ColorDelta) : Unit = {
        this.colorDelta = colorDelta
    }

    override def toString() : String = {
        return new StringMaker().append("PixelDelta: Point: ").append(this.point.toString()).append(CommonSeps.getInstance().SPACE).append(this.colorDelta.toString()).toString()
    }

}

object PixelDelta {
    def getKey(point : GPoint, colorDelta : ColorDelta) : Object = {
        return new StringMaker().appendint(TsUtil.getInstance().hashCode(point)).append(CommonSeps.getInstance().UNDERSCORE).append(colorDelta.getKey().toString()).toString()
    }

}


