/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.util.cache.CacheInterface
import _root_.org.allbinary.logic.util.cache.CacheInterfaceFactory
import _root_.org.allbinary.logic.util.cache.CachePolicyFactory
import _root_.org.allbinary.logic.util.cache.CacheTypeFactory
import _root_.org.allbinary.string.CommonStrings

class ImageComparisonResultCacheSingleton private() {
    import _root_.org.allbinary.media.image.comparison.ImageComparisonResultCacheSingleton.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

}

object ImageComparisonResultCacheSingleton {
    private var cacheInterface : CacheInterface = null

    {
        val logUtil : LogUtil = LogUtil.getInstance()
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        val STATIC_BLOCK : String = "Static Block"
        val instance : String = "ImageComparisonCacheSingleton"
        try {
            logUtil.putF(commonStrings.START, instance, STATIC_BLOCK)
            ImageComparisonResultCacheSingleton.cacheInterface = CacheInterfaceFactory.getInstance(CacheTypeFactory.getInstance().CACHE, CachePolicyFactory.getInstance().ONE_MINUTE_FIVE_MAX)
            logUtil.putF(commonStrings.END, instance, STATIC_BLOCK)
        } catch {
            case e : Exception => {
                logUtil.put(commonStrings.EXCEPTION, instance, STATIC_BLOCK, e)
            }
        }
    }

    def getInstance() : CacheInterface = {
        return ImageComparisonResultCacheSingleton.cacheInterface
    }

}


