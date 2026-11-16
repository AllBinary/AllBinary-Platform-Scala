/*  * AllBinary Open License Version 1  * Copyright (c) 2007 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.cache


class PoolType(param_cacheType : CacheType) {

    private var cacheType : CacheType = null

    //Constructor
    {
        val cacheType : CacheType = param_cacheType
        this.cacheType = cacheType
    }

    def getCacheType() : CacheType = {
        return this.cacheType
    }

    override def toString() : String = {
        val POOL_TYPE : String = "PoolType: "
        return POOL_TYPE + this.getCacheType().toString()
    }

}


