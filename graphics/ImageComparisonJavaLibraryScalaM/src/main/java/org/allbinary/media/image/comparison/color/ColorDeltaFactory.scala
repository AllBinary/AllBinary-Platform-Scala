/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison.color

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.util.cache.AutomaticCacheInterface
import _root_.org.allbinary.logic.util.cache.CacheInterfaceFactory
import _root_.org.allbinary.logic.util.cache.CachePolicyFactory
import _root_.org.allbinary.logic.util.cache.CacheTypeFactory
import _root_.org.allbinary.string.CommonStrings

class ColorDeltaFactory private() {
    import _root_.org.allbinary.media.image.comparison.color.ColorDeltaFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

}

object ColorDeltaFactory {
    private var cacheInterface : AutomaticCacheInterface = null

    {
        val logUtil : LogUtil = LogUtil.getInstance()
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        val STATIC_BLOCK : String = "Static Block"
        val instance : String = "ColorDeltaFactory"
        try {
            logUtil.putF(commonStrings.START, instance, STATIC_BLOCK)
            ColorDeltaFactory.cacheInterface = CacheInterfaceFactory.getInstance(CacheTypeFactory.getInstance().CACHE, CachePolicyFactory.getInstance().THIRTY_MINUTES_TEN_THOUSAND_MAX).asInstanceOf[AutomaticCacheInterface]
            logUtil.putF(commonStrings.END, instance, STATIC_BLOCK)
        } catch {
            case e : Exception => {
                logUtil.put(commonStrings.EXCEPTION, instance, STATIC_BLOCK, e)
            }
        }
    }

    def getInstance(rgb1 : Int, rgb2 : Int) : ColorDelta = {
        var colorDelta : ColorDelta = ColorDeltaFactory.cacheInterface.get(ColorDelta.getKey(rgb1, rgb2)).asInstanceOf[ColorDelta]
        if (colorDelta == null) {
            colorDelta = new ColorDelta(rgb1, rgb2)
        }
        return colorDelta
    }

}


