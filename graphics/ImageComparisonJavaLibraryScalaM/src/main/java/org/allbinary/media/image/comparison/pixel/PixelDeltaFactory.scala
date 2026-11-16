/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison.pixel

import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.util.cache.AutomaticCacheInterface
import _root_.org.allbinary.logic.util.cache.CacheInterfaceFactory
import _root_.org.allbinary.logic.util.cache.CachePolicyFactory
import _root_.org.allbinary.logic.util.cache.CacheTypeFactory
import _root_.org.allbinary.media.image.comparison.color.ColorDelta
import _root_.org.allbinary.media.image.comparison.color.ColorDeltaFactory
import _root_.org.allbinary.string.CommonStrings

class PixelDeltaFactory private() {
    import _root_.org.allbinary.media.image.comparison.pixel.PixelDeltaFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

}

object PixelDeltaFactory {
    private var cacheInterface : AutomaticCacheInterface = null

    {
        val logUtil : LogUtil = LogUtil.getInstance()
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        val STATIC_BLOCK : String = "Static Block"
        val instance : String = "PixelDeltaFactory"
        try {
            logUtil.putF(commonStrings.START, instance, STATIC_BLOCK)
            PixelDeltaFactory.cacheInterface = CacheInterfaceFactory.getInstance(CacheTypeFactory.getInstance().CACHE, CachePolicyFactory.getInstance().THIRTY_MINUTES_TEN_THOUSAND_MAX).asInstanceOf[AutomaticCacheInterface]
            logUtil.putF(commonStrings.END, instance, STATIC_BLOCK)
        } catch {
            case e : Exception => {
                logUtil.put(commonStrings.EXCEPTION, instance, STATIC_BLOCK, e)
            }
        }
    }

    def getInstance(x : Int, y : Int, rgb1 : Int, rgb2 : Int) : PixelDelta = {
        var point : GPoint = PointFactory.getInstance().createXY(x, y)
        var colorDelta : ColorDelta = ColorDeltaFactory.getInstance(rgb1, rgb2)
        var pixelDelta : PixelDelta = PixelDeltaFactory.cacheInterface.get(PixelDelta.getKey(point, colorDelta)).asInstanceOf[PixelDelta]
        if (pixelDelta == null) {
            pixelDelta = new PixelDelta(point, colorDelta)
        }
        return pixelDelta
    }

}


