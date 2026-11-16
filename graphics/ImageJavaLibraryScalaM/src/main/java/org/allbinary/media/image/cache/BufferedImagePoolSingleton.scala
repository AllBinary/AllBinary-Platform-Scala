/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.cache

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.util.cache.CachePolicyFactory
import _root_.org.allbinary.logic.util.cache.PoolInterface
import _root_.org.allbinary.logic.util.cache.PoolInterfaceFactory
import _root_.org.allbinary.logic.util.cache.PoolTypeFactory
import _root_.org.allbinary.string.CommonStrings

class BufferedImagePoolSingleton private() {
    import _root_.org.allbinary.media.image.cache.BufferedImagePoolSingleton.{*}

}

object BufferedImagePoolSingleton {
    private var poolInterface : PoolInterface = null

    {
        val logUtil : LogUtil = LogUtil.getInstance()
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        val STATIC_BLOCK : String = "Static Block"
        val instance : String = "BufferedImagePoolSingleton"
        try {
            logUtil.putF(commonStrings.START, instance, STATIC_BLOCK)
            BufferedImagePoolSingleton.poolInterface = PoolInterfaceFactory.getInstance(new BufferedImageCacheableFactory(), PoolTypeFactory.getInstance().VECTOR_POOL, CachePolicyFactory.getInstance().MAX_TIME_THOUSAND_MAX)
            logUtil.putF(commonStrings.END, instance, STATIC_BLOCK)
        } catch {
            case e : Exception => {
                logUtil.put(commonStrings.EXCEPTION, instance, STATIC_BLOCK, e)
            }
        }
    }

    def getInstance() : PoolInterface = {
        return BufferedImagePoolSingleton.poolInterface
    }

}


