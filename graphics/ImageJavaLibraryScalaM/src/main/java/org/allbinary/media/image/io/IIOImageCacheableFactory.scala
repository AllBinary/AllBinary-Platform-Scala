/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.io

import _root_.org.allbinary.logic.util.cache.CacheableInterface
import _root_.org.allbinary.logic.util.cache.CacheableInterfaceFactoryInterface

class IIOImageCacheableFactory() extends CacheableInterfaceFactoryInterface {

    def getInstance(key : Object) : CacheableInterface = {
        return new IIOImageCacheable(key.asInstanceOf[String])
    }

}


