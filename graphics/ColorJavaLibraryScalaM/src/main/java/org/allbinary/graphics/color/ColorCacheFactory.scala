/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.color

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.util.cache.AutomaticCacheInterface
import _root_.org.allbinary.logic.util.cache.AutomaticCacheInterfaceFactory
import _root_.org.allbinary.logic.util.cache.CachePolicyFactory
import _root_.org.allbinary.logic.util.cache.CacheTypeFactory
import _root_.org.allbinary.string.CommonStrings

class ColorCacheFactory private() {
    import _root_.org.allbinary.graphics.color.ColorCacheFactory.{*}

}

object ColorCacheFactory {
    private var cacheInterface : AutomaticCacheInterface = null

    {
        val logUtil : LogUtil = LogUtil.getInstance()
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        val STATIC_BLOCK : String = "Static Block"
        try {
            logUtil.putF(commonStrings.START, classOf[ColorCacheFactory], STATIC_BLOCK)
            ColorCacheFactory.cacheInterface = AutomaticCacheInterfaceFactory.getInstance(new ColorCacheableFactory(), CacheTypeFactory.getInstance().CACHE, CachePolicyFactory.getInstance().THIRTY_MINUTES_TEN_THOUSAND_MAX)
            logUtil.putF(commonStrings.END, classOf[ColorCacheFactory], STATIC_BLOCK)
        } catch {
            case e : Exception => {
                logUtil.put(commonStrings.EXCEPTION, classOf[ColorCacheFactory], STATIC_BLOCK, e)
            }
        }
    }

    def getInstance() : AutomaticCacheInterface = {
        return ColorCacheFactory.cacheInterface
    }

}


