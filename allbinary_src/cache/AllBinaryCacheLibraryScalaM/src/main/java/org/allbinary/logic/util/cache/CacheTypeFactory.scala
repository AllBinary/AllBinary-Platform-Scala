/* Generated Code Do Not Modify */
package org.allbinary.logic.util.cache

import _root_.org.allbinary.logic.string.StringUtil

class CacheTypeFactory {
    import _root_.org.allbinary.logic.util.cache.CacheTypeFactory.{*}

    var NO_CACHE : CacheType = new CacheType(StringUtil.getInstance().EMPTY_STRING, StringUtil.getInstance().EMPTY_STRING)

    var CACHE : CacheType = new CacheType(StringUtil.getInstance().EMPTY_STRING, StringUtil.getInstance().EMPTY_STRING)

    var SET : CacheType = new CacheType(StringUtil.getInstance().EMPTY_STRING, "Set")

    var CACHE_VECTOR : CacheType = new CacheType(StringUtil.getInstance().EMPTY_STRING, StringUtil.getInstance().EMPTY_STRING)

}

object CacheTypeFactory {
    private val instance : CacheTypeFactory = new CacheTypeFactory()

    def getInstance() : CacheTypeFactory = {
        return CacheTypeFactory.instance
    }

}


