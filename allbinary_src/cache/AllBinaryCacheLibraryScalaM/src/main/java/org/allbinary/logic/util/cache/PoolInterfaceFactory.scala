/*  * AllBinary Open License Version 1  * Copyright (c) 2007 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.cache


class PoolInterfaceFactory private() {
    import _root_.org.allbinary.logic.util.cache.PoolInterfaceFactory.{*}

}

object PoolInterfaceFactory {
    def getInstance(cacheableInterfaceFactoryInterface : CacheableInterfaceFactoryInterface, poolType : PoolType, cachePolicy : CachePolicy) : PoolInterface = {
        throw new Exception("No Such PoolType: " + poolType.toString())
    }

}


