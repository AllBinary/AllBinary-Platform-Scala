/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.cache

import _root_.jsinterop.annotations.JsType
import _root_.jsinterop.annotations.JsMethod

/* Use this cache if you want to manually remove objects  * from the cache  */
@JsType
trait CacheInterface {

    @JsMethod
    def add(cacheableInterface : CacheableInterface) : Unit

    @JsMethod
    def addArray(cacheableInterfaces : Array[CacheableInterface]) : Unit

    @JsMethod
    def clear() : Unit

}


