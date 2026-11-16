/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.cache


class CachePolicyFactory {
    import _root_.org.allbinary.logic.util.cache.CachePolicyFactory.{*}

    val NAME : String = "lru"

    var MAX_TIME_THOUSAND_MAX : CachePolicy = new CachePolicy(this.NAME, _root_.java.lang.Long.MAX_VALUE, 1000)

    var THIRTY_MINUTES_TEN_THOUSAND_MAX : CachePolicy = new CachePolicy(this.NAME, (1000 * 60) * 30, 10000)

    var THIRTY_MINUTES_FIFTY_THOUSAND_MAX : CachePolicy = new CachePolicy(this.NAME, (1000 * 60) * 30, 100000)

    var ONE_MINUTE_FIVE_MAX : CachePolicy = new CachePolicy(this.NAME, (1000 * 60) * 1, 5)

    var ONE_MINUTE_TEN_MAX : CachePolicy = new CachePolicy(this.NAME, (1000 * 60) * 1, 10)

    var ONE_MINUTE_ONE_HUNDRED_MAX : CachePolicy = new CachePolicy(this.NAME, (1000 * 60) * 1, 100)

}

object CachePolicyFactory {
    private val instance : CachePolicyFactory = new CachePolicyFactory()

    def getInstance() : CachePolicyFactory = {
        return CachePolicyFactory.instance
    }

}


