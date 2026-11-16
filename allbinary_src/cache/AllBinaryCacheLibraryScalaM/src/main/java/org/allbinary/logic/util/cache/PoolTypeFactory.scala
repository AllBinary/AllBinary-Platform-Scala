/* Generated Code Do Not Modify */
package org.allbinary.logic.util.cache


class PoolTypeFactory {
    import _root_.org.allbinary.logic.util.cache.PoolTypeFactory.{*}

    var VECTOR_POOL : PoolType = new PoolType(CacheTypeFactory.getInstance().NO_CACHE)

}

object PoolTypeFactory {
    private val instance : PoolTypeFactory = new PoolTypeFactory()

    def getInstance() : PoolTypeFactory = {
        return PoolTypeFactory.instance
    }

}


