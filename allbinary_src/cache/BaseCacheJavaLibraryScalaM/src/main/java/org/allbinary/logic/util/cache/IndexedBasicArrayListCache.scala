/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.cache

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.string.CommonStrings
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsConstructor
import _root_.jsinterop.annotations.JsProperty

/**  *  * @author user  */
@JsType
class IndexedBasicArrayListCache() extends BaseBasicArrayListCache with CacheInterface {
    import _root_.org.allbinary.logic.util.cache.IndexedBasicArrayListCache.{*}

    @JsProperty
    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var size : Int = 0

    @JsProperty
    var index : Int = 0

    @JsMethod
    def init(size : Int) : Unit = {
        //size = 0;
        if (this.size < size) {
            this.list.ensureCapacity(size)

            {
                var index : Int = size - 1
                while (index >= this.size) {
                    this.addDefault()
                    index -= 1
                }
            }
            this.size = size
        }
    }

    @JsMethod
    def getAt(index : Int) : Object = {
        return this.list.objectArray(index)
    }

    @JsMethod
    def addDefault() : Unit = {
    }

    @JsMethod
    def addObject(anyType : Object) : Unit = {
        this.list.add(anyType)
    }

    @JsMethod
    override def add(cacheableInterface : CacheableInterface) : Unit = {
        this.list.add(cacheableInterface)
    }

    @JsMethod
    override def addArray(cacheableInterfaces : Array[CacheableInterface]) : Unit = {
        //this.list.add(this);
        throw new Exception("No Imple")
    }

    @JsMethod
    override def clear() : Unit = {
        //PreLogUtil.put("abstractPathElementList: " + BasicArrayListUtil.log(this.abstractPathElementList), this, "clear");
        this.index = 0
    }

}

object IndexedBasicArrayListCache {
    @JsMethod
    def createCache(size : Int) : IndexedBasicArrayListCache = {
        val indexedBasicArrayListCache : IndexedBasicArrayListCache = new IndexedBasicArrayListCache()
        indexedBasicArrayListCache.init(size)
        return indexedBasicArrayListCache
    }

}


